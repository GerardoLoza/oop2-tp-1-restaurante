public enum Propina {
    BAJA(0.02),
    MEDIA(0.03),
    ALTA(0.05);

    private final double porcentaje;

    Propina(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double calcularPropina(double monto) {
        return monto * porcentaje;
    }
}
