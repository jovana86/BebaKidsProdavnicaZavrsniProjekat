import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest{

    @Test
    public void RegistracijaSaValidnimPodacima(){
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
//            driver.quit ();
        }
    }
}
