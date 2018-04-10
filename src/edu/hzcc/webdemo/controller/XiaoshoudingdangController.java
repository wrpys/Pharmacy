package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.XiaoshoudingdangDao;
import edu.hzcc.webdemo.pojo.Xiaoshoudingdang;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**
 * 销售订单
 *
 */
public class XiaoshoudingdangController extends ControllerBase {

	public void findALL(){
		System.out.println("xiaoshoudingdangController.findALL()");
		List<Xiaoshoudingdang> xiaoshoudingdangList=new ArrayList<>();
		xiaoshoudingdangList=XiaoshoudingdangDao.findALL();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("xiaoshoudingdangList", xiaoshoudingdangList);
		writeJson(jsonObject.toString());
		System.out.println(jsonObject.toString());
		return;
	}
	
	public void delete(){
		System.out.println("xiaoshoudingdangController.delete()");
		int xiaoshoudingdangID = getParameterInt("xiaoshoudingdangID");
		XiaoshoudingdangDao.delete(xiaoshoudingdangID);
		return;
	}
	
	public void save() {
		System.out.println("xiaoshoudingdangController.findALL()");
		Xiaoshoudingdang xiaoshoudingdang=new Xiaoshoudingdang();
		xiaoshoudingdang.setYaopingID(getParameterInt("yaopingID"));
		xiaoshoudingdang.setYaopingMingzi(getParameter("yaopingMingzi"));
		xiaoshoudingdang.setYaopingDanwei(getParameter("yaopingDanwei"));
		xiaoshoudingdang.setShuliang(getParameterInt("shuliang"));
		xiaoshoudingdang.setZongjia(getParameterDouble("zongjia"));
		xiaoshoudingdang.setRiqi(getParameter("riqi"));
		xiaoshoudingdang.setKehuID(getParameterInt("kehuID"));
		xiaoshoudingdang.setCangkuID(getParameterInt("cangkuID"));
		xiaoshoudingdang.setXiaoshoudingdangID(getParameterInt("xiaoshoudingdangID"));
		XiaoshoudingdangDao.save(xiaoshoudingdang);
	}
	public void update() {
		System.out.println("xiaoshoudingdangController.findALL()");
		Xiaoshoudingdang xiaoshoudingdang=new Xiaoshoudingdang();
		xiaoshoudingdang.setYaopingID(getParameterInt("yaopingID"));
		xiaoshoudingdang.setYaopingMingzi(getParameter("yaopingMingzi"));
		xiaoshoudingdang.setYaopingDanwei(getParameter("yaopingDanwei"));
		xiaoshoudingdang.setShuliang(getParameterInt("shuliang"));
		xiaoshoudingdang.setZongjia(getParameterDouble("zongjia"));
		xiaoshoudingdang.setComplete(getParameterInt("complete"));
		xiaoshoudingdang.setRiqi(getParameter("riqi"));
		xiaoshoudingdang.setCangkuID(getParameterInt("cangkuID"));
		xiaoshoudingdang.setKehuID(getParameterInt("kehuID"));
		xiaoshoudingdang.setXiaoshoudingdangID(getParameterInt("xiaoshoudingdangID"));
		XiaoshoudingdangDao.update(xiaoshoudingdang);
		System.out.println(xiaoshoudingdang);
	}
	/**
	 * 根据客户ID
	 */
	//这里是什么意思？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
//	public void findxiaoshoudingdangByKehuID(){
//		System.out.println("xiaoshoudingdangController.findxiaoshoudingdangByCustomerID()");
//		if(getParameterInt("kehuID")>0){
//			List<Xiaoshoudingdang> xiaoshoudingdangList=new ArrayList<>();
//			xiaoshoudingdangList=XiaoshoudingdangDao.findAllByCustomerID(getParameterInt("kehuID"));
//			JSONObject jsonObject = new JSONObject();
//			jsonObject.put("xiaoshoudingdangList", xiaoshoudingdangList);
//			writeJson(jsonObject.toString());
//			return;
//		}
//	} 
}
