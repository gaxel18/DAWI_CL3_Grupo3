package com.example.DAWI_CL3_Grupo3.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DAWI_CL3_Grupo3.model.bd.Rol;
import com.example.DAWI_CL3_Grupo3.model.bd.Usuario;
import com.example.DAWI_CL3_Grupo3.repository.RolRepository_CL3;
import com.example.DAWI_CL3_Grupo3.repository.UsuarioRepository_CL3;

@Service
public class UsuarioService_CL3 {
	@Autowired
	private UsuarioRepository_CL3 usuarioRepositorycl3;
	
	@Autowired
	private RolRepository_CL3 rolRepositorycl3;
	
	private BCryptPasswordEncoder 
		bCryptPasswordEncoder = 
			new BCryptPasswordEncoder();
	
	public Usuario buscarPorNombre
		(String nomusu) {
		return usuarioRepositorycl3
				.findByNomusuario(nomusu);
	}
	
	public Usuario guardarUsuario(
			Usuario usuario) {
		usuario.setPass_cl3(
				bCryptPasswordEncoder
					.encode(usuario.getPass_cl3()));
		usuario.setActivo(true);
		Rol rol = rolRepositorycl3
				.findByNomrol("ADMIN");
		usuario.setRol(new HashSet<Rol>(
				Arrays.asList(rol)));
		return usuarioRepositorycl3.save(usuario);
	}

}