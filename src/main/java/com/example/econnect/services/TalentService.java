package com.example.econnect.services;

import com.example.econnect.dtos.TalentRequest;
import com.example.econnect.enums.TalentType;
import com.example.econnect.models.Talent;
import com.example.econnect.repositories.TalentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TalentService implements ITalentService {
    @Autowired
    TalentRepository talentRepository;

    @Override
    public List<Talent> getAllTalents(String type) {
        if(type.equals("ALL")){
            return talentRepository.findAll();
        }

        return talentRepository.findByType(TalentType.valueOf(type));
    }

    @Override
    public Talent createTalent(TalentRequest talentRequest){
        Talent talent=new Talent();
        talent.setName(talentRequest.getName());
        talent.setType(talentRequest.getType());
        talent.setDescription(talentRequest.getDescription());
        return talentRepository.save(talent);
    }
}
