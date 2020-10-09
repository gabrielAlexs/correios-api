package com.correios.api.adapters.controllers;

public class MaxDeliveryDateRequest {
    private String nCdServico;
    private String sCepOrigem;
    private String sCepDestino;

    public MaxDeliveryDateRequest() {};

    public String getnCdServico() {
        return nCdServico;
    }

    public void setnCdServico(String nCdServico) {
        this.nCdServico = nCdServico;
    }

    public String getsCepOrigem() {
        return sCepOrigem;
    }

    public void setsCepOrigem(String sCepOrigem) {
        this.sCepOrigem = sCepOrigem;
    }

    public String getsCepDestino() {
        return sCepDestino;
    }

    public void setsCepDestino(String sCepDestino) {
        this.sCepDestino = sCepDestino;
    }
}
