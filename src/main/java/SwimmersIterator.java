import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwimmersIterator implements Iterator<Swimmer> {

  private List<Swimmer> swimmers;
  private int index = 0;
  private static final double OLYMPIC_TIME = 26.17;

  public SwimmersIterator(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
  }

  /**
   * hasNext checks if there is a qualified swimmer in the list
   * the index pointer will stop and return true
   * @return bool
   */
  @Override
  public boolean hasNext() {
    while (index < swimmers.size() &&
        !isQualified(swimmers.get(index))) {
      index++;
    }
    return index < swimmers.size();
  }

  @Override
  public Swimmer next() {
    Swimmer res = swimmers.get(index);
    index++;
    return res;
  }

  private boolean isQualified(Swimmer s) {
    if (s.getButterfly50mTimes().size() < 5) return false;

    for (double time : s.getFreestyle50mTimes()) {
      if (time <= OLYMPIC_TIME) return true;
    }
    return false;
  }
}