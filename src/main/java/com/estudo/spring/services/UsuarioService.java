package com.estudo.spring.services;
import com.estudo.spring.DTO.UsuarioDTO;
import com.estudo.spring.model.UsuarioModel;

import java.util.List;

public interface UsuarioService {

    public UsuarioModel cadastrar(UsuarioModel usuarioModel);

    public List<UsuarioDTO> listarUsuarios(UsuarioModel usuario);

}
