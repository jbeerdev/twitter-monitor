package jbeer.dev.twittermonitor.data.domain;

import java.util.List;

public class TweetMonitor {
	
	private List<Tweet> tweetList;
	private String nextPage;

	
	public List<Tweet> getTweetList() {
		return tweetList;
	}
	public void setTweetList(List<Tweet> tweetList) {
		this.tweetList = tweetList;
	}
	public String getNextPage() {
		return nextPage;
	}
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

}
