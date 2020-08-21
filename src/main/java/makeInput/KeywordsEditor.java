package makeInput;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

public class KeywordsEditor {
	
	public void keywordsHandling(String scenarioPath) throws Exception {
		String[] SENTENCES;
		String values;
		//String fieldRowCol;
		String EckigKlammernElemente;
		String EckigKlammernTexts;

		// find out the Sentences from texts
		SENTENCES = Common.SentencesDef(scenarioPath);
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
/**WENN**/
//Textfeld		
		//Textfeld Eingabefeld1 = new Textfeld(Constans.name1, Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
		//Textfeld/Linksklick				
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.buttonClicker(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
		}
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld2") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.buttonClicker(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
		}
		//Textfeld/eingebe
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {			
			String quoteText2 = quoteText[1].toString();
			Common.InputValueInField(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address, quoteText2);
		}
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld2") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {			
			String quoteText2 = quoteText[1].toString();
			Common.InputValueInField(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address, quoteText2);
		}
		//Textfeld/Rechtsklick
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			Common.rightClicker(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
		}
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld2") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			Common.rightClicker(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
		}
		//Textfeld/markiere
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("markiere")) {
			Common.highLighterMethod(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
		}
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("markiere")) {
			Common.highLighterMethod(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
		}
		//Textfeld/überfahre
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.mouseOverElement(Constans.Textfeld1_AddressTyp, Constans.Textfeld1_Address);
		}
		if(SENTENCES[i].contains("Textfeld") && SENTENCES[i].contains("Eingabefeld1") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.mouseOverElement(Constans.Textfeld2_AddressTyp, Constans.Textfeld2_Address);
		}
		
//Passwortfeld
		//Passwortfeld/Linksklick
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.buttonClicker(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
		}
		// Passwortfeld/Rechtsklick
		if (SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			Common.rightClicker(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
		}
		// Passwortfeld/markieren
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("markiere")) {
			Common.highLighterMethod(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
		}
		//Passwortfeld/Wert/eingeben
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {	
			String quoteText2 = quoteText[1].toString();
			Common.InputValueInField(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address, quoteText2);
		}
		//Passwortfeld/überfahren
		if(SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.mouseOverElement(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
		}
				
//Schaltfläche
		//Schaltfläche/Login/Linksklick
		if(SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				Common.buttonClicker(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				Common.buttonClicker(Constans.Schalflaeche2_AddressTyp,Constans.Schalflaeche2_Address);
			}
		}
		// Schaltfläche/Doppelklick
		if (SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("Doppelklick") && SENTENCES[i].contains("auswähle")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				Common.duppleClicker(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				Common.duppleClicker(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
			}
		}
		// Schaltfläche/Rechtsklick
		if (SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				Common.rightClicker(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				Common.rightClicker(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
			}
		}
		// Schaltfläche/überfahren
		if (SENTENCES[i].contains("Schaltfläche") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			if(SENTENCES[i].contains("schaltfläche1")) {
				Common.mouseOverElement(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				Common.mouseOverElement(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
			}
		}
		
//Checkbox-Radiobutton
		//Checkbox/anwähle
		if(SENTENCES[i].contains("WENN") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("anwähle")) {
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami"))			
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address) == false) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken"))			
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen"))			
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas"))			
				if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}	
		}
		//Radiobutton/anwähle
		if(SENTENCES[i].contains("WENN") && SENTENCES[i].contains("Radiobutton")&& SENTENCES[i].contains("anwähle")) {
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard"))
				if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address) == false) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa"))
				if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton1_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express"))
				if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton1_Address) == false) {
					Common.clickRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton1_Address);
			}
		}
		//Checkbox/abwähle
		if(SENTENCES[i].contains("WENN") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("abwähle")) {
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami"))
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken"))
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen"))
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas"))
			if (Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}
		}
		//Radiobutton/abwähle
		if(SENTENCES[i].contains("WENN") && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("abwähle")) {
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard"))
			if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa"))
			if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express"))
			if (Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address) == true) {
				Common.clickRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
			}
		}
		// Checkbox/überfahren
		if (SENTENCES[i].contains("WENN") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.mouseOverElement(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);	
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")){
				Common.mouseOverElement(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);	
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")){
				Common.mouseOverElement(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);	
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")){
				Common.mouseOverElement(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")){
				Common.mouseOverElement(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}
		}
		
		// Radiobutton/überfahren
		if (SENTENCES[i].contains("WENN") && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")){
				Common.mouseOverElement(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")){
				Common.mouseOverElement(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")){
				Common.mouseOverElement(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
			}
		}
		
//Tabelle1
		//Tabelle/Zeile/Spalte/Linksklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.leftClickTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
		}
		//Tabelle/Zeile/Spalte/Duppelklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Doppelklick") && SENTENCES[i].contains("auswähle")) {
			Common.duppleClickTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
		}
		//Tabelle/Zeile/Spalte/Rechtsklick/auswähle
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			Common.rightClickTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
		}
		// Tabelle/Zeile/Spalte/Wert/eingebe
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			Common.inputTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], quoteText[3], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
		}
		// Tabelle/Zeile/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt, eckKlmText );	
		}
		// Tabelle/Spalte/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleSpalteListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt, eckKlmText );
		}
		// Tabelle/Zeile/Spalte/Wert/markiere
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("markiere")) {
			Common.valueCellMarker(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2],Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
		}
		// Tabelle/Zeile/Spalte/überfahren
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")){
			Common.mouseOverTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
		}	
		
