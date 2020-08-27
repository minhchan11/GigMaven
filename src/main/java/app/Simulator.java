package app;

import static app.ConstantsUtils.FRACTION;
import static app.ConstantsUtils.MAX_CLIENT;
import static app.ConstantsUtils.SAMPLE_SIZE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Simulator.
 */
public class Simulator {
  private final Integer totalClient;
  private final Integer sampleSize;
  private final Integer invalidFraction;
  private final Generator model;

  /**
   * Instantiates a new Simulator.
   *
   * @param processedArgument the processed argument
   */
  public Simulator(HashMap<String,String> processedArgument) {
    this.totalClient = NumberAdapter.fromStringToInt(processedArgument.get(MAX_CLIENT));
    this.sampleSize = NumberAdapter.fromStringToInt(processedArgument.get(SAMPLE_SIZE));
    this.invalidFraction = NumberAdapter.fromStringToInt(processedArgument.get(FRACTION));
    this.model = new Generator(this.totalClient);
  }

  /**
   * Create simulation array list.
   *
   * @return the array list
   * @throws InvalidRangeException the invalid range exception
   */
  public ArrayList<List<String>> createSimulation() throws InvalidRangeException {
    ArrayList<Client> sample = model.getSampleClient(this.sampleSize);
    BankClientFacade application = new BankClientFacade(sample,this.invalidFraction);
    return application.simulate();
  }

}
