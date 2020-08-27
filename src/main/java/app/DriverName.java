package app;

import java.util.Objects;

/**
 * The type Driver name.
 */
public class DriverName implements BasicInformation, Comparable<DriverName> {

  private final String firstName;
  private final String lastName;

  /**
   * Instantiates a new Driver name.
   *
   * @param firstName the first name
   * @param lastName  the last name
   */
  public DriverName(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  @Override
  public String accept(DetailExtractor extractor) {
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
    DriverName that = (DriverName) o;
    return Objects.equals(firstName, that.firstName) &&
        Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "DriverName{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }

  @Override
  public int compareTo(DriverName o) {
    return this.getFirstName().compareTo(o.getFirstName());
  }
}
