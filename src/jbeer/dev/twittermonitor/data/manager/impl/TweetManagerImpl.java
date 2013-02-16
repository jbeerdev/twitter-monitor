package jbeer.dev.twittermonitor.data.manager.impl;

import java.util.List;

import android.os.AsyncTask;

import jbeer.dev.twittermonitor.data.dao.impl.TweetDaoWebImpl;
import jbeer.dev.twittermonitor.data.domain.Tweet;
import jbeer.dev.twittermonitor.data.manager.TweetManager;

public class TweetManagerImpl implements TweetManager {


	TweetManagerListener listener;
	
	@Override
	public void getRecentTweets(TweetManagerListener owner) {
		listener = owner;
		GetTweetTask task = new GetTweetTask();
		task.execute();
	}

	class GetTweetTask extends AsyncTask<Void, Void, List<Tweet>>{

		@Override
		protected List<Tweet> doInBackground(Void... params) {
			TweetDaoWebImpl tweetDao = new TweetDaoWebImpl();
			return tweetDao.retrieveRecentTweets();
		}
		
		@Override
		protected void onPostExecute(List<Tweet> tweetList) {
			listener.onTweetsRetreived(tweetList);
			super.onPostExecute(tweetList);
		}
		
	}

}
