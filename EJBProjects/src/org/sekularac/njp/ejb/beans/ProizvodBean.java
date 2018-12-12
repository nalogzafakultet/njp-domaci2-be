package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ProizvodWrapper;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProizvodBean {
    List<ProizvodWrapper> getAllProizvods();
    List<ProizvodWrapper> getRemainingProizvods(Recept recept);
    ProizvodWrapper getProizvodById(Long id);
    ProizvodWrapper makeNewProizvod(Proizvod proizvod);
    boolean deleteProizvod(Proizvod proizvod);
}
