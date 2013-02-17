package jbeer.dev.twittermonitor.data.dao;

import java.util.List;

import android.content.Context;

import jbeer.dev.twittermonitor.data.domain.Tweet;

public interface TweetDao {
	
	public List<Tweet> retrieveRecentTweets();


}
