package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.ssm.po.Item;
import cn.itcast.ssm.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	/**
	 * 查询商品列表
	 * @param model
	 * @return
	 */
	@RequestMapping("itemList")
	public String queryItemList(Model model){
		List<Item> list = itemService.queryItemList();
		model.addAttribute("itemList", list);
		return "itemList";
	}
	/**
	 * 根据id查询商品
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("itemEdit")
	public String queryItemById(Integer id,Model model){
		Item item = itemService.queryById(id);
		model.addAttribute("item", item);
		return "itemEdit";
	}
	
	@RequestMapping("updateItem")
	public String updateItem(Model model,Item item){
		itemService.updateItem(item);
		return "success";
	}
}
