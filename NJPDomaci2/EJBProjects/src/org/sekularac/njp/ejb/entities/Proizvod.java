package org.sekularac.njp.ejb.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PROIZVODI")
public class Proizvod implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "kolicina")
    private double kolicina;

    @ManyToMany(mappedBy = "proizvodi")
    private Set<Recept> recepti = new HashSet<>();

    public Proizvod() {
    }

    public Proizvod(String naziv, double kolicina) {
        this.naziv = naziv;
        this.kolicina = kolicina;
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

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Set<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(Set<Recept> recepti) {
        this.recepti = recepti;
    }

    @Override
    public String toString() {
        return "Proizvod{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", kolicina=" + kolicina +
                '}';
    }
}
