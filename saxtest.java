import javax.xml.parsers.*;
import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
public class saxtest{
	public static void main(String args[]) throws Exception{
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sax = spf.newSAXParser();
		sax.parse(new File("books.xml"),new myHandler());
	}
}
class myHandler extends DefaultHandler{
	public void characters(char[] ch,int start, int len){
				System.out.println("characters "+ new String(ch,start,len));

	}
	public void startDocument(){
		System.out.println("start document");

	}
	public void endDocument(){
		System.out.println("End document");

	}
	public void startElement(String uri, String localName, String qName, Attributes attr){
		System.out.println("Name "+ localName + "qname " + qName);
		int attLen = attr.getLength();
		for(int i =0;i<attLen;i++){
		System.out.println("Att name "+ attr.getQName(i) + "Att val "+ attr.getValue(i));
		}
	}
	public void endElement(String uri, String localName, String qName){
		System.out.println("End element");
	}

}