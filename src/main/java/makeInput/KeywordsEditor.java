package makeInput;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Verifier;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import java.util.logging.FileHandler;

import junit.framework.Assert;

public class KeywordsEditor {
	static String ID;
	static Logger logger;
	static Handler file_handler;
	static Formatter klartext;

	
	public  List<String> errorLog = new ArrayList<String>();
	public  List<String> errorLog1;

	 
    /**
     * Verifier is a base class for Rules like ErrorCollector, which can turn
     * otherwise passing test methods into failing tests if a verification check is
     * failed
     */
   public KeywordsEditor() throws IOException {
	 //  forLog = new Common();
	  logger=Logger.getLogger("KeywordsEditor");
	   // logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	   LogManager.getLogManager().readConfiguration(new FileInputStream("U:\\git\\KeywordDriverTestingHR2020\\src\\main\\java\\Log4jDB\\loggingAPI.properties"));
	   FileHandler fh = new FileHandler("C:/Users/case/Desktop/HR2020/Logs_Screenshots/TestLogsID.txt");
	   logger.addHandler(fh);
   }
//    public Verifier verifier = new Verifier() {
//        // After each method perform this check
//      //  @Override
//        public String verify() {
//        	String out="";
//            assertTrue("Error Log is not Empty!", errorLog.isEmpty());
//            System.out.println("heeer");
//            for (int i=0; i<errorLog.size();i++) {
//            	out = out+ ","+errorLog.get(i);
//            }
//            return out;
//        }
   
   public void setID(String Id) {
	 KeywordsEditor.ID = Id;
	 System.out.println("ID is: "+KeywordsEditor.ID);
 }
	@Test
	public String keywordsHandling(String scenarioPath) throws Exception {
		
		String[] SENTENCES;
		String values;
		int prf = 0;
		//String fieldRowCol;
		String EckigKlammernElemente;
		String EckigKlammernTexts;
		errorLog1 = new ArrayList<String>();
		String statusID = null;

		// find out the Sentences from texts
		//SENTENCES = Common.SentencesDef(scenarioPath);
		SENTENCES = Common.SentencesDefFromJira(scenarioPath);
		System.out.println("---------------------------------------");
		System.out.println("Sätze sind: " + Arrays.toString(SENTENCES));
		System.out.println("---------------------------------------");

		for (int i = 0; i < SENTENCES.length; i++) {
			
						EckigKlammernElemente = Common.getStringBetweenTwoChars(SENTENCES[i],"[", "]");
						EckigKlammernTexts = Common.getStringBetweenTwoChars(EckigKlammernElemente,"\"", "\"" );
						System.out.println("--------");
						System.out.println("EckigKlammern: "+EckigKlammernTexts.replace("%Space&", ","));
						SENTENCES[i] = SENTENCES[i].replace(EckigKlammernElemente, "");				

						// find out Value in Quotes and Parentheses:
						values = Common.getStringBetweenTwoChars(SENTENCES[i],"\"", "\"");
						System.out.println("FazitText: " + values.replace("%Space&", ","));
						String[] quoteText = values.split("%Space&");
						logger.info("[INFO]: Bearbeitung Satz: " +SENTENCES[i]);
/**WENN**/
//Textfeld		
		//Textfeld Eingabefeld1 = new Textfeld(Constans.name1, Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
		//Textfeld/Linksklick				
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1")) && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.buttonClicker(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
			logger.info("Textfeld/Linksklick erfolgreich!");
		}
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld2")||SENTENCES[i].contains("eingabefeld2")) && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.buttonClicker(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
			logger.info("Textfeld/Linksklick erfolgreich!");
		}
		//Textfeld/eingebe
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1")) && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			prf +=1;
			String quoteText2 = quoteText[1].toString();
			Common.InputValueInField(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address, quoteText2);
			logger.info("Textfeldseingabe erfolgreich!");
		}
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld2")||SENTENCES[i].contains("eingabefeld2")) && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {			
			prf +=1;
			String quoteText2 = quoteText[1].toString();
			Common.InputValueInField(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address, quoteText2);
			logger.info("Textfeldseingabe erfolgreich!");
		}
		//Textfeld/Rechtsklick
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1")) && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.rightClicker(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
			logger.info("Textfeld/Rechtsklick erfolgreich!");
		}
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld2")||SENTENCES[i].contains("eingabefeld2")) && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.rightClicker(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
			logger.info("Textfeld/Rechtsklick erfolgreich!");
		}
		//Textfeld/markiere
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1")) && SENTENCES[i].contains("markiere")) {
			prf +=1;
			Common.highLighterMethod(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
			logger.info("Textfeld/markiere erfolgreich!");
		}
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld2")||SENTENCES[i].contains("eingabefeld2")) && SENTENCES[i].contains("markiere")) {
			prf +=1;
			Common.highLighterMethod(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
			logger.info("Textfeld/markiere erfolgreich!");
		}
		//Textfeld/überfahre
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1")) && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			prf +=1;
			Common.mouseOverElement(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
			logger.info("Textfeld/überfahre erfolgreich!");
		}
		if(SENTENCES[i].contains("Textfeld") && (SENTENCES[i].contains("Eingabefeld2")||SENTENCES[i].contains("eingabefeld2")) && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			prf +=1;
			Common.mouseOverElement(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
			logger.info("Textfeld/überfahre erfolgreich!");
		}
		
//Passwortfeld
		//Passwortfeld/Linksklick
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.buttonClicker(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
			logger.info("Passwortfeld/Linksklick erfolgreich!");
		}
		// Passwortfeld/Rechtsklick
		if (SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.rightClicker(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
			logger.info("Passwortfeld/Rechtsklick erfolgreich!");
		}
		// Passwortfeld/markieren
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("markiere")) {
			prf +=1;
			Common.highLighterMethod(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
			logger.info("Passwortfeld/markieren erfolgreich!");
		}
		//Passwortfeld/Wert/eingeben
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {	
			prf +=1;
			String quoteText2 = quoteText[1].toString();
			Common.InputValueInField(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address, quoteText2);
			logger.info("Passwortfeld/Wert/eingeben erfolgreich!");
		}
		//Passwortfeld/überfahren
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			prf +=1;
			Common.mouseOverElement(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
			logger.info("Passwortfeld/überfahren erfolgreich!");
		}
				
//Schaltfläche
		//Schaltfläche/Login/Linksklick
		if(SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				prf +=1;
				Common.buttonClicker(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
				logger.info("Schaltfläche/Linksklick erfolgreich!");
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				prf +=1;
				Common.buttonClicker(Constans.Schalflaeche2_AddressTyp,Constans.Schalflaeche2_Address);
				logger.info("Schaltfläche/Linksklick erfolgreich!");
			}
		}
		// Schaltfläche/Doppelklick
		if (SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("Doppelklick") && SENTENCES[i].contains("auswähle")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				prf +=1;
				Common.duppleClicker(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
				logger.info("Schaltfläche/Doppelklick erfolgreich!");
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				prf +=1;
				Common.duppleClicker(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
				logger.info("Schaltfläche/Doppelklick erfolgreich!");
			}
		}
		// Schaltfläche/Rechtsklick
		if (SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				prf +=1;
				Common.rightClicker(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
				logger.info("Schaltfläche/Rechtsklick erfolgreich!");
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				prf +=1;
				Common.rightClicker(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
				logger.info("Schaltfläche/Rechtsklick erfolgreich!");
			}
		}
		// Schaltfläche/überfahren
		if (SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				prf +=1;
				Common.mouseOverElement(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
				logger.info("Schaltfläche/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				prf +=1;
				Common.mouseOverElement(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
				logger.info("Schaltfläche/überfahren erfolgreich!");
			}
		}
		
//Checkbox-Radiobutton
		//Checkbox/anwähle
		if((SENTENCES[i].contains("WENN")||SENTENCES[i].contains("UND")) && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("anwähle")) {
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")) {
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address) == false) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
				logger.info("Checkbox/anwähle erfolgreich!");}else {
					logger.warning("Checkbox bereits angewählt");
				}
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")) {	
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
					logger.info("Checkbox/anwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")) {	
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
					logger.info("Checkbox/anwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas"))	{
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
					logger.info("Checkbox/anwähle erfolgreich!");}
			}	
		}
		//Radiobutton/anwähle
		if((SENTENCES[i].contains("WENN")||SENTENCES[i].contains("UND")) && SENTENCES[i].contains("Radiobutton")&& SENTENCES[i].contains("anwähle")) {
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")) {
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address) == false) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
				logger.info("Radiobutton/anwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")) {
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
					logger.info("Radiobutton/anwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")) {
				prf +=1;
				if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
					logger.info("Radiobutton/anwähle erfolgreich!");}
			}
		}
		//Checkbox/abwähle
		if((SENTENCES[i].contains("WENN")||SENTENCES[i].contains("UND")) && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("abwähle")) {
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
				logger.info("Checkbox/abwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
				logger.info("Checkbox/abwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
				logger.info("Checkbox/abwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
				logger.info("Checkbox/abwähle erfolgreich!");}
			}
		}
		//Radiobutton/abwähle
		if((SENTENCES[i].contains("WENN")||SENTENCES[i].contains("UND")) && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("abwähle")) {
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
				logger.info("Radiobutton/abwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
				logger.info("Radiobutton/abwähle erfolgreich!");}
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")) {
				prf +=1;
			if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
				logger.info("Radiobutton/abwähle erfolgreich!");}
			}
		}
		// Checkbox/überfahren
		if ((SENTENCES[i].contains("WENN")||SENTENCES[i].contains("UND")) && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.mouseOverElement(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);	
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")){
				prf +=1;
				Common.mouseOverElement(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);	
				logger.info("Checkbox/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")){
				prf +=1;
				Common.mouseOverElement(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);	
				logger.info("Checkbox/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")){
				prf +=1;
				Common.mouseOverElement(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
				logger.info("Checkbox/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")){
				prf +=1;
				Common.mouseOverElement(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
				logger.info("Checkbox/überfahren erfolgreich!");
			}
		}
		
		// Radiobutton/überfahren
		if ((SENTENCES[i].contains("WENN")||SENTENCES[i].contains("UND")) && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")){
				prf +=1;
				Common.mouseOverElement(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
				logger.info("Radiobutton/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")){
				prf +=1;
				Common.mouseOverElement(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
				logger.info("Radiobutton/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")){
				prf +=1;
				Common.mouseOverElement(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
				logger.info("Radiobutton/überfahren erfolgreich!");
			}
		}
		
//Tabelle1
		//Tabelle/Zeile/Spalte/Linksklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.leftClickTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			logger.info("Linksklick/auswähle erfolgreich!");
		}
		//Tabelle/Zeile/Spalte/Duppelklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Doppelklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.duppleClickTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			logger.info("Duppelklick/auswähle erfolgreich!");
		}
		//Tabelle/Zeile/Spalte/Rechtsklick/auswähle
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.rightClickTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			logger.info("Rechtsklick/auswähle erfolgreich!");
		}
		// Tabelle/Zeile/Spalte/Wert/eingebe
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			prf +=1;
			Common.inputTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], quoteText[3], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			logger.info("Wert/eingebe erfolgreich!");
		}
		// Tabelle/Zeile/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt, eckKlmText );	
			logger.info("Liste/eingebe erfolgreich!");
		}
		// Tabelle/Spalte/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleSpalteListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt, eckKlmText );
			logger.info("Liste/eingebe erfolgreich!");
		}
		// Tabelle/Zeile/Spalte/Wert/markiere
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("markiere")) {
			prf +=1;
			Common.valueCellMarker(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2],Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			logger.info("Wert/markiere erfolgreich!");
		}
		// Tabelle/Zeile/Spalte/überfahren
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")){
			prf +=1;
			Common.mouseOverTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			logger.info("Zeile/Spalte/überfahren erfolgreich!");
		}	
		
