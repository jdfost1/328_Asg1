package Asg1;

public class Graph {
	
	int size;
	int[][] matrix;
	
	
	//default constructor
	public Graph() {
		this.size = 10;
		this.matrix = new int[10][10];
	}//end of default constructor
	
	//constructor with size and input lines as arguments
	public Graph(int size, int[][] matrix) {
		
		this.size = size;
		this.matrix = new int[size][size];
	}//end of constructor
	
	

}//end of class
