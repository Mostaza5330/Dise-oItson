/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.Producto;
import dto.ReporteInventario;

import java.util.HashMap;
import java.util.Map;

public class InventarioNegocio {
    private Map<Producto, Integer> productos;

    public InventarioNegocio() {
        this.productos = new HashMap<>();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        productos.put(producto, productos.getOrDefault(producto, 0) + cantidad);
    }

    public void actualizarStock(Producto producto, int cantidad) {
        productos.put(producto, cantidad);
    }

    public void registrarSalida(Producto producto, int cantidad) {
        if (productos.containsKey(producto)) {
            int stockActual = productos.get(producto);
            productos.put(producto, stockActual - cantidad);
        }
    }

    public ReporteInventario generarReporte() {
        // Lógica para generar un reporte del inventario
        ReporteInventario reporte = new ReporteInventario();
        reporte.generar();
        return reporte;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }
}
