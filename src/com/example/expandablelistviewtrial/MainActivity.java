package com.example.expandablelistviewtrial;

import java.util.List;

import com.example.expandablelistviewtrial.adapters.FoodAdapter;
import com.example.expandablelistviewtrial.models.Food;
import com.example.expandablelistviewtrial.utils.staticdata.StaticManager;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {
	private ExpandableListView mListView;
	private FoodAdapter mAdapter;
	private List<Food> foodList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ExpandableListView)findViewById(R.id.expandableListView);
		foodList = StaticManager.getInstance().getFoodItems();
		mAdapter = new FoodAdapter(this, foodList);
		mListView.setAdapter(mAdapter);
		mListView.setGroupIndicator(null);
	}
}
