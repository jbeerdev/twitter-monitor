package jbeer.dev.twittermonitor.data.dao.impl;

import java.util.List;

import jbeer.dev.twittermonitor.data.dao.TweetDao;
import jbeer.dev.twittermonitor.data.domain.Tweet;
import jbeer.dev.twittermonitor.persistence.CacheTable;
import android.content.Context;

public class TweetDaoCacheImpl implements TweetDao{

	Context mContext;
	CacheTable cache;
	
	public TweetDaoCacheImpl(Context context) {
		mContext = context;
		cache = new CacheTable(context);
	}
	
	@Override
	public List<Tweet> retrieveRecentTweets() {
		return cache.getTweets();
	}

	public void addTweet(Tweet tweet) {
		cache.addTweet(tweet);
	}

}