//Tabelle2
		//Tabelle/Zeile/Spalte/Linksklick/auswähle
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.leftClickTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
		}
		//Tabelle/Zeile/Spalte/Duppelklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Doppelklick") && SENTENCES[i].contains("auswähle")) {
			Common.duppleClickTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
		}
		//Tabelle/Zeile/Spalte/Rechtsklick/auswähle
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			Common.rightClickTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
		}
		// Tabelle/Zeile/Spalte/Wert/eingebe
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			Common.inputTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], quoteText[3], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
		}
		// Tabelle/Zeile/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleZeileListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt, eckKlmText );	
		}
		// Tabelle/Spalte/Liste/eingebe
		if  (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste [")&& SENTENCES[i].contains("eingebe")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			Common.inputTabelleSpalteListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table2_ColumnstagNameInhalt, eckKlmText );
		}
		// Tabelle/Zeile/Spalte/Wert/markiere
		if (SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("Wert") && SENTENCES[i].contains("markiere")) {
			Common.valueCellMarker(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2],Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
		}
		// Tabelle/Zeile/Spalte/überfahren
		if (SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")&& SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")){
			Common.mouseOverTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
		}
		
//Dropdownliste
		//Dropdown/Feld/Linksklick/auswähle
		if (SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("Feld mit dem Namen") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			System.out.println(quoteText[1]);
			if(SENTENCES[i].contains("dropdown1")) {
				Common.botstrapDropDown(Constans.DropDown1_AddressTyp, Constans.DropDown1_Address, Constans.DropDown1_MenuAddressTyp, Constans.DropDown1_MenuAddress, quoteText[1]);
			}
			if(SENTENCES[i].contains("dropdown2")) {
				Common.botstrapDropDown(Constans.DropDown2_AddressTyp, Constans.DropDown2_Address, Constans.DropDown2_MenuAddressTyp, Constans.DropDown2_MenuAddress, quoteText[1]);
			}
		}
		//Dropdown/Feld/überfahren
		if (SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			if(SENTENCES[i].contains("dropdown1")) {
				Common.MouseOverBotstrapDropDown(Constans.DropDown1_AddressTyp, Constans.DropDown1_Address);
			}
			if(SENTENCES[i].contains("dropdown2")) {
				Common.MouseOverBotstrapDropDown(Constans.DropDown2_AddressTyp, Constans.DropDown2_Address);;
			}
		}
		
//Scrollbar
		if (SENTENCES[i].contains("Scrollbar") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("scrolle")) {
			Common.scrollToElement(quoteText[1]);
		}
		
//Link
		//Link/Linksklick/auswähle
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.scrollElementToMiddle(quoteText[0]);
			Common.Locator("textName", quoteText[0]).click();
			Thread.sleep(4000);
		}
		//Link/Rechtsklick/auswähle
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("Rechtsklick") && SENTENCES[i].contains("auswähle")) {
			Common.scrollElementToMiddle(quoteText[0]);
			Common.rightClicker("textName", quoteText[0]);
		}
		//Link/markiere
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("markiere")) {

			Common.scrollElementToMiddle(quoteText[0]);
			Common.highLighterMethod("textName", quoteText[0]);
		}
		//Link/überfahre
		if (SENTENCES[i].contains("den Link") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.scrollElementToMiddle(quoteText[0]);
			Common.mouseOverElement("textName", quoteText[0]);
		}
		
