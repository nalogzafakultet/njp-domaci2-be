package org.sekularac.njp.ejb.beans;

import javax.ejb.Remote;

@Remote
public interface StudentBean {
    String getIme(Long id);
}
