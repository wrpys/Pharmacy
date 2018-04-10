package edu.hzcc.webdemo.controller;

import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.dao.CangkusheziDao;
import edu.hzcc.webdemo.pojo.Cangkushezi;
import edu.hzcc.webdemo.util.ControllerBase;
import net.sf.json.JSONObject;
/**
 * 预警设置
 *
 */
public class CangkusheziController extends ControllerBase{

	public void findAll() {
		System.out.println("cangkusheziController.getALL()");
		List<Cangkushezi> cangkushezi=new ArrayList<>();
		cangkushezi=CangkusheziDao.findALL();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("cangkushezi", cangkushezi);
		System.out.println(jsonObject.toString());
		writeJson(jsonObject.toString());
		return;
	}
	
	public void delete() {
		System.out.println("cangkusheziController.delete()");
		int id=getParameterInt("id");
		CangkusheziDao.delete(id);
		return;
	}
	
	public void save() {
		System.out.println("cangkusheziController.save()");
		Cangkushezi cangkushezi=new Cangkushezi();
		cangkushezi.setCangkuID(getParameterInt("cangkuID"));
		cangkushezi.setYaopingID(getParameterInt("yaopingID"));
		cangkushezi.setZuishaoshuliang(getParameterInt("zuishaoshuliang"));
		CangkusheziDao.save(cangkushezi);
	}
	public void update() {
		System.out.println("cangkusheziController.save()");
		Cangkushezi cangkushezi=new Cangkushezi();
		cangkushezi.setCangkuID(getParameterInt("cangkuID"));
		cangkushezi.setYaopingID(getParameterInt("yaopingID"));
		cangkushezi.setZuishaoshuliang(getParameterInt("zuishaoshuliang"));
			cangkushezi.setId(getParameterInt("Cangkusheziid"));
		CangkusheziDao.save(cangkushezi);
	}
}
