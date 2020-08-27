package app;

import static app.ConstantsUtils.BIRTHDAY_CHECK;

/**
 * The type Birthday validator.
 */
public class BirthdayValidator extends ValidatorAbstract {

  /**
   * Instantiates a new Birthday validator.
   *
   * @param registration the registration
   */
  public BirthdayValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    String birthdayProvided = this.getRegistration().getBirthday().accept(infoExtractor);
    String birthdayOnLicense = this.getRegistration().getLicense()
        .accept(infoExtractor, BIRTHDAY_CHECK);
    if (!birthdayProvided.equals(birthdayOnLicense)) {
      throw new ValidationException("Birthday does not match registration");
    }
    return true;
  }
}
