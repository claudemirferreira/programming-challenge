package com.sidia.provarest.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidia.provarest.model.Ratings;
import com.sidia.provarest.model.Title;
import com.sidia.provarest.repository.RatingsRepository;
import com.sidia.provarest.repository.TitleRepository;
import com.sidia.provarest.service.ImportTsvService;

@Service
public class ImportTsvServiceImpl implements ImportTsvService {

	@Autowired
	private TitleRepository titleRepository;
	
	@Autowired
	private RatingsRepository ratingsRepository;

	public void importTitle() throws IOException {
		String path = System.getProperty("user.dir") +"\\data\\basics.tsv";
		System.out.println(path);
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		List<String> listGeners;
		int i = 1;
		boolean isHeader = true;
		while ((line = reader.readLine()) != null) {
			String[] fields = line.split("\t");
			if (isHeader)
				isHeader = false;
			else {
				listGeners = new ArrayList<String>();
				for (String string : fields[8].split(",")) {
					listGeners.add(string);
				}
				i = i + 1;
				System.out.println(i);
				titleRepository.save(new Title(fields[0], fields[1], fields[2], fields[3], Boolean.valueOf(fields[4]),
						fields[5], fields[6], fields[7], listGeners));
				if (i > 200)
					break;
			}
		}
		reader.close();

	}
	
	public void importRatings() throws IOException {
		String path = System.getProperty("user.dir") +"\\data\\title.ratings.tsv";
		System.out.println(path);
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line;
		int i = 1;
		boolean isHeader = true;
		while ((line = reader.readLine()) != null) {
			String[] fields = line.split("\t");
			if (isHeader)
				isHeader = false;
			else {
				
				i = i + 1;
				System.out.println(i);
				ratingsRepository.save(new Ratings(null, fields[0], Float.parseFloat( fields[1]), Integer.parseInt(fields[2])));
				if (i > 200)
					break;
			}
		}
		reader.close();

	}

	public List<Title> findAll() {
		return titleRepository.findAll();
	}
}