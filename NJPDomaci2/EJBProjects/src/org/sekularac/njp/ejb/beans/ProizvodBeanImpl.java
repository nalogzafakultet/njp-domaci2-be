package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
@LocalBean
public class ProizvodBeanImpl implements ProizvodBean {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Proizvod> getAllProizvods() {
        return entityManager.createQuery("SELECT p FROM Proizvod p").getResultList();
    }

    @Override
    public List<Proizvod> getRemainingProizvods(Recept recept) {
        return null;
    }

    @Override
    public Proizvod getProizvodById(Long id) {
        return null;
    }

    @Override
    public boolean makeNewProizvod(Proizvod proizvod) {
        return false;
    }

    @Override
    public boolean deleteProizvod(Proizvod proizvod) {
        return false;
    }
}
