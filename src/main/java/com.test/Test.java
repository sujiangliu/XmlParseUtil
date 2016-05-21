package com.test;

import com.test.bo.AccsegmentResponse;
import com.test.utils.XmlParseUtil;

import javax.xml.bind.JAXBException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2016/5/21.
 */
public class Test {

    public static void main(String[] args) {

        String responseStr = "<?xml version=\"1.0\" encoding=\"GB2312\"?><accsegment version=\"1.0\"><acc><mobile name=\"isptype\" value=\"%E7%A7%BB%E5%8A%A8\"/><mobile name=\"provincename\" value=\"%E6%B1%9F%E8%8B%8F\"/><mobile name=\"citycode\" value=\"025\"/><mobile name=\"detail\" value=\"\"/></acc></accsegment>";
        try {
            AccsegmentResponse a = XmlParseUtil.readXMLFromString(AccsegmentResponse.class, responseStr);
            System.out.println(a.getIsptype());
            System.out.println(a.getProvinceName());
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
