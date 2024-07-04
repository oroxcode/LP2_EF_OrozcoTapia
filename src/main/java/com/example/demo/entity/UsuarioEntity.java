package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "tb_usuario")
@Getter
@Setter
@ToString

public class UsuarioEntity {

		@Id
		@Column(name="Correo",
				nullable=false,
				length=50,
				columnDefinition="VARCHAR(50)",
				unique=true
				)
		private String correo;
		
		
		@Column(name="Contraseña",
				nullable=false,
				length=50,
				columnDefinition="VARCHAR(60)"
				)
		private String password;
		

		@Column(name= "Nombre",
				nullable= false,
				length=50,
				columnDefinition="VARCHAR(50)"
				)
		private String nombre;
		
		
		@Column(name="Apellidos",
				nullable=false,
				length=50,
				columnDefinition="VARCHAR(50)"
				)
		private String apellidos;
		
		
		@Column(name="Fecha_nacimiento",nullable=false)
		private LocalDate fenac;
		
		
		@Column(name="url_imagen",
				nullable=false
				)
		private String urlImagen;
		
		
		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getNombres() {
			return nombre;
		}

		public void setNombres(String nombres) {
			this.nombre = nombres;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public LocalDate getFecNacimiento() {
			return fenac;
		}

		public void setFecNacimiento(LocalDate fecNacimiento) {
			this.fenac = fecNacimiento;
		}

		public String getUrlImagen() {
			return urlImagen;
		}

		public void setUrlImagen(String urlImagen) {
			this.urlImagen = urlImagen;
		}
		

		public UsuarioEntity() {
			super();
		}

		public UsuarioEntity(String correo, String password, String nombres, String apellidos, LocalDate fecNacimiento,
				String urlImagen) {
			super();
			this.correo = correo;
			this.password = password;
			this.nombre = nombres;
			this.apellidos = apellidos;
			this.fenac = fecNacimiento;
			this.urlImagen = urlImagen;
		}
		
		
		
		
		
}
