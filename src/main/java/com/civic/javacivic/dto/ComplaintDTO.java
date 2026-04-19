package com.civic.javacivic.dto;

import com.civic.javacivic.model.Complaint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComplaintDTO {
    @NotNull
    private Complaint.Category category;

    @NotBlank
    private String description;

    @NotBlank
    private String address;

    private String imageUrl;
}
