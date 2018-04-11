package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.util.ControllerBase;

/**
 * 
 * 采购订单汇总的交互，页面根据cls:'CaigouhuizongshenheController',mtd:'findAll'来调用 结果返回页面
 */
public class CaigouhuizongshenheController extends ControllerBase {

	public void findAll() {
		System.out.println("CaigouhuizongshenheController.findALL()");
		// 定义一个空的dingdanList列表
		List<Dingdan> dingdanList = new ArrayList<>();
		// 在DingdanDao中数据库操作 找出所有的dingdanlist列表
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanleixing(1);
		dingdanList = DingdanDao.findALL(dingdan);
		// 定义一个json格式
		JSONObject jsonObject = new JSONObject();
		// 把dingdanlist列表填入json
		jsonObject.put("caigoudingdanList", dingdanList);
		// 原路返回dingdanlist列表，用writeJson返回Json数据名字为dingdanlist
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
