import org.example.services.DnaService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DnaServicesTest {

    @Test
    public void testIsMutant1(){
        String[] dna = {
                        "AAAA",
                        "CCCC",
                        "TCAG",
                        "GGTC"
                       };

        boolean resultado = DnaService.isMutant(dna);
        assertTrue(resultado);
    }

    @Test
    public void testIsMutant2(){
        String[] dna = {
                "AAAT",
                "AACC",
                "AAAC",
                "CGGG"
        };

        boolean resultado = DnaService.isMutant(dna);
        assertFalse(resultado);
    }

    @Test
    public void testIsMutant3(){
        String[] dna = {
                "AAAA",
                "AAAA",
                "AAAA",
                "AAAA"
        };

        boolean resultado = DnaService.isMutant(dna);
        assertFalse(resultado);
    }

    @Test
    public void testIsMutant4(){
        String[] dna = {
                "ATGATG",
                "GTCTTA",
                "AATTGG",
                "ACTAGT",
                "GGATTC",
                "AGGCAA"
        };

        boolean resultado = DnaService.isMutant(dna);
        assertFalse(resultado);
    }


    @Test
    public void testIsMutant5(){
        String[] dna = {
                "ATAATG",
                "GTATGA",
                "GCTTAG",
                "TTTAGG",
                "GTAGTC",
                "AGTCAA"
        };

        boolean resultado = DnaService.isMutant(dna);
        assertTrue(resultado);
    }


    @Test
    public void testIsMutant6(){
        String[] dna = {
                "TCGGGTGAT",
                "TGATCCTTT",
                "TACGAGTGA",
                "AAATGTACG",
                "ACGAGTGCT",
                "AGACACATG",
                "GAATTCCAA",
                "ACTACGACC",
                "TGAGTATCC"
        };

        boolean resultado = DnaService.isMutant(dna);
        assertTrue(resultado);
    }


    @Test
    //matriz 20x20, solo tiene secuencias en las ultimas diagonales derecha y en la ultima diagonal izquierda
    public void testIsMutant7(){
        String[] dna = {
                "CGGAGACAGCCACACAGAAG",
                "TCTATCCACGTGGGTTCCAT",
                "ACTTAAATGTGGCAACCGAG",
                "GATTATGCTTCTAAGATATC",
                "CGCCTCGCCCTTAAAGCACT",
                "AATACACTAAACCTTCGTTA",
                "CTCTGTTGAATATCGTGAGA",
                "GGGTACGGGTTGCGAAGACG",
                "ACGGTTCCGACAATGACAAG",
                "CGAGGAGTCTGGACCGTGTT",
                "CTATAACAGTTAGGCAACGA",
                "TGCTAGTCAGTGTGTCTATT",
                "GGTTGCGAGTCTCTCTAGGT",
                "TTAGAAGTAGCAAAGGCATT",
                "CATTTGAGGTTCGTAGGCAA",
                "CTTAGAGACATGAGAAGAGC",
                "CTTCCGTCGGCCGAAACTTT",
                "GCGACTTTCCTATAGCTTTA",
                "TCCTCGAACGTCTCCCATAT",
                "GACCAGCTTAGATTCATCTG",
        };

        boolean resultado = DnaService.isMutant(dna);
        assertTrue(resultado);
    }


    @Test
    //misma matriz que la anterior, pero eliminando una de las secuencias
    public void testIsMutant8(){
        String[] dna = {
                "CGGAGACAGCCACACAGAAG",
                "TCTATCCACGTGGGTTCCAT",
                "ACTTAAATGTGGCAACCGAG",
                "GATTATGCTTCTAAGATATC",
                "CGCCTCGCCCTTAAAGCACT",
                "AATACACTAAACCTTCGTTA",
                "CTCTGTTGAATATCGTGAGA",
                "GGGTACGGGTTGCGAAGACG",
                "ACGGTTCCGACAATGACAAG",
                "CGAGGAGTCTGGACCGTGTT",
                "CTATAACAGTTAGGCAACGA",
                "TGCTAGTCAGTGTGTCTATT",
                "GGTTGCGAGTCTCTCTAGGT",
                "TTAGAAGTAGCAAAGGCATT",
                "CATTTGAGGTTCGTAGGCAA",
                "CTTAGAGACATGAGAAGAGC",
                "CTTCCGTCGGCCGAAACTTT",
                "GCGACTTTCCTATAGCTTTA",
                "TCCTCGAACGTCTCCCACAT",
                "GACCAGCTTAGATTCATCTG",
        };

        boolean resultado = DnaService.isMutant(dna);
        assertFalse(resultado);
    }

}
