package com.maxdev.agendamento_notificacao_api.controller;


import com.maxdev.agendamento_notificacao_api.business.AgendamentoService;
import com.maxdev.agendamento_notificacao_api.controller.dto.in.AgendamentoRecordIn;
import com.maxdev.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecordIn agendamento){
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoRecordOut> buscarAgendamentoPorId(@PathVariable("id") Long id ){
        return ResponseEntity.ok(agendamentoService.buscarAgendamentoPorId(id));
    }
}
