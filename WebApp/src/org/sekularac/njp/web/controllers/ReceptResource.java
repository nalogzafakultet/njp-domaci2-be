package org.sekularac.njp.web.controllers;

import org.sekularac.njp.ejb.beans.ReceptBean;
import org.sekularac.njp.ejb.entities.Proizvod;
import org.sekularac.njp.ejb.entities.Recept;
import org.sekularac.njp.ejb.wrappers.ReceptWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/recepti")
public class ReceptResource {

    @EJB
    private ReceptBean receptBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRecepti() {
        List<ReceptWrapper> sviRecepti = receptBean.getRecepti();
        return Response.status(Response.Status.OK)
                .entity(sviRecepti)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewRecipe(Recept recept) {
        ReceptWrapper newRecept = receptBean.addRecept(recept);
        if (newRecept != null) {
            return Response
                    .status(Response.Status.CREATED)
                    .entity(newRecept)
                    .build();
        } else {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReceptById(@PathParam("id") Integer id) {
        ReceptWrapper returnedRecept = receptBean.getReceptById((long) id);
        if (returnedRecept != null) {
            return Response
                    .status(Response.Status.OK)
                    .entity(returnedRecept)
                    .build();
        }

        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @GET
    @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByName(@QueryParam("name") String name) {
        System.out.println("USAO OVDE");
        if (name == null || name.isEmpty()) {
            return getAllRecepti();
        }

        List<ReceptWrapper> receptByName = receptBean.findReceptByName(name);
        return Response
                .status(Response.Status.OK)
                .entity(receptByName)
                .build();
    }

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchByProizvodi(List<Proizvod> proizvodList) {
        List<ReceptWrapper> receptByProizvodi = receptBean.findReceptByProizvodi(proizvodList);
        return Response
                .status(Response.Status.OK)
                .entity(receptByProizvodi)
                .build();
    }
}
