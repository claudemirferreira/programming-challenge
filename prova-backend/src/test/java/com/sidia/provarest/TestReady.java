package com.sidia.provarest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sidia.provarest.model.Data;
import com.sidia.provarest.util.Util;

public class TestReady {

	public static void main(String[] arg) throws Exception {
		String path = System.getProperty("user.dir") +"\\data\\";
		File[] arquivos = Util.loadFiles(path);
		boolean isTitle = false;
		for (File file : arquivos) {
			StringTokenizer st;
			BufferedReader TSVFile = new BufferedReader(new FileReader(file));
			String dataRow = TSVFile.readLine(); // Read first line.
			System.out.println(dataRow);
			
			while (dataRow != null) {
				st = new StringTokenizer(dataRow, "\t");
				List<String> dataArray = new ArrayList<String>();
				while (st.hasMoreElements()) {
					dataArray.add(st.nextElement().toString());
				}
				if(isTitle) {
					Data data = new Data(dataArray);
					//System.out.println(data.toString());
				}else {
					isTitle = true;
				}
				//
				for (String item : dataArray) {
					System.out.print(item + "  ");
				}
				System.out.println(); // Print the data line.
				dataRow = TSVFile.readLine(); // Read next line of data.
			}
			// Close the file once all data has been read.
			TSVFile.close();

			// End the printout with a blank line.
			System.out.println();
		}

		

	} // main()

}
