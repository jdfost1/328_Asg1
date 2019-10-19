package Asg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphList {
	
	
	List<Graph> graphList;
	
	//constructor
	public GraphList(String filename) throws NumberFormatException, IOException {
		// create array list of graphs so that we can read in and store all of the graphs from input file
				this.graphList = new ArrayList<Graph>();
				parseGraphs(filename);
		
	}
	
	//method to parse input file into an array list of graphs
	public void parseGraphs(String filename) throws NumberFormatException, IOException {
		BufferedReader bufferedReader;
		String firstChar;// first char read in to tell us the number of rows in graph/adjacency matrix
		
		int counter =0; //counter for testing/printing

		try {
			// create file reader object with input file
			FileReader reader = new FileReader(new File(filename));

			// use buffered reader object efficiently read characters,lines, and arrays
			bufferedReader = new BufferedReader(reader);

			// while loop to read in first number that lets us know how many rows in graph
			// and then reads lines
			while ((firstChar = bufferedReader.readLine()) != null) {
				int matrixSize = Integer.parseInt(firstChar);
				if(counter<5) {System.out.println("Matrix Size: " + firstChar);}

				// if there is 0 rows.. then we do not need to read in any lines
				if (matrixSize == 0) {
					System.out.println("matrix size = 0");
					break;
				} // end of if statement

				// create array of adjacency matrix to help create graph
				int[][] adjacencyMatrix = new int[matrixSize][matrixSize];

				for (int j = 0; j < matrixSize; j++) {
					String line = bufferedReader.readLine().replaceAll("\\s+", "");
					if(counter < 5) {System.out.println("\nLine " + (j + 1) + ": " + line);}
					for (int i = 0; i < matrixSize; i++) {

						adjacencyMatrix[j][i] = Integer.parseInt(line.charAt(i) + "");
						
						//only print the matrixes of first 5 for testing
						if(counter < 5)
						System.out.println("Filled in cell [" + j + "]" + "[" + i + "] in matrix with value of "
								+ adjacencyMatrix[j][i]);

					} // end of inner for loop
				} // end of outer for loop
				if(counter<5) {System.out.println("Filling of matrix complete \n\n");}
				counter++;

				// create new graph with adjacency matrix parsed from input file
				this.graphList.add(new Graph(matrixSize, adjacencyMatrix));

			} // end of while loop

			reader.close();
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		} // end of try/catch block
	}//end of parseGraphs method

}
