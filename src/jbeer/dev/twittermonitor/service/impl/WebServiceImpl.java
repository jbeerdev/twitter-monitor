package jbeer.dev.twittermonitor.service.impl;

import java.io.IOException;
import java.util.Map;

import jbeer.dev.twittermonitor.service.WebService;
import jbeer.dev.twittermonitor.utils.StringUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class WebServiceImpl implements WebService{

	DefaultHttpClient httpClient;
	HttpContext localContext;
	String returnedValue;

	HttpResponse response = null;
	HttpPost httpPost = null;
	HttpGet httpGet = null;
	String webServiceUrl;

	public WebServiceImpl(String serviceName){
		HttpParams myParams = new BasicHttpParams();

		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		HttpConnectionParams.setSoTimeout(myParams, 10000);
		httpClient = new DefaultHttpClient(myParams);
		localContext = new BasicHttpContext();
		webServiceUrl = serviceName;

	}

	@Override
	public String webGet(Map<String, String> params) {
		String getUrl = webServiceUrl;

		getUrl = StringUtils.generateUrl(params, getUrl);

		httpGet = new HttpGet(getUrl);
		Log.e("WebGetURL: ",getUrl);
		try {
			response = httpClient.execute(httpGet);
			System.out.println("STATUS RESPONSE "+response.getStatusLine().getStatusCode());
			returnedValue = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			Log.e("WebService:", " Messaje " +  e.getMessage());
		} catch (Exception e) {
			Log.e("WebService:", " Messaje " + e.getMessage());
		}
		return returnedValue;
	}

}
