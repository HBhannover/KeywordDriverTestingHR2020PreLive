package makeInput;
import makeInput.Constans;
import makeInput.KeywordsEditor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.Formatter;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.common.net.HttpHeaders;

import makeInput.Common;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

//import org.apache.log4j.Logger;
import java.text.MessageFormat;


public class ExcecutionEngine {
	public static KeywordsEditor keywordsEdit1; 
	static String statusId = null;
	static String issueId = null;
	static String issueTypeId = null;
	static String encoding =("admin" + ":" + "admin");
	static byte[] bytesEncoded = Base64.encodeBase64(encoding.getBytes());

	static Handler file_handler;
	static Formatter klartext;
	static String comment;
	
	 static Logger logger = Logger.getLogger("ExcecutionEngine");
	
	//static KeywordsEditor keywordsEdit;

	public static void main(String[] args) throws Exception {
		   Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		   logger.setLevel(Level.ALL);
		
		LogManager.getLogManager().readConfiguration(new FileInputStream("U:\\git\\KeywordDriverTestingHR2020\\src\\main\\java\\Log4jDB\\loggingAPI.properties"));
	  
		logger.info("ANFANG VON LOGS");
		String sentence = "";
		String executionId="";
		keywordsEdit1= new KeywordsEditor();
		
        System.out.println("Default Charset=" + Charset.defaultCharset());

        System.setProperty("file.encoding", "Latin-1");

        System.out.println("file.encoding=" + System.getProperty("file.encoding"));

        System.out.println("Default Charset=" + Charset.defaultCharset());


		//args[0]= "bach";

		// Selenium:
		//System.setProperty("webdriver.gecko.driver","U:\\git\\KeywordDriverTestingHR2020\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","U:\\git\\KeywordDriverTestingHR2020\\Drivers\\chromedriver.exe");
	//	keywordsEdit = new KeywordsEdit();
	//	keywordsEdit = new KeywordsEditor();
		
		for (int i = 0; i < args.length; i++) {
    		System.out.println("Die Eingabe war: " +args[i]);
    		//API GET Request um die zu automatisierenden Sätze aus der Jira Cloud zu laden
    		String uri=("http://localhost:2990/jira/rest/api/latest/issue/"+args[i]);
    		String proxy =("http://localhost:8080/");
    		URL url = new URL(uri);
    		
    		System.out.println(url);
    		

    		// Encode data on your side using BASE64
    		String encoding =("admin" + ":" + "admin");
    		byte[] bytesEncoded = Base64.encodeBase64(encoding.getBytes());
    		
    		System.out.println("encoded value is " + new String(bytesEncoded));
            //"YWRtaW4gOiBhZG1pbg==";//Base64Encoder.encode;

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty("Authorization", "Basic "+new String(bytesEncoded));

            //String contentType = con.getHeaderField("Content-Type");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); //Writer out = new OutputStreamWriter(new FileOutputStream(yourFile), "windows-1252");

            String inputLine;

            StringBuffer content = new StringBuffer();
            

            while ((inputLine = in.readLine()) != null) {

                content.append(inputLine);

            }

            in.close();

            con.disconnect();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(content.toString());
            JSONObject fields =(JSONObject) jsonObject.get("fields");
            JSONObject project =(JSONObject) fields.get("project");
            JSONObject issueType =(JSONObject) fields.get("issuetype");
            
            
            issueId=jsonObject.get("id").toString();
            issueTypeId=issueType.get("id").toString();
            String projectId=project.get("id").toString();
            	
            System.out.println(issueTypeId);
    		
    		if( issueTypeId.equals("10002"))
    		{
    		
    		//API Request für Testfälle
    		String uri5=("http://localhost:2990/jira/rest/zapi/latest/teststep/"+args[i]+"?offset=0&limit=50");
    		
    		URL url5 = new URL(uri5);
    		
    		System.out.println(url5);
    		

    		
    		System.out.println("encoded value is " + new String(bytesEncoded));
            //"YWRtaW4gOiBhZG1pbg==";//Base64Encoder.encode;

            HttpURLConnection con5 = (HttpURLConnection) url5.openConnection();

            con5.setRequestMethod("GET");

            con5.setRequestProperty("Authorization", "Basic "+new String(bytesEncoded));

            //String contentType = con.getHeaderField("Content-Type");

            int status5 = con5.getResponseCode();

            BufferedReader in5 = new BufferedReader(new InputStreamReader(con5.getInputStream())); //Writer out = new OutputStreamWriter(new FileOutputStream(yourFile), "windows-1252");

            String inputLine5;

            StringBuffer content5 = new StringBuffer();
            

            while ((inputLine5 = in5.readLine()) != null) {

                content5.append(inputLine5);

            }

            in5.close();

            con5.disconnect();
            JSONParser jsonParser5 = new JSONParser();
            JSONObject jsonObject5 = (JSONObject) jsonParser5.parse(content5.toString());
            JSONArray JSONArray =(JSONArray) jsonObject5.get("stepBeanCollection");
            int size= jsonObject5.size();
            System.out.println(size);
            System.out.println("OBJEKT"+jsonObject5);
            for(int k=0;k<size;k++)
            {
            	JSONObject testStep= (JSONObject) JSONArray.get(k);
            	String testStepSentence =testStep.get("step").toString();
            	sentence+= testStepSentence;
            	System.out.println("SATZ:"+testStepSentence);
    		}

    		}
    		else {
    			sentence= fields.get("customfield_10100").toString();
    			
    		}
    			
            System.out.println("Zu automatisierender Satz: "+sentence); 
            System.out.println("IssueId: "+issueId+"  ProjektId: "+projectId); 	
    			

             
            
 //POST Request zum Jira Addon Zephyr um dort einen Testfall zu starten           
            
    		String uri1=("http://localhost:2990/jira/rest/zapi/latest/execution");
    		
    		//String data = ("{\"cycleId\":\"-1\",\"issueId\":"+issueId+",\"projectId\":"+projectId+",\"assigneeType\":\"assignee\",\"assignee\":\"admin\"}");
    		//"executionStatus": "-1"
    		String data = ("{\"issueId\":"+issueId+",\"projectId\":"+projectId+"}");
    		URL url1 = new URL(uri1);
    		
    		System.out.println(url1);

            HttpURLConnection con1 = (HttpURLConnection) url1.openConnection();

            con1.setRequestMethod("POST");

            con1.setRequestProperty("Authorization", "Basic "+new String(bytesEncoded));
            
            con1.setDoOutput(true);
            con1.setRequestProperty("Content-Type", "application/json");
            con1.setRequestProperty("Accept", "application/json");

            //String contentType = con1.getHeaderField("Content-Type");

            
            
            
            OutputStreamWriter osw = new OutputStreamWriter(con1.getOutputStream());
            osw.write(data);
            osw.flush();
            osw.close();
            BufferedReader in1 = new BufferedReader(new InputStreamReader(con1.getInputStream())); //Writer out = new OutputStreamWriter(new FileOutputStream(yourFile), "windows-1252");
            
            if (con1 != null) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = in1.readLine()) != null) {
                    System.out.println(" line : " + line);
                    sb.append(line);
                }
                String getResponseString = "";
                getResponseString = sb.toString();
                JSONObject jsonObject1 = (JSONObject) jsonParser.parse(getResponseString);
                JSONArray jsonObject2= (JSONArray) jsonParser.parse(jsonObject1.values().toString());
                JSONObject jsonObject3= (JSONObject) jsonParser.parse(jsonObject2.get(0).toString());
                executionId= jsonObject3.get("id").toString();
                //keywordsEdit1.setID(executionId);
                System.out.println("testID:   "+jsonObject3.get("id"));
            //use server output getResponseString as string value.
            }
            
            
            System.err.println(con1.getResponseCode());
            
            

		//PUT Request zur Erstellten Zephypr Testausführung mit Update des Status
        String uri2=("http://localhost:2990/jira/rest/zapi/latest/execution/"+executionId+"/execute");	
        System.out.println("Nach dem Test 1");
		
        // Teststatus (1 Bestanden, 2 Nicht Bestanden, 3 In Arbeit
        // ,"comment":""
        statusId= Common.testExecuter(sentence);
        if (statusId =="1") {
         comment = "Test bestanden";
        }else if (statusId =="2"){
        	comment = "Test nicht bestanden";
        } else {
        	comment = "Test noch in Bearbeitung";
        }
      //  String log= keywordsEdit1.verify();

		String data1 = ("{\"status\": \""+statusId+"\",\"comment\":\""+comment +"\"}");
		
		
		URL url2 = new URL(uri2);
		
		System.out.println(url2);

        HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();

        con2.setRequestMethod("PUT");

		con2.setRequestProperty("Authorization", "Basic "+new String(bytesEncoded));
        
        con2.setDoOutput(true);
        con2.setRequestProperty("Content-Type", "application/json");
        con2.setRequestProperty("Accept", "application/json");

        //String contentType = con1.getHeaderField("Content-Type");

        OutputStreamWriter osw1 = new OutputStreamWriter(con2.getOutputStream());
        osw1.write(data1);
        osw1.flush();
        osw1.close();
        
        System.err.println(con2.getResponseCode());
        
        System.out.println(data1);
      
		}
		
		// Log bearbeiten
		File source = new File("C:/Users/case/Desktop/HR2020/Logs_Screenshots/TestLogsID.txt");
		File dest = new File("C:/Users/case/Desktop/HR2020/Logs_Screenshots/TestLogsID"+executionId+".txt");
		try {
		    FileUtils.copyFile(source, dest);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		//Screenshots bearbeiten
		Path quelleFiles =null;
    	File cache = new File("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot");// your destination
    	File[] listOfFiles = cache.listFiles();
    	Path ziel = Paths.get("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots"); 
    	for (int i = 0; i < listOfFiles.length; i++) {
    	 
    		if (listOfFiles[i].isFile()) {
    			quelleFiles = Paths.get("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\"+ listOfFiles[i].getName().replaceAll("[^A-Za-z0-9][.][\\s+]",""));
    			System.out.println("ScreenShot: "+quelleFiles.toString());
    		
    			Path fileTemp = Files.move(quelleFiles, quelleFiles.resolveSibling(i+"Error"+executionId+".jpg"));
    			Files.move(fileTemp, ziel.resolve(fileTemp.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    		}
    	}
    	
    	for (int i = -1; i < listOfFiles.length; i++)
    	{
    		File textFile;
    		if(i==-1)
    		{
    			textFile = new File("C:/Users/case/Desktop/HR2020/Logs_Screenshots/TestLogsID"+executionId+".txt");
    		}
    		else {
    			textFile = new File("C:/Users/case/Desktop/HR2020/Logs_Screenshots/"+i+"Error"+executionId+".jpg");
    		}
       String uri3=("http://localhost:2990/jira/rest/zapi/latest/attachment?entityId="+executionId+"&entityType=execution");
       URL url3 = new URL(uri3);
       String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
       
       
    
       String charset = "UTF-8";
       String CRLF = "\r\n"; // Line separator required by multipart/form-data.


		System.out.println(url3);
		HttpURLConnection con3 = (HttpURLConnection) url3.openConnection();
		
		con3.setRequestMethod("POST");

       con3.setRequestProperty("Authorization", "Basic "+new String(bytesEncoded));
       
       con3.setDoOutput(true);
       con3.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
       
       try (
       	    OutputStream output = con3.getOutputStream();
       	    PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
       ) {
         
           
       	// Send text file.
           writer.append("--" + boundary).append(CRLF);
           writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + textFile.getName() + "\"").append(CRLF);
           if(i==-1)
           {
           writer.append("Content-Type: text/plain; charset=" + charset).append(CRLF); // Text file itself must be saved in this charset!
           }
           else {
        	   writer.append("Content-Type: image/jpeg").append(CRLF); 
           }
           writer.append(CRLF).flush();
           Files.copy(textFile.toPath(), output);
           output.flush(); // Important before continuing with writer!
           writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.
           
        
           
        // End of multipart/form-data.
           writer.append("--" + boundary + "--").append(CRLF).flush();
       }

       // Request is lazily fired whenever you need to obtain information about response.
       int responseCode = ((HttpURLConnection) con3).getResponseCode();
       System.out.println(responseCode); // Should be 200
    	}
	}	
}
