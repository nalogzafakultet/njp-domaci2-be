package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ReceptWrapper;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
@LocalBean
public class ReceptBeanImpl implements ReceptBean {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ReceptWrapper> getRecepti() {
        List<Recept> recepts = entityManager.createQuery("SELECT r FROM Recept r").getResultList();
        List<ReceptWrapper> wrappers = new ArrayList<>();
        for (Recept recept: recepts) {
            wrappers.add(new ReceptWrapper(recept));
        }
        return wrappers;
    }

    @Override
    public ReceptWrapper getReceptById(Long id) {
        Recept foundRecept = entityManager.find(Recept.class, id);
        if (foundRecept != null) {
            return new ReceptWrapper(foundRecept);
        } else {
            return null;
        }
    }

    @Override
    public ReceptWrapper addRecept(Recept recept) {
        try {
            entityManager.persist(recept);
            return new ReceptWrapper(recept);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ReceptWrapper updateRecept(Recept recept) {
        recept = entityManager.merge(recept);
        return new ReceptWrapper(recept);
    }

    @Override
    public List<ReceptWrapper> findReceptByName(String name) {
        List<Recept> recepti = entityManager
                                .createQuery("SELECT r FROM Recept r where lower(r.naziv) like :naziv")
                                .setParameter("naziv", "%" + name.toLowerCase() + "%")
                                .getResultList();

        List<ReceptWrapper> resultRecepts = new ArrayList<>();
        for (Recept recept: recepti) {
            resultRecepts.add(new ReceptWrapper(recept));
        }
        return resultRecepts;
    }

    @Override
    /**
     * Nisam radio sa jos jednim JoinEntityjem, pa ne mogu lepo da odradim preko SQL-a ceo query.
     * Moracu rucno da prepakujem stvari.
     *
     * <b>Fuj</b>
     *
     * EDIT: <b>Ozbiljan fuj</b>
     */
    public List<ReceptWrapper> findReceptByProizvodi(List<Proizvod> proizvodList) {

        List<Recept> sviRecepti = entityManager.createQuery("SELECT r FROM Recept r").getResultList();

        List<ReceptWrapper> matchovaniRecepti = new ArrayList<>();

        boolean nisamMatchovanJbg = false;

        for (Recept recept: sviRecepti) {
            nisamMatchovanJbg = false;
            for (Proizvod proizvod: proizvodList) {
                if (!recept.getProizvodi().contains(proizvod)) {
                    nisamMatchovanJbg = true;
                    break;
                }
            }

            if (!nisamMatchovanJbg) {
                matchovaniRecepti.add(new ReceptWrapper(recept));
            }
        }

        return matchovaniRecepti;
    }
}
