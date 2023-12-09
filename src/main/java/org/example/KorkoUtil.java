package org.example;

import java.math.BigDecimal;

public class KorkoUtil {

    private static final int VUOSI_KUUKAUSISSA = 12;

    public static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosikorko, int maksuvaliKK) {
        BigDecimal vuosiKorkoProsenttiKerroin = vuosikorko.divide(new BigDecimal(100), 100, BigDecimal.ROUND_HALF_UP);
        return vuosiKorkoProsenttiKerroin.divide(new BigDecimal(VUOSI_KUUKAUSISSA), 100, BigDecimal.ROUND_HALF_UP)
                .multiply(new BigDecimal(maksuvaliKK));
    }

    public static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosikorko) {
        BigDecimal vuosiKorkoProsenttiKerroin = vuosikorko.divide(new BigDecimal(100), 100, BigDecimal.ROUND_HALF_UP);
        return vuosiKorkoProsenttiKerroin.divide(new BigDecimal(VUOSI_KUUKAUSISSA), 100, BigDecimal.ROUND_HALF_UP);
    }
}
