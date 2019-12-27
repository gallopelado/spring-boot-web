package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//Registra esta clase como un controlador, se buscara en ComponentScan.
@Controller
@RequestMapping("/app")
public class IndexController {

	private String titulo;
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	// Mapear
	// @GetMapping(value="/index")
	// @RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({ "/index", "/", "/home", "" })
	public String index(Model model) {
		this.titulo = textoIndex;
		model.addAttribute("titulo", this.titulo);
		return "index";
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan");
		usuario.setApellido("Gonzalez");
		usuario.setEmail("juanftp100@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil + " ".concat(usuario.getNombre()));
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		this.titulo = textoListar;
//		List<Usuario> usuarios = new ArrayList<>();
//		usuarios.add(new Usuario("Juan", "Gonzalez", "juanftp100@gmail.com"));
//		usuarios.add(new Usuario("Celina", "Ramirez", "chili.olimpera@gmail.com"));

		model.addAttribute("titulo", this.titulo);
		
		return "listar";
	}

	/*
	 * En vez de utilizar el model.addAttribute()
	 * con la anotación @ModelAttribute se envía 
	 * datos al modelo.
	 * */
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Juan", "Gonzalez", "juanftp100@gmail.com"),
				new Usuario("Celina", "Ramirez", "chili.olimpera@gmail.com"), new Usuario("Jose", "DiMartino", null));
		return usuarios;
	}

}
