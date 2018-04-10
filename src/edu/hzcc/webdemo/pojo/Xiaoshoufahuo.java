package edu.hzcc.webdemo.pojo;

/**
 * 销售出货明细
 * @author Administrator
 *
 */
public class Xiaoshoufahuo {

	private int xiaoshoufahuoID;	
	//药品ID
	private int yaopingID;
	//药品名字
	private String yaopingMingzi;
	//药品单位
	private String yaopingDanwei;
	//数量
	private int shuliang;
	//单价
	//总价
	private double zongjia;
	//日期
	private String riqi;
	//供应商ID
	private int gongyingshangID;
	//客户ID
    private int kehuID;
    
    private int xiaoshoudingdangID;
    
    /**
	 * 数据没有这个字节，为在表格显示，供应商
	 */
	private String gongyingshangMingzi;
	
	/**
	 * 数据没有这个字节，为在表格显示，客户
	 */
	private String kehuMingzi;
	
	/**
	 * 
	 * 是否结算
	 */
	private int complete;
    

	public int getXiaoshoufahuoID() {
		return xiaoshoufahuoID;
	}
	public void setXiaoshoufahuoID(int xiaoshoufahuoID) {
		this.xiaoshoufahuoID = xiaoshoufahuoID;
	}
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
	public int getComplete() {
		return complete;
	}
	public void setComplete(int complete) {
		this.complete = complete;
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
	public int getKehuID() {
		return kehuID;
	}
	public void setKehuID(int kehuID) {
		this.kehuID = kehuID;
	}
    
    
    
    
	public String getGongyingshangMingzi() {
		return gongyingshangMingzi;
	}
	public void setGongyingshangMingzi(String gongyingshangMingzi) {
		this.gongyingshangMingzi = gongyingshangMingzi;
	}
	public String getKehuMingzi() {
		return kehuMingzi;
	}
	public void setKehuMingzi(String kehuMingzi) {
		this.kehuMingzi = kehuMingzi;
	}
    
    
    
    
    
    
    
    
    
    
}
