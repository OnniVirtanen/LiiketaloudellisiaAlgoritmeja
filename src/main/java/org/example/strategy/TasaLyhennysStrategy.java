package org.example.strategy;

import org.example.valueobject.LainanMaksuEra;
import org.example.valueobject.LainanMaksuSuunnitelma;
import org.example.valueobject.VuosiKorko;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TasaLyhennysStrategy implements LyhennysStrategy {

    @Override
    public LainanMaksuSuunnitelma teeLainanMaksuSuunnitelma(final BigDecimal alkuLainapaaoma,
                                                                    final VuosiKorko vuosikorko,
                                                                    final int maksuaika,
                                                                    final int maksuvali) {
        BigDecimal lainapaaoma = alkuLainapaaoma;
        BigDecimal kumulatiivinenKorko = BigDecimal.ZERO;
        List<LainanMaksuEra> erat = new ArrayList<>();
        int maksuerienMaara = maksuaika / maksuvali;
        BigDecimal lainapaaomanLyhennys = lainapaaoma.divide(new BigDecimal(maksuerienMaara), 4, BigDecimal.ROUND_HALF_UP);

        for (int i = 0; i < maksuerienMaara; i++) {
            BigDecimal korkoProsentti = vuosikorko.getProsenttiKerroin(maksuvali);
            BigDecimal korko = korkoProsentti.multiply(lainapaaoma);
            kumulatiivinenKorko = kumulatiivinenKorko.add(korko);
            BigDecimal maksuera = lainapaaomanLyhennys.add(korko);
            int lyhennyksenLkm = i + 1;
            int kuukausi = (maksuaika / maksuerienMaara) * (i + 1);

            LainanMaksuEra era = new LainanMaksuEra(
                    kuukausi,
                    alkuLainapaaoma.setScale(2, BigDecimal.ROUND_HALF_UP),
                    lainapaaomanLyhennys.setScale(2, BigDecimal.ROUND_HALF_UP),
                    korko.setScale(2, BigDecimal.ROUND_HALF_UP),
                    maksuera.setScale(2, BigDecimal.ROUND_HALF_UP),
                    lyhennyksenLkm
            );
            erat.add(era);
            lainapaaoma = lainapaaoma.subtract(lainapaaomanLyhennys);
        }

        LainanMaksuSuunnitelma suunnitelma = new LainanMaksuSuunnitelma(
                erat,
                alkuLainapaaoma.setScale(2, BigDecimal.ROUND_HALF_UP),
                kumulatiivinenKorko.setScale(2, BigDecimal.ROUND_HALF_UP),
                alkuLainapaaoma.add(kumulatiivinenKorko.setScale(2, BigDecimal.ROUND_HALF_UP))
        );

        return suunnitelma;
    }
}
