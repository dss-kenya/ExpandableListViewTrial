package com.example.expandablelistviewtrial.utils.staticdata;

import java.util.ArrayList;
import java.util.List;

import com.example.expandablelistviewtrial.models.ChildFoodItems;
import com.example.expandablelistviewtrial.models.Food;

public class StaticManager {
	private static StaticManager mStaticManager = new StaticManager();
	
	public static StaticManager getInstance() {
		return mStaticManager;
	}
	
	public List<Food> getFoodItems() {
		List<Food> lstOfFood = new ArrayList<Food>();
		for(int i=0;i<10;i++) {
			Food food = new Food();
			food.setChildItems(getChildItems(i));
			food.setFoodName("Food Item: " + (i+1));
			lstOfFood.add(food);
		}
		return lstOfFood;
	}
	
	public List<ChildFoodItems> getChildItems(int id) {
		List<ChildFoodItems> childFoodItems = 
				new ArrayList<ChildFoodItems>();
		for(int i=0;i<10;i++) {
			ChildFoodItems childFoodItem = new ChildFoodItems();
			childFoodItem.setChildFoodItemName("Parent Item: " + (id +1) + "Child Item: " + (i + 1));
			childFoodItems.add(childFoodItem);
		}
		return childFoodItems;
	}
}
