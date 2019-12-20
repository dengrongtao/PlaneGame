package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
   double x,y;   //��ը��λ��
   
   public Explode(double x,double y) {
	   this.x=x;
	   this.y=y;
   }   //��������Ƭ������Ϊ16������
   static Image[] images = new Image[16];//static ����Ҫÿ�ζ�����
   static {
	   for (int i = 0; i < 16; i++) {
		//����ͼƬ
		 images[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
		 images[i].getWidth(null);
	}
   }
   int count;
   public void draw(Graphics g) {
	   if(count <= 15) {
		   g.drawImage(images[count] , (int)x,(int) y, null);
		   count ++;
	   }
   }
}
