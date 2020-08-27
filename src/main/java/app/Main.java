package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Main.
 */
public class Main {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   * @throws CommandLineException  the command line exception
   * @throws InvalidRangeException the invalid range exception
   */
  public static void main(String[] args)
      throws CommandLineException, InvalidRangeException {
    // command line processor get the input
    CommandLineProcessor clp = new CommandLineProcessor(args);
    HashMap<String,String> processedArguments = clp.processArguments();

    // pass to simulator and model
    Simulator simulator = new Simulator(processedArguments);
    ArrayList<List<String>> simulationResult = simulator.createSimulation();

    ResultGatherer result = new ResultGatherer(simulationResult,processedArguments);
    result.writeToFile();
  }
}
