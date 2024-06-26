package com.beaver.softw.support.config.xml;

import lombok.Getter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public final class XMLObject {
	@Getter
	private Node rootNode;
	private Text text;
	@Getter
	private String name;
	@Getter
	private String parentAttribute;

	public XMLObject(final Node rootNode, final String attributeName) {
		this.rootNode = rootNode;
		this.parentAttribute = ((Element) rootNode.getParentNode())
			.getAttribute(attributeName);
		this.name = ((Element) rootNode).getTagName();
		this.getTextData();
	}

	public String getText() {
		if (this.text != null)
			return this.text.getData()
				.strip()
				.replaceAll("\n", "");

		return "";
	}

	public String getPath() {
		if (this.parentAttribute.isBlank())
			return this.name;

		return this.parentAttribute+"."+this.name;
	}

	public static boolean isElement(final Node node) {
		return node.getNodeType() == Node.ELEMENT_NODE;
	}

	private static boolean isText(final Node node) {
		return node.getNodeType() == Node.TEXT_NODE;
	}

	private void getTextData() {
		NodeList childNodeList = this.rootNode.getChildNodes();

		for (int i = 0; i < childNodeList.getLength(); i++) {
			if (isText(childNodeList.item(i))) {
				Text text = (Text) childNodeList.item(i);

				if (text != null && !text.getData().isBlank())
					this.text = text;
			}
		}
	}
}