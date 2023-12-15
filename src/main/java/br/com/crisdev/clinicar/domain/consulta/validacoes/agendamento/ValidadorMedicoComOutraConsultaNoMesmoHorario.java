package br.com.crisdev.clinicar.domain.consulta.validacoes.agendamento;

import br.com.crisdev.clinicar.domain.ValidacaoException;
import br.com.crisdev.clinicar.domain.consulta.ConsultaRepository;
import br.com.crisdev.clinicar.domain.consulta.DadosAgendamentoConsulta;
import br.com.crisdev.clinicar.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
