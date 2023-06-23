package com.example.DAWI_CL3_Grupo3.model.bd;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuariocl3")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusu_cl3; 
	@Column(name="nomusu_cl3")
	private String nomusuario;
	@Column (name="email_cl3")
	private String email; 
	@Column(name="pass_cl3")
	private String pass_cl3; 
	@Column(name="nom_cl3")
	private String nom_cl3; 
	@Column (name="ape_cl3")
	private String ape_cl3; 
	@Column (name="activo")
	private Boolean activo; 
	
	@ManyToMany(cascade = CascadeType.MERGE, 
			fetch = FetchType.EAGER)
	@JoinTable(name ="usuariorolcl3",
			joinColumns = @JoinColumn(name="idusu_cl3"),
			inverseJoinColumns = @JoinColumn(name="idrol_cl3"))
	private Set<Rol> rol;

}
