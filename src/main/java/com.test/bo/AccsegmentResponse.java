package com.test.bo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="accsegment")
public class AccsegmentResponse {
	
	@XmlElement(name="acc")
	private Acc acc;

	public Acc getAcc() {
		return acc;
	}

	public void setAcc(Acc acc) {
		this.acc = acc;
	}
	
	public String getIsptype(){
		return getValue("isptype");
	}
	public String getProvinceName(){
		return getValue("provincename");
	}
	public String getCityCode(){
		return getValue("citycode");
	}
	public String getDetail(){
		return getValue("detail");
	}
	
	private String getValue(String name) {
		if (null != acc) {
			List<Mobile> list = acc.getMobileList();
			for (Mobile mobile : list) {
				if (name.equals(mobile.getName())) {
					try {
						return URLDecoder.decode(mobile.getValue(), "utf-8");
					} catch (UnsupportedEncodingException e) {
						return mobile.getValue();
					}
				}
			}
		}
		
		return "";
	}
}
