import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    public static <T extends Comparable<T>> List<T> sort(List<T> unsorted){


        List<T> sorted = new ArrayList<T>();
        int len = unsorted.size();
        for(int i=0; i<len; i++){
            T e = unsorted.get(i);
            int sorted_len = sorted.size();
            boolean added = false;
            for(int j=0; j < sorted_len; j++){
                if(e.compareTo(sorted.get(j))>0){
                    sorted.add(j, e);
                    added = true;
                    break;
                }
            }
            if(!added)sorted.add(e);
        }
        return sorted;
    }



    /*
        Se :
            multiple object type
            any  list length
            even if zero
            both lists should have the same length
            Algorithm itself: iterate through list take next element e,
             iterate through sorted sublist. when eement found that is smaller than e, insert e there
        Si:

        Ne: Comparabale, Comparator, Insertion sort algorithm
        Ni:
        iterate through unsorted
        take element e
        iterate through sorted
        compare e to elements of sorted till find one smaller
        insert e in that index of sorted
        continue iterating through unsorted till reach end of the list.
     */
}
