import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SearchTest extends BaseTest{

    /**
     * Ukucaj zeljeni artikal u Pretragu i filtriraj
     *
     * Test steps:
     * 1. Navigate to bebakids.com
     * 2. Unesi zeljeni proizvod u polje za pretragu i klikni Enter
     * 3. Filtriraj dobijeni rezultat u meniju sa leve strane
     * 4. Izaberi opcije pol Zenski, velicina 4, raspon cene 3001-3500
     *
     * Expected result:
     * 4. Verifikuj da su prikazani filteri u blok tagu
     *
     *      **/


    @Test
    public void ukucajZeljeniArtikalUPretraguIFiltriraj(){
        driver=openChromeDriver ();
        try {
            print ( "Navigiraj na bebakids.com" );
            BasePage basePage=new BasePage ( driver );
            basePage.sleep ();
            print ( "Klikni na pretragu i unesi artikal" );
            basePage.clickSearchButton ();
            basePage.enterTextInSearchField ( "haljina" );

            print ( "Verifikuj da je URL https://www.bebakids.com/proizvodi?search=haljina" );
            assert isCurrentUrlEqualsTo ( "https://www.bebakids.com/proizvodi?search=haljina" ):"Error. Expected URL is https://www.bebakids.com/proizvodi?search=haljina" ;

            SearchPage searchPage = new SearchPage ( driver );

            print ( "U levom delu ekrana oznaci filtere: pol zenski, velicina 4 i cena od 2501 do 3000 RSD" );
            searchPage.oznaciFilterPolZenskiVelicina4Cena3001Do3500 ();

            print ( "Verifikuj da su svi filteri prikazani u blok tagu" );
            searchPage.daLiSuSviFilteriOznaceniUBlokTagu ();


        }finally {
            driver.quit ();
        }
    }

    @Test
    public void ukucajZeljeniArtikalUpretraguISortiraj(){
        driver = openChromeDriver ();
        try {
            print ( "Navigiraj na bebakids.com" );
            BasePage basePage=new BasePage ( driver );
            basePage.sleep ();
            print ( "Klikni na pretragu i unesi artikal" );
            basePage.clickSearchButton ();
            basePage.enterTextInSearchField ( "haljina" );

            print ( "Verifikuj da je URL https://www.bebakids.com/proizvodi?search=haljina" );
            assert isCurrentUrlEqualsTo ( "https://www.bebakids.com/proizvodi?search=haljina" ):"Error. Expected URL is https://www.bebakids.com/proizvodi?search=haljina" ;

//
            SearchPage searchPage = new SearchPage ( driver );
            searchPage.oznaciFilterVelicina4 ();
//            searchPage.dropdownSortirajClick ();
//            searchPage.dropdownSortirajPoNazivu ();

            List<WebElement> unsortedList = driver.findElements(By.xpath ("//div[@class='block products-listing product product-listing-items ']"));
            ArrayList<String> unsortedArray= new ArrayList<>();
            //sa for petljom prolazim kroz sve elemente i stampam
            for(WebElement e : unsortedList) {
                //ovde koristim findElement nad webelementom (ne driverom)
                String itemName = e.findElement(By.xpath ("//div[@class='block products-listing product product-listing-items ']//div[@class='title']")).getText();
                //dodajem ime itema u niz
                unsortedArray.add(itemName);
                String price = e.findElement(By.xpath ("//div[@class='block products-listing product product-listing-items ']//div[@class='prices-wrapper']")).getText();
                System.out.println("Cena za  " + itemName + " je " + price);
            }
//            Select dropDown = new Select(driver.findElement(By.id ( "sort" )));
//            dropDown.selectByVisibleText("Po nazivu");

        }finally {
//            driver.quit ();
        }
    }



}
