package com.beerhouse.application.port;

import com.beerhouse.adapter.input.api.CervejaRequest;

import java.util.Collection;

public interface FindAllCervejaPort {

    Collection<CervejaRequest> collect();
}
