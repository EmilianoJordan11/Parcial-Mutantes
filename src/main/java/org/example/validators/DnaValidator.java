package org.example.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DnaValidator implements ConstraintValidator<ValidDna,String[]> {

    private static final String caracteresValidos = "ATCG";

    @Override
    public void initialize(ValidDna constrantAnnotation){

    }
    @Override
    public boolean isValid(String[] dna, ConstraintValidatorContext context){
        if(dna == null){
            return false;
        }
        int n = dna.length;
        if(n == 0){
            return false;
        }
        for(String fila : dna){
            if(fila == null || fila.length() != n){
                return false;
            }
            for(char c : fila.toCharArray()){
                if(caracteresValidos.indexOf(c) == -1){
                    return false;
                }
            }
        }
        return true;
    }
}
