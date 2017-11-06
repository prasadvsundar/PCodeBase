package WordCount;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
public static void main(String[] args) throws URISyntaxException, MalformedURLException {
	String referer = "https://bi-oru.mfxservices.com/bi-oru.mfxservices.com/";
	//String referer = "http://172.16.0.201:8098/NanoClientApplication/Welcome";
	
	URI uri = new URI(referer);
    String domain = uri.getHost();
    System.out.println(domain);
    
    
    URL aURL = new URL("http://example.com:80/docs/books/tutorial"
            + "/index.html?name=networking#DOWNLOADING");

System.out.println("protocol = " + aURL.getProtocol()+"://"+aURL.getAuthority()); //http
System.out.println("authority = " + aURL.getAuthority()); //example.com:80
System.out.println("host = " + aURL.getHost()); //example.com
System.out.println("port = " + aURL.getPort()); //80
System.out.println("path = " + aURL.getPath()); //  /docs/books/tutorial/index.html
System.out.println("query = " + aURL.getQuery()); //name=networking
System.out.println("filename = " + aURL.getFile()); ///docs/books/tutorial/index.html?name=networking
System.out.println("ref = " + aURL.getRef()); //DOWNLOADING
    
	/*referer = referer.substring(
			0,
			referer.indexOf(
					"/",
					referer.indexOf("/", referer.indexOf("/",
							referer.indexOf("/") + 1) + 1) + 1));
	System.out.println(referer);*/
}

}
