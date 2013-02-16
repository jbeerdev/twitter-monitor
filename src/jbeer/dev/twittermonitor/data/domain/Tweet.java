package jbeer.dev.twittermonitor.data.domain;

public class Tweet {
	
	private String userName;
	private String avatarURl;
	private String time;
	private String tweet;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAvatarURl() {
		return avatarURl;
	}
	public void setAvatarURl(String avatarURl) {
		this.avatarURl = avatarURl;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}
	
	

}
