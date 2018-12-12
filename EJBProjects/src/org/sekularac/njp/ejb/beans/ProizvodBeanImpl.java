package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ProizvodWrapper;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Stateless
@LocalBean
public class ProizvodBeanImpl implements ProizvodBean {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProizvodWrapper> getAllProizvods() {
        List<Proizvod> proizvods = entityManager.createQuery("SELECT p FROM Proizvod p").getResultList();
        List<ProizvodWrapper> proizvodWrappers = new ArrayList<>();
        for (Proizvod proizvod: proizvods) {
            proizvodWrappers.add(new ProizvodWrapper(proizvod));
        }
        return proizvodWrappers;
    }

    @Override
    public List<ProizvodWrapper> getRemainingProizvods(Recept recept) {
        Set<Proizvod> proizvodiRecepta = recept.getProizvodi();
        List<Long> idProizvoda = new ArrayList<>();

        for (Proizvod proizvod: proizvodiRecepta) {
            idProizvoda.add(proizvod.getId());
        }

        List<Proizvod> preostaliProizvodi =
                entityManager.createQuery("SELECT p from Proizvod p WHERE p.id NOT in :ids")
                .setParameter("ids", idProizvoda)
                .getResultList();

        List<ProizvodWrapper> results = new ArrayList<>();

        for (Proizvod proizvod: preostaliProizvodi) {
            results.add(new ProizvodWrapper(proizvod));
        }

        return results;
    }

    @Override
    public ProizvodWrapper getProizvodById(Long id) {
        Proizvod foundProduct = null;
        try {
            foundProduct = entityManager.find(Proizvod.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (foundProduct != null) {
            return new ProizvodWrapper(foundProduct);
        }
        return null;
    }

    @Override
    public ProizvodWrapper makeNewProizvod(Proizvod proizvod) {
        entityManager.persist(proizvod);
        return new ProizvodWrapper(proizvod);
    }

    @Override
    public boolean deleteProizvod(Proizvod proizvod) {
        try {
            proizvod = entityManager.merge(proizvod);
            entityManager.remove(proizvod);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
