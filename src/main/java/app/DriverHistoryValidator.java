package app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Driver history validator.
 */
public class DriverHistoryValidator extends ValidatorAbstract {

  /**
   * Instantiates a new Driver history validator.
   *
   * @param registration the registration
   */
  public DriverHistoryValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    List<TrafficViolation> trafficRecord = this.getRegistration().getDriverHistory()
        .accept(infoExtractor);
    List<Violation> violations = trafficRecord.stream().map(TrafficViolation::getViolation)
        .collect(Collectors.toList());
    return Arrays.stream(MovingViolation.values()).noneMatch(violations::contains);
  }
}
