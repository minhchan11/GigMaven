package app;

import static app.ConstantsUtils.DATE_TIME_FORMAT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DriverCOVIDTestingValidator extends ValidatorAbstract {

  protected static final int WINDOW_PERIOD = 30;

  /**
   * Instantiates a new Validator abstract.
   *
   * @param registration the registration
   */
  public DriverCOVIDTestingValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    LocalDate dateTested= this.getRegistration().getDriverCOVIDTesting().accept(infoExtractor);
    Long days = ChronoUnit.DAYS.between(dateTested, LocalDate.now());
    if (days > WINDOW_PERIOD){
      throw new ValidationException("Driver must be tested within 30 days");
    }
    return true;
  }
}
