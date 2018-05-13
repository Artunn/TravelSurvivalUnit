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
import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * __XMLMap class to parse the currency data and place them in a HashMap___
 * @author __Ayşe Ezgi Yavuz ___
 * @version __11.05.2018__
 */
public class XMLMap implements Serializable {
    // properties
    // XML URL to be parsed
    private static final String URL = "https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
    // XML node keys
    private static final String KEY_ITEM = "Cube"; // parent node
    private static final String KEY_CURRENCY = "currency";
    private static final String KEY_RATE = "rate";
    private XMLParser parser; //reference for the inner class XMLParser
    private NodeList nodeList;
    private HashMap<String, Double> map;

    // constructor
    public XMLMap(){
        parser = new XMLParser();
        map = new HashMap<String, Double>();

        Thread thread = new Thread (new Runnable() {
            @Override
            public void run() {
                try{
                    String xml = parser.getXmlFromUrl(URL); // getting XML
                    Document doc = parser.getDomElement(xml); // getting DOM element

                    nodeList = doc.getElementsByTagName(KEY_ITEM);

                    // looping through all item nodes
                    for (int i = 0; i < nodeList.getLength(); i++) {
                        Element e = (Element) nodeList.item(i);
                        String currencyName = e.getAttribute(KEY_CURRENCY);
                        String currencyValue = e.getAttribute(KEY_RATE);
                        // adding each child node to HashMap key => value
                        if ( !currencyValue.isEmpty() )
                            map.put(currencyName, Double.parseDouble(currencyValue));
                    }
                }

                catch (Exception e) {e.printStackTrace();}
            }
        });

        thread.start();
    }
    // methods
    public HashMap<String, Double> getMap() {return map;}

    /**
     * __XMLParser class to convert to given URL to a doc format___
     * @author __Ayşe Ezgi Yavuz ___
     * @version __11.05.2018__
     */
    private class XMLParser {
        // constructor
        private XMLParser() {
        }

        /**
         * Getting XML from URL making HTTP request
         * @param url String
         * @return xml String
         */
        private String getXmlFromUrl( String url) {
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
         * @param xml String
         * @return doc Document
         */
        private Document getDomElement( String xml){
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