package app;

import static app.ConstantsUtils.DATE_TIME_FORMAT;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * The type Age validator.
 */
public class AgeValidator extends ValidatorAbstract {

  /**
   * The constant ALLOWED_AGE.
   */
  protected static final int ALLOWED_AGE = 21;

  /**
   * Instantiates a new Age validator.
   *
   * @param registration the registration
   */
  public AgeValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    String birthdayProvided = this.getRegistration().getBirthday().accept(infoExtractor);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    LocalDate birthDay = LocalDate.parse(birthdayProvided, formatter);
    Long age = ChronoUnit.YEARS.between(birthDay, LocalDate.now());
    if (age < ALLOWED_AGE){
      throw new ValidationException("Driver must be at least 21 years old");
    }
    return true;
  }
}
