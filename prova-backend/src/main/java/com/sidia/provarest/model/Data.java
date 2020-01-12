package com.sidia.provarest.model;

import java.util.List;

public class Data {

	private String nconst;

	private String primaryName;

	private String birthYear;

	private String deathYear;

	private String primaryProfession;

	private String knownForTitles;

	public Data() {
	}

	public Data(List<String> dataArray) {
		this.nconst = dataArray.get(0);
		this.primaryName = dataArray.get(1);
		this.birthYear = dataArray.get(2);
		this.deathYear = dataArray.get(3);
		this.primaryProfession = dataArray.get(4);
		if("Gary Ross" == dataArray.get(5)) {
			System.out.println("=================");
			System.out.println("dataArray =" + dataArray);
			System.out.println("=================");
		}
		this.knownForTitles = dataArray.get(5);
	}

	public Data(String nconst, String primaryName, String birthYear, String deathYear, String primaryProfession,
			String knownForTitles) {
		this.nconst = nconst;
		this.primaryName = primaryName;
		this.birthYear = birthYear;
		this.deathYear = deathYear;
		this.primaryProfession = primaryProfession;
		this.knownForTitles = knownForTitles;
	}

	public String getNconst() {
		return nconst;
	}

	public void setNconst(String nconst) {
		this.nconst = nconst;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getDeathYear() {
		return deathYear;
	}

	public void setDeathYear(String deathYear) {
		this.deathYear = deathYear;
	}

	public String getPrimaryProfession() {
		return primaryProfession;
	}

	public void setPrimaryProfession(String primaryProfession) {
		this.primaryProfession = primaryProfession;
	}

	public String getKnownForTitles() {
		return knownForTitles;
	}

	public void setKnownForTitles(String knownForTitles) {
		this.knownForTitles = knownForTitles;
	}

	public String toString() {
		return " nconst =" + this.nconst + "\n primaryName =" + primaryName + "\n birthYear =" + birthYear
				+ "\n deathYear =" + deathYear + "\n primaryProfession =" + primaryProfession + "\n knownForTitles ="
				+ knownForTitles;
	}

}