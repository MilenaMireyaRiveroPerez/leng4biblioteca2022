package com.biblioteca.mov.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.biblioteca.entidad.PrestamoLibro;
import com.biblioteca.mov.session.PrestamoLibroSession;

@Path("prestamo-libro")

public class PrestamoLibroRestService {

	@EJB
	PrestamoLibroSession pls;

	// GET
	// http://localhost:8080/PROYECTO-REST/rest/prestamo-libro/find-by-prestamo/{prestamoId}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find-by-prestamo/{codigo}")
	public List<PrestamoLibro> buscar(@PathParam("prestamoId") Integer prestamoId) throws Exception {
		return pls.buscarPorNumeroPrestamo(prestamoId);
	}

	// DELETE
	// http://localhost:8080/PROYECTO-REST/rest/prestamo-libro/delete/{prestamoId}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{prestamoId}")
	public void borrarPorPrestamo(@PathParam("prestamoId") Integer prestamoId) throws Exception {
		pls.eliminarPorPrestamo(prestamoId);
	}

}
