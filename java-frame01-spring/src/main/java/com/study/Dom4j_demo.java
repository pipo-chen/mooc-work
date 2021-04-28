package com.study;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Dom4j_demo {

	public static void main(String[] args) throws Exception{
		SAXReader reader = new SAXReader();
		//必须是要绝对路径
		File f = new File("/Users/ct/Documents/Alg/mooc-work/java-frame01-spring/src/main/resources/applicationContext.xml");

		Document doc = reader.read(f);
		Element root = doc.getRootElement();
		//根据根节点获取 bean 中全部的子节点
		List<Element> childList = root.elements();
		for (Element child : childList) {
			System.out.println("id:"+child.attributeValue("id"));
			System.out.println("class"+child.attributeValue("class"));

			Object obj = Class.forName(child.attributeValue("class"));
			System.out.println(obj);
		}
	}
}
