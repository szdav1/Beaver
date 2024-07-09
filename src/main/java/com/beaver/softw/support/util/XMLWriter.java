package com.beaver.softw.support.util;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class XMLWriter {
	public static void writeToXML() throws Exception {
		Document xmlDocument = DocumentBuilderFactory.newInstance()
			.newDocumentBuilder()
			.newDocument();

		Transformer transformer = TransformerFactory.newInstance()
			.newTransformer();

		Element settingsElement = xmlDocument.createElement("LookAndFeel");
		xmlDocument.appendChild(settingsElement);
		transformer.transform(new DOMSource(xmlDocument), new StreamResult(ResourceHandler.getTarget("/settings/", "Test3.xml")));
	}
}
