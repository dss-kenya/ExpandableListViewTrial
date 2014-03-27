package com.example.expandablelistviewtrial.adapters;

import java.util.List;

import com.example.expandablelistviewtrial.R;
import com.example.expandablelistviewtrial.models.ChildFoodItems;
import com.example.expandablelistviewtrial.models.Food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FoodAdapter extends BaseExpandableListAdapter{
	private Context mContext;
	private List<Food> mItems;
	
	public FoodAdapter(Context context, List<Food> items) {
		mContext = context;
		mItems = items;
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosition) {
		if(mItems != null) {
			if(mItems.get(groupPosition).getChildItems() != null) {
				return mItems.get(groupPosition).getChildItems().get(childPosition);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = convertView;
		ViewHolder vh;
		
		if(view == null) {
			view = inflater.inflate(R.layout.individual_child_item, parent, false);
			vh = new ViewHolder();
			vh.txtChildName = (TextView)view.findViewById(R.id.txtChildName);
			vh.relChild = (RelativeLayout)view.findViewById(R.id.relChild);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		Food food = mItems.get(groupPosition);
		List<ChildFoodItems> childItems = food.getChildItems();
		
		if(childItems != null) {
			ChildFoodItems childItem = childItems.get(childPosition);
			vh.txtChildName.setText(childItem.getChildFoodItemName());
		}else {
			vh.txtChildName.setText("Empty");
		}
		
		if(childPosition % 2 == 0) {
			vh.relChild.setBackgroundResource(R.drawable.first_child);
		}else {
			vh.relChild.setBackgroundResource(R.drawable.second_child);
		}
	
		return view;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if(mItems != null) {
			if(mItems.get(groupPosition).getChildItems() != null) {
				return mItems.get(groupPosition).getChildItems().size();
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}

	@Override
	public Object getGroup(int groupPosition) {
		if(mItems != null) {
			return mItems.get(groupPosition);
		}else {
			return null;
		}
	}

	@Override
	public int getGroupCount() {
		if(mItems != null) {
			return mItems.size();
		}else {
			return 0;
		}
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = convertView;
		ViewHolder vh;
		
		if(view == null) {
			view = inflater.inflate(R.layout.individual_group_item, parent, false);
			vh = new ViewHolder();
			vh.txtGroupName = (TextView)view.findViewById(R.id.txtGroupName);
			vh.relGroup = (RelativeLayout)view.findViewById(R.id.relGroup);
			view.setTag(vh);
		}else {
			vh = (ViewHolder)view.getTag();
		}
		
		Food food = mItems.get(groupPosition);
		vh.txtGroupName.setText(food.getFoodName());
		vh.relGroup.setBackgroundResource(R.drawable.parent_level);
		
		return view;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
	
	static class ViewHolder {
		private RelativeLayout relGroup;
		private RelativeLayout relChild;
		private TextView txtGroupName;
		private TextView txtChildName;
	}
}
