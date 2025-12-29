package com.gahan.gahan_app.service.impl;

import com.gahan.gahan_app.entity.Gahan;
import com.gahan.gahan_app.repository.GahanRepository;
import com.gahan.gahan_app.service.GahanService;
import org.springframework.stereotype.Service;

@Service
public class GahanServiceImpl implements GahanService {

    private final GahanRepository gahanRepository;

    public GahanServiceImpl(GahanRepository gahanRepository) {
        this.gahanRepository = gahanRepository;
    }

    @Override
    public Gahan createGahan(Gahan gahan) {

        // 🧠 Business logic: calculate initial value
        double initialValue =
                gahan.getWeightInGrams() * gahan.getInitialRate();

        gahan.setInitialValue(initialValue);

        return gahanRepository.save(gahan);
    }
}
