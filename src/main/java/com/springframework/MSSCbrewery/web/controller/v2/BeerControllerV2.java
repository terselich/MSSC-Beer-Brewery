package com.springframework.MSSCbrewery.web.controller.v2;

import com.springframework.MSSCbrewery.service.v2.BeerServiceV2;
import com.springframework.MSSCbrewery.web.model.v2.BeerDTOV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

    private final BeerServiceV2 beerService;

    public BeerControllerV2(BeerServiceV2 beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})  //Get beer
    public ResponseEntity<BeerDTOV2> getBeer(@PathVariable("beerId") UUID beerId){
        // more control to return ResponseEntity
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping                //Post a new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDTOV2 beerDtoV2){
        BeerDTOV2 saveDTO = beerService.saveNewBeer(beerDtoV2);
        HttpHeaders headers = new HttpHeaders();
        //location of the resource todo HOSTNAME URL
        headers.add("Location", "/api/v2/beer/" + saveDTO.getId().toString());
        //client knows the resource created
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})  //Update beer
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDTOV2 beerDtoV2){
        beerService.updateBeer(beerId, beerDtoV2);
        // returning response
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})   //Delete beer
    @ResponseStatus(HttpStatus.NO_CONTENT)   //response body using this annotation
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteByBeer(beerId);
    }
}
