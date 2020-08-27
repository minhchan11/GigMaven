package app;

/**
 * The type Validator decorator.
 */
public class ValidatorDecorator implements IValidatable {

  /**
   * The Validator.
   */
  protected IValidatable validator;

  /**
   * Instantiates a new Validator decorator.
   *
   * @param validator the validator
   */
  public ValidatorDecorator(IValidatable validator) {
    this.validator = validator;
  }

  @Override
  public DriverRegistration getRegistration() {
    return this.validator.getRegistration();
  }

  @Override
  public Boolean validate() throws ValidationException {
    return this.validator.validate();
  }
}
