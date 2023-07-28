package com.estudo.spring.serviceImpl;

import com.estudo.spring.DTO.UsuarioDTO;
import com.estudo.spring.model.UsuarioModel;
import com.estudo.spring.repositories.UsuarioRepository;
import com.estudo.spring.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    public UsuarioRepository userRepository;

    @Override
    public UsuarioModel cadastrar(UsuarioModel usuarioModel) {
        boolean usuarioExiste = userRepository.existsByLogin(usuarioModel.getLogin());
        if (!usuarioExiste) {
            usuarioModel.setDataCadastro(new Date());
            return userRepository.save(usuarioModel);
        } else {
            return null;
        }
    }

    @Override
    public List<UsuarioDTO> listarUsuarios(UsuarioModel usuario) {
        List<UsuarioDTO> dtos = new ArrayList<>();
        if (userRepository.existsByLogin(usuario.getLogin())) {
        List<UsuarioModel> usuarioBanco = userRepository.findAll();
        for (UsuarioModel usuarios : usuarioBanco) {
            dtos.add(UsuarioDTO.builder()
                    .nome(usuarios.getNome())
                    .login(usuarios.getLogin())
                    .dataCadastro(usuarios.getDataCadastro()).build());
        }
        return dtos;
        } else {
            return dtos;
        }
    }
}