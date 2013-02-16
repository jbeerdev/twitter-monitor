package jbeer.dev.twittermonitor.ui.adapter;

import java.util.List;

import jbeer.dev.twittermonitor.ConnectionInfo;
import jbeer.dev.twittermonitor.R;
import jbeer.dev.twittermonitor.data.domain.Tweet;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TweetAdapter extends BaseAdapter {


	public int count = ConnectionInfo.PAGE_NUMBER;
	List<Tweet> tweetList;
	Context mContext;
	
	public TweetAdapter(Context context, List<Tweet> tweetList){
		this.tweetList = tweetList;
		mContext = context;
	}
	
	
	@Override
	public int getCount() {
		return count;
	}

	@Override
	public Object getItem(int position) {
		return tweetList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LinearLayout tweetLayout = null;
		if (convertView == null) {
			tweetLayout = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.tweet_row, parent, false);
		} else {
			tweetLayout = (LinearLayout) convertView;
		}
		String tweet = tweetList.get(position).getTweet();
		((TextView) tweetLayout.findViewById(R.id.tweet)).setText(tweet);
		return tweetLayout; 
	}

}
