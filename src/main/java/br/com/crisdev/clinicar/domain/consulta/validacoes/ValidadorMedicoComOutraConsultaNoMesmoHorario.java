package br.com.crisdev.clinicar.domain.consulta.validacoes;

import br.com.crisdev.clinicar.domain.ValidacaoException;
import br.com.crisdev.clinicar.domain.consulta.DadosAgendamentoConsulta;
import br.com.crisdev.clinicar.domain.medico.MedicoRepository;

public class ValidadorMedicoComOutraConsultaNoMesmoHorario {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}