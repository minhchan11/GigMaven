package app;

import java.util.List;
import java.util.Objects;

/**
 * The type Driver history.
 */
public class DriverHistory implements BasicInformation {

  private final DriverName driver;
  private final List<TrafficViolation> driverViolationHistory;

  /**
   * Instantiates a new Driver history.
   *
   * @param driver                 the driver
   * @param driverViolationHistory the driver violation history
   */
  public DriverHistory(DriverName driver,
      List<TrafficViolation> driverViolationHistory) {
    this.driver = driver;
    this.driverViolationHistory = driverViolationHistory;
  }

  /**
   * Gets driver violation history.
   *
   * @return the driver violation history
   */
  public List<TrafficViolation> getDriverViolationHistory() {
    return driverViolationHistory;
  }

  @Override
  public List<TrafficViolation> accept(DetailExtractor extractor) {
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
    DriverHistory that = (DriverHistory) o;
    return Objects.equals(driver, that.driver) &&
        Objects.equals(driverViolationHistory, that.driverViolationHistory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driver, driverViolationHistory);
  }

  @Override
  public String toString() {
    return "DriverHistory{" +
        "driver=" + driver +
        ", driverViolationHistory=" + driverViolationHistory +
        '}';
  }
}
