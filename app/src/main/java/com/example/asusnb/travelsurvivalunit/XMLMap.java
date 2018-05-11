package com.example.asusnb.travelsurvivalunit;
import android.util.Log;

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
    private static final String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    // XML node keys
    private static final String KEY_ITEM = "Cube"; // parent node
    private static final String KEY_CURRENCY = "currency";
    private static final String KEY_RATE = "rate";
    private XMLParser parser;
    private NodeList nodeList;
    private HashMap<String, Double> map;


    public XMLMap(){

        parser = new XMLParser();
        String xml = parser.getXmlFromUrl(URL); // getting XML
        Document doc = parser.getDomElement(xml); // getting DOM element

        nodeList = doc.getElementsByTagName( KEY_ITEM);
        // creating new HashMap
        map = new HashMap<String, Double>();

        // looping through all item nodes <item>
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element e = (Element) nodeList.item(i);
            String currencyName = e.getAttribute(KEY_CURRENCY);
            String currencyValue = e.getAttribute(KEY_RATE);
            // adding each child node to HashMap key => value
            map.put( currencyName, Double.parseDouble(currencyValue));
            //Log.e("after", currencyValue + "");
        }
    }

    public HashMap<String, Double> getMap() {
        return map;
    }

    class XMLParser {
        // constructor
        private XMLParser() {
        }

        /**
         * Getting XML from URL making HTTP request
         *
         * @param url string
         */
        String getXmlFromUrl( String url){
            String xml;
            // defaultHttpClient
            DefaultHttpClient httpClient;
            HttpPost httpPost;
            HttpResponse httpResponse;
            HttpEntity httpEntity;

            xml = null;
            try {
                httpClient = new DefaultHttpClient();
                httpPost = new HttpPost(url);
                httpResponse = httpClient.execute(httpPost);
                httpEntity = httpResponse.getEntity();
                xml = EntityUtils.toString(httpEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return xml;
        }

        /**
         * Getting XML DOM element
         */
        Document getDomElement( String xml){
            Document doc;
            DocumentBuilderFactory dbf;
            DocumentBuilder db;
            InputSource is;

            dbf = DocumentBuilderFactory.newInstance();
            try {

                db = dbf.newDocumentBuilder();
                is = new InputSource();
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