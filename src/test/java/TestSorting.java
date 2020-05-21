import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestSorting {

    @Test
    public void adjacencyMatrix(){
        int[][] init = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        AdjacencyMatrix matrix = new AdjacencyMatrix(init);
        assert(matrix.getLen() == 3);
        assert(matrix.hasCapacity());
        matrix.deleteEdge(0, 2);
        assert(matrix.getEdge(0,2) == 0);
        matrix.setEdge(0,2, 3);
        assert(matrix.getEdge(0,2)==3);
        matrix.deleteVertex(1);
        int[] x = matrix.getVertex(1);
        assert(x[1]==9);
    }

    @Test
    public void binarySearchTree(){
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(4,5,8,13,4,2,1));
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(input);
        int len = input.size();
        List<Integer> inOrder = bst.inOrder();
        List<Integer> postOrder = bst.postOrder();
        List<Integer> preOrder = bst.preOrder();
        for(int i = 1; i < len; i++){
            assert(inOrder.get(i) >= inOrder.get(i-1));
        }
        bst.deleteByValue(4);
        assert(bst.contains(4));
        bst.deleteByValue(4);
        assert(! bst.contains(4));

    }

    @Test
    public void heapSort(){
        List<Integer> unsorted = new ArrayList<Integer>(Arrays.asList(3,4,9,6,1));
        List<Integer> sorted = HeapSort.sort(new ArrayList<Integer>(unsorted));
        assert(unsorted.size() == sorted.size());
        for(int i =1; i < sorted.size(); i++){
            assert(sorted.get(i-1) >= sorted.get(i));
        }
    }

    @Test
    public void quickSort(){
        Integer[] array = {3,4,6,1,9};
        new QuickSort().sort(array, 0,4);
        for(int i = 1; i < 5; i++){
            assert(array[i-1] <= array[i]);
        }

        array = new Integer[]{3,4,6,1,9};
        new QuickSort().sortHighPivot(array, 0, 4);
        for(int i = 1; i < 5; i++){
            assert(array[i-1] <= array[i]);
        }
    }

    @Test
    public void mergeSort(){
        List<Integer> unsorted = new ArrayList<Integer>(Arrays.asList(3,4,9,6,1));
        List<Integer> sorted = MergeSort.sort(unsorted, 0, unsorted.size() - 1);
        assert(unsorted.size() == sorted.size());
        for(int i = 1; i < sorted.size(); i++){
            assert(sorted.get(i-1) >= sorted.get(i));
        }
    }


    @Test
    public void insertionSort(){
        List<Integer> unsorted = new ArrayList<Integer>(Arrays.asList(3,4,9,5,6));
        List<Integer> sorted = InsertionSort.sort(unsorted);
        assert(unsorted.size() == sorted.size());
        for(int i = 1; i < sorted.size(); i++){
            assert(sorted.get(i-1) >= sorted.get(i));
        }
    }

    @Test
    public void selectionSort(){
        List<Integer> unsorted = new ArrayList<Integer>(Arrays.asList(3,4,9,5,6));
        List<Integer> sorted = SelectionSort.sort(unsorted);
        assert(unsorted.size() == sorted.size());
        for(int i = 1; i < sorted.size(); i++){
            assert(sorted.get(i-1) >= sorted.get(i));
        }
    }
}
