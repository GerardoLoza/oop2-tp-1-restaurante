package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<Bebida> bebidasSeleccionadas;
    private List<PlatoPrincipal> platosPrincipalesSeleccionados;
    private boolean confirmado;
    private LocalDate fechaPedido;

    public Pedido() {
        this.bebidasSeleccionadas = new ArrayList<>();
        this.platosPrincipalesSeleccionados = new ArrayList<>();
        this.confirmado = false;
    }

    public void agregarBebida(Bebida bebida) {
        if (confirmado) {
            throw new RuntimeException("El pedido ya fue confirmado y no se pueden agregar mas bebidas");
        }
        bebidasSeleccionadas.add(bebida);
    }

    public void agregarPlatoPrincipal(PlatoPrincipal platoPrincipal) {
        if (confirmado) {
            throw new RuntimeException("El pedido ya fue confirmado y no se pueden agregar mas platos principales");
        }
        platosPrincipalesSeleccionados.add(platoPrincipal);
    }

    public double calcularCostoTotalBebidas() {
        return bebidasSeleccionadas.stream()
                .mapToDouble(Bebida::getPrecio)
                .sum();
    }

    public double calcularCostoTotalPlatosPrincipales() {
        return platosPrincipalesSeleccionados.stream()
                .mapToDouble(PlatoPrincipal::getPrecio)
                .sum();
    }

    public void confirmarPedido() {
        this.fechaPedido = LocalDate.now();
        confirmado = true;
    }

    public String obtenerFechaPedido() {
        return fechaPedido.toString();
    }
}
