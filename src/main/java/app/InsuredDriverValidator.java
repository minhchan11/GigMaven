package app;

import static app.ConstantsUtils.VEHICLE_INSURED_DRIVERS_CHECK;

import java.util.List;

/**
 * The type Insured driver validator.
 */
public class InsuredDriverValidator extends ValidatorDecorator {

  /**
   * Instantiates a new Insured driver validator.
   *
   * @param validator the validator
   */
  public InsuredDriverValidator(IValidatable validator) {
    super(validator);
  }

  @Override
  public Boolean validate() throws ValidationException {
    try {
      if (!super.validate()) {
        DetailExtractor infoExtractor = new DetailGetter();
        DriverName driver = this.getRegistration().getName();
        List<DriverName> driverNameList = this.getRegistration().getVehicleInsurance()
            .accept(infoExtractor, VEHICLE_INSURED_DRIVERS_CHECK);
        if (!driverNameList.contains(driver)) {
          throw new ValidationException("Driver is not official nor on insured drivers list of vehicle");
        }
        return true;
      }
    } catch (ValidationException e){
      throw e;
    }
    return false;
  }
}
