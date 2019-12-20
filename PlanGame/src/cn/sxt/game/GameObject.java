package cn.sxt.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
        Image image;
        double x,y;
        double speed;
        int width,height;
        
        public void drawSelf(Graphics g) {
        	g.drawImage(image,(int)x, (int)y,null);
        	
        }
        public GameObject() {
        	
        }
        public GameObject(Image image,double x,double y) {
        	super();
        	this.image = image;
        	this.x = x;
        	this.y = y;
        }
        public GameObject(Image image,double x,double y,int speed,int width,int height) {
        	super();
        	this.image = image;
        	this.x = x;
        	this.y = y;
        	this.speed = speed;
            this.width = width; 
            this.height = height;
        }//返回图形的外接矩形（便于后续的碰撞检测）
        public Rectangle getRectangle() {
        	return new Rectangle((int)x,(int)y,width,height);
        }
}
