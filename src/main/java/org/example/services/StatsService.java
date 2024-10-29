package org.example.services;

import org.example.dto.StatsResponse;
import org.example.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    public StatsResponse getStats(){
        long countMutantDna = dnaRepository.countByIsMutant(true);
        long countHumanDna = dnaRepository.countByIsMutant(false);
        double ratio = countHumanDna==0 ? 0 : (double)countMutantDna/countHumanDna;

        return new StatsResponse(countMutantDna, countHumanDna, ratio);
    }

}
