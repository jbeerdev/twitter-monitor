package jbeer.dev.twittermonitor.ui.activity;

import java.util.List;

import jbeer.dev.twittermonitor.R;
import jbeer.dev.twittermonitor.data.domain.Tweet;
import jbeer.dev.twittermonitor.data.manager.TweetManager;
import jbeer.dev.twittermonitor.data.manager.TweetManager.TweetManagerListener;
import jbeer.dev.twittermonitor.data.manager.impl.TweetManagerImpl;
import jbeer.dev.twittermonitor.ui.adapter.TweetAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class MainActivity extends ListActivity implements OnScrollListener, TweetManagerListener {

	 TweetAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TweetManager tweetManager = new TweetManagerImpl();
        tweetManager.getRecentTweets(this);
    }

    public void onScroll(AbsListView view,
        int firstVisible, int visibleCount, int totalCount) {

        boolean loadMore = /* maybe add a padding */
            firstVisible + visibleCount >= totalCount;

        if(loadMore) {
            adapter.count += visibleCount; // or any other amount
            adapter.notifyDataSetChanged();
        }
    }

    public void onScrollStateChanged(AbsListView v, int s) { }

	@Override
	public void onTweetsRetreived(List<Tweet> tweetList) {
		adapter = new TweetAdapter(getApplicationContext(), tweetList);
		setListAdapter(adapter); 
        getListView().setOnScrollListener(this);
		
	}    
	
//	http://search.twitter.com/search.json?q=Android&rpp=25&result_type=recent

}
