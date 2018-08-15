package com.citi.ci.userTaskAPI.util;

public class Constant {

	public static final String BASE_HOST = "http://192.168.43.37:8099/";
	public static final String CREDITLIMIT = "creditlimit/temporaryIncrease";
//	*********************************************************credit checks***************************************
	public static final  String INETERNAL_ACCOUNTPULL =BASE_HOST +  "creditChecks/inetrnalAcccountPull";
	public static final  String NESS =BASE_HOST +  "creditChecks/ness";
	public static final  String CREDITBUREAU =BASE_HOST +  "creditChecks/creditBureau";
	public static final  String FMESYNC =BASE_HOST +  "creditChecks/fmeSync";
//	*********************************************************creditAnalysis***************************************
	public static final String CREDITANALYSIS_CIFME = BASE_HOST + "creditAnalysis/ciFME";
	public static final String CREDITANALYSIS_CIAPPLICATIONADD = BASE_HOST  + "creditAnalysis/ciApplicationAdd";
	public static final String CREDITANALYSIS_INTERNALACCOUNT = BASE_HOST + "creditAnalysis/internalAccount";
	public static final String CREDITANALYSIS_CITISCREENING = BASE_HOST + "creditAnalysis/citiScreening";
	public static final String CREDITANALYSIS_CREDITDECISION= BASE_HOST  + "creditAnalysis/creditDecision";
//	*********************************************************internalAccount***************************************
	public static final String COMMUMICATION_CITIALERT = BASE_HOST + "commumication/citiAlert";
	
	public static final String DOCUMNET_DOCUMENTUM = BASE_HOST+  "document/documentum";
	
}
