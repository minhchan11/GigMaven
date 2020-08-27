package app;

/**
 * The enum Moving violation.
 */
public enum MovingViolation implements Violation {
  /**
   * Distracted driving moving violation.
   */
  DISTRACTED_DRIVING,
  /**
   * Reckless driving moving violation.
   */
  RECKLESS_DRIVING,
  /**
   * Speeding moving violation.
   */
  SPEEDING,
  /**
   * Driving under influence moving violation.
   */
  DRIVING_UNDER_INFLUENCE,
  /**
   * Failure to respect traffic signs moving violation.
   */
  FAILURE_TO_RESPECT_TRAFFIC_SIGNS,
  /**
   * Driving without a valid license and or insurance moving violation.
   */
  DRIVING_WITHOUT_A_VALID_LICENSE_AND_OR_INSURANCE
}
