package com.sistema.appqrcode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.appqrcode.models.Usuario;
import com.sistema.appqrcode.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll(); 
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrar(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/{id}")
	void removerUsuario(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Usuario atualizar(@RequestBody Usuario novousuario, @PathVariable Long id) {
		
		return usuarioRepository.findById(id)
			      .map(usuario -> {
			    	  usuario.setNome(novousuario.getNome());
			    	  usuario.setTituloQrcode(novousuario.getTituloQrcode());
			    	  usuario.setImgQrcode(novousuario.getImgQrcode());
			    	  usuario.setTituloConteudo(novousuario.getTituloConteudo());
			    	  usuario.setDescricaoConteudo(novousuario.getDescricaoConteudo());
			    	  usuario.setLinkConteudo(novousuario.getLinkConteudo());
			          return usuarioRepository.save(usuario);
			        })
			        .orElseGet(() -> {
			        	novousuario.setId(id);
			          return usuarioRepository.save(novousuario);
			        });
		
	}
}
