import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
public class transformer
{
public static void main(String[] args) throws Exception
{
DocumentBuilderFactory Factoryobj=DocumentBuilderFactory.newInstance();
Factoryobj.setValidating(false);

DocumentBuilder DOmParser=Factoryobj.newDocumentBuilder();
//create a domparser of non-validating
Document XMLTreeObj= DOmParser.parse("transformer.xml");
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
/*for(int index=0;index<length;index++ )
{ 
Node fromList=ListObj.item(index);
System.out.println("Node Name: "+fromList.getNodeName()+" Node Value: "+fromList.getNodeValue());
}*/
Element BookEle=(Element)ListObj.item(1);
NamedNodeMap MapObj=BookEle.getAttributes();
Node AttrNode=MapObj.item(0);
String AttrName=AttrNode.getNodeName();
String AttrValue=AttrNode.getNodeValue();
System.out.println("Attribute Name= "+AttrName+"Attribute Value= "+AttrValue);
Element ElemISBN=XMLTreeObj.createElement("ISBN");
Text TextValue=XMLTreeObj.createTextNode("2100");
ElemISBN.appendChild(TextValue);
BookEle.appendChild(ElemISBN);
//Transformer object helps us to view the tree on the console itself
TransformerFactory TransFact=TransformerFactory.newInstance();
Transformer Transformerobj=TransFact.newTransformer();
//transform(Source xmlSource, Result outputTarget)
DOMSource SourceObject=new DOMSource(XMLTreeObj);
StreamResult Displayout=new StreamResult(System.out);
//Transformerobj.transform(SourceObject,Displayout);
//Cloning a node
Element clonenode=(Element)BookEle.cloneNode(true);
RootElem.appendChild(BookEle);
Transformerobj.transform(SourceObject,Displayout);

}//end of main
}//end of class