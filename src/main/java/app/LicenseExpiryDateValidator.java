package app;

import static java.time.temporal.ChronoUnit.DAYS;
import static app.ConstantsUtils.EXPIRY_DATE_CHECK;
import static app.ConstantsUtils.TODAY;

/**
 * The type License expiry date validator.
 */
public class LicenseExpiryDateValidator extends ValidatorAbstract {

  /**
   * The constant INT_EXPIRED.
   */
  protected static final int INT_EXPIRED = 0;


  /**
   * Instantiates a new License expiry date validator.
   *
   * @param registration the registration
   */
  public LicenseExpiryDateValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailGetter infoExtractor = new DetailGetter();
    String expiryDate = this.registration.getLicense().accept(infoExtractor, EXPIRY_DATE_CHECK);
    Long expired = DAYS.between(infoExtractor.convertToLocalDate().apply(expiryDate), TODAY);
    if (expired > INT_EXPIRED) {
      throw new ValidationException("License has expired");
    }
    return true;
  }
}
