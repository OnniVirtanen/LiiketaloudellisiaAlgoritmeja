package org.example;

import org.example.laina.LainaLaskuri;
import org.example.laina.LainaLaskuriImpl;
import org.example.laina.valueobject.LainanMaksuEra;
import org.example.laina.valueobject.LainanMaksuSuunnitelma;
import org.example.laina.valueobject.VuosiKorko;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal paaoma = new BigDecimal(20000);
        VuosiKorko korko = new VuosiKorko(10);
        int maksuaika = 24;
        int maksuvali = 1;

        LainaLaskuri lainaLaskuri = new LainaLaskuriImpl();

        LainanMaksuSuunnitelma suunnitelma = lainaLaskuri.teeLainanMaksuSuunnitelmaTasaEraLyhennyksella(
                paaoma, korko, maksuaika);

        for (LainanMaksuEra era : suunnitelma.getLainanMaksuErat()) {
            System.out.println(era);
        }

        System.out.println("lainapaaoma: " + suunnitelma.getLainaPaaoma());
        System.out.println("summa: " + suunnitelma.getSumma());
        System.out.println("kumulatiivinen korko: " + suunnitelma.getKumulatiivinenKorko());

    }
}