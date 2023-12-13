package br.com.crisdev.clinicar.domain.consulta.validacoes;

import br.com.crisdev.clinicar.domain.ValidacaoException;
import br.com.crisdev.clinicar.domain.consulta.DadosAgendamentoConsulta;
import br.com.crisdev.clinicar.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo");
        }
    }
}
