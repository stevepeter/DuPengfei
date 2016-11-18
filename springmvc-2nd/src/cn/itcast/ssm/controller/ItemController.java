package cn.itcast.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.ssm.po.Item;
import cn.itcast.ssm.po.QueryVo;
import cn.itcast.ssm.service.ItemService;

@Controller
//@RequestMapping("item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 查询商品列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "itemList", "itemListAll" }, method = { RequestMethod.POST, RequestMethod.GET })
	public String queryItemList(Model model) {
		List<Item> list = itemService.queryItemList();
		model.addAttribute("itemList", list);
		return "itemList";
	}

	/**
	 * 根据id查询商品
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("itemEdit")
	public String queryItemById(Integer id, Model model) {
		Item item = itemService.queryById(id);
		model.addAttribute("item", item);
		return "itemEdit";
	}

	@RequestMapping("updateItem")
	public String updateItem(Item item,MultipartFile pictureFile) throws IllegalStateException, IOException {
		//设置图片随机名称,避免重复
		String picName=UUID.randomUUID().toString();
		//获取原本文件名
		String oriName = pictureFile.getOriginalFilename();
		//获取图片后缀
		String suffixName = oriName.substring(oriName.lastIndexOf("."));
		//开始上传
		pictureFile.transferTo(new File("D:/Develop/MARS/WorkSpace/pic/"+picName+suffixName));
		
		
		item.setPic(picName+suffixName);
		itemService.updateItem(item);
		return "redirect:/itemList.action";
	}

	@RequestMapping("queryItem")
	public String queryItem(QueryVo queryVo) {
		return "redirect:/itemList.action";
	}
	
	public @ResponseBody Item testJson(@RequestBody Item item){
		return item;
	}
}
