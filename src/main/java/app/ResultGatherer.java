package app;

import static app.ConstantsUtils.HEADERS;
import static app.ConstantsUtils.OUTPUT_FILE;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type ResultGatherer.
 */
public class ResultGatherer {
  private final ArrayList<List<String>> simulationResult;
  private final String outputFile;

  /**
   * Instantiates a new ResultGatherer.
   *
   * @param simulationResult  the simulation result
   * @param processedArgument the processed argument
   */
  public ResultGatherer(ArrayList<List<String>> simulationResult, HashMap<String,String> processedArgument) {
    this.simulationResult = simulationResult;
    this.outputFile = processedArgument.get(OUTPUT_FILE);
  }

  /**
   * Write to file.
   */
  public void writeToFile(){
    File file = new File(this.outputFile); // Create a file object
    file.getParentFile().mkdirs(); // Create a folder if it doesn't exist
    try (BufferedWriter outputFile = new BufferedWriter(new FileWriter(this.outputFile))) {
      outputFile.append(HEADERS);
      outputFile.append("\n");
      for (List<String> rowData : this.simulationResult) {
        outputFile.append(rowData.get(0));
        outputFile.append("\n");
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

}