//Tabelle2
		//Tabelle/Zeile/Spalte/Linksklick/auswähle
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.leftClickTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			logger.info("Linksklick/auswähle erfolgreich!");
		}
		//Tabelle/Zeile/Spalte/Duppelklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Doppelklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.duppleClickTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			logger.info("Duppelklick/auswähle erfolgreich!");
		}
		//Tabelle/Zeile/Spalte/Rechtsklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.rightClickTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			logger.info("Rechtsklick/auswähle erfolgreich!");
		}
		// Tabelle/Zeile/Spalte/Wert/eingebe
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			prf +=1;
			Common.inputTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], quoteText[3], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			logger.info("Wert/eingebe erfolgreich!");
		}
		// Tabelle/Zeile/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleZeileListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt, eckKlmText );
			logger.info("Liste/eingebe erfolgreich!");
		}
		// Tabelle/Spalte/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleSpalteListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table2_ColumnstagNameInhalt, eckKlmText );
			logger.info("Liste/eingebe erfolgreich!");
		}
		// Tabelle/Zeile/Spalte/Wert/markiere
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("markiere")) {
			prf +=1;
			Common.valueCellMarker(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2],Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			logger.info("Wert/markiere erfolgreich!");
		}
		// Tabelle/Zeile/Spalte/überfahren
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")){
			prf +=1;
			Common.mouseOverTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			logger.info("Zeile/Spalte/überfahren erfolgreich!");
		}
		
//Dropdownliste
		//Dropdown/Feld/Linksklick/auswähle
		if (SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("Feld mit dem Namen") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			System.out.println(quoteText[1]);
			if(SENTENCES[i].contains("dropdown1")) {
				prf +=1;
				Common.botstrapDropDown(Constans.DropDown1_AddressTyp, Constans.DropDown1_Address, Constans.DropDown1_MenuAddressTyp, Constans.DropDown1_MenuAddress, quoteText[1]);
				logger.info("Dropdown Linksklick/auswähle erfolgreich!");
			}
			if(SENTENCES[i].contains("dropdown2")) {
				prf +=1;
				Common.botstrapDropDown(Constans.DropDown2_AddressTyp, Constans.DropDown2_Address, Constans.DropDown2_MenuAddressTyp, Constans.DropDown2_MenuAddress, quoteText[1]);
				logger.info("Dropdown Linksklick/auswähle erfolgreich!");
			}
		}
		//Dropdown/Feld/überfahren
		if (SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			if(SENTENCES[i].contains("dropdown1")) {
				prf +=1;
				Common.MouseOverBotstrapDropDown(Constans.DropDown1_AddressTyp, Constans.DropDown1_Address);
				logger.info("Dropdown Feld/überfahren erfolgreich!");
			}
			if(SENTENCES[i].contains("dropdown2")) {
				prf +=1;
				Common.MouseOverBotstrapDropDown(Constans.DropDown2_AddressTyp, Constans.DropDown2_Address);
				logger.info("Dropdown Feld/überfahren erfolgreich!");
			}
		}
		
//Scrollbar
		if (SENTENCES[i].contains("Scrollbar") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("scrolle")) {
			prf +=1;
			Common.scrollToElement(quoteText[1]);
			logger.info("Scrollbar scroll to Element erfolgreich!");
		}
		
//Link
		//Link/Linksklick/auswähle
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.scrollElementToMiddle(quoteText[0]);
			Common.Locator("textName", quoteText[0]).click();
			Thread.sleep(4000);
			logger.info("Link Linksklick/auswähle erfolgreich!");
		}
		//Link/Rechtsklick/auswähle
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.scrollElementToMiddle(quoteText[0]);
			Common.rightClicker("textName", quoteText[0]);
			logger.info("Link Rechtsklick/auswähle erfolgreich!");
		}
		//Link/markiere
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("markiere")) {
			prf +=1;
			Common.scrollElementToMiddle(quoteText[0]);
			Common.highLighterMethod("textName", quoteText[0]);
			logger.info("Link markiere erfolgreich!");
		}
		//Link/überfahre
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			prf +=1;
			Common.scrollElementToMiddle(quoteText[0]);
			Common.mouseOverElement("textName", quoteText[0]);
			logger.info("Link überfahre erfolgreich!");
		}
		
