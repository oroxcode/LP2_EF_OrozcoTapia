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
@Table(name= "tb_producto")
@Getter
@Setter
@ToString

public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productoId;
	
	
	@Column(name = "Producto",
			nullable = false,
			length = 50,
			columnDefinition="VARCHAR(50)"
			)
	private String nombre;
	
	@Column(name = "Precio",
			nullable=false
			)
	private Double	precio;
	
	@Column(name= "Stock",
			nullable=false
			)
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="categoriaId")
	private CategoriaEntity categorias;
	
	
	public Integer getIdProducto() {
		return productoId;
	}

	public void setIdProducto(Integer idProducto) {
		this.productoId = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public CategoriaEntity getCategoriaEntity() {
		return categorias;
	}

	public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
		this.categorias = categoriaEntity;
	}

	public ProductoEntity(Integer idProducto, String nombre, Double precio, Integer stock,
			CategoriaEntity categoriaEntity) {
		super();
		this.productoId = idProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
		this.categorias = categoriaEntity;
	}

	public ProductoEntity() {
	}

	@Override
	public String toString() {
		return "ProductoEntity [idProducto=" + productoId + ", nombre=" + nombre + ", precio=" + precio + ", stock="
				+ stock + ", categoriaEntity=" + categorias + "]";
	}
	
	
	
	
}
