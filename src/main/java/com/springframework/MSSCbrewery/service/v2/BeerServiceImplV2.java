package com.springframework.MSSCbrewery.service.v2;

import com.springframework.MSSCbrewery.web.model.v2.BeerDTOV2;
import com.springframework.MSSCbrewery.web.model.v2.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImplV2 implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.LAGER)
                .upc(53532532525L)
                .build();
    }

    @Override
    public BeerDTOV2 saveNewBeer(BeerDTOV2 beerDTO) {
        return BeerDTOV2.builder()
                .id(UUID.randomUUID())
                .beerStyle(BeerStyle.ALE)
                .upc(53532532526L)
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {
        //TODO imlplementation ...
    }

    @Override
    public void deleteByBeer(UUID beerId) {
        log.debug("deleting beer");
    }
}
