package app;

import java.util.Objects;

/**
 * The type Driver birthday.
 */
public class DriverBirthday implements BasicInformation {

  private final Integer day;
  private final Integer month;
  private final Integer year;

  /**
   * Instantiates a new Driver birthday.
   *
   * @param day   the day
   * @param month the month
   * @param year  the year
   */
  public DriverBirthday(Integer day, Integer month, Integer year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  /**
   * Gets day.
   *
   * @return the day
   */
  public Integer getDay() {
    return day;
  }

  /**
   * Gets month.
   *
   * @return the month
   */
  public Integer getMonth() {
    return month;
  }

  /**
   * Gets year.
   *
   * @return the year
   */
  public Integer getYear() {
    return year;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DriverBirthday that = (DriverBirthday) o;
    return Objects.equals(day, that.day) &&
        Objects.equals(month, that.month) &&
        Objects.equals(year, that.year);
  }

  @Override
  public int hashCode() {
    return Objects.hash(day, month, year);
  }

  @Override
  public String toString() {
    return "DriverBirthday{" +
        "day=" + day +
        ", month=" + month +
        ", year=" + year +
        '}';
  }

  @Override
  public String accept(DetailExtractor extractor) {
    return extractor.visit(this);
  }
}
