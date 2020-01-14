package com.sidia.provarest.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidia.provarest.model.Ratings;
import com.sidia.provarest.model.Title;
import com.sidia.provarest.service.ImportService;
import com.sidia.provarest.service.RatingsService;
import com.sidia.provarest.service.TitleService;

@Service
public class ImportServiceImpl implements ImportService {

	private int total = 0;

	@Autowired
	private TitleService service;
	
	@Autowired
	private RatingsService ratingsService;

	public void importTitle() throws IOException {
		List<Title> lista = new ArrayList<Title>();
		BufferedReader reader = lerFile("basics.tsv");
		int i = 0;
		boolean isHeader = true;
		String line;
		Date s = new Date();
		List<String> listGeners;
		while ((line = reader.readLine()) != null) {
			if (isHeader)
				isHeader = false;
			else {
				String[] fields = line.split("\t");
				System.out.println("linha =" + i);
				i = i + 1;
				total = total + 1;
				if (i == 5000) {
					System.out.println(this.total);
					service.saveAll(lista);
					lista = new ArrayList<>();
					i = 0;
				} else {
					listGeners = new ArrayList<String>();
					for (String string : fields[8].split(",")) {
						listGeners.add(string);
					}
					lista.add(new Title(fields[0], fields[1], fields[2], fields[3], Boolean.valueOf(fields[4]),
							fields[5], fields[6], fields[7], listGeners));
				}

			}
		}

		System.out.println(s);
		System.out.println(new Date());
	}
	
	public void importRatings() throws IOException {
		List<Ratings> lista = new ArrayList<Ratings>();
		BufferedReader reader = lerFile("title.ratings.tsv");
		int i = 0;
		boolean isHeader = true;
		String line;
		Date s = new Date();
		List<String> listGeners;
		while ((line = reader.readLine()) != null) {
			if (isHeader)
				isHeader = false;
			else {
				String[] fields = line.split("\t");
				System.out.println("linha =" + i);
				i = i + 1;
				total = total + 1;
				if (i == 5000) {
					System.out.println(this.total);
					ratingsService.saveAll(lista);
					lista = new ArrayList<>();
					i = 0;
				} else {
					Ratings r = new Ratings( fields[0], new Float( fields[1]), Integer.parseInt(fields[2]));
					System.out.println(r.toString());
					lista.add(r);
				}
			}
		}

		System.out.println(s);
		System.out.println(new Date());
	}

	private BufferedReader lerFile(String name) throws FileNotFoundException {
		String path = System.getProperty("user.dir") + "\\data\\" + name;
		System.out.println(path);
		BufferedReader reader = new BufferedReader(new FileReader(path));
		return reader;
	}

	private Title processLine(String[] fields) {
		List<String> listGeners = new ArrayList<String>();
		for (String string : fields[8].split(",")) {
			listGeners.add(string);
		}
		return new Title(fields[0], fields[1], fields[2], fields[3], Boolean.valueOf(fields[4]), fields[5], fields[6],
				fields[7], listGeners);
	}

}