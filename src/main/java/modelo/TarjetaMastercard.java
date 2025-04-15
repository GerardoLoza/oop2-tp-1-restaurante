package modelo;

public class TarjetaMastercard implements TarjetaCredito {

    private static final float DESCUENTO_MASTERCARD = 0.02f; //Descuento del 2% en el total de los platos principales

    @Override
    public double calcularCosto(Pedido pedido, Propina propina) {
        double costoTotal = pedido.calcularCostoTotalPlatosPrincipales() * (1 - DESCUENTO_MASTERCARD) + pedido.calcularCostoTotalBebidas();
        return costoTotal + propina.calcularPropina(costoTotal);
    }
}
