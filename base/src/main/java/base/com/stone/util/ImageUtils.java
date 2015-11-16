package com.stone.util;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;

import com.stone.base.system.SystemConstants;

public final class ImageUtils {
	/**
	 * 图片水印
	 * @param pressImg 水印图片
	 * @param targetImg 目标图片
	 * @param x 修正值 默认在中间
	 * @param y 修正值 默认在中间
	 * @param alpha 透明度
	 */
	public final static void pressImage(String pressImg, String targetImg, int x, int y, float alpha) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			//水印文件
			Image src_biao = ImageIO.read(new File(pressImg));
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawImage(src_biao, (wideth - wideth_biao) / 2, (height - height_biao) / 2, wideth_biao, height_biao, null);
			//水印文件结束
			g.dispose();
			ImageIO.write(image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 文字水印
	 * @param pressText 水印文字
	 * @param targetImg 目标图片
	 * @param fontName 字体名称
	 * @param fontStyle 字体样式
	 * @param color 字体颜色
	 * @param fontSize 字体大小
	 * @param x 修正值
	 * @param y 修正值
	 * @param alpha 透明度
	 */
	public static void pressText(String pressText, String targetImg, String fontName, int fontStyle, 
   Color color, int fontSize, int x, int y, float alpha) {
		try {
			File img = new File(targetImg);
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			g.drawString(pressText, (width - (getLength(pressText) * fontSize)) / 2 + x, (height - fontSize) / 2 + y);
			g.dispose();
			ImageIO.write(image, "jpg", img);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 	/**  
	      * 缩放图像 
	      * @param srcImageFile 源图像文件地址 
	      * @param result       缩放后的图像地址 
	      * @param scale        缩放倍数
	      */  
	     public static void scale(String srcImageFile, String result, int scale)  
	     {  
	         try  
	         {  
	             BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件  
	             int width = src.getWidth(); // 得到源图宽  
	             int height = src.getHeight(); // 得到源图长  
                 width = width * scale;  
                 height = height * scale;  
	             Image image = src.getScaledInstance(width, height, Image.SCALE_DEFAULT);  
	             BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
	             Graphics g = tag.getGraphics();  
	             g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
	             g.dispose();  
	             ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
	         }  
	         catch (IOException e)  
	         {  
	             e.printStackTrace();  
	         }  
	     }  
	     
	     
	     

		 	 /**  
		      * 缩放图像 
		      * @param srcImageFile 源图像文件地址 
		      * @param result       缩放后的图像地址 
		      * @param maxW         最大宽度
		      * @param maxH         最大高度
		      */  
		     public static void scaleLimitAndPressText(String srcImageFile, String result,int maxW,int maxH)  
		     {  
		         try  
		         {  
		        	 BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件  
		             int w = src.getWidth(); // 得到源图宽  
		             int h = src.getHeight(); // 得到源图长  
		             double scale = (double)w/h;
		        	 double maxScale = (double)maxW/maxH;
			         int newW = 0,newH=0;
			         if(scale>maxScale){
			        	 if(w>maxW){
			        		newW = maxW;
			        		newH = (int) (newW/scale);
			        	 }
			         }else{
			        	 if(h>maxH){
			        		 newH = maxH;
			        		 newW = (int) (newH*scale);
			        	 }
			         }
		             Image image = src.getScaledInstance(newW, newH, Image.SCALE_DEFAULT);  
		             BufferedImage tag = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);  
		             Graphics g = tag.getGraphics();  
		             g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
		             g.dispose();  
		             ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
		         }  
		         catch (IOException e)  
		         {  
		             e.printStackTrace();  
		         }  
		     }  
		     
		     /**
		      * 图片缩放和加水印文字
		      * @param is
		      * @param desPath
		      */
		     public static void defaultScaleLimitAndPressText(InputStream is, String desPath)  
		     {  
		         try{  
		        	 int maxW = SystemConstants.imgMaxW;
		        	 int maxH = SystemConstants.imgMaxH;
		        	 String pressText = SystemConstants.pressText;
		        	 BufferedImage src = ImageIO.read(is); // 读入文件  
		             int w = src.getWidth(); // 得到源图宽  
		             int h = src.getHeight(); // 得到源图长  
		             double scale = (double)w/h;
		        	 double maxScale = (double)maxW/maxH;
			         if(scale>maxScale){
			        	 if(w>maxW){
			        		w = maxW;
			        		h = (int) (w/scale);
			        	 }
			         }else{
			        	 if(h>maxH){
			        		 h = maxH;
			        		 w = (int) (h*scale);
			        	 }
			         }
		             Image image = src.getScaledInstance(w, h, Image.SCALE_DEFAULT);  
		             BufferedImage tag = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
		             Graphics g = tag.getGraphics();  
		             g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
		             g.dispose();  
		             //加水印文字
		 			Graphics2D g2 = tag.createGraphics();
		 			g2.drawImage(src, 0, 0, w, h, null);
		 			g2.setColor(Color.green);
		 			g2.setFont(new Font("黑体", 36, 80));
		 			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.3f));
		 			g2.drawString(pressText, (w - (getLength(pressText) * 80)) / 2 + 0, (h - 80) / 2 + 0);
		 			g2.dispose();
		 			
		            ImageIO.write(tag, "JPEG", new File(desPath));// 输出到文件流  
		         }catch (IOException e){  
		             e.printStackTrace();  
		         }  
		     }  
		     
		     
		     /**
		      * 图片缩放和加水印图标
		      * @param is
		      * @param desPath
		      */
		     public static void defaultScaleLimitAndPressImg(InputStream is, String desPath)  
		     {  
		         try{  
		        	 int maxW = SystemConstants.imgMaxW;
		        	 int maxH = SystemConstants.imgMaxH;
		        	 BufferedImage src = ImageIO.read(is); // 读入文件  
		             int w = src.getWidth(); // 得到源图宽  
		             int h = src.getHeight(); // 得到源图长  
		             double scale = (double)w/h;
		        	 double maxScale = (double)maxW/maxH;
			         if(scale>maxScale){
			        	 if(w>maxW){
			        		w = maxW;
			        		h = (int) (w/scale);
			        	 }
			         }else{
			        	 if(h>maxH){
			        		 h = maxH;
			        		 w = (int) (h*scale);
			        	 }
			         }
		             Image image = src.getScaledInstance(w, h, Image.SCALE_DEFAULT);  
		             BufferedImage tag = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
		             Graphics g = tag.getGraphics();  
		             g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
		             g.dispose();  
		             //加水印文字
		            Graphics2D g2 = tag.createGraphics();
		            Image src_biao = ImageIO.read(new File(SystemConstants.pressLogo));
		 			int wideth_biao = src_biao.getWidth(null);
		 			int height_biao = src_biao.getHeight(null);
		 			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.5f));
		 			g2.drawImage(src_biao, 10, 10, wideth_biao, height_biao, null);
		 			g2.dispose();
		 			
