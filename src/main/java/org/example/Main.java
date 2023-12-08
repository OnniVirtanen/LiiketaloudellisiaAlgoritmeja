package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        Double paaoma = 20000.0;
        int vuosikorko = 10;
        int maksuaika = 24;
        int maksuvali = 1;

        List<LainanMaksuEra> erat = LainanTakaisinMaksaja.laskeEratTasalyhennyksessa(paaoma, vuosikorko, maksuaika, maksuvali);

        for (LainanMaksuEra era : erat) {
            System.out.println(era.toString());
        }
         */
        Double paaoma = 20000.0;
        int vuosikorko = 10;
        int maksuaika = 24;
        int maksuvali = 1;

        LainanMaksuSuunnitelma suunnitelma = LainanTakaisinMaksaja.laskeEratTasalyhennyksessa(paaoma, vuosikorko, maksuaika, maksuvali);

        System.out.println(suunnitelma);
    }
}