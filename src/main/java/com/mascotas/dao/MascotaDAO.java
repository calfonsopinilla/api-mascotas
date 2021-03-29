package com.mascotas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mascotas.model.Mascota;

public interface MascotaDAO extends JpaRepository<Mascota,String>{
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Mascota mascota WHERE mascota.id = :id")
	public String deleteMascotaById(@Param("id") String id);
	
	@Query("SELECT mascota FROM Mascota mascota WHERE mascota.id = :id")
	public Mascota getMascota(@Param("id") String id);
}
