package com.mascotas.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mascotas.dao.MascotaDAO;
import com.mascotas.model.Mascota;

@RestController
@RequestMapping("api/mascotas")
@CrossOrigin("*")
public class MascotaRest {
	
	@Autowired
	private MascotaDAO mascotaDAO;
	
	@PostMapping("/post")
	public ResponseEntity<Mascota> postMascota(@RequestBody Mascota mascota) {
		Mascota res = mascotaDAO.save(mascota);
		return new ResponseEntity<Mascota>(res,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public List<Mascota> getMascotas(){
		return mascotaDAO.findAll();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Mascota> deleteMascota(@PathVariable("id") String id) {
		Mascota mascota = mascotaDAO.getMascota(id);
		if(mascota != null) {
			mascotaDAO.deleteById(id);
		}else {
			return new ResponseEntity<Mascota>(mascota, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Mascota>(mascota, HttpStatus.OK);
	}
}
