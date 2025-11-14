package com.javamaster.bffagendadortarefas.business;


import com.javamaster.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.javamaster.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviarEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }


}
