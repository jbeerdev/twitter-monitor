package jbeer.dev.twittermonitor.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class StringUtils {

	
	public static String generateUrl(Map<String, String> params, String getUrl) {
		int i = 0;
		for (Map.Entry<String, String> param : params.entrySet())
		{
			if(i == 0){
				getUrl += "?";
			}
			else{
				getUrl += "&";
			}
			try {
				getUrl += param.getKey() + "=" + URLEncoder.encode(param.getValue(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			i++;
		}
		return getUrl;
	}
	
}
