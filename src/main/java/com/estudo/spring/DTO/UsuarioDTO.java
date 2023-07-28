package com.estudo.spring.DTO;

import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private Date dataCadastro;

}
