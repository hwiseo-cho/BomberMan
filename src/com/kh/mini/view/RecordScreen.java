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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.model.Ranking;

public class RecordScreen extends JFrame
{
	ContinueScreen cs = new ContinueScreen();
	ImageIcon i = new ImageIcon("Image/white.jpg");
	Image im = i.getImage();

	public void RecordScreen()
	{
		GameScreen gs = new GameScreen();
		Ranking rk = new Ranking();
		
		JTextField name = new JTextField(10);
		JTextField result = new JTextField(10);
		JButton btn = new JButton();
		MyPanel mypanel = new MyPanel();
		mypanel.setLayout(null);
		
		String str = "점수 입력하기";
		JLabel label = new JLabel(str);
		label.setFont(new Font("메이플스토리", Font.BOLD, 30));
		label.setBounds(350, 50, 250, 60);

		String nameStr = "이름 : ";
		JLabel nameLabel = new JLabel(nameStr);
		nameLabel.setFont(new Font("메이플스토리", Font.BOLD, 30));
		nameLabel.setBounds(350, 120, 250, 60);
		name.setFont(new Font("메이플스토리", Font.BOLD, 30));
		name.setBounds(440, 120, 200, 60);

		String resultStr = "점수 : ";
		JLabel resultLabel = new JLabel(resultStr);
		resultLabel.setFont(new Font("메이플스토리", Font.BOLD, 30));
		resultLabel.setBounds(350, 200, 250, 60);
		result.setText(gs.getScore() + "");
		result.setFont(new Font("메이플스토리", Font.BOLD, 30));
		result.setBounds(440, 200, 200, 60);
		result.setEditable(false);

		btn = new JButton("확인");
		btn.setFont(new Font("메이플스토리", Font.BOLD, 50));
		btn.setBackground(Color.WHITE);
		btn.setBounds(440, 280, 200, 60);

		btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = name.getText();
				rk.fileSave(input, gs.getScore());
				gs.setScore(gs.getScore());
				System.out.println("확인용" + gs.getScore());
				cs.ContinueScreen();
				dispose();
			}
		});

		this.add(mypanel);
		mypanel.add(label);
		mypanel.add(nameLabel);
		mypanel.add(name);
		mypanel.add(resultLabel);
		mypanel.add(result);
		mypanel.add(btn);		

		this.setSize(700, 700);
		this.setTitle("BomberMan");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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