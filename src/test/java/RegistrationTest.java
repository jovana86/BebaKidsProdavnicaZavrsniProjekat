import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test
    public void RegistracijaSaValidnimPodacimaTest(){
        driver=openChromeDriver ();

        try {

            RegistrationPage registrationPage = new RegistrationPage ( driver );

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
           registrationPage.registracijaPotvrdiRegistracijuButtonClick ();
           registrationPage.registracijaDaLiJeErrorMessagePrisutan ();





//todo uradi asert za negativan scenario



        }finally {
            driver.quit ();
        }
    }

    @Test
    public void registracijaSaNevalidnomEmailAdresomTest(){
        driver = openChromeDriver ();
        try {
            RegistrationPage registrationPage = new RegistrationPage ( driver );

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
            registrationPage.registracijaDaLiJeErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJeEmailErrorMessagePrisutan ();


        }finally {
            driver.quit ();
        }

    }

    @Test
    public void registracijaSaNevalidnimBrojemTelefonaILozinkomSaManjeOd6KarakteraTest(){
        driver = openChromeDriver ();

        try {
            RegistrationPage registrationPage = new RegistrationPage ( driver );

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
            registrationPage.registracijaDaLiJeErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJeTelefonErrorMessagePrisutan ();
            registrationPage.registracijaDaLiJeLozinkaDo6KarakteraErrorMessagePrisutan ();

        }finally {
            driver.quit ();
        }
    }

    @Test
    public void registracijaSaPogresnimPostanskimBrojemINjegoveErrorPoruke(){
        driver = openChromeDriver ();
        try {
            RegistrationPage registrationPage = new RegistrationPage ( driver );

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
            registrationPage.registracijaOznaciSlazemSeSaUslovimaKoriscenja ();
            registrationPage.registracijaOznaciLoyaltyRequest ();
            registrationPage.registracijaPotvrdiRegistracijuButtonClick ();
            registrationPage.registracijaDaLiJeErrorMessagePrisutan ();



        }finally {
//            driver.quit ();
        }
    }
}
