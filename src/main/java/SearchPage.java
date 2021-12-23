import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage{
    WebDriver driver = null;

    //WebElementi
//    @FindBy(xpath = "//form[@id='filter_form']//label[@class='icheck-label icheck[qdovq]']")
//    @FindBy(xpath = "//div[@class='icheckbox_flat icheck-item icheck[az2fo]']")
//            @FindBy(xpath = "//div[@class='filter-group  ']//label[@class='icheck-label icheck[az2fo]']")
    @FindBy(xpath = "//label[contains(@for,'5_zenski')]")
    WebElement filterPolZenski;

//    @FindBy(xpath = "//ul[@class='items-wrapper']//div[@class='icheckbox_flat icheck-item icheck[ctu2a] checked']")
   @FindBy(xpath = "//ul[@class='items-wrapper']//input[contains(@checked,'checked')]")
    WebElement filterPolZenskiOznacen;

    @FindBy(id = "f_eusize_04")
    WebElement filterVelicina4;

        @FindBy (id = "f_pricelist_2000")
         //   @FindBy(xpath = "//ul[@class='items-wrapper']//label[@class='icheck-label icheck[6zc6u]']")
    WebElement filterCena1501Do2000;
        @FindBy(id = "f_pricelist_3500")
        WebElement filterCena3001Do3500;

    @FindBy(xpath = "//div[text()='Reč ili fraza: haljina']")
    WebElement pretragaHaljinaOznacena;

    @FindBy(xpath = "//div[text()='zenski ']")
    WebElement pretragaFilterZenskiOznacen;




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

    public void daLiJeHaljinaOznacena(){
        print ( "daLiJeHaljinaOznacena" );
        assert isElementPresent ( pretragaHaljinaOznacena ):"Error. Haljina nije produkt pretrage";

    }
    public void daLiJePolZenskiOznacen(){
        waitForElement ( filterPolZenski );
        print ( "daLiJePolZenskiOznacen" );
        assert isElementPresent ( filterPolZenskiOznacen ):"Error. Pol zenski nije oznacen";


    }

    public void daLiJePolZenskiOznacenUPretraziFiltera(){
        waitForElement ( pretragaFilterZenskiOznacen );
        print ( "Da li se pol zenski pojavio kao filter u blok tagu" );
        assert isElementPresent ( pretragaFilterZenskiOznacen ):"Error. Filter zenski pol nije prikazan ";

    }



}
