import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree <T extends Comparable<T>>{

    Node root;

    public BinarySearchTree(List<T> n){
        for(T t : n){
            this.add(t);
        }
    }

    public void add(T x){
        this.root = addRec(x, this.root);
    }

    private Node addRec(T x, Node root){
        if(root == null) root = new Node(x);
        else if(x.compareTo(root.value) < 0) root.left = addRec(x, root.left);
        else{
            root.right = addRec(x, root.right);
        }
        return root;
    }

    public void deleteByValue (T x){
        root = deleteRec(x, root);
    }


    private Node deleteRec(T x, Node root){
        if(root == null) return null;
        int compare = x.compareTo(root.value);
        if(compare < 0) root.left = deleteRec(x, root.left);
        else if(compare > 0) root.right = deleteRec(x, root.right);
        else{

            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            root.value =  findMin(root).value;
            root.right = deleteRec(root.value, root.right);
        }
        return root;
    }

    public  Node findMin(Node root){
        Node min = root;
        while(min.left != null){
            min = min.left;
        }
        return min;
    }

    public  Node find(T x){
        return findRec(x, root);
    }

    public boolean contains(T x){
        return (this.find(x) != null);
    }

    private  Node findRec(T x, Node root){
        if(root == null)return null;
        int compare = x.compareTo(root.value);
        if(compare == 0)return root;
        else if(compare < 0) return findRec(x, root.left);
        else{
            return findRec(x, root.right);
        }
    }

    public  List<T> inOrder(){
        List<T> sorted = new ArrayList<T>();
        return inOrderRec(root, sorted);
    }

    public List<T> inOrderRec(Node root, List<T> sorted){
        if(root != null){
            inOrderRec(root.left, sorted);
            sorted.add(root.value);
            inOrderRec(root.right, sorted);
        }
        return sorted;
    }

    public List<T> preOrder(){
        List<T> preOrder = new ArrayList<T>();
        preOrderRec(this.root, preOrder);
        return preOrder;
    }

    public void preOrderRec(Node root, List<T> n){
        if(root != null){
            n.add(root.value);
            preOrderRec(root.left, n);
            preOrderRec(root.right, n);
        }
    }

    public List<T> postOrder(){
        return postOrderRec(this.root, new ArrayList<T>());
    }

    public List<T> postOrderRec(Node root, List<T> sorted){
        if(root != null){
            postOrderRec(root.left, sorted);
            postOrderRec(root.right, sorted);
            sorted.add( root.value);
        }
        return sorted;
    }

    public class Node {
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }
    }

}

