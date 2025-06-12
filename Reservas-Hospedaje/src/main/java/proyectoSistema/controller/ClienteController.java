package proyectoSistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ClienteController {

	@GetMapping("/cliente/inicio")
    public String inicioCliente(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        return "clienteInicio";
    }

    @GetMapping("/cliente/habitaciones")
    public String habitacionesCliente(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        return "clienteHabitaciones"; // aún por crear
    }

    @GetMapping("/cliente/mis-reservas")
    public String misReservas(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        return "cclienteMisReservas"; // aún por crear
    }

    @GetMapping("/cliente/mi-seleccion")
    public String miSeleccion(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        return "clienteMiSeleccion"; // aún por crear
    }

    @GetMapping("/cliente/perfil")
    public String perfil(HttpServletRequest request, Model model) {
        model.addAttribute("currentPath", request.getRequestURI());
        return "clientePerfil"; // aún por crear
    }
}
