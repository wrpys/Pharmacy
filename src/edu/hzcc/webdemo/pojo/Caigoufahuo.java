package edu.hzcc.webdemo.pojo;

/*
 * 采购收货
 */
public class Caigoufahuo {
	

		private int caigoufahuoID;	
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
		//采购订单号
		private int caigoudingdangID;
		//是否结算 0未结算		 
		private int complete;
	
		/**
		 * 数据没有这个字节，为在表格显示
		 */
		private String gongyingshangMingzi;


		
		
		
		
		
		
		


		public int getCaigoufahuoID() {
			return caigoufahuoID;
		}


		public void setCaigoufahuoID(int caigoufahuoID) {
			this.caigoufahuoID = caigoufahuoID;
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


		public int getCaigoudingdangID() {
			return caigoudingdangID;
		}


		public void setCaigoudingdangID(int caigoudingdangID) {
			this.caigoudingdangID = caigoudingdangID;
		}


		public String getGongyingshangMingzi() {
			return gongyingshangMingzi;
		}


		public void setGongyingshangMingzi(String gongyingshangMingzi) {
			this.gongyingshangMingzi = gongyingshangMingzi;
		}
	
	
	
	
	
	
	
	
	

	
}
