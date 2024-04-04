import java.util.*;

public class Electrodomestico {
    private String codigo;
    private String descripcion;
    private double valor;
    private int stock;

    public Electrodomestico(String codigo, String descripcion, double valor, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor = valor;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getValor() {
        return valor;
    }

    public int getStock() {
        return stock;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double calcularIVA() {
        return this.valor * 0.19;
    }

    public double calcularTotal() {
        return this.valor + calcularIVA();
    }
}

class ElectrodomesticoPequeno extends Electrodomestico {
    public ElectrodomesticoPequeno(String codigo, String descripcion, double valor, int stock) {
        super(codigo, descripcion, valor, stock);
    }
}

class ElectrodomesticoMediano extends Electrodomestico {
    public ElectrodomesticoMediano(String codigo, String descripcion, double valor, int stock) {
        super(codigo, descripcion, valor, stock);
    }
}

class ElectrodomesticoGrande extends Electrodomestico {
    public ElectrodomesticoGrande(String codigo, String descripcion, double valor, int stock) {
        super(codigo, descripcion, valor, stock);
    }
}

class Almacen {
    private List<Electrodomestico> electrodomesticos;

    public Almacen() {
        this.electrodomesticos = new ArrayList<>();
    }

    public void agregarElectrodomestico(Electrodomestico e) {
        this.electrodomesticos.add(e);
    }

    public void comprar(String codigo) {
        for (Electrodomestico e : this.electrodomesticos) {
            if (e.getCodigo().equals(codigo)) {
                int stock = e.getStock();
                if (stock > 0) {
                    e.setStock(stock - 1);
                    System.out.println("Compra exitosa. Total a pagar: " + e.calcularTotal() + ", IVA: " + e.calcularIVA());
                } else {
                    System.out.println("Stock agotado.");
                }
                break;
            }
        }
    }

    public void mostrarProductos() {
        for (Electrodomestico e : this.electrodomesticos) {
            System.out.println("Código: " + e.getCodigo() + ", Descripción: " + e.getDescripcion() + ", Valor: " + e.getValor() + ", Stock: " + e.getStock());
        }
    }

    public Electrodomestico buscarProducto(String codigo) {
        for (Electrodomestico e : this.electrodomesticos) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
}

