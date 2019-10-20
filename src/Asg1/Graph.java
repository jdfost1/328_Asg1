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
		this.matrix = new int[size][size];
		this.time = 0;
	}// end of constructor

	// getters and setters for time
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

}// end of class
