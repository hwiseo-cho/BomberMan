package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.model.Ranking;
import com.kh.mini.model.Score;

public class RankingScreen
{	
	Ranking rt = new Ranking();
	ImageIcon i = new ImageIcon("Image/white.jpg");
	Image im = i.getImage();
	
	public void RankingScreen()
	{
		FirstScreen fs = new FirstScreen();
		ArrayList<Score> rank = new ArrayList<Score>();
		rank = rt.fileOpen();
		
		JFrame frame = new JFrame();
		MyPanel mypanel = new MyPanel();
		mypanel.setLayout(null);
		
		String str = "Ranking";
		JLabel j = new JLabel(str);
		j.setFont(new Font("메이플스토리",Font.BOLD,30));
		j.setBounds(410, 50, 250, 60);

		String str1 = "1위   " + rank.get(0).getName() + "   " + rank.get(0).getScore();
		JLabel j1 = new JLabel(str1);
		j1.setFont(new Font("메이플스토리",Font.BOLD,30));
		j1.setBounds(410, 100, 250, 60);
		
		String str2 = "2위   " + rank.get(1).getName() + "   " + rank.get(1).getScore();
		JLabel j2 = new JLabel(str2);
		j2.setFont(new Font("메이플스토리",Font.BOLD,30));
		j2.setBounds(410, 150, 250, 60);

		String str3 = "3위   " + rank.get(2).getName() + "   " + rank.get(2).getScore();
		JLabel j3 = new JLabel(str3);
		j3.setFont(new Font("메이플스토리",Font.BOLD,30));
		j3.setBounds(410, 200, 250, 60);
		
		String str4 = "4위   " + rank.get(3).getName() + "   " + rank.get(3).getScore();
		JLabel j4 = new JLabel(str4);
		j4.setFont(new Font("메이플스토리",Font.BOLD,30));
		j4.setBounds(410, 250, 250, 60);
		
		JPanel panel5 = new JPanel();
		String str5 = "5위   " + rank.get(4).getName() + "   " + rank.get(4).getScore();
		JLabel j5 = new JLabel(str5);
		j5.setFont(new Font("메이플스토리", Font.BOLD, 30));
		j5.setBounds(410, 300, 250, 60);	
		
		JButton btn = new JButton("시작 화면");
		btn.setBounds(410, 500, 200, 60);
		btn.setBackground(Color.WHITE);
		btn.setFont(new Font("메이플스토리", Font.BOLD, 30));
		
		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Thread.sleep(0);
				}
				catch(InterruptedException ex) 
				{
					ex.printStackTrace();
				}
				
				fs.FirstScreen();
				frame.dispose();
			}
		});
		
		frame.add(mypanel);
		mypanel.add(j);
		mypanel.add(j1);
		mypanel.add(j2);
		mypanel.add(j3);
		mypanel.add(j4);
		mypanel.add(j5);
		mypanel.add(btn);
		
		frame.setSize(700, 700);
		frame.setTitle("Bomber Man");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class MyPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(im, 0, 0, getWidth(), getHeight(), this);
		}
	}
}