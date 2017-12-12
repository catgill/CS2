

public class SelectSort<T extends Comparable> implements ISort <T>{



  /**
   * Sorts an array of items in place
   * @param in An array to sort
   */
  public  void sort(T[] in) {
    for (int i = 0; i < in.length - 1; i++) {
      int idx = 0;
      for (int j = i + 1; j < in.length; j++) {
        if (in[j].compareTo(in[i]) < 0) {
          T hold = in[i];
          in[i] = in[j];
          in[j] = hold;
        }
      }
    }
  }


  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName() {
    return "Select Sort";
  }



  // public static void main(String[] args) {
  //   SelectSort<Integer> s = new SelectSort<Integer>();
  //   Integer[] array = new Integer[4];
  //   array[0] = 13;
  //   array[1] = -10;
  //   array[2] = 5;
  //   array[3] = 4;
  //   s.sort(array);
  //   for (int i = 0; i < array.length; i++) {
  //     System.out.println(array[i]);
  //   }
  // }
}
