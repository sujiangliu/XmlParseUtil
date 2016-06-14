package com.test.xml.parse.bo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Acc implements Serializable {

	@XmlElement(name="mobile")
	private List<Mobile> mobileList;

	public List<Mobile> getMobileList() {
		return mobileList;
	}

	public void setMobileList(List<Mobile> mobileList) {
		this.mobileList = mobileList;
	}
}
