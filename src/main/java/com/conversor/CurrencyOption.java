package com.conversor;

public enum CurrencyOption {
    USD("Dólar estadounidense"),
    EUR("Euro"),
    BRL("Real brasileño"),
    ARS("Peso argentino"),
    CLP("Peso chileno"),
    MXN("Peso mexicano"),
    COP("Peso colombiano"),
    GBP("Libra esterlina"),
    JPY("Yen japonés"),
    CNY("Yuan chino");

    private final String descripcion;

    CurrencyOption(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return this.name();
    }

    public String getDescripcion() {
        return descripcion;
    }
}
