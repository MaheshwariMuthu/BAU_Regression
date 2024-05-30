package automationFramework;

import java.io.*;
import static automationFramework.Constant.*;
import java.nio.file.Files;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import DataMapping.testDataMapping;

import static stepDefinations.Hooks.configProperties;

public class DataReader {
	public static Logger log = Logger.getLogger(PageActions.class);


	public static String geturl_old() throws IOException {
		String url=null;
		String env=configProperties.getProperty("server.env");
		String Site=configProperties.getProperty("server.site");
		System.out.println(env);
		System.out.println(Site);
		if(Site!=null){
			switch (Site){
				case"aepindianamichigan":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case"wvwachoice":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case"buffalowaternipcnew":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case"kypower-tabs":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case"firstenergy-fundle":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case "sanjose":
					url= "https://www.reghomeserve.com/sc/mail/" +Site;
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case"lasanitation":
					url= "https://" + env + ".slwofa.com/mail/" +Site;
					break;
				case"ottawa":
					url= "https://" + env + ".slwofc.ca/mail/" +Site;
					break;
				case"Homeserve":
					url= "https://www.reghomeserve.com/?ncr=true";
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;
				case"slwofa":
					url= "https://" + env + ".slwofa.com/";
					break;
				case"slwofc":
					url= "https://" + env + ".slwofc.ca/";
					break;
				case"HomeServe-CE":
					url= "https://www.reghomeserve.com/sc/mail/homeserve-ce";
					if(env.equalsIgnoreCase("preprod2")){
						url = url.replace("www.reg","preprod.");
					} else if (env.equalsIgnoreCase("test")) {
						url = url.replace("www.reg","uat");
					}else if (env.equalsIgnoreCase("prod")) {
						url = url.replace("www.reg","prod.");
					}
					break;

				default:
					System.out.println("Invalid url entered");
					Assert.fail("Invalid url entered :: "+Site);
			}
		}
		System.out.println("URL under test: " + url);
		log.info("URL under test: " + url);
		return url;
	}

		
	
	public static String geturl() throws IOException {
		String Site = testDataMapping.getValue(outputData, "Site");
		String url = testDataMapping.getValue(URLMapping, Site);
		log.info("Site: "+Site+"\n");
		log.info("URL: "+ url + "\n");
		return url;
		
	}
}
