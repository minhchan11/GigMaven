package app;

import java.time.LocalDate;

/**
 * The type Crash.
 */
public class Crash extends IncidentAbstract {

  /**
   * Instantiates a new Crash.
   *
   * @param dateCommitted the date committed
   * @param crashType     the crash type
   */
  public Crash(LocalDate dateCommitted, CrashType crashType) {
    super(dateCommitted, crashType);
  }

}
