package app;

import java.util.Objects;

/**
 * The type Driver registration.
 */
public class DriverRegistration {

  private final DriverName name;
  private final DriverBirthday birthday;
  private final DriverLicense license;
  private final VehicleInformation vehicleInformation;
  private final VehicleInsurance vehicleInsurance;
  private final DriverHistory driverHistory;
  private final VehicleHistory vehicleHistory;
  private final DriverCOVIDTesting driverCOVIDTesting;

  public DriverRegistration(DriverName name, DriverBirthday birthday, DriverLicense license,
      VehicleInformation vehicleInformation, VehicleInsurance vehicleInsurance,
      DriverHistory driverHistory, VehicleHistory vehicleHistory,
      DriverCOVIDTesting driverCOVIDTesting) {
    this.name = name;
    this.birthday = birthday;
    this.license = license;
    this.vehicleInformation = vehicleInformation;
    this.vehicleInsurance = vehicleInsurance;
    this.driverHistory = driverHistory;
    this.vehicleHistory = vehicleHistory;
    this.driverCOVIDTesting = driverCOVIDTesting;
  }

  public DriverName getName() {
    return name;
  }

  public DriverBirthday getBirthday() {
    return birthday;
  }

  public DriverLicense getLicense() {
    return license;
  }

  public VehicleInformation getVehicleInformation() {
    return vehicleInformation;
  }

  public VehicleInsurance getVehicleInsurance() {
    return vehicleInsurance;
  }

  public DriverHistory getDriverHistory() {
    return driverHistory;
  }

  public VehicleHistory getVehicleHistory() {
    return vehicleHistory;
  }

  public DriverCOVIDTesting getDriverCOVIDTesting() {
    return driverCOVIDTesting;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverRegistration that = (DriverRegistration) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(birthday, that.birthday) &&
        Objects.equals(license, that.license) &&
        Objects.equals(vehicleInformation, that.vehicleInformation) &&
        Objects.equals(vehicleInsurance, that.vehicleInsurance) &&
        Objects.equals(driverHistory, that.driverHistory) &&
        Objects.equals(vehicleHistory, that.vehicleHistory) &&
        Objects.equals(driverCOVIDTesting, that.driverCOVIDTesting);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(name, birthday, license, vehicleInformation, vehicleInsurance, driverHistory,
            vehicleHistory, driverCOVIDTesting);
  }

  @Override
  public String toString() {
    return "DriverRegistration{" +
        "name=" + name +
        ", birthday=" + birthday +
        ", license=" + license +
        ", vehicleInformation=" + vehicleInformation +
        ", vehicleInsurance=" + vehicleInsurance +
        ", driverHistory=" + driverHistory +
        ", vehicleHistory=" + vehicleHistory +
        ", driverCOVIDTesting=" + driverCOVIDTesting +
        '}';
  }
}
