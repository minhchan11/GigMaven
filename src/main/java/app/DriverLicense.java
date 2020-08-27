package app;


import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Driver license.
 */
public class DriverLicense implements BasicInformation {

  private final String licenseNumber;
  private final DriverName driverName;
  private final String address;
  private final DriverBirthday driverBirthday;
  private final String countryIssue;
  private final String stateIssue;
  private final LocalDate dateIssue;
  private final LocalDate dateExpired;

  /**
   * Instantiates a new Driver license.
   *
   * @param licenseNumber  the license number
   * @param driverName     the driver name
   * @param address        the address
   * @param driverBirthday the driver birthday
   * @param countryIssue   the country issue
   * @param stateIssue     the state issue
   * @param dateIssue      the date issue
   * @param dateExpired    the date expired
   */
  public DriverLicense(String licenseNumber, DriverName driverName, String address,
      DriverBirthday driverBirthday, String countryIssue, String stateIssue,
      LocalDate dateIssue, LocalDate dateExpired) {
    this.licenseNumber = licenseNumber;
    this.driverName = driverName;
    this.address = address;
    this.driverBirthday = driverBirthday;
    this.countryIssue = countryIssue;
    this.stateIssue = stateIssue;
    this.dateIssue = dateIssue;
    this.dateExpired = dateExpired;
  }

  /**
   * Gets license number.
   *
   * @return the license number
   */
  public String getLicenseNumber() {
    return licenseNumber;
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
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets driver birthday.
   *
   * @return the driver birthday
   */
  public DriverBirthday getDriverBirthday() {
    return driverBirthday;
  }

  /**
   * Gets country issue.
   *
   * @return the country issue
   */
  public String getCountryIssue() {
    return countryIssue;
  }

  /**
   * Gets state issue.
   *
   * @return the state issue
   */
  public String getStateIssue() {
    return stateIssue;
  }

  /**
   * Gets date issue.
   *
   * @return the date issue
   */
  public LocalDate getDateIssue() {
    return dateIssue;
  }

  /**
   * Gets date expired.
   *
   * @return the date expired
   */
  public LocalDate getDateExpired() {
    return dateExpired;
  }

  @Override
  public Object accept(DetailExtractor extractor) {
    return null;
  }

  /**
   * Accept string.
   *
   * @param extractor the extractor
   * @param type      the type
   * @return the string
   */
  public String accept(DetailExtractor extractor, String type) {
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
    DriverLicense that = (DriverLicense) o;
    return Objects.equals(licenseNumber, that.licenseNumber) &&
        Objects.equals(driverName, that.driverName) &&
        Objects.equals(address, that.address) &&
        Objects.equals(driverBirthday, that.driverBirthday) &&
        Objects.equals(countryIssue, that.countryIssue) &&
        Objects.equals(stateIssue, that.stateIssue) &&
        Objects.equals(dateIssue, that.dateIssue) &&
        Objects.equals(dateExpired, that.dateExpired);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(licenseNumber, driverName, address, driverBirthday, countryIssue, stateIssue,
            dateIssue,
            dateExpired);
  }

  @Override
  public String toString() {
    return "DriverLicense{" +
        "licenseNumber='" + licenseNumber + '\'' +
        ", driverName=" + driverName +
        ", address='" + address + '\'' +
        ", driverBirthday=" + driverBirthday +
        ", countryIssue='" + countryIssue + '\'' +
        ", stateIssue='" + stateIssue + '\'' +
        ", dateIssue=" + dateIssue +
        ", dateExpired=" + dateExpired +
        '}';
  }
}
