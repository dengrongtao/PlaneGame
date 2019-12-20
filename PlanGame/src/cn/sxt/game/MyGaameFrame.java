package cn.sxt.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.JFrame;

@SuppressWarnings("all")
public class MyGaameFrame extends JFrame {
	
	 static Date startDate;
	 static Date endDate;
	 static int period;  //��Ϸ������ʱ��
	 
	 //˫���弼�����ӿ��ͼ���ٶȣ�
	 private Image offScreenImage = null;
	 public void update(Graphics g) {
		 if(offScreenImage == null) {
			 offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
			 //��Ϸ����Ŀ�
			 Graphics goffGraphics = offScreenImage.getGraphics();
			 paint(goffGraphics);
			 g.drawImage(offScreenImage,0,0,null);
		 }
	 }
	 
	 //���ر���ͼƬ���ɻ����ӵ�
	 Image planeImg = GameUtil.getImage("images/plane.png");
	 Image bgImg = GameUtil.getImage("images/bg.jpg");
	 
	 Plane plane = new Plane(planeImg,100,100);
	 Shell [] shells = new Shell[50];//��������ӵ�������
	 Explode explode = null;//��ը����
	 
	 public void paint(Graphics g) {
		 g.drawImage(bgImg, 0, 0, null);
		 //�����ڵ�
		 for (int i = 0; i < 6; i++) {
			 shells[i].drawSelf(g);
			//ʵ�־��ε���ײ��ʵʱ��⣩
			 boolean peng = shells[i].getRectangle().intersects(plane.getRectangle());
			 if (peng) {
				plane.live = false;//�ɻ���ʧ
				if(explode == null) {
					explode = new Explode(plane.x, plane.y);
					endDate = new Date();
					period = (int)(endDate.getTime()-startDate.getTime())/1000;
				}
				explode.draw(g);
			}
			//����ɻ���ը����ӡ���ʱ��
			 if(!plane.live) {
				 Color color = g.getColor();
				 Font font = g.getFont();
				 g.setColor(Color.WHITE);
				 g.setFont(new Font("����",Font.BOLD,25));
				 g.drawString("̽��ʱ�䣺"+period+"�� " ,(int)plane.x,(int)plane.y);
				 g.setColor(color);
				 g.setFont(font);
			 }
		}
		plane.drawSelf(g);//���ɻ�
		
	}
	 //�������Ƿ������ظ������ڣ��ڲ���ʵ�ֶ��̣߳�
	 class PaintThread extends Thread{
		 public void run() {
			 while (true) {
				repaint();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		 }
	 }
	 //��Ӽ��̼������̳���������
	 class KeyMonitor extends KeyAdapter{
		 public void keyPressed(KeyEvent e) {
			 plane.addDirection(e);
			
		}
		 public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	 }
	 
	 //��ʼ������
	 public void launchFrame() {
		 
		 this.setTitle("Plane Game");
		 this.setVisible(true);
		 this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		 this.setLocation(300,300);
		 this.setResizable(false);
		 this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 this.addWindowFocusListener(new WindowAdapter() {
			 public void windowclosing(WindowEvent e) {
				 System.exit(0);
			 }
		});
		new PaintThread().start();//�����ػ����ڵ��߳�
		addKeyListener(new KeyMonitor());//���̼���
		
		//��ʼ��50���ڵ�
		for (int i = 0; i < shells.length; i++) {
			shells[i] = new Shell();
		}
	}
	 
	 public static void main(String[] args) {
	     startDate = new Date();//��¼��Ϸ��ʼʱ��
	     MyGaameFrame f = new MyGaameFrame(); 
	     f.launchFrame();
	}
}
