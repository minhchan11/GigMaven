package app;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The type Vehicle insurance.
 */
public class VehicleInsurance implements BasicInformation {

  private final DriverName officialOwner;
  private final List<DriverName> insuredDrivers;
  private final LocalDate insuranceExpiryDate;

  /**
   * Instantiates a new Vehicle insurance.
   *
   * @param officialOwner       the official owner
   * @param insuredDrivers      the insured drivers
   * @param insuranceExpiryDate the insurance expiry date
   */
  public VehicleInsurance(DriverName officialOwner,
      List<DriverName> insuredDrivers, LocalDate insuranceExpiryDate) {
    this.officialOwner = officialOwner;
    this.insuredDrivers = insuredDrivers;
    this.insuranceExpiryDate = insuranceExpiryDate;
  }

  /**
   * Gets official owner.
   *
   * @return the official owner
   */
  public DriverName getOfficialOwner() {
    return officialOwner;
  }

  /**
   * Gets insured drivers.
   *
   * @return the insured drivers
   */
  public List<DriverName> getInsuredDrivers() {
    return insuredDrivers;
  }

  /**
   * Gets insurance expiry date.
   *
   * @return the insurance expiry date
   */
  public LocalDate getInsuranceExpiryDate() {
    return insuranceExpiryDate;
  }

  @Override
  public LocalDate accept(DetailExtractor extractor) {
    return extractor.visit(this);
  }

  /**
   * Accept list.
   *
   * @param extractor the extractor
   * @param type      the type
   * @return the list
   */
  public List<DriverName> accept(DetailExtractor extractor, String type) {
    return extractor.visit(this, type);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleInsurance that = (VehicleInsurance) o;
    return Objects.equals(officialOwner, that.officialOwner) &&
        Objects.equals(insuredDrivers, that.insuredDrivers) &&
        Objects.equals(insuranceExpiryDate, that.insuranceExpiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(officialOwner, insuredDrivers, insuranceExpiryDate);
  }

  @Override
  public String toString() {
    return "VehicleInsurance{" +
        "officialOwner=" + officialOwner +
        ", insuredDrivers=" + insuredDrivers +
        ", insuranceExpiryDate=" + insuranceExpiryDate +
        '}';
  }
}