//Kombobox
		//Kombobox/Wert/eingebe
		if  (SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			prf +=1;
			Common.ComboboxInput(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address, quoteText[1]);
			logger.info("Kombobox/Wert/eingebe erfolgreich!");
		}
		//Kombobox/Liste durch die Eingabe des Wertes/Wertnummer/Linksklick/auswähle
		if  (SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("das Feld mit dem Namen") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			prf +=1;
			Common.searchAndClick(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address, quoteText[1]);	
			logger.info("Kombobox/Liste durch die Eingabe des Wertes/Wertnummer/Linksklick/auswähle erfolgreich");
		}
		//Kombobox/überfahre
		if  (SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			prf +=1;
			Common.mouseOverCombobox(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address);
			logger.info("Kombobox/überfahre erfolgreich!");
		}
		

		
/**DANN**/
		
//Textfeld und Ausgabefeld		
		//Textfeld/Text/angezeigt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && (SENTENCES[i].contains("Text") || SENTENCES[i].contains("Wert"))
				&& !(SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert =")) && !(SENTENCES[i].contains("Tabelle"))&& !(SENTENCES[i].contains("Dropdownliste"))
				&& !(SENTENCES[i].contains("der Link")) && !(SENTENCES[i].contains("Kombobox"))){
			Thread.sleep(2000);
			if(SENTENCES[i].contains("Textfeld")  && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1"))) {
				prf +=1;
				String quoteText2 = quoteText[1].toString();
				String outputText_Istwert = Common.getTextByElement(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
				System.out.println("textfeld1: "+outputText_Istwert);
				if(outputText_Istwert.equals("")||outputText_Istwert.equals(null))
				outputText_Istwert = Common.htmlTextGetterHR("eingabefeld1");
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
				if(outputText_Istwert.equals(quoteText2)) {
					logger.info(quoteText2 + " wird angezeigt");
				} else {
					logger.warning(quoteText2 + " wird NICHT angezeigt");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\"+quoteText2+"NICHTangezeigt.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if(SENTENCES[i].contains("Ausgabefeld") && (SENTENCES[i].contains("Ausgabefeld1")||SENTENCES[i].contains("ausgabefeld1"))) {
				prf +=1;
				String quoteText2 = quoteText[1].toString();
				String outputText_Istwert = Common.getTextByElement(Constans.Ausgabefeld1_AddressTyp, Constans.Ausgabefeld1_Address);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
				if (outputText_Istwert.equals(quoteText2)) {
					logger.info(outputText_Istwert+ " wird angezeigt");
				} else {
					logger.warning(outputText_Istwert + " NICHT angezeigt");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\"+quoteText2+"NICHTangezeigt.jpg");			
					errorLog1.add("ERROR");					
				}
				}
		}
		//Textfeld/Wert2 ><= Wert1 angezeigt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && SENTENCES[i].contains("Wert") && !SENTENCES[i].contains("Tabelle")
				&& (SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))) {
			String wert1String = null;
			Thread.sleep(3000);
			float wert2 = Float.parseFloat(quoteText[1]);
			if(SENTENCES[i].contains("Textfeld")  && (SENTENCES[i].contains("Eingabefeld1")||SENTENCES[i].contains("eingabefeld1"))) {
				prf +=1;
				wert1String = Common.getTextByElement(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
			}
			if(SENTENCES[i].contains("Ausgabefeld") && (SENTENCES[i].contains("Ausgabefeld1")||SENTENCES[i].contains("ausgabefeld1"))) {
				prf +=1;
				wert1String = Common.getTextByElement(Constans.Ausgabefeld1_AddressTyp, Constans.Ausgabefeld1_Address);
			}
			if(wert1String != null) {
			float wert1 = Float.parseFloat(wert1String);

			if(SENTENCES[i].contains("Wert >")){
				prf +=1;
				System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
				System.out.println(wert1 > wert2);
				if(wert1 > wert2) {
					logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
				} else {
					logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1FALSE"+wert1+"GROSS"+wert2+".jpg");			
					errorLog1.add("ERROR");
				}
			}
			if(SENTENCES[i].contains("Wert <")){
				prf +=1;
				System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
				System.out.println(wert1 < wert2);
				if(wert1 < wert2) {
					logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
				} else {
					logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1FALSE"+wert1+"KLEIN"+wert2+".jpg");			
					errorLog1.add("ERROR");
				}
			}
			if(SENTENCES[i].contains("Wert =")){
				prf +=1;
				System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
				System.out.println(wert1 == wert2);
				if(wert1 == wert2) {
					logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
				} else {
					logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1FALSE"+wert1+"GLEICH"+wert2+".jpg");			
					errorLog1.add("ERROR");
				}
			}
			} else {
				logger.info("OutputWert nicht vergleichbar");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\OutputNOTfound.jpg");			
				errorLog1.add("ERROR");	
			}
		}
		
//Passwortfeld
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("angezeigt")) {
			prf +=1;
			Thread.sleep(3000);
			String quoteText2 = quoteText[1].toString();
			String outputText_Istwert = Common.getTextByElement(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
			System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
			if (outputText_Istwert.equals(quoteText2)) {
				logger.info(outputText_Istwert+ " wird angezeigt");
			} else {
				logger.warning(outputText_Istwert + " NICHT angezeigt");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\"+quoteText2+"NICHTangezeigt.jpg");			
				errorLog1.add("ERROR");
				
			}
		}
		
//Schaltfläche
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Schaltfäche") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("angezeigt")) {
			Thread.sleep(3000);
			String quoteText2 = quoteText[1].toString();
			if(SENTENCES[i].contains("schaltfläche1")||SENTENCES[i].contains("Schaltfläche1")) {
				prf +=1;
				String outputText_Istwert = Common.getTextByElement(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
				if(outputText_Istwert.equals(quoteText2)) {
					logger.info(outputText_Istwert+ " wird angezeigt");
				}else {
					logger.warning(outputText_Istwert + " NICHT angezeigt");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\"+quoteText2+"NICHTangezeigt.jpg");			
					errorLog1.add("ERROR");	
				}
			}
			if(SENTENCES[i].contains("schaltfläche2")||SENTENCES[i].contains("Schaltfläche2")) {
				prf +=1;
				String outputText_Istwert = Common.getTextByElement(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
				if(outputText_Istwert.equals(quoteText2)) {
					logger.info(outputText_Istwert+ " wird angezeigt");
				}else {
					logger.warning(outputText_Istwert + " NICHT angezeigt");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\"+quoteText2+"NICHTangezeigt.jpg");			
					errorLog1.add("ERROR");	
				}
			} 
		}
	
//Checkbox-Radiobutton
		//Radiobutton/angewählt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("angewählt")) {
			boolean status=false;
			String quoteText1 = quoteText[0].toString();
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
			}
			if(status == true) {
				//System.out.println("Radiobutton "+quoteText1+" aktuell angewählt");
				logger.info("Radiobutton "+quoteText1+" aktuell angewählt");
			} else if(status == false) {
				logger.warning("Radiobutton "+quoteText1+" aktuell NICHT angewählt");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\RadiobuttonNICHTangewaehlt.jpg");			
				errorLog1.add("ERROR");
				
			}
		}
		// Radiobutton/abgewählt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("abgewählt")) {
			String quoteText1 = quoteText[0].toString();
			boolean status=true;
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
			}
			if (status == true) {
				logger.warning("Radiobutton "+quoteText1+" aktuell NICHT abgewählt");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\RadiobuttonNICHTAbgewaehlt.jpg");
				errorLog1.add("ERROR");
			} else if (status == false) {
				logger.info("Radiobutton "+quoteText1+" aktuell abgewählt");
				
			}
		}
		//Checkbox/angewählt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("angewählt")) {
			boolean status = false;
			String quoteText1 = quoteText[0].toString();
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}
			if(status == true) {
				//System.out.println("Checkbox "+quoteText1+" aktuell angewählt");
				logger.info("Checkbox "+quoteText1+" aktuell angewählt");
			} else if(status == false) {
				logger.warning("Checkbox "+quoteText1+" aktuell NICHT angewählt");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\CheckboxNICHTangewaehlt.jpg");
				errorLog1.add("ERROR");
			}
		}
		// Checkbox/abgewählt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("abgewählt")) {
			String quoteText1 = quoteText[0].toString();
			boolean status = true;
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")) {
				prf +=1;
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}
			if (status == true) {
				logger.warning("Checkbox "+quoteText1+" aktuell NICHT abgewählt");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\CheckboxNICHTAbgewaehlt.jpg");
				errorLog1.add("ERROR");
			} else if (status == false) {
				logger.info("Checkbox "+quoteText1+" aktuell abgewählt");
				
			}
		}
		
