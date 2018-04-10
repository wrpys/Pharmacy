package edu.hzcc.webdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.pojo.Xiaoshoufahuo;
import edu.hzcc.webdemo.sys.ProjectShare;
/**
 * 销售发货
 *
 */
public class XiaoshoufahuoDao {

	private static Xiaoshoufahuo converxiaoshoufahuo(ResultSet rs) throws Exception{
		Xiaoshoufahuo xiaoshoufahuo= new Xiaoshoufahuo();
		xiaoshoufahuo.setXiaoshoufahuoID(rs.getInt("xiaoshoufahuoID"));
		xiaoshoufahuo.setYaopingID(rs.getInt("yaopingID"));
		xiaoshoufahuo.setYaopingMingzi(rs.getString("yaopingMingzi"));
		xiaoshoufahuo.setYaopingDanwei(rs.getString("yaopingDanwei"));
		xiaoshoufahuo.setShuliang(rs.getInt("shuliang"));
		xiaoshoufahuo.setZongjia(rs.getDouble("zongjia"));
		xiaoshoufahuo.setRiqi(rs.getString("riqi"));
		xiaoshoufahuo.setGongyingshangID(rs.getInt("gongyingshangID"));
		xiaoshoufahuo.setKehuID(rs.getInt("kehuID"));
		xiaoshoufahuo.setXiaoshoudingdangID(rs.getInt("xiaoshoudingdangID"));
		xiaoshoufahuo.setComplete(rs.getInt("complete"));
		//这里是什么意思？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
		//xiaoshoufahuo这张表没有GongyingshangMingzi，有gongyingshangID，通过GongyingshangDao.findByGongyingshangID获取Gongyingshang，得到名字，用于显示
		if(xiaoshoufahuo.getGongyingshangID()>0) {
			//GongyingshangDao.findByGongyingshangID根据GongyingshangID得到Gongyingshang这个类，getGongyingshangMingzi（）获取名字，然后xiaoshoudingdang.setKehuMingzi设置名字

			xiaoshoufahuo.setGongyingshangMingzi(GongyingshangDao.findByGongyingshangID(xiaoshoufahuo.getGongyingshangID()).getGongyingshangMingzi());
		}
		//xiaoshoufahuo这张表没有KehuMingzi，有kehuID，通过KehuDao.findBykehuID获取Kehu，得到名字，用于显示

		if(xiaoshoufahuo.getKehuID()>0) {
			//KehuDao.findBykehuID根据KehuID得到Kehu这个类，getKehuMingzi（）获取名字，然后xiaoshoufahuo.setKehuMingzi设置名字

			xiaoshoufahuo.setKehuMingzi(KehuDao.findBykehuID(xiaoshoufahuo.getKehuID()).getKehuMingzi());
		}
		return xiaoshoufahuo;
	}
	
	public static boolean save(Xiaoshoufahuo xiaoshoufahuo){
		try {
			String sql = null;
			if(xiaoshoufahuo.getXiaoshoufahuoID()>0){
				//执行修改
				sql ="update xiaoshoufahuo set yaopingID= '"+xiaoshoufahuo.getYaopingID()+
						"',yaopingMingzi='"+xiaoshoufahuo.getYaopingMingzi()+
						"',yaopingDanwei='"+xiaoshoufahuo.getYaopingDanwei()+
						"',shuliang='"+xiaoshoufahuo.getShuliang()+
						"',zongjia='"+xiaoshoufahuo.getZongjia()+
						"',riqi='"+xiaoshoufahuo.getRiqi()+
						"',gongyingshangID='"+xiaoshoufahuo.getGongyingshangID()+
						"',kehuID='"+xiaoshoufahuo.getKehuID()+
						"',complete='"+xiaoshoufahuo.getComplete()+
						"',xiaoshoudingdangID='"+xiaoshoufahuo.getXiaoshoudingdangID()+
						"' where xiaoshoufahuoID="+xiaoshoufahuo.getXiaoshoufahuoID();
			}else {
				//执行新增
				sql = "insert into xiaoshoufahuo(yaopingID,yaopingMingzi,yaopingDanwei,"
						+ "shuliang,zongjia,riqi,gongyingshangID,kehuID,xiaoshoudingdangID)";
				sql += " values('"+xiaoshoufahuo.getYaopingID()+"','"+xiaoshoufahuo.getYaopingMingzi()+"','"+
						xiaoshoufahuo.getYaopingDanwei()+"','"+xiaoshoufahuo.getShuliang()+"','"
						+xiaoshoufahuo.getZongjia()+"','"+xiaoshoufahuo.getRiqi()+"','"+xiaoshoufahuo.getGongyingshangID()+"','"
						+xiaoshoufahuo.getKehuID()+"','"+xiaoshoufahuo.getXiaoshoudingdangID()+"')";
				
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
			ProjectShare.log("xiaoshoufahuo.save/update error: "+e.getMessage());
			return false;
		}
	}

	public static boolean delete(int xiaoshoufahuoID){
		try {
			Connection connection = ProjectShare.getDbPool().getConnection();
			String sql = "delete from xiaoshoufahuo where xiaoshoufahuoID="+xiaoshoufahuoID;
			int i=ProjectShare.getDbPool().update(connection, sql);
			
			ProjectShare.getDbPool().closeConnection(connection);
			if(i==1)
				return true;
			return false;
			          
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("xiaoshoufahuo.delete error: "+e.getMessage());
			return false;
		}
	}

	public static List<Xiaoshoufahuo> findALL(){
		try {
			List<Xiaoshoufahuo> list = new ArrayList<>();
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from xiaoshoufahuo";
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			while(rs.next()){
				Xiaoshoufahuo xiaoshoufahuo = converxiaoshoufahuo(rs);
				list.add(xiaoshoufahuo);
				
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("xiaoshoufahuo.findALL error: "+e.getMessage());
			return null;
		}
	}
	//收款单有xiaoshoufahuoID，是销售发货是保存的，在收款单结算后，要生成一条库存，根据收款单的xiaoshoufahuoID，找出库存的明细
	public static Xiaoshoufahuo findOne(int xiaoshoufahuoID){
		try {
			Xiaoshoufahuo xiaoshoufahuo = new Xiaoshoufahuo();
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from xiaoshoufahuo where xiaoshoufahuoID="+xiaoshoufahuoID;
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			if(rs.next()){
				 xiaoshoufahuo = converxiaoshoufahuo(rs);
				
			}
			rs.close();
			
			ProjectShare.getDbPool().closeConnection(connection);
			
			return xiaoshoufahuo;
			
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("xiaoshoufahuo.findBygongyingshangID error: "+e.getMessage());
			return null;
		}
	}

}
