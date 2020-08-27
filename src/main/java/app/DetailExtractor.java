package app;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

/**
 * The interface Detail extractor.
 */
public interface DetailExtractor {

    /**
     * Visit string.
     *
     * @param driverName the driver name
     * @return the string
     */
    String visit(DriverName driverName);

    /**
     * Visit string.
     *
     * @param driverBirthday the driver birthday
     * @return the string
     */
    String visit(DriverBirthday driverBirthday);

    /**
     * Visit string.
     *
     * @param license the license
     * @param type    the type
     * @return the string
     */
    String visit(DriverLicense license, String type);

    /**
     * Visit integer.
     *
     * @param vehicleInformation the vehicle information
     * @return the integer
     */
    Integer visit(VehicleInformation vehicleInformation);

    /**
     * Visit local date.
     *
     * @param vehicleInsurance the vehicle insurance
     * @return the local date
     */
    LocalDate visit(VehicleInsurance vehicleInsurance);

    /**
     * Visit list.
     *
     * @param vehicleInsurance the vehicle insurance
     * @param type             the type
     * @return the list
     */
    List<DriverName> visit(VehicleInsurance vehicleInsurance, String type);

    /**
     * Visit list.
     *
     * @param driverHistory the driver history
     * @return the list
     */
    List<TrafficViolation> visit(DriverHistory driverHistory);

    /**
     * Visit hash map.
     *
     * @param vehicleHistory the vehicle history
     * @return the hash map
     */
    HashMap<DriverName, List<IncidentAbstract>> visit(VehicleHistory vehicleHistory);

    /**
     * Visit local date.
     *
     * @param driverCOVIDTesting the driver testing
     * @return the local date
     */
    LocalDate visit(DriverCOVIDTesting driverCOVIDTesting);
}
