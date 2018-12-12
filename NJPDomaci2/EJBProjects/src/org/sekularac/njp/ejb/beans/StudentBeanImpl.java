package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.entities.Student;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class StudentBeanImpl implements StudentBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public String getIme(Long id) {
        Proizvod mleko = new Proizvod("Mleko", 1);
        entityManager.persist(mleko);
        Proizvod pahuljice = new Proizvod("Pahuljice", 200);
        entityManager.persist(pahuljice);
        Recept recept = new Recept("Pahuljice sa mlekom", "He he");
        entityManager.persist(recept);
        recept.addProizvod(mleko);
        recept.addProizvod(pahuljice);
        return "ADDED";
    }
}
