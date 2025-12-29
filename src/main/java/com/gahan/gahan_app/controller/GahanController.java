package com.gahan.gahan_app.controller;

import com.gahan.gahan_app.entity.Gahan;
import com.gahan.gahan_app.service.GahanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gahan")
public class GahanController {

    private final GahanService gahanService;

    public GahanController(GahanService gahanService) {
        this.gahanService = gahanService;
    }

    @PostMapping
    public Gahan createGahan(@RequestBody Gahan gahan) {
        return gahanService.createGahan(gahan);
    }
}