//Tabelle1
		//Tabelle/Zeile/Spalte/Text/angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Text") && SENTENCES[i].contains("angezeigt") 
				&& !(SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))){
			String outputText=null;
			if(SENTENCES[i].contains("tabelle1")) {
				prf +=1;
				outputText = Common.htmlTextGetter(Common.IDTabelle1(quoteText[1], quoteText[2]));
				System.out.println("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
				if(outputText.equals(quoteText[3])) {
					logger.info("Tabelle1 [row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : is " + outputText.equals(quoteText[3]));
				}else {
					logger.warning("Tabelle1 [row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : is " + outputText.equals(quoteText[3]));
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\TextNichtAngezeigt.jpg");
					errorLog1.add("ERROR");
				}
			}
			if(!SENTENCES[i].contains("tabelle1") && !SENTENCES[i].contains("tabelle2")) {
				prf +=1;
				outputText =  Common.searchTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt).getText();
				Thread.sleep(2000);
				System.out.println("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
				if(outputText.equals(quoteText[3])) {
					logger.info("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : is " + outputText.equals(quoteText[3]));
				}else {
					logger.warning("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : is " + outputText.equals(quoteText[3]));
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1TextNichtAngezeigt.jpg");
					errorLog1.add("ERROR");
				}
			}			
		}
		// Tabelle/Zeile/Spalte/Wert2 ><= Wert1 angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && SENTENCES[i].contains("Wert")
				&& SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && (SENTENCES[i].contains("Wert >")
						|| SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))) {
			String cellText = Common.searchTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt).getText();
			float wert2 = Float.parseFloat(quoteText[3]);
			if (cellText.equals("") || cellText.equals(null)) {
				String cell = Common.IDTabelle1(quoteText[1], quoteText[2]);
				cellText = Common.htmlTextGetter(cell);
				float wert1 = Float.parseFloat(cellText);
				if (SENTENCES[i].contains("Wert >")) {
					prf +=1;
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
					if(wert1 > wert2) {
						logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2FALSE"+wert1+"GROSS"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Wert <")) {
					prf +=1;
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
					if(wert1 < wert2) {
						logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2FALSE"+wert1+"KLEIN"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Wert =")) {
					prf +=1;
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
					if(wert1 == wert2) {
						logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1FALSE"+wert1+"GLEICH"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}

			} else {
				float wert1 = Float.parseFloat(cellText);
				if (SENTENCES[i].contains("Wert >")) {
					prf +=1;
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
					if(wert1 > wert2) {
						logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2FALSE"+wert1+"GROSS"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Wert <")) {
					prf +=1;
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
					if(wert1 < wert2) {
						logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2FALSE"+wert1+"KLEIN"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Wert =")) {
					prf +=1;
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
					if(wert1 == wert2) {
						logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2FALSE"+wert1+"GLEICH"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
			}
		}
		//Tabelle/Zeile/Wert/zu finden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("zu finden")
				&& !SENTENCES[i].contains("Spalte")) {
			prf +=1;
			int count = 0;
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address,quoteText[1], Constans.Table1_ColumnstagNameInhalt);
			Label1: for (int k = 0; k < rowElements.size(); k++) {
				String outputText = rowElements.get(k).getText();
				if (outputText.equals("") || outputText.equals(null)) {
					String[] row = Common.IDTabelle1Row(quoteText[1]);
					for (int j = 0; j < row.length; j++) {
						outputText = Common.htmlTextGetter(row[j]);
						if (outputText.equals(quoteText[2])) {
							logger.info("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> gefunden!");
							count += 1;
							break;
						}
					}
					if (count == 0) {
						logger.warning("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> NICHT gefunden!");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\ZeileWertNOTfound.jpg");			
						errorLog1.add("ERROR");
					}
					break Label1;
				}
				if (rowElements.get(k).getText().equals(quoteText[2])) {
					logger.info("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> gefunden!");
				} else {
					logger.warning("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> NICHT gefunden!");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1ZeileWertNOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		
		//Tabelle/Spalte/Wert/zu finden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Wert")
				&& SENTENCES[i].contains("zu finden") && !SENTENCES[i].contains("Zeile")) {
			prf +=1;
			int count = 0;
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table1_AddressTyp,Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName,Constans.Table1_ColumnstagNameInhalt);
			Label1: for (int k = 0; k < colElements.size(); k++) {
				String outputText = colElements.get(k).getText();
				if (outputText.equals("") || outputText.equals(null)) {
					String[] cols = Common.IDTabelle1Cell(quoteText[1]);
					for (int j = 0; j < cols.length; j++) {
						outputText = Common.htmlTextGetter(cols[j]);
						if (outputText.equals(quoteText[2])) {
							logger.info("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> gefunden!");
							count += 1;
							break;
						}
					}
					if (count == 0) {
						logger.warning("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> NICHT gefunden!");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\SpalteWertNOTfound.jpg");			
						errorLog1.add("ERROR");
					}
					break Label1;
				}
				if (colElements.get(k).getText().equals(quoteText[2])) {
					logger.info("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> gefunden!");
				} else {
					logger.warning("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> NICHT gefunden!");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1SpalteWertNOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		
		// Tabelle/Zeile/alle Werte ><= Wert1 angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Zeile") && !SENTENCES[i].contains("Spalte")
				&& SENTENCES[i].contains("alle Werte") && SENTENCES[i].contains("angezeigt werden")
				&& (SENTENCES[i].contains("Werte >") || SENTENCES[i].contains("Werte <")|| SENTENCES[i].contains("Werte ="))) {		
			String textWert1 = null;
			float wert2 = Float.parseFloat(quoteText[2]);
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt);
			for (int k = 1; k < rowElements.size(); k++) {
				textWert1 = rowElements.get(k).getText();
			
			if (textWert1.equals("") || textWert1.equals(null)) {
				String[] cells = Common.IDTabelle1Row(quoteText[1]);
				for (int n = 0; n < cells.length; n++) {
					textWert1 = Common.htmlTextGetter(cells[n]);
					float wert1 = Float.parseFloat(textWert1);
					if (SENTENCES[i].contains("Werte >")) {
						prf +=1;
						System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
						System.out.println(wert1 > wert2);
						if(wert1 > wert2) {
							logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
						} else {
							logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
							Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\3FALSE"+wert1+"GROSS"+wert2+".jpg");			
							errorLog1.add("ERROR");
						}
						
					}
					if (SENTENCES[i].contains("Werte <")) {
						prf +=1;
						System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
						System.out.println(wert1 < wert2);
						if(wert1 < wert2) {
							logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
						} else {
							logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
							Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\3FALSE"+wert1+"KLEIN"+wert2+".jpg");			
							errorLog1.add("ERROR");
						}
					}
					if (SENTENCES[i].contains("Werte =")) {
						prf +=1;
						System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
						System.out.println(wert1 == wert2);
						if(wert1 == wert2) {
							logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
						} else {
							logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
							Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\3FALSE"+wert1+"GLEICH"+wert2+".jpg");			
							errorLog1.add("ERROR");
						}
					}
				} break;
			} else {
				float wert1 = Float.parseFloat(textWert1);
				if (SENTENCES[i].contains("Werte >")) {
					prf +=1;
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
					if(wert1 > wert2) {
						logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\3FALSE"+wert1+"GROSS"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Werte <")) {
					prf +=1;
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
					if(wert1 < wert2) {
						logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\3FALSE"+wert1+"KLEIN"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Werte =")) {
					prf +=1;
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
					if(wert1 == wert2) {
						logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\3FALSE"+wert1+"GLEICH"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
			}

		}}
		
		// Tabelle/Spalte/alle Werte ><= Wert1 angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Spalte") && !SENTENCES[i].contains("Zeile")
				&& SENTENCES[i].contains("alle Werte") && SENTENCES[i].contains("angezeigt werden")
				&& (SENTENCES[i].contains("Werte >") || SENTENCES[i].contains("Werte <") || SENTENCES[i].contains("Werte ="))) {
			float wert2 = Float.parseFloat(quoteText[2]);
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);

			Label1: for (int k = 0; k < colElements.size(); k++) {
				String textWert1 = colElements.get(k).getText();
				if (textWert1.equals("") || textWert1.equals(null)) {
					String[] cells = Common.IDTabelle1Cell(quoteText[1]);
					for (int n = 0; n < cells.length; n++) {
						textWert1 = Common.htmlTextGetter(cells[n]);
						float wert1 = Float.parseFloat(textWert1);

						if (SENTENCES[i].contains("Werte >")) {
							prf +=1;
							System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
							System.out.println(wert1 > wert2);
							if(wert1 > wert2) {
								logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
							} else {
								logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
								Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\4FALSE"+wert1+"GROSS"+wert2+".jpg");			
								errorLog1.add("ERROR");
							}
						}
						if (SENTENCES[i].contains("Werte <")) {
							prf +=1;
							System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
							System.out.println(wert1 < wert2);
							if(wert1 < wert2) {
								logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
							} else {
								logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
								Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\4FALSE"+wert1+"KLEIN"+wert2+".jpg");			
								errorLog1.add("ERROR");
							}
						}
						if (SENTENCES[i].contains("Werte =")) {
							prf +=1;
							System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
							System.out.println(wert1 == wert2);
							if(wert1 == wert2) {
								logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
							} else {
								logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
								Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\4FALSE"+wert1+"GLEICH"+wert2+".jpg");			
								errorLog1.add("ERROR");
							}
						}
					}
					break Label1;
				} else {
					float wert1 = Float.parseFloat(textWert1);
					System.out.println(wert1);

					if (SENTENCES[i].contains("Werte >")) {
						prf +=1;
						System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
						System.out.println(wert1 > wert2);
						if(wert1 > wert2) {
							logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
						} else {
							logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
							Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\4FALSE"+wert1+"GROSS"+wert2+".jpg");			
							errorLog1.add("ERROR");
						}
					}
					if (SENTENCES[i].contains("Werte <")) {
						prf +=1;
						System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
						System.out.println(wert1 < wert2);
						if(wert1 < wert2) {
							logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
						} else {
							logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
							Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\4FALSE"+wert1+"KLEIN"+wert2+".jpg");			
							errorLog1.add("ERROR");
						}
					}
					if (SENTENCES[i].contains("Werte =")) {
						prf +=1;
						System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
						System.out.println(wert1 == wert2);
						if(wert1 == wert2) {
							logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
						} else {
							logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
							Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\4FALSE"+wert1+"GLEICH"+wert2+".jpg");			
							errorLog1.add("ERROR");
						}
					}
				}
			}
		}
		// Tabelle/Spalte/maximal/minimal/genau Werte-Anzahl angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Spalte") && !SENTENCES[i].contains("Zeile")
				&& (SENTENCES[i].contains("maximal")||SENTENCES[i].contains("minimal")||SENTENCES[i].contains("genau")) && SENTENCES[i].contains("Werte angezeigt werden")) {
			int count = 0;
			String wertString1 = null;
			int wert2 = Integer.parseInt(quoteText[2]);
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1],Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			for(int k=0; k<colElements.size(); k++) {
				wertString1 = colElements.get(k).getText();
				if((wertString1 != null) && !(wertString1.isEmpty())) {
					count +=1;
				}
			}
			if(count == 0) {
					String[] cells = Common.IDTabelle1Cell(quoteText[1]);
					for (int n = 0; n < cells.length; n++) {
						wertString1 = Common.htmlTextGetter(cells[n]);
						if((wertString1 != null) && !(wertString1.isEmpty())) {
							count +=1;
						}
				  }
			}
			if(SENTENCES[i].contains("maximal")) {
				prf +=1;
				System.out.println("Maximale Werte sind "+count+ " :" + (count <= wert2)); //true
				if((count <= wert2)) {
					logger.info("Maximale Werte sind "+count+ " :" + (count <= wert2));
				}else {
					logger.warning("Maximale Werte sind "+count+ " : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1MaxWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("minimal")) {
				prf +=1;
				System.out.println("Minimale Werte sind "+count+ " :" + (count >= wert2)); // true
				if((count <= wert2)) {
					logger.info("Minimale Werte sind "+count+ " :" + (count >= wert2));
				}else {
					logger.warning("Minimale Werte sind "+count+ " : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1MinWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("genau")) {
				prf +=1;
				System.out.println("Genaue Werte sind "+count+ " :" + (count == wert2)); // true
				if((count == wert2)) {
					logger.info("Vergleich-Werte sind "+count+ " :" + (count == wert2));
				}else {
					logger.warning("Aktuell: "+count+ ", erwartet:" +wert2+" : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\1GleichWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/Zeile/maximal/minimal/genau Werte-Anzahl angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && !SENTENCES[i].contains("Spalte")
				&& (SENTENCES[i].contains("maximal")||SENTENCES[i].contains("minimal")||SENTENCES[i].contains("genau")) && SENTENCES[i].contains("Werte angezeigt werden")) {
			String wertString1 = null;
			int count = 0;
			int wert2 = Integer.parseInt(quoteText[2]);
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt);
			for(int k=0; k<rowElements.size(); k++) {
			wertString1 = rowElements.get(k).getText();
				if((wertString1 != null) && !(wertString1.isEmpty())) {
					count +=1;
				}
			}
			if(count == 0) {
					String[] cells = Common.IDTabelle1Row(quoteText[1]);
					for (int n = 0; n < cells.length; n++) {
						wertString1 = Common.htmlTextGetter(cells[n]);
						if((wertString1 != null) && !(wertString1.isEmpty())) {
							count +=1;
						}
				  }
			}
			if(SENTENCES[i].contains("maximal")) {
				prf +=1;
				System.out.println("Maximale Werte sind "+count+ " :" + (count <= wert2)); //true
				if((count <= wert2)) {
					logger.info("Maximale Werte sind "+count+ " :" + (count <= wert2));
				}else {
					logger.warning("Maximale Werte sind "+count+ " : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2MaxWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("minimal")) {
				prf +=1;
				System.out.println("Minimale Werte sind "+count+ " :" + (count >= wert2)); // true
				if((count <= wert2)) {
					logger.info("Minimale Werte sind "+count+ " :" + (count >= wert2));
				}else {
					logger.warning("Minimale Werte sind "+count+ " : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2MinWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("genau")) {
				prf +=1;
				System.out.println("Genaue Werte sind "+count+ " :" + (count == wert2)); // true
				if((count == wert2)) {
					logger.info("Aktuell: "+count+ ", erwartet:" +wert2);
				}else {
					logger.warning("Aktuell: "+count+ ", erwartet:" +wert2+" : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\2GleichWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/Zeile/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt)[k+1]));
				if(eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt)[k+1])) {
					logger.info("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt)[k+1]));
				}else {
					logger.warning("Vergleich Soll/Ist Liste["+k+"]: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\ListeZeileWertNOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/Spalte/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt)[k+1]));
				if(eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt)[k+1])) {
					logger.info("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt)[k+1]));
				}else {
					logger.warning("Vergleich Soll/Ist Liste["+k+"]: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\ListeSpalteWertNOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/beliebigen Zeile/ein Wert in der Spalte X/ ein Wert in der Spalte Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("beliebigen Zeile") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Spalte")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			prf +=1;
			int k = 0; int m = 0; int n = 0; int j = 0;
			List<WebElement> elements = Common.searchTableColumns(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableColumns(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[4], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			// 1.Spalte
			for (WebElement ele : elements) {
				if (quoteText[1].equals(ele.getText())) {
					k += 1;
					System.out.println("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist vorhanden");
					logger.info("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist vorhanden");
					break;
				}
			}
			if (k == 0) {
				String[] cells = Common.IDTabelle1Cell(quoteText[2]);
				for (int t = 0; t < cells.length; t++) {
					String cellText = Common.htmlTextGetter(cells[t]);
					if (quoteText[1].equals(cellText)) {
						m += 1;
						System.out.println("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist vorhanden");
						logger.info("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist vorhanden");
						break;
					}
				}
				if (m == 0) {
					System.out.println("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist NICHT vorhanden");
					logger.warning("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist NICHT vorhanden");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\Spalte"+quoteText[2]+"Wert"+quoteText[1]+"NOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
			// 2.Spalte
			for (WebElement ele1 : elements1) {
				if (quoteText[3].equals(ele1.getText())) {
					n += 1;
					System.out.println("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist vorhanden");
					logger.info("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist vorhanden");
					break;
				}
			}
			if (n == 0) {
				String[] cells = Common.IDTabelle1Cell(quoteText[4]);
				for (int t = 0; t < cells.length; t++) {
					String cellText = Common.htmlTextGetter(cells[t]);
					if (quoteText[3].equals(cellText)) {
						j += 1;
						System.out.println("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist vorhanden");
						logger.info("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist vorhanden");
						break;
					}
				}
				if (j == 0) {
					System.out.println("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist NICHT vorhanden");
					logger.warning("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist NICHT vorhanden");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\Spalte"+quoteText[4]+"Wert"+quoteText[3]+"NOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/beliebigen Spalte/ein Wert in der Zeile X/ ein Wert in der Zeile Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("beliebigen Spalte") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Zeile")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			prf +=1;
			int k = 0; int m = 0; int n = 0; int j = 0;
			List<WebElement> elements = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[2],Constans.Table1_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[4],Constans.Table1_ColumnstagNameInhalt);
			// 1.Zeile
			for (WebElement ele : elements) {
				if (quoteText[1].equals(ele.getText())) {
					k += 1;
					System.out.println("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist vorhanden");
					logger.info("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist vorhanden");
					break;
				}
			}
			if (k == 0) {
				String[] cells = Common.IDTabelle1Row(quoteText[2]);
				for (int t = 0; t < cells.length; t++) {
					String cellText = Common.htmlTextGetter(cells[t]);
					if (quoteText[1].equals(cellText)) {
						m += 1;
						System.out.println("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist vorhanden");
						logger.info("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist vorhanden");
						break;
					}
				}
				if (m == 0) {
					System.out.println("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist NICHT vorhanden");
					logger.warning("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist NICHT vorhanden");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\Zeile"+quoteText[2]+"Wert"+quoteText[1]+"NOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
			// 2.Zeile
			for (WebElement ele1 : elements1) {
				if (quoteText[3].equals(ele1.getText())) {
					n += 1;
					System.out.println("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist vorhanden");
					logger.info("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist vorhanden");
					break;
				}
			}
			if (n == 0) {
				String[] cells = Common.IDTabelle1Row(quoteText[4]);
				for (int t = 0; t < cells.length; t++) {
					String cellText = Common.htmlTextGetter(cells[t]);
					if (quoteText[3].equals(cellText)) {
						j += 1;
						System.out.println("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist vorhanden");
						logger.info("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist vorhanden");
						break;
					}
				}
				if (j == 0) {
					System.out.println("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist NICHT vorhanden");
					logger.warning("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist NICHT vorhanden");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\Zeile"+quoteText[4]+"Wert"+quoteText[3]+"NOTfound.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
//Tabelle2
		//Tabelle/Zeile/Spalte/Text/angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Text") && SENTENCES[i].contains("angezeigt") 
				&& !(SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))){
			prf +=1;
			String outputText = Common.searchTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt).getText();
			System.out.println("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
			if(outputText.equals(quoteText[3])) {
				logger.info("Tabelle2 [row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
			}else {
				logger.warning("Tabelle2 [row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : FALSE");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\WertNotAngezeigt.jpg");			
				errorLog1.add("ERROR");
			}
		}
		//Tabelle/Zeile/Spalte/Wert2 ><= Wert1 angezeigt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")
				&& (SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))) {
			String cellText = Common.searchTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt).getText();
			float wert1 = Float.parseFloat(cellText);
			float wert2 = Float.parseFloat(quoteText[3]);
			if(SENTENCES[i].contains("Wert >")){
				prf +=1;
				System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
				System.out.println(wert1 > wert2);
				if(wert1 > wert2) {
					logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
				} else {
					logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\5FALSE"+wert1+"GROSS"+wert2+".jpg");			
					errorLog1.add("ERROR");
				}
			}
			if(SENTENCES[i].contains("Wert <")){
				prf +=1;
				System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
				System.out.println(wert1 < wert2);
				if(wert1 < wert2) {
					logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
				} else {
					logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\5FALSE"+wert1+"KLEIN"+wert2+".jpg");			
					errorLog1.add("ERROR");
				}
			}
			if(SENTENCES[i].contains("Wert =")){
				prf +=1;
				System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
				System.out.println(wert1 == wert2);
				if(wert1 == wert2) {
					logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
				} else {
					logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\5FALSE"+wert1+"GLEICH"+wert2+".jpg");			
					errorLog1.add("ERROR");
				}
			}	
		}
		//Tabelle/Zeile/Wert/zu finden
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("zu finden")
				&& !SENTENCES[i].contains("Spalte")) {
			prf +=1;
			int count = 0;
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt);
			for(int k=0; k<rowElements.size(); k++) {
				if(rowElements.get(k).getText().equals(quoteText[2])){
					System.out.println("Wert "+quoteText[2]+ " in der Zeile "+quoteText[1]+ " gefunden!");
					logger.info("Wert "+quoteText[2]+ " in der Zeile "+quoteText[1]+ " gefunden!");
					count +=1;
					break;
					}
				}
			if(count == 0) {
					System.out.println("Wert "+quoteText[2]+ " in der Zeile "+quoteText[1]+ " NICHT gefunden!");	
					logger.warning("Wert "+quoteText[2]+ " in der Zeile "+quoteText[1]+ " NICHT gefunden!");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\Wert"+quoteText[2]+"Zeile"+quoteText[1]+"NOTfound.jpg");			
					errorLog1.add("ERROR");
			}
		}
		
		//Tabelle/Spalte/Wert/zu finden
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("zu finden")
				&& !SENTENCES[i].contains("Zeile")) {
			prf +=1;
			int count = 0;
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			for(int k=0; k<colElements.size(); k++) {
				if(colElements.get(k).getText().equals(quoteText[2])){
					System.out.println("Wert "+quoteText[2]+ " in der Spalte "+quoteText[1]+ " gefunden!");
					logger.info("Wert "+quoteText[2]+ " in der Spalte "+quoteText[1]+ " gefunden!");
					count +=1;
					break;					
				}
			}
			if(count == 0) {
				System.out.println("Wert "+quoteText[2]+ " in der Spalte "+quoteText[1]+ " NICHT gefunden!");
				logger.warning("Wert "+quoteText[2]+ " in der Spalte "+quoteText[1]+ " NICHT gefunden!");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\Wert"+quoteText[2]+"Spalte"+quoteText[1]+"NOTfound.jpg");			
				errorLog1.add("ERROR");
			}
		}
		
		// Tabelle/Zeile/alle Werte ><= Wert1 angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && !SENTENCES[i].contains("Spalte")
				&& SENTENCES[i].contains("alle Werte") && SENTENCES[i].contains("angezeigt werden")
				&& (SENTENCES[i].contains("Werte >") || SENTENCES[i].contains("Werte <")|| SENTENCES[i].contains("Werte ="))) {
			float wert2 = Float.parseFloat(quoteText[2]);
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt);
			for(int k=1; k<rowElements.size(); k++) {
				float wert1 = Float.parseFloat(rowElements.get(k).getText());
				if (SENTENCES[i].contains("Werte >")) {
					prf +=1;
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
					if(wert1 > wert2) {
						logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\6FALSE"+wert1+"GROSS"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Werte <")) {
					prf +=1;
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
					if(wert1 < wert2) {
						logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\6FALSE"+wert1+"KLEIN"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Werte =")) {
					prf +=1;
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
					if(wert1 == wert2) {
						logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\6FALSE"+wert1+"GLEICH"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
			}
		 }
		
		}
		
		// Tabelle/Spalte/alle Werte ><= Wert1 angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && !SENTENCES[i].contains("Zeile")
				&& SENTENCES[i].contains("alle Werte") && SENTENCES[i].contains("angezeigt werden")
				&& (SENTENCES[i].contains("Werte >") || SENTENCES[i].contains("Werte <")|| SENTENCES[i].contains("Werte ="))) {
			float wert2 = Float.parseFloat(quoteText[2]);
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1],Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			for(int k=1; k<colElements.size(); k++) {
				float wert1 = Float.parseFloat(colElements.get(k).getText());
				if (SENTENCES[i].contains("Werte >")) {
					prf +=1;
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
					if(wert1 > wert2) {
						logger.info("(" + wert1 + " > " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " > " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\6FALSE"+wert1+"GROSS"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Werte <")) {
					prf +=1;
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
					if(wert1 < wert2) {
						logger.info("(" + wert1 + " < " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " < " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\6FALSE"+wert1+"KLEIN"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
				}
				if (SENTENCES[i].contains("Werte =")) {
					prf +=1;
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
					if(wert1 == wert2) {
						logger.info("(" + wert1 + " = " + wert2 + ") is: TRUE");
					} else {
						logger.warning("(" + wert1 + " = " + wert2 + ") is: FALSE");
						Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\6FALSE"+wert1+"GLEICH"+wert2+".jpg");			
						errorLog1.add("ERROR");
					}
			}
		 }
		
		}
		// Tabelle/Spalte/maximal/minimal/genau Werte-Anzahl angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && !SENTENCES[i].contains("Zeile")
				&& (SENTENCES[i].contains("maximal")||SENTENCES[i].contains("minimal")||SENTENCES[i].contains("genau")) && SENTENCES[i].contains("Werte angezeigt werden")) {		
			int count = 0;
			int wert2 = Integer.parseInt(quoteText[2]);
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1],Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			for(int k=0; k<colElements.size(); k++) {
				String wertString1 = colElements.get(k).getText();
				if(wertString1 != null) {
					count +=1;
				}
			}
			System.out.println(count);
			if(SENTENCES[i].contains("maximal")) {
				prf +=1;
				System.out.println("Maximale Werte sind :" +(count<=wert2)); //true	
				if((count<=wert2)) {
					logger.info("Maximale Werte sind : TRUE");
				}else {
					logger.warning("Maximale Werte sind : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\MaxWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("minimal")) {
				prf +=1;
				System.out.println("Minimale Werte sind :" + (count >= wert2)); // true
				if((count>=wert2)) {
					logger.info("Minimale Werte sind: TRUE");
				}else {
					logger.warning("Minimale Werte sind: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\MinWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("genau")) {
				prf +=1;
				System.out.println("genau "+count+" Werte is :" + (count == wert2)); // true
				if((count==wert2)) {
					logger.info("genau "+count+" Werte is : TRUE");
				}else {
					logger.warning("genau "+count+" Werte is : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\genaueWerteFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/Zeile/maximal/minimal/genau Werte-Anzahl angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && !SENTENCES[i].contains("Spalte")
				&& (SENTENCES[i].contains("maximal")||SENTENCES[i].contains("minimal")||SENTENCES[i].contains("genau")) && SENTENCES[i].contains("Werte angezeigt werden")) {
			int count = 0;
			int wert2 = Integer.parseInt(quoteText[2]);
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt);
			for(int k=0; k<rowElements.size(); k++) {
				String wertString1 = rowElements.get(k).getText();
				if(wertString1 != null) {
					count +=1;
				}
			}
			System.out.println(count);
			if(SENTENCES[i].contains("maximal")) {
				prf +=1;
				System.out.println("Maximale Werte sind :" +(count<=wert2)); //true	
				if((count<=wert2)) {
					logger.info("Maximale Werte sind : TRUE");
				}else {
					logger.warning("Maximale Werte sind : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\MaxWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("minimal")) {
				prf +=1;
				System.out.println("Minimale Werte sind :" + (count >= wert2)); // true
				if((count>=wert2)) {
					logger.info("Minimale Werte sind: TRUE");
				}else {
					logger.warning("Minimale Werte sind : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\MinWertFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
			if (SENTENCES[i].contains("genau")) {
				prf +=1;
				System.out.println("genau "+count+" Werte is :" + (count == wert2)); // true
				if((count==wert2)) {
					logger.info("genau "+count+" Werte is : TRUE");
				}else {
					logger.warning("genau "+count+" Werte is : FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\genaueWerteFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/Zeile/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt)[k+1]));	
				if(eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt)[k+1])) {
					logger.info("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt)[k+1]));	
				}else {
					logger.warning("Vergleich Soll/Ist Liste["+k+"]: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\T2ListeZeileFalse.jpg");			
					errorLog1.add("ERROR");
				}	
			}
		}
		// Tabelle/Spalte/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			prf +=1;
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt)[k+1]));
				if(eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt)[k+1])) {
					logger.info("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt)[k+1]));	
				}else {
					logger.warning("Vergleich Soll/Ist Liste["+k+"]: FALSE");
					Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\T2ListeSpalteFalse.jpg");			
					errorLog1.add("ERROR");
				}
			}
		}
		// Tabelle/beliebigen Zeile/ein Wert in der Spalte X/ ein Wert in der Spalte Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("beliebigen Zeile") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Spalte")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			prf +=1;
			int k = 0; int n = 0;
			List<WebElement> elements = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[2],Constans.Table2_ColumnstagName,Constans.Table2_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[4],Constans.Table2_ColumnstagName,Constans.Table2_ColumnstagNameInhalt);
			for(WebElement ele : elements) {
				if(quoteText[1].equals(ele.getText())){
					k +=1;	
					System.out.println("Der Wert " +quoteText[1]+ " in Spalte "+quoteText[2]+" ist vorhanden");
					logger.info("Der Wert " +quoteText[1]+ " in Spalte "+quoteText[2]+" ist vorhanden");
					break;
				}
			}
			if(k == 0) {
				System.out.println("Der Wert " +quoteText[1]+ " in Spalte "+quoteText[2]+" ist NICHT vorhanden");
				logger.warning("Der Wert " +quoteText[1]+ " in Spalte "+quoteText[2]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\T2beliebigZeileFalse.jpg");			
				errorLog1.add("ERROR");
			}
			for(WebElement ele1 : elements1) {
				if(quoteText[3].equals(ele1.getText())){
					n +=1;
					System.out.println("Der Wert " +quoteText[3]+ " in Spalte "+quoteText[4]+" ist vorhanden");
					logger.info("Der Wert " +quoteText[3]+ " in Spalte "+quoteText[4]+" ist vorhanden");
					break;									
				}
			}
			if(n == 0) {
				System.out.println("Der Wert " +quoteText[3]+ " in Spalte "+quoteText[4]+" ist NICHT vorhanden");
				logger.warning("Der Wert " +quoteText[3]+ " in Spalte "+quoteText[4]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\T2beliebigSpalteFalse.jpg");			
				errorLog1.add("ERROR");
			}
		}
		// Tabelle/beliebigen Spalte/ein Wert in der Zeile X/ ein Wert in der Zeile Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("beliebigen Spalte") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Zeile")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			prf +=1;
			int k = 0; int n = 0;
			List<WebElement> elements = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[2],Constans.Table2_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[4],Constans.Table2_ColumnstagNameInhalt);
			for(WebElement ele : elements) {
				if(quoteText[1].equals(ele.getText())){
					k +=1;	
					System.out.println("Der Wert " +quoteText[1]+ " in Zeile "+quoteText[2]+" ist vorhanden");
					logger.info("Der Wert " +quoteText[1]+ " in Zeile "+quoteText[2]+" ist vorhanden");
					break;
				}
			}
			if(k == 0) {
				System.out.println("Der Wert " +quoteText[1]+ " in Zeile "+quoteText[2]+" ist NICHT vorhanden");
				logger.warning("Der Wert " +quoteText[1]+ " in Zeile "+quoteText[2]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\T2beliebigSpalteWertFalse.jpg");			
				errorLog1.add("ERROR");
			}
			for(WebElement ele1 : elements1) {
				if(quoteText[3].equals(ele1.getText())){
					n +=1;
					System.out.println("Der Wert " +quoteText[3]+ " in Zeile "+quoteText[4]+" ist vorhanden");
					logger.info("Der Wert " +quoteText[3]+ " in Zeile "+quoteText[4]+" ist vorhanden");
					break;									
				}
			}
			if(n == 0) {
				System.out.println("Der Wert " +quoteText[3]+ " in Zeile "+quoteText[4]+" ist NICHT vorhanden");
				logger.warning("Der Wert " +quoteText[3]+ " in Zeile "+quoteText[4]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\T2beliebigSpalteWerteFalse.jpg");			
				errorLog1.add("ERROR");
			}
		}

//Dropdownliste
		//Dropdownliste/Feld/Name/vorhanden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("Feld") && SENTENCES[i].contains("Namen") && SENTENCES[i].contains("vorhanden")) {
			prf +=1;
			System.out.println(quoteText[1].toString());
			if(Common.elementTextIsVisible(quoteText[1])) {
				System.out.println("Feld mit dem Name "+quoteText[1]+" ist vorhanden");
				logger.info("Feld mit dem Name "+quoteText[1]+" ist vorhanden");
			}else {
				System.out.println("Feld mit dem Name "+quoteText[1]+" ist NICHT vorhanden");
				logger.warning("Feld mit dem Name "+quoteText[1]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\DropdownFeldNameErr.jpg");			
				errorLog1.add("ERROR");
			}		
		}
		//Dropdownliste/Feld/Name/vorhanden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("Stelle") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("angezeigt")) {
			prf +=1;
			int a = 0;
			int loc = Integer.parseInt(quoteText[1]);
			List<WebElement> elements = Common.botstrapDropDownMenu(Constans.DropDownAddressTyp, Constans.DropDownAddress, Constans.DropDownMenuAddressTyp, Constans.DropDownMenuAddress);
			if(elements.size()>loc) {
				for(WebElement ele : elements) {
					if(quoteText[2].equals(ele.getText())) {
						a += 1;
						System.out.println("Stelle "+loc+ " Wert "+quoteText[2]+" ist: " +(loc == (elements.indexOf(ele))));
						logger.info("Stelle "+loc+ " Wert "+quoteText[2]+" ist: " +(loc == (elements.indexOf(ele))));
						
					}	
				}
			if(a == 0) {
				System.out.println("Wert "+quoteText[2]+" ist NICHT vorhanden");
				logger.warning("Wert "+quoteText[2]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\DropdownStelleWertErr.jpg");			
				errorLog1.add("ERROR");
				}	
			}
		}
		
//Scrollbar
		//Crollbar/Wert/eingestellt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Scrollbar") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingestellt")) {
			prf +=1;
			if(Common.isVisibleInViewport(quoteText[1])) {
				System.out.println("Element mit dem Name "+quoteText[1]+" ist vorhanden");
				logger.info("Element mit dem Name "+quoteText[1]+" ist vorhanden");
			}else {
				System.out.println("Element mit dem Name "+quoteText[1]+" ist NICHT vorhanden");
				logger.warning("Element mit dem Name "+quoteText[1]+" ist NICHT vorhanden");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\ScrollbarWertErr.jpg");			
				errorLog1.add("ERROR");
			}
		}
		
//Link
		//Link/den Wert/anzeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("der Link") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("anzeigt")) {	
			prf +=1;
			String searchElem = Common.searchElemNewWindow(quoteText[0], quoteText[1]);			
			if(searchElem.equals(quoteText[1])) {
				System.out.println("Link <"+quoteText[0]+"> zeigt Wert <"+quoteText[1]+"> an.");
				logger.info("Link <"+quoteText[0]+"> zeigt Wert <"+quoteText[1]+"> an.");
			}else {
				System.out.println("Link <"+quoteText[0]+"> zeigt Wert <"+quoteText[1]+"> NICHT an.");
				logger.warning("Link <"+quoteText[0]+"> zeigt Wert <"+quoteText[1]+"> NICHT an.");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\LinkWertErr.jpg");			
				errorLog1.add("ERROR");
			}
		}
		//Link/der Link/zu Bildschirm/führt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("der Link") && SENTENCES[i].contains("Bildschirm") && SENTENCES[i].contains("führt")) {
			prf +=1;
			if(Common.switchToWindow(quoteText[1])) {
				System.out.println("Aktueller Bildschirm: "+quoteText[1]);
				logger.info("Aktueller Bildschirm: "+quoteText[1]);
			} else {
				System.out.println(quoteText[1]+" Nicht gefunden!");
				logger.warning(quoteText[1]+" Nicht gefunden!");
				Common.takeScreenShort("C:\\Users\\case\\Desktop\\HR2020\\Logs_Screenshots\\CacheScreenShot\\LinkBildschirmErr.jpg");			
				errorLog1.add("ERROR");
			}
		}
		
//Kombobox --> Wegen des unvollständgen Testobjekt von Henrik, wird es erst nicht weiter getestet werden
		//Kombobox/Feld mit dem Name/vorhanden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("Feld mit dem Namen") && SENTENCES[i].contains("vorhanden ist")) {
			prf +=1;
			System.out.println(Common.listSearch(Constans.Listbox1_AddressTyp, Constans.Listbox1_Address, quoteText[1]));
		}
		//Kombobox/den Wert/angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("den Wert") && SENTENCES[i].contains("angezeigt")) {
			prf +=1;
			String comboText = Common.Locator(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address).getAttribute("value");
			comboText = comboText.replaceAll("\\s+", "");
			System.out.println(comboText);
			System.out.println(comboText.equalsIgnoreCase(quoteText[1].replaceAll("\\s+", "")));
		}
// Wenn ein Satz nicht abgedeckt werden kann:
		if (!(prf > 0)) {
			System.out.println("Dieser Satz ist nicht in Ordnung gemäß Mustersatz oder Code [Klasse: KeywordsEditor.java]");
			logger.warning("Eingelesener Satz nicht in Ordnung, bitte gegen Mustersatz oder Code prüfen [Klasse: KeywordsEditor.java]!!! \r\n+ Der Satz ist: "+SENTENCES[i]);
		} else {
			prf = 0;
		}
		
		//Config Output: Execution-Code: 1-Testbestanden, 2-TestFail:
		if (errorLog1.size()>0) {
			statusID = "2"; 
		} else {
			statusID = "1";
		}
	} 
		
	return statusID;
		
	}
	
//  public Verifier verifier = new Verifier() {
//  // After each method perform this check
//  @Override
  public String verify() {
  	String out="";
      assertTrue("Error Log is not Empty!", errorLog.isEmpty());
      for (int i=0; i<errorLog.size();i++) {
      	out = out+ ","+errorLog.get(i);
      }
      return out;
  }

}
