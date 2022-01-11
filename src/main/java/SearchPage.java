import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{
    WebDriver driver = null;

    //WebElementi

    @FindBy(xpath = "//label[contains(@for,'5_zenski')]")
    WebElement filterPolZenski;

    @FindBy(xpath = "//ul[@class='items-wrapper']//input[contains(@checked,'checked')]")
    WebElement filterPolZenskiOznacen;

    @FindBy(id = "f_eusize_04")
    WebElement filterVelicina4;

    @FindBy (id = "f_pricelist_2000")
    WebElement filterCena1501Do2000;

    @FindBy(id = "f_pricelist_3500")
    WebElement filterCena3001Do3500;

    @FindBy(xpath = "//div[text()='Reč ili fraza: haljina']")
    WebElement pretragaHaljinaOznacena;

    @FindBy(xpath = "//div[contains(@nb-value,'zenski')]")
    WebElement pretragaFilterZenskiOznacen;

    @FindBy(xpath = "//div[text()='Reč ili fraza: haljina']")
    WebElement pretragaFilterHaljinaOznacen;

    @FindBy(xpath ="//div[text()='04']")
    WebElement pretragaFilterVelicina04Oznacen;

    @FindBy(xpath = "//div[text()='3.001 - 3.500 RSD']")
    WebElement pretragaFilterCena2501Do3000Oznacen;

    @FindBy(id = "sort")
    WebElement dropdownSortiraj;

    @FindBy(xpath = "//select[@id='sort']//option[text()='Najjeftinije prvo']")
    WebElement dropdownSortirajNajjeftinijePrvo;

    @FindBy(xpath = "//select[@id='sort']//option[text()='Po nazivu']")
    WebElement dropdownSortirajPoNazivu;

    @FindBy(xpath = "//div[@class='block products-listing product product-listing-items ']")
    WebElement rezultatSortiranja;



    //Konstruktor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    //Metode nad webelementima

    public void oznaciFilterPolZenski(){

        assert isElementPresent ( filterPolZenski ):"Error. Filter form is not present.";
        filterPolZenski.click ();
        sleep ();
    }
    public void oznaciFilterVelicina4(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterVelicina4 );
        assert isElementPresent ( filterVelicina4 ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterVelicina4);
        sleep ();
//        filterVelicina4.click ();
    }
    public void oznaciFilterCena1501Do2000(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterCena1501Do2000 );
        assert isElementPresent ( filterCena1501Do2000 ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterCena1501Do2000);
        sleep ();

    }
    public void oznaciFilterCena3001Do3500(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterCena3001Do3500 );
        assert isElementPresent ( filterCena3001Do3500 ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterCena3001Do3500);
        sleep ();
    }
    public void oznaciFilterPolZenskiVelicina4Cena3001Do3500(){
        this.oznaciFilterPolZenski ();
        this.oznaciFilterVelicina4 ();
        this.oznaciFilterCena3001Do3500 ();
    }



    public void daLiJePolZenskiOznacenUBlokTagu(){
        print ( "Da li se pol zenski pojavio kao filter u blok tagu" );
        assert isElementPresent ( pretragaFilterZenskiOznacen ):"Error. Filter zenski pol nije prikazan.";

    }
    public void daLiJeHaljinaOznacenaUBlokTagu(){
        print ( "Da li se rec haljina pojavljuje kao filter u blok tagu" );
        assert isElementPresent ( pretragaFilterHaljinaOznacen ):"Error. Filter haljina nije prikazan.";
    }

    public void daLiJeVelicina04UBlokTagu(){
        print ( "Da li se velicina 04 pojavljuje kao filter u blok tagu" );
        assert isElementPresent ( pretragaFilterVelicina04Oznacen ):"Error. Filter Velicina 04 nije prikazan.";
    }

    public void daLiJeCena2501Do3000UBlokTagu(){
        print ( "Da li se cena od 2501 do 3000 pojavljuje kao filter u blok tagu" );
        assert isElementPresent ( pretragaFilterCena2501Do3000Oznacen ):"Error. Filter Cena 2501 do 3000 nije prikazan.";
    }

    public void daLiSuSviFilteriOznaceniUBlokTagu(){
        this.daLiJePolZenskiOznacenUBlokTagu ();
        this.daLiJeHaljinaOznacenaUBlokTagu ();
        this.daLiJeVelicina04UBlokTagu ();
        this.daLiJeCena2501Do3000UBlokTagu ();
    }

    public void dropdownSortirajClick(){
        assert isElementPresent ( dropdownSortiraj ):"Error. Dropdown menu is not present.";
        dropdownSortiraj.click ();
    }

    public void dropdownSortirajNajjeftinijePrvoClick(){
        assert isElementPresent ( dropdownSortirajNajjeftinijePrvo ):"Error. Dropdown menu is not present.";
        dropdownSortirajNajjeftinijePrvo.click ();
    }

    public void dropdownSortirajPoNazivu(){
        assert isElementPresent ( dropdownSortirajPoNazivu ):"Error. Dropdown menu is not present.";
        dropdownSortirajPoNazivu.click ();
    }

    public void searchAllProduct(){
//        List<WebElement> rezultatPretrage = driver.findElements(By.xpath ( "//div[@class='block products-listing product product-listing-items ']" ) );
//
//        for( WebElement artikal : rezultatPretrage){
//
//            print (artikal.getText());

//            String prviArtikalUNizu

            ArrayList<String> sortedArray= new ArrayList<> ();
            //Stampa posle sortiranja
            List<WebElement> sortedList = driver.findElements(By.xpath ("//div[@class='block products-listing product product-listing-items ']"));
            for(WebElement e : sortedList) {
                String itemName = e.findElement(By.xpath ("//div[@class='product-shortname']")).getText();
                sortedArray.add(itemName);
                String price = e.findElement(By.xpath ("//div[@class='prices-wrapper']")).getText();
                System.out.println("Cena za  " + itemName + " je " + price);
            }


        }
    }






