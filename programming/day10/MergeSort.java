

public class MergeSort<T extends Comparable> implements ISort <T> {

  private T[] new_array;
  private int len;;
  private T[] ret_array;

  /**
   * Sorts an array of items in place
   * @param in An array to sort
   */
  public void sort(T[] in) {
    new_array = in;
    len = in.length;
    Integer[] ret_array = new Integer[len];
    mergeSorting(0, len - 1);
  }

  private void mergeSorting(int min, int max) {
    if (min < max) {
      int mid = min + ((max - min) / 2);
      mergeSorting(min, mid);
      mergeSorting(mid + 1, max);
      merge(min, mid, max);
    }
  }

  private void merge(int mini, int midi, int maxi) {
    for (int i = mini; i <= maxi; i++) {
      ret_array[i] = new_array[i];
    }
    int miner = mini;
    int middle = midi + 1;
    int maxer = maxi;

    while (miner <= midi && middle <= maxi) {
      if (ret_array[miner].compareTo(ret_array[middle]) <= 0) {
        new_array[maxer] = ret_array[miner];
        miner++;
      }
      else {
        new_array[maxer] = ret_array[middle];
      }
      maxer++;
    }
    while (miner <= midi) {
      new_array[maxer] = ret_array[miner];
      maxer++;
      miner++;
    }
  }

  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName() {
    return "MergeSort";
  }
}
