package jbeer.dev.twittermonitor.data.manager;

import java.util.List;

import android.content.Context;

import jbeer.dev.twittermonitor.data.domain.Tweet;

public interface TweetManager {
	public interface TweetManagerListener{
		public void onTweetsRetreived(List<Tweet> tweetList);
	}
	
	public void getRecentTweets(TweetManagerListener owner, Context context);

}
