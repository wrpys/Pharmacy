package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.util.ControllerBase;

/**
 * 采购订单审核汇总的交互，页面根据cls:'CaigouhuizongshenheController',mtd:'findAll'来调用 结果返回页面
 */
public class CaigouhuizongshenheController extends ControllerBase {

	// 查找所有采购订单
	public void findAll() {
		System.out.println("CaigouhuizongshenheController.findALL()");
		// 定义一个空的dingdanList列表
		List<Dingdan> dingdanList = new ArrayList<>();
		// 在DingdanDao中数据库操作 找出所有的dingdanlist列表
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanleixing(1);// 查找订单为：采购订单
		dingdanList = DingdanDao.findALL(dingdan);
		// 定义一个json格式
		JSONObject jsonObject = new JSONObject();
		// 把dingdanlist列表填入json
		jsonObject.put("caigoudingdanList", dingdanList);
		// 原路返回dingdanlist列表，用writeJson返回Json数据名字为dingdanlist
		writeJson(jsonObject.toString());
		return;
	}

	// 审核 修改采购订单的状态
	public void update() {
		Dingdan dingdan = new Dingdan();
		// 从页面表单中获取。name="dingdanID"
		dingdan.setDingdanID(getParameterInt("dingdanID"));
		dingdan.setComplete(getParameterInt("complete"));
		// 在DingdanDao中数据库操作 修改一个订单
		DingdanDao.updateComplete(dingdan);
	}

}
