package com.citi.ci.userTaskAPI.service;

import com.citi.ci.userTaskAPI.util.Constant;
import com.citi.ci.userTaskAPI.util.HttpUtil;

/**
 * 
 * @author yanfu
 *
 */
public class AppService {


	public static String ness(String str) {
		System.out.println("=====ness==start====" + str);
		String response = HttpUtil.httpGet(str);
		System.out.println(response);
		System.out.println("=====ness==end====");
		return "ness---- " + str;
	}

	public static String creditBureau(String str) {
		System.out.println("=====creditBureau==start====" + str);
		String response = HttpUtil.httpGet(str);
		System.out.println(response);
		System.out.println("=====creditBureau==end====");
		return "creditBureau-----";
	}

	public String fmeSync(String str) {
		System.out.println("=====fmeSync==start====" + str);
		String response = HttpUtil.httpGet(str);
		System.out.println(response);
		System.out.println("=====fmeSync==end====");
		return "internalAccountPull-----";

	}

	
	public String internalAccountPull(String str) {
		System.out.println("=====internalAccountPull==start====" + str);
		String response = HttpUtil.httpGet(str);
		System.out.println(response);
		System.out.println("=====internalAccountPull==end====");
		return "internalAccountPull-----";
	}
	
	
	public String cdeDesicion(String str) {
		System.out.println("=====cdeDesicion==start====" );
		String response = HttpUtil.httpGet(Constant.CREDITANALYSIS_CREDITDECISION);
		System.out.println(response);
		System.out.println("=====cdeDesicion==end====");
		
		return "";
	}
	
	public static String citiScreening(String str) {
		
		System.out.println("=====citiScreening==start====" );
		String response = HttpUtil.httpGet(Constant.CREDITANALYSIS_CITISCREENING);
		System.out.println(response);
		System.out.println("=====citiScreening==end====");
		
		return "";
	}
	
public static String document(String str) {
		
		System.out.println("=====document==start====" );
		String response = HttpUtil.httpGet(Constant.DOCUMNET_DOCUMENTUM);
		System.out.println(response);
		System.out.println("=====document==end====");
		
		return "";
	}
	


public static String confirm(String str) {
	
	System.out.println("=====confirm==start====" );
//	String response = HttpUtil.httpGet(str);
//	System.out.println(response);
	System.out.println("=====confirm==end====");
	
	return "";
}


public static String  creditBureau2(String str) {
	System.out.println("========credit bureau===start==");
	
	System.out.println("========credit bureau===end==");
	
	
	return "";
}

}
