import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MesaTest {

    @Test
    public void calcularDescuentoVisa() {
        Mesa mesa1 = new Mesa(3);
        var tarjetaVisa = new TarjetaVisa();
        Menu menu = new Menu(
                List.of(new Bebida("Coca-Cola", 3500)),
                List.of(new PlatoPrincipal("Milanesa con papas fritas", 12000))
        );

        Pedido pedido = new Pedido();
        pedido.agregarBebida(menu.getBebida("Coca-Cola"));
        pedido.agregarPlatoPrincipal(menu.getPlatoPrincipal("Milanesa con papas fritas"));
        pedido.confirmarPedido();

        assertEquals(15702.90, mesa1.calcularCostoTotal(pedido, tarjetaVisa, Propina.BAJA), 0.01f);
        assertEquals(15856.85, mesa1.calcularCostoTotal(pedido, tarjetaVisa, Propina.MEDIA), 0.01f);
        assertEquals(16164.75, mesa1.calcularCostoTotal(pedido, tarjetaVisa, Propina.ALTA), 0.01f);
    }

    @Test
    public void calcularDescuentoMastercard() {
        Mesa mesa1 = new Mesa(3);
        var tarjetaMastercard = new TarjetaMastercard();
        Menu menu = new Menu(
                List.of(new Bebida("Coca-Cola", 3500)),
                List.of(new PlatoPrincipal("Hamburguesa con papas fritas", 12000))
        );

        Pedido pedido = new Pedido();
        pedido.agregarBebida(menu.getBebida("Coca-Cola"));
        pedido.agregarPlatoPrincipal(menu.getPlatoPrincipal("Hamburguesa con papas fritas"));
        pedido.confirmarPedido();

        assertEquals(15565.20, mesa1.calcularCostoTotal(pedido, tarjetaMastercard, Propina.BAJA), 0.01f);
        assertEquals(15717.80, mesa1.calcularCostoTotal(pedido, tarjetaMastercard, Propina.MEDIA), 0.01f);
        assertEquals(16023.00, mesa1.calcularCostoTotal(pedido, tarjetaMastercard, Propina.ALTA), 0.01f);
    }

    @Test
    public void calcularDescuentoComarcaPlus() {
        Mesa mesa1 = new Mesa(3);
        var tarjetaComarcaPlus = new TarjetaComarcaPlus();
        Menu menu = new Menu(
                List.of(new Bebida("Coca-Cola", 3500)),
                List.of(new PlatoPrincipal("Milanesa con papas fritas", 12000))
        );

        Pedido pedido = new Pedido();
        pedido.agregarBebida(menu.getBebida("Coca-Cola"));
        pedido.agregarPlatoPrincipal(menu.getPlatoPrincipal("Milanesa con papas fritas"));
        pedido.confirmarPedido();

        assertEquals(15493.80, mesa1.calcularCostoTotal(pedido, tarjetaComarcaPlus, Propina.BAJA), 0.01f);
        assertEquals(15645.70, mesa1.calcularCostoTotal(pedido, tarjetaComarcaPlus, Propina.MEDIA), 0.01f);
        assertEquals(15949.50, mesa1.calcularCostoTotal(pedido, tarjetaComarcaPlus, Propina.ALTA), 0.01f);
    }

    @Test
    public void calcularDescuentoViedma() {
        var tarjetaCreditoViedma = new TarjetaViedma();
        Mesa mesa1 = new Mesa(3);

        Menu menu = new Menu(
                List.of(new Bebida("Coca-Cola", 3500)),
                List.of(new PlatoPrincipal("Milanesa con papas fritas", 12000))
        );

        Pedido pedido = new Pedido();
        pedido.agregarBebida(menu.getBebida("Coca-Cola"));
        pedido.agregarPlatoPrincipal(menu.getPlatoPrincipal("Milanesa con papas fritas"));
        pedido.confirmarPedido();

        assertEquals(15810, mesa1.calcularCostoTotal(pedido, tarjetaCreditoViedma, Propina.BAJA), 0.01f);
        assertEquals(15965, mesa1.calcularCostoTotal(pedido, tarjetaCreditoViedma, Propina.MEDIA), 0.01f);
        assertEquals(16275, mesa1.calcularCostoTotal(pedido, tarjetaCreditoViedma, Propina.ALTA), 0.01f);
    }
}
