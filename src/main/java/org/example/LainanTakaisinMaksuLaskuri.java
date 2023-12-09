package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LainanTakaisinMaksuLaskuri {
    private static int VUOSI_KUUKAUSISSA = 12;

    public static LainanMaksuSuunnitelma laskeEratTasalyhennyksessa(final BigDecimal alkuLainapaaoma,
                                                                    final BigDecimal vuosikorko,
                                                                    final int maksuaika,
                                                                    final int maksuvali) {
        BigDecimal lainapaaoma = alkuLainapaaoma;
        BigDecimal kumulatiivinenKorko = BigDecimal.ZERO;
        List<LainanMaksuEra> erat = new ArrayList<>();
        int maksuerienMaara = maksuaika / maksuvali;
        BigDecimal lainapaaomanLyhennys = lainapaaoma.divide(new BigDecimal(maksuerienMaara), 4, BigDecimal.ROUND_HALF_UP);

        for (int i = 0; i < maksuerienMaara; i++) {
            BigDecimal korkoProsentti = laskeKorkoProsenttiKerroin(vuosikorko, maksuvali);
            BigDecimal korko = korkoProsentti.multiply(lainapaaoma);
            kumulatiivinenKorko = kumulatiivinenKorko.add(korko);
            BigDecimal maksuera = lainapaaomanLyhennys.add(korko);
            int lyhennyksenLkm = i + 1;

            LainanMaksuEra era = new LainanMaksuEra(
                lyhennyksenLkm,
                alkuLainapaaoma.setScale(2, BigDecimal.ROUND_HALF_UP),
                lainapaaomanLyhennys.setScale(2, BigDecimal.ROUND_HALF_UP),
                korko.setScale(2, BigDecimal.ROUND_HALF_UP),
                maksuera.setScale(2, BigDecimal.ROUND_HALF_UP),
                lyhennyksenLkm
            );
            erat.add(era);
            lainapaaoma = lainapaaoma.subtract(lainapaaomanLyhennys);
        }

        LainanMaksuSuunnitelma suunnitelma = new LainanMaksuSuunnitelma();

        suunnitelma.setSumma(alkuLainapaaoma.add(kumulatiivinenKorko.setScale(2, BigDecimal.ROUND_HALF_UP)));
        suunnitelma.setLainaPaaoma(alkuLainapaaoma.setScale(2, BigDecimal.ROUND_HALF_UP));
        suunnitelma.setLainanMaksuErat(erat);
        suunnitelma.setKumulatiivinenKorko(kumulatiivinenKorko.setScale(2, BigDecimal.ROUND_HALF_UP));

        return suunnitelma;
    }

    private static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosikorko, int maksuvaliKK) {
        BigDecimal vuosiKorkoProsenttiKerroin = vuosikorko.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_UP);
        return vuosiKorkoProsenttiKerroin.divide(new BigDecimal(VUOSI_KUUKAUSISSA), 10, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(maksuvaliKK));
    }
}
