package edu.ucsb.cs56.projects.weather.tides.model;

import java.net.*;
import java.io.*;
import java.util.ArrayList;


import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.Certificate;
import java.io.*;
 

/**
   This object is designed to download the XML data for 
   Santa Barbara tides from:

   http://tidesandcurrents.noaa.gov/noaatidepredictions/NOAATidesFacade.jsp?Stationid=9411340&datatype=Annual%20XML

   @author Phill Conrad
   @version UCSB CS56 S13
*/

public class TideDownloader
{  

    public static final boolean debug=true;

    /** default URL used in the main */

    public static final String TIDE_XMLFILE_URL =
	"http://tidesandcurrents.noaa.gov/noaatidepredictions/NOAATidesFacade.jsp?Stationid=9411340&datatype=Annual%20XML";

    /** getTideXMLContent() is just a convenient wrapper around
	the stuff that gets the XML content from the URL.

       @return XML Content for Tide Information
    */
    public static String getTideXMLContent() {
	StringBuffer wholeResponse = null;
	try {
	    String agent = "Mozilla/4.0";
	    String encodedData = "";
	    URL endpoint = new URL(TIDE_XMLFILE_URL);
	    HttpURLConnection urlc = null;
	    
	    urlc = (HttpURLConnection) endpoint.openConnection();
	    urlc.setRequestMethod("GET");
	    urlc.setDoInput(true);
	    urlc.setUseCaches(false);
	    urlc.setAllowUserInteraction(false);
	    urlc.setRequestProperty("Referer",TIDE_XMLFILE_URL);

	    int rc = urlc.getResponseCode();
	    
	    BufferedReader in = 
		new BufferedReader(new InputStreamReader(urlc.getInputStream()));
	    
	    String inputLine;
	    wholeResponse = new StringBuffer();
	    
	    while ((inputLine = in.readLine()) != null) {
		wholeResponse.append(inputLine + "\n");
	    }
	    in.close();
	}
	catch( IOException e ){
	    System.out.println(e);
	    e.printStackTrace();
	}
	if (wholeResponse==null)
	    return null;
	else
	    return wholeResponse.toString();
	
    }


    /** main method to demonstrate that the getTideXMLContent() method
	works.
     */

    public static void main(String [] args) {
	try {
	    String xmlContent = getTideXMLContent();
	    System.out.println(xmlContent);
	    
	} catch (Exception e) {
	    System.err.println(e);
	    e.printStackTrace();
	}
    }  // main
	
}
