package org.example.valueobject;

import org.example.KorkoUtil;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public final class VuosiKorko implements Serializable {

    private static final long serialVersionUID = 1L;

    private final BigDecimal arvo;

    public VuosiKorko(BigDecimal vuosikorko) {
        this.arvo = vuosikorko.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public VuosiKorko(int vuosikorko) {
        this(new BigDecimal(vuosikorko));
    }

    public VuosiKorko(double vuosikorko) {
        this(new BigDecimal(vuosikorko));
    }

    public BigDecimal getVuosikorko() {
        return arvo;
    }

    public BigDecimal getProsenttiKerroin() {
        return KorkoUtil.laskeKorkoProsenttiKerroin(this.arvo);
    }

    public BigDecimal getProsenttiKerroin(int maksuvaliKK) {
        return KorkoUtil.laskeKorkoProsenttiKerroin(this.arvo, maksuvaliKK);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VuosiKorko vuosiKorko = (VuosiKorko) o;
        return Objects.equals(arvo, vuosiKorko.arvo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arvo);
    }
}
