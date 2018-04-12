/*package kucunyujing;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.KucunDao;
import edu.hzcc.webdemo.pojo.KucunJisuang;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
*//**
 * 找出所有预警的库存
 *//*
public class KucunyujingController extends ControllerBase{

	*//**
	 * 找出所有预警的库存
	 *//*
	public void findAllMinNumber(){
		System.out.println("kucunController.findAllMinNumber()");
		List<KucunJisuang> AllMinNumber=new ArrayList<>();
		AllMinNumber=KucunDao.findAllMinshuliang();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("AllMinNumber", AllMinNumber);
		writeJson(jsonObject.toString());
		return;
	}
}
*/