import javax.xml.parsers.*;
import org.w3c.dom.*;
public class BooksParser
{
public static void main(String[] args) throws Exception
{
DocumentBuilderFactory Factoryobj=DocumentBuilderFactory.newInstance();
Factoryobj.setValidating(false);

DocumentBuilder DOmParser=Factoryobj.newDocumentBuilder();
//create a domparser of non-validating
Document XMLTreeObj= DOmParser.parse("books.xml");
//Get the root element from the xml tree
Element RootElem=XMLTreeObj.getDocumentElement();
String ElementName=RootElem.getTagName();
String ElementValue=RootElem.getNodeValue();
System.out.println("Name: " +ElementName);
System.out.println("Value: " +ElementValue);
//find the number of children for root element
NodeList ListObj=RootElem.getChildNodes();
//Get the number of children by getting the length of the list
int length=ListObj.getLength();
System.out.println("Length of the list is "+ListObj.getLength());
//Listing the child nodes of the root element
for(int index=0;index<length;index++ )
{ 
Node fromList=ListObj.item(index);
NodeList from_fromList = fromList.getChildNodes();
int from_fromListLength = from_fromList.getLength();
for(int i =0;i<from_fromListLength;i++){
	Node node = from_fromList.item(i); 
	System.out.println("Node Name: "+node.getNodeName()+" Node Value: "+node.getTextContent());

}
System.out.println("Node Name: "+fromList.getNodeName()+" Node Value: "+fromList.getNodeValue());
}
}
}