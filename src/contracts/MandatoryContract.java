package contracts;

/**
 * Created by Tomasz on 18.05.2017.
 */
public class MandatoryContract extends Contract {

    public MandatoryContract(double podstawa) {
        super(podstawa);
        this.setUmowa("UMOWA-ZLECENIE");
        this.setProcentKosztowUzyskaniaPrzychodu(20);
    }
}
