package com.erp.qa.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    // Constructor to initialize elements
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="txtownerfirstname")
    WebElement fistname;
    public void enterFirstName(String fn) {
        fistname.sendKeys(fn);
    }

    @FindBy(id="txtownerlasttname")
    WebElement lastname;
    public void enterLastName(String ln) {
        lastname.sendKeys(ln);
    }

    @FindBy(id="txtownercontactno")
    WebElement contact;
    public void enterContact(String con) {
        contact.sendKeys(con);
    }

    @FindBy(id="txtowneremail")
    WebElement email;
    public void enterEmail(String eml) {
        email.sendKeys(eml);
    }

    @FindBy(id="txtdistributorcode")
    WebElement distributorcode;
    public void enterDistributorcode(String dbc) {
        distributorcode.sendKeys(dbc);
    }

    @FindBy(id="txtdistributorname")
    WebElement distributorname;
    public void enterDistributorname(String dbn) {
        distributorname.sendKeys(dbn);
    }

    @FindBy(id="txtdistributoraddress1")
    WebElement distributoraddress;
    public void enterdistributoradd(String dba) {
        distributoraddress.sendKeys(dba);
    }

    @FindBy(id="txtdistributoraddress2")
    WebElement distributoradd;
    public void enterdistribuadd(String dba2) {
        distributoradd.sendKeys(dba2);
    }

    @FindBy(id="select2-ddlstate-container")
    WebElement state;
    public void selectState() {
        state.click();
    }

    @FindBy(xpath="//input[@role='textbox']")
    WebElement serstate;
    public void searchState(String stat) {
        serstate.sendKeys(stat);
        serstate.sendKeys(Keys.ENTER);
    }

    @FindBy(id="select2-ddldistrict-container")
    WebElement district;
    public void clickdistrict() {
        district.click();
    }

    @FindBy(xpath="//input[@role='textbox']")
    WebElement searchdistrict;
    public void selectDistrict(String dis) {
        searchdistrict.sendKeys(dis);
        searchdistrict.sendKeys(Keys.ENTER);
    }

    @FindBy(id="select2-ddlTahsil-container")
    WebElement tehsil;
    public void clickOnTehsil() {        
        tehsil.click();
    }

    @FindBy(xpath="//input[@role='textbox']")
    WebElement selecttehsil;
    public void selectOnTehsil(String teh) {
        selecttehsil.sendKeys(teh);
        selecttehsil.sendKeys(Keys.ENTER);
    }

    @FindBy(id="txtcity")
    WebElement city;
    public void enterCity(String cit) {
        city.sendKeys(cit);
    }

    @FindBy(id="txtSalesArea")
    WebElement area;
    public void enterArea(String are) {
        area.sendKeys(are);
    }

    @FindBy(id="txtpincode")
    WebElement pincode;
    public void enterOnPincode(String pin) {
        pincode.sendKeys(pin);
    }

    @FindBy(id="txtcontactdetail1")
    WebElement contact1;
    public void enterContact1(String cont) {
        // fixed: use contact1 not contact
        contact1.sendKeys(cont);
    }

    @FindBy(id="txtcontactdetail2")
    WebElement contact2;
    public void enterContact2(String cont2) {
        contact2.sendKeys(cont2);
    }

    @FindBy(id="txtdistributormail")
    WebElement email1;
    public void enterEmail1(String eml) {
        email1.sendKeys(eml);
    }

    @FindBy(id="select2-ddldistributorof-container")
    WebElement distributorof;
    public void selectdistributorof() {
        distributorof.click();
    }

    @FindBy(xpath="//input[@role='textbox']")
    WebElement searchdistributorof;
    public void clickOnsearchdistirbutorof(String dist) {
        searchdistributorof.sendKeys(dist);
        searchdistributorof.sendKeys(Keys.ENTER);
    }

    @FindBy(id="select2-ddlterittory-container")
    WebElement terittory;
    public void clickOnTerittory() {
        terittory.click();
    }

    @FindBy(xpath="//input[@role='textbox']")
    WebElement selectterittory;
    public void clickonselectterittory(String ter) {
        selectterittory.sendKeys(ter);
        selectterittory.sendKeys(Keys.ENTER);
    }

    @FindBy(id="select2-ddldistributortype-container")
    WebElement distributortype;
    public void clickOndistributortype() {
        distributortype.click();
    }

    @FindBy(xpath="//input[@role='textbox']")
    WebElement selecttype;
    public void clickOntype(String typ) {
        selecttype.sendKeys(typ);
        selecttype.sendKeys(Keys.ENTER);
    }

    @FindBy(id="txttransportorcode")
    WebElement transportorcode;
    public void enterOnTransasaportorcode(String cod) {
        transportorcode.sendKeys(cod);
    }

    @FindBy(id="txtPANnumber")
    WebElement pannumber;
    public void enterOnPan(String pan) {
        pannumber.sendKeys(pan);
    }

    @FindBy(id="txtGSTINnumer")
    WebElement gstin;
    public void enterGSTIN(String gst) {
        gstin.sendKeys(gst);
    }

    @FindBy(id="txtuserid")
    WebElement userid;
    public void enterUserId(String use) {
        userid.sendKeys(use);
    }

    @FindBy(id="txtpswd")
    WebElement password;
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    @FindBy(id="txtrepswd")
    WebElement repassword;
    public void enterRepassword(String pass1) {
        repassword.sendKeys(pass1);
    }

    @FindBy(id="btnclear")
    WebElement clear;
    public void clickOnclear() {
        clear.click();
    }

    @FindBy(id="btnsubmit")
    WebElement submit;
    public void clickOnsubmit() {
        submit.click();
    }
    public void Filling(String fn, String ln, String con, String eml, String dbc, String dbn, String dba, String dba2, String stat, String dis, String teh, String cit, String are, String pin, String cont, String cont2, String eml1, String dist, String ter, String typ, String cod, String pan, String gst, String use, String pass, String pass1) {
		enterFirstName(fn);
		enterLastName(ln);
		enterContact(con);
		enterEmail(eml);
		enterDistributorcode(dbc);
		enterDistributorname(dbn);
		enterdistributoradd(dba);
		enterdistribuadd(dba2);
		selectState();
		searchState(stat);
		clickdistrict();
		selectDistrict(dis);
		clickOnTehsil();
		selectOnTehsil(teh);
		enterCity(cit);
		enterArea(are);
		enterOnPincode(pin);
		enterContact1(cont);
		enterContact2(cont2);
		enterEmail1(eml1);
		selectdistributorof();
		clickOnsearchdistirbutorof(dist);
		clickOnTerittory();
		clickonselectterittory(ter);
		clickOndistributortype();
		clickOntype(typ);
		enterOnTransasaportorcode(cod);
		enterOnPan(pan);
		enterGSTIN(gst);
		enterUserId(use);
		enterPassword(pass);
		enterRepassword(pass1);
	}
   
}
