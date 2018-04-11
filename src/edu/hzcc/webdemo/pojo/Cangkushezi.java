package edu.hzcc.webdemo.pojo;
/**
 * 预警设置，
 *
 */
public class Cangkushezi {

	
	private Integer id;
	//仓库ID
	private Integer cangkuID;
	//药品编号
	private Integer yaopingID;
	
	//最少数量
	private Integer zuishaoshuliang;
	
	private Yaoping yaoping;
	
	private Dingdan dingdan;
	
	private Kucun kucun;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCangkuID() {
		return cangkuID;
	}

	public void setCangkuID(Integer cangkuID) {
		this.cangkuID = cangkuID;
	}

	public Integer getYaopingID() {
		return yaopingID;
	}

	public void setYaopingID(Integer yaopingID) {
		this.yaopingID = yaopingID;
	}

	public Integer getZuishaoshuliang() {
		return zuishaoshuliang;
	}

	public void setZuishaoshuliang(Integer zuishaoshuliang) {
		this.zuishaoshuliang = zuishaoshuliang;
	}

	public Yaoping getYaoping() {
		return yaoping;
	}

	public void setYaoping(Yaoping yaoping) {
		this.yaoping = yaoping;
	}

	public Dingdan getDingdan() {
		return dingdan;
	}

	public void setDingdan(Dingdan dingdan) {
		this.dingdan = dingdan;
	}

	public Kucun getKucun() {
		return kucun;
	}

	public void setKucun(Kucun kucun) {
		this.kucun = kucun;
	}
	
}