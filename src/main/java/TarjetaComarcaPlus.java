public class TarjetaComarcaPlus implements TarjetaCredito {

    private static final float DESCUENTO_COMARCA_PLUS = 0.02f; //Descuento del 2% en el costo total "Bebidas + "Platos Principales"

    @Override
    public double calcularCosto(Pedido pedido, Propina propina) {
        double costoTotal = (pedido.calcularCostoTotalBebidas() + pedido.calcularCostoTotalPlatosPrincipales()) * (1 - DESCUENTO_COMARCA_PLUS);
        return costoTotal + propina.calcularPropina(costoTotal);
    }
}
