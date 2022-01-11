import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest{

    @Test
    public void ubacivanjeArtiklaUKorpuIKupovina(){
        driver = openChromeDriver ();
        try {
            ShoppingPage shoppingPage = new ShoppingPage ( driver );
            shoppingPage.sleep ();
            shoppingPage.clickNavigacionaListaObuca ();
            shoppingPage.clickFilterVelicina25 ();
            shoppingPage.clickFilterBrendNaturino ();

            SearchPage searchPage=new SearchPage ( driver );
            searchPage.oznaciFilterPolZenski ();

            shoppingPage.clickOdabraneCipele ();



        }finally {
           // driver.quit ();
        }
    }


}
