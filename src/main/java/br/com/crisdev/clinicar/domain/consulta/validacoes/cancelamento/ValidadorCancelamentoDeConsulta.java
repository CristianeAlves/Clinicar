package br.com.crisdev.clinicar.domain.consulta.validacoes.cancelamento;

import br.com.crisdev.clinicar.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
