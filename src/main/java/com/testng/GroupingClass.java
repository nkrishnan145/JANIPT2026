package com.testng;
import org.testng.annotations.Test;

public class GroupingClass {

    @Test(groups = "VEG")
    private void iddly() {
        System.out.println("IDDLY");
    }

    @Test(groups = "VEG")
    private void poori() {
        System.out.println("POORI");
    }

    @Test(groups = "VEG")
    private void curdRice() {
        System.out.println("CURDRICE");
    }

    @Test(groups = "NONVEG")
    private void mutton() {
        System.out.println("MUTTON");
    }
    
    @Test(groups = "NONVEG")
    private void chicken() {
        System.out.println("CHICKEN");
    }

    @Test(groups = "NONVEG")
    private void fish() {
        System.out.println("FISH");
    }

    @Test(groups = "EC")
    private void mobile() {
        System.out.println("MOBILE");
    }

    @Test(groups = "EC")
    private void watch() {
        System.out.println("WATCH");
    }

}