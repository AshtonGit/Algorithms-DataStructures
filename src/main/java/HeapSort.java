import java.util.List;

public class HeapSort {


    public static <T extends Comparable> List<T> sort(List<T> x){
        int n = x.size();
        for(int i=n/2 -1 ; i>=0; i--)
            heapify(x,n, i);

        for(int i = n-1; i>=0; i--){
            T temp = x.get(0);
            x.set(0, x.get(i));
            x.set(i, temp);
            heapify(x, i, 0);

        }

        return x;
    }

    private static <T extends Comparable> void heapify(List<T> x, int n, int i){
        int smallest = i;
        int left = (i*2)+1;
        int right = (i*2)+2;
        if(left < n && x.get(left).compareTo(x.get(smallest)) < 0){
          smallest = left;
        }
        if(right < n && x.get(right).compareTo(x.get(smallest)) < 0){
            smallest = right;
        }

        if(smallest != i){
            T swap = x.get(i);
            x.set(i, x.get(smallest));
            x.set(smallest, swap);
            heapify(x, n, smallest);
        }
    }

}
