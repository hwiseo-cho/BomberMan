package com.kh.mini.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.mini.view.GameScreen;

public class Ranking
{
	private String fileName;
	private int filescore;

	public void fileSave(String name, int score)
	{
		GameScreen gs = new GameScreen();
//		Scanner sc = new Scanner(System.in);
//
//		System.out.print("이름을 입력하시오 : ");
//		fileName = sc.nextLine();
		this.fileName = name;
		this.filescore = score;

		ArrayList aList = new ArrayList();

		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Ranking.txt"));)
		{
			aList = (ArrayList)oin.readObject();
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		aList.add(new Score(fileName, filescore));

		try(ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream("Ranking.txt"));)
		{
			oOut.writeObject(aList);

			oOut.flush();

			System.out.println("객체 저장이 완료되었습니다.");
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public ArrayList<Score> fileOpen()
	{
		ArrayList<Score> aList = new ArrayList<Score>();

		try(ObjectInputStream oin = new ObjectInputStream(new FileInputStream("Ranking.txt"));)
		{
			aList = (ArrayList)oin.readObject();
			
			aList.sort(new DescScoreSort());
			
			for (Object obj : aList) 
			{
				System.out.println(obj);
			}
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return aList;
	}
}