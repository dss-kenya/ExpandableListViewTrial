package com.example.expandablelistviewtrial.models;

import java.util.List;

public class Food {
	private String foodName;
	private List<ChildFoodItems> childItems;
	
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public List<ChildFoodItems> getChildItems() {
		return childItems;
	}
	public void setChildItems(List<ChildFoodItems> childItems) {
		this.childItems = childItems;
	}
}
