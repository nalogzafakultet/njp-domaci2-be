package org.sekularac.njp.ejb.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RECEPTI")
public class Recept implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "naziv")
    private String naziv;

    @NotNull
    @Column(name = "opis")
    private String opis;

    @ManyToMany(
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "PROIZVODI_RECEPATA",
            joinColumns = {@JoinColumn(name = "RECEPT_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "PROIZVOD_ID", referencedColumnName = "id")}
    )
    @JsonManagedReference
    private Set<Proizvod> proizvodi = new HashSet<>();

    public Recept() {
    }

    public Recept(@NotNull String naziv, @NotNull String opis) {
        this.naziv = naziv;
        this.opis = opis;
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

    public Set<Proizvod> getProizvodi() {
        return proizvodi;
    }

    public void setProizvodi(Set<Proizvod> proizvodi) {
        this.proizvodi = proizvodi;
    }

    public void addProizvod(Proizvod proizvod) {
        this.proizvodi.add(proizvod);
        proizvod.getRecepti().add(this);
    }

    public void removeProizvod(Proizvod proizvod) {
        this.proizvodi.remove(proizvod);
        proizvod.getRecepti().remove(this);
    }

    @Override
    public String toString() {
        return "Recept{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", proizvodi=" + proizvodi +
                '}';
    }
}
