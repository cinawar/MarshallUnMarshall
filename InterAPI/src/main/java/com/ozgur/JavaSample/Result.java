package com.ozgur.JavaSample;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@SuppressWarnings("restriction")
@XmlRootElement(name = "Result")
@XmlAccessorType (XmlAccessType.FIELD)
public class Result {

	@XmlElement(name = "MKVkg")
	private List<MKVkg> liste;

	public List<MKVkg> getListe() {
		return liste;
	}

	public void setListe(List<MKVkg> liste) {
		this.liste = liste;
	}
	
	
}
