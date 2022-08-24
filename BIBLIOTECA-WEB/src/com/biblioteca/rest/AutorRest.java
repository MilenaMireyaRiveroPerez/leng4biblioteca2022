package com.biblioteca.rest;

import java.util.List;
import java.util.Map;

import javax.decorator.Delegate;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.Body;

import com.biblioteca.entidad.Autor;
import com.biblioteca.entidad.Cliente;
import com.biblioteca.session.AutorSession;

@Path("/autor")

public class AutorRest {

	@EJB
	AutorSession as;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar")
	public List<Autor> consultar(String nombre) {
		return as.consultarAutores();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultar-por-nombre")
	// parametros: ""queryparam"", pathparam, bodyparam
	// abajo se usa queryparam
	public Map<String, Object> consultarPorNombre(@QueryParam("nombre") String nombre) {
		return as.consultarAutoresPorNombre(nombre);

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/incluir")
	public Autor incluir(Autor autor) {
		return as.incluir(autor);

	}

	@DELETE
	@Path("/eliminar/{id}")
	private void eliminar(@PathParam("id") Integer codigo) {
		as.eliminar(codigo);

	}

	//// implementar editar, actualizar, buscarPorcodigo
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/actualizar")
	public Autor actualizar(Autor autor){
		return as.actualizar(autor);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarPorCodigo")
	public Autor buscar(@PathParam("codigo") Integer codigo) throws Exception {
		return as.buscarPorCodigo(codigo);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/editar")
	public Autor editar(Autor autor){
		return as.editar(autor);

	}
}