package org.example.entities;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Dna extends Base implements Serializable {

    private String[] dna;
    private boolean isMutant;
}
