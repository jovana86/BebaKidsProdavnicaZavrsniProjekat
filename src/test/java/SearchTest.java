import org.testng.annotations.Test;

public class SearchTest extends BaseTest{

    @Test
    public void pretraziSajt(){
        driver=openChromeDriver ();
        try {
            BasePage basePage=new BasePage ( driver );
            basePage.sleep ();
            basePage.clickSearchButton ();
            basePage.enterTextInSearchField ( "haljina" );

            assert isCurrentUrlEqualsTo ( "https://www.bebakids.com/proizvodi?search=haljina" ):"Error. Expected URL is https://www.bebakids.com/proizvodi?search=haljina" ;

            SearchPage searchPage = new SearchPage ( driver );

            searchPage.oznaciFilterPolZenskiVelicina4Cena3001Do3500 ();

            assert verifySearchItemIsShown ( "zenski" ,driver):"Error. Search item is not shown: " + "zenski";
            searchPage.sleep ();
            assert verifySearchItemIsShown ( "Reč ili fraza: haljina",driver ):"Error. Search item is not shown: " + "Reč ili fraza: haljina";
            searchPage.sleep ();

//            assert verifySearchItemIsShown ( "04",driver ):"Error. Search item is not shown: " + "04";
//            assert verifySearchItemIsShown ( "3.001 - 3.500 RSD",driver ):"Error. Search item is not shown: " + "3.001 - 3.500 RSD";






        }finally {
//            driver.quit ();
        }
    }

}
