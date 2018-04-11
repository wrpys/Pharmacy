package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.util.ControllerBase;

/**
 * 
 * 销售发货订单审核汇总的交互，页面根据cls:'ShoukuanshenheController',mtd:'findAll'来调用 结果返回页面
 */
public class ShoukuanshenheController extends ControllerBase {

	public void findAll() {
		System.out.println("ShoukuanshenheController.findALL()");
		// 定义一个空的caigoudingdan列表
		List<Dingdan> caigoudingdanList = new ArrayList<>();
		// 在caigoudingdanDao中数据库操作 找出所有的caigoudingdanlist列表
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanleixing(4);
		caigoudingdanList = DingdanDao.findALL(dingdan);
		// 定义一个json格式
		JSONObject jsonObject = new JSONObject();
		// 把caigoudingdanlist列表填入json
		jsonObject.put("caigoudingdanList", caigoudingdanList);
		// 原路返回caigoudingdanlist列表，用writeJson返回Json数据名字为caigoudingdanglist
		writeJson(jsonObject.toString());
		return;
	}

	public void update() {
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanID(getParameterInt("dingdanID"));
		dingdan.setComplete(getParameterInt("complete"));
		DingdanDao.updateComplete(dingdan);
	}

}
