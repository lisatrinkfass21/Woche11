/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lisa
 */
public class DateTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in, "Windows-1252");
        String datum1;
        LocalDateTime date1 = null;
        LocalDateTime date2 = null;
        String datum2;

        while (date1 == null) {
            System.out.println("Gib ein Datum mit Uhrzeit ein (dd:MM:yyyy-hh:mm) (1)");
            datum1 = scan.nextLine();
            date1 = split(datum1);
        }

        while (date2 == null) {
            System.out.println("Gib ein Datum mit Uhrzeit ein (dd:MM:yyyy-hh:mm) (2)");
            datum2 = scan.nextLine();
            date2 = split(datum2);
        }

        if (überprüfung(date1, date2)) {
            calcDiff cd = new calcDiff(date1, date2);
            cd.compare();
        }

        datesbetween(date1, date2);
    }

    private static LocalDateTime split(String date) {
        int day = 0;
        int month = 0;
        int year = 0;
        int minute = 0;
        int hour = 0;
        if (date != null && date.length() == 16) {
            String[] arr = date.split("-");
            String[] datum = arr[0].split(":");
            String[] zeit = arr[1].split(":");
            try {
                if (Integer.parseInt(datum[0]) > 0 && Integer.parseInt(datum[0]) < 32) {
                    day = Integer.parseInt(datum[0]);
                }
                if (Integer.parseInt(datum[1]) > 0 && Integer.parseInt(datum[1]) < 13) {
                    month = Integer.parseInt(datum[1]);
                }
                if (Integer.parseInt(datum[2]) > 0) {
                    year = Integer.parseInt(datum[2]);
                }
                if (Integer.parseInt(zeit[0]) > -1 && Integer.parseInt(zeit[0]) < 24) {
                    hour = Integer.parseInt(zeit[0]);
                }
                if (Integer.parseInt(zeit[1]) > -1 && Integer.parseInt(zeit[1]) < 60) {
                    minute = Integer.parseInt(zeit[1]);
                }
            } catch (Exception ex) {
                System.out.println("kein gültiges Datum oder Uhrzeit");
                return null;
            }
            return LocalDateTime.of(year, month, day, hour, minute);

        } else {
            System.out.println("Falsches Format");
        }
        return null;
    }

    private static boolean überprüfung(LocalDateTime date1, LocalDateTime date2) {
        int diffyear = date2.getYear() - date1.getYear();
        if (diffyear < 0) {
            throw new IllegalArgumentException(); // Datum 2 vor Datum 1
        } else if (diffyear == 0) {
            int diffmonth = date2.getMonthValue() - date1.getMonthValue();
            if (diffmonth < 0) {
                throw new IllegalArgumentException();
            } else if (diffmonth > 0) {
                System.out.println("Die Differenz ist zu klein - es muss mindestens 1 Jahr dazwischen sein");
                return false;
            } else {
                int diffday = date2.getDayOfMonth() - date1.getDayOfMonth();
                if (diffday < 1) {
                    throw new IllegalArgumentException();
                } else {
                    System.out.println("Die Differenz ist zu klein - es muss mindestens 1 Jahr dazwischen sein");
                    return false;
                }
            }
        }

        return true;//wenn diff min. 1 Jahr ist datum1 vor datum 2 ist

    }

    private static void datesbetween(LocalDateTime date1, LocalDateTime date2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy-hh:mm:ss");

        while (date1.getYear() != date2.getYear() || date1.getMonthValue() != date2.getMonthValue() || date1.getDayOfMonth() != date2.getDayOfMonth()) {
            date1 = date1.plusDays(1);
            System.out.println(dtf.format(date1));
        }
    }

}
