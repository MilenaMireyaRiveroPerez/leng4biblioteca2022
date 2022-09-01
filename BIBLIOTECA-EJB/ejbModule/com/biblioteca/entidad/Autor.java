package com.biblioteca.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//poner asi cuando es SERIAL

	@Column(name = "aut_codigo")
	private Integer codigo;

	@Column(name = "aut_nombre")
	private String nombre;

	@ManyToOne                  /////una ciudad tiene muchos autores many es lado de la clase
	@JoinColumn(name = "aut_ciudad")
	private Ciudad ciudad;
	
	
	
	
	
	
	
	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Column(name = "aut_foto")
	private byte[] foto;

	public Autor() {
		super(); ///// ?preguntar en el otro no esta super

	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
