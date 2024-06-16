package com.beaver.softw.support.config.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;

import com.beaver.softw.app.view.dialog.ErrorDialog;
import com.beaver.softw.app.view.dialog.ErrorDialogTitle;
import com.beaver.softw.support.util.ResourceHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class AbstractXMLObjectParser {
	protected final XMLReaderConfiguration configuration;
	protected final List<XMLObject> xmlObjects;

	public AbstractXMLObjectParser(XMLReaderConfiguration configuration) {
		this.configuration = configuration;
		this.xmlObjects = new ArrayList<>();
	}

	public HashMap<String, String> getData() {
		HashMap<String, String> data = new HashMap<>();
		this.xmlObjects.forEach(xmlo -> data.put(xmlo.getPath(), xmlo.getText()));

		return data;
	}

	public void readFromXML(final String filePath) {
		try {
			Document xmlDoc = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.parse(new File(ResourceHandler.get(filePath)));

			xmlDoc.normalize();
			NodeList rootNodes = xmlDoc.getElementsByTagName(configuration.getRootTagName());

			for (int i = 0; i < rootNodes.getLength(); i++) {
				if (!XMLObject.isElement(rootNodes.item(i)))
					continue;

				Element rootElement = (Element) rootNodes.item(i);
				NodeList childNodes = rootElement.getChildNodes();

				for (int j = 0; j < childNodes.getLength(); j++) {
					if (childNodes.item(j).getNodeType() != Node.ELEMENT_NODE)
						continue;

					this.xmlObjects.add(new XMLObject(childNodes.item(j), this.configuration.getAttributeName()));
				}
			}
		}
		catch (Exception exc) {
			ErrorDialog.display(ErrorDialogTitle.XML_RESOURCE_ERROR, exc);
		}
	}
}
