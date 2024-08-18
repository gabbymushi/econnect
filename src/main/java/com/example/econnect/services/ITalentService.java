package com.example.econnect.services;

import com.example.econnect.dtos.TalentRequest;
import com.example.econnect.models.Talent;

import java.util.List;

public interface ITalentService {
    List<Talent> getAllTalents(String type);

    Talent createTalent(TalentRequest talentRequest);
}
