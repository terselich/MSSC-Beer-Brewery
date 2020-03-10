package com.springframework.MSSCbrewery.web.model;

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
public class BeerDTO {
    /*
            DATA MEMBERS
     */
    @Null               // Not allow client set the id
    private UUID id;

    @NotBlank           // Not Blank beerName
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive   //must be positive value
    private Long upc;
}
