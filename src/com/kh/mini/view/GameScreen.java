package com.kh.mini.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameScreen
{	
	private static JFrame frame;
	private static JPanel panel;
	private static JButton button;
	private static JButton button2;
	private static JDialog dialog;
	private static JLabel[][] f;
	private static Random random;

	private static ImageIcon wall = new ImageIcon("Image/wall.png");
	private static ImageIcon grass = new ImageIcon("Image/grass.png");
	private static ImageIcon bomberman = new ImageIcon("Image/bomberman.png");
	private static ImageIcon enemy = new ImageIcon("Image/enemy.png");
	private static ImageIcon enemy2 = new ImageIcon("Image/enemy2.png");
	private static ImageIcon enemy3 = new ImageIcon("Image/enemy3.png");
	private static ImageIcon bomb = new ImageIcon("Image/bomb.png");
	private static ImageIcon onlybomb = new ImageIcon("Image/onlybomb.png");
	private static ImageIcon bombwave = new ImageIcon("Image/bombwave.png");
	private static ImageIcon loseIcon = new ImageIcon("Image/lose.jpg");
	private static ImageIcon winIcon = new ImageIcon("Image/win.jpg");

	private static int bombermanH, bombermanW;						 // 유저의 위치
	private static int enemyH, enemyW;								 // 적 1의 위치
	private static int enemyH2, enemyW2;							 // 적 2의 위치
	private static int enemyH3, enemyW3;							 // 적 3의 위치
	private static int where, start;
	private static int score, count;

	private static Icon temp10, temp11, temp12, temp13, temp14;      // 적 1의 움직임 위치
	private static Icon temp20, temp21, temp22, temp23, temp24;      // 적 2의 움직임 위치
	private static Icon temp30, temp31, temp32, temp33, temp34;      // 적 2의 움직임 위치

	KListener klistener = new KListener();			// 유저
	TListener1 tListener1 = new TListener1();		// 적 1
	TListener2 tListener2 = new TListener2();		// 적 2
	TListener3 tListener3 = new TListener3();		// 적 3
	Plistener pListener = new Plistener();			// 폭탄 터트리기
	Elistener elistener = new Elistener();			// 폭탄 터트린 후 없애기
	Slistener slistener = new Slistener();			// 폭탄 터트린 후 없애기
	BombTime bombtime = new BombTime();				// 폭탄 터지는 거

	Timer t1 = new Timer(500, tListener1);		// 적 1
	Timer t2 = new Timer(500, tListener2);		// 적 2
	Timer t3 = new Timer(500, tListener3);		// 적 3
	Timer p1 = new Timer(2300, pListener);    	// 폭탄 지연 시간
	Timer e1 = new Timer(2600, elistener);		// 폭탄불 없애는 시간
	Timer e2 = new Timer(1, elistener);		
	Timer b1 = new Timer(2601, bombtime);
	Timer s1 = new Timer(1000, slistener);

	public void GameScreen()
	{
		frame = new JFrame();
		button = new JButton(loseIcon);
		button2 = new JButton(winIcon);
		dialog = new JDialog();
		random = new Random();
		panel = new JPanel();

		panel.setLayout(new GridLayout(15,15));
		frame.requestFocus();
		frame.addKeyListener(new KListener());
		button.addActionListener(new Blistener());
		button2.addActionListener(new Blistener());
		f = new JLabel[15][15];

		bombermanH = 12;
		bombermanW = 7;
		enemyH=7;
		enemyW=7;
		enemyH2=8;
		enemyW2=1;
		enemyH3=9;
		enemyW3=12;
		start = 2;
		temp10 = grass;
		temp20 = grass;
		temp30 = grass;
		score = 100;
		count = 3;

		t1.start();
		t2.start();
		t3.start();
		s1.start();
		
		dialog.setSize(700, 700);
		dialog.setVisible(false);

		for(int i = 0; i < 15; i++) 
		{
			for(int j = 0; j < 15; j++)
			{
				f[i][j] = new JLabel(); 
			}
		}

		for(int i = 0; i < 15; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				f[i][j].setIcon(wall);
				f[i][j].addKeyListener(klistener);
				panel.add(f[i][j]);
			}
		}

		f[1][1].setIcon(grass); f[1][3].setIcon(grass);	f[1][4].setIcon(grass);	f[1][5].setIcon(grass);	f[1][6].setIcon(grass);	f[1][7].setIcon(grass);	f[1][8].setIcon(grass);	f[1][9].setIcon(grass);	f[1][10].setIcon(grass); f[1][11].setIcon(grass); f[1][12].setIcon(grass); f[1][13].setIcon(grass);
		f[2][1].setIcon(grass); f[2][3].setIcon(grass); f[2][7].setIcon(grass); f[2][9].setIcon(grass); f[2][12].setIcon(grass); f[2][13].setIcon(grass);
		f[3][1].setIcon(grass); f[3][3].setIcon(grass); f[3][4].setIcon(grass); f[3][5].setIcon(grass); f[3][7].setIcon(grass); f[3][10].setIcon(grass); f[3][11].setIcon(grass); f[3][12].setIcon(grass); f[3][13].setIcon(grass);
		f[4][1].setIcon(grass); f[4][3].setIcon(grass); f[4][5].setIcon(grass); f[4][6].setIcon(grass); f[4][7].setIcon(grass); f[4][8].setIcon(grass); f[4][9].setIcon(grass); f[4][10].setIcon(grass); f[4][11].setIcon(grass); f[4][12].setIcon(grass); f[4][13].setIcon(grass);
		f[5][1].setIcon(grass); f[5][2].setIcon(grass); f[5][3].setIcon(grass); f[5][7].setIcon(grass); f[5][11].setIcon(grass); f[5][12].setIcon(grass);
		f[6][2].setIcon(grass); f[6][5].setIcon(grass); f[6][6].setIcon(grass); f[6][7].setIcon(grass); f[6][8].setIcon(grass); f[6][9].setIcon(grass); f[6][11].setIcon(grass); f[6][13].setIcon(grass);
		f[7][1].setIcon(grass); f[7][2].setIcon(grass); f[7][3].setIcon(grass); f[7][5].setIcon(grass); f[7][6].setIcon(grass); f[7][7].setIcon(enemy); f[7][8].setIcon(grass); f[7][9].setIcon(grass); f[7][11].setIcon(grass); f[7][12].setIcon(grass); f[7][13].setIcon(grass);
		f[8][1].setIcon(enemy2); f[8][7].setIcon(grass); f[8][12].setIcon(grass); f[8][13].setIcon(grass);
		f[9][1].setIcon(grass); f[9][2].setIcon(grass); f[9][3].setIcon(grass); f[9][4].setIcon(grass); f[9][5].setIcon(grass); f[9][6].setIcon(grass); f[9][7].setIcon(grass); f[9][8].setIcon(grass); f[9][9].setIcon(grass); f[9][11].setIcon(grass); f[9][12].setIcon(enemy3);
		f[10][5].setIcon(grass); f[10][6].setIcon(grass); f[10][7].setIcon(grass); f[10][8].setIcon(grass); f[10][9].setIcon(grass); f[10][12].setIcon(grass); f[10][13].setIcon(grass);
		f[11][1].setIcon(grass); f[11][3].setIcon(grass); f[11][5].setIcon(grass); f[11][7].setIcon(grass); f[11][9].setIcon(grass); f[11][11].setIcon(grass); f[11][12].setIcon(grass); f[11][13].setIcon(grass);       
		f[12][1].setIcon(grass); f[12][2].setIcon(grass); f[12][3].setIcon(grass); f[12][4].setIcon(grass); f[12][5].setIcon(grass); f[12][7].setIcon(bomberman); f[12][9].setIcon(grass); f[12][10].setIcon(grass); f[12][11].setIcon(grass); f[12][13].setIcon(grass);
		f[13][1].setIcon(grass); f[13][2].setIcon(grass); f[13][5].setIcon(grass); f[13][6].setIcon(grass);	f[13][7].setIcon(grass); f[13][8].setIcon(grass); f[13][9].setIcon(grass); f[13][10].setIcon(grass); f[13][11].setIcon(grass); f[13][12].setIcon(grass); f[13][13].setIcon(grass);  

		frame.add(panel);
		frame.setSize(700, 700);
		frame.setTitle("Bomber Man");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static int getScore()
	{
		return score;
	}
	public static void setScore(int score)
	{
		GameScreen.score = score;
	}
	public static int getCount()
	{
		return count;
	}
	public static void setCount(int count)
	{
		GameScreen.count = count;
	}

	// 유저 이동 및 폭탄 삽입
	class KListener extends KeyAdapter
	{		
		public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();

			switch(key)
			{
			case KeyEvent.VK_UP :
				if((f[bombermanH - 1][bombermanW].getIcon()).equals(grass)) 
				{
					if(f[bombermanH][bombermanW].getIcon().equals(bomb))        // 폭탄 설치시
					{
						if(f[bombermanH-1][bombermanW].getIcon().equals(grass)) 
						{
							f[bombermanH-1][bombermanW].setIcon(bomberman);
							f[bombermanH][bombermanW].setIcon(onlybomb);
						}
					} 
					else 
					{
						f[bombermanH-1][bombermanW].setIcon(bomberman);
						f[bombermanH][bombermanW].setIcon(grass);
					}
					bombermanH--;
				}

				if((f[bombermanH][bombermanW-1].getIcon()).equals(enemy) || (f[bombermanH][bombermanW-1].getIcon()).equals(enemy2)) 
				{
					dialog.add(button);
					dialog.setVisible(true);
				}
				
				break;

			case KeyEvent.VK_DOWN :
				if((f[bombermanH+1][bombermanW].getIcon()).equals(grass)) 
				{
					if(f[bombermanH][bombermanW].getIcon().equals(bomb)) 
					{
						if(f[bombermanH+1][bombermanW].getIcon().equals(grass)) 
						{
							f[bombermanH+1][bombermanW].setIcon(bomberman);
							f[bombermanH][bombermanW].setIcon(onlybomb);
						}
					} 
					else 
					{
						f[bombermanH+1][bombermanW].setIcon(bomberman);
						f[bombermanH][bombermanW].setIcon(grass);
					}
					bombermanH++;
				}

				if((f[bombermanH][bombermanW+1].getIcon()).equals(enemy) || (f[bombermanH][bombermanW+1].getIcon()).equals(enemy2)) 
				{
					dialog.add(button);
					dialog.setVisible(true);
				}
				

				break;

			case KeyEvent.VK_LEFT :
				if((f[bombermanH][bombermanW-1].getIcon()).equals(grass)) 
				{
					if(f[bombermanH][bombermanW].getIcon().equals(bomb)) 
					{
						if(f[bombermanH][bombermanW-1].getIcon().equals(grass)) 
						{
							f[bombermanH][bombermanW-1].setIcon(bomberman);
							f[bombermanH][bombermanW].setIcon(onlybomb);
						}
					} 
					else 
					{
						f[bombermanH][bombermanW-1].setIcon(bomberman);
						f[bombermanH][bombermanW].setIcon(grass);
					}
					bombermanW--;
				}

				if((f[bombermanH][bombermanW-1].getIcon()).equals(enemy) || (f[bombermanH][bombermanW-1].getIcon()).equals(enemy2)) 
				{
					dialog.add(button);
					dialog.setVisible(true);
				}

				break;

			case KeyEvent.VK_RIGHT :
				if((f[bombermanH][bombermanW+1].getIcon()).equals(grass))
				{
					if(f[bombermanH][bombermanW].getIcon().equals(bomb)) 
					{
						if(f[bombermanH][bombermanW+1].getIcon().equals(grass))
						{
							f[bombermanH][bombermanW+1].setIcon(bomberman);
							f[bombermanH][bombermanW].setIcon(onlybomb);
						}
					} 
					else
					{
						f[bombermanH][bombermanW+1].setIcon(bomberman);
						f[bombermanH][bombermanW].setIcon(grass);
					}
					bombermanW++;
				}

				if((f[bombermanH][bombermanW+1].getIcon()).equals(enemy) || (f[bombermanH][bombermanW+1].getIcon()).equals(enemy2)) 
				{
					dialog.add(button);
					dialog.setVisible(true);
				}

				break;

			case KeyEvent.VK_SPACE :
				if(f[bombermanH][bombermanW].getIcon().equals(bomberman)) 
				{
					f[bombermanH][bombermanW].setIcon(bomb);
					p1.start();
					System.out.println("p1.start");
					e1.start();
					System.out.println("e1.start");
					b1.restart();
					score -= 2;
				}
			}
		}
	}

	// 적1
	class TListener1 implements ActionListener 
	{   
		public void actionPerformed(ActionEvent event)
		{
			if(start <= 0)
			{
				where = 1 + random.nextInt(4);
			}
			else
			{ 
				where = 1; start--;
			}
			switch(where) 
			{
			case 1:
				if(!(f[enemyH-1][enemyW].getIcon().equals(wall)) && !(f[enemyH-1][enemyW].getIcon().equals(onlybomb)) && !(f[enemyH-1][enemyW].getIcon().equals(bombwave)))
				{
					temp11 = f[enemyH-1][enemyW].getIcon();
					f[enemyH-1][enemyW].setIcon(enemy);
					f[enemyH][enemyW].setIcon(temp10);
					temp10 = temp11;
					enemyH--;
				}
				break;

			case 2:
				if(!(f[enemyH+1][enemyW].getIcon().equals(wall)) && !(f[enemyH+1][enemyW].getIcon().equals(onlybomb)) && !(f[enemyH+1][enemyW].getIcon().equals(bombwave))) 
				{
					temp12=f[enemyH+1][enemyW].getIcon();
					f[enemyH+1][enemyW].setIcon(enemy);
					f[enemyH][enemyW].setIcon(temp10);
					temp10 = temp12;
					enemyH++;
				}
				break;

			case 3:
				if(!(f[enemyH][enemyW-1].getIcon().equals(wall)) && !(f[enemyH][enemyW-1].getIcon().equals(onlybomb)) && !(f[enemyH][enemyW-1].getIcon().equals(bombwave))) 
				{
					temp13=f[enemyH][enemyW-1].getIcon();
					f[enemyH][enemyW-1].setIcon(enemy);
					f[enemyH][enemyW].setIcon(temp10);
					temp10 = temp13;
					enemyW--;
				}
				break;

			case 4:
				if(!(f[enemyH][enemyW+1].getIcon().equals(wall)) && !(f[enemyH][enemyW+1].getIcon().equals(onlybomb)) && !(f[enemyH][enemyW+1].getIcon().equals(bombwave))) 
				{
					temp14=f[enemyH][enemyW+1].getIcon();
					f[enemyH][enemyW+1].setIcon(enemy);
					f[enemyH][enemyW].setIcon(temp10);
					temp10 = temp14;
					enemyW++;
				}
				break;
			}

			if(enemyH2 == bombermanH && enemyW2 == bombermanW) 
			{
				dialog.add(button);
				dialog.setVisible(true);
			}
		}
	}

	// 적2
	class TListener2 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(start <= 0)
			{
				where = 1 + random.nextInt(4);
			}
			else 
			{ 
				where = 1; start--;
			}
			switch(where) 
			{
			case 1:
				if(!(f[enemyH2-1][enemyW2].getIcon().equals(wall)) && !(f[enemyH2-1][enemyW2].getIcon().equals(onlybomb)) && !(f[enemyH2-1][enemyW2].getIcon().equals(bombwave))) 
				{
					temp21 = f[enemyH2-1][enemyW2].getIcon();
					f[enemyH2-1][enemyW2].setIcon(enemy2);
					f[enemyH2][enemyW2].setIcon(temp20);
					temp20 = temp21;
					enemyH2--;
				}
				break;
			case 2:
				if(!(f[enemyH2+1][enemyW2].getIcon().equals(wall)) && !(f[enemyH2+1][enemyW2].getIcon().equals(onlybomb)) && !(f[enemyH2+1][enemyW2].getIcon().equals(bombwave))) 
				{
					temp22 = f[enemyH2+1][enemyW2].getIcon();
					f[enemyH2+1][enemyW2].setIcon(enemy2);
					f[enemyH2][enemyW2].setIcon(temp20);
					temp20 = temp22;
					enemyH2++;
				}
				break;
			case 3:
				if(!(f[enemyH2][enemyW2-1].getIcon().equals(wall)) && !(f[enemyH2][enemyW2-1].getIcon().equals(onlybomb)) && !(f[enemyH2][enemyW2-1].getIcon().equals(bombwave))) 
				{
					temp23=f[enemyH2][enemyW2-1].getIcon();
					f[enemyH2][enemyW2-1].setIcon(enemy2);
					f[enemyH2][enemyW2].setIcon(temp20);
					temp20 = temp23;
					enemyW2--;
				}
				break;
			case 4:
				if(!(f[enemyH2][enemyW2+1].getIcon().equals(wall)) && !(f[enemyH2][enemyW2+1].getIcon().equals(onlybomb)) && !(f[enemyH2][enemyW2+1].getIcon().equals(bombwave))) 
				{
					temp24=f[enemyH2][enemyW2+1].getIcon();
					f[enemyH2][enemyW2+1].setIcon(enemy2);
					f[enemyH2][enemyW2].setIcon(temp20);
					temp20 = temp24;
					enemyW2++;
				}
				break;
			}

			if(enemyH2==bombermanH && enemyW2==bombermanW) 
			{
				dialog.add(button);
				dialog.setVisible(true);
			}
		}  
	}

	// 적3
	class TListener3 implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(start <= 0)
			{
				where = 1 + random.nextInt(4);
			}
			else 
			{ 
				where = 1; start--;
			}
			switch(where) 
			{
			case 1:
				if(!(f[enemyH3-1][enemyW3].getIcon().equals(wall)) && !(f[enemyH3-1][enemyW3].getIcon().equals(onlybomb)) && !(f[enemyH3-1][enemyW3].getIcon().equals(bombwave))) 
				{
					temp31 = f[enemyH3-1][enemyW3].getIcon();
					f[enemyH3-1][enemyW3].setIcon(enemy3);
					f[enemyH3][enemyW3].setIcon(temp30);
					temp30 = temp31;
					enemyH3--;
				}
				break;
				
			case 2:
				if(!(f[enemyH3+1][enemyW3].getIcon().equals(wall)) && !(f[enemyH3+1][enemyW3].getIcon().equals(onlybomb)) && !(f[enemyH3+1][enemyW3].getIcon().equals(bombwave))) 
				{
					temp32 = f[enemyH3+1][enemyW3].getIcon();
					f[enemyH3+1][enemyW3].setIcon(enemy3);
					f[enemyH3][enemyW3].setIcon(temp30);
					temp30 = temp32;
					enemyH3++;
				}
				break;
			case 3:
				if(!(f[enemyH3][enemyW3-1].getIcon().equals(wall)) && !(f[enemyH3][enemyW3-1].getIcon().equals(onlybomb)) && !(f[enemyH3][enemyW3-1].getIcon().equals(bombwave))) 
				{
					temp33=f[enemyH3][enemyW3-1].getIcon();
					f[enemyH3][enemyW3-1].setIcon(enemy3);
					f[enemyH3][enemyW3].setIcon(temp30);
					temp30 = temp33;
					enemyW3--;
				}
				break;
			case 4:
				if(!(f[enemyH3][enemyW3+1].getIcon().equals(wall)) && !(f[enemyH3][enemyW3+1].getIcon().equals(onlybomb)) && !(f[enemyH3][enemyW3+1].getIcon().equals(bombwave))) 
				{
					temp34=f[enemyH3][enemyW3+1].getIcon();
					f[enemyH3][enemyW3+1].setIcon(enemy3);
					f[enemyH3][enemyW3].setIcon(temp30);
					temp30 = temp34;
					enemyW3++;
				}
				break;
			}

			if(enemyH3==bombermanH && enemyW3==bombermanW) 
			{
				dialog.add(button);
				dialog.setVisible(true);
			}
		}  
	}

	// 폭탄 터트리기
	class Plistener implements ActionListener
	{ 
		public void actionPerformed(ActionEvent event)
		{
			for (int i = 0; i < 15; i++) 
			{
				for(int j = 0; j < 15; j++)
				{
					if(f[i][j].getIcon().equals(bomb) || f[i][j].getIcon().equals(onlybomb))
					{
						// 폭탄 주위에 벽
						if(!f[i+1][j].getIcon().equals(wall))
						{
							// 폭탄 주위에 유저
							if(f[i+1][j].getIcon().equals(bomberman)) 
							{
								dialog.add(button);
								dialog.setVisible(true);      
							}
							// 폭탄 주위에 적
							if(f[i+1][j].getIcon().equals(enemy))
							{
								enemyH = 0;
								enemyW = 0;
								score += 150;
								count--;
								System.out.println(score + " : " + count);
								f[i+1][j].setIcon(bombwave);;
								t1.stop();
							}
							if(f[i+1][j].getIcon().equals(enemy2))
							{
								enemyH2 = 0;
								enemyW2 = 0;
								score += 120;
								count--;
								System.out.println(score + " : " + count);
								f[i+1][j].setIcon(bombwave);
								t2.stop();
							}
							if(f[i+1][j].getIcon().equals(enemy3))
							{
								enemyH3 = 0;
								enemyW3 = 0;
								score += 100;
								count--;
								System.out.println(score + " : " + count);
								f[i+1][j].setIcon(bombwave);
								t3.stop();
							}
							else
							{
								f[i+1][j].setIcon(bombwave);
							}
						}

						if(!f[i-1][j].getIcon().equals(wall))
						{
							if(f[i-1][j].getIcon().equals(bomberman))
							{
								dialog.add(button);
								dialog.setVisible(true);
							}
							if(f[i-1][j].getIcon().equals(enemy))
							{
								enemyH = 0;
								enemyW = 0;
								score += 150;
								count--;
								System.out.println(score + " : " + count);
								t1.stop();
								f[i-1][j].setIcon(bombwave);
							}
							if(f[i-1][j].getIcon().equals(enemy2))
							{
								enemyH2 = 0;
								enemyW2 = 0;
								score += 120;
								count--;
								System.out.println(score + " : " + count);
								t2.stop();
								f[i-1][j].setIcon(bombwave);
							}
							if(f[i-1][j].getIcon().equals(enemy3))
							{
								enemyH3 = 0;
								enemyW3 = 0;
								score += 100;
								count--;
								System.out.println(score + " : " + count);
								t3.stop();
								f[i-1][j].setIcon(bombwave);
							}
							else
							{
								f[i-1][j].setIcon(bombwave);
							}
						}

						if(!f[i][j+1].getIcon().equals(wall))
						{
							if(f[i][j+1].getIcon().equals(bomberman))
							{
								dialog.add(button);
								dialog.setVisible(true);
							}
							if(f[i][j+1].getIcon().equals(enemy))
							{
								enemyH = 0;
								enemyW = 0;
								score += 150;
								count--;
								System.out.println(score + " : " + count);
								f[i][j+1].setIcon(bombwave);
								t1.stop();
							}
							if(f[i][j+1].getIcon().equals(enemy2))
							{
								enemyH2 = 0;
								enemyW2 = 0;
								score += 120;
								count--;
								System.out.println(score + " : " + count);
								f[i][j+1].setIcon(bombwave);
								t2.stop();
							}
							if(f[i][j+1].getIcon().equals(enemy3))
							{
								enemyH3 = 0;
								enemyW3 = 0;
								score += 100;
								count--;
								System.out.println(score + " : " + count);
								f[i][j+1].setIcon(bombwave);
								t3.stop();
							}
							else
							{
								f[i][j+1].setIcon(bombwave);
							}
						}

						if(!f[i][j-1].getIcon().equals(wall))
						{            
							if(f[i][j-1].getIcon().equals(bomberman))
							{            
								dialog.add(button);
								dialog.setVisible(true);
							}
							if(f[i][j-1].getIcon().equals(enemy))
							{            
								enemyH = 0;
								enemyW = 0;
								score += 150;
								count--;
								System.out.println(score + " : " + count);
								f[i][j-1].setIcon(bombwave);
								t1.stop();
							}
							if(f[i][j-1].getIcon().equals(enemy2))
							{            
								enemyH2 = 0;
								enemyW2 = 0;
								score += 120;
								count--;
								System.out.println(score + " : " + count);
								f[i][j-1].setIcon(bombwave);
								t2.stop();
							}
							if(f[i][j-1].getIcon().equals(enemy3))
							{            
								enemyH3 = 0;
								enemyW3 = 0;
								score += 100;
								count--;
								System.out.println(score + " : " + count);
								f[i][j-1].setIcon(bombwave);
								t3.stop();
							}
							else
							{
								f[i][j-1].setIcon(bombwave);
							}
						}

						if(!f[i][j].getIcon().equals(wall))
						{            
							if(f[i][j].getIcon().equals(bomberman) || f[i][j].getIcon().equals(bomb))
							{            
								dialog.add(button);
								dialog.setVisible(true);
							}
							if(f[i][j].getIcon().equals(enemy))
							{            
								enemyH = 0;
								enemyW = 0;
								score += 150;
								count--;
								System.out.println(score + " : " + count);
								f[i][j].setIcon(bombwave);
								t1.stop();
							}
							if(f[i][j].getIcon().equals(enemy2))
							{       
								enemyH2 = 0;
								enemyW2 = 0;
								score += 120;
								count--;
								System.out.println(score + " : " + count);
								f[i][j].setIcon(bombwave);
								t2.stop();
							}
							if(f[i][j].getIcon().equals(enemy3))
							{       
								enemyH3 = 0;
								enemyW3 = 0;
								score += 100;
								count--;
								System.out.println(score + " : " + count);
								f[i][j].setIcon(bombwave);
								t3.stop();
							}
							else
							{
								f[i][j].setIcon(bombwave);
							}
						}
					} 
				}
			}
		}
	}

	// 폭탄 터트린 후 없애기
	class Elistener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			for (int i = 0; i < 15; i++) 
			{
				for(int j = 0; j < 15; j++)
				{
					if(f[i][j].getIcon().equals(bombwave)) 
					{
						if(f[i][j].getIcon().equals(enemy))
						{
							t1.stop();
							f[i][j].setIcon(grass);
						}
						else if(f[i][j].getIcon().equals(enemy2))
						{
							t2.stop();
							f[i][j].setIcon(grass);
						}
						else if(f[i][j].getIcon().equals(enemy3))
						{
							t3.stop();
							f[i][j].setIcon(grass);
						}
						else
						{
							f[i][j].setIcon(grass);
						}
					}
				}
			}
		}
	}

	// 졌을때
	class Blistener implements ActionListener 
	{
		RecordScreen rs = new RecordScreen();
		public void actionPerformed(ActionEvent event)
		{
			s1.stop();
			rs.RecordScreen();
			t1.stop();
			t2.stop();
			t3.stop();
			frame.dispose();
		}
	}
	
	// 이겼을 때
	class Slistener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			if(count == 0)
			{
				dialog.add(button2);
				dialog.setVisible(true);
				s1.stop();
				frame.dispose();
			}
			System.out.println(score);
		}
	}
	
	// 폭탄 터지는 거
	class BombTime implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			p1.stop();
			e1.stop();
			
			for (int i = 0; i < 15; i++)
			{
				for (int j = 0; j < 15; j++)
				{
					if(f[i][j].getIcon().equals(bombwave))
					{
						e2.restart();
					}
					if(!f[i][j].getIcon().equals(bombwave))
					{
						e2.stop();
					}
				}
			}
		}
	}
	
	class what implements ActionListener {
		String str;
		String str1;
		String str2;
		String str3;

		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
	}
}