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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuario_cl3")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idusu_cl3; 
	@Column(name="nomusu")
	private String nomusu;
	@Column (name="email")
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
	@JoinTable(name ="usuario_rol_cl3",
			joinColumns = @JoinColumn(name="idusu_cl3"),
			inverseJoinColumns = @JoinColumn(name="idrol_cl3"))
	private Set<Rol> rol;

}
