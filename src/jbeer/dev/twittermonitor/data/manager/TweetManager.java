package jbeer.dev.twittermonitor.data.manager;

import java.util.List;

import jbeer.dev.twittermonitor.data.domain.Tweet;

public interface TweetManager {
	
	public List<Tweet> getRecentTweets();

}
