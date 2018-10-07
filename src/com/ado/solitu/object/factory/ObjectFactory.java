package com.ado.solitu.object.factory;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

@SuppressWarnings("all")
public class ObjectFactory {

	private static Map<String,Object> object_map=new HashMap<String,Object>();
	static {
		SAXReader saxreader=new SAXReader();
//		File file=new File("src/beans.xml");
		try {
			Document document=saxreader.read(ObjectFactory.class.getClassLoader().getResourceAsStream("beans.xml"));
			Element root_element=document.getRootElement();
			List<Element> list=root_element.elements("bean");
			for (Element element : list) {
				String key=element.attributeValue("id");
				String value=element.attributeValue("class");
				object_map.put(key, Class.forName(value).newInstance());
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}	
	}
	
	public static Object getObject(String key) {
		return object_map.get(key);
	}
}
