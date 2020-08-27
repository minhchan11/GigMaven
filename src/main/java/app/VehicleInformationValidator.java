package app;


import java.time.LocalDate;

/**
 * The type Vehicle information validator.
 */
public class VehicleInformationValidator extends ValidatorAbstract {

  /**
   * The constant YEAR_THRESHOLD.
   */
  protected static final int YEAR_THRESHOLD = 15;

  /**
   * Instantiates a new Vehicle information validator.
   *
   * @param registration the registration
   */
  public VehicleInformationValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    Integer yearMade = this.registration.getVehicleInformation().accept(infoExtractor);
    Integer yearUsed = LocalDate.now().getYear() - yearMade;
    if (yearUsed > YEAR_THRESHOLD) {
      throw new ValidationException("Vehicle is older than 15 years");
    }
    return true;
  }
}
