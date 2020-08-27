package app;

import static app.ConstantsUtils.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

/**
 * The type Detail getter.
 */
public class DetailGetter implements DetailExtractor {

  /**
   * The Formatter.
   */
  protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);

  @Override
  public String visit(DriverName driverName) {
    return driverName.getFirstName() + driverName
        .getLastName(); // return String instead of object, save memory
  }

  @Override
  public String visit(DriverBirthday driverBirthday) {
    return driverBirthday.getDay() + "/"
        + driverBirthday.getMonth() + "/" +
        + driverBirthday.getYear();
  }

  @Override
  public String visit(DriverLicense license, String type) {
    switch (type){
      case(NAME_CHECK):
        return license.getDriverName().accept(this);
      case(BIRTHDAY_CHECK):
        return license.getDriverBirthday().accept(this);
      case(COUNTRY_CHECK):
        return license.getCountryIssue();
      case (ISSUE_DATE_CHECK):
        return this.convertToString().apply(license.getDateIssue());
      case (EXPIRY_DATE_CHECK):
        return this.convertToString().apply(license.getDateExpired());
      default:
        return null;
    }
  }

  /**
   * Convert to string function.
   *
   * @return the function
   */
  public Function<LocalDate, String> convertToString() {
    return date -> date.format(formatter);
  }

  /**
   * Convert to local date function.
   *
   * @return the function
   */
  public Function<String, LocalDate> convertToLocalDate() {
    return string -> LocalDate.parse(string, formatter);
  }

  @Override
  public Integer visit(VehicleInformation vehicleInformation) {
    return vehicleInformation.getYear();
  }

  @Override
  public LocalDate visit(VehicleInsurance vehicleInsurance) {
    return vehicleInsurance.getInsuranceExpiryDate();
  }

  @Override
  public List<DriverName> visit(VehicleInsurance vehicleInsurance, String type) {
    if (type.equals(VEHICLE_INSURED_DRIVERS_CHECK) ){
      return vehicleInsurance.getInsuredDrivers();
    } else if (type.equals(VEHICLE_OFFICIAL_OWNER_CHECK)){
      List<DriverName> officialOwner = new ArrayList<>();
      officialOwner.add(vehicleInsurance.getOfficialOwner());
      return officialOwner;
    }
    return null;
  }

  @Override
  public List<TrafficViolation> visit(DriverHistory driverHistory) {
    return driverHistory.getDriverViolationHistory();
  }

  @Override
  public HashMap<DriverName, List<IncidentAbstract>> visit(VehicleHistory vehicleHistory) {
    return vehicleHistory.getVehicleIncidentHistory();
  }

  @Override
  public LocalDate visit(DriverCOVIDTesting driverCOVIDTesting) {
    return driverCOVIDTesting.getDatesTested().stream()
        .max(LocalDate::compareTo)
        .orElse(null);
  }

}
