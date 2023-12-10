package org.example.laina;

import java.math.BigDecimal;
import java.math.MathContext;

public class KorkoUtil {

    private static final int VUOSI_KUUKAUSISSA = 12;

    private KorkoUtil() {

    }

    public static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosiKorko, int maksuvaliKK) {
        return laskeKorkoProsenttiKerroin(vuosiKorko).multiply(new BigDecimal(maksuvaliKK));
    }

    public static BigDecimal laskeKorkoProsenttiKerroin(BigDecimal vuosiKorko) {
        BigDecimal vuosiKorkoProsenttiKerroin = vuosiKorko.divide(new BigDecimal(100), MathContext.DECIMAL64);
        return vuosiKorkoProsenttiKerroin.divide(new BigDecimal(VUOSI_KUUKAUSISSA), MathContext.DECIMAL64);
    }
}
