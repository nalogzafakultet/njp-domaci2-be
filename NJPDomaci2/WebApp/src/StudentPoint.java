import org.sekularac.njp.ejb.beans.ProizvodBean;
import org.sekularac.njp.ejb.beans.StudentBean;
import org.sekularac.njp.ejb.entities.Proizvod;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Path("/student")
@Stateless
@LocalBean
public class StudentPoint {

    @EJB
    ProizvodBean proizvodBean;

    @EJB
    StudentBean studentBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Proizvod> getString() {
        List<Proizvod> proizvods = proizvodBean.getAllProizvods();

        for (Proizvod p: proizvods) {
            p.getRecepti().size();
        }

        return proizvods;
    }

    @Path("/add")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addUsers() {
        return studentBean.getIme(1L);
    }
}
