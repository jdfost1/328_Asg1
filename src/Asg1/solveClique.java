package Asg1;

import java.io.IOException;
import java.util.ArrayList;

public class solveClique {
	static long ms;

	// Driver code to find the max clique in each graph from the input file
	public static void main(String[] args) throws NumberFormatException, IOException {

        //create new graph list object with input file as argument
		GraphList allGraphs = new GraphList("graphs2019.txt");
		
		//iterate through the graphs in the graph list and call the findMaxClique on each graph
		for (int i = 0; i < allGraphs.graphList.size(); i++) {

			int graphSize = allGraphs.graphList.get(i).getSize();

			// create an integer list to hold the set of vertices found in the max clique for this graph
			ArrayList<Integer> cliqueList = new ArrayList<Integer>();
			
			//start timer
			long startTime = System.currentTimeMillis();

			//call method to find max clique in graph and return the list of vertices
			cliqueList = findMaxClique(allGraphs.graphList.get(i));
			
			//end timer
			ms = System.currentTimeMillis() - startTime;

			// print the max clique results for this graph
			System.out.println("G" + (i + 1) + " (" + graphSize + ", " + allGraphs.graphList.get(i).countEdges() + ") "
					+ cliqueList.toString() + "(size=" + cliqueList.size() + ", " + ms + " ms)");
		} // end of for loop

	}// end of main method
	
	//take graph and pass into recursive algorithm to find max clique
	public static ArrayList<Integer> findMaxClique(Graph graph){
		
	//pass in a new array list to hold clique (this argument is needed for recursion), initialize second arg to 0 (needed for recursion as well)
		return findMaxCliqueAlgorithm(new ArrayList<Integer>(),0, graph);
		
	}//end of helper method

	
	public static ArrayList<Integer> findMaxCliqueAlgorithm(ArrayList<Integer> clique, int row, Graph graph) {
		
        int dimension = graph.size;
 
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> maxClique = new ArrayList<Integer>();
		
		maxClique = clique;

		for (int i = row; i < dimension; i++) {
			boolean isClique = true;
			
			for (int j = 0; j < clique.size(); j++) {
				if (graph.matrix[clique.get(j)][i] != 1) {
					isClique = false;
				}
			}//end of inner for loop

			if (isClique) {
				ArrayList<Integer> currentClique = new ArrayList<Integer>(clique);
				currentClique.add(i);
				temp = findMaxCliqueAlgorithm(currentClique, i + 1, graph);

				if (temp.size() > maxClique.size()) { maxClique = temp;}
			}//end of outer if statement
		} // end of outer loop
		
		return maxClique;
	}//end of findMaxClique method

}// end of class
