package br.com.fiap.CPEvento.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"nome", "data", "url", "cidade"})
@Entity
@Table(name = "tb_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve ter no mínimo 3 caracteres")
    private String nome;


    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve ter no mínimo 3 caracteres")
    private String data;


    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve ter no mínimo 3 caracteres")
    private String url;


    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false) //CHAVE PRIMARIA DE CIDADE
    private Cidade cidade;


}