package edu.hzcc.webdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.pojo.Caigoufahuo;
import edu.hzcc.webdemo.sys.ProjectShare;
/**
 * 
 * 采购收货的数据库操作
 *以下方法都是由CaigoufahuoController调用，值返回给CaigoufahuoController
 */
public class CaigoufahuoDao {
	/*
	 * 把数据库查到的数据填充到caigoufahuo这个对象中，以便操作
	 * rs.getInt("caigoufahuoID")
	 * rs是数据库查询的结果集
	 * getInt表示什么类型的数据
	 * caigoufahuoID表示数据库定义的字段
	 */
	private static Caigoufahuo convercaigoufahuo(ResultSet rs) throws Exception{
		Caigoufahuo caigoufahuo= new Caigoufahuo();
		caigoufahuo.setCaigoufahuoID(rs.getInt("caigoufahuoID"));
		caigoufahuo.setYaopingID(rs.getInt("yaopingID"));
		caigoufahuo.setYaopingMingzi(rs.getString("yaopingMingzi"));
		caigoufahuo.setYaopingDanwei(rs.getString("yaopingDanwei"));
		caigoufahuo.setShuliang(rs.getInt("shuliang"));
		caigoufahuo.setZongjia(rs.getDouble("zongjia"));
		caigoufahuo.setRiqi(rs.getString("riqi"));
		caigoufahuo.setGongyingshangID(rs.getInt("gongyingshangID"));
		caigoufahuo.setCaigoudingdangID(rs.getInt("caigoudingdangID"));
		caigoufahuo.setComplete(rs.getInt("complete"));
		if(caigoufahuo.getGongyingshangID()>0) {
			caigoufahuo.setGongyingshangMingzi(GongyingshangDao.findByGongyingshangID(caigoufahuo.getGongyingshangID()).getGongyingshangMingzi());
		}
		return caigoufahuo;
		//把数据库查到的数据填充到caigoufahuo这个对象中,返回给使用列表的方法，findALL()中也返回给caigoufahuoController了
	}
	
	public static boolean save(Caigoufahuo caigoufahuo){
		try {
			String sql = null;
			//药品ID是数据库自增的，所以保存不需要页面提交ID，页面保存没有提交yaopingID，更新有，由此来判断是保存还是更新
			if(caigoufahuo.getCaigoufahuoID()>0){
				//执行修改
				sql ="update caigoufahuo set yaopingID= '"+caigoufahuo.getYaopingID()+
						"',yaopingMingzi='"+caigoufahuo.getYaopingMingzi()+
						"',yaopingDanwei='"+caigoufahuo.getYaopingDanwei()+
						"',shuliang='"+caigoufahuo.getShuliang()+
						"',zongjia='"+caigoufahuo.getZongjia()+
						"',riqi='"+caigoufahuo.getRiqi()+
						"',gongyingshangID='"+caigoufahuo.getGongyingshangID()+
						"',caigoudingdangID='"+caigoufahuo.getCaigoudingdangID()+
						"',complete='"+caigoufahuo.getComplete()+
						"' where caigoufahuoID="+caigoufahuo.getCaigoufahuoID();
			}else {
				//执行新增
				sql = "insert into caigoufahuo(caigoudingdangID,yaopingID,yaopingMingzi,yaopingDanwei,"
						+ "shuliang,zongjia,riqi,gongyingshangID,complete)";
				sql += " values('"+caigoufahuo.getCaigoudingdangID()+"','"+caigoufahuo.getYaopingID()+"','"+caigoufahuo.getYaopingMingzi()+"','"+
						caigoufahuo.getYaopingDanwei()+"','"+caigoufahuo.getShuliang()+"','"
						+caigoufahuo.getZongjia()+"','"+caigoufahuo.getRiqi()+"','"+caigoufahuo.getGongyingshangID()+"','"+caigoufahuo.getComplete()+"')";
				
			}
			System.out.print(sql);
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			//开启数据库事物
			ProjectShare.getDbPool().transaction(connection, true);
			//数据库更新
			ProjectShare.getDbPool().update(connection, sql);
			//提交操作
			ProjectShare.getDbPool().commit(connection);
			//事物关闭
			ProjectShare.getDbPool().transaction(connection, false);
			//链接关闭
			ProjectShare.getDbPool().closeConnection(connection);
			
			return true;
			//异常
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("caigoufahuo.save/update error: "+e.getMessage());
			return false;
		}
	}

