import java.util.ArrayList;
import java.util.List;

public class  QuickSort <T extends Comparable<T>>{

    public void sort(T[] array, int low, int high){
        if(low < high){
            int pi= low + (high-low)/2;
            T pivot = array[pi];
            int i = low;
            int j =high;

            while(i <= j){
                while(array[i].compareTo(pivot) < 0)i++;
                while(array[j].compareTo(pivot) > 0)j--;
                if(i <= j){
                    swap(array, i, j);
                    i++;
                    j++;
                }
            }
            sort(array, low, j);
            sort(array, i, high);
        }
    }

    public void sortHighPivot(T[] array, int low, int high){
        if(low  < high){
            int pi = high;
            T pivot = array[pi];
            int j = -1;
            for(int i =0; i < pi; i++){
                if(array[i].compareTo(pivot) < 0){
                    j++;
                    swap(array, i, j);
                }
            }
            swap(array, ++j, pi);
            sortHighPivot(array, low, j-1);
            sortHighPivot(array, j+1, high);
        }
    }



    private void swap(T[] array, int a, int b){
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
