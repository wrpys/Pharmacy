package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hzcc.webdemo.dao.RizhiDao;
import edu.hzcc.webdemo.pojo.Rizhi;
import edu.hzcc.webdemo.sys.ProjectShare;
import edu.hzcc.webdemo.util.ControllerBase;
import edu.hzcc.webdemo.util.JsonDateValueProcessor;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class RizhiController extends ControllerBase{

	public void findAll() {
		JSONObject jsonObject = new JSONObject();
		List<Rizhi> rizhiList=new ArrayList<>();
		rizhiList= RizhiDao.findALL();
		jsonObject.put("rizhiList", rizhiList);
		
		
		writeJson(jsonObject.toString());
		return;
	}
}
