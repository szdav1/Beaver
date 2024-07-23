package com.beaver.softw.support.config.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.beaver.softw.app.view.dialogs.error.ErrorDialog;
import com.beaver.softw.app.view.dialogs.error.ErrorDialogTitle;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public abstract class AbstractXMLWriter {
	protected final XMLWriterConfiguration configuration;

	public AbstractXMLWriter(final XMLWriterConfiguration configuration) {
		this.configuration = configuration;
	}

	public void writeXML(final String data) {
		try {
			Document xmlDocument = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder()
				.newDocument();

			Element rootElement = xmlDocument.createElement(this.configuration.getXmlName());
			Element selectedElement = xmlDocument.createElement(this.configuration.getSelectedElementName());
			Element lookAndFeelElement = xmlDocument.createElement(this.configuration.getElementName());
			Text text = xmlDocument.createTextNode(data);

			lookAndFeelElement.appendChild(text);
			selectedElement.appendChild(lookAndFeelElement);
			rootElement.appendChild(selectedElement);
			xmlDocument.appendChild(rootElement);

			DOMSource source = new DOMSource(xmlDocument);
			StreamResult streamResult = new StreamResult(this.configuration.getFilePath());
			TransformerFactory.newInstance()
				.newTransformer()
				.transform(source, streamResult);
		}
		catch (Exception exc) {
			ErrorDialog.displayError(ErrorDialogTitle.LOOK_AND_FEEL_ERROR, exc);
		}
	}
}
