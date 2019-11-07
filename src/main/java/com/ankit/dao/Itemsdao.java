package com.ankit.dao;

import java.util.List;
import com.ankit.model.Items;

public interface Itemsdao {
	public List<Items> getItems(Integer kid);
	public void addItems(Items items);
	public List<Items> admingetitems(Integer kid);
	public void deleteItems(Integer kid);
	public List<Items> loadAll();
	public List<Items> getItemsname(String name);
	
}
