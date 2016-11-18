package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.Item;

public interface ItemService {
	/**
	 * 查找全部商品
	 * @return
	 */
	List<Item> queryItemList();
	/**
	 * 根据id查找商品
	 * @param id
	 * @return
	 */
	Item queryById(int id);
	/**
	 * 修改商品信息
	 * @param item
	 */
	void updateItem(Item item);
}
