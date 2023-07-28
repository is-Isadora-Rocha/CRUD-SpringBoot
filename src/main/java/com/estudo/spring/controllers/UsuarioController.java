package com.estudo.spring.controllers;
import com.estudo.spring.DTO.UsuarioDTO;
import com.estudo.spring.model.UsuarioModel;
import com.estudo.spring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioDTO user){
        /*No paramêtro foi trocado UsuarioModel pelo UsuarioDTO, pois altera o processo de comunicação
        * já que no DTO pode ser "escolhido" quais informações pode-se passar para o front-end
        * EX: Não quero que o front-end veja a senha do usuário, então eu monto o DTO
        * para que a senha seja 'null' */
            usuarioService.cadastrar(converterDTO(user));
            return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarUsuarios(@RequestBody UsuarioDTO user){
//        List <UsuarioDTO> usuarios = usuarioService.listarUsuarios(converterDTO(user));
//        return new ResponseEntity(usuarios, HttpStatus.CREATED);
        return new ResponseEntity(usuarioService.listarUsuarios(converterDTO(user)), HttpStatus.CREATED);
    }

    public UsuarioModel converterDTO (UsuarioDTO usuario){
        return UsuarioModel.builder()
                .login(usuario.getLogin())
                .senha(usuario.getSenha())
                .dataCadastro(usuario.getDataCadastro())
                .nome(usuario.getNome()).build();


    }
}
