import org.sekularac.njp.ejb.beans.ProizvodBean;
import org.sekularac.njp.ejb.beans.ReceptBean;
import org.sekularac.njp.ejb.beans.StudentBean;
import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ProizvodWrapper;
import org.sekularac.njp.ejb.wrappers.ReceptWrapper;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/student")
@Stateless
@LocalBean
public class StudentPoint {

    @EJB
    ProizvodBean proizvodBean;

    @EJB
    StudentBean studentBean;

    @EJB
    ReceptBean receptBean;

    @GET
    public String index() {
        return "Zdravo raja";
    }

//    @GET
//    @Path("/recepti")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Recept> getRecepti() {
//        return receptBean.getRecepti();
//    }

    @GET
    @Path("/recept")
    @Produces(MediaType.TEXT_PLAIN)
    public ReceptWrapper getRecept() {
        return receptBean.getReceptById(3L);
    }

//    @GET
//    @Path("/proizvod")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProizvodWrapper> getString() {
//        List<ProizvodWrapper> proizvods = proizvodBean.getAllProizvods();
//
//        for (ProizvodWrapper p: proizvods) {
//            p.getRecepti().size();
//        }
//
//        return proizvods;
//    }

    @Path("/add")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String addUsers() {
        return studentBean.getIme(1L);
    }
}
