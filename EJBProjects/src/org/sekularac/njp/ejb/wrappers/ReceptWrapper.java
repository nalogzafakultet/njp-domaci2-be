package org.sekularac.njp.ejb.wrappers;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ReceptWrapper implements Serializable {

    private Long id;
    private String naziv;
    private String opis;
    private Set<ProizvodWrapper> proizvodi = new HashSet<>();

    public ReceptWrapper(Recept recept) {
        this.id = recept.getId();
        this.naziv = recept.getNaziv();
        this.opis = recept.getOpis();
        for (Proizvod proizvod: recept.getProizvodi()) {
            proizvodi.add(new ProizvodWrapper(proizvod));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Set<ProizvodWrapper> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Set<ProizvodWrapper> proizvodi) {
        this.proizvodi = proizvodi;
    }

    @Override
    public String toString() {
        return "ReceptWrapper{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", proizvodi=" + proizvodi +
                '}';
    }
}
