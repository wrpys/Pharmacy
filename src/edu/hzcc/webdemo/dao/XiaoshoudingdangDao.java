package edu.hzcc.webdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.hzcc.webdemo.pojo.Xiaoshoudingdang;
import edu.hzcc.webdemo.sys.ProjectShare;
/**
 * 销售订单
 *
 */
//怎么实现销售汇总的？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
//用findALL()列出数据库所有数据
public class XiaoshoudingdangDao {

	private static Xiaoshoudingdang converXiaoshoudingdang(ResultSet rs) throws Exception{
		Xiaoshoudingdang xiaoshoudingdang= new Xiaoshoudingdang();
		xiaoshoudingdang.setXiaoshoudingdangID(rs.getInt("xiaoshoudingdangID"));
		xiaoshoudingdang.setYaopingID(rs.getInt("yaopingID"));
		xiaoshoudingdang.setYaopingMingzi(rs.getString("yaopingMingzi"));
		xiaoshoudingdang.setYaopingDanwei(rs.getString("yaopingDanwei"));
		xiaoshoudingdang.setShuliang(rs.getInt("shuliang"));
		xiaoshoudingdang.setJingjia(rs.getDouble("jingjia"));
		xiaoshoudingdang.setZongjia(rs.getDouble("zongjia"));
		xiaoshoudingdang.setRiqi(rs.getString("riqi"));
		xiaoshoudingdang.setKehuID(rs.getInt("kehuID"));
		xiaoshoudingdang.setCangkuID(rs.getInt("cangkuID"));
		xiaoshoudingdang.setComplete(rs.getInt("complete"));
		//KehuMingzi是数据库xiaoshoudingdang中没有的，是通过kehuID在kehu这个数据表查找的
		if(xiaoshoudingdang.getKehuID()>0) {
			//KehuDao.findBykehuID根据KehuID得到Kehu这个类，getKehuMingzi（）获取名字，然后xiaoshoudingdang.setKehuMingzi设置名字
			xiaoshoudingdang.setKehuMingzi(KehuDao.findBykehuID(xiaoshoudingdang.getKehuID()).getKehuMingzi());
		}
		//CangkuMingzi是数据库xiaoshoudingdang中没有的，是通过CangkuID在Cangku这个数据表查找的
		if(xiaoshoudingdang.getCangkuID()>0){
			//CangkuDao.findBycangkuID根据cangkuID得到cangku这个类，getCangkuMingzi（）获取名字，然后xiaoshoudingdang.setCangkuMingzi设置名字

			xiaoshoudingdang.setCangkuMingzi(CangkuDao.findBycangkuID(xiaoshoudingdang.getCangkuID()).getCangkuMingzi());
		}
		return xiaoshoudingdang;
	}
	
