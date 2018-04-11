package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.pojo.CangkuHuizongbiao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;

public class CangkuhuizongController extends ControllerBase{

	/**
	 * 采购订单列表
	 */
	public void findCaigouDingdan() {
		List<Dingdan> dingdanList = DingdanDao.findDingdan(1);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("dingdanList", dingdanList);
		System.out.println(jsonObject.toString());
		writeJson(jsonObject.toString());
		return;
	}
	
	/**
	 * 更新采购订单列表
	 */
	public void update() {
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanID(getParameterInt("dingdanID"));
		dingdan.setDanjia(getParameterDouble("danjia"));
		dingdan.setShuliang(getParameterInt("shuliang"));
		dingdan.setZongjia(getParameterDouble("zongjia"));
		dingdan.setRiqi(getParameter("riqi"));
		dingdan.setGongyingshangID(getParameterInt("gongyingshangID"));
		dingdan.setKehuID(getParameterInt("kehuID"));
		dingdan.setCangkuID(getParameterInt("cangkuID"));
		dingdan.setComplete(getParameterInt("complete"));
		DingdanDao.update(dingdan);
	}
	
	/**
	 * 删除采购订单列表
	 */
	public void delete() {
		DingdanDao.delete(getParameterInt("dingdanID"));
	}
	
	/**
	 * 销售订单表
	 */
	public void findXiaoshouDingdan(){
		List<Dingdan> dingdanList = DingdanDao.findDingdan(2);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("dingdanList", dingdanList);
		System.out.println(jsonObject.toString());
		writeJson(jsonObject.toString());
		return;
	}
	
	/**
	 * 仓库汇总表
	 */
	public void findCangkuHuizongbiao(){
		List<Integer> yaoPingIDs = DingdanDao.getYaopingIdDistinct();
		Map<Integer,List<CangkuHuizongbiao>> mapList = DingdanDao.findCangkuHuizongbiao(yaoPingIDs);
		List<CangkuHuizongbiao> dataList = tongji(mapList);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("dataList", dataList);
		System.out.println(jsonObject.toString());
		writeJson(jsonObject.toString());
		return;
	}
	
	private List<CangkuHuizongbiao> tongji(Map<Integer,List<CangkuHuizongbiao>> mapList){
		List<CangkuHuizongbiao> list = new ArrayList<>();
		for (Map.Entry<Integer, List<CangkuHuizongbiao>> entry : mapList.entrySet()) {
			List<CangkuHuizongbiao> dataList = entry.getValue();
			int rukuzongshu = 0;
			int chukuzongshu = 0;
			for (CangkuHuizongbiao cangkuHuizongbiao : dataList) {
				if(cangkuHuizongbiao.getDingdanleixing()==2) {
					rukuzongshu+=cangkuHuizongbiao.getShuliang();
				}else if(cangkuHuizongbiao.getDingdanleixing()==4){
					chukuzongshu+=cangkuHuizongbiao.getShuliang();
				}
			}
			CangkuHuizongbiao cangkuHuizongbiao = dataList.get(0);
			cangkuHuizongbiao.setChukuzongshu(chukuzongshu);
			cangkuHuizongbiao.setRukuzongshu(rukuzongshu);
			list.add(cangkuHuizongbiao);
		}
		return list;
	}
}
