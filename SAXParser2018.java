import javax.xml.parsers.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;
import java.io.*;
import java.util.*;
public class SAXParser2018
{
public static void main(String[] args) throws Exception
{
SAXParserFactory FactoryObj=SAXParserFactory.newInstance();
FactoryObj.setValidating(false);
SAXParser parserobj= FactoryObj.newSAXParser();
CallbackHandler Callbackobj=new CallbackHandler();
File xmlFile=new File("SAXParser.xml");
parserobj.parse(xmlFile, Callbackobj);


}
}
class CallbackHandler extends DefaultHandler
{
public void startDocument() throws SAXException
{
System.out.println("Parsing has commenced\n");
}
public void endDocument() throws SAXException
{
System.out.println("Parsing has ended\n");
}
public void startElement(String uri,String localName,String qName,Attributes attributes)throws SAXException
{
System.out.println("Element Name: "+qName);
int numofAttributes=attributes.getLength();
for(int i=0;i<numofAttributes;i++)
{
String NameAttribute=attributes.getQName(i);
String ValueAttribute=attributes.getValue(i);
System.out.println(NameAttribute+"= "+ValueAttribute);
} 
}
public void endElement(String uri,
String localName,
String qName)
throws SAXException
{
System.out.println("End Element\n");
}
public void characters(char[] ch,
int start,
int length)
throws SAXException
{
String ContentofElements=new String(ch,start,length);
System.out.println("Content of Elements "+ContentofElements);
}

}