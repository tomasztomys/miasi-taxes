package contracts;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomasz on 19.05.2017.
 */
public class MandatoryContractTest {
    private final static double podstawa = 2000.0;
    private MandatoryContract contract;

    @Before
    public void setUp() {
        contract = new MandatoryContract(podstawa);
    }

    @Test
    public void obliczWynagrodzenie() {
        double wynagrodzenie = contract.obliczWynagrodzenie();
        assertEquals(1455.48, wynagrodzenie, 0.1);
    }

    @Test
    public void obliczZaliczkeUS() {
        contract.obliczWynagrodzenie();
        double zaliczkaUS = contract.obliczZaliczkeUS(2000,200,200);

        assertEquals(1600.0, zaliczkaUS, 0.1);
    }

    @Test
    public void obliczZaliczkeNaPodatekDochodowy() {
        double zaliczkaNaPodatekDochodowy = contract.obliczZaliczkeNaPodatekDochodowy(podstawa);

        assertEquals(360.0, zaliczkaNaPodatekDochodowy, 0.1);
    }


    @Test
    public void obliczonaPodstawa() {
        double obliczonaPodstawa = contract.obliczonaPodstawa(podstawa);

        assertEquals(1725.8, obliczonaPodstawa, 0.1);
    }


    @Test
    public void obliczSkladkiZdrowotne() {
        contract.obliczWynagrodzenie();
        Map<String, Double> skladkiZdrowotne = contract.obliczSkladkiZdrowotne(podstawa);

        assertEquals(180.0, skladkiZdrowotne.get("skladkaZdrowotnaOdWymiaru9"), 0.1);
        assertEquals(155.0, skladkiZdrowotne.get("skladkaZdrowotnaOdWymiaru775"), 0.1);
    }
}
