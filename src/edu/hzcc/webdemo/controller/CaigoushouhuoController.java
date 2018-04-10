package edu.hzcc.webdemo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.util.ControllerBase;
/**

 * 采购收货订单汇总的交互，页面根据cls:'CaigoushouhuoController',mtd:'findAll'来调用
 * 结果返回页面
 */
public class CaigoushouhuoController extends ControllerBase{

	public void findAll(){
		System.out.println("CaigoushouhuoController.findALL()");
		//定义一个空的caigoudingdan列表
		List<Dingdan> caigoudingdanList=new ArrayList<>();
		//在caigoudingdanDao中数据库操作 找出所有的caigoudingdanlist列表
		Dingdan dingdan = new Dingdan();
		dingdan.setDingdanleixing(2);
		caigoudingdanList=DingdanDao.findALL(dingdan);
		//定义一个json格式
		JSONObject jsonObject = new JSONObject();
		//把caigoudingdanlist列表填入json
		jsonObject.put("caigoudingdanList", caigoudingdanList);
		//原路返回caigoudingdanlist列表，用writeJson返回Json数据名字为caigoudingdanglist
		writeJson(jsonObject.toString());
		return;
	}

	public void delete(){
		System.out.println("CaigoushouhuoController.delete()");
		//getParameterInt收到页面提交的dingdanID--->要和data中的dingdanID一样
		int dingdanID = getParameterInt("dingdanID");
		//在DingdanDao中数据库操作 删除一个订单
		DingdanDao.delete(dingdanID);
		return;
	}
	
	public void save() {
		Dingdan caigoudingdan=new Dingdan();
		caigoudingdan.setDingdanBianhao(getParameter("dingdanBianhao"));
		caigoudingdan.setYaopingID(getParameterInt("yaopingID"));
		caigoudingdan.setDanjia(getParameterDouble("danjia"));
		caigoudingdan.setShuliang(getParameterInt("shuliang"));
		caigoudingdan.setZongjia(caigoudingdan.getDanjia() * caigoudingdan.getShuliang());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caigoudingdan.setRiqi(sdf.format(date));
		caigoudingdan.setGongyingshangID(getParameterInt("gongyingshangID"));
		caigoudingdan.setCangkuID(getParameterInt("cangkuID"));
		caigoudingdan.setDingdanleixing(2);
		caigoudingdan.setKehuID(0);
		caigoudingdan.setComplete(0);
		DingdanDao.save(caigoudingdan);
	}
	
	public void update() {
		Dingdan caigoudingdan=new Dingdan();
		caigoudingdan.setDingdanID(getParameterInt("dingdanID"));
		caigoudingdan.setDingdanBianhao(getParameter("dingdanBianhao"));
		caigoudingdan.setYaopingID(getParameterInt("yaopingID"));
		caigoudingdan.setDanjia(getParameterDouble("danjia"));
		caigoudingdan.setShuliang(getParameterInt("shuliang"));
		caigoudingdan.setZongjia(caigoudingdan.getDanjia() * caigoudingdan.getShuliang());
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		caigoudingdan.setRiqi(sdf.format(date));
		caigoudingdan.setGongyingshangID(getParameterInt("gongyingshangID"));
		caigoudingdan.setCangkuID(getParameterInt("cangkuID"));
		caigoudingdan.setDingdanleixing(2);
		caigoudingdan.setKehuID(0);
		caigoudingdan.setComplete(0);
		DingdanDao.update(caigoudingdan);
	}
	

}
