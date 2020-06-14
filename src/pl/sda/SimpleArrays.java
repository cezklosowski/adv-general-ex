package pl.sda;

import java.util.Arrays;

public class SimpleArrays {

    /**
     * 1. Stwórz metodę getDistinct, która przyjmuje w parametrze tablicę i zwraca inną tablicę (nie modyfikuje tamtej!) natomiast bez powtórzeń.
     * 2. Stwórz metodę getLarger(int tab1[], int tab2[]), która zsumuje osobno obie tablice i zwróci tą, która jest większa.
     */
    public static void main(String[] args) {
        int[] tab = {1,2,3,3,4,7,8,8,6,5,5,5,9};
        int[] tab2 = getDistinct(tab);
        printTab(tab);
        printTab(tab2);
    }

    public static int[] getDistinct (int[] tab){
        int[] tabWithoutRepetition = new int[tab.length];
        int tabWithoutRepetitionIndex = 0;
        boolean repeat = false;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tabWithoutRepetitionIndex; j++) {
                if (tabWithoutRepetition[j] == tab[i]){
                    repeat = true;
                    break;
                }
            }
            if (!repeat) {
                tabWithoutRepetition[tabWithoutRepetitionIndex++] = tab[i];
            }
            repeat = false;
        }
        tabWithoutRepetition = Arrays.copyOf(tabWithoutRepetition,tabWithoutRepetitionIndex);
        return tabWithoutRepetition;
    }

    public static void printTab (int[] tab){
        for (int i = 0; i < tab.length - 1; i++) {
            System.out.print(tab[i] + ", ");
        }
        System.out.println(tab[tab.length-1]);
    }
}
