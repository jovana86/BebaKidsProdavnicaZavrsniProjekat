import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    /**
     * Registracija sa validnim podacima (zbog anti spam polja nije izvodljiva do kraja u Seleniumu,
     * pa se kao asertacija uzima error poruka anti spam polja)
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme REGISTRUJTE SE
     * 3. Kada se pojavi registracioni modal, popuniti validne podatke i checkirati polja
     * "Slazem se sa uslovima koriscenja" i
     * "Želim da postanem član Loyalty programa i ostvarim dodatne pogodnosti"
     * 4. Kliknuti dugme REGISTRACIJA
     *
     * Expected result:
     * 1. U okviru anti spam polja, pojavice se poruka "Ovo polje je obavezno."
     */

    @Test
    public void RegistracijaSaValidnimPodacimaTest(){
        driver=openChromeDriver ();

        try {
            print ( "Navigiraj na bebakids.com" );
            RegistrationPage registrationPage = new RegistrationPage ( driver );

            print ( "Unesi validne podatke u polja registracionog modala" );

            registrationPage.clickRegistracijaButton ();
            registrationPage.registracijaUnesiIme ();
            registrationPage.registracijaUnesiPrezime ();
            registrationPage.registracijaUnesiEmail ();
            registrationPage.registracijaUnesiTelefon ();
            registrationPage.registracijaUnesiGrad ();
            registrationPage.registracijaUnesiPostanskiBroj ();
            registrationPage.registracijaUnesiAdresu ();
            registrationPage.registracijaUnesiBrojUlice ();
            registrationPage.registracijaUnesiLozinku ();
            registrationPage.registracijaPonovoUnesiLozinku ();
            registrationPage.registracijaOznaciPolZenski ();
            registrationPage.registracijaOznaciSlazemSeSaUslovimaKoriscenja ();
           registrationPage.registracijaOznaciLoyaltyRequest ();

           print ( "Potvrdi registraciju i verifikuj error poruku u okviru polja anti spam" );
           registrationPage.registracijaPotvrdiRegistracijuButtonClick ();
           registrationPage.registracijaDaLiJeErrorMessagePrisutan ();

        }finally {
            driver.quit ();
        }
    }

    /**
     * Registracija sa nevalidnom Email adresom i svim ostalim validnim podacima
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme REGISTRUJTE SE
     * 3. Kada se pojavi registracioni modal, polje Email popuniti nevalidnim podacima, a sva ostala polja
     * popuniti validnim podacima i checkirati polja
     * "Slazem se sa uslovima koriscenja"
     * 4. Kliknuti dugme REGISTRACIJA
     *
     * Expected result:
     * 1. U okviru anti spam polja, pojavice se poruka "Ovo polje je obavezno."
     * 2. U okviru Email polja, pojavice se poruka "Unesite validan email."
     */

    @Test
    public void registracijaSaNevalidnomEmailAdresomTest(){
        driver = openChromeDriver ();
        try {
            print ( "Navigiraj na bebakids.com" );
            RegistrationPage registrationPage = new RegistrationPage ( driver );

            print ( "Unesi nevalidnu Email adresu i sve ostale validne podatke u registracioni modal" );
            registrationPage.clickRegistracijaButton ();
            registrationPage.registracijaUnesiIme ();
            registrationPage.registracijaUnesiPrezime ();
            registrationPage.registracijaUnesiNevalidniEmail ();
            registrationPage.registracijaUnesiTelefon ();
            registrationPage.registracijaUnesiGrad ();
            registrationPage.registracijaUnesiPostanskiBroj ();
            registrationPage.registracijaUnesiAdresu ();
            registrationPage.registracijaUnesiBrojUlice ();
            registrationPage.registracijaUnesiLozinku ();
            registrationPage.registracijaPonovoUnesiLozinku ();
            registrationPage.registracijaOznaciPolZenski ();
            registrationPage.registracijaOznaciSlazemSeSaUslovimaKoriscenja ();
            registrationPage.registracijaPotvrdiRegistracijuButtonClick ();

            print ( "Potvrdi registraciju i verifikuj error poruku u okviru polja anti spam i error poruku u okviru polja Email adresa" );
            registrationPage.registracijaDaLiJeErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJeEmailErrorMessagePrisutan ();


        }finally {
            driver.quit ();
        }

    }

    /**
     * Registracija sa nevalidnom Brojem telefona,lozinkom sa manje od 6 karaktera  i ostalim validnim pdoacima
     *
     * Test steps:
     * 1. Navigiraj na bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme REGISTRUJTE SE
     * 3. Kada se pojavi registracioni modal, polje Broj telefona popuniti slovima,polje lozinka i
     * polje ponovi lozinku popuniti lozinkom koja sadrzi manje od sest karaktera.
     * Ostala polja popuniti validno i checkirati polja
     * "Slazem se sa uslovima koriscenja" i
     * "Želim da postanem član Loyalty programa i ostvarim dodatne pogodnosti"
     * 4. Kliknuti dugme REGISTRACIJA
     *
     * Expected result:
     * 1. U okviru anti spam polja, pojavice se poruka "Ovo polje je obavezno."
     * 2. U okviru polja Broj telefona pojavice se poruka "Ovo polje nije validno."
     * 3. U okviru polja lozinka pojavice se poruka "Ovo polje sadrži manje od 6 karaktera."
     */

    @Test
    public void registracijaSaNevalidnimBrojemTelefonaILozinkomSaManjeOd6KarakteraTest(){
        driver = openChromeDriver ();

        try {
            print ( "Navigiraj na bebakids.com" );
            RegistrationPage registrationPage = new RegistrationPage ( driver );

            print ( "Unesi nevalidni Broj Telefona, do 6 karaktera Lozinku i Ponovnu Lozinku i sve ostale validne podatke u registracioni modal" );
            registrationPage.clickRegistracijaButton ();
            registrationPage.registracijaUnesiIme ();
            registrationPage.registracijaUnesiPrezime ();
            registrationPage.registracijaUnesiEmail ();
            registrationPage.registracijaUnesiNevalidniBrojTelefona ();
            registrationPage.registracijaUnesiGrad ();
            registrationPage.registracijaUnesiPostanskiBroj ();
            registrationPage.registracijaUnesiAdresu ();
            registrationPage.registracijaUnesiBrojUlice ();
            registrationPage.registracijaUnesiDo6KarakteraLozinku ();
            registrationPage.registracijaPonovoUnesiDo6KarakteraLozinku ();
            registrationPage.registracijaOznaciPolZenski ();
            registrationPage.registracijaOznaciSlazemSeSaUslovimaKoriscenja ();
            registrationPage.registracijaOznaciLoyaltyRequest ();
            registrationPage.registracijaPotvrdiRegistracijuButtonClick ();

            print ( "Potvrdi registraciju i verifikuj error poruke u okviru sledecih polja: anti spam, Broj Telefona i Lozinka" );
            registrationPage.registracijaDaLiJeErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJeTelefonErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJeLozinkaDo6KarakteraErrorMessagePrisutan ();

        }finally {
            driver.quit ();
        }
    }

    /**
     * Registracija sa pogresnim Postanskim brojem i njegove error poruke
     *
     * Test steps:
     * 1. Navigate to bebakids.com
     * 2. U gornjem desnom delu headera klikni dugme REGISTRUJTE SE
     * 3. Kada se pojavi registracioni modal, polje Postanski broj popuniti sa vise ili manje od 5 cifara,
     * preci na sledece polje
     * Expected result:
     *  U okviru polja Postanski broj pojavice se poruka "Dužina ovog polja mora biti 5 karaktera."
     *
     * 4. Vratiti se na polje Postanski broj, obrisati postojece i
     * popuniti sa 5 nevalidnih karaktera(kombinacija slova i brojeva), preci na sledece polje za popunjavanje
     *
     *  Expected result:
     *   U okviru polja Postanski broj pojavice se poruka "Ovo polje nije validno."
     *
     *  5. Vratiti se na polje Postanski broj i popuniti ga validnim podacima
     *  6. Ostala polja popuniti validno i checkirati polja

     *
     * 7. Kliknuti dugme REGISTRACIJA
     *
     * Expected result:
     * 1. U okviru anti spam polja, pojavice se poruka "Ovo polje je obavezno."
     * 2. U okviru polja check box Potvrdi uslove koriscenje pojavice se poruka "Ovo polje je obavezno."

     */

    @Test
    public void registracijaSaPogresnimPostanskimBrojemINjegoveErrorPoruke(){
        driver = openChromeDriver ();
        try {
            print ( "Navigiraj na bebakids.com" );
            RegistrationPage registrationPage = new RegistrationPage ( driver );

            print ( "Unesi validne podatke Ime,Prezime,Email,Telefon,Grad,Adresu,Broj Ulice,Lozinku u registracioni modal" );
            registrationPage.clickRegistracijaButton ();
            registrationPage.registracijaUnesiIme ();
            registrationPage.registracijaUnesiPrezime ();
            registrationPage.registracijaUnesiEmail ();
            registrationPage.registracijaUnesiTelefon ();
            registrationPage.registracijaUnesiGrad ();
            registrationPage.registracijaNevalidanPostanskiBrojIErrorPoruke ();
//            registrationPage.registracijaPostanskiBrojSa5NevalidnihKaraktera ();
            registrationPage.registracijaUnesiAdresu ();
//            registrationPage.registracijaDaLiJePostanskiBrojSa5NevalidnihKarakteraErrorMessagePrisutan ();
            registrationPage.registracijaUnesiBrojUlice ();
            registrationPage.registracijaUnesiLozinku ();
            registrationPage.registracijaPonovoUnesiLozinku ();
            registrationPage.registracijaOznaciPolZenski ();

            print ( "Potvrdi registraciju i verifikuj error poruku u polju anti spam i kod check box polja Potvrdi uslove koriscenja " );
            registrationPage.registracijaPotvrdiRegistracijuButtonClick ();
            registrationPage.registracijaDaLiJeErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJePotvrdiUsloveErrorMessagePrisutan ();



        }finally {
            driver.quit ();
        }
    }

}
