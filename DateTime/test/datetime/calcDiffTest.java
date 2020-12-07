/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lisa
 */
public class calcDiffTest {

    public calcDiffTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class calcDiff.
     */
    @Test
    public void testCompare() {
        System.out.println("compare");
        LocalDateTime date1 = LocalDateTime.of(2016, 10, 14, 12, 34);
        LocalDateTime date2 = LocalDateTime.of(2020, 11, 16, 11, 12);
        calcDiff cd = new calcDiff(date1, date2);
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(22);
        list.add(0);
        assertEquals(list, cd.compare());

    }

}
