package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.validators.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}
