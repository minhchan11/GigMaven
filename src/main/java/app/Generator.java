package app;

import app.Client;
import app.RandomGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type Generator.
 */
public class Generator {
  private final Integer maxClient;
  private final ArrayList<Client> allClients;

  /**
   * Instantiates a new Generator.
   *
   * @param maxClient the max client
   */
  public Generator(Integer maxClient) {
    this.maxClient = maxClient;
    this.allClients = this.generateClients();
  }

  /***
   * generate client from random ids
   * @return an array list of Client
   */
  private ArrayList<Client> generateClients(){
    List<Integer> uniqueIds = RandomGenerator.createRandomID(this.maxClient);
    return uniqueIds.stream().map(Client::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  /**
   * Gets max client.
   *
   * @return the max client
   */
  public Integer getMaxClient() {
    return maxClient;
  }

  /**
   * Gets all clients.
   *
   * @return the all clients
   */
  public ArrayList<Client> getAllClients() {
    return allClients;
  }

  /**
   * Get sample client array list.
   *
   * @param sampleSize the sample size
   * @return the array list
   */
  public ArrayList<Client> getSampleClient(Integer sampleSize){
    Set<Integer> included = new HashSet<>();
    ArrayList<Client> output = new ArrayList<>();
    Random rand = new Random();
    for (int i = 0; i < this.maxClient && sampleSize > 0 ; i++) {
      int chosen = rand.nextInt(this.allClients.size());
      if (!included.contains(chosen)){
        output.add(this.allClients.get(chosen));
        included.add(chosen);
        sampleSize--;
      }
    }
    return output;
  }


}
