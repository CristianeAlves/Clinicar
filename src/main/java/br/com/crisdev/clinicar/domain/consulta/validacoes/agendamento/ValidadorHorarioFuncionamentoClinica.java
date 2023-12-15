package br.com.crisdev.clinicar.domain.consulta.validacoes.agendamento;

import br.com.crisdev.clinicar.domain.ValidacaoException;
import br.com.crisdev.clinicar.domain.consulta.DadosAgendamentoConsulta;
import br.com.crisdev.clinicar.domain.consulta.validacoes.agendamento.ValidadorAgendamentoDeConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var aposEncerramentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || aposEncerramentoDaClinica) {
            throw new ValidacaoException("Consulta fora de horário de funcionamento da clínica");
        }
    }
}
