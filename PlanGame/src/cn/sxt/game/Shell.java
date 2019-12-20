package cn.sxt.game;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("all")
public class Shell extends GameObject {
         double degree;//炮弹的飞行角度
         
         public Shell() {
        	 x = 200;
        	 y = 200;
        	 width = 10;
        	 height = 10;
        	 speed = 0.6;
        	 
        	 degree = Math.random()*Math.PI*2.0;//degree为弧度
         }
         //重写父类的方法
         public void drawSelf(Graphics g) {
        	 Color color = g.getColor();
        	 g.setColor(color.YELLOW);
        	 g.fillOval((int)x, (int)y, width, height);
			//炮弹任意方向去飞
        	 x += speed*Math.cos(degree);
        	 y += speed*Math.sin(degree);
        	 
        	 //碰壁检测
        	if(x<0||x>Constant.GAME_WIDTH-width) {
        		degree = Math.PI - degree;//子弹角度关于y轴翻转
        	}
        	if(y<0+34||y>Constant.GAME_HEIGHT-height) {
        		degree = -degree;
        	}
        	g.setColor(color);
        	
		}
}
