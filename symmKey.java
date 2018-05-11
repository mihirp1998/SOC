import java.lang.Object;
import javax.crypto.*;
class symmKey
{
public static void main(String[] args) throws Exception
{
KeyGenerator keyGenobj= KeyGenerator.getInstance("DES");
//specify the size of the key
keyGenobj.init(56);
//key generator and cipher objects
SecretKey keyobj=keyGenobj.generateKey();
Cipher c= Cipher.getInstance("DES/ECB/PKCS5Padding");
//Initialize this cipher with a key as well as a mode
c.init(Cipher.ENCRYPT_MODE,keyobj);
String ToBeEncrypted="Attend lab and class regularly";
byte[] ToBeEncryptedBytes=ToBeEncrypted.getBytes("UTF8");//every byte is converted to 8 bit or 16 bit- its a format
byte[] EncryptedBytes=c.doFinal(ToBeEncryptedBytes);
String EncryptedString=new String(EncryptedBytes,"UTF8");
System.out.println("Encrypted Stuff: "+EncryptedString);
c.init(Cipher.DECRYPT_MODE,keyobj);
byte[] DecryptedBytes=c.doFinal(EncryptedBytes);
String DecryptedString=new String(DecryptedBytes,"UTF8");
System.out.println("Decrypted Stuff: "+DecryptedString);

}



}
