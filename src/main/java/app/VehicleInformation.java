package app;

import java.util.Objects;

/**
 * The type Vehicle information.
 */
public class VehicleInformation implements BasicInformation<Integer> {

  private final String make;
  private final String model;
  private final Integer year;
  private final DriverName officialOwner;

  /**
   * Instantiates a new Vehicle information.
   *
   * @param make          the make
   * @param model         the model
   * @param year          the year
   * @param officialOwner the official owner
   */
  public VehicleInformation(String make, String model, Integer year, DriverName officialOwner) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.officialOwner = officialOwner;
  }

  /**
   * Gets make.
   *
   * @return the make
   */
  public String getMake() {
    return make;
  }

  /**
   * Gets model.
   *
   * @return the model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets year.
   *
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  /**
   * Gets official owner.
   *
   * @return the official owner
   */
  public DriverName getOfficialOwner() {
    return officialOwner;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleInformation vehicleInformation = (VehicleInformation) o;
    return Objects.equals(make, vehicleInformation.make) &&
        Objects.equals(model, vehicleInformation.model) &&
        Objects.equals(year, vehicleInformation.year) &&
        Objects.equals(officialOwner, vehicleInformation.officialOwner);
  }

  @Override
  public int hashCode() {
    return Objects.hash(make, model, year, officialOwner);
  }

  @Override
  public String toString() {
    return "VehicleInformation{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", year=" + year +
        ", officialOwner=" + officialOwner +
        '}';
  }

  @Override
  public Integer accept(DetailExtractor extractor) {
    return extractor.visit(this);
  }
}
