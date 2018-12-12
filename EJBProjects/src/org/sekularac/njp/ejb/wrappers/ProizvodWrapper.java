package org.sekularac.njp.ejb.wrappers;

import org.sekularac.njp.ejb.entities.Proizvod;

import java.io.Serializable;

public class ProizvodWrapper implements Serializable {
    private Long id;
    private String naziv;

    public ProizvodWrapper(Proizvod proizvod) {
        this.id = proizvod.getId();
        this.naziv = proizvod.getNaziv();
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

    @Override
    public String toString() {
        return "ProizvodWrapper{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}
