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

import com.kh.mini.view.FirstScreen.MyPanel;

public class ContinueScreen extends JFrame
{
	FirstScreen fs = new FirstScreen();
	GameScreen gs = new GameScreen();
	
	ImageIcon i = new ImageIcon("Image/black.jpg");
	Image im = i.getImage();
	
	public void ContinueScreen()
	{
		MyPanel panel1 = new MyPanel();
		panel1.setLayout(null);
		
		JButton btn1 = new JButton("한번 더!");
		panel1.add(btn1);
		
		JButton btn2 = new JButton("시작 화면");
		panel1.add(btn2);

		JButton btn3 = new JButton("게임 종료");
		panel1.add(btn3);
		
		btn1.setBounds(50, 550, 180, 60);
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		btn1.setFont(new Font("메이플스토리", Font.BOLD, 30));
	
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
				System.out.println("확인용" + gs.getScore());
				gs.setScore(gs.getScore());
				dispose();
			}
		});
		
		btn2.setBounds(250, 550, 180, 60);
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		btn2.setFont(new Font("메이플스토리", Font.BOLD, 30));
		
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
				
				fs.FirstScreen();
				dispose();
			}
		});
		
		btn3.setBounds(450, 550, 180, 60);
		btn3.setBackground(Color.BLACK);
		btn3.setForeground(Color.WHITE);
		btn3.setFont(new Font("메이플스토리", Font.BOLD, 30));
		
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