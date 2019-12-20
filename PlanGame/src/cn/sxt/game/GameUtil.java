package cn.sxt.game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public class GameUtil {
      //工具类最好将构造器私有化   这样就不可以被实例化了
	private  GameUtil() {
		}
	public static Image getImage(String path) {
		BufferedImage bufferedImage = null;
		try {
			URL url = GameUtil.class.getClassLoader().getResource(path);
			bufferedImage = ImageIO.read(url);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bufferedImage;
	}
}