		            ImageIO.write(tag, "JPEG", new File(desPath));// 输出到文件流  
		         }catch (IOException e){  
		             e.printStackTrace();  
		         }  
		     }  
		     
		     
		     
		     
		     public static void scaleLimit(InputStream is, String result,int maxW,int maxH,String pressText)  
		     {  
		         try  
		         {  
		        	 BufferedImage src = ImageIO.read(is); // 读入文件  
		             int w = src.getWidth(); // 得到源图宽  
		             int h = src.getHeight(); // 得到源图长  
		             double scale = (double)w/h;
		        	 double maxScale = (double)maxW/maxH;
			         if(scale>maxScale){
			        	 if(w>maxW){
			        		w = maxW;
			        		h = (int) (w/scale);
			        	 }
			         }else{
			        	 if(h>maxH){
			        		 h = maxH;
			        		 w = (int) (h*scale);
			        	 }
			         }
		             Image image = src.getScaledInstance(w, h, Image.SCALE_DEFAULT);  
		             BufferedImage tag = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
		             Graphics g = tag.getGraphics();  
		             g.drawImage(image, 0, 0, null); // 绘制缩小后的图  
		             g.dispose();  
		             //加水印文字
		 			Graphics2D g2 = tag.createGraphics();
		 			g2.drawImage(src, 0, 0, w, h, null);
		 			g2.setColor(Color.green);
		 			g2.setFont(new Font("黑体", 36, 80));
		 			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.3f));
		 			g2.drawString(pressText, (w - (getLength(pressText) * 80)) / 2 + 0, (h - 80) / 2 + 0);
		 			g2.dispose();
		 			
		            ImageIO.write(tag, "JPEG", new File(result));// 输出到文件流  
		         }  
		         catch (IOException e)  
		         {  
		             e.printStackTrace();  
		         }  
		     }  
		     
		   
	  /**  
	      * 图像切割 
	      * @param srcImageFile 源图像地址 
	      * @param descDir      切片目标文件夹 
	      * @param destWidth    目标切片宽度 
	      * @param destHeight   目标切片高度 
	      */  
	     public static void cut(String srcImageFile, String descDir, int destWidth, int destHeight)  
	     {  
	         try  
	         {  
	             Image img;  
	             ImageFilter cropFilter;  
	             // 读取源图像  
	             BufferedImage bi = ImageIO.read(new File(srcImageFile));  
	             int srcWidth = bi.getHeight(); // 源图宽度  
	             int srcHeight = bi.getWidth(); // 源图高度  
	             if (srcWidth > destWidth && srcHeight > destHeight)  
	             {  
	                 Image image = bi.getScaledInstance(srcWidth, srcHeight, Image.SCALE_DEFAULT);  
	                 destWidth = 200; // 切片宽度  
	                 destHeight = 150; // 切片高度  
	                 int cols = 0; // 切片横向数量  
	                 int rows = 0; // 切片纵向数量  
	                 // 计算切片的横向和纵向数量  
	                 if (srcWidth % destWidth == 0)  
	                 {  
	                     cols = srcWidth / destWidth;  
	                 }  
	                 else  
	                 {  
	                     cols = (int) Math.floor(srcWidth / destWidth) + 1;  
	                 }  
	                 if (srcHeight % destHeight == 0)  
	                 {  
	                     rows = srcHeight / destHeight;  
	                 }  
	                 else  
	                 {  
	                     rows = (int) Math.floor(srcHeight / destHeight) + 1;  
	                 }  
	                 // 循环建立切片  
	                 // 改进的想法:是否可用多线程加快切割速度  
	                 for (int i = 0; i < rows; i++)  
	                 {  
	                     for (int j = 0; j < cols; j++)  
	                     {  
	                         // 四个参数分别为图像起点坐标和宽高  
	                         // 即: CropImageFilter(int x,int y,int width,int height)  
	                         cropFilter = new CropImageFilter(j * 200, i * 150, destWidth, destHeight);  
	                         img = Toolkit.getDefaultToolkit().createImage(  
	                                         new FilteredImageSource(image.getSource(), cropFilter));  
	                         BufferedImage tag = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);  
	                         Graphics g = tag.getGraphics();  
	                         g.drawImage(img, 0, 0, null); // 绘制缩小后的图  
	                         g.dispose();  
	                         // 输出为文件  
	                         ImageIO.write(tag, "JPEG", new File(descDir + "pre_map_" + i + "_" + j + ".jpg"));  
	                     }  
	                 }  
	             }  
	         }  
	         catch (Exception e)  
	         {  
	             e.printStackTrace();  
	         }  
	     }  
	   
	  /**  
	      * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X) 
	      */  
	   
	     public static void convert(String source, String result)  
	     {  
	         try  
	         {  
	             File f = new File(source);  
	             f.canRead();  
	             f.canWrite();  
	             BufferedImage src = ImageIO.read(f);  
	             ImageIO.write(src, "JPG", new File(result));  
	         }  
	         catch (Exception e)  
	         {  
	             // TODO Auto-generated catch block  
	             e.printStackTrace();  
	         }  
	     }  
	   
	  /**  
	      * 彩色转为黑白 
	      * @param source 
	      * @param result 
	      */  
	     public static void gray(String source, String result)  
	     {  
	         try  
	         {  
	             BufferedImage src = ImageIO.read(new File(source));  
	             ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);  
	             ColorConvertOp op = new ColorConvertOp(cs, null);  
	             src = op.filter(src, null);  
	             ImageIO.write(src, "JPEG", new File(result));  
	         }  
	         catch (IOException e)  
	         {  
	             e.printStackTrace();  
	         }  
	     }  
	
	     public static int getLength(String text) {
	 		int length = 0;
	 		for (int i = 0; i < text.length(); i++) {
	 			if (new String(text.charAt(i) + "").getBytes().length > 1) {
	 				length += 2;
	 			} else {
	 				length += 1;
	 			}
	 		}
	 		return length / 2;
	 	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		pressImage("d:/upload/ibm.jpg", "d:/upload/a.jpg", 0, 0, 0.5f);
//		pressText("我是文字水印没办法", "d:/upload/a.jpg", "黑体", 36, Color.yellow, 80, 0, 0, 0.3f);
	//resize("d:/upload/a.jpg", 500, 500, false);
	
//	scaleLimit("d:/upload/a.jpg","d:/upload/11.jpg",200,300);
	//gray("d:/upload/a.jpg","d:/upload/aaa.jpg");
	}
	
}
