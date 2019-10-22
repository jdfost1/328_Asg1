package Asg1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class solve3CNF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "cnfs2019.txt";
		BufferedReader fin;
		String currentLine;
		ArrayList<Graph> graphList = new ArrayList<Graph>();

		try {

			// create file reader object with input file

			FileReader reader = new FileReader(new File(filename));

			// use buffered reader object to help efficiently read in characters and lines
			// from input file
			fin = new BufferedReader(reader);
			//while ((currentLine = fin.readLine()) != null) {
				currentLine = fin.readLine();
				// read line and split into an array
				String[] line = currentLine.split("\\s");

				// Initialize an arraylist and take first value from line to know number of
				// variables
				ArrayList<Integer> valueArray = new ArrayList<Integer>();
				int n = Integer.parseInt(line[0]);

				if (n != 0) {
					System.out.println("Number of variables = " + n);
					for (int i = 1; i < line.length; i++) {
						valueArray.add(Integer.parseInt(line[i]));
					}
					System.out.println("Number of clauses = " + (valueArray.size() / 3));

					for (int i = 0; i < valueArray.size(); i++) {
						System.out.print(valueArray.get(i)+",");
					}
					System.out.println();
					
					Graph graph = CNFtoClique(valueArray);
					graph.printMatrix();
				}
			//}

		} catch (IOException e) {
			// TODO: handle exception
		}

	}

	public static Graph CNFtoClique(ArrayList<Integer> valueArray) {
		Graph graph;
		int size = valueArray.size();

		int[][] matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j)
					matrix[i][j] = 1;
				else if (i / 3 == j / 3)
					matrix[i][j] = 0;
				else if ((valueArray.get(i) * -1) == valueArray.get(j))
					matrix[i][j] = 0;
				else
					matrix[i][j] = 1;
			}
		}
		
		graph = new Graph(size, matrix);
		
		return graph;
	}
}
