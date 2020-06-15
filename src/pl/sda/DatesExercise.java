package pl.sda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

public class DatesExercise {
    /**
     * 1. Napisz funkcję mapToDate(String date), która dostanie jako parametr date w formacie dd.MM.yyyy i zwroci LocalDate
     * 2. Napisz funkcję mapToDateTime(String dateTime), która dostanie jako parametr date w formacie dd.MM.yyyy HH:mm i zwroci LocalDateTime
     * 3. Napisz funkcje isMondayToday(LocalDate day), która sprawdzi czy podany dzień to poniedziałek
     * 4. Napisz funkcję howLongAgoWasTheBattle(), która sprawdzi jak dawno była bitwa pod grunwaldem - powinna zwrócić ilość dni (int)
     * 5. Napisz funkcję scanIfAdult(), która poprosi o wprowadzenie daty urodzin i jeśli osoba jest pełnoletnia zwróci true, a jeśli nie false
     * 6. Napisz funkcję dayOfTheWeek100DaysAgo(), która sprawdzi jaki dzień tygodnia był 100 dni temu
     */
    public static void main(String[] args) {
        // 1.
        LocalDate newDate = mapToDate("12.03.2012");
        System.out.println(newDate);
        // 2.
        System.out.println(mapToDateTime("12.03.2012 12:25"));
        // 3.
        if (isMondayToday(newDate)) {
            System.out.println("Tak, " + newDate + " to poniedziałek.");
        } else {
            System.out.println("Nie, " + newDate + " to nie poniedziałek.");
        }
        // 4.
        System.out.println("Bitwa pod Grunwaldem odbyła się " + howLongAgoWasTheBattle() + " dni temu.");
        // 5.
        if(scanIfAdult()){
            System.out.println("Jesteś pełnoletni.");
        } else {
            System.out.println("Nie jesteś pełnoletni.");
        }
        // 6.
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.MONDAY) System.out.println("Sto dni temu był poniedziałek.");
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.TUESDAY) System.out.println("Sto dni temu był wtorek.");
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.WEDNESDAY) System.out.println("Sto dni temu była środa.");
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.THURSDAY) System.out.println("Sto dni temu był czwartek.");
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.FRIDAY) System.out.println("Sto dni temu był piątek.");
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.SATURDAY) System.out.println("Sto dni temu była sobota.");
        if(dayOfTheWeek100DaysAgo()==DayOfWeek.SUNDAY) System.out.println("Sto dni temu była niedziela.");

    }

    public static LocalDate mapToDate(String date) {
        String[] dateSplitString = date.split("\\.");
        int[] dateSplitInt = new int[dateSplitString.length];
        for (int i = 0; i < dateSplitInt.length; i++) {
            dateSplitInt[i] = Integer.parseInt(dateSplitString[i]);
        }
        return LocalDate.of(dateSplitInt[2], dateSplitInt[1], dateSplitInt[0]);
    }

    public static LocalDateTime mapToDateTime(String dateTime) {
        String[] dateSplitString = dateTime.split("[. :]");
        int[] dateSplitInt = new int[dateSplitString.length];
        for (int i = 0; i < dateSplitInt.length; i++) {
            dateSplitInt[i] = Integer.parseInt(dateSplitString[i]);
        }
        return LocalDateTime.of(dateSplitInt[2], dateSplitInt[1], dateSplitInt[0], dateSplitInt[3], dateSplitInt[4]);
    }

    public static boolean isMondayToday(LocalDate day) {
        return day.getDayOfWeek() == DayOfWeek.MONDAY;
    }

    public static int howLongAgoWasTheBattle() {
        LocalDate now = LocalDate.now();
        LocalDate battle = LocalDate.of(1410, 7, 15);
        return (int) DAYS.between(battle, now);
    }

    public static boolean scanIfAdult(){
        final int adultAge = 18;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź datę urodzenia (dd.mm.rrrr): ");
        String dateString = scanner.nextLine();
        LocalDate birthDate = mapToDate(dateString);
        return YEARS.between(birthDate,LocalDate.now()) >= adultAge;
    }

    public static DayOfWeek dayOfTheWeek100DaysAgo(){
        LocalDate now = LocalDate.now();
        LocalDate hundredDaysAgo = now.minusDays(100);
        return hundredDaysAgo.getDayOfWeek();
    }

}
