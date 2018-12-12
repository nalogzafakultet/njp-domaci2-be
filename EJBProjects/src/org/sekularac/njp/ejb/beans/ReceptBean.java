package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ReceptWrapper;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ReceptBean {

    List<ReceptWrapper> getRecepti();
    ReceptWrapper getReceptById(Long id);
    ReceptWrapper addRecept(Recept recept);
    ReceptWrapper updateRecept(Recept recept);
    List<ReceptWrapper> findReceptByName(String name);
    List<ReceptWrapper> findReceptByProizvodi(List<Proizvod> proizvodList);
}
