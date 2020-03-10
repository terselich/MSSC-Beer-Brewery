package com.springframework.MSSCbrewery.web.model.v2;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

// I love Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDTOV2 {
    /*
            DATA MEMBERS
     */
    @Null                   //Not allow client set the id
    private UUID id;

    @NotBlank
    private String beerName;

    //ENUM (new business requirements)
    @NotBlank
    private BeerStyle beerStyle;

    @Positive
    private Long upc;
}
