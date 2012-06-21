package br.usp.mlapp;

import java.io.BufferedReader;
import java.io.FileReader;

public class MutualInformation {
	
	public static final String FILENAME = "/home/fm/workspace/pf/data/0012/1000/cut3/dy_file.data";
		
	private float[][] data;
	
	public void readData(String filename) throws Exception {
		
		BufferedReader in = new BufferedReader(new FileReader(filename));
		
		in.readLine(); // skip line 
		
		int nrows = Integer.parseInt(in.readLine());
		int ncols = Integer.parseInt(in.readLine()) - 2;
		
		in.readLine(); // skip line 
		
		data = new float[nrows][ncols];
		
		String line;
		int i = 0;
		while ((line = in.readLine()) != null) {
			
			String[] split = line.split(";");
			for (int j = 1; j < split.length - 1; j++) {
				
				data[i][j-1] = Float.parseFloat(split[j]);
			}
			i++;
		}
		
	}
	
	public void calculate() {
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		MutualInformation mt = new MutualInformation();
		mt.readData(FILENAME);
	}

}
