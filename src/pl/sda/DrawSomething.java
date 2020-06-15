package pl.sda;

import java.util.Scanner;

public class DrawSomething {

    /**
     * 1. Narysuj prostokąt ze znaków *
     * 2. Zamiast rysować pełny prostokąt rysuj pusty w środku prostokąt (wypełniony spacjami)
     * 3. Daj użytkownikowi możliwość podania wymiarów prostokąta
     * 4. Przenieś kod do rysowania prostokąta do funkcji drawRectangle(int a, int b) - gdzie a i b to długości boków
     * 5. Stwórz dedykowaną metodę do rysowania kwadratu - powinna tylko wykorzystywać metodę drawRectangle
     * 6. Do sygnatury metody dodaj argument typu boolean isChessboardFill - sygnatura powinna wyglądać mniej więcej tak:
     * drawRectangle(int a, int b, boolean isChessboardFill)
     * jeśli isChessboardFill jest ustawione na true to wypełnij prostokąt szachownicą, jeśli nie samymi spacjami
     * 7. Narysuj trójkąt prostokątny wypełniony szachownicą i umieść kod do rysowania go w metodzie drawChessboardFillTriangle(int a, int h)
     * 8. Narysuj choinkę :)
     **/
    /**
     * Prostokąt 5 na 5:
     * *****
     * *****
     * *****
     * *****
     * *****
     * Pusty prostokąt 5 na 5:
     * *****
     * *   *
     * *   *
     * *   *
     * *****
     * Prostokąt wypełniony szachownicą (6 na 9):
     * *********
     * ** * * **
     * * * * * *
     * ** * * **
     * * * * * *
     * *********
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj wymiary prostokąta");
        System.out.println("Bok a: ");
        int a = scanner.nextInt();
        System.out.println("Bok b: ");
        int b = scanner.nextInt();
        drawRectangle(a, b, true);
        System.out.println();

        System.out.println("Podaj bok kwadratu");
        System.out.println("Bok: ");
        int c = scanner.nextInt();
        drawSquare(c);




        drawChessboardFillTriangle(5,8);
    }

    public static void drawRectangle(int a, int b, boolean isChessboardFill) {
        for (int i = 0; i < b; i++) {
            System.out.print("*");
        }
        System.out.print("\n");

        if (isChessboardFill) {
            boolean flag = true;
            for (int i = 0; i < a - 2; i++) {
                System.out.print("*");
                for (int j = 0; j < b - 2; j++) {
                    if (flag) {
                        System.out.print("*");
                        flag = !flag;
                    } else {
                        System.out.print(" ");
                        flag = !flag;
                    }
                }
                System.out.print("*");
                System.out.print("\n");
                flag = !flag;
            }

        } else {
            for (int i = 0; i < a - 2; i++) {
                System.out.print("*");
                for (int j = 0; j < b - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.print("\n");
            }
        }

        for (int i = 0; i < b; i++) {
            System.out.print("*");
        }
        System.out.print("\n");
    }

    public static void drawSquare(int a) {
        drawRectangle(a, a, false);
    }

    public static void drawChessboardFillTriangle(int a, int h){

        // Nie wiem jak narysować trójkąt prostokątny inny niż równoramienny :(

    }
}
