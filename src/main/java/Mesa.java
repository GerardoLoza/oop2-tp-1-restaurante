public class Mesa {
    private int capacidad;

    public Mesa(int capacidad) {
        this.capacidad = capacidad;
    }

    public double calcularCostoTotal(Pedido pedido, TarjetaCredito tarjetaCredito, Propina propina) {
        return tarjetaCredito.calcularCosto(pedido, propina);
    }
}
