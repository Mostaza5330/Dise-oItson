/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

public class ReporteInventario {
    private int id;
    private Date fechaGeneracion;

    public ReporteInventario() {
        this.fechaGeneracion = new Date();
    }

    public void generar() {
        // Lógica para generar un reporte del inventario
        System.out.println("Reporte de inventario generado el " + fechaGeneracion);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }
}
