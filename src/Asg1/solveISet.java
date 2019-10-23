package Asg1;

import java.io.IOException;
import java.util.List;

public class solveISet {

	// main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// initiates new object
			GraphList graphList = new GraphList("graphs2019.txt");

			// invert graph
			List<Graph> inverseGraphs = graphList.invertGraphs();

			for (int i = 0; i < inverseGraphs.size(); i++) {

				System.out.println();
				System.out.println("Graph " + i);

				inverseGraphs.get(i).printMatrix();

				// here goes the clique method which uses the inverted graph

			}

		} catch (IOException e) {
			System.out.println("file error");
		}
	}

}
