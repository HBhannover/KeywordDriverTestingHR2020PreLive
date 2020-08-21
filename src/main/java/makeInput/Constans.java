package makeInput;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class Constans {
		
	// Paths zu Szenarien:

	public static String pathTestfall1 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall1.1.txt";
	public static String pathTestfall2 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall2.txt";
	public static String pathTestfall2_1 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall2.1.txt";
	public static String pathTestfall2_2 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall2.2.txt";
	public static String pathTestfall2_3 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall2.3.txt";
	public static String pathTestfall2_4 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall2.4.txt";
	public static String pathTestfall2_5 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall2.5.txt";
	public static String pathTestfall3 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall3.txt";
	public static String pathTestfall3_1 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall3.1.txt";
	public static String pathTestfall5 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall5.txt";
	public static String pathTestfall6 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall6.txt";
	public static String pathTestfall6_1 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall6.1.txt";
	public static String pathTestfall6_2 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall6.2.txt";
	public static String pathTestfall6_3 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall6.3.txt";
	public static String pathTestfall7 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall7.txt";
	public static String pathTestfall8_1 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall8.1.txt";
	public static String pathTestfall8_2 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall8.2.txt";
	public static String pathTestfall8_3 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall8.3.txt";
	public static String pathTestfall9_1 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall9.1.txt";
	public static String pathTestfall9_2 = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\Testfall9.2.txt";
	public static String pathProbe = "C:\\Users\\hbn\\DemoKeywordDriver\\Henrik_MA2020\\src\\main\\java\\scenario\\TFProbe.txt";
	public static String pathEncodingCHCP1252 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\ProbeEncodingCHCP1252";
	
	//Henrik-Objekt:
	public static String pathTextfeld1 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Textfeld1.txt";
	public static String pathRadiobutton1 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Radiobutton1.txt";
	public static String pathCheckbox1 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Checkbox1.txt";
	public static String pathPasswortfeld1 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Passwortfeld1.txt";
	public static String pathDropdown1  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Dropdown1.txt";
	public static String pathDropdown2  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Dropdown2.txt";
	public static String pathKombobox1  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Kombobox1.txt";
	public static String pathKombobox2  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Kombobox2.txt";
	public static String pathScrollbar1  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Scrollbar1.txt";
	public static String pathLink1  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Link1.txt";
	public static String pathLink2  = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Link2.txt";
	public static String pathTabelle1 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Tabelle1.txt";
	public static String pathTabelle2 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Tabelle2.txt";
	public static String pathTabelle3 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Tabelle3.txt";
	public static String pathTabelle4 = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_Tabelle4.txt";
	public static String pathTabelleProbe = "C:\\Users\\hbn\\Desktop\\Bach\\PPI_Welt\\Henrik_MA\\Testobjekt\\Testfall\\TF_TabelleProbe.txt";

	
	// WebApps:
	public static String url = "http://app.hubspot.com/login"; //für TF1
	public static String urlAdditionTable = "https://keisan.casio.com/exec/system/13800848854767"; //für TF2 und TF5
	public static String urlRadioButtonCheckBox = "https://htmldog.com/examples/inputcheckboxes.html"; // für TF3 und TF3.1
	public static String urlBootstrapDropDown = "https://www.hotel.de/"; //für TF6 tf7
	public static String urlPPIAG = "https://www.ppi.de/"; //für TF8
	public static String urlProbe = "https://chandanachaitanya.github.io/selenium-practice-site/";
	public static String urlKombobox ="https://www.ibm.com/support/knowledgecenter/de";
	public static String urlHenrik = "file:///C:/Users/hbn/Desktop/Bach/PPI_Welt/Henrik_MA/Testobjekt/index.html";
	
	// Elements lokalisieren:
	
	
/*=================
	Henrik-Objekt
==================*/
/***Textfeld**/
	public static String name1 = "Eingabefeld1 ";
	public static String Textfeld1_AddressTyp = "id";
	public static String Textfeld1_Address = "eingabefeld1";
	
	public static String name2 = "Eingabefeld2 ";
	public static String Textfeld2_AddressTyp = "id";
	public static String Textfeld2_Address = "eingabefeld2";
	
/***Passwortfeld**/
	public static String Passwortfeld1_AddressTyp = "id";
	public static String Passwortfeld1_Address = "passwortfeld";
	
/***RadioButton**/
	public static String RadioButton1_AddressTyp = "id";
	public static String RadioButton1_Address = "mc";
	
	public static String RadioButton2_AddressTyp = "id";
	public static String RadioButton2_Address = "vi";
	
	public static String RadioButton3_AddressTyp = "id";
	public static String RadioButton3_Address = "ae";
	
/***CheckBox**/
	public static String CheckBox1_AddressTyp = "xpath";
	public static String CheckBox1_Address = "//input[@value='salami']";
	
	public static String CheckBox2_AddressTyp = "";
	public static String CheckBox2_Address = "//input[@value='schinken']";
	
	public static String CheckBox3_AddressTyp = "";
	public static String CheckBox3_Address = "//input[@value='sardellen']";
	
	public static String CheckBox4_AddressTyp = "";
	public static String CheckBox4_Address = "//input[@value='ananas']";
	
/***Tabelle**/
	//Tabelle1
	public static String Table1_AddressTyp = "xpath";
	public static String Table1_Address = "//*[@id='tabelle1']//tbody//tr";
	public static String Table1_ColumnstagName = "th";
	public static String Table1_ColumnstagNameInhalt = "td";

	
	//Tabelle2
	public static String Table2_AddressTyp = "xpath";
	public static String Table2_Address = "//*[@id='tabelle2']//tbody//tr";
	public static String Table2_ColumnstagName = "th";
	public static String Table2_ColumnstagNameInhalt = "td";
	
/***Schaltfläche**/
	//public static String Schalflaeche1_AddressTyp = "id";
	//public static String Schalflaeche1_Address = "schaltfläche1";
	public static String Schalflaeche1_AddressTyp = "xpath";
	public static String Schalflaeche1_Address = "//button[@onclick='changeVehicle()']";
	
	
	//public static String Schalflaeche2_AddressTyp = "id";
	//public static String Schalflaeche2_Address = "schaltfläche2";
	
	public static String Schalflaeche2_AddressTyp = "xpath";
	public static String Schalflaeche2_Address = "//input[@onclick='switchLight()']";
	
/***Dropdownliste**/
	public static String DropDown1_AddressTyp = "id";
	public static String DropDown1_Address = "dropdown1";
	public static String DropDown1_MenuAddressTyp = "xpath";
	public static String DropDown1_MenuAddress = "//select[@id='dropdown1']//option";
	
	public static String DropDown2_AddressTyp = "id";
	public static String DropDown2_Address = "dropdown2";
	public static String DropDown2_MenuAddressTyp = "xpath";
	public static String DropDown2_MenuAddress = "//select[@id='dropdown2']//option";

/***Ausgabefeld**/
	public static String Ausgabefeld1_AddressTyp = "id";
	public static String Ausgabefeld1_Address = "ausgabefeld1";
	
/***Kombobox (Kombinationsfeldern): wird hier als eine Kombination zwischen ein Textfeld und eine Dropdown-Liste **/
	public static String Kombobox1_AddressTyp ="id"; 
	public static String Kombobox1_Address = "kombobox1";
	public static String Listbox1_AddressTyp = "xpath"; //"id";
	public static String Listbox1_Address = "//datalist[@id='bundesländer']//option"; //"react-autowhatever-1";
	
	
//===============================================================================/
/* Weitere Testobjekte
//===============================================================================/
	
/***Textfeld-Input**/
		//Texfeld zum Linksklick
		public static String TextfeldLinksklickAddressTyp = "";
		public static String TextfeldLinksklickAddress = "";
		
		//Textfeld zur Eingabe
		public static String TextfeldEingabeAddressTyp = "id";
		public static String TextfeldEingabeAddress = "eingabefeld1";
		
		// Textfeld als Benutzername
		public static String BenutzernameAddressTyp = "id";
		public static String BenutzernameAddress = "username";
		//public static String BenutzernameValue = "dentruocbinhminh@yahoo.com";
		
		// Texfeld zum Recksklick
		public static String TextfeldRightClickElementAddressTyp = "";
		public static String TextfeldRightClickElementAddress = "";
		
		// Texfeld zu markieren
		public static String TextfeldHightlightElementAddressTyp = "";
		public static String TextfeldHightlightElementAddress = "";
		
		//Texfeld zum MouseOver (überfahren)
		public static String TextfeldMouseOverElementAddressTyp = "";
		public static String TextfeldMouseOverElementAddress = "";

/***Textfeld-Output**/
		//TextfeldOutput FeldtypValue
		public static String Textfeld_FeldtypValue_AddressTyp = "";
		public static String Textfeld_FeldtypValue_Address = "";
				
		//TextOutput AktionsValue
		public static String TextOutputAddressTyp = "xpath";
		public static String TextOutputAddress = "//h1[@class = 'private-header__heading private-header__heading--solo']";
		public static String TextOutput_Sollwert = "Dashboard-Bibliothek";		
		
/***Passwortfeld-Input**/
		//Input-FeldtypValue
		// Passwortfeld FeldtypValue zum Linksklick
		public static String PasswortfeldLinksklickAddressTyp = "";
		public static String PasswortfeldLinksklickAddress = "";

		// Passwortfeld FeldtypValue zur Eingabe
		public static String PasswortfeldEingabeAddressTyp = "id";
		public static String PasswortfeldEingabeAddress = "password";

		// Passwortfeld FeldtypValue zum Recksklick
		public static String PasswortfeldRightClickElementAddressTyp = "";
		public static String PasswortfeldRightClickElementAddress = "";

		// Passwortfeld FeldtypValue zu markieren
		public static String PasswortfeldHightlightElementAddressTyp = "";
		public static String PasswortfeldHightlightElementAddress = "";

		// Passwortfeld FeldtypValue zum MouseOver (überfahren)
		public static String PasswortfeldMouseOverElementAddressTyp = "";
		public static String PasswortfeldMouseOverElementAddress = "";
		
/***Passwortfeld-Output**/
		//Output-FeldtypValue
		public static String PasswortFeldOutputAddressTyp = "";
		public static String PasswortFeldOutputAddress = "";		
		
/***Schaltfläche-Input**/
		//Schaltfläche/Linksklick FeldtypValue (Login-Button)
		public static String SchalflaecheLOGINLinksklickAddressTyp = "id";
		public static String SchalflaecheLOGINLinksklickAddress = "loginBtn";
		
		//Schaltfläche/Linksklick FeldtypValue (Berechne-Button) (Additionstabelle)
		public static String SchalflaecheBerechneLinksklickAddressTyp = "id";
		public static String SchalflaecheBerechneLinksklickAddress = "executebtn";

		// Schaltfläche/Rechtsklick FeldtypValue
		public static String SchalflaecheRechtsklickAddressTyp = "";
		public static String SchalflaecheRechtsklickAddress = "";

		// Schaltfläche/Doppelklick FeldtypValue
		public static String SchalflaecheDoppelklickAddressTyp = "";
		public static String SchalflaecheDoppelklickAddress = "";

		// Schaltfläche/Überfahren FeldtypValue
		public static String SchalflaecheOverAddressTyp = "";
		public static String SchalflaecheOverAddress = "";

/***Schaltfläche-Output **/
		// Schaltfläche FeldtypValue
		public static String SchalflaecheOutputISTAddressTyp = "";
		public static String SchalflaecheOutputISTAddress = "";
		
		// Schaltfläche AktionsValue
		public static String SchalflaecheOutputSOLLAddressTyp = "";
		public static String SchalflaecheOutputSOLLAddress = "";
	
/***Tabelle-Input**/
		// inputTable (Additionstabelle)
//		public static String TableAddressTyp = "xpath";
//		public static String TableAddress = "//*[@id='var_a_EXL']//tbody//tr";
//		public static String TableColumnstagName = "td";
//
//		
//		// outputTable:
////		public static String OutputTableAddressTyp="xpath";
////		public static String OutputTableAddress = "//*[@class='htCore']//tbody//tr";
////		public static String OutputTableColumnstagName = "td";
//		public static String OutputTableAddressTyp="xpath";
//		public static String OutputTableAddress = "//*[@id='var_a_EXL']//tbody//tr";
//		public static String OutputTableColumnstagName = "td";
		
/***RadioButton-Input**/
		//Radiobutton/anwählen
		public static String RadioButtonInputAddressTyp1 = "id";
		public static String RadioButtonInputAddress1 = "20to39";
		
		//Radiobutton/abwählen
		public static String RadioButtonInputAddressTyp2 = "";
		public static String RadioButtonInputAddress2 = "";
		
		//Radiobutton/überfahren
		public static String RadioButtonInputAddressTyp3 = "";
		public static String RadioButtonInputAddress3 = "";

/***RadioButton-Output**/
		//Radiobutton/angewält
		public static String RadioButtonOutputAddressTyp1 = "id";
		public static String RadioButtonOutputAddress1 = "gt59";
		
		// Radiobutton/abgewält
		public static String RadioButtonOutputAddressTyp2 = "";
		public static String RadioButtonOutputAddress2 = "";
		
/***CheckBox-Input**/
		//Checkbox/anwähle
		public static String CheckBoxInputAddressTyp1 = "id";
		public static String CheckBoxInputAddress1 = "comedy";
		
		//Checkbox/abwähle
		public static String CheckBoxInputAddressTyp2 = "";
		public static String CheckBoxInputAddress2 = "";
		
		//Checkbox/überfahren
		public static String CheckBoxInputAddressTyp3 = "";
		public static String CheckBoxInputAddress3 = "";

/***CheckBox-Output**/
		//Checkbox/angewählt
		public static String CheckBoxOutputAddressTyp1 = "id";
		public static String CheckBoxOutputAddress1 = "horror";
		
		// Checkbox/abgewählt
		public static String CheckBoxOutputAddressTyp2 = "";
		public static String CheckBoxOutputAddress2 = "";
				
		// FirmenLogo:
		public static String FirmenLogoAddressTyp = "xpath";
		public static String FirmenLogoAddress = "//*[@id=\"site-title\"]/a/img";

/***Dropdownliste**/
		// Dropdownliste/Feld/Linksklick/auswähle
		public static String DropDownAddressTyp = "xpath";
		public static String DropDownAddress = "//div[@class='IconWithLink__iconText--ArXtV IconWithLink__accentDarkGray--1yBic IconWithLink__xsmall--2MrZp IconWithLink__mediumbold--3R76q']";
		public static String DropDownMenuAddressTyp = "xpath";
		public static String DropDownMenuAddress = "//div[@class='DropDown__itemsList--ZLQ4w']//a";
		
		//Zusätzliches Beispiel für Testfall 6.2 (Dropdown überfahren)
//		public static String DropDownAddressTyp = "xpath";
//		public static String DropDownAddress  = "//li[@id='navi-life']";
//		public static String DropDownMenuAddressTyp = "xpath";
//		public static String DropDownMenuAddress = "//ul[@class='sub-menu']//li";
		
/***Link**/
		
/***Kombobox (Kombinationsfeldern): wird hier als eine Kombination zwischen ein Textfeld und eine Dropdown-Liste **/
		//Kombobox/Wert/eingebe/überfahre
		public static String KomboboxAddressTyp ="xpath"; 
		public static String KomboboxAddress = "//div[@class='LocationAutoSuggest__container--2Hli_']//input";
		public static String ListboxAddressTyp = "xpath"; //"id";
		public static String ListboxAddress = "//div[@id='react-autowhatever-1']//ul//li"; //"react-autowhatever-1";
		

		
	


}
