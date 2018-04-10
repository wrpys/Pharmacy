package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.YaopingDao;
import edu.hzcc.webdemo.dao.KucunDao;
import edu.hzcc.webdemo.pojo.Yaoping;
import edu.hzcc.webdemo.pojo.Kucun;
import edu.hzcc.webdemo.pojo.KucunJisuang;
import edu.hzcc.webdemo.sys.ProjectShare;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**
 * 
 * 库存页面交互，页面根据cls:'GongyingshangController',mtd:'findAll'来调用
 * 结果返回页面
 */
public class KucunController extends ControllerBase{

	public void findAll(){
		System.out.println("kucunController.getALL()");
		//定义一个空的kucun列表
		List<Kucun> kucunList=new ArrayList<>();
		//在kucunDao中数据库操作 找出所有的kucun列表
		kucunList=KucunDao.findALL();
		//定义一个json格式
		JSONObject jsonObject = new JSONObject();
		//把kucun列表填入json
		jsonObject.put("kucunList", kucunList);
		//原路返回kucun列表，用writeJson返回Json数据名字为kucun
		writeJson(jsonObject.toString());
		System.out.println(jsonObject.toString());
		return;
	}
////下面除了update与save都解释下，就回答每段功能是被谁调用，返回到哪里？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？	
//	/*
//	 * 采购订单存余数
//	 */
//	public void findDetail(){
//		System.out.println("kucunController.findDetail()");
//		List<Kucun> kucunDetailList=new ArrayList<>();
//		kucunDetailList=KucunDao.findDetail();
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("kucunDetailList", kucunDetailList);
//		writeJson(jsonObject.toString());
//		return;
//	}
	
	public void save() {
		Kucun kucun=new Kucun();
		kucun.setYaopingID(getParameterInt("yaopingID"));
		kucun.setYaopingMingzi(getParameter("yaopingMingzi"));
		kucun.setDingdanhao(getParameterInt("dingdanhao"));
		kucun.setYaopingDanwei(getParameter("yaopingDanwei"));
		kucun.setShuliang(getParameterInt("shuliang"));
		kucun.setRiqi(getParameter("riqi"));
		kucun.setZhuangtai(getParameterInt("zhuangtai"));
		System.out.println(kucun.toString());
		if(KucunDao.save(kucun)){
			Yaoping yaoping=YaopingDao.findByYaopingID(kucun.getYaopingID());
			if(yaoping!=null){
				if(kucun.getZhuangtai()==1){
					YaopingDao.updateNumber(yaoping.getYaopingID(), yaoping.getShuliang()+kucun.getShuliang());
				}
				if(kucun.getZhuangtai()==2){
					YaopingDao.updateNumber(yaoping.getYaopingID(), yaoping.getShuliang()-kucun.getShuliang());
				}
			}
		}
	}
	
	public void update() {
		Kucun kucun=new Kucun();
		kucun.setYaopingID(getParameterInt("yaopingID"));
		kucun.setYaopingMingzi(getParameter("yaopingMingzi"));
		kucun.setDingdanhao(getParameterInt("dingdanhao"));
		kucun.setYaopingDanwei(getParameter("yaopingDanwei"));
		kucun.setShuliang(getParameterInt("shuliang"));
		kucun.setRiqi(getParameter("riqi"));
		kucun.setZhuangtai(getParameterInt("zhuangtai"));
		kucun.setKucunID(getParameterInt("kucunID"));
		KucunDao.save(kucun);
	}
	
	
//	/**
//	 * 根据订单号查找
//	 */
//	public void findALLByOrderID(){
//		System.out.println("kucunController.findALLByOrderID()");
//		List<Kucun> kucunBydingdanhao=new ArrayList<>();
//		kucunBydingdanhao=KucunDao.findALLBydingdanhao(getParameterInt("dingdanhao"));
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("kucunBydingdanhao", kucunBydingdanhao);
//		writeJson(jsonObject.toString());
//		return;
//	}
	
//	public static void main(String[] args) {
//		ProjectShare.initDatabasePool();
//
//		List<kucunSum> kucunSum=new ArrayList<>();
//		kucunSum=kucunDao.findSum();
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("kucunSum", kucunSum);
//		System.out.println(jsonObject.toString());
//	}
}
