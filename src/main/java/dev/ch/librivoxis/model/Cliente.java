package dev.ch.librivoxis.model;

import dev.ch.librivoxis.enums.ClienteTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private ClienteTipo customerType;

}
