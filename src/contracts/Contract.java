package contracts;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Tomasz on 18.05.2017.
 */
@Getter
@Setter
public abstract class Contract {
    private double podstawa = 0;
    private String umowa = "";

    private double skladkaEmerytalna = 0;
    private double skladkaRentowa = 0;
    private double ubezpieczenieChorobowe = 0;

    private double kosztyUzyskania = 0;
    private double skladkaZdrowotnaOdWymiaru9 = 0;
    private double skladkaZdrowotnaOdWymiaru775 = 0;

    private double zaliczkaNaPodatekDochodowy = 0;
    private double kwotaZmniejszajacaPodatek = 0;
    private double zaliczkaUS = 0;
    private double zaliczkaUSZaokraglenie = 0;

    private double wynagrodzenie = 0;

    private double podatekPotracony = 0;
    private double obliczonaPodstawa = 0;

    private double podstawaOpodatkowania = 0;
    private double podstawaOpodatkowaniaZaokraglona = 0;

    private double procentKosztowUzyskaniaPrzychodu = 0;

    DecimalFormat dfSetne = new DecimalFormat("#.00");
    DecimalFormat dfCalkowite = new DecimalFormat("#");

    public Contract(double podstawa) {
        this.setPodstawa(podstawa);
    }

    public double obliczZaliczkeUS(double zaliczkaNaPodatekDochodowy, double skladkaZdrowotnaOdWymiaru775, double kwotaZmniejszajacaPodatek) {
        this.setZaliczkaUS(zaliczkaNaPodatekDochodowy - skladkaZdrowotnaOdWymiaru775 - kwotaZmniejszajacaPodatek);
        return this.getZaliczkaUS();
    }

    public double obliczZaliczkeNaPodatekDochodowy(double podstawa) {
        this.setZaliczkaNaPodatekDochodowy((podstawa * 18) / 100);
        return this.getZaliczkaNaPodatekDochodowy();
    }

    public double obliczonaPodstawa(double podstawa) {
        this.setSkladkaEmerytalna((podstawa * 9.76) / 100);
        this.setSkladkaRentowa((podstawa * 1.5) / 100);
        this.setUbezpieczenieChorobowe((podstawa * 2.45) / 100);
        this.setObliczonaPodstawa((podstawa - this.getSkladkaEmerytalna() - this.getSkladkaRentowa() - this.getUbezpieczenieChorobowe()));

        return this.getObliczonaPodstawa();
    }

    public Map<String, Double> obliczSkladkiZdrowotne(double podstawa) {
        this.setSkladkaZdrowotnaOdWymiaru9((podstawa * 9) / 100);
        this.setSkladkaZdrowotnaOdWymiaru775((podstawa * 7.75) / 100);


        Map<String, Double> skladkiZdrowotne = new HashMap<>();
        skladkiZdrowotne.put("skladkaZdrowotnaOdWymiaru9", this.getSkladkaZdrowotnaOdWymiaru9());
        skladkiZdrowotne.put("skladkaZdrowotnaOdWymiaru775", this.getSkladkaZdrowotnaOdWymiaru775());
        return skladkiZdrowotne;
    }

    public double obliczWynagrodzenie() {
        this.obliczonaPodstawa(this.getPodstawa());
        this.obliczSkladkiZdrowotne(this.getObliczonaPodstawa());
        this.setKosztyUzyskania((this.getObliczonaPodstawa() * this.getProcentKosztowUzyskaniaPrzychodu()) / 100 + this.getKosztyUzyskania());
        this.setPodstawaOpodatkowania(this.getObliczonaPodstawa() - this.getKosztyUzyskania());
        this.setPodstawaOpodatkowaniaZaokraglona(Double.parseDouble(dfCalkowite.format(this.getPodstawaOpodatkowania())));
        this.obliczZaliczkeNaPodatekDochodowy(this.getPodstawaOpodatkowaniaZaokraglona());
        this.setPodatekPotracony(this.getZaliczkaNaPodatekDochodowy() - this.getKwotaZmniejszajacaPodatek());
        this.obliczZaliczkeUS(this.getZaliczkaNaPodatekDochodowy(), this.getSkladkaZdrowotnaOdWymiaru775(), this.getKwotaZmniejszajacaPodatek());
        this.setZaliczkaUSZaokraglenie(Double.parseDouble(dfCalkowite.format(this.getZaliczkaUS())));
        this.setWynagrodzenie(this.getPodstawa() - ((this.getSkladkaEmerytalna() + this.getSkladkaRentowa() + this.getUbezpieczenieChorobowe()) + this.getSkladkaZdrowotnaOdWymiaru9() + this.getZaliczkaUSZaokraglenie()));

        return this.getWynagrodzenie();
    }
}
