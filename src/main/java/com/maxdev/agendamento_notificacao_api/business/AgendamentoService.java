package com.maxdev.agendamento_notificacao_api.business;

import com.maxdev.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.maxdev.agendamento_notificacao_api.controller.dto.in.AgendamentoRecordIn;
import com.maxdev.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.maxdev.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.maxdev.agendamento_notificacao_api.infrastructure.enums.StatusNotificacaoEnum;
import com.maxdev.agendamento_notificacao_api.infrastructure.exception.NotFoundException;
import com.maxdev.agendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecordIn agendamento) {
        return agendamentoMapper.paraOut(
                repository.save(
                        agendamentoMapper.paraEntity(agendamento)
                )
        );
    }

    public AgendamentoRecordOut buscarAgendamentoPorId(long id) {
        return agendamentoMapper.paraOut(
                repository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Id não encontrado."))
        );
    }

    public void cancelarAgendamento(Long id) {
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Id não encontrado."));

        agendamento.setStatusNotificacao(StatusNotificacaoEnum.CANCELADO);
        agendamento.setDataHoraModificacao(LocalDateTime.now());

        repository.save(agendamento);
    }

}

