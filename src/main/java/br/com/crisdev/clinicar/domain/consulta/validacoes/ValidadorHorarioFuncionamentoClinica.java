package br.com.crisdev.clinicar.domain.consulta.validacoes;

import br.com.crisdev.clinicar.domain.ValidacaoException;
import br.com.crisdev.clinicar.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidadorHorarioFuncionamentoClinica {

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
