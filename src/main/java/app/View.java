package app;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The type ResultGatherer.
 */
public class View {

  /**
   * The constant EMPTY.
   */
  protected static final int EMPTY = 0;
  /**
   * The Generator.
   */
  public Model model;

  /**
   * Instantiates a new ResultGatherer.
   *
   * @param model the model
   */
  public View(Model model) {
    this.model = model;
  }

  /**
   * Provide driver info.
   *
   * @param lastName the last name
   */
  public void provideDriverInfo(String lastName) {
    List<DriverPoolRecord> filtered = this.filterLastName(lastName);
    if (filtered.size() > EMPTY) {
      Map<DriverName, List<DriverPoolRecord>> groupedByName = groupAndSort(filtered);
      for (Map.Entry<DriverName, List<DriverPoolRecord>> entry : groupedByName.entrySet()) {
        DriverName driver = entry.getKey();
        List<DriverPoolRecord> information = entry.getValue();
        this.printDriverName(driver);
        this.printVehicles(information);
        this.printDriverHistory(information);
      }
    } else{
      System.out.println("No registered driver found");
    }
  }

  /**
   * Helper method to filter and sort
   * @param lastName
   * @return
   */
  private List<DriverPoolRecord> filterLastName(String lastName){
    List<DriverPoolRecord> filtered = this.model.getAcceptedDriverPool()
        .stream()
        .filter(filterByLastName(lastName)).collect(Collectors.toList());
    return filtered;
  }

  private Predicate<DriverPoolRecord> filterByLastName(String lastName){
    return driver -> driver.getDriverName().getLastName().equals(lastName);
  }

  /**
   * Helper method to group and sort
   * @param driverList
   * @return
   */
  private TreeMap<DriverName, List<DriverPoolRecord>> groupAndSort(
      List<DriverPoolRecord> driverList) {
    Map<DriverName, List<DriverPoolRecord>> groupedByName = driverList
        .stream()
        .collect(Collectors.groupingBy(DriverPoolRecord::getDriverName));
    return new TreeMap<>(groupedByName);
  }


  /**
   * Print driver name.
   *
   * @param driver the driver
   */
  protected void printDriverName(DriverName driver) {
    System.out.println("* " + driver.getLastName() + "," + driver.getFirstName());
  }

  /**
   * Print vehicles.
   *
   * @param driverInformation the driver information
   */
  protected void printVehicles(List<DriverPoolRecord> driverInformation) {
    List<String> vehiclesOwned = driverInformation.stream().map(DriverPoolRecord::getVehicleDetails)
        .distinct().collect(
            Collectors.toList());
    for (String vehicle : vehiclesOwned) {
      System.out.println("\t\t >> " + vehicle);
    }
  }

  /**
   * Print driver history.
   *
   * @param driverInformation the driver information
   */
  protected void printDriverHistory(List<DriverPoolRecord> driverInformation) {
    List<TrafficViolation> driverRecord = driverInformation.stream()
        .flatMap(e -> e.getDriverDrivingRecord().stream()).distinct().collect(Collectors.toList());
    if (driverRecord.size() > 0) {
      System.out.println("\t\t * Driving Violations:");
      for (TrafficViolation v : driverRecord) {
        System.out.println("\t\t\t >> " + v.getViolation());
      }
    }
  }
}
