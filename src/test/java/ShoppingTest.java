import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ShoppingTest extends BaseTest{

    /**
     * Pretraga iz navigacione liste, filtriranje, odabir, dodavanje u korpu i
     * kupovina uz prijavu na korisnicki nalog
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U navigacionom meniju u header delu stranice odaberi opciju Obuca i klikni
     * 3. Filtriraj rezultat u meniju sa leve strane: velicina 25, brend Naturino i pol Zenski
     * 4. Klik na odabrane cipele, potom markiraj velicinu 25 i dodaj u korpu
     * 5. Udji u korpu i proveri da li je zeljeni artikal u korpi
     * 6. Prijavi se kao postojeci korisnik iz korpe
     * 7. Odaberi opciju placanje karticom
     *
     *
     * Expected results
     * 3. Verifikuj da su odabrani filteri u blok tagu //todo
     * 5. Verifikuj da se broj artikala na ikonici korpa promenio u 1
     * 5. Verifikuj da je zeljeni artikal isti kao onaj koji smo uneli u korpu //todo
     * 8. Verifikuj da je prisutno dugme potvrdi kupovinu
     */

    @Test
    public void pretragaIzNavigacioneListeFiltriranjeOdabirIKupovinaArtikla(){
        driver = openChromeDriver ();
        try {
            print ( "Navigiraj na bebakids.com" );
            ShoppingPage shoppingPage = new ShoppingPage ( driver );
            shoppingPage.sleep ();

            print ( "U navigacionoj listi odaberi opciju Obuca i klikni" );
            shoppingPage.clickNavigacionaListaObuca ();

            print ( "Filtriraj rezultat u meniju sa leve strane: velicina 25, Brend Naturino i pol Zenski");
            shoppingPage.clickFilterVelicina25 ();
            shoppingPage.clickFilterBrendNaturino ();

            SearchPage searchPage=new SearchPage ( driver );
            searchPage.oznaciFilterPolZenski ();

            print ( "Klikni ns zeljene cipele, potom markiraj velicinu 25 i dodaj artikal u korpu" );
            shoppingPage.clickOdabraneCipele ();
            shoppingPage.clickOdrediVelicinu25 ();
            shoppingPage.clickDodajUKorpu ();
            shoppingPage.sleep ();

            print ( "Verifikuj da je boj na ikonici korpa 1" );
            String brojArtikalaUKorpi = shoppingPage.getBrojNaIkoniciKorpa ();
            assert brojArtikalaUKorpi.equals("1") : "Error. Broj artikala u korpi nije odgovarajuci.";

            print ( "Klikni na ikonicu korpa i verifikuj da je u njoj odabrani artikal" );
            shoppingPage.clickIkonicaKorpa ();
            shoppingPage.sleep ();

            shoppingPage.getItemNames ();

            print ( "U korpi izaberi opciju prijava i prijavi se kao postojeci korisnik" );
            shoppingPage.clickPrijavaKorisnikaUKorpi ();
            shoppingPage.prijavaKorisnikaZaKupovinuIzKorpe ();

            print ( "Odaberi opciju placanje karticom" );
            shoppingPage.clickPlacanjeKarticom ();

            print ( "Verifikuj da je dugme Potvrdi prisutno" );
            shoppingPage.daLiJeDugmePotvrdiKupovinuPrisutno ();







            //todo uradi asertaciju da se artikal sa tim nazivom nalazi u korpi i ispisi test case i prints

            //todo iskoristi ovaj princip za search test




        }finally {
           // driver.quit ();
        }
    }


}
