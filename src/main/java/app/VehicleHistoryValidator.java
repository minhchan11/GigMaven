package app;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type Vehicle history validator.
 */
public class VehicleHistoryValidator extends ValidatorAbstract {

  /**
   * The constant SIX_MONTHS.
   */
  protected static final int SIX_MONTHS = 180;

  /**
   * Instantiates a new Vehicle history validator.
   *
   * @param registration the registration
   */
  public VehicleHistoryValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    HashMap<DriverName, List<IncidentAbstract>> vehicleRecord = this.getRegistration()
        .getVehicleHistory().accept(infoExtractor);
    List<Violation> violations = vehicleRecord.values()
        .stream().flatMap(Collection::stream)
        .filter(this.filterLastSixMonths())
        .map(IncidentAbstract::getViolation)
        .collect(Collectors.toList());
    if (containsCrashOrMovingViolation(violations)){
      throw new ValidationException("Vehicle history contains crash or moving violation");
    }
    return true;
  }

  private Predicate<IncidentAbstract> filterLastSixMonths(){
    return record -> DAYS.between(record.getDateCommitted(),LocalDate.now()) <= SIX_MONTHS;
  }

  /**
   * Helper method to see if contain crash or violation
   * @param violations
   * @return
   */
  private Boolean containsCrashOrMovingViolation(List<Violation> violations){
    if (Arrays.stream(MovingViolation.values()).anyMatch(violations::contains)){
      return true;
    }
    if (Arrays.stream(CrashType.values()).anyMatch(violations::contains)){
      return true;
    }
    return false;
  }
}
