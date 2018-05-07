/*import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


public class XMLMap {
    // All static variables
    static final String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    // XML node keys
    static final String KEY_ITEM = "Cube"; // parent node
    static final String KEY_CURRENCY = "currency";
    static final String KEY_RATE = "rate";
    XMLParser parser;
    NodeList n1;
    HashMap<String, String> map;


    String xml = parser.getXmlFromUrl(URL); // getting XML
    Document doc = parser.getDomElement(xml); // getting DOM element

    n1 = doc.getElementsByTagName( KEY_ITEM);
    // creating new HashMap
    map = new HashMap<String, String>();

    // looping through all item nodes <item>
    for (int i = 0; i < nl.getLength(); i++) {
        Element e = (Element) nl.item(i);
        String currencyName = e.getAttribute(KEY_CURRENCY);
        String currencyValue = e.getAttribute(KEY_RATE);
        // adding each child node to HashMap key => value
        map.put( currencyName, currencyValue);
        //Log.e("after", currencyValue + "");
    }

}


class XMLParser {

    // constructor
    public XMLParser() {

    }

    /**
     * Getting XML from URL making HTTP request
     *
     * @param url string
     */
/*
    public String getXmlFromUrl(String url) {
        String xml = null;

        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return XML
        return xml;
    }

    /**
     * Getting XML DOM element
     */
/*
    public Document getDomElement(String xml) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }

        return doc;
    }
}
}
*/