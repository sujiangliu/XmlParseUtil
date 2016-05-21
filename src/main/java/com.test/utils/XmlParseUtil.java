package com.test.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class XmlParseUtil {

	private static String MQ_MSG_CHARSET_NAME = "UTF-8";
	
	@SuppressWarnings("unchecked")
	public static <T> T readXmlFromFile(Class<T> clazz, String filePath)
			throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(new File(filePath));
		} catch (JAXBException e) {
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T readConfig(Class<T> clazz, String configPath,
			Object... arguments) throws JAXBException, IOException {
		InputStream is = null;
		try {
			if (arguments.length > 0) {
				configPath = MessageFormat.format(configPath, arguments);
			}
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			is = new FileInputStream(configPath);
			return (T) u.unmarshal(is);
		} catch (IOException e) {
			throw e;
		} catch (JAXBException e) {
			throw e;
		} finally {
			try {
				if(is != null) is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T readConfigFromStream(Class<T> clazz,
			InputStream dataStream) throws JAXBException {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(dataStream);
		} catch (JAXBException e) {
			throw e;
		} finally {
			try {
				if(dataStream != null) dataStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readXMLFromString(Class<T> clazz, String xml) throws JAXBException, UnsupportedEncodingException {
		InputStream in = null;
		try {
			in = new ByteArrayInputStream(xml.getBytes(MQ_MSG_CHARSET_NAME));
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(in);
		} catch (JAXBException e) {
			throw e;
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static <T> String write(Class<T> clazz, T obj) throws JAXBException {
		ByteArrayOutputStream out = null;
		try {
			out = new ByteArrayOutputStream();
			JAXBContext context = JAXBContext.newInstance(clazz);  
	        Marshaller marshaller = context.createMarshaller();  
	        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
	        marshaller.setProperty(Marshaller.JAXB_ENCODING, MQ_MSG_CHARSET_NAME);
	        marshaller.marshal(obj, out);  
	        return out.toString();
		} catch (JAXBException e) {
			throw e;
		} finally {
			try {
				if(out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
