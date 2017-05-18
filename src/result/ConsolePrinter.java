package result;

import contracts.Contract;

/**
 * Created by Tomasz on 18.05.2017.
 */
public class ConsolePrinter extends Printer {
    public ConsolePrinter(Contract contract) {
        super(contract);
    }

    public void wydrukujWynik() {
        System.out.println(contract.getUmowa());
        System.out.println("Podstawa wymiaru składek " + contract.getPodstawa());
        System.out.println("Składka na ubezpieczenie emerytalne "
                + dfSetne.format(contract.getSkladkaEmerytalna()));
        System.out.println("Składka na ubezpieczenie rentowe    "
                + dfSetne.format(contract.getSkladkaRentowa()));
        System.out.println("Składka na ubezpieczenie chorobowe  "
                + dfSetne.format(contract.getUbezpieczenieChorobowe()));
        System.out
                .println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                        + contract.getObliczonaPodstawa());
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
                + dfSetne.format(contract.getSkladkaZdrowotnaOdWymiaru9()) + " 7,75% = " + dfSetne.format(contract.getSkladkaZdrowotnaOdWymiaru775()));
        System.out.println("Koszty uzyskania przychodu w stałej wysokości " + contract.getKosztyUzyskania()); //DIFF
        System.out.println("Podstawa opodatkowania " + contract.getPodstawaOpodatkowania()
                + " zaokrąglona " + dfCalkowite.format(contract.getPodstawaOpodatkowaniaZaokraglona()));
        System.out.println("Zaliczka na podatek dochodowy 18 % = "
                + contract.getZaliczkaNaPodatekDochodowy());
        System.out.println("Kwota wolna od podatku = " + contract.getKwotaZmniejszajacaPodatek());
        System.out.println("Podatek potrącony = "
                + dfSetne.format(contract.getPodatekPotracony()));
        System.out.println("Zaliczka do urzędu skarbowego = "
                + dfSetne.format(contract.getZaliczkaUS()) + " po zaokrągleniu = "
                + dfCalkowite.format(contract.getZaliczkaUSZaokraglenie()));
        System.out.println();
        System.out
                .println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                        + dfSetne.format(contract.getWynagrodzenie()));
    }
}
