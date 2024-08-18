package com.example.econnect.dtos;

import com.example.econnect.enums.TalentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalentRequest {
    @NotBlank(message = "Name can not be empty.")
    private String name;
    private String description;
    @NotNull(message = "Type can not be empty.")
    @Enumerated(EnumType.STRING)
    private TalentType type;
}
