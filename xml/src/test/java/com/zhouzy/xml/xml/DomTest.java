package com.zhouzy.xml.xml;
import org.junit.Test;

import com.zhouzy.xml.dom.DomXml;

public class DomTest {
	@Test
    public void testDome4j() {  
       DomXml xml = new DomXml();
       xml.createXML();
       xml.parseXML();  
    }  

}
