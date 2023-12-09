package org.example.laina.valueobject;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class LainanMaksuSuunnitelma implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<LainanMaksuEra> lainanMaksuErat;
    private BigDecimal lainaPaaoma;
    private BigDecimal kumulatiivinenKorko;
    private BigDecimal summa;

    public LainanMaksuSuunnitelma(List<LainanMaksuEra> lainanMaksuErat, BigDecimal lainaPaaoma,
                                  BigDecimal kumulatiivinenKorko, BigDecimal summa) {
        this.lainanMaksuErat = lainanMaksuErat;
        this.lainaPaaoma = lainaPaaoma;
        this.kumulatiivinenKorko = kumulatiivinenKorko;
        this.summa = summa;
    }

    public List<LainanMaksuEra> getLainanMaksuErat() {
        return lainanMaksuErat;
    }

    public void setLainanMaksuErat(List<LainanMaksuEra> lainanMaksuErat) {
        this.lainanMaksuErat = lainanMaksuErat;
    }

    public BigDecimal getLainaPaaoma() {
        return lainaPaaoma;
    }

    public void setLainaPaaoma(BigDecimal lainaPaaoma) {
        this.lainaPaaoma = lainaPaaoma;
    }

    public BigDecimal getKumulatiivinenKorko() {
        return kumulatiivinenKorko;
    }

    public void setKumulatiivinenKorko(BigDecimal kumulatiivinenKorko) {
        this.kumulatiivinenKorko = kumulatiivinenKorko;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    @Override
    public String toString() {
        return "LainanMaksuSuunnitelma{" +
                "lainanMaksuErat=" + lainanMaksuErat +
                ", lainaPaaoma=" + lainaPaaoma +
                ", kumulatiivinenKorko=" + kumulatiivinenKorko +
                ", summa=" + summa +
                '}';
    }
}
