package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.ZhanghuDao;
import edu.hzcc.webdemo.dao.CaigoufahuoDao;
import edu.hzcc.webdemo.dao.FukuandanDao;
import edu.hzcc.webdemo.dao.KucunDao;
import edu.hzcc.webdemo.pojo.Caigoufahuo;
import edu.hzcc.webdemo.pojo.Fukuandan;
import edu.hzcc.webdemo.pojo.Kucun;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**
 * 付款操作
 *
 */
public class FukuandanController extends ControllerBase{

	public void findAll(){
		System.out.println("fukuandanDController.findAll()");
		List<Fukuandan> fukuandanList=new ArrayList<>();
		fukuandanList=FukuandanDao.findALL();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("fukuandanList", fukuandanList);
		writeJson(jsonObject.toString());
		System.out.println(jsonObject.toString());
		return;
	}
	
	public void save() {
		System.out.println("fukuandanDController.save()");
		Fukuandan fukuandan=new Fukuandan();
		fukuandan.setGongyingshangID(getParameterInt("gongyingshangID"));
		fukuandan.setRiqi(getParameter("riqi"));
		fukuandan.setCaigoudingdangID(getParameterInt("caigoudingdangID"));
		fukuandan.setQianshu(getParameterDouble("qianshu"));
		fukuandan.setBeizhi(getParameter("beizhi"));
		fukuandan.setZhuangtai(getParameterInt("zhuangtai"));
		fukuandan.setCaigoufahuoID(getParameterInt("caigoufahuoID"));
		FukuandanDao.save(fukuandan);
	}
	
	public void update() {
		System.out.println("fukuandanDController.save()");
		Fukuandan fukuandan=new Fukuandan();
		fukuandan.setGongyingshangID(getParameterInt("gongyingshangID"));
		fukuandan.setRiqi(getParameter("riqi"));
		fukuandan.setCaigoudingdangID(getParameterInt("caigoudingdangID"));
		fukuandan.setQianshu(getParameterDouble("qianshu"));
		fukuandan.setBeizhi(getParameter("beizhi"));
		fukuandan.setZhuangtai(getParameterInt("zhuangtai"));
		fukuandan.setFukuandanID(getParameterInt("fukuandanID"));
		fukuandan.setCaigoufahuoID(getParameterInt("caigoufahuoID"));
		//付款单更新成功
		if(FukuandanDao.save(fukuandan)){
			//如果这个付款单更新是结算是，就生成一条库存，Zhuangtai=1是结算
			if(fukuandan.getZhuangtai()>0){
				Caigoufahuo caigoufahuo=new Caigoufahuo();
				caigoufahuo=CaigoufahuoDao.findOne(fukuandan.getCaigoufahuoID());
				Kucun kucun=new Kucun();
				kucun.setYaopingDanwei(caigoufahuo.getYaopingDanwei());
				kucun.setDingdanhao(caigoufahuo.getCaigoudingdangID());
				kucun.setYaopingID(caigoufahuo.getYaopingID());
				kucun.setYaopingMingzi(caigoufahuo.getYaopingMingzi());
				kucun.setShuliang(caigoufahuo.getShuliang());
				kucun.setRiqi(caigoufahuo.getRiqi());
				kucun.setZhuangtai(1);
				KucunDao.save(kucun);
				//付款单更新是结算时，找出账户钱-付款钱，再更新账户
				ZhanghuDao.updatezhanghuQianshu(1, ZhanghuDao.findOne(1).getQianshu()-fukuandan.getQianshu());

			}
		}
	}
	public void delete(){
		System.out.println("fukuandanDController.delete()");
		int fukuandanID=getParameterInt("fukuandanID");
		FukuandanDao.delete(fukuandanID);
		return;
	}
}
