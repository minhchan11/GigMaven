package app;

import java.time.LocalDate;
import java.util.Objects;

/**
 * The type Incident abstract.
 */
public abstract class IncidentAbstract {

  private final LocalDate dateCommitted;
  private final Violation violation;

  /**
   * Instantiates a new Incident abstract.
   *
   * @param dateCommitted the date committed
   * @param violation     the violation
   */
  public IncidentAbstract(LocalDate dateCommitted, Violation violation) {
    this.dateCommitted = dateCommitted;
    this.violation = violation;
  }

  /**
   * Gets date committed.
   *
   * @return the date committed
   */
  public LocalDate getDateCommitted() {
    return dateCommitted;
  }

  /**
   * Gets violation.
   *
   * @return the violation
   */
  public Violation getViolation() {
    return violation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IncidentAbstract that = (IncidentAbstract) o;
    return Objects.equals(dateCommitted, that.dateCommitted) &&
        Objects.equals(violation, that.violation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateCommitted, violation);
  }

  @Override
  public String toString() {
    return "IncidentAbstract{" +
        "dateCommitted=" + dateCommitted +
        ", violation=" + violation +
        '}';
  }
}
