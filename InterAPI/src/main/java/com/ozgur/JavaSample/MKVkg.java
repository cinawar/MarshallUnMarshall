package com.ozgur.JavaSample;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings({ "restriction"})
@XmlRootElement(name = "MKVkg")
@XmlAccessorType (XmlAccessType.FIELD)
public class MKVkg {
	
	private Date tarih;
	private String isin;
	private Integer vkg;
	
	
	
	public Date getTarih() {
		return tarih;
	}
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public Integer getVkg() {
		return vkg;
	}
	public void setVkg(Integer vkg) {
		this.vkg = vkg;
	}
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
}
