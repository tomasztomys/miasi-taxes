package result;

import contracts.Contract;

import java.text.DecimalFormat;

/**
 * Created by Tomasz on 18.05.2017.
 */
public abstract class Printer {
    protected Contract contract;

    protected DecimalFormat dfSetne = new DecimalFormat("#.00");
    protected DecimalFormat dfCalkowite = new DecimalFormat("#");

    public Printer(Contract contract) {
        this.contract = contract;
    }
}
