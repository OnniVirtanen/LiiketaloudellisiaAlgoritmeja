package org.example.laina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class LainanMaksuSuunnitelma implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private List<LainanMaksuEra> lainanMaksuErat;
    private BigDecimal lainaPaaoma;
    private BigDecimal kumulatiivinenKorko;
    private BigDecimal summa;

    public LainanMaksuSuunnitelma(UUID id, List<LainanMaksuEra> lainanMaksuErat, BigDecimal lainaPaaoma,
                                  BigDecimal kumulatiivinenKorko, BigDecimal summa) {
        this.id = id;
        this.lainanMaksuErat = lainanMaksuErat;
        this.lainaPaaoma = lainaPaaoma;
        this.kumulatiivinenKorko = kumulatiivinenKorko;
        this.summa = summa;
    }

    public UUID getId() {
        return id;
    }

    public List<LainanMaksuEra> getLainanMaksuErat() {
        return lainanMaksuErat;
    }

    public BigDecimal getLainaPaaoma() {
        return lainaPaaoma;
    }

    public BigDecimal getKumulatiivinenKorko() {
        return kumulatiivinenKorko;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LainanMaksuSuunnitelma that = (LainanMaksuSuunnitelma) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
