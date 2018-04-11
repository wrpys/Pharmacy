package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.CaigoufahuoDao;
import edu.hzcc.webdemo.dao.FukuandanDao;
import edu.hzcc.webdemo.dao.KucunDao;
import edu.hzcc.webdemo.pojo.Caigoufahuo;
import edu.hzcc.webdemo.pojo.Fukuandan;
import edu.hzcc.webdemo.pojo.Kucun;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
import sun.security.jca.GetInstance;
/**
 
 * 采购收货页面交互，页面根据cls:'CaigoufahuoController',mtd:'findAll'来调用
 * 结果返回页面
 */
//这里的拼音是标错了吗？Caigoufahuo采购发货，caigoushouhuo采购收货？？？？？？？？？？？？？？？？？？？？
public class CaigoufahuoController extends ControllerBase{

	public void findAll(){
		System.out.println("OrderGoodController.findALL()");
		//定义一个空的caigoufahuoList列表
		List<Caigoufahuo> caigoufahuoList=new ArrayList<>();
		//在caigoufahuoDao中数据库操作 找出所有的caigoufahuo列表
		caigoufahuoList=CaigoufahuoDao.findALL();
		//定义一个json格式
		JSONObject jsonObject = new JSONObject();
		//把caigoufahuoList列表填入json
		jsonObject.put("caigoufahuoList", caigoufahuoList);
		//原路返回caigoufahuoList列表，用writeJson返回Json数据名字为caigoufahuoList
		writeJson(jsonObject.toString());
		return;
	}
	
	public void delete(){
		System.out.println("caigoufahuoController.delete()");
		//getParameterInt收到页面提交的caigoufahuoID--->要和data中的caigoufahuoID一样
		int caigoufahuoID=getParameterInt("caigoufahuoID");
		//在CaigoufahuoDao中数据库操作 删除一采购收货
		CaigoufahuoDao.delete(caigoufahuoID);
		return;
	}
	
	public void save() {
		System.out.println("caigoufahuoController.save()");
		Caigoufahuo caigoufahuo=new Caigoufahuo();
		//getParameter("yaopingID")获取页面的传来值yaopingID
		 // "yaopingID"要和页面的Input的name="yaopingID"一样
		caigoufahuo.setYaopingID(getParameterInt("yaopingID"));
		caigoufahuo.setYaopingMingzi(getParameter("yaopingMingzi"));
		caigoufahuo.setYaopingDanwei(getParameter("yaopingDanwei"));
		caigoufahuo.setShuliang(getParameterInt("shuliang"));
		caigoufahuo.setZongjia(getParameterDouble("zongjia"));
		caigoufahuo.setRiqi(getParameter("riqi"));
		caigoufahuo.setGongyingshangID(getParameterInt("gongyingshangID"));
		caigoufahuo.setCaigoudingdangID(getParameterInt("caigoudingdangID"));
		//调用CaigoufahuoDao的保存操作
		CaigoufahuoDao.save(caigoufahuo);

			
		
	}
	
	public void update() {
		System.out.println("caigoufahuoController.save()");
		Caigoufahuo caigoufahuo=new Caigoufahuo();
		//getParameter("yaopingID")获取页面的传来值yaopingID
		 // "yaopingID"要和页面的Input的name="yaopingID"一样
		caigoufahuo.setYaopingID(getParameterInt("yaopingID"));
		caigoufahuo.setYaopingMingzi(getParameter("yaopingMingzi"));
		caigoufahuo.setYaopingDanwei(getParameter("yaopingDanwei"));
		caigoufahuo.setShuliang(getParameterInt("shuliang"));
		caigoufahuo.setZongjia(getParameterDouble("zongjia"));
		caigoufahuo.setRiqi(getParameter("riqi"));
		caigoufahuo.setGongyingshangID(getParameterInt("gongyingshangID"));
		caigoufahuo.setCaigoudingdangID(getParameterInt("caigoudingdangID"));
		caigoufahuo.setCaigoufahuoID(getParameterInt("caigoufahuoID"));
		caigoufahuo.setComplete(getParameterInt("complete"));
		//当采购收货保存这次更新
		if(CaigoufahuoDao.save(caigoufahuo)){
			//如果这次更新是采购收货审核时（Complete=1为审核）
			if(caigoufahuo.getComplete()>0){
				Fukuandan fukuandan=new Fukuandan();
				fukuandan.setZhuangtai(0);
				fukuandan.setBeizhi("采购收货订单付款");
				fukuandan.setCaigoudingdangID(caigoufahuo.getCaigoudingdangID());
				fukuandan.setGongyingshangID(caigoufahuo.getGongyingshangID());
				fukuandan.setQianshu(caigoufahuo.getZongjia());
				fukuandan.setRiqi(caigoufahuo.getRiqi());
				fukuandan.setCaigoufahuoID(caigoufahuo.getCaigoufahuoID());
				FukuandanDao.save(fukuandan);
			}
		}
	}
//	//？？？？？？？？？？？？？？？？？？？？？？？？？
//	public void findOrderGoodByBusinessID(){
//		System.out.println("caigoufahuoController.findOrderGoodByBusinessID()");
//		if(getParameterInt("gongyingshangID")>0){
//			List<Caigoufahuo> caigoufahuoList=new ArrayList<>();
//			caigoufahuoList=CaigoufahuoDao.findBycaigoudingdangID(getParameterInt("gongyingshangID"));
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("caigoufahuoList", caigoufahuoList);
//			writeJson(jsonObject.toString());
//			return;
//		}
//	}
}
