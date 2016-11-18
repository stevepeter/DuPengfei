package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.ssm.mapper.ItemMapper;
import cn.itcast.ssm.po.Item;
import cn.itcast.ssm.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;

	@Override
	public List<Item> queryItemList() {
		List<Item> list = itemMapper.selectByExample(null);
		
		return list;
	}

	@Override
	public Item queryById(int id) {
		return itemMapper.selectByPrimaryKey(id);
		
	}

	@Override
	public void updateItem(Item item) {
		itemMapper.updateByPrimaryKeySelective(item);
	}
}
