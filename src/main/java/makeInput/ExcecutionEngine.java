package makeInput;
import makeInput.Constans;
import makeInput.KeywordsEditor;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import com.google.common.net.HttpHeaders;

import makeInput.Common;

public class ExcecutionEngine {
	
	static KeywordsEditor keywordsEdit;
	
//	@BeforeClass
//	public static void preperation() {
//		
//	} 
//	
//	// keywordsEdit.keywordsHandling(Constans.pathProbe)
//	
//	@Test		
//    public void testJUnitMessage() {					
//
//        System.out.println("Junit Message is printing");									
//
//    }	    private static String getDefaultCharSet() {

    private static String getDefaultCharSet() {

        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());

        String enc = writer.getEncoding();

        return enc;

    }
	public static void main(String[] args) throws Exception {
        System.out.println("Default Charset=" + Charset.defaultCharset());

        System.setProperty("file.encoding", "Latin-1");

        System.out.println("file.encoding=" + System.getProperty("file.encoding"));

        System.out.println("Default Charset=" + Charset.defaultCharset());

        System.out.println("Default Charset in Use=" + getDefaultCharSet());
		//args[0]= "bach";

		// Selenium:
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\Drivers\\chromedriver.exe");
	//	keywordsEdit = new KeywordsEdit();
		keywordsEdit = new KeywordsEditor();
		
		for (int i = 0; i < args.length; i++) {
    		System.out.println("eingebe war: " +args[i]);
    		URL url = new URL("http://jira.ppi.int/jira/rest/api/latest/issue/"+args[i]);
    		
    		System.out.println(url);

            String encoding = "YWRtaW4gOiBhZG1pbg==";//Base64Encoder.encode("admin" + ":" + "admin");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            con.setRequestProperty(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

           

            String contentType = con.getHeaderField("Content-Type");

            int status = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream())); //Writer out = new OutputStreamWriter(new FileOutputStream(yourFile), "windows-1252");

            String inputLine;

            StringBuffer content = new StringBuffer();
            

            while ((inputLine = in.readLine()) != null) {

                content.append(inputLine);

            }

            in.close();

            con.disconnect();
           System.out.println(content.toString());
		}	

		for(int n=1; n<2; n++) {
			
			Common.openUrl(Constans.urlHenrik);
			
			if(n==1) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.url);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall1);
			//	keywordsEdit.keywordsHandling(Constans.pathTabelleProbe); 
				keywordsEdit.keywordsHandling(Constans.pathEncodingCHCP1252); 
				
				
//				keywordsEdit.keywordsHandling(Constans.pathTextfeld1);
//				keywordsEdit.keywordsHandling(Constans.pathTabelle4);
//				keywordsEdit.keywordsHandling(Constans.pathTabelle3);
//				keywordsEdit.keywordsHandling(Constans.pathTabelle2);
//				keywordsEdit.keywordsHandling(Constans.pathTabelle1);
//				keywordsEdit.keywordsHandling(Constans.pathRadiobutton1);
//				keywordsEdit.keywordsHandling(Constans.pathCheckbox1);
//				keywordsEdit.keywordsHandling(Constans.pathPasswortfeld1);
//				keywordsEdit.keywordsHandling(Constans.pathDropdown1);
//				keywordsEdit.keywordsHandling(Constans.pathDropdown2);
//				keywordsEdit.keywordsHandling(Constans.pathKombobox1);
//				keywordsEdit.keywordsHandling(Constans.pathScrollbar1);
//				keywordsEdit.keywordsHandling(Constans.pathLink1);
//				keywordsEdit.keywordsHandling(Constans.pathLink2);
			
			}
			if(n==2) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlAdditionTable);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall2);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall2_1);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall2_2);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall2_3);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall2_4);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall2_5);
				keywordsEdit.keywordsHandling(Constans.pathProbe);
				
			}
			if(n==3) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlRadioButtonCheckBox);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall3);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall3_1);
				
			}
			if(n==4) {
				System.out.println("Testfall 4: Muss noch abstimmen und weiter machen!");
				
			}
			if(n==5) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlAdditionTable);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall5);
				
			}
			if(n==6) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlBootstrapDropDown);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall6);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall6_2);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall6_3);
				//keywordsEdit.keywordsHandling(Constans.pathProbe);
			}
			if(n==7) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlBootstrapDropDown);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall7);
				//keywordsEdit.keywordsHandling(Constans.pathProbe);
			}
			if(n==8) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlPPIAG);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall8_1);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall8_2);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall8_3);
			}
			if(n==9) {
				System.out.println("_______________ Testfall"+n+"_________________");
				//Common.openUrl(Constans.urlBootstrapDropDown);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall9_1);
				//keywordsEdit.keywordsHandling(Constans.pathTestfall9_2);
				
			}
				
		}

	}

}
