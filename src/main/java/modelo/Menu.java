package modelo;

import java.util.List;

public class Menu {
    private List<Bebida> bebidas;
    private List<PlatoPrincipal> platosPrincipales;

    public Menu(List<Bebida> bebidas, List<PlatoPrincipal> platosPrincipales) {
        this.bebidas = bebidas;
        this.platosPrincipales = platosPrincipales;
    }

    public Bebida getBebida(String nombre) {
        for (Bebida bebida : bebidas) {
            if (bebida.getNombre().equals(nombre)) {
                return bebida;
            }
        }
        throw new IllegalArgumentException("Bebida no encontrada: " + nombre);
    }

    public PlatoPrincipal getPlatoPrincipal(String nombre) {
        for (PlatoPrincipal platoPrincipal : platosPrincipales) {
            if (platoPrincipal.getNombre().equals(nombre)) {
                return platoPrincipal;
            }
        }
        throw new IllegalArgumentException("Plato favorito no encontrado: " + nombre);
    }
}
