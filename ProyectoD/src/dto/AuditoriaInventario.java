/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

public class AuditoriaInventario {
    private int id;
    private Date fecha;

    public AuditoriaInventario(int id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public void auditar() {
        // Lógica para auditar el inventario
        System.out.println("Auditoría realizada el " + fecha);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
