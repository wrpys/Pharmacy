package edu.hzcc.webdemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.hzcc.webdemo.pojo.Dingdan;
import edu.hzcc.webdemo.sys.ProjectShare;

/**
  * 订单的数据库操作
 */
public class DingdanDao {
	
	/*
	 * 把数据库查到的数据填充到Dingdan这个对象中，以便操作
	 */
	private static Dingdan converDingdan(ResultSet rs) throws Exception{
		Dingdan dingdan= new Dingdan();
		dingdan.setDingdanID(rs.getInt("dingdanID"));
		dingdan.setDingdanBianhao(rs.getString("dingdanBianhao"));
		dingdan.setYaopingID(rs.getInt("yaopingID"));
		dingdan.setShuliang(rs.getInt("shuliang"));
		dingdan.setDanjia(rs.getDouble("danjia"));
		dingdan.setZongjia(rs.getDouble("zongjia"));
		dingdan.setRiqi(rs.getString("riqi"));
		dingdan.setGongyingshangID(rs.getInt("gongyingshangID"));
		dingdan.setKehuID(rs.getInt("kehuID"));
		dingdan.setCangkuID(rs.getInt("cangkuID"));
		dingdan.setComplete(rs.getInt("complete"));
		// 药品详情
		if(dingdan.getYaopingID() != null) {
			dingdan.setYaoping(YaopingDao.findByYaopingID(dingdan.getYaopingID()));
		}
		// 供应商详情
		if(dingdan.getGongyingshangID() != null) {
			dingdan.setGongyingshang(GongyingshangDao.findByGongyingshangID(dingdan.getGongyingshangID()));
		}
		// 客户详情
		if (dingdan.getKehuID() != null) {
			dingdan.setKehu(KehuDao.findBykehuID(dingdan.getKehuID()));
		}
		// 仓库详情
		if (dingdan.getCangkuID() != null) {
			dingdan.setCangku(CangkuDao.findBycangkuID(dingdan.getCangkuID()));
		}
		return dingdan;
	}
	
	public static boolean save(Dingdan dingdan){
		try {
			String sql = null;
				//执行新增
				sql = "insert into dingdan(dingdanBianhao,yaopingID,danjia,"
											+ "shuliang,zongjia,dingdanleixing,"
											+ "riqi,gongyingshangID,kehuID,cangkuID,complete)";
				sql += " values('"+dingdan.getDingdanBianhao()+"','"+dingdan.getYaopingID()+"','"+dingdan.getDanjia()+"','"+
						dingdan.getShuliang()+"','"+dingdan.getZongjia()+"','"+dingdan.getDingdanleixing()+"','"+
						dingdan.getRiqi()+"','"+dingdan.getGongyingshangID()+"','"+dingdan.getKehuID()+"','"+dingdan.getCangkuID()+"','"+dingdan.getComplete()+"')";
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
			ProjectShare.log("dingdan.save/update error: "+e.getMessage());
			return false;
		}
	}

	public static boolean update(Dingdan dingdan){
		try {
			String sql = null;
				//执行修改
				sql ="update dingdan "
						+ "set dingdanBianhao= '"+dingdan.getDingdanBianhao()+
						"',danjia='"+dingdan.getDanjia()+
						"',shuliang='"+dingdan.getShuliang()+
						"',zongjia='"+dingdan.getZongjia()+
						"',dingdanleixing='"+dingdan.getDingdanleixing()+
						"',riqi='"+dingdan.getRiqi()+
						"',gongyingshangID='"+dingdan.getGongyingshangID()+
						"',kehuID='"+dingdan.getKehuID()+
						"',cangkuID='"+dingdan.getCangkuID()+
						"',complete='"+dingdan.getComplete()+
						"' where dingdanID="+dingdan.getDingdanID();
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
			ProjectShare.log("dingdan.save/update error: "+e.getMessage());
			return false;
		}
	}
	
	public static boolean delete(int dingdanID){
		try {
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			String sql = "delete from dingdan where dingdanID="+dingdanID;
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
			ProjectShare.log("dingdan .delete error: "+e.getMessage());
			return false;
		}
	}

	public static List<Dingdan> findALL(Dingdan params){
		try {
			List<Dingdan> list = new ArrayList<>();
			//开启数据库链接
			Connection connection = ProjectShare.getDbPool().getConnection();
			
			String sql = "select * from dingdan where 1=1";
			if(params.getDingdanleixing() != null) {
				sql += " and dingdanleixing=" + params.getDingdanleixing();
			}
			//返回数据库结果集
			ResultSet rs = ProjectShare.getDbPool().query(connection, sql);
			//循环结果集，一个个填充入List<Dingdan>
			while(rs.next()){
				//把结果集填入Dingdan对象
				Dingdan dingdan = converDingdan(rs);
				list.add(dingdan);
				
			}
			//结果集关闭
			rs.close();
			//数据量链接关闭
			ProjectShare.getDbPool().closeConnection(connection);
			
			return list;
			//异常
		} catch (Exception e) {
			// TODO: handle exception
			ProjectShare.log("dingdan.findALL error: "+e.getMessage());
			return null;
		}
	}
	

}
