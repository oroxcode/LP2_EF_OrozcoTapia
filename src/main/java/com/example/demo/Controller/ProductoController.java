package com.example.demo.Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.CategoriaEntity;
import com.example.demo.entity.ProductoEntity;
import com.example.demo.entity.UsuarioEntity;
import com.example.demo.service.CategoriaService;
import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.impl.PdfService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ProductoController {
	
	

	  @Autowired
	  private UsuarioService usuarioService;
	
	
	
	@Autowired
	private ProductoService productoService;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private PdfService pdfService;
	

	@GetMapping("/menu")
	public String showMenu(HttpSession session, Model model) {
		if(session.getAttribute("usuario") == null) {
			return "redirect:/";
		} 
		List<ProductoEntity>productos = productoService.findAllProductos();
		model.addAttribute("lstProd", productos);
											
		return "menu";
	}
	
	
	@GetMapping("/registrarProd")
	public String viewRegistrarProducto(Model model) {
		model.addAttribute("prod", new ProductoEntity());
		List<CategoriaEntity> listCat = categoriaService.findAllCategorias();
		model.addAttribute("listCat", listCat);
		return "registrar_producto";
	}
	
	@PostMapping("/registrarProd")
	public String registrarProducto(ProductoEntity productoEntity, Model model) {
		
		productoService.registrarProducto(productoEntity, model);
		
		return "registrar_producto";
	}
	
	@GetMapping("/detalle/{id}")
	public String verProducto(HttpSession session,  Model model, @PathVariable("id") Integer id) {
		
		if (session.getAttribute("usuario") == null) {
	        return "redirect:/";
	    }
		
		String correo = session.getAttribute("usuario").toString();
	    UsuarioEntity usuarioEntity = usuarioService.buscarUsuarioPorCorreo(correo);
	    model.addAttribute("foto", usuarioEntity.getUrlImagen());
	    
	    String nombreCompleto = usuarioEntity.getNombre() + " " + usuarioEntity.getApellidos();
	    model.addAttribute("nombreUsuario", nombreCompleto);
	    model.addAttribute("foto", usuarioEntity.getUrlImagen());
		
	    ProductoEntity producto = productoService.buscarProductoPorId(id);
	    model.addAttribute("producto", producto);
	    return "detalle"; 
	}
	
	
	
	
	
}
