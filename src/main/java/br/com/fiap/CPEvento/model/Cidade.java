package br.com.fiap.CPEvento.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"nome", "estado"})
@Entity
@Table(name = "tb_cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, message = "O campo deve ter no mínimo 3 caracteres")
    private String nome;


   @NotNull(message = "Campo requerido")
   @Size(min = 1, max = 2 ,message = "O campo deve ter no mínimo 1 caractere e no maximo 2")
    private String estado;

    @OneToMany(mappedBy = "cidade")
   private List<Evento> cidades = new ArrayList<>();

}