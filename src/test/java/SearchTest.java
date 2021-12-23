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


//            List<WebElement> list= driver.findElements ( By.xpath ( "//div[@class='block products-listing product product-listing-items ']//div[@class='row']" ) );
 //          List<WebElement> list = driver.findElements ( By.className ( "item-data col-xs-12" ) );
//          //  List<WebElement> list = driver.findElements (By.xpath ( "//div[@class='item-data col-xs-12']" ));
//           // List<WebElement> list = driver.findElements (By.className ( "wrapper-grid-view item product-item ease col-xs-6 col-sm-4 col-md-3 col-lg-3 grid-view   appeared" ));
//            ArrayList<String> listaDobijenihProizvoda= new ArrayList<>();
 //          for (WebElement e: list){
//               String nazivProizvoda = e.findElement ( By.xpath ( "//div[@class='item-data col-xs-12']//div[@class='title']" ) ).getText ();
//               // String nazivProizvoda = e.findElement ( By.className ("title" )).getText ();
//                // String nazivProizvoda = e.findElement ( By.xpath ( "//div[@class='text-wrapper ']/div[@class='title']']" ) ).getText ();
//                listaDobijenihProizvoda.add ( nazivProizvoda );
//
 //              String vazecaCena = e.findElement ( By.xpath ( "//div[@class='item-data col-xs-12']//div[@class='prices-wrapper']" )).getText ();
//                //String vazecaCena = e.findElement ( By.name ( "Važeća MP cena" )).getText ();
//                String vazecaCena = e.findElement ( By.xpath ( "//div[@title='Važeća MP cena']" ) ).getText ();
//                listaDobijenihProizvoda.add ( vazecaCena );



 //               print ( "Vazeca cena za " + nazivProizvoda + "je " + vazecaCena  );
 //           }
            List<WebElement> unsortedList = driver.findElements (By.className ( "wrapper-grid-view item product-item ease col-xs-6 col-sm-4 col-md-3 col-lg-3 grid-view   appeared" ));
            ArrayList<String> unsortedArray = new ArrayList<> ();
            for (WebElement e: unsortedList){
                String itemName = e.findElement ( By.className ( "title" ) ).getText ();
                unsortedArray.add ( itemName );
                String price = e.findElement ( By.className ( "current-price " ) ).getText ();
                print ( "Cena za " + itemName + "je " + price );
            }
            searchPage.dropdownSortirajClick ();
            searchPage.dropdownSortirajNajjeftinijePrvoClick ();

        }finally {
//            driver.quit ();
        }
    }



}
