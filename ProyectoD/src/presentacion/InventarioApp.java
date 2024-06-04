package presentacion;

import dto.Producto;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import negocio.InventarioNegocio;

public class InventarioApp extends JFrame {
    private InventarioNegocio inventarioNegocio;

    private JTable tblProductos;
    private DefaultTableModel tblModel;
    private JButton btnAgregar;
    private JButton btnRegistrarSalida;
    private JButton btnGenerarReporte;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtStock;

    public InventarioApp() {
        initComponents();
        inventarioNegocio = new InventarioNegocio();
    }

    private void initComponents() {
        setTitle("Aplicación de Inventario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tblModel = new DefaultTableModel(new Object[]{"ID", "Nombre", "Precio", "Stock"}, 0);
        tblProductos = new JTable(tblModel);
        JScrollPane scrollPane = new JScrollPane(tblProductos);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar Producto");
        btnRegistrarSalida = new JButton("Registrar Salida");
        btnGenerarReporte = new JButton("Generar Reporte");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnRegistrarSalida);
        panelBotones.add(btnGenerarReporte);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        btnRegistrarSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarSalida();
            }
        });

        btnGenerarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarReporte();
            }
        });

        // Panel para campos de entrada de producto
        JPanel panelEntrada = new JPanel(new GridLayout(4, 2));
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblId = new JLabel("ID:");
        txtId = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        JLabel lblPrecio = new JLabel("Precio:");
        txtPrecio = new JTextField();
        JLabel lblStock = new JLabel("Stock:");
        txtStock = new JTextField();

        panelEntrada.add(lblId);
        panelEntrada.add(txtId);
        panelEntrada.add(lblNombre);
        panelEntrada.add(txtNombre);
        panelEntrada.add(lblPrecio);
        panelEntrada.add(txtPrecio);
        panelEntrada.add(lblStock);
        panelEntrada.add(txtStock);

        add(panelEntrada, BorderLayout.NORTH);
    }

    private void agregarProducto() {
        // Obtener valores de los campos de entrada
        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        int stock = Integer.parseInt(txtStock.getText());

        Producto producto = new Producto(id, nombre, precio, stock);
        inventarioNegocio.agregarProducto(producto, stock);
        actualizarTabla();
    }

    private void registrarSalida() {
        // Aquí puedes implementar la lógica para registrar una salida de producto
        // Por simplicidad, simplemente registraremos la salida del primer producto en la tabla
        if (tblProductos.getRowCount() > 0) {
            Producto producto = new Producto((int) tblModel.getValueAt(0, 0), tblModel.getValueAt(0, 1).toString(), (double) tblModel.getValueAt(0, 2), (int) tblModel.getValueAt(0, 3));
            inventarioNegocio.registrarSalida(producto, 20);
            actualizarTabla();
        }
    }

    private void generarReporte() {
        inventarioNegocio.generarReporte();
    }

    private void actualizarTabla() {
        tblModel.setRowCount(0); // Limpiar tabla
        Map<Producto, Integer> productos = inventarioNegocio.getProductos();
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            Producto producto = entry.getKey();
            Integer stock = entry.getValue();
            tblModel.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getPrecio(), stock});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InventarioApp().setVisible(true);
            }
        });
    }
}



