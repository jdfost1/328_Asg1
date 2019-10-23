package Asg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphList {

	// list that contains all the graphs
	List<Graph> graphList;
	
	public GraphList(String filename) throws NumberFormatException, IOException {
		this.graphList = new ArrayList<Graph>();
		parseGraphs(filename);

	}// end of constructor

	// method to parse input file into an array list of graphs
	public void parseGraphs(String filename) throws NumberFormatException, IOException {
		BufferedReader bufferedReader;
		String firstChar;// first char read in to tell us the number of rows/cols in graph/adjacency
							// matrix

		// these counter variables are used to print a specified number of graphs in the
		// graph list for testing (FOR TESTING ONLY)
		int counter = 0;
		int maxCounter = 5;// set number of graphs to print from list of graphs

		try {
			// create file reader object with input file
			FileReader reader = new FileReader(new File(filename));

			// use buffered reader object to help efficiently read in characters and lines
			// from input file
			bufferedReader = new BufferedReader(reader);

			// while loop to read in first number that lets us know how many rows in graph
			// and then reads lines to set values in graph
			while ((firstChar = bufferedReader.readLine()) != null) {

				// first character read in should represent the size of the rows & cols for the
				// symmetric adjacency matrix
				int matrixSize = Integer.parseInt(firstChar);

				// used for testing
				if (counter < maxCounter) {
					System.out.println("Matrix Size: " + firstChar);
				}

				// if there is 0 rows.. then we do not need to read in any lines
				if (matrixSize == 0) {
					System.out.println("matrix size = 0");
					break;
				} // end of if statement

				// create array of adjacency matrix to help create graph
				int[][] adjacencyMatrix = new int[matrixSize][matrixSize];

				// for loop to read input file and parse into graph
				for (int j = 0; j < matrixSize; j++) {
					String line = bufferedReader.readLine().replaceAll("\\s+", "");
					if (counter < maxCounter) {
						System.out.println("\nLine " + (j + 1) + ": " + line);
					}
					for (int i = 0; i < matrixSize; i++) {

						adjacencyMatrix[j][i] = Integer.parseInt(line.charAt(i) + "");

						// only print the matrixes of first 5 for testing
						if (counter < maxCounter)
							System.out.println("Filled in cell [" + j + "]" + "[" + i + "] in matrix with value of "
									+ adjacencyMatrix[j][i]);

					} // end of inner for loop
				} // end of outer for loop

				// print method for testing only
				if (counter < maxCounter) {
					System.out.println("Filling of matrix complete \n\n");
				}
				counter++;

				// create new graph with adjacency matrix parsed from input file and add to list
				// of graphs
				this.graphList.add(new Graph(matrixSize, adjacencyMatrix));

			} // end of while loop

			reader.close();
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} // end of try/catch block
	}// end of parseGraphs method

	// static method which will invert all graphs in the list returns message if list is empty
	public List<Graph> invertGraphs() {

		// lets user know no graphs were inverted
		if (graphList.size() == 0) {
			System.out.println("No graphs to invert");
		}

		// for loop that goes through each graph of the list
		for (int i = 0; i < graphList.size(); i++) {
			Graph temp = graphList.get(i); //variable not used?

			int[][] matrix = graphList.get(i).getMatrix();
			int size = graphList.get(i).getSize();

			// for loop that inverts matrix
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					if (j == k)
						matrix[j][k] = 1;
					else if (matrix[j][k] == 0)
						matrix[j][k] = 1;
					else
						matrix[j][k] = 0;
				}
			}

			graphList.get(i).setMatrix(matrix);

		}

		return graphList;
	}// end of invertGraphs method

	public List<Graph> getGraphList() {
		return graphList;
	}

}// end of class
