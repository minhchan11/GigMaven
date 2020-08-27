package app;

import static app.ConstantsUtils.VEHICLE_OFFICIAL_OWNER_CHECK;

import java.util.List;
import java.util.function.Function;

/**
 * The type Official owner validator.
 */
public class OfficialOwnerValidator extends ValidatorDecorator {

  /**
   * Instantiates a new Official owner validator.
   *
   * @param validator the validator
   */
  public OfficialOwnerValidator(IValidatable validator) {
    super(validator);
  }

  @Override
  public Boolean validate() throws ValidationException {
    try {
      super.validate();
      DetailExtractor infoExtractor = new DetailGetter();
      DriverName nameProvided = this.getRegistration().getName();
      DriverName nameOnVehicle = this.getOfficialDriver().apply(this.getRegistration().getVehicleInsurance()
          .accept(infoExtractor, VEHICLE_OFFICIAL_OWNER_CHECK));
      if (nameProvided.equals(nameOnVehicle)) {
        return true;
      }
    } catch(ValidationException e){
      throw e;
    }
    return false;
  }

  private Function<List<DriverName>,DriverName> getOfficialDriver(){
    return driverNames -> driverNames.get(0);
  }
}
