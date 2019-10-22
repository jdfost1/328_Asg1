package Asg1;

//class to create graph objects
public class Graph {

	int size;
	int numEdges;

	int[][] matrix; // symmetric adjacency matrix n*n

	// constructor with size and adjacency matrix as arguments
	public Graph(int size, int[][] matrix) {

		this.size = size;
		this.matrix = matrix;
	}// end of constructor

	// method for printing the matrix
	public void printMatrix() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {System.out.print(matrix[i][j]);}
			System.out.println();
		}//end of for loop
	}

	// method to count the total number of edges in a graph
	public int countEdges() {

		int numEdges = 0;
		
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				if (matrix[i][j] == 1)
					numEdges++;
			} // end of inner loop
		} // end of outer loop

		return numEdges;
	}

	// getters and setters
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

}// end of class