//Kombobox
		//Kombobox/Wert/eingebe
		if  (SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingebe")) {
			Common.ComboboxInput(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address, quoteText[1]);
		}
		//Kombobox/Liste durch die Eingabe des Wertes/Wertnummer/Linksklick/auswähle
		if  (SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("das Feld mit dem Namen") && SENTENCES[i].contains("Linksklick") && SENTENCES[i].contains("auswähle")) {
			Common.searchAndClick(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address, quoteText[1]);			
		}
		//Kombobox/überfahre
		if  (SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("über") && SENTENCES[i].contains("fahre")) {
			Common.mouseOverCombobox(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address);
		}
		

		
/**DANN**/
		
//Textfeld und Ausgabefeld		
		//Textfeld/Text/angezeigt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && (SENTENCES[i].contains("Text") || SENTENCES[i].contains("Wert"))
				&& !(SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert =")) && !(SENTENCES[i].contains("Tabelle"))&& !(SENTENCES[i].contains("Dropdownliste"))
				&& !(SENTENCES[i].contains("der Link")) && !(SENTENCES[i].contains("Kombobox"))){
			Thread.sleep(2000);
			if(SENTENCES[i].contains("Textfeld")  && SENTENCES[i].contains("Eingabefeld1")) {
				String quoteText2 = quoteText[1].toString();
				String outputText_Istwert = Common.getTextByElement(Constans.Textfeld_FeldtypValue_AddressTyp, Constans.Textfeld_FeldtypValue_AddressTyp);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
			}
			if(SENTENCES[i].contains("Ausgabefeld") && SENTENCES[i].contains("ausgabefeld1")) {
				String quoteText2 = quoteText[1].toString();
				String outputText_Istwert = Common.getTextByElement(Constans.Ausgabefeld1_AddressTyp, Constans.Ausgabefeld1_Address);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
				}
		}
		//Textfeld/Wert2 ><= Wert1 angezeigt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && SENTENCES[i].contains("Wert") && !SENTENCES[i].contains("Tabelle")
				&& (SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))) {
			String wert1String = null;
			Thread.sleep(3000);
			float wert2 = Float.parseFloat(quoteText[1]);
			if(SENTENCES[i].contains("Textfeld")  && SENTENCES[i].contains("Eingabefeld1")) {
				wert1String = Common.getTextByElement(Constans.Textfeld_FeldtypValue_AddressTyp, Constans.Textfeld_FeldtypValue_Address);
			}
			if(SENTENCES[i].contains("Ausgabefeld") && SENTENCES[i].contains("ausgabefeld1")) {
				wert1String = Common.getTextByElement(Constans.Ausgabefeld1_AddressTyp, Constans.Ausgabefeld1_Address);
			}
			if(wert1String != null) {
			float wert1 = Float.parseFloat(wert1String);

			if(SENTENCES[i].contains("Wert >")){
				System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
				System.out.println(wert1 > wert2);
			}
			if(SENTENCES[i].contains("Wert <")){
				System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
				System.out.println(wert1 < wert2);
			}
			if(SENTENCES[i].contains("Wert =")){
				System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
				System.out.println(wert1 == wert2);
			}
			} else {
				System.out.println("OutputWert nicht gefunden");
			}
		}
		
//Passwortfeld
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Passwortfeld") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("angezeigt")) {
			Thread.sleep(3000);
			String quoteText2 = quoteText[1].toString();
			String outputText_Istwert = Common.getTextByElement(Constans.Passwortfeld1_AddressTyp, Constans.Passwortfeld1_Address);
			System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
		}
		
//Schaltfläche
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Schaltfäche") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("angezeigt")) {
			Thread.sleep(3000);
			String quoteText2 = quoteText[1].toString();
			if(SENTENCES[i].contains("schaltfläche1")) {
				String outputText_Istwert = Common.getTextByElement(Constans.Schalflaeche1_AddressTyp, Constans.Schalflaeche1_Address);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
			}
			if(SENTENCES[i].contains("schaltfläche2")) {
				String outputText_Istwert = Common.getTextByElement(Constans.Schalflaeche2_AddressTyp, Constans.Schalflaeche2_Address);
				System.out.println(outputText_Istwert.equals(quoteText2) + " --> " + outputText_Istwert);
			}
		}
	
