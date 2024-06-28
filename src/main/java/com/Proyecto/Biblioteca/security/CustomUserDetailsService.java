package com.Proyecto.Biblioteca.security;

import com.Proyecto.Biblioteca.domain.model.Usuario;
import com.Proyecto.Biblioteca.persistence.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByNombresSesisonUsu(username);
        if (usuario.isPresent()){
            var usuarioObj = usuario.get();
            return User.builder()
                    .username(usuarioObj.getNombresSesisonUsu())
                    .password(usuarioObj.getPswSesesionUs())
                    .authorities(getAuthorities(usuarioObj))
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    private List<SimpleGrantedAuthority> getAuthorities(Usuario user) {
        if (user.getTipoUsu() == null) {
            return List.of(new SimpleGrantedAuthority("ROLE_Lector"));
        }
        return Arrays.stream(user.getTipoUsu().split(","))
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}
