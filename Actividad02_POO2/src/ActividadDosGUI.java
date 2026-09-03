import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ActividadDosGUI extends JFrame {

    private JTextField txtNombre;
    private JTextField txtCantidad;
    private JButton btnRegistrar;
    private JTextArea areaProductos;
    private List<Producto> listaProductos;

    public ActividadDosGUI() {
        listaProductos = new ArrayList<Producto>();

        setTitle("Registro de Productos - Almacen");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 2, 5, 5));

        panelFormulario.add(new JLabel("Nombre del producto:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelFormulario.add(txtCantidad);

        btnRegistrar = new JButton("Registrar");
        panelFormulario.add(btnRegistrar);

        areaProductos = new JTextArea();
        areaProductos.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaProductos);

        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarProducto();
            }
        });
    }

    private void registrarProducto() {
        String nombre = txtNombre.getText();
        String cantidadTexto = txtCantidad.getText();

        if (nombre.isEmpty() || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe llenar todos los campos");
            return;
        }

        try {
            int cantidad = Integer.parseInt(cantidadTexto);
            Producto p = new Producto(nombre, cantidad);
            listaProductos.add(p);

            guardarEnArchivo(p);

            areaProductos.append(p.toString() + "\n");

            txtNombre.setText("");
            txtCantidad.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un numero");
        }
    }
    private void guardarEnArchivo(Producto p) {
        try {
            FileWriter fw = new FileWriter("stock.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(p.getNombreProducto() + ";" + p.getCantidad());
            pw.close();
        } catch (IOException e) {
            System.out.println("Error al guardar en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ActividadDosGUI ventana = new ActividadDosGUI();
        ventana.setVisible(true);
    }
}