//Checkbox-Radiobutton
		//Radiobutton/angewählt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("angewählt")) {
			boolean status=false;
			String quoteText1 = quoteText[0].toString();
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
			}
			if(status == true) {
				System.out.println("Radiobutton "+quoteText1+" aktuell angewählt");
			} else if(status == false) {
				System.out.println("Radiobutton "+quoteText1+" aktuell NICHT angewählt");
			}
		}
		// Radiobutton/abgewählt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Radiobutton") && SENTENCES[i].contains("abgewählt")) {
			String quoteText1 = quoteText[0].toString();
			boolean status=true;
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Mastercard")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton1_AddressTyp, Constans.RadioButton1_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Visa")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton2_AddressTyp, Constans.RadioButton2_Address);
			}
			if(SENTENCES[i].contains("radiobutton1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("American Express")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.RadioButton3_AddressTyp, Constans.RadioButton3_Address);
			}
			if (status == true) {
				System.out.println("Radiobutton "+quoteText1+" aktuell NICHT abgewählt");
			} else if (status == false) {
				System.out.println("Radiobutton "+quoteText1+" aktuell agewählt");
			}
		}
		//Checkbox/angewählt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("angewählt")) {
			boolean status = false;
			String quoteText1 = quoteText[0].toString();
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}
			if(status == true) {
				System.out.println("Checkbox "+quoteText1+" aktuell angewählt");
			} else if(status == false) {
				System.out.println("Checkbox "+quoteText1+" aktuell NICHT angewählt");
			}
		}
		// Checkbox/abgewählt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Checkbox") && SENTENCES[i].contains("abgewählt")) {
			String quoteText1 = quoteText[0].toString();
			boolean status = true;
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Salami")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox1_AddressTyp, Constans.CheckBox1_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Schinken")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox2_AddressTyp, Constans.CheckBox2_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Sardellen")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox3_AddressTyp, Constans.CheckBox3_Address);
			}
			if(SENTENCES[i].contains("checkbox1") && SENTENCES[i].contains("Option")&& SENTENCES[i].contains("Ananas")) {
				status = Common.checkRadioButtonAndCheckBox(Constans.CheckBox4_AddressTyp, Constans.CheckBox4_Address);
			}
			if (status == true) {
				System.out.println("Checkbox "+quoteText1+" aktuell NICHT abgewählt");
			} else if (status == false) {
				System.out.println("Checkbox "+quoteText1+" aktuell abgewählt");
			}
		}
		
