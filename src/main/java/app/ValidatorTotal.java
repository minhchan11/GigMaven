package app;

import static app.ConstantsUtils.AGE_CHECK;
import static app.ConstantsUtils.BIRTHDAY_CHECK;
import static app.ConstantsUtils.COUNTRY_CHECK;
import static app.ConstantsUtils.DRIVER_HISTORY_CHECK;
import static app.ConstantsUtils.EXPIRY_DATE_CHECK;
import static app.ConstantsUtils.ISSUE_DATE_CHECK;
import static app.ConstantsUtils.NAME_CHECK;
import static app.ConstantsUtils.VEHICLE_HISTORY_CHECK;
import static app.ConstantsUtils.VEHICLE_INFO_CHECK;
import static app.ConstantsUtils.VEHICLE_INSURANCE_CHECK;

/**
 * The type Validator total.
 */
public class ValidatorTotal implements IValidatable {

  private final DriverRegistration registration;

  /**
   * Instantiates a new Validator total.
   *
   * @param registration the registration
   */
  public ValidatorTotal(DriverRegistration registration) {
    this.registration = registration;
  }

  /**
   * Validator factory boolean.
   *
   * @param check the check
   * @return the boolean
   * @throws ValidationException the validation exception
   */
  public Boolean validatorFactory(String check) throws ValidationException {
    switch (check) {
      case AGE_CHECK:
        return new AgeValidator(this.registration).validate();
      case NAME_CHECK:
        return new NameValidator(this.registration).validate();
      case BIRTHDAY_CHECK:
        return new BirthdayValidator(this.registration).validate();
      case COUNTRY_CHECK:
        return new CountryValidator(this.registration).validate();
      case ISSUE_DATE_CHECK:
        return new LicenseIssueDateValidator(this.registration).validate();
      case EXPIRY_DATE_CHECK:
        return new LicenseExpiryDateValidator(this.registration).validate();
      case VEHICLE_INFO_CHECK:
        return new VehicleInformationValidator(this.registration).validate();
      case VEHICLE_INSURANCE_CHECK:
        return new InsuredDriverValidator(new OfficialOwnerValidator(new InsuranceExpiryValidator(this.registration))).validate();
      case DRIVER_HISTORY_CHECK:
        return new MovingViolationValidator(new DriverHistoryValidator(this.registration)).validate();
      case VEHICLE_HISTORY_CHECK:
        return new VehicleHistoryValidator(this.registration).validate();
      default:
        return null;
    }
  }

  @Override
  public DriverRegistration getRegistration() {
    return this.registration;
  }

  @Override
  public Boolean validate() throws ValidationException {
    String[] checkItems = {AGE_CHECK,NAME_CHECK,BIRTHDAY_CHECK,COUNTRY_CHECK,
        ISSUE_DATE_CHECK,EXPIRY_DATE_CHECK,VEHICLE_INFO_CHECK,
        VEHICLE_INSURANCE_CHECK, DRIVER_HISTORY_CHECK, VEHICLE_HISTORY_CHECK};
    for (String checkPoint: checkItems){
      try{ validatorFactory(checkPoint);} catch(ValidationException e){
        System.out.println(e);
        return false;
      }
    }
    return true;
  }
}
