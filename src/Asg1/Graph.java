package Asg1;

//class to create graph objects
public class Graph {

	// size = both row and column ... size * size = total number of nodes in graph
	int size;

	// symmetric adjacency matrix n*n
	int[][] matrix;

	// time to find max clique for graph
	long time;

	// default constructor
	public Graph() {
		this.size = 10;
		this.matrix = new int[10][10];
		this.time =0;
	}// end of default constructor

	// constructor with size and adjacency matrix as arguments
	public Graph(int size, int[][] matrix) {

		this.size = size;
		this.matrix = matrix;
		this.time = 0;
	}// end of constructor
	
	//getters and setters
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	// getters and setters for time
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	//method for printing the matrix
	public void printMatrix() {
		for (int i=0; i<size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

}// end of class
