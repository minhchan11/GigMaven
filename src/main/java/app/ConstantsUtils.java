package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The type Constants utils.
 */
public class ConstantsUtils {

  /**
   * The constant AGE_CHECK.
   */
  public static final String AGE_CHECK = "Age";
  /**
   * The constant NAME_CHECK.
   */
  public static final String NAME_CHECK = "Name";
  /**
   * The constant BIRTHDAY_CHECK.
   */
  public static final String BIRTHDAY_CHECK = "Birthday";
  /**
   * The constant COUNTRY_CHECK.
   */
  public static final String COUNTRY_CHECK = "Country";
  /**
   * The constant ISSUE_DATE_CHECK.
   */
  public static final String ISSUE_DATE_CHECK = "Issue Date";
  /**
   * The constant EXPIRY_DATE_CHECK.
   */
  public static final String EXPIRY_DATE_CHECK = "Expiry Date";
  /**
   * The constant VEHICLE_INFO_CHECK.
   */
  public static final String VEHICLE_INFO_CHECK = "Vehicle Information";
  /**
   * The constant VEHICLE_INSURANCE_CHECK.
   */
  public static final String VEHICLE_INSURANCE_CHECK = "Vehicle Insurance";
  /**
   * The constant VEHICLE_OFFICIAL_OWNER_CHECK.
   */
  public static final String VEHICLE_OFFICIAL_OWNER_CHECK = "Vehicle Official Owner";
  /**
   * The constant VEHICLE_INSURED_DRIVERS_CHECK.
   */
  public static final String VEHICLE_INSURED_DRIVERS_CHECK = "Vehicle Insured Drivers";
  /**
   * The constant DRIVER_HISTORY_CHECK.
   */
  public static final String DRIVER_HISTORY_CHECK = "Driver History";
  /**
   * The constant VEHICLE_HISTORY_CHECK.
   */
  public static final String VEHICLE_HISTORY_CHECK = "Vehicle History";
  /**
   * The constant TODAY.
   */
  public static final LocalDate TODAY = LocalDate.now();
  /**
   * The constant DATE_TIME_FORMAT.
   */
  public static final String DATE_TIME_FORMAT = "d/M/yyyy";


  /**
   * The constant DEPOSIT.
   */
  public static final String DEPOSIT = "Deposit";
  /**
   * The constant WITHDRAWAL.
   */
  public static final String WITHDRAWAL = "Withdrawal";
  /**
   * The constant ACCEPTED.
   */
  public static final String ACCEPTED = "Accepted";
  /**
   * The constant REJECTED.
   */
  public static final String REJECTED = "Rejected";
  /**
   * The constant VALID.
   */
  public static final String VALID = "Yes";
  /**
   * The constant INVALID.
   */
  public static final String INVALID = "No";
  /**
   * The constant MAX_CLIENT.
   */
  public static final String MAX_CLIENT = "Max_Client";
  /**
   * The constant SAMPLE_SIZE.
   */
  public static final String SAMPLE_SIZE = "Sample_Size";
  /**
   * The constant FRACTION.
   */
  public static final String FRACTION = "Percent_Invalid";
  /**
   * The constant OUTPUT_FILE.
   */
  public static final String OUTPUT_FILE = "Output_File";
  /**
   * The constant PROCESSABLE.
   */
  public static final List<String> PROCESSABLE = new ArrayList<>(
      Arrays.asList(MAX_CLIENT, SAMPLE_SIZE, FRACTION, OUTPUT_FILE));
  /**
   * The constant HEADERS.
   */
  public static final String HEADERS = "Transaction No,Time,Client ID,Message,Digital Signature,Verified,Transaction Status";
  /**
   * Instantiates a new Constants utils.
   */
  public ConstantsUtils() {
  } // to get coverage
}