//Tabelle1
		//Tabelle/Zeile/Spalte/Text/angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Text") && SENTENCES[i].contains("angezeigt") 
				&& !(SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))){
			String outputText=null;
			System.out.println("ssssss");
			if(SENTENCES[i].contains("tabelle1")) {
				outputText = Common.htmlTextGetter(Common.IDTabelle1(quoteText[1], quoteText[2]));
				System.out.println("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
			}
			if(!SENTENCES[i].contains("tabelle1") && !SENTENCES[i].contains("tabelle2")) {
				outputText =  Common.searchTableCell(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt).getText();
				Thread.sleep(2000);
				System.out.println("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
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
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
				}
				if (SENTENCES[i].contains("Wert <")) {
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
				}
				if (SENTENCES[i].contains("Wert =")) {
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
				}

			} else {
				float wert1 = Float.parseFloat(cellText);
				if (SENTENCES[i].contains("Wert >")) {
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
				}
				if (SENTENCES[i].contains("Wert <")) {
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
				}
				if (SENTENCES[i].contains("Wert =")) {
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
				}
			}
		}
		//Tabelle/Zeile/Wert/zu finden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("zu finden")
				&& !SENTENCES[i].contains("Spalte")) {
			int count = 0;
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address,quoteText[1], Constans.Table1_ColumnstagNameInhalt);
			Label1: for (int k = 0; k < rowElements.size(); k++) {
				String outputText = rowElements.get(k).getText();
				if (outputText.equals("") || outputText.equals(null)) {
					String[] row = Common.IDTabelle1Row(quoteText[1]);
					for (int j = 0; j < row.length; j++) {
						outputText = Common.htmlTextGetter(row[j]);
						if (outputText.equals(quoteText[2])) {
							System.out.println("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> gefunden!");
							count += 1;
							break;
						}
					}
					if (count == 0) {
						System.out.println("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> NICHT gefunden!");
					}
					break Label1;
				}
				if (rowElements.get(k).getText().equals(quoteText[2])) {
					System.out.println("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> gefunden!");
				} else {
					System.out.println("Wert <" + quoteText[2] + "> in der Zeile <" + quoteText[1] + "> NICHT gefunden!");
				}
			}
		}
		
		//Tabelle/Spalte/Wert/zu finden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle1")
				&& SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Wert")
				&& SENTENCES[i].contains("zu finden") && !SENTENCES[i].contains("Zeile")) {
			int count = 0;
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table1_AddressTyp,Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName,Constans.Table1_ColumnstagNameInhalt);
			Label1: for (int k = 0; k < colElements.size(); k++) {
				String outputText = colElements.get(k).getText();
				if (outputText.equals("") || outputText.equals(null)) {
					String[] cols = Common.IDTabelle1Cell(quoteText[1]);
					for (int j = 0; j < cols.length; j++) {
						outputText = Common.htmlTextGetter(cols[j]);
						if (outputText.equals(quoteText[2])) {
							System.out.println("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> gefunden!");
							count += 1;
							break;
						}
					}
					if (count == 0) {
						System.out.println("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> NICHT gefunden!");
					}
					break Label1;
				}
				if (colElements.get(k).getText().equals(quoteText[2])) {
					System.out.println("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> gefunden!");
				} else {
					System.out.println("Wert <" + quoteText[2] + "> in der Spalte <" + quoteText[1] + "> NICHT gefunden!");
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
						System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
						System.out.println(wert1 > wert2);
					}
					if (SENTENCES[i].contains("Werte <")) {
						System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
						System.out.println(wert1 < wert2);
					}
					if (SENTENCES[i].contains("Werte =")) {
						System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
						System.out.println(wert1 == wert2);
					}
				} break;
			} else {
				float wert1 = Float.parseFloat(textWert1);
				if (SENTENCES[i].contains("Werte >")) {
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
				}
				if (SENTENCES[i].contains("Werte <")) {
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
				}
				if (SENTENCES[i].contains("Werte =")) {
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
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
							System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
							System.out.println(wert1 > wert2);
						}
						if (SENTENCES[i].contains("Werte <")) {
							System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
							System.out.println(wert1 < wert2);
						}
						if (SENTENCES[i].contains("Werte =")) {
							System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
							System.out.println(wert1 == wert2);
						}
					}
					break Label1;
				} else {
					float wert1 = Float.parseFloat(textWert1);
					System.out.println(wert1);

					if (SENTENCES[i].contains("Werte >")) {
						System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
						System.out.println(wert1 > wert2);
					}
					if (SENTENCES[i].contains("Werte <")) {
						System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
						System.out.println(wert1 < wert2);
					}
					if (SENTENCES[i].contains("Werte =")) {
						System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
						System.out.println(wert1 == wert2);
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
				System.out.println("Maximale Werte sind "+count+ " :" + (count <= wert2)); //true
			}
			if (SENTENCES[i].contains("minimal")) {
				System.out.println("Minimale Werte sind "+count+ " :" + (count >= wert2)); // true
			}
			if (SENTENCES[i].contains("genau")) {
				System.out.println("Genaue Werte sind "+count+ " :" + (count == wert2)); // true
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
				System.out.println("Maximale Werte sind "+count+ " :" + (count <= wert2)); //true
			}
			if (SENTENCES[i].contains("minimal")) {
				System.out.println("Minimale Werte sind "+count+ " :" + (count >= wert2)); // true
			}
			if (SENTENCES[i].contains("genau")) {
				System.out.println("Genaue Werte sind "+count+ " :" + (count == wert2)); // true
			}
		}
		// Tabelle/Zeile/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagNameInhalt)[k+1]));	
			}
		}
		// Tabelle/Spalte/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[1], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt)[k+1]));	
			}
		}
		// Tabelle/beliebigen Zeile/ein Wert in der Spalte X/ ein Wert in der Spalte Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("beliebigen Zeile") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Spalte")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			int k = 0; int m = 0; int n = 0; int j = 0;
			List<WebElement> elements = Common.searchTableColumns(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[2], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableColumns(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[4], Constans.Table1_ColumnstagName, Constans.Table1_ColumnstagNameInhalt);
			// 1.Spalte
			for (WebElement ele : elements) {
				if (quoteText[1].equals(ele.getText())) {
					k += 1;
					System.out.println("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist vorhanden");
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
						break;
					}
				}
				if (m == 0) {
					System.out.println("Der Wert " + quoteText[1] + " in Spalte " + quoteText[2] + " ist NICHT vorhanden");
				}
			}
			// 2.Spalte
			for (WebElement ele1 : elements1) {
				if (quoteText[3].equals(ele1.getText())) {
					n += 1;
					System.out.println("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist vorhanden");
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
						break;
					}
				}
				if (j == 0) {
					System.out.println("Der Wert " + quoteText[3] + " in Spalte " + quoteText[4] + " ist NICHT vorhanden");
				}
			}
		}
		// Tabelle/beliebigen Spalte/ein Wert in der Zeile X/ ein Wert in der Zeile Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle1") && SENTENCES[i].contains("beliebigen Spalte") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Zeile")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			int k = 0; int m = 0; int n = 0; int j = 0;
			List<WebElement> elements = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[2],Constans.Table1_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableRows(Constans.Table1_AddressTyp, Constans.Table1_Address, quoteText[4],Constans.Table1_ColumnstagNameInhalt);
			// 1.Zeile
			for (WebElement ele : elements) {
				if (quoteText[1].equals(ele.getText())) {
					k += 1;
					System.out.println("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist vorhanden");
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
						break;
					}
				}
				if (m == 0) {
					System.out.println("Der Wert " + quoteText[1] + " in Zeile " + quoteText[2] + " ist NICHT vorhanden");
				}
			}
			// 2.Zeile
			for (WebElement ele1 : elements1) {
				if (quoteText[3].equals(ele1.getText())) {
					n += 1;
					System.out.println("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist vorhanden");
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
						break;
					}
				}
				if (j == 0) {
					System.out.println("Der Wert " + quoteText[3] + " in Zeile " + quoteText[4] + " ist NICHT vorhanden");
				}
			}
		}
