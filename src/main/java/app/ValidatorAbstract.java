package app;

/**
 * The type Validator abstract.
 */
public abstract class ValidatorAbstract implements IValidatable {

  /**
   * The Registration.
   */
  protected DriverRegistration registration;

  /**
   * Instantiates a new Validator abstract.
   *
   * @param registration the registration
   */
  public ValidatorAbstract(DriverRegistration registration) {
    this.registration = registration;
  }

  public DriverRegistration getRegistration() {
    return this.registration;
  }

  @Override
  public abstract Boolean validate() throws ValidationException;
}
