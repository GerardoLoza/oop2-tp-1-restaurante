package modelo;

import persistencia.Almacenamiento;

public class Mesa {
    private int capacidad;
    private Almacenamiento almacenamiento;

    public Mesa(int capacidad, Almacenamiento almacenamiento) {
        this.capacidad = capacidad;
        this.almacenamiento = almacenamiento;
    }

    public double calcularCostoTotal(Pedido pedido, TarjetaCredito tarjetaCredito, Propina propina) {
        double costoTotal = tarjetaCredito.calcularCosto(pedido, propina);
        String registro = pedido.obtenerFechaPedido() + "||" + costoTotal;
        almacenamiento.registrar(registro);
        return costoTotal;
    }
}
