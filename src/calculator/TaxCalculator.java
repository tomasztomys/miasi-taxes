package calculator;

import contracts.Contract;
import contracts.EmployeeContract;
import contracts.MandatoryContract;
import result.ConsolePrinter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaxCalculator {
	public static void main(String[] args) {
		double podstawa;
		char umowa;

		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("Podaj kwotę dochodu: ");	
			podstawa = Double.parseDouble(br.readLine());
			
			System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
			umowa = br.readLine().charAt(0);
			
		} catch (Exception ex) {
			System.out.println("Błędna kwota");
			System.err.println(ex);
			return;
		}


		if (umowa != 'P' && umowa != 'Z') {
			System.out.println("Nieznany typ umowy!");
			return;
		}

		Contract contract = null;
		if (umowa == 'P') {
			contract = new EmployeeContract(podstawa);
		} else if (umowa == 'Z') {
			contract = new MandatoryContract(podstawa);
		}

		contract.obliczWynagrodzenie();
		ConsolePrinter consolePrinter = new ConsolePrinter(contract);
		consolePrinter.wydrukujWynik();

	}


}
