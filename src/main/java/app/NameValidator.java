package app;

import static app.ConstantsUtils.NAME_CHECK;

/**
 * The type Name validator.
 */
public class NameValidator extends ValidatorAbstract {

  /**
   * Instantiates a new Name validator.
   *
   * @param registration the registration
   */
  public NameValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    String nameProvided = this.getRegistration().getName().accept(infoExtractor);
    String nameOnLicense = this.getRegistration().getLicense().accept(infoExtractor, NAME_CHECK);
    if (!nameProvided.equals(nameOnLicense)) {
      throw new ValidationException("Name does not match registration");
    }
    return true;
  }
}
