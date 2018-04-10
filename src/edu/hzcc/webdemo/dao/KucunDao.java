package edu.hzcc.webdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.pojo.Kucun;
import edu.hzcc.webdemo.pojo.KucunJisuang;
import edu.hzcc.webdemo.pojo.Caigoudingdang;
import edu.hzcc.webdemo.sys.ProjectShare;
/**
 * 库存数据库操作
 *
 */
public class KucunDao {

	private static Kucun converkucun(ResultSet rs) throws Exception{
		Kucun kucun= new Kucun();
		kucun.setKucunID(rs.getInt("kucunID"));
		kucun.setYaopingID(rs.getInt("yaopingID"));
		kucun.setYaopingMingzi(rs.getString("yaopingMingzi"));
		kucun.setDingdanhao(rs.getInt("dingdanhao"));
		kucun.setYaopingDanwei(rs.getString("yaopingDanwei"));
		kucun.setShuliang(rs.getInt("shuliang"));
		kucun.setRiqi(rs.getString("riqi"));
		kucun.setZhuangtai(rs.getInt("zhuangtai"));
		return kucun;
	}
//没有实现数据库数量操作以及状态？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？	
	public static boolean save(Kucun kucun){
		try {
			String sql = null;
			if(kucun.getKucunID()>0){
				//执行修改
				sql ="update kucun set yaopingID= '"+kucun.getYaopingID()+
						"',yaopingMingzi='"+kucun.getYaopingMingzi()+
						"',yaopingDanwei='"+kucun.getYaopingDanwei()+
						"',dingdanhao='"+kucun.getDingdanhao()+
						"',shuliang='"+kucun.getShuliang()+
						"',riqi='"+kucun.getRiqi()+
						"',zhuangtai="+kucun.getZhuangtai()+
						" where kucunID="+kucun.getKucunID();
			}else {
				//执行新增
				sql = "insert into kucun(yaopingID,yaopingMingzi,dingdanhao,yaopingDanwei,shuliang,riqi,zhuangtai)";
				sql += " values('"+kucun.getYaopingID()+"','"+kucun.getYaopingMingzi()+"','"+kucun.getDingdanhao()+"','"+
						kucun.getYaopingDanwei()+"','"+kucun.getShuliang()+"','"+kucun.getRiqi()+"',"
						+kucun.getZhuangtai()+")";
				
			}
			System.out.print(sql);
			Connection connection = ProjectShare.getDbPool().getConnection();
			ProjectShare.getDbPool().transaction(connection, true);
			ProjectShare.getDbPool().update(connection, sql);
			ProjectShare.getDbPool().commit(connection);
			ProjectShare.getDbPool().transaction(connection, false);
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("kucun.save/update error: "+e.getMessage());
			return false;
		}
	}
	public static boolean delete(int kucunID){
		try {
			Connection connection = ProjectShare.getDbPool().getConnection();
			String sql = "delete from kucun where kucunID="+kucunID;
			int i=ProjectShare.getDbPool().update(connection, sql);
			
			ProjectShare.getDbPool().closeConnection(connection);
			if(i==1)
				return true;
			return false;
			          
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("kucun .delete error: "+e.getMessage());
			return false;
		}
	}