//Tabelle2
		//Tabelle/Zeile/Spalte/Text/angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Text") && SENTENCES[i].contains("angezeigt") 
				&& !(SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))){
			String outputText = Common.searchTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt).getText();
			System.out.println("[row;col] = ["+quoteText[1]+";"+quoteText[2]+"] : " + outputText.equals(quoteText[3]));
		}
		//Tabelle/Zeile/Spalte/Wert2 ><= Wert1 angezeigt
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("angezeigt") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Spalte")
				&& (SENTENCES[i].contains("Wert >") || SENTENCES[i].contains("Wert <") || SENTENCES[i].contains("Wert ="))) {
			String cellText = Common.searchTableCell(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], quoteText[2], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt).getText();
			float wert1 = Float.parseFloat(cellText);
			float wert2 = Float.parseFloat(quoteText[3]);
			if(SENTENCES[i].contains("Wert >")){
				System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
				System.out.println(wert1 > wert2);
			}
			if(SENTENCES[i].contains("Wert <")){
				System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
				System.out.println(wert1 < wert2);
			}
			if(SENTENCES[i].contains("Wert =")){
				System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
				System.out.println(wert1 == wert2);
			}	
		}
		//Tabelle/Zeile/Wert/zu finden
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2")&& SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("zu finden")
				&& !SENTENCES[i].contains("Spalte")) {
			int count = 0;
			List<WebElement> rowElements = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt);
			for(int k=0; k<rowElements.size(); k++) {
				if(rowElements.get(k).getText().equals(quoteText[2])){
					System.out.println("Wert "+quoteText[2]+ " in der Zeile "+quoteText[1]+ " gefunden!");
					count +=1;
					break;
					}
				}
			if(count == 0) {
					System.out.println("Wert "+quoteText[2]+ " in der Zeile "+quoteText[1]+ " NICHT gefunden!");	
			}
		}
		
		//Tabelle/Spalte/Wert/zu finden
		if(SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("zu finden")
				&& !SENTENCES[i].contains("Zeile")) {
			int count = 0;
			List<WebElement> colElements = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt);
			for(int k=0; k<colElements.size(); k++) {
				if(colElements.get(k).getText().equals(quoteText[2])){
					System.out.println("Wert "+quoteText[2]+ " in der Spalte "+quoteText[1]+ " gefunden!");
					count +=1;
					break;					
				}
			}
			if(count == 0) {
				System.out.println("Wert "+quoteText[2]+ " in der Spalte "+quoteText[1]+ " NICHT gefunden!");
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
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
				}
				if (SENTENCES[i].contains("Werte <")) {
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
				}
				if (SENTENCES[i].contains("Werte =")) {
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
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
					System.out.print("(" + wert1 + " > " + wert2 + ") is: ");
					System.out.println(wert1 > wert2);
				}
				if (SENTENCES[i].contains("Werte <")) {
					System.out.print("(" + wert1 + " < " + wert2 + ") is: ");
					System.out.println(wert1 < wert2);
				}
				if (SENTENCES[i].contains("Werte =")) {
					System.out.print("(" + wert1 + " = " + wert2 + ") is: ");
					System.out.println(wert1 == wert2);
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
				System.out.println("Maximale Werte sind :" +(count<=wert2)); //true	
			}
			if (SENTENCES[i].contains("minimal")) {
				System.out.println("Maximale Werte sind :" + (count >= wert2)); // true
			}
			if (SENTENCES[i].contains("genau")) {
				System.out.println("Maximale Werte sind :" + (count == wert2)); // true
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
			System.out.println("Maximale Werte sind :" + (count <= wert2)); //true
			}
			if (SENTENCES[i].contains("minimal")) {
				System.out.println("Maximale Werte sind :" + (count >= wert2)); // true
			}
			if (SENTENCES[i].contains("genau")) {
				System.out.println("Maximale Werte sind :" + (count == wert2)); // true
			}
		}
		// Tabelle/Zeile/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Zeile") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleZeileListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagNameInhalt)[k+1]));	
			}
		}
		// Tabelle/Spalte/Liste/angezeigt werden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle")&& SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("Spalte") && SENTENCES[i].contains("Liste") && SENTENCES[i].contains("angezeigt werden")) {
			String[] eckKlmText = EckigKlammernTexts.split("%Space&");
			for(int k=0; k<eckKlmText.length; k++) {
				System.out.println("Vergleich Soll/Ist Liste["+k+"]: "  +eckKlmText[k].equals(Common.outputTabelleSpalteListe(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[1], Constans.Table2_ColumnstagName, Constans.Table2_ColumnstagNameInhalt)[k+1]));	
			}
		}
		// Tabelle/beliebigen Zeile/ein Wert in der Spalte X/ ein Wert in der Spalte Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("beliebigen Zeile") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Spalte")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			int k = 0; int n = 0;
			List<WebElement> elements = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[2],Constans.Table2_ColumnstagName,Constans.Table2_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableColumns(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[4],Constans.Table2_ColumnstagName,Constans.Table2_ColumnstagNameInhalt);
			for(WebElement ele : elements) {
				if(quoteText[1].equals(ele.getText())){
					k +=1;	
					System.out.println("Der Wert " +quoteText[1]+ " in Spalte "+quoteText[2]+" ist vorhanden");
					break;
				}
			}
			if(k == 0) {
				System.out.println("Der Wert " +quoteText[1]+ " in Spalte "+quoteText[2]+" ist NICHT vorhanden");
			}
			for(WebElement ele1 : elements1) {
				if(quoteText[3].equals(ele1.getText())){
					n +=1;
					System.out.println("Der Wert " +quoteText[3]+ " in Spalte "+quoteText[4]+" ist vorhanden");
					break;									
				}
			}
			if(n == 0) {
				System.out.println("Der Wert " +quoteText[3]+ " in Spalte "+quoteText[4]+" ist NICHT vorhanden");
			}
		}
		// Tabelle/beliebigen Spalte/ein Wert in der Zeile X/ ein Wert in der Zeile Y/vorhanden ist
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Tabelle") && SENTENCES[i].contains("tabelle2") && SENTENCES[i].contains("beliebigen Spalte") && SENTENCES[i].contains("ein Wert") && SENTENCES[i].contains("in der Zeile")
				&& SENTENCES[i].contains("und ein Wert") && SENTENCES[i].contains("vorhanden ist")) {
			int k = 0; int n = 0;
			List<WebElement> elements = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[2],Constans.Table2_ColumnstagNameInhalt);
			List<WebElement> elements1 = Common.searchTableRows(Constans.Table2_AddressTyp, Constans.Table2_Address, quoteText[4],Constans.Table2_ColumnstagNameInhalt);
			for(WebElement ele : elements) {
				if(quoteText[1].equals(ele.getText())){
					k +=1;	
					System.out.println("Der Wert " +quoteText[1]+ " in Zeile "+quoteText[2]+" ist vorhanden");
					break;
				}
			}
			if(k == 0) {
				System.out.println("Der Wert " +quoteText[1]+ " in Zeile "+quoteText[2]+" ist NICHT vorhanden");
			}
			for(WebElement ele1 : elements1) {
				if(quoteText[3].equals(ele1.getText())){
					n +=1;
					System.out.println("Der Wert " +quoteText[3]+ " in Zeile "+quoteText[4]+" ist vorhanden");
					break;									
				}
			}
			if(n == 0) {
				System.out.println("Der Wert " +quoteText[3]+ " in Zeile "+quoteText[4]+" ist NICHT vorhanden");
			}
		}

