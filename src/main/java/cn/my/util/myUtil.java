package cn.my.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.imageio.ImageIO;

public class myUtil {
	/*
	 * 生成中文图片验证码
	 * 
	 * @throws Exception
	 */
	public static void generateImgCode() throws Exception {
	 
		// 随机生成字体
		String[] fontTypes = { "\u5b8b\u4f53", "\u65b0\u5b8b\u4f53",
				"\u9ed1\u4f53", "\u6977\u4f53", "\u96b6\u4e66" };
	 
		// 设置图片的长宽
		int width = 176, height = 30;
	 
		// 创建内存图像
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
	 
		// 获取图形上下文
		Graphics g = image.getGraphics();
	 
		// 创建随机类的实例
		Random random = new Random();
	 
		// 设定图像背景色(因为是做背景，所以偏淡)
		g.setColor(getRandColor(random, 200, 250));
		g.fillRect(0, 0, width, height);
	 
		// 在图片背景上增加噪点
		g.setColor(getRandColor(random, 160, 200));
		g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		for (int i = 0; i < 6; i++) {
			g.drawString("****************************", 0, 5 * (i + 2));
		}
	 
		// 保存生成的汉字字符串
		String sRand = "";
		for (int i = 0; i < 6; i++) {
	 
			// 取随机产生的汉字
			String rand = getRandomChar();
	 
			sRand += rand;
	 
			// 设置字体的颜色
			g.setColor(getRandColor(random, 10, 150));
			// 设置字体
			g.setFont(new Font(fontTypes[random.nextInt(fontTypes.length)],
					Font.BOLD, 18 + random.nextInt(6)));
			// 将此汉字画到图片上
			g.drawString(rand, 24 * i + 10 + random.nextInt(8), 24);
		}
	 
		g.dispose();
	 
		// 设置页面不缓存
		// response.setHeader("Pragma", "No-cache");
		// response.setHeader("Cache-Control", "no-cache");
		// response.setDateHeader("Expires", 0);
		// 输出到页面
		// ImageIO.write(image, "JPEG", response.getOutputStream());
	 
		// 输出验证码
		System.out.println("aaaaaaa   "+sRand);
		 

		// 输出图象
		OutputStream os = new FileOutputStream(new File("d:/imgCode.jpg"));
		ImageIO.write(image, "JPEG", os);
	}
	 
	/**
	 * 生成随机汉字 原理是从汉字区位码找到汉字 在汉字区位码中分高位与底位， 其中有简体又有繁体，位数越前生成的汉字繁体的机率越大。
	 * 在本例中高位从171取，底位从161取， 去掉大部分的繁体和生僻字，但仍然会有！！
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getRandomChar() throws UnsupportedEncodingException {
		String str = null;
	 
		// 定义高低位
		int hightPos, lowPos;
	 
		Random random = new Random();
	 
		// 获取高位值
		hightPos = (176 + Math.abs(random.nextInt(39)));
	 
		// 获取低位值
		lowPos = (161 + Math.abs(random.nextInt(93)));
	 
		byte[] b = new byte[2];
	 
		b[0] = (new Integer(hightPos).byteValue());
	 
		b[1] = (new Integer(lowPos).byteValue());
	 
		// 转成中文
		str = new String(b, "GBk");
	 
		return str;
	}
	 
	/**
	 * 生成随机颜色
	 * 
	 * @param random
	 * @param fc
	 * @param bc
	 * @return
	 */
	private static Color getRandColor(Random random, int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	  
	public static void main(String[] arg){
		
		myUtil my = new myUtil();
		try {
			my.generateImgCode();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
