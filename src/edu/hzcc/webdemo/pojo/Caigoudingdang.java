package edu.hzcc.webdemo.pojo;

/*
 * 采购订单
 */
public class Caigoudingdang {
	/**
	 * 自己输入
	 */
	private int caigoudingdangID;
	//药品ID
	private int yaopingID;
	//药品名字
	private String yaopingMingzi;
	//药品单位
	private String yaopingDanwei;
	//数量
	private int shuliang;
	//总价
	private double zongjia;
	//日期
	private String riqi;
	//供应商ID
	private int gongyingshangID;
	//仓库ID
	private int cangkuID;	
	//是否审核 0 未审核
	private int complete;
	
	
	/**
	 * 供应商名字，数据库没有
	 */
	private String gongyingshangMingzi;
	/**
	 * 仓库名字，数据库没有
	 */
	private String cangkuMingzi;

	public String getCangkuMingzi() {
		return cangkuMingzi;
	}
	
	public void setCangkuMingzi(String cangkuMingzi) {
		this.cangkuMingzi = cangkuMingzi;
	}
	public int getCangkuID() {
		return cangkuID;
	}

	public void setCangkuID(int cangkuID) {
		this.cangkuID = cangkuID;
	}



	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public int getCaigoudingdangID() {
		return caigoudingdangID;
	}

	public void setCaigoudingdangID(int caigoudingdangID) {
		this.caigoudingdangID = caigoudingdangID;
	}

	public int getYaopingID() {
		return yaopingID;
	}

	public void setYaopingID(int yaopingID) {
		this.yaopingID = yaopingID;
	}

	public String getYaopingMingzi() {
		return yaopingMingzi;
	}

	public void setYaopingMingzi(String yaopingMingzi) {
		this.yaopingMingzi = yaopingMingzi;
	}

	public String getYaopingDanwei() {
		return yaopingDanwei;
	}

	public void setYaopingDanwei(String yaopingDanwei) {
		this.yaopingDanwei = yaopingDanwei;
	}

	public int getShuliang() {
		return shuliang;
	}

	public void setShuliang(int shuliang) {
		this.shuliang = shuliang;
	}


	public double getZongjia() {
		return zongjia;
	}

	public void setZongjia(double zongjia) {
		this.zongjia = zongjia;
	}

	public String getRiqi() {
		return riqi;
	}

	public void setRiqi(String riqi) {
		this.riqi = riqi;
	}

	public int getGongyingshangID() {
		return gongyingshangID;
	}

	public void setGongyingshangID(int gongyingshangID) {
		this.gongyingshangID = gongyingshangID;
	}

	public String getGongyingshangMingzi() {
		return gongyingshangMingzi;
	}

	public void setGongyingshangMingzi(String gongyingshangMingzi) {
		this.gongyingshangMingzi = gongyingshangMingzi;
	}

	@Override
	public String toString() {
		return "Caigoudingdang [caigoudingdangID=" + caigoudingdangID + ", yaopingID=" + yaopingID + ", yaopingMingzi="
				+ yaopingMingzi + ", yaopingDanwei=" + yaopingDanwei + ", shuliang=" + shuliang 
				+ ", zongjia=" + zongjia + ", riqi=" + riqi + ", gongyingshangID=" + gongyingshangID
				+ ", gongyingshangMingzi=" + gongyingshangMingzi + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
