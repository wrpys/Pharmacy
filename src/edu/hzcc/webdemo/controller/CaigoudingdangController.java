package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.CaigoudingdangDao;
import edu.hzcc.webdemo.pojo.Caigoudingdang;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**

 * 采购订单汇总的交互，页面根据cls:'caigoudingdanController',mtd:'findAll'来调用
 * 结果返回页面
 */
public class CaigoudingdangController extends ControllerBase{

	public void findALL(){
		System.out.println("caigoudingdangController.findALL()");
		//定义一个空的caigoudingdan列表
		List<Caigoudingdang> caigoudingdangList=new ArrayList<>();
		//在caigoudingdanDao中数据库操作 找出所有的caigoudingdanlist列表
		caigoudingdangList=CaigoudingdangDao.findALL();
		//定义一个json格式
		JSONObject jsonObject = new JSONObject();
		//把caigoudingdanlist列表填入json
		jsonObject.put("caigoudingdangList", caigoudingdangList);
		//原路返回caigoudingdanlist列表，用writeJson返回Json数据名字为caigoudingdanglist
		writeJson(jsonObject.toString());
		return;
	}
//	public static void main(String[] args) {
//		ProjectShare.initDatabasePool();
//		System.out.println(caigoudingdangDao.findALL().toString());
//	}
	public void delete(){
		System.out.println("caigoudingdangController.delete()");
		//getParameterInt收到页面提交的caigoudingdangID--->要和data中的caigoudingdangID一样
		int caigoudingdangID = getParameterInt("caigoudingdangID");
		//在caigoudingdangDao中数据库操作 删除一个订单
		CaigoudingdangDao.delete(caigoudingdangID);
		return;
	}
	
	public void save() {
		Caigoudingdang caigoudingdang=new Caigoudingdang();
		//getParameter("yaopingID")获取页面的传来值yaopingID
		 // "yaopingID"要和页面的Input的name="yaopingID"一样
		caigoudingdang.setYaopingID(getParameterInt("yaopingID"));
		caigoudingdang.setYaopingMingzi(getParameter("yaopingMingzi"));
		caigoudingdang.setYaopingDanwei(getParameter("yaopingDanwei"));
		caigoudingdang.setShuliang(getParameterInt("shuliang"));
		caigoudingdang.setZongjia(getParameterDouble("zongjia"));
		caigoudingdang.setRiqi(getParameter("riqi"));
		caigoudingdang.setGongyingshangID(getParameterInt("gongyingshangID"));
		caigoudingdang.setCaigoudingdangID(getParameterInt("caigoudingdangID"));
		caigoudingdang.setCangkuID(getParameterInt("cangkuID"));
		//调用CaigoudingdangDao的保存操作
		CaigoudingdangDao.save(caigoudingdang);
	}
	
	public void update() {
		Caigoudingdang caigoudingdang=new Caigoudingdang();
		//getParameter("yaopingID")获取页面的传来值yaopingID
		 // "yaopingID"要和页面的Input的name="yaopingID"一样
		caigoudingdang.setYaopingID(getParameterInt("yaopingID"));
		caigoudingdang.setYaopingMingzi(getParameter("yaopingMingzi"));
		caigoudingdang.setYaopingDanwei(getParameter("yaopingDanwei"));
		caigoudingdang.setShuliang(getParameterInt("shuliang"));
		caigoudingdang.setZongjia(getParameterDouble("zongjia"));
		caigoudingdang.setRiqi(getParameter("riqi"));
		caigoudingdang.setGongyingshangID(getParameterInt("gongyingshangID"));
		caigoudingdang.setCangkuID(getParameterInt("cangkuID"));
		caigoudingdang.setCaigoudingdangID(getParameterInt("caigoudingdangID"));
		caigoudingdang.setComplete(getParameterInt("complete"));
		CaigoudingdangDao.update(caigoudingdang);
	}
//	/**
//	 * 根据供应商ID查询这个供应商这个类，有些类只有ID，用这个方法来寻找供应商名字
//	 */
//	
//	public void findCaigoudingdangByGongyingshangID(){
//		System.out.println("caigoudingdangController.findCaigoudingdangByGongyingshangID()");
//		if(getParameterInt("gongyingshangID")>0){
//			List<Caigoudingdang> caigoudingdangList=new ArrayList<>();
//			caigoudingdangList=CaigoudingdangDao.findByBusinessID(getParameterInt("gongyingshangID"));
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("caigoudingdangList", caigoudingdangList);
//			writeJson(jsonObject.toString());
//			return;
//		}
//	}
	

}
