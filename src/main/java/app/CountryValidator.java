package app;

import static app.ConstantsUtils.COUNTRY_CHECK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Country validator.
 */
public class CountryValidator extends ValidatorAbstract {

  /**
   * The Allowed.
   */
  protected List<String> allowed = new ArrayList<>(Arrays.asList("US", "Canada"));

  /**
   * Instantiates a new Country validator.
   *
   * @param registration the registration
   */
  public CountryValidator(DriverRegistration registration) {
    super(registration);
  }

  @Override
  public Boolean validate() throws ValidationException {
    DetailExtractor infoExtractor = new DetailGetter();
    String countryProvided = this.getRegistration().getLicense()
        .accept(infoExtractor, COUNTRY_CHECK);
    if (!allowed.contains(countryProvided)) {
      throw new ValidationException("Only US and Canada allowed");
    }
    return true;
  }
}
