package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("all")
public class Shell extends GameObject {
         double degree;//�ڵ��ķ��нǶ�
         
         public Shell() {
        	 x = 200;
        	 y = 200;
        	 width = 10;
        	 height = 10;
        	 speed = 0.6;
        	 
        	 degree = Math.random()*Math.PI*2.0;//degreeΪ����
         }
         //��д����ķ���
         public void drawSelf(Graphics g) {
        	 Color color = g.getColor();
        	 g.setColor(color.YELLOW);
        	 g.fillOval((int)x, (int)y, width, height);
			//�ڵ����ⷽ��ȥ��
        	 x += speed*Math.cos(degree);
        	 y += speed*Math.sin(degree);
        	 
        	 //���ڼ��
        	if(x<0||x>Constant.GAME_WIDTH-width) {
        		degree = Math.PI - degree;//�ӵ��Ƕȹ���y�ᷭת
        	}
        	if(y<0+34||y>Constant.GAME_HEIGHT-height) {
        		degree = -degree;
        	}
        	g.setColor(color);
        	
		}
}
