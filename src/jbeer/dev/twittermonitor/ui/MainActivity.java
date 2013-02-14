package jbeer.dev.twittermonitor.ui;

import java.util.HashMap;
import java.util.Map;

import jbeer.dev.twittermonitor.R;
import jbeer.dev.twittermonitor.R.layout;
import jbeer.dev.twittermonitor.R.menu;
import jbeer.dev.twittermonitor.service.impl.WebServiceImpl;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		WebServiceImpl webService = new WebServiceImpl("http://search.twitter.com/search.json");
		Map<String,String> params = new HashMap<String, String>(); 
		params.put("result_type", "recent");
		params.put("rpp", "25");
		params.put("q", "Android");
		String result = webService.webGet(params);
		Log.e("JBC", "RESULT "+result);
		
	}
	
//	http://search.twitter.com/search.json?q=Android&rpp=25&result_type=recent

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		return true;
	}

}
