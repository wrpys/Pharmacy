package edu.hzcc.webdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hzcc.webdemo.pojo.Caigoudingdang;
import edu.hzcc.webdemo.pojo.Yonghu;
import edu.hzcc.webdemo.sys.ProjectShare;

/**
 
  * 采购订单汇总的数据库操作
 *以下方法都是由GongyingshangController调用，值返回给GongyingshangController
 */
public class CaigoudingdangDao {
	/*
	 * 把数据库查到的数据填充到Caigoudingdang这个对象中，以便操作
	 * rs.getInt("CaigoudingdangID")
	 * rs是数据库查询的结果集
	 * getInt表示什么类型的数据
	 * gongyingshangID表示数据库定义的字段
	 */
	private static Caigoudingdang convercaigoudingdang(ResultSet rs) throws Exception{
		Caigoudingdang caigoudingdang= new Caigoudingdang();
		caigoudingdang.setCaigoudingdangID(rs.getInt("caigoudingdangID"));
		caigoudingdang.setYaopingID(rs.getInt("yaopingID"));
		caigoudingdang.setYaopingMingzi(rs.getString("yaopingMingzi"));
		caigoudingdang.setYaopingDanwei(rs.getString("yaopingDanwei"));
		caigoudingdang.setShuliang(rs.getInt("shuliang"));
		caigoudingdang.setZongjia(rs.getDouble("zongjia"));
		caigoudingdang.setRiqi(rs.getString("riqi"));
		caigoudingdang.setGongyingshangID(rs.getInt("gongyingshangID"));
		caigoudingdang.setCangkuID(rs.getInt("cangkuID"));
		caigoudingdang.setComplete(rs.getInt("complete"));
		//GongyingshangMingzi是数据库caigoudingdang中没有的，是通过GongyingshangID在Gongyingshang这个数据表查找的
		if(caigoudingdang.getGongyingshangID()>0){
			caigoudingdang.setGongyingshangMingzi( GongyingshangDao.findByGongyingshangID(caigoudingdang.getGongyingshangID()).getGongyingshangMingzi());
		}
		//CangkuMingzi是数据库caigoudingdang中没有的，是通过CangkuID在Cangku这个数据表查找的
		if(caigoudingdang.getCangkuID()>0){
			caigoudingdang.setCangkuMingzi(CangkuDao.findBycangkuID(caigoudingdang.getCangkuID()).getCangkuMingzi());
		}
		return caigoudingdang;//返回给GongyingshangController，与findALL()有关
	}
	
	
//为什么这里要把新增和修改分开写？？？？？？？？？？？？？？？？？？？？？？
	////ID是自己编写的 ，不是自动生成，保存和修改都有，所以不能分开写
	public static boolean save(Caigoudingdang caigoudingdang){
		try {
			String sql = null;
			
				//执行新增
				sql = "insert into caigoudingdang(caigoudingdangID,yaopingID,yaopingMingzi,yaopingDanwei,"
											+ "shuliang,zongjia,"
											+ "riqi,gongyingshangID,cangkuID)";
				sql += " values('"+caigoudingdang.getCaigoudingdangID()+"','"+caigoudingdang.getYaopingID()+"','"+caigoudingdang.getYaopingMingzi()+"','"+
						caigoudingdang.getYaopingDanwei()+"','"+caigoudingdang.getShuliang()+"','"
						+caigoudingdang.getZongjia()+"','"+caigoudingdang.getRiqi()+"','"+caigoudingdang.getGongyingshangID()+"','"+caigoudingdang.getCangkuID()+"')";
				
			
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
			ProjectShare.log("caigoudingdang.save/update error: "+e.getMessage());
			return false;
		}
	}

	public static boolean update(Caigoudingdang caigoudingdang){
		try {
			String sql = null;
			
				//执行修改
				sql ="update caigoudingdang "
						+ "set yaopingID= '"+caigoudingdang.getYaopingID()+
						"',yaopingMingzi='"+caigoudingdang.getYaopingMingzi()+
						"',yaopingDanwei='"+caigoudingdang.getYaopingDanwei()+
						"',shuliang='"+caigoudingdang.getShuliang()+
						"',zongjia='"+caigoudingdang.getZongjia()+
						"',riqi='"+caigoudingdang.getRiqi()+
						"',gongyingshangID='"+caigoudingdang.getGongyingshangID()+
						"',cangkuID='"+caigoudingdang.getCangkuID()+
						"',complete='"+caigoudingdang.getComplete()+
						"' where caigoudingdangID="+caigoudingdang.getCaigoudingdangID();
				
		
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
			ProjectShare.log("caigoudingdang.save/update error: "+e.getMessage());
			return false;
		}
	}
	public static boolean delete(int caigoudingdangID){
		try {
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			String sql = "delete from caigoudingdang where caigoudingdangID="+caigoudingdangID;
			//表示数据库更新这个链接
			int i=ProjectShare.getDbPool().update(connection, sql);
			//链接关闭
			ProjectShare.getDbPool().closeConnection(connection);
			//更新一次，表示成功，这里为什么更新了就是成功了？？？？？表示操作完成
			if(i==1)
				return true;
			return false;
			//异常        
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("caigoudingdang .delete error: "+e.getMessage());
			return false;
		}
	}

	public static List<Caigoudingdang> findALL(){
		try {
			List<Caigoudingdang> list = new ArrayList<>();
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from caigoudingdang";
			//返回数据库结果集
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			//循环结果集，一个个填充入List<Caigoudingdang>
			while(rs.next()){
				//把结果集填入Caigoudingdang对象
				Caigoudingdang caigoudingdang = convercaigoudingdang(rs);
				//list添加然后去了哪？？？？？？？？？？？？？？？？？？？？返回给caigoudingdangController
				list.add(caigoudingdang);
				
			}
			//结果集关闭
			rs.close();
			//数据量链接关闭
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;//找到所有采购订单列表，返回给caigoudingdangController
			//异常
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("caigoudingdang.findALL error: "+e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param businessID
	 * @return 在该供应商的采购明细
	 */
//	//这里是什么意思，干什么用的？？？？？？在改供应商的采购明细
//	public static List<Caigoudingdang> findByBusinessID(int caigoudingdangID){
//		try {
//			List<Caigoudingdang> list = new ArrayList<>();
//			Connection connection = ProjectShare.getDbPool().getConnection();
//			
//			String sql = "select * from caigoudingdang where caigoudingdangID="+caigoudingdangID;
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			while(rs.next()){
//				Caigoudingdang caigoudingdang = convercaigoudingdang(rs);
//				list.add(caigoudingdang);
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
//			ProjectShare.log("caigoudingdang.findByBusinessID error: "+e.getMessage());
//			return null;
//		}
//	}
	
	

}
