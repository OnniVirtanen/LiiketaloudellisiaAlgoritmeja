package org.example.laina;

import java.math.BigDecimal;

public class KorkoUtil {

    /**
     * Monen desimaalin tarkkuudella välivaiheissa käytetään liukulukuja. Double on noin 15 desimaalin tarkkuudella.
     */
    private static final int N_DESIMAALIN_TARKKUUS = 32;
    private static final int VUOSI_KUUKAUSISSA = 12;

    public static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosikorko, int maksuvaliKK) {
        BigDecimal vuosiKorkoProsenttiKerroin = vuosikorko.divide(new BigDecimal(100), N_DESIMAALIN_TARKKUUS, BigDecimal.ROUND_HALF_UP);
        return vuosiKorkoProsenttiKerroin.divide(new BigDecimal(VUOSI_KUUKAUSISSA), N_DESIMAALIN_TARKKUUS, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(maksuvaliKK));
    }

    public static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosikorko) {
        BigDecimal vuosiKorkoProsenttiKerroin = vuosikorko.divide(new BigDecimal(100), N_DESIMAALIN_TARKKUUS, BigDecimal.ROUND_HALF_UP);
        return vuosiKorkoProsenttiKerroin.divide(new BigDecimal(VUOSI_KUUKAUSISSA), N_DESIMAALIN_TARKKUUS, BigDecimal.ROUND_HALF_UP);
    }
}
