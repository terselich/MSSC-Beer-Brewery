package com.springframework.MSSCbrewery.web.controller;

import com.springframework.MSSCbrewery.web.model.BeerDTO;
import com.springframework.MSSCbrewery.service.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Deprecated
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})  //Get beer
    public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerId){
        // more control to return ResponseEntity
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping                //Post a new beer
    public ResponseEntity handlePost(@Valid @RequestBody BeerDTO beerDTO){
        BeerDTO saveDTO = beerService.saveNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        //location of the resource todo HOSTNAME URL
        headers.add("Location", "/api/v1/beer/" + saveDTO.getId().toString());
        //client knows the resource created
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})  //Update beer
    public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDTO beerDTO){
        beerService.updateBeer(beerId, beerDTO);
        // returning response
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})   //Delete beer
    @ResponseStatus(HttpStatus.NO_CONTENT)   //response body using this annotation
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteByBeer(beerId);
    }
}
