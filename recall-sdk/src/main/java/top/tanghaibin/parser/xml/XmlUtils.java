package top.tanghaibin.parser.xml;


import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import top.tanghaibin.exception.BizException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class XmlUtils {
	
	private static final String XMLNS_XSI = "xmlns:xsi";
	private static final String XSI_SCHEMA_LOCATION = "xsi:schemaLocation";
	private static final String LOGIC_YES = "yes";
	private static final String DEFAULT_ENCODE = "UTF-8";

	/**
	 * Creates a new document instance.
	 * 
	 * @return a new document instance
	 * @throws BizException problem creating a new document
	 */
	public static Document newDocument() throws BizException {
		Document doc = null;
		
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch (ParserConfigurationException e) {
			throw new BizException(e.getMessage());
		}

		return doc;
	}

	/**
	 * Parses the content of the given XML file as an XML document.
	 * 
	 * @param file the XML file instance
	 * @return the document instance representing the entire XML document
	 * @throws BizException problem parsing the XML file
	 */
	public static Document getDocument(File file) throws BizException {
		InputStream in = getInputStream(file);
		return getDocument(new InputSource(in), null);
	}

	/**
	 * Parses the content of the given stream as an XML document.
	 * 
	 * @param xml the XML file input stream
	 * @return the document instance representing the entire XML document
	 * @throws BizException problem parsing the XML input stream
	 */
	public static Document getDocument(InputSource xml, InputStream xsd) throws BizException {
		Document doc = null;

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			if (xsd != null) {
				dbf.setNamespaceAware(true);
			}

			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.parse(xml);

			if (xsd != null) {
				validateXml(doc, xsd);
			}
		} catch (ParserConfigurationException e) {
			throw new BizException(e.getMessage());
		} catch (SAXException e) {
			throw new BizException("XML_PARSE_ERROR", e);
		} catch (IOException e) {
			throw new BizException("XML_READ_ERROR", e);
		} finally {
			closeStream(xml.getByteStream());
		}

		return doc;
	}

	/**
	 * Creates a root element as well as a new document with specific tag name.
	 * 
	 * @param tagName the name of the root element
	 * @return a new element instance
	 * @throws BizException problem generating a new document
	 */
	public static Element createRootElement(String tagName) throws BizException {
		Document doc = newDocument();
		Element root = doc.createElement(tagName);
		doc.appendChild(root);
		return root;
	}

	/**
	 * Gets the root element from input stream.
	 * 
	 * @param xml the XML file input stream
	 * @return the root element of parsed document
	 * @throws BizException problem parsing the XML file input stream
	 */
	public static Element getRootElementFromStream(InputStream xml) throws BizException {
		return getDocument(new InputSource(xml), null).getDocumentElement();
	}

	/**
	 * Gets the root element from input stream.
	 * 
	 * @param xml the XML file input stream
	 * @return the root element of parsed document
	 * @throws BizException problem parsing the XML file input stream
	 */
	public static Element getRootElementFromStream(InputStream xml, InputStream xsd) throws BizException {
		return getDocument(new InputSource(xml), xsd).getDocumentElement();
	}

	/**
	 * Gets the root element from given XML file.
	 * 
	 * @param xml the name of the XML file
	 * @return the root element of parsed document
	 * @throws BizException problem parsing the XML file
	 */
	public static Element getRootElementFromFile(File xml) throws BizException {
		return getDocument(xml).getDocumentElement();
	}

	/**
	 * Gets the root element from the given XML payload.
	 * 
	 * @param payload the XML payload representing the XML file.
	 * @return the root element of parsed document
	 * @throws BizException problem parsing the XML payload
	 */
	public static Element getRootElementFromString(String payload) throws BizException {
		if (payload == null || payload.length() < 1) {
			throw new BizException("XML_PAYLOAD_EMPTY");
		}

		StringReader sr = new StringReader(escapeXml(payload));
		InputSource source = new InputSource(sr);
		return getDocument(source, null).getDocumentElement();
	}

	/**
	 * Gets the descendant elements list from the parent element.
	 * 
	 * @param parent the parent element in the element tree
	 * @param tagName the specified tag name
	 * @return the NOT NULL descendant elements list
	 */
	public static List<Element> getElements(Element parent, String tagName) {
		NodeList nodes = parent.getElementsByTagName(tagName);
		List<Element> elements = new ArrayList<Element>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element) {
				elements.add((Element) node);
			}
		}

		return elements;
	}

	/**
	 * Gets the immediately descendant element from the parent element.
	 * 
	 * @param parent the parent element in the element tree
	 * @param tagName the specified tag name.
	 * @return immediately descendant element of parent element, NULL otherwise.
	 */
	public static Element getElement(Element parent, String tagName) {
		List<Element> children = getElements(parent, tagName);

		if (children.isEmpty()) {
			return null;
		} else {
			return children.get(0);
		}
	}

	/**
	 * Gets the immediately child elements list from the parent element.
	 * 
	 * @param parent the parent element in the element tree
	 * @param tagName the specified tag name
	 * @return the NOT NULL immediately child elements list
	 */
	public static List<Element> getChildElements(Element parent, String tagName) {
		NodeList nodes = parent.getElementsByTagName(tagName);
		List<Element> elements = new ArrayList<Element>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element && node.getParentNode() == parent) {
				elements.add((Element) node);
			}
		}

		return elements;
	}

	/**
	 * Gets the immediately child elements list from the parent element.
	 * 
	 * @param parent the parent element in the element tree
	 * @return the NOT NULL immediately child elements list
	 */
	public static List<Element> getChildElements(Element parent) {
		NodeList nodes = parent.getChildNodes();
		List<Element> elements = new ArrayList<Element>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element && node.getParentNode() == parent) {
				elements.add((Element) node);
			}
		}

		return elements;
	}

	/**
	 * Gets the immediately child element from the parent element.
	 * 
	 * @param parent the parent element in the element tree
	 * @param tagName the specified tag name
	 * @return immediately child element of parent element, NULL otherwise
	 */
	public static Element getChildElement(Element parent, String tagName) {
		List<Element> children = getChildElements(parent, tagName);

		if (children.isEmpty()) {
			return null;
		} else {
			return children.get(0);
		}
	}

	/**
	 * Gets the value of the child element by tag name under the given parent
	 * element. If there is more than one child element, return the value of the
	 * first one.
	 * 
	 * @param parent the parent element
	 * @param tagName the tag name of the child element
	 * @return value of the first child element, NULL if tag not exists
	 */
	public static String getElementValue(Element parent, String tagName) {
		Element element = getElement(parent, tagName);
		if (element != null) {
			return element.getTextContent();
		} else {
			return null;
		}
	}

	/**
	 * Gets the value of the immediately child element by tag name under the given parent
	 * element. If there is more than one child element, return the value of the
	 * first one.
	 * 
	 * @param parent the parent element
	 * @param tagName the tag name of the child element
	 * @return value of the first child element, NULL if tag not exists
	 */
	public static String getChildElementValue(Element parent, String tagName) {
		Element element = getChildElement(parent, tagName);
		if (element != null) {
			return element.getTextContent();
		} else {
			return null;
		}
	}
	/**
	 *
	 * @param element
	 * @return
	 */
	public static String getElementValue(Element element) {
		if (element != null) {
			NodeList nodes = element.getChildNodes();
			if (nodes != null && nodes.getLength() > 0) {
				for (int i = 0; i < nodes.getLength(); i++) {
					Node node = nodes.item(i);
					if (node instanceof Text) {
						return ((Text) node).getData();
					}
				}
			}
		}

		return null;
	}

	/**
	 * Gets the specific attribute's value form current element.
	 * 
	 * @param current current element
	 * @param attrName attribute name in current element
	 * @return attribute value if not null
	 */
	public static String getAttributeValue(Element current, String attrName) {
		if (current.hasAttribute(attrName)) {
			return current.getAttribute(attrName);
		} else {
			return null;
		}
	}

	/**
	 * Appends the child element to the parent element.
	 * 
	 * @param parent the parent element
	 * @param tagName the child element name
	 * @return the child element added to the parent element
	 */
	public static Element appendElement(Element parent, String tagName) {
		Element child = parent.getOwnerDocument().createElement(tagName);
		parent.appendChild(child);
		return child;
	}

	/**
	 * Appends the child element as well as value to the parent element.
	 * 
	 * @param parent the parent element
	 * @param tagName the child element name
	 * @param value the child element value
	 * @return the child element added to the parent element
	 */
	public static Element appendElement(Element parent, String tagName, String value) {
		Element child = appendElement(parent, tagName);
		child.setTextContent(value);
		return child;
	}

	/**
	 * Appends another element as a child element.
	 * 
	 * @param parent the parent element
	 * @param child the child element to append
	 */
	public static void appendElement(Element parent, Element child) {
		Node tmp = parent.getOwnerDocument().importNode(child, true);
		parent.appendChild(tmp);
	}

	/**
	 * Appends the CDATA element to the parent element.
	 * 
	 * @param parent the parent element
	 * @param tagName the CDATA element name
	 * @param value the CDATA element value
	 * @return the CDATA element added to the parent element
	 */
	public static Element appendCDATAElement(Element parent, String tagName, String value) {
		Element child = appendElement(parent, tagName);
		if (value == null) { // avoid "null" word in the XML payload
			value = "";
		}

		Node cdata = child.getOwnerDocument().createCDATASection(value);
		child.appendChild(cdata);
		return child;
	}

	/**
	 * Converts the Node/Element instance to XML payload.
	 * 
	 * @param node the node/element instance to convert
	 * @return the XML payload representing the node/element
	 * @throws BizException problem converting XML to string
	 */
	public static String childNodeToString(Node node) throws BizException {
		String payload = null;

		try {
			Transformer tf = TransformerFactory.newInstance().newTransformer();

			Properties props = tf.getOutputProperties();
			props.setProperty(OutputKeys.OMIT_XML_DECLARATION, LOGIC_YES);
            props.setProperty(OutputKeys.ENCODING, DEFAULT_ENCODE);
			tf.setOutputProperties(props);

			StringWriter writer = new StringWriter();
			tf.transform(new DOMSource(node), new StreamResult(writer));
			payload = escapeXml(writer.toString());
		} catch (TransformerException e) {
			throw new BizException("XML_TRANSFORM_ERROR", e);
		}

		return payload;
	}

	/**
	 * Converts the Node/Document/Element instance to XML payload.
	 * 
	 * @param node the node/document/element instance to convert
	 * @return the XML payload representing the node/document/element
	 * @throws BizException problem converting XML to string
	 */
	public static String nodeToString(Node node) throws BizException {
		String payload = null;

		try {
			Transformer tf = TransformerFactory.newInstance().newTransformer();

			Properties props = tf.getOutputProperties();
			props.setProperty(OutputKeys.ENCODING, DEFAULT_ENCODE);
			props.setProperty(OutputKeys.INDENT, LOGIC_YES);
			tf.setOutputProperties(props);

			StringWriter writer = new StringWriter();
			tf.transform(new DOMSource(node), new StreamResult(writer));
			payload = escapeXml(writer.toString());
		} catch (TransformerException e) {
			throw new BizException("XML_TRANSFORM_ERROR", e);
		}

		return payload;
	}

	public static String escapeXml(String payload) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < payload.length(); i++) {
			char c = payload.charAt(i);
			if ((c == 0x9) || (c == 0xA) || (c == 0xD) || ((c >= 0x20) && (c <= 0xD7FF))
					|| ((c >= 0xE000) && (c <= 0xFFFD)) || ((c >= 0x10000) && (c <= 0x10FFFF)))
				out.append(c);
		}
		return out.toString();
	}

	/**
	 * Converts the an XML file to XML payload.
	 * 
	 * @param file the XML file instance
	 * @return the XML payload representing the XML file
	 * @throws BizException problem transforming XML to string
	 */
	public static String xmlToString(File file) throws BizException {
		Element root = getRootElementFromFile(file);
		return nodeToString(root);
	}

	/**
	 * Converts the an XML file input stream to XML payload.
	 * 
	 * @param in the XML file input stream
	 * @return the payload represents the XML file
	 * @throws BizException problem transforming XML to string
	 */
	public static String xmlToString(InputStream in) throws BizException {
		Element root = getRootElementFromStream(in);
		return nodeToString(root);
	}

	/**
	 * Saves the node/document/element as XML file.
	 * 
	 * @param doc the XML node/document/element to save
	 * @param file the XML file to save
	 * @throws BizException problem persisting XML file
	 */
	public static void saveToXml(Node doc, File file) throws BizException {
		OutputStream out = null;

		try {
			Transformer tf = TransformerFactory.newInstance().newTransformer();

			Properties props = tf.getOutputProperties();
			props.setProperty(OutputKeys.METHOD, XMLConstants.XML_NS_PREFIX);
			props.setProperty(OutputKeys.INDENT, LOGIC_YES);
			tf.setOutputProperties(props);

			DOMSource dom = new DOMSource(doc);
			out = getOutputStream(file);
			Result result = new StreamResult(out);
			tf.transform(dom, result);
		} catch (TransformerException e) {
			throw new BizException("XML_TRANSFORM_ERROR", e);
		} finally {
			closeStream(out);
		}
	}

	/**
	 * Validates the XML file via the given XML schema file.
	 * 
	 * @param xml the XML file to validate
	 * @param xsd the XML schema file
	 * @throws BizException error occurs if validation fail
	 */
	public static void validateXml(InputStream xml, InputStream xsd) throws BizException {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			Document doc = dbf.newDocumentBuilder().parse(xml);
			validateXml(doc, xsd);
		} catch (SAXException e) {
			throw new BizException("XML_VALIDATE_ERROR", e);
		} catch (Exception e) {
			throw new BizException("XML_READ_ERROR", e);
		} finally {
			closeStream(xml);
			closeStream(xsd);
		}
	}

	/**
	 * Validates the XML file via the given XML schema file.
	 * 
	 * @param root the root element of XML
	 * @param xsd the XML schema file
	 * @throws BizException error occurs if validation fail
	 */
	public static void validateXml(Node root, InputStream xsd) throws BizException {
		try {
			Source source = new StreamSource(xsd);
			Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(source);

			Validator validator = schema.newValidator();
			validator.validate(new DOMSource(root));
		} catch (SAXException e) {
			throw new BizException("XML_VALIDATE_ERROR", e);
		} catch (Exception e) {
			throw new BizException("XML_READ_ERROR", e);
		} finally {
			closeStream(xsd);
		}
	}

	/**
	 * Transforms the XML content to XHTML/HTML format string with the XSL.
	 * 
	 * @param payload the XML payload to convert
	 * @param xsltFile the XML stylesheet file
	 * @return the transformed XHTML/HTML format string
	 * @throws BizException problem converting XML to HTML
	 */
	public static String xmlToHtml(String payload, File xsltFile) throws BizException {
		String result = null;

		try {
			Source template = new StreamSource(xsltFile);
			Transformer transformer = TransformerFactory.newInstance().newTransformer(template);

			Properties props = transformer.getOutputProperties();
			props.setProperty(OutputKeys.OMIT_XML_DECLARATION, LOGIC_YES);
			transformer.setOutputProperties(props);

			StreamSource source = new StreamSource(new StringReader(payload));
			StreamResult sr = new StreamResult(new StringWriter());
			transformer.transform(source, sr);

			result = sr.getWriter().toString();
		} catch (TransformerException e) {
			throw new BizException("XML_TRANSFORM_ERROR", e);
		}

		return result;
	}

	/**
	 * Sets the namespace to specific element.
	 * 
	 * @param element the element to set
	 * @param namespace the namespace to set
	 * @param schemaLocation the XML schema file location URI
	 */
	public static void setNamespace(Element element, String namespace, String schemaLocation) {
		element.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, XMLConstants.XMLNS_ATTRIBUTE, namespace);
		element.setAttributeNS(XMLConstants.XMLNS_ATTRIBUTE_NS_URI, XMLNS_XSI, XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
		element.setAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, XSI_SCHEMA_LOCATION, schemaLocation);
	}

	/**
	 * Encode the XML payload to legality character.
	 * 
	 * @param payload the XML payload to encode
	 * @return the encoded XML payload
	 * @throws BizException problem encoding the XML payload
	 */
	public static String encodeXml(String payload) throws BizException {
		Element root = createRootElement(XMLConstants.XML_NS_PREFIX);
		root.setTextContent(payload);
		return childNodeToString(root.getFirstChild());
	}

	private static void closeStream(Closeable stream) {
		if (stream != null) {
			try {
				stream.close();
			} catch (IOException e) {
			}
		}
	}

	private static InputStream getInputStream(File file) throws BizException {
		InputStream in = null;

		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			throw new BizException("XML_FILE_NOT_FOUND", e);
		}

		return in;
	}

	private static OutputStream getOutputStream(File file) throws BizException {
		OutputStream in = null;

		try {
			in = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			throw new BizException("XML_FILE_NOT_FOUND", e);
		}

		return in;
	}

	public static void main(String[] args) {
	try {
		Element root = createRootElement("ROOT");
		appendElement(root,"TransCode","value");
		appendElement(root,"TransDate","value");
		appendElement(root,"TransTime","value");
		appendElement(root,"JnlNo","value");
		appendElement(root,"ChkDate","value");
		appendElement(root,"ComCode","value");
		
		
		
		String s = nodeToString(root);
		System.out.println(s);
		//Element e = createRootElement("ROOT");
	} catch (BizException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}