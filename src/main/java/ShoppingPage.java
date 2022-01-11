import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

}
