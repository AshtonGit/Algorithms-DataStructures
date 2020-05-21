public class AdjacencyMatrix {

    private int[][] matrix;
    private int capacity;
    private int len;

    public AdjacencyMatrix(int len){
        this.len = len;
        this.capacity = len + 5;
        this.matrix = new int[capacity][capacity];
    }

    public AdjacencyMatrix(int[][] matrix){
        this.matrix = matrix;
        this.len = matrix.length;
        this.increaseCapacity();
    }

    void addVertex(){
        if(!hasCapacity())this.increaseCapacity();
        len++;
    }

    void setEdge(int x, int y, int val){
        if(val > 0){
            this.matrix[x][y]=val;
        }
    }

    void deleteEdge(int x, int y){
        this.matrix[x][y]=0;
    }

    /*
     *  slide values down on index starting from vertex+1
     *  set values at matrix[len] to 0
     *  de-increment len by 1
     *
     * @param vertex
     */
    void deleteVertex(int vertex){
        for(int i=0; i < len; i++){
             for(int j=vertex; j<len-1; j++){
                 this.matrix[i][j] = this.matrix[i][j+1];
             }
        }
        for(int i = vertex; i<len-1; i++){
            for(int j =0; j<len-1; j++){
                this.matrix[i][j]= this.matrix[i+1][j];
            }
        }

        for(int i = 0; i<len; i++){
            this.matrix[len-1][i]=0;
            this.matrix[i][len-1]=0;
        }

        this.len--;
    }

    boolean hasCapacity(){
        return len < capacity-1;
    }

    /*
     *increases dimensions of matrix by 5
     */
    void increaseCapacity(){
        int newCapacity = this.capacity+5;
        int[][] expanded = new int[newCapacity][newCapacity];
        for(int i =0; i<len; i++){
            for(int j=0; j<len; j++){
                expanded[i][j] = matrix[i][j];
            }
        }
        this.capacity = newCapacity;
        this.matrix = expanded;
    }

    public int[] getVertex(int vertex){
        return this.matrix[vertex];
    }

    public int getEdge(int x, int y){
        return this.matrix[x][y];
    }

    public boolean hasEdge(int x, int y){
        return this.matrix[x][y] > 0;
    }

    public boolean hasVertex(int vertex){
        return this.len > vertex + 1;
    }

    public int getLen(){
        return this.len;
    }

}
