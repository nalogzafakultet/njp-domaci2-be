package org.sekularac.njp.ejb.beans;

import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface ProizvodBean {
    List<Proizvod> getAllProizvods();
    List<Proizvod> getRemainingProizvods(Recept recept);
    Proizvod getProizvodById(Long id);
    boolean makeNewProizvod(Proizvod proizvod);
    boolean deleteProizvod(Proizvod proizvod);
}
