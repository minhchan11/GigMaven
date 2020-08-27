package app;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * The type Vehicle history.
 */
public class VehicleHistory implements BasicInformation {

  private final HashMap<DriverName, List<IncidentAbstract>> vehicleIncidentHistory;

  /**
   * Instantiates a new Vehicle history.
   *
   * @param vehicleIncidentHistory the vehicle incident history
   */
  public VehicleHistory(
      HashMap<DriverName, List<IncidentAbstract>> vehicleIncidentHistory) {
    this.vehicleIncidentHistory = vehicleIncidentHistory;
  }

  /**
   * Gets vehicle incident history.
   *
   * @return the vehicle incident history
   */
  public HashMap<DriverName, List<IncidentAbstract>> getVehicleIncidentHistory() {
    return vehicleIncidentHistory;
  }

  @Override
  public HashMap<DriverName, List<IncidentAbstract>> accept(DetailExtractor extractor) {
    return extractor.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleHistory that = (VehicleHistory) o;
    return Objects.equals(vehicleIncidentHistory, that.vehicleIncidentHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleIncidentHistory);
  }

  @Override
  public String toString() {
    return "VehicleHistory{" +
        "vehicleIncidentHistory=" + vehicleIncidentHistory +
        '}';
  }
}
