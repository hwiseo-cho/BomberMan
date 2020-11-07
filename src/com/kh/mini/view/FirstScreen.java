package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FirstScreen extends JFrame
{ 
	GameScreen gs = new GameScreen();
	RankingScreen rs = new RankingScreen();
	
	ImageIcon i = new ImageIcon("Image/FirstScreen.jpg");
	Image im = i.getImage();

	public void FirstScreen()
	{
		MyPanel panel1 = new MyPanel();
		panel1.setLayout(null);

		JButton btn1 = new JButton("게임시작");
		btn1.setFont(new Font("메이플스토리", Font.BOLD, 30));
		btn1.setBackground(Color.WHITE);
		btn1.setBounds(50, 600, 180, 40);
		panel1.add(btn1);
		btn1.addActionListener(new ActionListener()
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
				
				gs.GameScreen();
				dispose();
			}
		});
		
		JButton btn2 = new JButton("랭킹보기");
		btn2.setFont(new Font("메이플스토리", Font.BOLD, 30));
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(250, 600, 180, 40);
		panel1.add(btn2);		
		btn2.addActionListener(new ActionListener()
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
				
				rs.RankingScreen();
				dispose();
			}
		});
		
		JButton btn3 = new JButton("나가기");
		btn3.setFont(new Font("메이플스토리", Font.BOLD, 30));
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(450, 600, 180, 40);
		panel1.add(btn3);
		btn3.addActionListener(new ActionListener()
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
				
				System.exit(0);
			}
		});

		this.pack();
		this.setTitle("Bomber Man");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel1);
		this.setSize(700, 700);
		this.setVisible(true);
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