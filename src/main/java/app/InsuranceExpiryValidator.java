package app;

import static java.time.temporal.ChronoUnit.DAYS;
import static app.ConstantsUtils.TODAY;

import java.time.LocalDate;

/**
 * The type Insurance expiry validator.
 */
public class InsuranceExpiryValidator extends ValidatorAbstract {

  /**
   * The constant INT_EXPIRED.
   */
  protected static final int INT_EXPIRED = 0;

  /**
   * Instantiates a new Insurance expiry validator.
   *
   * @param registration the registration
   */
  public InsuranceExpiryValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    LocalDate expiryDate = this.getRegistration().getVehicleInsurance().accept(infoExtractor);
    Long expired = DAYS.between(expiryDate, TODAY);
    if (expired > INT_EXPIRED) {
      throw new ValidationException("Insurance has expired");
    }
    return true;
  }
}
