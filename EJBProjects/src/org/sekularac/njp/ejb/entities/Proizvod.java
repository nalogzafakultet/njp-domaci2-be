package org.sekularac.njp.ejb.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PROIZVODI")
public class Proizvod implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "naziv")
    private String naziv;

    @ManyToMany(mappedBy = "proizvodi")
    @JsonBackReference
    private Set<Recept> recepti = new HashSet<>();

    public Proizvod() {
    }

    public Proizvod(String naziv) {
        this.naziv = naziv;
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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proizvod)) return false;
        Proizvod proizvod = (Proizvod) o;
        return Objects.equals(getId(), proizvod.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
