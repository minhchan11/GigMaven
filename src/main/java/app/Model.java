package app;

import java.util.HashSet;
import java.util.Set;

/**
 * The type Generator.
 */
public class Model {

  private final Set<DriverPoolRecord> acceptedDriverPool;

  /**
   * Instantiates a new Generator.
   */
  public Model() {
    this.acceptedDriverPool = new HashSet<>();
  }

  /**
   * Gets accepted driver pool.
   *
   * @return the accepted driver pool
   */
  public Set<DriverPoolRecord> getAcceptedDriverPool() {
    return acceptedDriverPool;
  }

  /**
   * Add driver to pool.
   *
   * @param driverRegistration the driver registration
   * @throws ValidationException the validation exception
   */
  public void addDriverToPool(DriverRegistration driverRegistration) throws ValidationException {
    ValidatorTotal validator = new ValidatorTotal(driverRegistration);
    if (validator.validate()) {
      DriverPoolRecord newDriverRecord = new DriverPoolRecord(driverRegistration);
      this.acceptedDriverPool.add(newDriverRecord);
    }
  }
}
