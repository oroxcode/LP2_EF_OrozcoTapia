package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "tb_categoria")
@Getter
@Setter
@ToString
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer categoriaId;
	
	@Column(name= "Nombre",
			nullable=false,
			length=50,
			columnDefinition="VARCHAR(50)"
			)
	private String nombreCat;
	
	public Integer getIdCategoria() {
		return categoriaId;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.categoriaId = idCategoria;
	}

	public String getNombre() {
		return nombreCat;
	}

	public void setNombre(String nombre) {
		this.nombreCat = nombre;
	}

	public CategoriaEntity(Integer idCategoria, String nombre) {
		super();
		this.categoriaId = idCategoria;
		this.nombreCat = nombre;
	}

	public CategoriaEntity() {
	}
	
	@Override
	public String toString() {
		return "CategoriaEntity [idCategoria=" + categoriaId + ", nombre=" + nombreCat + "]";
	}
}
