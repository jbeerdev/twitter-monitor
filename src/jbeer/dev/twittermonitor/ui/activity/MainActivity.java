package jbeer.dev.twittermonitor.ui.activity;

import jbeer.dev.twittermonitor.data.manager.TweetManager.TweetManagerListener;
import jbeer.dev.twittermonitor.ui.adapter.TweetAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class MainActivity extends ListActivity implements OnScrollListener, TweetManagerListener {

    TweetAdapter adapter = new TweetAdapter();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(adapter); 
        getListView().setOnScrollListener(this);
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
	public void onTweetsRetreived() {
		// TODO Auto-generated method stub
		
	}    
	
//	http://search.twitter.com/search.json?q=Android&rpp=25&result_type=recent

}
