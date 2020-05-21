import java.util.ArrayList;
import java.util.List;

public class AdjacencyList {

    private int size;
    private List<Node> adjacencyList;

    public AdjacencyList(int size){
        this.size = size;
        this.adjacencyList = new ArrayList<Node>();
    }

    public boolean setEdge(int from, int to, int edge){
        if(from < size && to < size){
            if(adjacencyList.get(from) == null)
                adjacencyList.set(from, new Node(to, edge));
            else{
                adjacencyList.get(from).addNode(new Node(to, edge));
            }
            return true;
        }
        return false;
    }

    public void deleteEdge(int from, int to){
        Node node = adjacencyList.get(from);
        if(node.vertex == to){
            adjacencyList.set(from, node.next);
            return;
        }
        while(node != null){
            if(node.next.vertex == to){
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    public boolean hasEdge(int from, int to){
        Node node = adjacencyList.get(from);
        while(node != null){
            if(node.vertex == to) return true;
        }
        return false;
    }

    public void addVertex(){
        this.size++;
    }

    public void deleteVertex(int vertex){
        adjacencyList.remove(vertex);
        size--;
        for(int i =0; i<size; i++){
            Node node = adjacencyList.get(i);
            while(node != null){
                if(node.vertex == vertex){
                    adjacencyList.set(i,node.next);
                    break;
                }
                node = node.next;
            }
        }
    }


    private class Node{

        public Node next;
        public int vertex;
        public int edge;

        Node(int vertex, int edge){
            this.vertex = vertex;
            this.edge = edge;
        }

        Node(int vertex, int edge, Node next){
            this.vertex = vertex;
            this.edge = edge;
            this.next = next;
        }

        public void addNode(Node node) {
            if (this.vertex == node.vertex)
                this.edge = node.edge;
            else if (next == null)
                next = node;
            else {
                next.addNode(node);
            }
        }
    }

}
