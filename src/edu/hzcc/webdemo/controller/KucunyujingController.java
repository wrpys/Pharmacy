package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.CangkusheziDao;
import edu.hzcc.webdemo.dao.DingdanDao;
import edu.hzcc.webdemo.dao.KucunDao;
import edu.hzcc.webdemo.pojo.Cangkushezi;
import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.pojo.Kucun;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**
 * 找出所有预警的库存
 */
public class KucunyujingController extends ControllerBase{

	/**
	 * 找出所有预警的库存
	 */
	public void findYujing() {
		List<Cangkushezi> returnCangkushezi=new ArrayList<>();
		System.out.println("cangkusheziController.getALL()");
		List<Cangkushezi> cangkushezi=new ArrayList<>();
		cangkushezi=CangkusheziDao.findALL();
		for (Cangkushezi cangkushezi2 : cangkushezi) {
			Kucun kucun = KucunDao.findAllMinshuliang(cangkushezi2.getCangkuID(),cangkushezi2.getYaopingID());
			if(0 != kucun.getKucunID() || null != kucun){
				Dingdan dingdan = new Dingdan();
				dingdan.setDingdanID(kucun.getDingdanID());
				cangkushezi2.setDingdan(DingdanDao.findDingdanByPK(dingdan));
				cangkushezi2.setKucun(kucun);
				if(kucun.getShuliang()<cangkushezi2.getZuishaoshuliang()) {
					returnCangkushezi.add(cangkushezi2);
				}
			}
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("returnCangkushezi", returnCangkushezi);
		System.out.println(jsonObject.toString());
		writeJson(jsonObject.toString());
		return;
	}
	/*public void findAllMinNumber(){
		System.out.println("kucunController.findAllMinNumber()");
		List<KucunJisuang> AllMinNumber=new ArrayList<>();
		AllMinNumber=KucunDao.findAllMinshuliang();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("AllMinNumber", AllMinNumber);
		writeJson(jsonObject.toString());
		return;
	}*/
}
