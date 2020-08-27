package app;

/**
 * The interface Validatable.
 */
public interface IValidatable {

  /**
   * Gets registration.
   *
   * @return the registration
   */
  DriverRegistration getRegistration();

  /**
   * Validate boolean.
   *
   * @return the boolean
   * @throws ValidationException the validation exception
   */
  Boolean validate() throws ValidationException;
}
