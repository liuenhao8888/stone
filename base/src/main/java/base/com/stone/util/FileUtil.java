package com.stone.util;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class FileUtil {
	
	public static String getSuffix(String fileName){
		int index = fileName.lastIndexOf(".");
		return fileName.substring(index+1);
	}
	
	public static String getNewFileName(String fileName){
		return System.currentTimeMillis()+"_"+RandomUtil.getRandom(5)+"."+getSuffix(fileName);
	}
	
	public   static   void  createPreviewImage(String srcFile, String destFile){
		     try    {
		         File fi  =   new  File(srcFile);  //  src
		         File fo  =   new  File(destFile);  //  dest
		         BufferedImage bis  =  ImageIO.read(fi);
		         int  w  =  bis.getWidth();
		         int  h  =  bis.getHeight();
		         double  scale  =  ( double )w / h;
		         
		         //div 400*400
		         int divW = 400;
		         int divH = 400;
		         double divScale = (double)divW/divH;
		         int newW = 0,newH=0;
		         if(scale>divScale){
		        	 if(w>divW){
		        		newW = divW;
		        		newH = (int) (newW/scale);
		        	 }
		         }else{
		        	 if(h>divH){
		        		 newH = divH;
		        		 newW = (int) (newH*scale);
		        	 }
		         }
//		         double sx = (double)newW/w;
//		         double sy = (double)newH/h;
//		         AffineTransform transform = new AffineTransform();
//		        transform.setToScale(sx,sy);
//		        AffineTransformOp ato  =   new  AffineTransformOp(transform,  null );
		        BufferedImage bid  =   new  BufferedImage(newW, newH, BufferedImage.TYPE_3BYTE_BGR);
//		        ato.filter(bis,bid);
		        ImageIO.write(bid,  " jpeg " , fo);
		    }   catch (Exception e)   {
		        e.printStackTrace();
		         throw   new  RuntimeException( " Failed in create preview image. Error:  "   +  e.getMessage());
		    }
		}
		
	
	
	
	public static void main(String[] s){
		
		//System.out.println(getSuffix("abc.txt"));
		
		createPreviewImage("d:/upload/a.jpg","d:/upload/b.jpg");
	}

}
