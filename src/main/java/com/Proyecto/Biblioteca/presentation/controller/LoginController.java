package com.Proyecto.Biblioteca.presentation.controller;

import com.Proyecto.Biblioteca.business.facade.UsuarioFacade;
import com.Proyecto.Biblioteca.business.service.HistorialReservaService;
import com.Proyecto.Biblioteca.domain.dto.LoginRequest;
import com.Proyecto.Biblioteca.domain.model.HistorialReserva;
import com.Proyecto.Biblioteca.domain.model.Usuario;
import com.Proyecto.Biblioteca.persistence.repository.HistorialReservaRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioFacade usuarioFacade;

    @Autowired
    private HistorialReservaService historialReservaService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(authToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Obtener el rol y nombre del usuario
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String role = roles.contains("ROLE_Administrador") ? "Administrador" : "Lector";
        String username = authentication.getName();

        // Obtener los detalles completos del usuario
        Optional<Usuario> usuarioOpt = usuarioFacade.buscarPorNombreUsuario(username);
        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Usuario usuario = usuarioOpt.get();

        List<HistorialReserva> historialReservas = historialReservaService.findByUsuario(username);

        Map<String, Object> response = new HashMap<>();
        response.put("role", role);
        response.put("username", username);
        response.put("usuario", usuario);
        response.put("historialReservas", historialReservas);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/default")
    public ResponseEntity<Void> defaultAfterLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_Administrador")) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/empleado")).build();
        } else if (roles.contains("ROLE_Lector")) {
            return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/")).build();
        }
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/login?error=true")).build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/usuario/actual")
    public ResponseEntity<Map<String, String>> obtenerUsuarioActual() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("username", username);
        userDetails.put("role", AuthorityUtils.authorityListToSet(authentication.getAuthorities()).toString());

        return ResponseEntity.ok(userDetails);
    }

}
