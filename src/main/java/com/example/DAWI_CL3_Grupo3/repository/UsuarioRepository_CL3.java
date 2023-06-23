package com.example.DAWI_CL3_Grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.DAWI_CL3_Grupo3.model.bd.Usuario;

@Repository
public interface UsuarioRepository_CL3 extends JpaRepository<Usuario, Integer>{
	
	Usuario findByEmail(String email);
	
	Usuario findByNomusuario(String nomusu);

}
