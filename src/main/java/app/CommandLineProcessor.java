package app;

import static app.ConstantsUtils.FRACTION;
import static app.ConstantsUtils.MAX_CLIENT;
import static app.ConstantsUtils.PROCESSABLE;
import static app.ConstantsUtils.SAMPLE_SIZE;

import java.util.Arrays;
import java.util.HashMap;


/**
 * The type Command line processor.
 */
public class CommandLineProcessor {

  /**
   * The constant MAX_CLIENT_LIMIT.
   */
  protected static final int MAX_CLIENT_LIMIT = 50000;
  /**
   * The constant MIN_LIMIT.
   */
  protected static final int MIN_LIMIT = 0;
  /**
   * The constant MAX_SAMPLE_SIZE_LIMIT.
   */
  protected static final int MAX_SAMPLE_SIZE_LIMIT = 10000;
  /**
   * The constant MAX_FRACTION_LIMIT.
   */
  protected static final int MAX_FRACTION_LIMIT = 100;
    private final String[] cmdArguments;

  /**
   * A command line process of arguments processing
   *
   * @param cmdArguments the command line arguments to process
   */
  public CommandLineProcessor(String[] cmdArguments) {
      this.cmdArguments = cmdArguments;
    }

  /**
   * Process arguments hash map.
   *
   * @return the hash map
   * @throws CommandLineException the command line exception
   */
  public HashMap<String,String> processArguments() throws CommandLineException {
      HashMap<String,String> output = new HashMap<>();
      if(this.cmdArguments.length != PROCESSABLE.size()){
        throw new CommandLineException("There should be 4 arguments");
      }
    for (int i = 0; i < this.cmdArguments.length; i++) {
      output.put(PROCESSABLE.get(i), this.cmdArguments[i]);
    }
    int maxClient = NumberAdapter.fromStringToInt(output.get(MAX_CLIENT));
    int sampleSize = NumberAdapter.fromStringToInt(output.get(SAMPLE_SIZE));
    int percentageInvalid = NumberAdapter.fromStringToInt(output.get(FRACTION));
    if (maxClient < MIN_LIMIT || maxClient > MAX_CLIENT_LIMIT) {
      throw new CommandLineException("Maximum clients must be between 0 and " + MAX_CLIENT_LIMIT);
    }
    if (sampleSize < MIN_LIMIT || sampleSize > MAX_SAMPLE_SIZE_LIMIT || sampleSize > maxClient) {
      throw new CommandLineException(
          "Number of unique verification must be less than or equal number of clients, between 0 and "
              + MAX_SAMPLE_SIZE_LIMIT);
    }
    if (percentageInvalid < MIN_LIMIT || percentageInvalid > MAX_FRACTION_LIMIT) {
      throw new CommandLineException(
          "Percentage of failed verification must be between 0 and " + MAX_FRACTION_LIMIT);
    }
    return output;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLineProcessor processor = (CommandLineProcessor) o;
    return Arrays.equals(cmdArguments, processor.cmdArguments);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(cmdArguments);
  }

  @Override
  public String toString() {
    return "CommandLineProcessor{" +
        "cmdArguments=" + Arrays.toString(cmdArguments) +
        '}';
  }
}

