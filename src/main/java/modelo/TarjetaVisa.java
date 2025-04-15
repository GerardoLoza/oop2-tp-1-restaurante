package modelo;

public class TarjetaVisa implements TarjetaCredito {

    private static final float DESCUENTO_VISA = 0.03f; //Descuento del 3% en el total de las bebidas

    @Override
    public double calcularCosto(Pedido pedido, Propina propina) {
        double costoTotal = pedido.calcularCostoTotalBebidas() * (1 - DESCUENTO_VISA) + pedido.calcularCostoTotalPlatosPrincipales();
        return costoTotal + propina.calcularPropina(costoTotal);
    }
}
