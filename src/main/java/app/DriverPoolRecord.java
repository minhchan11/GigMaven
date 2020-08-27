package app;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The type Driver pool record.
 */
public class DriverPoolRecord {

  private final DriverName driverName;
  private final VehicleInformation vehicleInformation;
  private final DriverHistory driverHistory;
  private final DriverLicense driverLicense;
  private final List<TrafficViolation> driverDrivingRecord;
  private final String vehicleDetails;
  private final List<LocalDate> datesTested;

  /**
   * Instantiates a new Driver pool record.
   *
   * @param driverRegistration the driver registration
   */
  public DriverPoolRecord(DriverRegistration driverRegistration) {
    this.driverName = driverRegistration.getName();
    this.vehicleInformation = driverRegistration.getVehicleInformation();
    this.driverHistory = driverRegistration.getDriverHistory();
    this.driverLicense = driverRegistration.getLicense();
    this.driverDrivingRecord = this.driverHistory.getDriverViolationHistory();
    this.vehicleDetails = this.vehicleTotalInfo();
    this.datesTested = driverRegistration.getDriverCOVIDTesting().getDatesTested();
  }

  /**
   * Gets driver name.
   *
   * @return the driver name
   */
  public DriverName getDriverName() {
    return driverName;
  }

  /**
   * Gets vehicle information.
   *
   * @return the vehicle information
   */
  public VehicleInformation getVehicleInformation() {
    return vehicleInformation;
  }

  /**
   * Gets driver history.
   *
   * @return the driver history
   */
  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  /**
   * Gets driver license.
   *
   * @return the driver license
   */
  public DriverLicense getDriverLicense() {
    return driverLicense;
  }

  /**
   * Gets driver driving record.
   *
   * @return the driver driving record
   */
  public List<TrafficViolation> getDriverDrivingRecord() {
    return driverDrivingRecord;
  }

  /**
   * Gets vehicle details.
   *
   * @return the vehicle details
   */
  public String getVehicleDetails() {
    return vehicleDetails;
  }

  /**
   * Vehicle information
   * @return string contains make model registration
   */
  private String vehicleTotalInfo() {
    String vehicleInfo =
        this.vehicleInformation.getYear() + " " + this.vehicleInformation.getMake() + " "
            + this.vehicleInformation.getModel();
    String licensePlate = this.driverLicense.getLicenseNumber();
    return vehicleInfo + ", " + licensePlate;
  }

  /**
   * Gets dates tested.
   *
   * @return the dates tested
   */
  public List<LocalDate> getDatesTested() {
    return datesTested;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverPoolRecord that = (DriverPoolRecord) o;
    return Objects.equals(driverName, that.driverName) &&
        Objects.equals(vehicleInformation, that.vehicleInformation) &&
        Objects.equals(driverHistory, that.driverHistory) &&
        Objects.equals(driverLicense, that.driverLicense) &&
        Objects.equals(driverDrivingRecord, that.driverDrivingRecord) &&
        Objects.equals(vehicleDetails, that.vehicleDetails) &&
        Objects.equals(datesTested, that.datesTested);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(driverName, vehicleInformation, driverHistory, driverLicense, driverDrivingRecord,
            vehicleDetails, datesTested);
  }

  @Override
  public String toString() {
    return "DriverPoolRecord{" +
        "driverName=" + driverName +
        ", vehicleInformation=" + vehicleInformation +
        ", driverHistory=" + driverHistory +
        ", driverLicense=" + driverLicense +
        ", driverDrivingRecord=" + driverDrivingRecord +
        ", vehicleDetails='" + vehicleDetails + '\'' +
        ", datesTested=" + datesTested +
        '}';
  }
}
