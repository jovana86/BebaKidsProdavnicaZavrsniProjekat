import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    /**
     * Prijava na stranicu sa validnim kredencijalima
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme PRIJAVITE SE
     * 3. Kada se pojavi modal za prijavu, polje Email i Lozinka popuniti validnim podacima

     * 4. Kliknuti dugme PRIJAVA
     *
     * Expected result:
     * 1. Na stranici su sada prisutni profil korisnika, postani Vip i Odjava
     */

    @Test
    public void prijavaSaValidnimKredencijalimaTest(){
        driver = openChromeDriver ();

        try {
            print ( "Navigiraj na bebakids.com" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "Unesi validne kredencijale, Email i Lozinku i klikni Prijava" );
            loginPage.prijaviteSeButtonClick ();
            loginPage.unesiLoginEmail ();
            loginPage.unesiLoginLozinka ();

            print ( "Potvrdi prijavu na sajt i verifikuj da su na stranici prisutni profil Korisnika," +
                    " postani VIP i Odjava" );
            loginPage.loginPrijavaClick ();
            loginPage.sleep ();

            loginPage.postaniVipPrisutanNaStranici ();
            loginPage.odjavaSaProfilaPrisutnaNaStranici ();
            loginPage.profilKorisnikaPrisutanNaStranici ();



        }finally {
            driver.quit ();
        }
    }

    /**
     * Prijava na stranicu sa nevalidnim kredencijalima
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme PRIJAVITE SE
     * 3. Kada se pojavi modal za prijavu, polje Email i Lozinka popuniti nevalidnim podacima
     * iz dela za nevalidnu Registraciju

     * 4. Kliknuti dugme PRIJAVA
     *
     * Expected result:
     * 1. Error poruka ispod polja Email: "Unesite validan email."
     */
    @Test
    public void prijavaSaNevalidnimKredencijalimaTest(){
        driver = openChromeDriver ();

        try {
            print ( "Navigiraj na bebakids.com" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "Unesi nevalidne kredencijale" );
            loginPage.prijaviteSeButtonClick ();
            loginPage.unesiNevalidanEmail ();
            loginPage.unesiNevalidnuLozinku ();

            print ( "Potvrdi prijavu na sajt i verifikuj error poruku" );
            loginPage.loginPrijavaClick ();
            loginPage.daLiJePrisutnaErrorPorukaZaPrijavuSaNevalidnimKredencijalima ();



        }finally {
            driver.quit ();
        }

    }

    /**
     * Prijava na stranicu sa nevalidnim kredencijalima
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme PRIJAVITE SE
     * 3. Kada se pojavi modal za prijavu, polje Email popuniti validno, polje Lozinka popuniti nevalidnim podacima
     * iz dela za nevalidnu Registraciju

     * 4. Kliknuti dugme PRIJAVA
     *
     * Expected result:
     * 1. Error Alert: "Pogrešna email adresa ili lozinka. Molimo Vas pokušajte ponovo!"
     */

    @Test
    public void prijavaSaValidnomEmailAdresomINevalidnomLozinkom(){
        driver = openChromeDriver ();
        try {
            print ( "Navigiraj na bebakids.com" );
            LoginPage loginPage = new LoginPage ( driver );

            print ( "Unesi validan Email i nevalidnu Lozinku " );
            loginPage.prijaviteSeButtonClick ();
            loginPage.unesiLoginEmail ();
            loginPage.unesiNevalidnuLozinku ();

            print ( "Potvrdi prijavu na sajt i verifikuj error alert" );
            loginPage.loginPrijavaClick ();
            loginPage.sleep ();
            loginPage.daLiJeErrorAlertPrisutan ();

        }finally {
            driver.quit ();
        }
    }

//    @Test
//    public void prijavaBezKredencijalaTest(){
//        driver = openChromeDriver ();
//        try {
//            print ( "Navigiraj na bebakids.com" );
//            LoginPage loginPage = new LoginPage ( driver );
//
//            print ( "Bez unosa kredencijala potvrdi prijavu" );
//            loginPage.prijaviteSeButtonClick ();
//            loginPage.loginPrijavaClick ();
//
//
//            loginPage.daLiJePrisutnaErrorPorukaZaPrijavuBezEmailAdrese ();
//            loginPage.daLiJePrisutnaErrorPorukaZaPrijavuBezLozinke ();
//
//
//
//        }finally {
//            driver.quit ();
//        }
//    }

}
