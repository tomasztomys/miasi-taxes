package contracts;

/**
 * Created by Tomasz on 18.05.2017.
 */
public class EmployeeContract extends Contract {
    public EmployeeContract(double podstawa) {
        super(podstawa);
        this.setUmowa("UMOWA O PRACĘ");
        this.setKosztyUzyskania(111.25);
        this.setKwotaZmniejszajacaPodatek(46.33);
    }
}
