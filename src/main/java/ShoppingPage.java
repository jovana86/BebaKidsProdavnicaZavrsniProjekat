import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ShoppingPage extends BasePage{

    WebDriver driver=null;

    //Webelementi
    @FindBy(className = "slider_recommend_obuca")
    WebElement navigacionaListaObuca;

    @FindBy(xpath = "//label[contains(@for,'5_zenski')]")
    WebElement filterPolZenski;

    @FindBy(id = "f_eusize_25")
    WebElement filterVelicina25;

    @FindBy(xpath = "//label[contains(@for,'2_naturino')]")
    WebElement filterBrendNaturino;

    @FindBy(xpath =  "//div[contains(@data-productid,'17371')]")
    WebElement odabraneCipele;

    @FindBy(xpath = "//li[contains(@data-productsize-name,'25')]")
    WebElement odrediVelicinu25;

    @FindBy(id = "nb_addToCartButton")
    WebElement dodajUKorpu;

    @FindBy(xpath = "//div[@id='miniCartContent']")
    WebElement ikonicaKorpa;

    @FindBy(xpath = "//a[text()='MOJA KORPA']")
    WebElement mojaKorpa;

    @FindBy(className = "header-carthor-total")
    WebElement brojNaIkoniciKorpa;

    @FindBy(xpath = "//table[@class='table cart-table']")
    WebElement tabelaUKorpi;

    @FindBy(xpath = "//h3[text()='Prijava']")
    WebElement prijavaKorisnikaUKorpi;

    @FindBy(id = "login_email")
    WebElement loginEmailUKorpi;

    @FindBy (id = "login_password")
    WebElement loginLozinkaUKorpi;

    @FindBy(xpath = "//button[@class='btn btn-success btn-login confirm-loader']")
    WebElement prijavaUKorpi;

    @FindBy(xpath = "//i[@class='icon icon-cash icon-4x']")
    WebElement placanjeKarticom;

    @FindBy(xpath = "//button[@id='submit_order_one_page']")
    WebElement potvrdiKupovinu;



    //Konstruktor
    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements ( driver, this );
    }

    //Metode
    public void clickNavigacionaListaObuca(){
        assert isElementPresent ( navigacionaListaObuca ):"Error. Navigaciona lista se ne prikazuje.";
        navigacionaListaObuca.click ();
        sleep ();
    }

    public void clickFilterVelicina25(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterVelicina25 );
        assert isElementPresent ( filterVelicina25 ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterVelicina25);
        sleep ();

    }

    public void clickFilterBrendNaturino(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", filterBrendNaturino );
        assert isElementPresent ( filterBrendNaturino ):"Error. Filter form is not present.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", filterBrendNaturino);
        sleep ();

    }

    public void clickOdabraneCipele(){
        assert isElementPresent ( odabraneCipele ):"Error. Artikal vise nije dostupan.";
        odabraneCipele.click ();
    }
    public void clickOdrediVelicinu25(){
        assert isElementPresent ( odrediVelicinu25 ):"Error. Velicina nije dostupna.";
        odrediVelicinu25.click ();
    }
    public void clickDodajUKorpu(){
        assert isElementPresent ( dodajUKorpu ):"Error. Dodaj u korpu button se ne prikazuje.";
        dodajUKorpu.click ();
    }
    public void clickIkonicaKorpa(){
        assert isElementPresent ( ikonicaKorpa ):"Error. Ikonica korpa se ne prikazuje.";

        //prelazak misem preko elementa da se pojavi podmeni
        Actions action = new Actions(driver);
        action.moveToElement(ikonicaKorpa).build().perform();

        mojaKorpa.click ();
    }

    public String getBrojNaIkoniciKorpa() {
        print("getBrojNaIkoniciKorpa");
        return brojNaIkoniciKorpa.getText();
    }

    public void  getItemNames() {
        List<WebElement> rowsList = tabelaUKorpi.findElements ( By.tagName ("tr"  ));

        List<WebElement> columnsList = null;

        for (WebElement row : rowsList) {
            System.out.println();
            columnsList = row.findElements(By.className ("cart-product"));
           // columnsList = row.findElements(By.tagName("td"));

            for (WebElement column : columnsList) {
                print (column.getText() + ",");
            }
        }
        //todo uradi asertaciju
    }
    public void clickPrijavaKorisnikaUKorpi(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", prijavaKorisnikaUKorpi );
        assert isElementPresent ( prijavaKorisnikaUKorpi ):"Error. Prijava u korpi nije moguca.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", prijavaKorisnikaUKorpi);
        sleep ();


    }
    public void unesiLoginEmailUKorpi(){
        assert isElementPresent ( loginEmailUKorpi ):"Error. Login Modal u korpi is not open.";
        loginEmailUKorpi.click ();
        loginEmailUKorpi.sendKeys ( Strings.LOGIN_EMAIL );
    }
    public void unesiLoginLozinkaUKorpi(){
        assert isElementPresent ( loginLozinkaUKorpi ):"Error. Login Modal u korpi is not open.";
        loginLozinkaUKorpi.click ();
        loginLozinkaUKorpi.sendKeys ( Strings.LOGIN_LOZINKA );
    }

    public void clickPrijavaUKorpi(){
        assert isElementPresent ( prijavaUKorpi ):"Error. Login Modal u korpi is not open.";
        prijavaUKorpi.click ();
    }
    public void prijavaKorisnikaZaKupovinuIzKorpe(){
        this.unesiLoginEmailUKorpi ();
        this.unesiLoginLozinkaUKorpi ();
        this.clickPrijavaUKorpi ();
        sleep ();
    }
    public void clickPlacanjeKarticom(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", placanjeKarticom );
        assert isElementPresent ( placanjeKarticom ):"Error. Placanje karticom nije opcija.";
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", placanjeKarticom);

    }
    public void daLiJeDugmePotvrdiKupovinuPrisutno(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript ( "arguments[0].scrollIntoView();", potvrdiKupovinu );

        assert isElementPresent ( potvrdiKupovinu ):"Error. Dugme Potvrdi kupovinu nije prisutno na stranici.";
    }


}
