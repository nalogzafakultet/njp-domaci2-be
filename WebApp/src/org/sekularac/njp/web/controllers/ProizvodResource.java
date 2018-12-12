package org.sekularac.njp.web.controllers;

import org.sekularac.njp.ejb.beans.ProizvodBean;
import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ProizvodWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/proizvodi")
public class ProizvodResource {

    @EJB
    ProizvodBean proizvodBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProizvodWrapper> getAllProizvods() {
        return proizvodBean.getAllProizvods();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProizvod(Proizvod proizvod) {
        ProizvodWrapper newProizvod =  proizvodBean.makeNewProizvod(proizvod);
        if (newProizvod != null) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(newProizvod)
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }

    @GET
    @Path("/diff")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProizvodWrapper> getRemainingProizvodsForRecipe(Recept recept) {
        return proizvodBean.getRemainingProizvods(recept);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean removeProizvod(Proizvod proizvod) {
        return proizvodBean.deleteProizvod(proizvod);
    }

}
