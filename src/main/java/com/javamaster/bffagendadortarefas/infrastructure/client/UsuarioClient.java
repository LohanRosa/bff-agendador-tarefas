package com.javamaster.bffagendadortarefas.infrastructure.client;


import com.javamaster.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.javamaster.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.javamaster.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.javamaster.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.javamaster.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.javamaster.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.javamaster.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader(value = "Authorization", required=false)String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);


    @DeleteMapping("/{email}")
    void deleteUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required=false)String token);

    @PutMapping
    UsuarioDTOResponse atualizaDadoUsuario(@RequestBody UsuarioDTORequest dto,
                                           @RequestHeader(value = "Authorization", required=false)String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false)String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false)String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastraEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader(value = "Authorization", required=false)String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader(value = "Authorization", required=false)String token);


}
