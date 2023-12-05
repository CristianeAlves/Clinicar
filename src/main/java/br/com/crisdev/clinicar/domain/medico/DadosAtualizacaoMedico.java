package br.com.crisdev.clinicar.domain.medico;

import br.com.crisdev.clinicar.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
