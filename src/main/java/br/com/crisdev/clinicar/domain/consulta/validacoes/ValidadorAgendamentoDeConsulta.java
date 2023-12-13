package br.com.crisdev.clinicar.domain.consulta.validacoes;

import br.com.crisdev.clinicar.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {

    void validar(DadosAgendamentoConsulta dados);
}
