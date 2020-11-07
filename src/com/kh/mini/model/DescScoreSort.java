package com.kh.mini.model;

import java.util.Comparator;

public class DescScoreSort implements Comparator<Score>
{
	public int compare(Score s1, Score s2)
	{
		int result = 0;
		
		if(s1.getScore() > s2.getScore())
		{
			result = -1;
		}
		else if(s1.getScore() < s2.getScore())
		{
			result = 1;
		}
		
		return result;
	}
}