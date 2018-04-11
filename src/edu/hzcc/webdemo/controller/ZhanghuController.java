package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.ZhanghuDao;
import edu.hzcc.webdemo.pojo.Zhanghu;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**
 *账户的页面交互，页面根据cls:'zhanghuController',mtd:'getAll'来调用
 * 结果返回页面
 */
public class ZhanghuController extends ControllerBase{

	public void getAll(){
		//定义一个空的zhanghu列表
		List<Zhanghu> ZhanghuList=new ArrayList<>();
		//在zhanghuDao中数据库操作 找出所有的zhanghu列表
		ZhanghuList=ZhanghuDao.findALL();
		//定义一个json格式
		JSONObject jsonObject = new JSONObject();
		//把zhanghu列表填入json
		jsonObject.put("ZhanghuList", ZhanghuList);
		//原路返回zhanghu列表，用writeJson返回Json数据名字为zhanghulist
		writeJson(jsonObject.toString());
		return;
	}
	
	
	public void update() {		
		Zhanghu Zhanghu=new Zhanghu();	
		//getParameter("ID")获取页面的传来值ID
		 // "ID"要和页面的Input的name="ID"一样
		Zhanghu.setID(getParameterInt("ID"));
		Zhanghu.setMingzi(getParameter("mingzi"));
		Zhanghu.setQianshu(getParameterDouble("qianshu"));
		//调用zhanghuDao的修改操作
		ZhanghuDao.update(Zhanghu);
	}
}
