package com.correios.api.domain.ports;

import com.correios.api.adapters.controllers.MaxDeliveryDateRequest;

public interface CorreiosPort {

    String getMaxDeliveryDate(MaxDeliveryDateRequest dados);
}