	/*
	 * 总入出库明细
	 */
	public static List<Kucun> findALL(){
		List<Kucun> list = new ArrayList<>();
		try {
			Connection connection = ProjectShare.getDbPool().getConnection();
	//主要是状态是怎么，下面这句话解释下？？？？？？？？1入库2出库    数据库中zhuangtai  1是入库  2是出库  在保存的时候  生成  


			String sql = "select * from kucun where zhuangtai in (1,2)";
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			while(rs.next()){
				Kucun kucun = converkucun(rs);
				list.add(kucun);
				System.out.println(kucun.toString());
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("kucun.findALL error: "+e.getMessage());
			return list;
		}
	}
	
	/*
	 * 订单入出库明细
	 */
//	public static List<Kucun> findALLBydingdanhao(int dingdanhao){
//		try {
//			List<Kucun> list = new ArrayList<>();
//			Connection connection = ProjectShare.getDbPool().getConnection();
//		//下面这句话解释下？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？	
//			String sql = "select * from kucun where dingdanhao='"+dingdanhao+"' and zhuangtai in (1,2)";
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			while(rs.next()){
//				Kucun kucun = converkucun(rs);
//				list.add(kucun);
//				
//			}
//			rs.close();
//			
//			ProjectShare.getDbPool().closeConnection(connection);
//			
//			return list;
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			ProjectShare.log("kucun.findALL error: "+e.getMessage());
//			return null;
//		}
//	}
	
//	/*
//	 * 采购订单存余数
//	 */
//	public static List<Kucun> findDetail(){
//		try {
//			List<Kucun> list = new ArrayList<>();
//			Connection connection = ProjectShare.getDbPool().getConnection();
//			//下面这句话解释下？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？		
//			String sql = "select * from kucun where zhuangtai='0' ";
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			while(rs.next()){
//				Kucun kucun = converkucun(rs);
//				list.add(kucun);
//				
//			}
//			rs.close();
//			
//			ProjectShare.getDbPool().closeConnection(connection);
//			
//			return list;
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			ProjectShare.log("kucun.findALL error: "+e.getMessage());
//			return null;
//		}
//	}
	/**
	 * 
	 * @return 数据少于预警设置数量的库存列表
	 */
//详细写一下？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
	public static  List<KucunJisuang> findAllMinshuliang(){
		try {
			List<KucunJisuang> list = new ArrayList<>();
			Connection connection = ProjectShare.getDbPool().getConnection();
			//获取药品的总数量小于设置的数量的所有药品ｉｄ
			List<Integer> drugs=CangkusheziDao.findZuishaoshuliangOfYaopingID();
			//List<Integer> drugs是[1,2,3]这种格式，通过循环弄成（1，2，3）这个格式
			String drusID="(";
			for(int i=0;i<drugs.size();i++){
				drusID+=drugs.get(i);
				drusID+=",";
			}
			//以上生成（1，2，3,这个格式,下面这句是去掉逗号，变成（1，2，3
			drusID=drusID.substring(0, drusID.length()-1);
			drusID+=")";
			System.out.println(drusID);
			//下面这句话解释下？？？？？？？？？计算出药品ＩＤ，入库，出库，库存数	
			String sql = "SELECT ininven.yaopingID,ininven.yaopingMingzi,ininven.yaopingDanwei,ininven.ininvensum,outinven.outinvensum,ininven.ininvensum-outinven.outinvensum as inoutinven FROM "+
					"(SELECT kucun.yaopingID,kucun.yaopingMingzi,kucun.yaopingDanwei,SUM(kucun.shuliang) as ininvensum FROM kucun WHERE kucun.zhuangtai=1 group by kucun.yaopingID) as ininven "+
					"JOIN (SELECT kucun.yaopingID, SUM(kucun.shuliang)  as outinvensum FROM kucun WHERE kucun.zhuangtai=2 group by kucun.yaopingID) as outinven ON outinven.yaopingID=ininven.yaopingID"+
					" WHERE ininven.yaopingID IN  "+drusID;
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			while(rs.next()){
				KucunJisuang kucunSum=new KucunJisuang();
				kucunSum.setYaopingID(rs.getInt("yaopingID"));
				kucunSum.setYaopingMingzi(rs.getString("yaopingMingzi"));
				kucunSum.setYaopingDanwei(rs.getString("yaopingDanwei"));
				kucunSum.setZongruku(rs.getInt("ininvensum"));
				kucunSum.setZongchuku(rs.getInt("outinvensum"));
				kucunSum.setShengyushu(rs.getInt("inoutinven"));
				list.add(kucunSum);
				
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("kucun.findALL error: "+e.getMessage());
			return null;
		}
	
	}
	/*
	 * 汇总表
	 */
	//为什么库存调拨单里面有汇总，分开写？？汇总表和挑拨单都是在kucun这张表操作的
	public static  List<KucunJisuang>  findSum(){
		try {
			List<KucunJisuang> list = new ArrayList<>();
			Connection connection = ProjectShare.getDbPool().getConnection();
		
			String sql = "SELECT ininven.yaopingID,ininven.yaopingMingzi,ininven.yaopingDanwei,ininven.ininvensum,outinven.outinvensum,ininven.ininvensum-outinven.outinvensum as inoutinven FROM "+
					"(SELECT kucun.yaopingID,kucun.yaopingMingzi,kucun.yaopingDanwei,SUM(kucun.shuliang) as ininvensum FROM kucun WHERE kucun.zhuangtai=1 group by kucun.yaopingID) as ininven "+
					"JOIN (SELECT kucun.yaopingID, SUM(kucun.shuliang)  as outinvensum FROM kucun WHERE kucun.zhuangtai=2 group by kucun.yaopingID) as outinven ON outinven.yaopingID=ininven.yaopingID";
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			while(rs.next()){
				KucunJisuang kucunSum=new KucunJisuang();
				kucunSum.setYaopingID(rs.getInt("yaopingID"));
				kucunSum.setYaopingMingzi(rs.getString("yaopingMingzi"));
				kucunSum.setYaopingDanwei(rs.getString("yaopingDanwei"));
				kucunSum.setZongruku(rs.getInt("ininvensum"));
				kucunSum.setZongchuku(rs.getInt("outinvensum"));
				kucunSum.setShengyushu(rs.getInt("inoutinven"));
				list.add(kucunSum);
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("kucun.findSum error: "+e.getMessage());
			return null;
		}
	}


}
