package proyectoSistema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import proyectoSistema.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	Optional<Usuario> findByCorreo(String correo);

}
