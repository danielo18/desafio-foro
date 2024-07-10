package desafio.api.foro.controller;

import desafio.api.foro.dominio.usuarios.DatosAutenticarUsuario;
import desafio.api.foro.dominio.usuarios.Usuario;
import desafio.api.foro.infra.security.DatosJWTToken;
import desafio.api.foro.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/login")
    public class AutenticacionController {
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private TokenService tokenService;
        @PostMapping
        public ResponseEntity autenticacionUsuario(@RequestBody @Valid DatosAutenticarUsuario datosAutenticacionUsuario){
            Authentication authtoken=new UsernamePasswordAuthenticationToken
                    (datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());
            var usuarioAutenticado=  authenticationManager.authenticate(authtoken);
            var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
        }
    }


