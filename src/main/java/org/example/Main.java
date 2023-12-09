package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal paaoma = new BigDecimal(20000);
        BigDecimal vuosikorko = new BigDecimal(10);
        int maksuaika = 24;
        int maksuvali = 3;

        LainanMaksuSuunnitelma suunnitelma = LainanTakaisinMaksuLaskuri.laskeEratTasalyhennyksessa(paaoma, vuosikorko, maksuaika, maksuvali);

        for (LainanMaksuEra era : suunnitelma.getLainanMaksuErat()) {
            System.out.println(era);
        }

        System.out.println("lainapaaoma: " + suunnitelma.getLainaPaaoma());
        System.out.println("summa: " + suunnitelma.getSumma());
        System.out.println("kumulatiivinen korko: " + suunnitelma.getKumulatiivinenKorko());
    }
}