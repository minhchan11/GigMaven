package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The type Driver birthday.
 */
public class DriverCOVIDTesting implements BasicInformation {
  private final DriverName driverName;
  private final ArrayList<LocalDate> datesTested;

  /**
   * Instantiates a new Driver covid testing.
   *
   * @param driverName  the driver name
   * @param datesTested the dates tested
   */
  public DriverCOVIDTesting(DriverName driverName,
      ArrayList<LocalDate> datesTested) {
    this.driverName = driverName;
    this.datesTested = datesTested;
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
   * Gets dates tested.
   *
   * @return the dates tested
   */
  public ArrayList<LocalDate> getDatesTested() {
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
    DriverCOVIDTesting that = (DriverCOVIDTesting) o;
    return Objects.equals(driverName, that.driverName) &&
        Objects.equals(datesTested, that.datesTested);
  }

  @Override
  public int hashCode() {
    return Objects.hash(driverName, datesTested);
  }

  @Override
  public String toString() {
    return "DriverCOVIDTesting{" +
        "driverName=" + driverName +
        ", datesTested=" + datesTested +
        '}';
  }

  @Override
  public LocalDate accept(DetailExtractor extractor) {
    return extractor.visit(this);
  }
}
