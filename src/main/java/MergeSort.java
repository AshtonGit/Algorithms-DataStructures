import java.util.ArrayList;
import java.util.List;

/*
 * Merge sort is a recursive divide and conquer algorithm.
 * 1. divide input array into 2 equal halves
 * 2. call merge sort on the first half
 * 3. call merge sort on the second half
 * 4. merge the two havles sorted in steps 2 and 3.
 * Merge sort divides the arrays recursively until the input arrays have len <= 1.
 * The merging process:
 * While(both arrays have len > 0):
 * Compare The elements at the index 0 for each sub-array.
 *  The smaller element  is appended to the output and removed from its sub array.
 *  The larger element stays in its sub array and enters the next round of comparison
 *  When one array is empty, the loop is exited.
 *  All remaining elements in the non empty sub array are appended to the output.
 *
 * eg .
 * i = [3,4,9,6]
 * ii. = [3,4] , [9,6]
 * iii. = [3], [4], [9], [6].
 * iv. (merging).
 *  x = [3], y = [4], output = []
 *  x = [], y = [4], output = [3]
 *  x = [], y = [], output = [3,4]
 *
 * v. (merging).
 *  x = [9], y = [6], output= []
 *  x = [9], y = [], output = [6]
 *  x = [], y = [], output = [6.9]
 *
 * vi. (merging).
 *  x = [3,4] , y = [6,9], output = []
 *  x = [4], y = [6,9], output = [3]
 *  x = [], y = [6,9], output = [3,4]
 *  x = [], y = [], output = [3,4,6,9]
 * Sorted array = [3,4,6,9]
 *
Time Complexity :
* O(n log n) in all cases (best, avg, worst)
* merge sort always divides the arrays into 2 halves and takes linear time to merge two halves
*
* Space Complexity:
* O(n).
* The temp arrays are created after the recursion and so do not persist in memory.
* The array is sorted in place, its doesn't shrink or grow in size.
*
* Applications:
* Merge sort is useful for sorting Linked Lists, esp compared to quicksort
* due to difference in memory allocation for linked lists vs arrays.
* Quick sort does lots of random memory access (x[0] then x[4] then x[3].
* Arrays have elements stored contiguously in memory while linked lists may not. To access an item in a linked list
* you have to traverse the list in order to reach a target node. Therefore overhead increases for quicksort.
* Merge sort accesses data sequentially (as its depth first), and the need for random access is low.
* In a linked list, we can insert items in the middle in O(1) extra space and O(1) time.
* Therefore merge operation of merge sort can be implemented without extra space for linked lists.
 */
public class MergeSort {

    public static <T extends Comparable> List<T> sort(List<T> array, int start, int end){


        if(start < end){
            int pivot = (start+end)/2;
            sort(array, start, pivot);
            sort(array, pivot+1, end);
            merge(array, start, pivot, end);
        }


        return array;
    }

     public static <T extends Comparable> void merge(List<T>array, int start, int pivot, int end ){
        List<T> a = array.subList(start, pivot);
        List<T> b = array.subList(pivot, end);
        int alen = a.size();
        int blen = b.size();
        int i =0;
        int j = 0;
        int k = start;

        while(i<alen && j < blen){
            if(a.get(i).compareTo(b.get(i))>= 0){
                array.set(k, a.get(i));
                i++;
            }else{
                array.set(k, b.get(i));
                j++;
            }
            k++;
        }
        while(i<alen){
            array.set(k, a.get(i));
            i++;
            k++;
        }
        while(j < blen){
            array.set(k, b.get(j));
            j++;
            k++;
        }
     }



}
