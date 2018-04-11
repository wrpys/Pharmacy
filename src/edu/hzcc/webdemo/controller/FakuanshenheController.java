package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.util.ControllerBase;

/**
 * 
 * 采购收货订单审核汇总的交互，页面根据cls:'FakuanshenheControllerController',mtd:'findAll'来调用
 * 结果返回页面
 */
public class FakuanshenheController extends ControllerBase {

	public void findAll() {
		System.out.println("FakuanshenheControllerController.findALL()");
		// 定义一个空的caigoushouhuo列表
		List<Dingdan> caigoudingdanList = new ArrayList<>();
		// 在DingdanDao中数据库操作 找出所有的caigoushouhuolist列表
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanleixing(2);
		caigoudingdanList = DingdanDao.findALL(dingdan);
		// 定义一个json格式
		JSONObject jsonObject = new JSONObject();
		// 把caigoushouhuolist列表填入json
		jsonObject.put("caigoudingdanList", caigoudingdanList);
		// 原路返回caigoushouhuolist列表，用writeJson返回Json数据名字为caigoushouhuolist
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
