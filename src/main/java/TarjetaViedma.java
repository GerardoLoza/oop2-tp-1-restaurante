public class TarjetaViedma implements TarjetaCredito {

    //No posee descuentos

    @Override
    public double calcularCosto(Pedido pedido, Propina propina) {
        double costoTotal = pedido.calcularCostoTotalBebidas() + pedido.calcularCostoTotalPlatosPrincipales();
        return costoTotal + propina.calcularPropina(costoTotal);
    }
}