	public static boolean delete(int caigoufahuoID){
		try {
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			String sql = "delete from caigoufahuo where caigoufahuoID="+caigoufahuoID;
			//表示数据库更新这个链接
			int i=ProjectShare.getDbPool().update(connection, sql);
			//链接关闭
			ProjectShare.getDbPool().closeConnection(connection);
			//更新一次，表示成功，什么叫更新一次就成功？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
			if(i==1)
				return true;
			return false;
			//异常              
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("caigoufahuo .delete error: "+e.getMessage());
			return false;
		}
	}

	public static List<Caigoufahuo> findALL(){
		try {
			List<Caigoufahuo> list = new ArrayList<>();
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from caigoufahuo";
			//返回数据库结果集
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			//循环结果集，一个个填充入List<Caigoufahuo>
			while(rs.next()){
				//把结果集填入caigoufahuo对象
				Caigoufahuo caigoufahuo = convercaigoufahuo(rs);
				list.add(caigoufahuo);//list添加然后去了哪？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
				
			}
			//结果集关闭
			rs.close();
			//数据量链接关闭
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;//找到所有采购收货列表，返回给CaigoufahuoController
			//异常
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("caigoufahuo.findALL error: "+e.getMessage());
			return null;
		}
	}
//	//什么意思啊，被谁调用了这个方法？？？？？？？？？？？？？？？？？？？？？？？？？？？？
//	public static List<Caigoufahuo> findBygongyingshangID(int gongyingshangID){
//		try {
//			List<Caigoufahuo> list = new ArrayList<>();
//			Connection connection = ProjectShare.getDbPool().getConnection();
//			
//			String sql = "select * from caigoufahuo where gongyingshangID="+gongyingshangID;
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			while(rs.next()){
//				Caigoufahuo caigoufahuo = convercaigoufahuo(rs);
//				list.add(caigoufahuo);
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
//			ProjectShare.log("caigoufahuo.findDetail error: "+e.getMessage());
//			return null;
//		}
//	}
	//什么意思啊，被谁调用了这个方法？？？？？？？？？？？？？？？？？？？？？？？？？？？？
//	public static List<Caigoufahuo> findBycaigoudingdangID(int caigoudingdangID){
//		try {
//			List<Caigoufahuo> list = new ArrayList<>();
//			Connection connection = ProjectShare.getDbPool().getConnection();
//			
//			String sql = "select * from caigoufahuo where caigoudingdangID="+caigoudingdangID;
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			while(rs.next()){
//				Caigoufahuo caigoufahuo = convercaigoufahuo(rs);
//				list.add(caigoufahuo);
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
//			ProjectShare.log("caigoufahuo.findBycaigoudingdangID error: "+e.getMessage());
//			return null;
//		}
//	}
//	
	//付款单有CaigoufahuoID，是采购收货是保存的，在付款单结算后，要生成一条库存，根据付款单的CaigoufahuoID，找出库存的明细
	public static Caigoufahuo findOne(int caigoufahuoID){
		try {
			Caigoufahuo caigoufahuo=new Caigoufahuo();
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from caigoufahuo where caigoufahuoID="+caigoufahuoID;
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			if(rs.next()){
				caigoufahuo = convercaigoufahuo(rs);
				
				
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return caigoufahuo;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("caigoufahuo.findBycaigoudingdangID error: "+e.getMessage());
			return null;
		}
	}
	

}
