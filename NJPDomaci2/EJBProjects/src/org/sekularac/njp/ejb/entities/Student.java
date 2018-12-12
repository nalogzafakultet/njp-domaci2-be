package org.sekularac.njp.ejb.entities;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTI")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "prezime")
    private String prezime;

    public Student() {
    }

    public Student(Long id, String ime, String prezime) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
}
