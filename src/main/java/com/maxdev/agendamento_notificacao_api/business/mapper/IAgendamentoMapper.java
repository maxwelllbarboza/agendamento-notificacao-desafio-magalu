package com.maxdev.agendamento_notificacao_api.business.mapper;

import com.maxdev.agendamento_notificacao_api.controller.dto.in.AgendamentoRecordIn;
import com.maxdev.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.maxdev.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import org.mapstruct.Mapper;


import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {

    Agendamento paraEntity(AgendamentoRecordIn agendamento);

    AgendamentoRecordOut paraOut(Agendamento agendamento);

    // chama isso no service: aplicarCancelamento(agendamento)
    Agendamento aplicarCancelamento(Agendamento agendamento);

}

