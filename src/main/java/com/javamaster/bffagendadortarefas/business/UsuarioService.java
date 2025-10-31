package com.javamaster.bffagendadortarefas.business;

import com.javamaster.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javamaster.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javamaster.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javamaster.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javamaster.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javamaster.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javamaster.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.javamaster.bffagendadortarefas.infrastructure.client.UsuarioClient;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);
    }

    public String loginUsuario(LoginRequestDTO dto) {
        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token) {
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deleteUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(String token, UsuarioDTORequest dto) {
        return client.atualizaDadoUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token) {
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto) {
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto) {
       return client.cadastraTelefone(dto, token);
    }

}
