package com.sidia.provarest.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import com.sidia.provarest.model.Title;

public class UtilReadTsv {

	public static HashSet<Title> importTitle() throws IOException {
		String path = System.getProperty("user.dir") +"\\data\\";
		System.out.println(path);
		BufferedReader reader = new BufferedReader(new FileReader("data.tsv"));
		String line;
		HashSet<Title> list = new HashSet<Title>();
		List<String> listGeners;
		int i = 1;
		
		boolean isHeader = true;
		while ((line = reader.readLine()) != null) {
			String[] fields = line.split("\t");
			if (isHeader)
				isHeader = false;
			else {
				/*
				Title t = new Title();
				t.setId(fields[0]);
				t.setTitleType(fields[1]);
				t.setPrimaryTitle(fields[2]);
				t.setOriginalTitle(fields[3]);
				System.out.println(fields[4]);
				t.setAdulto(Boolean.valueOf(fields[4]));
				t.setStartYear(fields[5]);
				t.setEndYear(fields[6]);
				t.setRuntimeMinutes(fields[7]);
				String[] geners = fields[8].split(",");
				List<String> listGeners = new ArrayList<String>();
				for (String string : geners) {
					listGeners.add(string);
				}
				//TODO refactory the list
				t.setGenres(listGeners);
				System.out.println(t.toString());
				*/
				listGeners = new ArrayList<String>();
				for (String string : fields[8].split(",")) {
					listGeners.add(string);
				}
				i = i+1;
				System.out.println(i);
				/*
				
				list.add(new Title(fields[0], 
						fields[1], 
						fields[2], 
						fields[3], 
						Boolean.valueOf(fields[4]), 
						fields[5], 
						fields[6], 
						fields[7], 
						listGeners));
						
						*/
				//break;
			}

		}
		reader.close();
		return list;
	}

	public static void importTitleOld() throws IOException {
		String path = System.getProperty("user.dir") + "\\data\\title\\";
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
					// System.out.println(st.nextElement().toString());
					dataArray.add(st.nextElement().toString());
				}
				if (isTitle) {
					// Title data = new Title(dataArray);
					// System.out.println(data.toString());
				} else {
					isTitle = true;
				}
				for (String item : dataArray) {
					System.out.print(item + "  ");
				}
				System.out.println();
				dataRow = TSVFile.readLine();
			}
			TSVFile.close();
		}
	}

}
