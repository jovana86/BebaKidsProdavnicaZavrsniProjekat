import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends BaseTest{

    /**
     * Search for item and clicking on it
     *
     * Test steps:
     * 1. Navigate to bebakids.com
     * 2. Unesi zeljeni proizvod u polje za pretragu i klikni Enter
     * 3. Filtriraj dobijeni rezultat u meniju sa leve strane
     * 4. Izaberi opcije pol Zenski, velicina 4, raspon cene 3001-3500
     *      * 5. From search results find that item and click on it //todo
     *      *
     * Expected result:
     * 4. Verifikuj da su prikazani filteri u blok tagu
     *      **/


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


           searchPage.daLiJePolZenskiOznacenUBlokTagu ();
           searchPage.daLiJeHaljinaOznacenaUBlokTagu ();
           searchPage.daLiJeVelicina04UBlokTagu ();
           searchPage.daLiJeCena2501Do3000UBlokTagu ();

                 //todo izvuci listu dobijenih artikala



            searchPage.dropdownSortirajClick ();
            searchPage.dropdownSortirajNajjeftinijePrvoClick ();

        }finally {
            driver.quit ();
        }
    }



}
