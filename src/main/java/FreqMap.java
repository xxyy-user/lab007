import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqMap {

  // returns relative frequency of each number in the list
  public static Map<Integer, Double> getFrequencyCount(List<Integer> numbers) {
    Map<Integer, Double> frequencyMap = new HashMap<>();

    // count occurrences of each number
    for (Integer num : numbers) {
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0.0) + 1);
    }

    // calculate the relative frequency
    int total = numbers.size();
    for (Map.Entry<Integer, Double> entry : frequencyMap.entrySet()) {
      frequencyMap.put(entry.getKey(), entry.getValue() / total);
    }

    return frequencyMap;
  }

  // test
  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 1, 1, 2, 2, 3, 3, 4, 4, 4);
    Map<Integer, Double> result = getFrequencyCount(numbers);

    for (Map.Entry<Integer, Double> entry : result.entrySet()) {
      System.out.println(entry.getKey() + " → " + entry.getValue());
    }
  }
}