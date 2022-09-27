package com.tms.model;

public class participantDO {
	private int rand;
	private String sname;
	private int age;
	private int height;
	private int weight;
	private char gender;
	private String belt;
	private String dojoName;
	private String senseiName;
	private String address;
	private long mobile;
	private participantDO participant;
	private String tournamentName;

	public int getRand() {
		return rand;
	}
	public void setRand(int rand) {
		this.rand = rand;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getBelt() {
		return belt;
	}
	public void setBelt(String belt) {
		this.belt = belt;
	}
	public String getDojoName() {
		return dojoName;
	}
	public void setDojoName(String dojoName) {
		this.dojoName = dojoName;
	}
	public String getSenseiName() {
		return senseiName;
	}
	public void setSenseiName(String senseiName) {
		this.senseiName = senseiName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public participantDO getParticipant() {
		return participant;
	}
	public void setParticipant(participantDO participant) {
		this.participant = participant;
	}
	public String getTournamentName() {
		return tournamentName;
	}
	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}
}