//Dropdownliste
		//Dropdownliste/Feld/Name/vorhanden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("Feld") && SENTENCES[i].contains("Namen") && SENTENCES[i].contains("vorhanden")) {
			System.out.println(quoteText[1].toString());
			if(Common.elementTextIsVisible(quoteText[1])) {
				System.out.println("Feld mit dem Name "+quoteText[1]+" ist vorhanden");
			}else {
				System.out.println("Feld mit dem Name "+quoteText[1]+" ist NICHT vorhanden");
			}		
		}
		//Dropdownliste/Feld/Name/vorhanden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Dropdownliste") && SENTENCES[i].contains("Stelle") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("angezeigt")) {
			int a = 0;
			int loc = Integer.parseInt(quoteText[1]);
			List<WebElement> elements = Common.botstrapDropDownMenu(Constans.DropDownAddressTyp, Constans.DropDownAddress, Constans.DropDownMenuAddressTyp, Constans.DropDownMenuAddress);
			if(elements.size()>loc) {
				for(WebElement ele : elements) {
					if(quoteText[2].equals(ele.getText())) {
						a += 1;
						System.out.println("Stelle "+loc+ " Wert "+quoteText[2]+" ist: " +(loc == (elements.indexOf(ele))));
					}	
				}
			if(a == 0) {
				System.out.println("Wert "+quoteText[2]+" ist NICHT vorhanden");
				}	
			}
		}
		
