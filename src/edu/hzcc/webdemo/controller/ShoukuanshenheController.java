package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.dao.ZhanghuDao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.pojo.Zhanghu;
import edu.hzcc.webdemo.util.ControllerBase;

/**
 * 
 * 销售发货订单审核汇总的交互，页面根据cls:'ShoukuanshenheController',mtd:'findAll'来调用 结果返回页面
 */
public class ShoukuanshenheController extends ControllerBase {

	//查找所有销售出货订单
	public void findAll() {
		System.out.println("ShoukuanshenheController.findALL()");
		// 定义一个空的dingdan列表
		List<Dingdan> dingdanList = new ArrayList<>();
		// 在caigoudingdanDao中数据库操作 找出所有的dingdanList列表
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanleixing(4);// 查找订单为：销售出货订单
		dingdanList = DingdanDao.findALL(dingdan);
		// 定义一个json格式
		JSONObject jsonObject = new JSONObject();
		// 把dingdanList列表填入json
		jsonObject.put("caigoudingdanList", dingdanList);
		// 原路返回dingdanList列表，用writeJson返回Json数据名字为caigoudingdanList
		writeJson(jsonObject.toString());
		return;
	}

	// 收款结算。
	public void update() {
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanID(getParameterInt("dingdanID"));
		dingdan.setComplete(getParameterInt("complete"));
		// 将销售发货订单的状态改为已结算
		boolean isSucess = DingdanDao.updateComplete(dingdan);
		// 审核成功后，进行账户金额增加
		if (dingdan.getComplete().intValue() == 1 && isSucess) {
			Integer zhanghuID = getParameterInt("zhanghuID");
			Double zongjia = getParameterDouble("zongjia");
			Zhanghu zhanghu = ZhanghuDao.findOne(zhanghuID);
			// 修改账户金额
			ZhanghuDao.updatezhanghuQianshu(zhanghuID, zhanghu.getQianshu()
					+ zongjia);
		}
	}

}
