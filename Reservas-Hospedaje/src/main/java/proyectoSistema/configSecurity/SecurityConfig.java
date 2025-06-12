package proyectoSistema.configSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import proyectoSistema.model.Usuario;
import proyectoSistema.repository.UsuarioRepository;
import proyectoSistema.service.UsuarioService;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@Autowired
	private UsuarioService usuarioService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		.userDetailsService(usuarioService)
		.authorizeHttpRequests(auth -> auth
		        .requestMatchers(
		                "/css/**",
		                "/Imagenes/**",
		                "/",                  
		                "/login/**", "/login/registroUsuario",
		                "/habitaciones",       
		                "/habitaciones/**"     
		        ).permitAll()
		        .requestMatchers("/admin/**").hasRole("ADMIN")
		        .requestMatchers("/cliente/**").hasRole("CLIENTE")
		        .anyRequest().authenticated()
				)
		.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/rol/redireccionar", true)
				.failureUrl("/login?error=true")
				.permitAll()
				)
		.logout(logout -> logout
                .logoutUrl("/logout") 
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID") 
                .permitAll()
            );
		System.out.println("Configurando SecurityFilterChain con UserDetailsService: " + usuarioService);
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
	
	

}
