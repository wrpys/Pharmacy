package edu.hzcc.webdemo.pojo;
/**
 * 预警设置，
 *
 */
public class Cangkushezi {

	
	private int id;
	//仓库ID
	private int cangkuID;
	//药品编号
	private int yaopingID;
	
	//最少数量
	private int zuishaoshuliang;
	/*
	 * 数据库没有这个字段，为了表格显示
	 */
	private String cangkuMingzi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCangkuID() {
		return cangkuID;
	}
	public void setCangkuID(int cangkuID) {
		this.cangkuID = cangkuID;
	}
	public int getYaopingID() {
		return yaopingID;
	}
	public void setYaopingID(int yaopingID) {
		this.yaopingID = yaopingID;
	}
	public int getZuishaoshuliang() {
		return zuishaoshuliang;
	}
	public void setZuishaoshuliang(int zuishaoshuliang) {
		this.zuishaoshuliang = zuishaoshuliang;
	}
	public String getCangkuMingzi() {
		return cangkuMingzi;
	}
	public void setCangkuMingzi(String cangkuMingzi) {
		this.cangkuMingzi = cangkuMingzi;
	}
	
	
	
	
	
}