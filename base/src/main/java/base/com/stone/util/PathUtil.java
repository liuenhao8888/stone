package com.stone.util;

/**
 * 
 * java类获取web应用的根目录
 * 
 */
public class PathUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		PathUtil p = new PathUtil();
		System.out.println(p.getWebClassesPath());
		System.out.println(p.getWebInfPath());
		System.out.println(p.getWebRoot());
	}

	public String getWebClassesPath() {
		String path = getClass().getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		path = trim(path);
		return path;

	}

	public String getWebInfPath() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
			path = path.substring(0, path.indexOf("WEB-INF") + 8);
			path = trim(path);
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}

	public String getWebRoot() throws IllegalAccessException {
		String path = getWebClassesPath();
		if (path.indexOf("WEB-INF") > 0) {
//			path = path.substring(0, path.indexOf("WEB-INF/classes"));
			path = path.substring(0, path.indexOf("WEB-INF"));
			path = trim(path);
		} else {
			throw new IllegalAccessException("路径获取错误");
		}
		return path;
	}
	
	private String trim(String s){
		if(s.startsWith("/")||s.startsWith("\\")){
			s = s.substring(1);
			trim(s);
		}
		return s;
	};
	
}
