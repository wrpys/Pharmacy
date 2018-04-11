package edu.hzcc.webdemo.pojo;

/*
 * 库存
 */
public class Kucun {

	private int kucunID;
	/*
	 * 药品ID
	 */
	private int yaopingID;
	/*
	 * 入出库数量
	 */
	private int shuliang;
	
	/**
	 * 仓库ID
	 */
	private int cangKuID;
	
	/**
	 * 订单ID
	 */
	private int dingdanID;
	
	private String riqi;
	/*
	 * 
	 * 1入库
	 * 2出库
	 */
	private int zhuangtai;
	public int getKucunID() {
		return kucunID;
	}
	public void setKucunID(int kucunID) {
		this.kucunID = kucunID;
	}
	public int getYaopingID() {
		return yaopingID;
	}
	public void setYaopingID(int yaopingID) {
		this.yaopingID = yaopingID;
	}
	public int getShuliang() {
		return shuliang;
	}
	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}
	public String getRiqi() {
		return riqi;
	}
	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}
	public int getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(int zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public int getCangKuID() {
		return cangKuID;
	}
	
	public void setCangKuID(int cangKuID) {
		this.cangKuID = cangKuID;
	}
	public int getDingdanID() {
		return dingdanID;
	}
	public void setDingdanID(int dingdanID) {
		this.dingdanID = dingdanID;
	}
	@Override
	public String toString() {
		return "Kucun [kucunID=" + kucunID + ", yaopingID=" + yaopingID + ", yaopingMingzi=" + ", shuliang=" + shuliang
				+ ", riqi=" + riqi + ", zhuangtai=" + zhuangtai + ", cangKuID=" + cangKuID + ", dingdanID=" + dingdanID +"]";
	}
	
	
	

	
	
	
}
