/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lisa
 */
public class calcDiff {

    LocalDateTime date1;
    LocalDateTime date2;

    public calcDiff(LocalDateTime date1, LocalDateTime date2) {
        this.date1 = date1;
        this.date2 = date2;
    }

    public List<Integer> compare() {
        int diffyear = date2.getYear() - date1.getYear();
        int diffmonth = date2.getMonthValue() - date1.getMonthValue();
        int diffday = date2.getDayOfMonth() - date1.getDayOfMonth();
        int diffminute = date2.getMinute() - date1.getMinute();
        int diffhour = date2.getHour() - date1.getHour();
        int diffseconds = date2.getSecond() - date1.getSecond();

        List<Integer> diffs = new ArrayList<>(); //speichert die diffs - zum testen
        diffs.add(diffyear);
        diffs.add(Math.abs(diffmonth));
        diffs.add(Math.abs(diffday));
        diffs.add(Math.abs(diffhour));
        diffs.add(Math.abs(diffminute));
        diffs.add(Math.abs(diffseconds));
        System.out.println("Diff. Year: " + diffyear);
        System.out.println("Diff. Month: " + Math.abs(diffmonth));
        System.out.println("Diff. Day: " + Math.abs(diffday));
        System.out.println("Diff. Hour: " + Math.abs(diffhour));
        System.out.println("Diff. Minute: " + Math.abs(diffminute));
        System.out.println("Diff. Seconds: " + Math.abs(diffseconds));
        return diffs;
    }

}
