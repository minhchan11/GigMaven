package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Moving violation validator.
 */
public class MovingViolationValidator extends ValidatorDecorator {

  /**
   * The Unacceptable offense.
   */
  protected List<MovingViolation> unacceptableOffense = new ArrayList<>(
      Arrays.asList(MovingViolation.RECKLESS_DRIVING,
          MovingViolation.SPEEDING,
          MovingViolation.DRIVING_WITHOUT_A_VALID_LICENSE_AND_OR_INSURANCE,
          MovingViolation.DRIVING_UNDER_INFLUENCE));

  /**
   * Instantiates a new Moving violation validator.
   *
   * @param validator the validator
   */
  public MovingViolationValidator(IValidatable validator) {
    super(validator);
  }

  @Override
  public Boolean validate() throws ValidationException {
    if (!super.validate()) {
      DetailExtractor infoExtractor = new DetailGetter();
      List<TrafficViolation> trafficRecord = this.getRegistration().getDriverHistory()
          .accept(infoExtractor);
      List<Violation> violations = trafficRecord.stream().map(TrafficViolation::getViolation)
          .collect(
              Collectors.toList());
      if(!Collections.disjoint(violations, unacceptableOffense)){
        throw new ValidationException("Driver history contains reckless driving, speeding, DUI, or driving "
            + "without a valid license/insurance");
      }
    }
    return true;
  }
}
