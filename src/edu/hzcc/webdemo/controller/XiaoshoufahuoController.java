package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.KucunDao;
import edu.hzcc.webdemo.dao.RukuandanDao;
import edu.hzcc.webdemo.dao.XiaoshoufahuoDao;
import edu.hzcc.webdemo.pojo.Kucun;
import edu.hzcc.webdemo.pojo.Rukuandan;
import edu.hzcc.webdemo.pojo.Xiaoshoufahuo;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/*
 * 销售发货
 */
public class XiaoshoufahuoController extends ControllerBase{

	public void findALL(){
		System.out.println("xiaoshoufahuoController.findALL()");
		List<Xiaoshoufahuo> xiaoshoufahuoList=new ArrayList<>();
		xiaoshoufahuoList=XiaoshoufahuoDao.findALL();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("xiaoshoufahuoList", xiaoshoufahuoList);
		writeJson(jsonObject.toString());
		return;
	}
	
	public void delete(){
		System.out.println("xiaoshoufahuoController.delete()");
		int xiaoshoufahuoID = getParameterInt("xiaoshoufahuoID");
		XiaoshoufahuoDao.delete(xiaoshoufahuoID);
		return;
	}
	
	public void save() {
		Xiaoshoufahuo xiaoshoufahuo=new Xiaoshoufahuo();
		xiaoshoufahuo.setYaopingID(getParameterInt("yaopingID"));
		xiaoshoufahuo.setYaopingMingzi(getParameter("yaopingMingzi"));
		xiaoshoufahuo.setYaopingDanwei(getParameter("yaopingDanwei"));
		xiaoshoufahuo.setShuliang(getParameterInt("shuliang"));
		xiaoshoufahuo.setZongjia(getParameterDouble("zongjia"));
		xiaoshoufahuo.setRiqi(getParameter("riqi"));
		xiaoshoufahuo.setGongyingshangID(getParameterInt("gongyingshangID"));
		xiaoshoufahuo.setKehuID(getParameterInt("kehuID"));
		xiaoshoufahuo.setXiaoshoudingdangID(getParameterInt("xiaoshoudingdangID"));
		XiaoshoufahuoDao.save(xiaoshoufahuo);

			
			
		
	}
	public void update() {
		Xiaoshoufahuo xiaoshoufahuo=new Xiaoshoufahuo();
		xiaoshoufahuo.setYaopingID(getParameterInt("yaopingID"));
		xiaoshoufahuo.setYaopingMingzi(getParameter("yaopingMingzi"));
		xiaoshoufahuo.setYaopingDanwei(getParameter("yaopingDanwei"));
		xiaoshoufahuo.setShuliang(getParameterInt("shuliang"));
		xiaoshoufahuo.setZongjia(getParameterDouble("zongjia"));
		xiaoshoufahuo.setRiqi(getParameter("riqi"));
		xiaoshoufahuo.setGongyingshangID(getParameterInt("gongyingshangID"));
		xiaoshoufahuo.setKehuID(getParameterInt("kehuID"));
		xiaoshoufahuo.setXiaoshoudingdangID(getParameterInt("xiaoshoudingdangID"));
		xiaoshoufahuo.setXiaoshoufahuoID(getParameterInt("xiaoshoufahuoID"));
		xiaoshoufahuo.setComplete(getParameterInt("complete"));
		if(XiaoshoufahuoDao.save(xiaoshoufahuo)){
			if(xiaoshoufahuo.getComplete()>0){
				Rukuandan rukuandan=new Rukuandan();
				rukuandan.setBeizhi("销售出货");
				rukuandan.setKehuID(xiaoshoufahuo.getKehuID());
				rukuandan.setRiqi(xiaoshoufahuo.getRiqi());
				rukuandan.setXiaoshoudingdangID(xiaoshoufahuo.getXiaoshoudingdangID());
				rukuandan.setQianshu(xiaoshoufahuo.getZongjia());
				rukuandan.setZhuantai(0);
				
				rukuandan.setXiaoshoufahuoID(xiaoshoufahuo.getXiaoshoudingdangID());
				RukuandanDao.save(rukuandan);
				
			}
		}
		
	}

}
