package jbeer.dev.twittermonitor.data.manager.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.os.AsyncTask;

import jbeer.dev.twittermonitor.data.dao.TweetDao;
import jbeer.dev.twittermonitor.data.dao.impl.TweetDaoCacheImpl;
import jbeer.dev.twittermonitor.data.dao.impl.TweetDaoWebImpl;
import jbeer.dev.twittermonitor.data.domain.Tweet;
import jbeer.dev.twittermonitor.data.manager.TweetManager;

public class TweetManagerImpl implements TweetManager {


	TweetManagerListener listener;
	Context mContext;
	
	
	
	@Override
	public void getRecentTweets(TweetManagerListener owner, Context context) {
		listener = owner;
		mContext = context;
		GetTweetTask task = new GetTweetTask();
		task.execute();
	}

	class GetTweetTask extends AsyncTask<Void, Void, List<Tweet>>{

		@Override
		protected List<Tweet> doInBackground(Void... params) {
			List<Tweet> listTweet = new ArrayList<Tweet>();
			TweetDaoCacheImpl daoCache = new TweetDaoCacheImpl(mContext);
			listTweet = daoCache.retrieveRecentTweets();
			if(listTweet==null){
				TweetDao daoWeb = new TweetDaoWebImpl();
				listTweet = daoWeb.retrieveRecentTweets();
				addTweetsToCache(daoCache, listTweet);
			}
			return listTweet;
		}
		
		private void addTweetsToCache(TweetDaoCacheImpl daoCache, List<Tweet> listTweet) {
			for(Tweet tweet : listTweet){
				daoCache.addTweet(tweet);
			}
			
		}

		@Override
		protected void onPostExecute(List<Tweet> tweetList) {
			listener.onTweetsRetreived(tweetList);
			super.onPostExecute(tweetList);
		}
		
	}

}
