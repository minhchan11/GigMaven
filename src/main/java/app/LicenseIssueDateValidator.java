package app;

import static java.time.temporal.ChronoUnit.DAYS;
import static app.ConstantsUtils.ISSUE_DATE_CHECK;
import static app.ConstantsUtils.TODAY;

import java.time.LocalDate;

/**
 * The type License issue date validator.
 */
public class LicenseIssueDateValidator extends ValidatorAbstract {

  private final LocalDate today = LocalDate.now();
  private int sixMonth = 180;

  /**
   * Instantiates a new License issue date validator.
   *
   * @param registration the registration
   */
  public LicenseIssueDateValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailGetter infoExtractor = new DetailGetter();
    String issueDate = this.registration.getLicense().accept(infoExtractor, ISSUE_DATE_CHECK);
    Long issueToNow = DAYS.between(infoExtractor.convertToLocalDate().apply(issueDate), TODAY);
    if (issueToNow < sixMonth) {
      throw new ValidationException("License is issued less than six months ago");
    }
    return true;
  }
}
