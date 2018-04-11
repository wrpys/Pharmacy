package edu.hzcc.webdemo.pojo;

/*销售订单
 * 
 */
public class Xiaoshoudingdang {

	/**
	 * 自己输入
	 */
	private int xiaoshoudingdangID;
	//药品ID
	private int yaopingID;
	//药品名字
	private String yaopingMingzi;
	//药品单位
	private String yaopingDanwei;
	//数量
	private int shuliang;
	//单价
	private double jingjia;
	//总价
	private double zongjia;
	//日期
	private String riqi;
	//仓库ID
	private int cangkuID;
	//客户ID
	private int kehuID;
	/**
	 * 这个销售订单是否审核
	 */
	private int complete;

	/**
	 * 数据没有这个字节，为在表格显示，仓库名字
	 */
	private String cangkuMingzi;
	
	/**
	 * 数据没有这个字节，为在表格显示，客户
	 */
	private String kehuMingzi;
	
	
	
	
	
	
	
	
	

	public int getXiaoshoudingdangID() {
		return xiaoshoudingdangID;
	}

	public void setXiaoshoudingdangID(int xiaoshoudingdangID) {
		this.xiaoshoudingdangID = xiaoshoudingdangID;
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

	public double getJingjia() {
		return jingjia;
	}

	public void setJingjia(double jingjia) {
		this.jingjia = jingjia;
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


	public int getKehuID() {
		return kehuID;
	}

	public void setKehuID(int kehuID) {
		this.kehuID = kehuID;
	}



	public int getComplete() {
		return complete;
	}

	public void setComplete(int complete) {
		this.complete = complete;
	}

	public int getCangkuID() {
		return cangkuID;
	}

	public void setCangkuID(int cangkuID) {
		this.cangkuID = cangkuID;
	}

	public String getCangkuMingzi() {
		return cangkuMingzi;
	}

	public void setCangkuMingzi(String cangkuMingzi) {
		this.cangkuMingzi = cangkuMingzi;
	}

	public String getKehuMingzi() {
		return kehuMingzi;
	}

	public void setKehuMingzi(String kehuMingzi) {
		this.kehuMingzi = kehuMingzi;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

