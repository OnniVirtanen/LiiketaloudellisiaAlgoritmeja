package org.example.laina;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class LainanMaksuEra implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private int kuukausi;
    private BigDecimal lainaPaaoma;
    private BigDecimal lainaPaaomanLyhennysEra;
    private BigDecimal koronOsuus;
    private BigDecimal summa;
    private Integer lyhennyksenLkm;

    public LainanMaksuEra(UUID id, int kuukausi, BigDecimal lainaPaaoma, BigDecimal lainaPaaomanLyhennysEra,
                          BigDecimal koronOsuus, BigDecimal summa, Integer lyhennyksenLkm) {
        this.id = id;
        this.kuukausi = kuukausi;
        this.lainaPaaoma = lainaPaaoma;
        this.lainaPaaomanLyhennysEra = lainaPaaomanLyhennysEra;
        this.koronOsuus = koronOsuus;
        this.summa = summa;
        this.lyhennyksenLkm = lyhennyksenLkm;
    }

    public UUID getId() {
        return id;
    }

    public int getKuukausi() {
        return kuukausi;
    }

    public BigDecimal getLainaPaaoma() {
        return lainaPaaoma;
    }

    public BigDecimal getLainaPaaomanLyhennysEra() {
        return lainaPaaomanLyhennysEra;
    }

    public BigDecimal getKoronOsuus() {
        return koronOsuus;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public Integer getLyhennyksenLkm() {
        return lyhennyksenLkm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LainanMaksuEra that = (LainanMaksuEra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
