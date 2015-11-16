package com.stone.util;
import java.util.Random;

/**
 * 随机数相关类
 *
 */
public class RandomUtil {

	/**
	 * 产生一组不重复的随机数
	 * 
	 * @param n 生成的个数
	 * @return int[] 返回结果
	 */
	public static int[] getUniqueRandoms(int n) {
		int[] num = new int[n];
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			num[i] = Math.abs(r.nextInt());
		}
		return num;
	}
	/**
	 * 产生一组不重复的随机数
	 * 
	 * @param n 生成的个数
	 * @param len 长度限制
	 * @return int[] 返回结果
	 */
	public static int[] getUniqueRandoms(int n, int len) {
		int[] num = new int[n];
		Random r = new Random(System.currentTimeMillis());
		for (int i = 0; i < n; i++) {
			num[i] = Math.abs(r.nextInt() % digit(len));
		}
		return num;
	}
	/**
	 * 产生一个随机数功能
	 * 
	 * @return int 返回结果
	 */
	public static int getRandom() {
		return Math.abs(new Random().nextInt());
	}

	/**
	 * 产生一个有长度限制的随机数功能
	 * 
	 * @param len 设置长度限制
	 * @return int 返回结果
	 */
	public static int getRandom(int len) {
		int maxvalue = digit(len);
		return Math.abs(new Random().nextInt(maxvalue));
	}
	/**
	 * @param n 设置长度限制
	 * @return int 返回随机数最大值
	 */
	private static int digit(int n) {
		int j = 1;
		for (int i = 0; i < n; i++) {
			j = 10 * j;
		}
		return j - 1;
	}
	
	public static void main(String args[]){
		int ceshi=RandomUtil.getRandom(5);
		System.out.println(ceshi);
	}
}
