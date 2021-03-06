package com.funkypantssoftware.communique;


import com.funkypantssoftware.communique.Util.MessageAdapter;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.funkypantssoftware.communique.Util.XML.Message;

public class SermonActivity extends ListActivity {
	private ListView mList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		this.setContentView(R.layout.sermon_view);

		SermonActivity.this.setListAdapter(new MessageAdapter(SermonActivity.this, MainActivity.sermonFeed));
		
		mList = (ListView) SermonActivity.this.findViewById(android.R.id.list);
		
		SermonActivity.this.mList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long id) {
				try {
					final Intent details = new Intent(SermonActivity.this, SermonDetailActivity.class);
					final Message message = (Message) view.getTag();
					details.putExtra("message", message);
					SermonActivity.this.startActivity(details);
					
				} catch (final Exception e) {
					//TODO: Handle error
					System.out.println(e.toString());
				}
			}
		});
		
		SermonActivity.this.setProgressBarIndeterminateVisibility(false);
	}
}