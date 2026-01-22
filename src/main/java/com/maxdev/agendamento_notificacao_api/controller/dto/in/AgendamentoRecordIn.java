package com.maxdev.agendamento_notificacao_api.controller.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.maxdev.agendamento_notificacao_api.infrastructure.enums.StatusNotificacaoEnum;

import java.time.LocalDateTime;

public record AgendamentoRecordIn(Long id, String emailDestinatario,
                                  String telefoneDestinatario,
                                  String mensagem,
                                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                  LocalDateTime dataHoraEnvio,
                                  StatusNotificacaoEnum statusNotificacaoEnum) {
}




