import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    /*
        Iterate through a sublist of the list to be sorted.
        At each iteration decrease the sublist's
        range by 1. eg. [0:n] -> [1:n] .. ->[n:n]
        Find the minimum and move it to the start of the array.
        increment counter.
        repeat till entire list iterated through and sorted.


    */

    public static <T extends Comparable<T>> List<T> sort(List<T> unsorted){
        int len = unsorted.size();

       List<T> sorted = new ArrayList<T>(unsorted);
        for(int i =0; i<len; i++){
            int indexOfMin = i;
            for(int j = i+1; j<len; j++){
                if(sorted.get(j).compareTo(sorted.get(indexOfMin))>=1){
                    indexOfMin = j;
                }
            }
            T t = sorted.get(i);
            sorted.set(i,sorted.get(indexOfMin));
            sorted.set(indexOfMin, t);
        }
        return sorted;
    }
}
