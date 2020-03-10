package com.springframework.MSSCbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    /*
            DATA MEMBERS
    */
    @Null
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String customerName;
}
