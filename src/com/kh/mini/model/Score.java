package com.kh.mini.model;

import java.io.Serializable;

public class Score implements Serializable
{
	private static final long serialVersionUID = 3799235693248447677L;

	private String name;
	private int score;

	public Score() {}

	public Score(String name, int score)
	{
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() 
	{
		return "name = " + name + ", score = " + score;
	}
}