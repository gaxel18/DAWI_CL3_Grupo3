package com.example.DAWI_CL3_Grupo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.DAWI_CL3_Grupo3.model.bd.Rol;

@Repository
public interface RolRepository_CL3 extends JpaRepository<Rol, Integer>{
	
	Rol findByNomrol(String rolname);
}
