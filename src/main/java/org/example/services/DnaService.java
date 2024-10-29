package org.example.services;

import org.example.entities.Dna;
import org.example.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DnaService {
    @Autowired
    public DnaRepository dnaRepository;


    public static String revisarFilas(String[] dna, int dimension, String secuenciasEncontradas){
        char aux;
        boolean letraIzquierda = false;
        boolean letraDerecha = false;

        for (int i = 0; i <= dimension; i++) {
            letraIzquierda = false;
            letraDerecha = false;
            aux= dna[i].charAt(0); //primer letra de la fila

            for (int j = 2; j <= dimension; j+=2) {
                if (aux == dna[i].charAt(j) && !secuenciasEncontradas.contains(""+aux)){ //si son iguales empiezo a comparar

                    //primero el elemento del medio, ya que es el que debe estar si o si
                    if (aux == dna[i].charAt(j-1)){//si no es el primer elemento de la fila
                        if (j>2){
                            letraIzquierda = aux == dna[i].charAt(j-3);
                        }
                        if (j!=dimension){ //si no es el ultimo elemento de la fila
                            letraDerecha = aux == dna[i].charAt(j+1);
                        }

                        //si alguna de las anteriores es true, hay secuencia
                        if (letraDerecha || letraIzquierda){
                            secuenciasEncontradas += aux; //agrego la letra para no repetir secuencias
                            if (secuenciasEncontradas.length()==2){
                                return secuenciasEncontradas;
                            }
                        }
                    }
                }
                aux=dna[i].charAt(j);
            }
        }
        return secuenciasEncontradas;
    }

    public static String revisarColumnas(String[] dna, int dimension, String secuenciasEncontradas){
        char aux;
        boolean letraArriba ;
        boolean letraAbajo;

        for (int i = 0; i <= dimension; i++) {
            letraArriba = false;
            letraAbajo = false;
            aux = dna[0].charAt(i); //primer letra de la columna

            for (int j = 2; j <= dimension; j+=2) {
                if (aux== dna[j].charAt(i) && !secuenciasEncontradas.contains(""+aux)){
                    //primero reviso el elemento del medio, ya que es el que debe estar si o si
                    if (aux== dna[j-1].charAt(i)){
                        if (j>2){//si no es el primer elemento de la columna
                            letraArriba= aux == dna[j-3].charAt(i);
                        }
                        if (j!=dimension){//si no es el ultimo elemento de la columna
                            letraAbajo = aux == dna[j+1].charAt(i);
                        }

                        //si alguna de las anteriores es true, hay secuencia
                        if (letraArriba || letraAbajo){
                            secuenciasEncontradas+=aux; //agrego la letra para no repetir secuencias
                            if (secuenciasEncontradas.length()==2){
                                return secuenciasEncontradas;
                            }
                        }
                    }
                }
                aux = dna[j].charAt(i);
            }
        }
        return secuenciasEncontradas;
    }

    public static String revisarDiagonales(String[] dna, int dimension, String secuenciasEncontradas){

        //columnas
        for (int i = 0; i <= dimension-3; i++) {
            secuenciasEncontradas = revisarDiagonalDerechaColumna(dna, dimension, i, secuenciasEncontradas);
            if (secuenciasEncontradas.length()==2){
                return secuenciasEncontradas;
            }
            secuenciasEncontradas=revisarDiagonalIzquierdaColumna(dna, dimension, i, secuenciasEncontradas);
            if (secuenciasEncontradas.length()==2){
                return secuenciasEncontradas;
            }
        }

        //filas
        for (int i = 1; i <= dimension-3; i++) { //desde 1 ya que la diagonal principal ya fue analizada
            secuenciasEncontradas =  revisarDiagonalDerechaFila(dna, dimension, i, secuenciasEncontradas);
            if (secuenciasEncontradas.length()==2){
                return secuenciasEncontradas;
            }
            secuenciasEncontradas =  revisarDiagonalIzquierdaFila(dna, dimension, i , secuenciasEncontradas);
            if (secuenciasEncontradas.length()==2){
                return secuenciasEncontradas;
            }
        }

        return secuenciasEncontradas;
    }

    public static String revisarDiagonalDerechaColumna(String[] dna, int dimension, int columna,String secuenciasEncontradas){
        boolean letraNoroeste;
        boolean letraSureste;
        char aux = dna[0].charAt(columna);

        //filas
        for (int i = 2; i <= dimension-columna; i+=2) {
            letraNoroeste= false;
            letraSureste = false;
            if (aux== dna[i].charAt(columna+i) && !secuenciasEncontradas.contains(""+aux)){
                //primero el elemento del medio, ya que es el que debe estar si o si
                if (aux== dna[i-1].charAt(columna+i-1)){
                    if (i>2){//si aux no es el primer elemento de la diagonal
                        letraNoroeste = aux==dna[i-3].charAt(columna+i-3);
                    }
                    if (i!=dimension-columna){//si no es el ultimo elemento de la diagonal
                        letraSureste = aux==dna[i+1].charAt(columna+i+1);
                    }
                    //si alguna de las anteriores es true, hay secuencia
                    if (letraNoroeste || letraSureste){
                        secuenciasEncontradas += aux;
                        if (secuenciasEncontradas.length()==2){
                            return secuenciasEncontradas;
                        }
                    }
                }
            }
            aux= dna[i].charAt(columna+i);
        }
        return secuenciasEncontradas;
    }

    public static String revisarDiagonalDerechaFila(String[] dna, int dimension, int fila,String secuenciasEncontradas){
        boolean letraNoroeste;
        boolean letraSureste;
        char aux = dna[fila].charAt(0);

        //columnas
        for (int i = 2; i <= dimension-fila; i+=2) {
            letraNoroeste= false;
            letraSureste = false;
            if (aux == dna[fila+i].charAt(i) && !secuenciasEncontradas.contains(""+aux)){
                //primero el elemento del medio, ya que es el que debe estar si o si
                if (aux==dna[fila+i-1].charAt(i-1)){
                    if (i>2){//si aux no es el primer elemento de la diagonal
                        letraNoroeste = aux==dna[fila+i-3].charAt(i-3);
                    }
                    if (i!=dimension-fila){//si no es el ultimo elemento de la diagonal
                        letraSureste = aux==dna[fila+i+1].charAt(i+1);
                    }
                    //si alguna de las anteriores es true, hay secuencia
                    if (letraNoroeste || letraSureste){
                        secuenciasEncontradas+=aux;
                        if (secuenciasEncontradas.length()==2){
                            return secuenciasEncontradas;
                        }
                    }
                }
            }
            aux= dna[fila+i].charAt(i);
        }
        return secuenciasEncontradas;
    }

    public static String  revisarDiagonalIzquierdaColumna(String[] dna, int dimension, int columna,String secuenciasEncontradas){
        boolean letraNoreste;
        boolean letraSuroeste;
        char aux = dna[0].charAt(dimension-columna);

        //filas
        for (int i = 2; i <= dimension-columna; i+=2) {
            letraNoreste= false;
            letraSuroeste= false;
            if (aux==dna[i].charAt(dimension-columna-i) && !secuenciasEncontradas.contains(""+aux)){
                //primero el elemento del medio, ya que es el que debe estar si o si
                if (aux==dna[i-1].charAt(dimension-i-columna+1)){
                    if (i>2){//si aux no es el primer elemento de la diagonal
                        letraNoreste = aux==dna[i-3].charAt(dimension-i-columna+3);
                    }
                    if (i!=dimension-columna){//si no es el ultimo elemento de la diagonal
                        letraSuroeste =  aux==dna[i+1].charAt(dimension-columna-i-1);
                    }
                    //si alguna de las anteriores es true, hay secuencia
                    if (letraNoreste || letraSuroeste){
                        secuenciasEncontradas+=aux;
                        if (secuenciasEncontradas.length()==2){
                            return secuenciasEncontradas;
                        }
                    }
                }
            }
            aux = dna[i].charAt(dimension-i-columna);
        }
        return secuenciasEncontradas;
    }


    public static String revisarDiagonalIzquierdaFila(String[] dna, int dimension, int fila,String secuenciasEncontradas){
        boolean letraNoreste;
        boolean letraSuroeste;
        char aux = dna[fila].charAt(dimension);

        //columnas
        for (int i = 2; i <= dimension-fila; i+=2) {
            letraNoreste = false;
            letraSuroeste= false;

            if (aux==dna[fila+i].charAt(dimension-i) && !secuenciasEncontradas.contains(""+aux)){
                //primero el elemento del medio, ya que es el que debe estar si o si
                if (aux==dna[fila+i-1].charAt(dimension-i+1)){
                    if (i>2){//si aux no es el primer elemento de la diagonal
                        letraNoreste = aux==dna[fila+i-3].charAt(dimension-i+3);
                    }
                    if (i!=dimension-fila){//si no es el ultimo elemento de la diagonal
                        letraSuroeste = aux==dna[fila+i+1].charAt(dimension-i-1);
                    }
                    //si alguna de las anteriores es true, hay secuencia
                    if (letraNoreste || letraSuroeste){
                        secuenciasEncontradas+=aux;
                        if (secuenciasEncontradas.length()==2){
                            return secuenciasEncontradas;
                        }
                    }
                }
            }
            aux=dna[fila+i].charAt(dimension-i);
        }
        return secuenciasEncontradas;
    }


public boolean analizeDna(String[] dna){
    //String secuencia =String.join(",", dna);
    Optional<Dna> dnaExistente = dnaRepository.findByDna(dna);

    if (dnaExistente.isPresent()){
        return dnaExistente.get().isMutant();
    }

    boolean isMutant = isMutant(dna);
    Dna dnaEntity = Dna.builder().dna(dna).isMutant(isMutant).build();
    dnaRepository.save(dnaEntity);

    return isMutant;
}


    public static boolean isMutant(String[] dna){
        int dimension = dna.length - 1;

        String secuenciasEncontradas = revisarFilas(dna, dimension, "");
        if (secuenciasEncontradas.length()==2) return true;

        secuenciasEncontradas = revisarColumnas(dna, dimension, secuenciasEncontradas);
        if (secuenciasEncontradas.length()==2) return true;

        secuenciasEncontradas = revisarDiagonales(dna, dimension, secuenciasEncontradas);
        return secuenciasEncontradas.length()>1;
    }
}
