package Asg1;

import java.io.IOException;

public class solveClique {

	// Driver code to solve the max clique in each graph
	public static void main(String[] args) throws NumberFormatException, IOException {

//create new graph list object with input file as argument
		GraphList allGraphs = new GraphList("graphs2019.txt");
		
		
	//call method to calculate maxCliques for all graphs in the graph list
		findMaxClique(allGraphs);

	}// end of main method

	public static void findMaxClique(GraphList graphs) {
		
		
		//start loop to iterate through each graph in graphlist
		
		// start timer to calculate time it takes to find max clique for this graph
		long startTime = System.currentTimeMillis();
		
		
		//use algorithm to find max clique for this graph
		
		//get total time elapsed after algorithm implemented on this graph
		long timeElapsed = System.nanoTime() - startTime;
		
		//print max clique set for this graph
		
		//print the size of the max clique found
		
		//print the time elapsed to calculate the max clique for this graph
		

	

	}// end of findMaxClique method

}//end of class
