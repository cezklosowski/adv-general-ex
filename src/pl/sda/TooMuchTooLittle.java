package pl.sda;

import java.util.Random;
import java.util.Scanner;

public class TooMuchTooLittle {
    /**
     * Gra w za dużo za mało przebiega następująco:
     * 1. Losowana jest liczba od 1-10 - zapamiętaj ją w zmiennej
     * 2. Gracz jest pytany: "Jaka to liczba?"
     * 3. Jeśli podana odpowiedź jest mniejsza od wylosowanej to gra wypisuje: "Za mało"
     * 4. Jeśli podana odpowiedź jest większa od wylosowanej to gra wypisuje: "Za dużo"
     * 5. Jeśli podana odpowiedź jest równa wylosowanej to gra wypisuje: "Gratulacje, wygrana!" i kończy grę.
     */
    public static void main(String[] args) {
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomNumber = r.nextInt(10) + 1;
        boolean win = false;
        do {
            System.out.println("Jaka to liczba? ");
            int number = scanner.nextInt();
            if (number > randomNumber) {
                System.out.println("Za dużo");
            }
            if (number < randomNumber) {
                System.out.println("Za mało");
            }
            if (number == randomNumber) {
                System.out.println("Gratulacje, wygrana!");
                win = true;
            }
        } while (!win);
    }
}
