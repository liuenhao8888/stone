package com.stone.base.system;

import com.stone.util.PathUtil;

/**
 * 系统常用属性配置
 * 
 * @author stone
 *
 */
public abstract class SystemConstants {

	
	/**
	 * session中admin的key
	 */
	public static final String SESSION_ADMIN = "admin";


	/**
	 * 系统启动后静态化延迟时间 单位秒
	 */
	public static final int htmlDelay = 1 * 60;

	/**
	 * 信息静态化周期时间间隔 单位秒
	 */
	public static final int htmlCycle = 2 * 60;
	/**
	 * 最大上传文件大小 byte
	 */
	public static final int maxUploadSize = 3000000;
	/**
	 * 信息中图片的最大宽度
	 */
	public static final int imgMaxW = 500;
	/**
	 * 信息中图片的最大高度
	 */
	public static final int imgMaxH = 500;

	public static final String pressText = "爱我社区";

	public static String uploadPath = "resource/upload/";

	/**
	 * 默认分页的页面数据记录数
	 */
	public final static int PAGE_SIZE = 10;

	public static String webRoot = "";

	static {
		 try {
		 webRoot = new PathUtil().getWebRoot();
		 } catch (IllegalAccessException e) {
		 e.printStackTrace();
		 }
	}

	public static final String pressLogo = webRoot + "img/logo.jpg";
	
	
	/**
	 * redis DB 枚举
	 * @author stone
	 *
	 */
	public enum RedisDB {

		defaultDB(0),userDB(1), cartDB(2);

		private int dbIndex = 0;

		private RedisDB(int dbIndex) {
			this.dbIndex = dbIndex;
		}

		public String toString() {

			return this.dbIndex + "";
		}

	}
	
	
	/**
	 * redis key 枚举
	 * @author stone
	 *
	 */
	public enum CacheKey {

		user("user"), cart("cart");

		private String key = "";

		private CacheKey(String key) {
			this.key = key;
		}

		public String toString() {

			return this.key;
		}

	}
	
	/**
	 * cookie 配置
	 * @author stone
	 *
	 */
	public enum CookieSet {
		
		domain("localhost"), path("/"),tokenNname("token");
		
		private String value = "";

		private CookieSet(String value) {
			this.value = value;
		}

		public String toString() {

			return this.value;
		}

	}

}
