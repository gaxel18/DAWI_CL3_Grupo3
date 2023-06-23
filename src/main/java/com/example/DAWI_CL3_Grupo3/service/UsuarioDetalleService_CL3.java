package com.example.DAWI_CL3_Grupo3.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.DAWI_CL3_Grupo3.model.bd.Usuario;
import com.example.DAWI_CL3_Grupo3.model.bd.Rol;

@Service
public class UsuarioDetalleService_CL3 implements UserDetailsService {
	@Autowired
	private UsuarioService_CL3 usuarioService_cl3;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = 
				usuarioService_cl3
				.buscarPorNombre(username);		
		return usuarioPorAutenticacion(usuario, 
				obtenerAutorizacionUsuario(usuario.getRol()));
	}
	
	private List<GrantedAuthority> 
		obtenerAutorizacionUsuario(
				Set<Rol> listRoles){
		Set<GrantedAuthority> roles = 
				new HashSet<GrantedAuthority>();
		for(Rol rol: listRoles) {
			roles.add(new 
					SimpleGrantedAuthority(rol.getNomrol()));
		}
		List<GrantedAuthority> grantedAuthorities 
			= new ArrayList<>(roles);
		return grantedAuthorities;
		
		
	}
	
	private UserDetails usuarioPorAutenticacion(
			Usuario usuario,
			List<GrantedAuthority> authorityList) {
		return new User(
				usuario.getNomusuario(),
				usuario.getPass_cl3(),
				usuario.getActivo(),
				true, true, true, authorityList);
	}

}
