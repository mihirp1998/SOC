import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;
public class bookparsertest{
	public static void main(String args[]) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File("books.xml"));
		Element root = doc.getDocumentElement();
		System.out.println("root name "+ root.getNodeName() + "root val "+ root.getNodeValue());
		NodeList nl = root.getChildNodes();
		int len = nl.getLength();
		for(int i = 0;i<len;i++){
			Node item = nl.item(i);
			System.out.println("node name "+ item.getNodeName() + "node val "+ item.getNodeValue());

		}
		Element elem = doc.createElement("Papa");
		elem.setTextContent("pp");
		Attr allib = doc.createAttribute("name");
		// elem.appendChild(allib);
		root.appendChild(elem);
		TransformerFactory tsf = TransformerFactory.newInstance();
		Transformer ts = tsf.newTransformer();
		DOMSource domr = new DOMSource(doc);
		StreamResult sr = new StreamResult(System.out);
		ts.transform(domr,sr);


	}
}