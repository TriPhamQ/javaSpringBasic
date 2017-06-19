package com.phamqtri.ninjagold.models;

import java.util.ArrayList;

public class LootModel {
	private ArrayList<String[]> lootHistory = new ArrayList<String[]>();
	
	public LootModel() {
		
	}

	public ArrayList<String[]> getLootHistory() {
		return lootHistory;
	}

	public void setLootHistory(ArrayList<String[]> lootHistory) {
		this.lootHistory = lootHistory;
	}
	
	public ArrayList<String[]> add(String[] loot) {
		this.lootHistory.add(loot);
		return this.lootHistory;
	}
}