//Scrollbar
		//Crollbar/Wert/eingestellt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Scrollbar") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("eingestellt")) {
			if(Common.isVisibleInViewport(quoteText[1])) {
				System.out.println("Element mit dem Name "+quoteText[1]+" ist vorhanden");
			}else {
				System.out.println("Element mit dem Name "+quoteText[1]+" ist NICHT vorhanden");
			}
		}
		
//Link
		//Link/den Wert/anzeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("der Link") && SENTENCES[i].contains("Wert") && SENTENCES[i].contains("anzeigt")) {			
			String searchElem = Common.searchElemNewWindow(quoteText[0], quoteText[1]);			
			if(searchElem.equals(quoteText[1])) {
				System.out.println("Link <"+quoteText[0]+"> zeigt Wert <"+quoteText[1]+"> an.");
			}else {
				System.out.println("Link <"+quoteText[0]+"> zeigt Wert <"+quoteText[1]+"> NICHT an.");
			}
		}
		//Link/der Link/zu Bildschirm/führt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("der Link") && SENTENCES[i].contains("Bildschirm") && SENTENCES[i].contains("führt")) {
			if(Common.switchToWindow(quoteText[1])) {
				System.out.println("Aktueller Bildschirm: "+quoteText[1]);
			} else {
				System.out.println(quoteText[1]+" Nicht gefunden!");
			}
		}
		
//Kombobox
		//Kombobox/Feld mit dem Name/vorhanden
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("Feld mit dem Namen") && SENTENCES[i].contains("vorhanden ist")) {
			System.out.println(Common.listSearch(Constans.Listbox1_AddressTyp, Constans.Listbox1_Address, quoteText[1]));
		}
		//Kombobox/den Wert/angezeigt
		if (SENTENCES[i].contains("prüfe") && SENTENCES[i].contains("Kombobox") && SENTENCES[i].contains("den Wert") && SENTENCES[i].contains("angezeigt")) {
			String comboText = Common.Locator(Constans.Kombobox1_AddressTyp, Constans.Kombobox1_Address).getAttribute("value");
			comboText = comboText.replaceAll("\\s+", "");
			System.out.println(comboText);
			System.out.println(comboText.equalsIgnoreCase(quoteText[1].replaceAll("\\s+", "")));
		}
		
		
		
		
		
		}
	}

}
