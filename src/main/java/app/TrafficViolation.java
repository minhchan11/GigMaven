package app;

import java.time.LocalDate;

/**
 * The type Traffic violation.
 */
public class TrafficViolation extends IncidentAbstract {

  /**
   * Instantiates a new Traffic violation.
   *
   * @param dateCommitted the date committed
   * @param violation     the violation
   */
  public TrafficViolation(LocalDate dateCommitted, Violation violation) {
    super(dateCommitted, violation);
  }
}