	public static boolean save(Xiaoshoudingdang xiaoshoudingdang){
		try {
			String sql = null;
			sql = "insert into xiaoshoudingdang(xiaoshoudingdangID,yaopingID,yaopingMingzi,yaopingDanwei,"
					+ "shuliang,jingjia,zongjia,riqi,cangkuID,kehuID,complete)";
			sql += " values('"+xiaoshoudingdang.getXiaoshoudingdangID()+"','"+xiaoshoudingdang.getYaopingID()+"','"+xiaoshoudingdang.getYaopingMingzi()+"','"+
					xiaoshoudingdang.getYaopingDanwei()+"','"+xiaoshoudingdang.getShuliang()+"','"
					+xiaoshoudingdang.getJingjia()+"','"+xiaoshoudingdang.getZongjia()+"','"+xiaoshoudingdang.getRiqi()+"','"+xiaoshoudingdang.getCangkuID()+"','"
					+xiaoshoudingdang.getKehuID()+"','"+xiaoshoudingdang.getComplete()+"')";
				
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
			ProjectShare.log("xiaoshoudingdang.save error: "+e.getMessage());
			return false;
		}
	}
	public static boolean update(Xiaoshoudingdang xiaoshoudingdang){
		try {
			String sql = null;
				sql ="update xiaoshoudingdang "
						+ "set yaopingID= '"+xiaoshoudingdang.getYaopingID()+
						"',yaopingMingzi='"+xiaoshoudingdang.getYaopingMingzi()+
						"',yaopingDanwei='"+xiaoshoudingdang.getYaopingDanwei()+
						"',shuliang='"+xiaoshoudingdang.getShuliang()+
						"',jingjia='"+xiaoshoudingdang.getJingjia()+
						"',zongjia='"+xiaoshoudingdang.getZongjia()+
						"',riqi='"+xiaoshoudingdang.getRiqi()+
						"',cangkuID='"+xiaoshoudingdang.getCangkuID()+
						"',kehuID='"+xiaoshoudingdang.getKehuID()+
						"',complete='"+xiaoshoudingdang.getComplete()+
						"' where xiaoshoudingdangID="+xiaoshoudingdang.getXiaoshoudingdangID();
				
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
			ProjectShare.log("xiaoshoudingdang.save/update error: "+e.getMessage());
			return false;
		}
	}
	public static boolean delete(int xiaoshoudingdangID){
		try {
			Connection connection = ProjectShare.getDbPool().getConnection();
			String sql = "delete from xiaoshoudingdang where xiaoshoudingdangID="+xiaoshoudingdangID;
			int i=ProjectShare.getDbPool().update(connection, sql);
			
			ProjectShare.getDbPool().closeConnection(connection);
			if(i==1)
				return true;
			return false;
			          
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("xiaoshoudingdangID.delete error: "+e.getMessage());
			return false;
		}
	}

	public static List<Xiaoshoudingdang> findALL(){
		try {
			List<Xiaoshoudingdang> list = new ArrayList<>();
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from xiaoshoudingdang";
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			while(rs.next()){
				Xiaoshoudingdang xiaoshoudingdang = converXiaoshoudingdang(rs);
				list.add(xiaoshoudingdang);
				
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("ReceiptGoods.findALL error: "+e.getMessage());
			return null;
		}
	}
//下面所有的都详细些下？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
	public static List<Xiaoshoudingdang> findAllByCustomerID(int customerID){
		try {
			List<Xiaoshoudingdang> list = new ArrayList<>();
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from xiaoshoudingdang where customerID="+customerID;
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			while(rs.next()){
				Xiaoshoudingdang xiaoshoudingdang = converXiaoshoudingdang(rs);
				list.add(xiaoshoudingdang);
				
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("xiaoshoudingdang.findByBusinessID error: "+e.getMessage());
			return null;
		}
	}
	
//	public static int findCountComplete(){
//		try {
//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String today=sdf.format(date);
//			Connection connection = ProjectShare.getDbPool().getConnection();
//			
//			String sql = "select count(*) record_ from xiaoshoudingdang where complete=0";
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			int rowCount=0;
//			if(rs.next())      
//			{      
//			    rowCount=rs.getInt("record_");      
//			}   
//			rs.close();
//			
//			ProjectShare.getDbPool().closeConnection(connection);
//			
//			return rowCount;
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			ProjectShare.log("ReceiptGoods.findALL error: "+e.getMessage());
//			return 0;
//		}
//	}
//	
//	public static int findCount(){
//		try {
//			Date date = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String today=sdf.format(date);
//			Connection connection = ProjectShare.getDbPool().getConnection();
//			
//			String sql = "select count(*) record_ from xiaoshoudingdang where riqi like '"+today+"'";
//			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
//			int rowCount=0;
//			if(rs.next())      
//			{      
//			    rowCount=rs.getInt("record_");      
//			}   
//			rs.close();
//			
//			ProjectShare.getDbPool().closeConnection(connection);
//			
//			return rowCount;
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			ProjectShare.log("ReceiptGoods.findALL error: "+e.getMessage());
//			return 0;
//		}
//	}
	
}
