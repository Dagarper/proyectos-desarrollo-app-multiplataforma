package garcia_perez_david_di02_tarea;

/********************************************************************************
 ** Form generated from reading ui file 'MainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends QMainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QWidget centralwidget;
    public QLabel label;
    public QWidget layoutWidget;
    public QHBoxLayout horizontalLayout;
    public QVBoxLayout verticalLayout;
    public QPushButton btnAniadir;
    public QPushButton btnBorrarSeleccion;
    public QPushButton btnBorrarTodo;
    public QPushButton btnImprimir;
    public QTableWidget tableListaCompra;
    public QStatusBar statusbar;

    public MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1460, 951).expandedTo(MainWindow.minimumSizeHint()));
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(560, 20, 441, 71));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(120, 120, 120));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(120, 120, 120));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        label.setPalette(palette);
        QFont font = new QFont();
        font.setFamily("Lucida Sans Typewriter");
        font.setPointSize(20);
        font.setBold(true);
        font.setWeight(75);
        label.setFont(font);
        layoutWidget = new QWidget(centralwidget);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(220, 100, 1051, 631));
        horizontalLayout = new QHBoxLayout(layoutWidget);
        horizontalLayout.setObjectName("horizontalLayout");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        btnAniadir = new QPushButton(layoutWidget);
        btnAniadir.setObjectName("btnAniadir");
        btnAniadir.setIcon(new QIcon("src\\garcia_perez_david_di02_tarea\\add.png"));//Se incluye la ruta del directorio del proyecto donde se encuentra el icono.

        verticalLayout.addWidget(btnAniadir);

        btnBorrarSeleccion = new QPushButton(layoutWidget);
        btnBorrarSeleccion.setObjectName("btnBorrarSeleccion");

        verticalLayout.addWidget(btnBorrarSeleccion);

        btnBorrarTodo = new QPushButton(layoutWidget);
        btnBorrarTodo.setObjectName("btnBorrarTodo");

        verticalLayout.addWidget(btnBorrarTodo);

        btnImprimir = new QPushButton(layoutWidget);
        btnImprimir.setObjectName("btnImprimir");

        verticalLayout.addWidget(btnImprimir);


        horizontalLayout.addLayout(verticalLayout);

        tableListaCompra = new QTableWidget(layoutWidget);
        tableListaCompra.setObjectName("tableListaCompra");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(tableListaCompra.sizePolicy().hasHeightForWidth());
        tableListaCompra.setSizePolicy(sizePolicy);
        tableListaCompra.setMaximumSize(new QSize(1011, 791));
        tableListaCompra.setAutoFillBackground(false);
        tableListaCompra.setRowCount(0);
        tableListaCompra.setColumnCount(5);

        horizontalLayout.addWidget(tableListaCompra);

        MainWindow.setCentralWidget(centralwidget);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
        
       
        
        
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Lista de la compra", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "LISTA DE LA COMPRA", null));
        btnAniadir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "A\u00f1adir", null));
        btnBorrarSeleccion.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Borrar selecci\u00f3n", null));
        btnBorrarTodo.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Borrar todo", null));
        btnImprimir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Imprimir", null));
        tableListaCompra.clear();
        tableListaCompra.setColumnCount(5);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Seleccion", null));
        tableListaCompra.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Nombre", null));
        tableListaCompra.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cantidad", null));
        tableListaCompra.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Seccion", null));
        tableListaCompra.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00bfEs urgente?", null));
        tableListaCompra.setHorizontalHeaderItem(4, __colItem4);
        tableListaCompra.setRowCount(0);
        
    /**
    * Conecta los botones de la interfaz a los métodos correspondientes para manejar eventos.
    * 
    * - btnAniadir: Abre un formulario para añadir un nuevo producto.
    * - btnBorrarSeleccion: Elimina los elementos seleccionados en la tabla.
    * - btnBorrarTodo: Borra todos los elementos de la lista de compra.
    * - btnImprimir: Muestra un cuadro de diálogo con los productos en la lista de compra.
    */
        btnAniadir.clicked.connect(this, "mostrarFormulario()");
        btnBorrarSeleccion.clicked.connect(this, "borrarSeleccion()");
        btnBorrarTodo.clicked.connect(this, "borrarTodo()");
        btnImprimir.clicked.connect(this, "mostrarProductos()");
    } // setupUi
    
    
    
    /** Abre un formulario modal para añadir un nuevo producto a la lista de compra.
    * 
    * Este método crea una instancia de la clase `DialogFormulario`, configura su interfaz y lo muestra como un diálogo modal.
    * Si el usuario confirma la acción (haciendo clic en el botón "Aceptar" del formulario), se obtienen los datos introducidos,
    * y estos se añaden a la tabla de productos mediante el método `agregarProductoATabla()`.
    */
    
    public void mostrarFormulario() {
        DialogFormulario dialog = new DialogFormulario();
        dialog.setupUi(dialog);
        if (dialog.exec() == QDialog.DialogCode.Accepted.value()) {
            String[] datos = dialog.obtenerDatosProducto();
            agregarProductoATabla(datos);
        }
    }
    
    //Método para agregar el producto que se ha rellenado en el formulario a la tabla.
    /**
    * Agrega un nuevo producto a la tabla `tableListaCompra`.
    * 
    * Este método inserta una nueva fila en la tabla y añade un `QCheckBox` en la primera columna 
    * para marcar o desmarcar el producto. A continuación, los datos del producto se insertan en las
    * siguientes columnas de la tabla. Los datos se proporcionan como un arreglo de cadenas (`String[]`).
    * 
    * @param datos Un arreglo de `String` que contiene la información del producto:
    *              - datos[0]: Nombre del producto
    *              - datos[1]: Cantidad del producto
    *              - datos[2]: Sección (categoría) del producto
    *              - datos[3]: Urgencia del producto (por ejemplo, "Sí" o "No")
    */
    
    private void agregarProductoATabla(String[] datos) {
        // Obtener el número actual de filas en la tabla
        int row = tableListaCompra.rowCount();
        
        // Insertar una nueva fila al final de la tabla
        tableListaCompra.insertRow(row);
        
         // Crear el QCheckBox y agregarlo en la primera celda de la fila
        QCheckBox checkBox = new QCheckBox();
        checkBox.setChecked(false);  // Estado inicial: desmarcado
        tableListaCompra.setCellWidget(row, 0, checkBox);  // Agregar el checkbox en la primera celda.
        
        // Rellenar las celdas de la fila con los datos proporcionados
        for (int col = 0; col < datos.length; col++) {
            // Insertar los datos a partir de la segunda columna (col + 1)
            tableListaCompra.setItem(row, col+1, new QTableWidgetItem(datos[col]));
        }
    }
    
    
   /**
    * Elimina todos los elementos de la tabla `tableListaCompra`.
    * 
    * Este método borra el contenido de todas las celdas de la tabla sin eliminar la estructura de las columnas.
    * Después de borrar los contenidos, también establece el número de filas en 0, eliminando todas las filas existentes.
    */
    public void borrarTodo() {
        // Elimina el contenido de todas las celdas de la tabla, manteniendo la estructura de las columnas
        tableListaCompra.clearContents();
        
        // Ajusta el número de filas a 0, eliminando todas las filas de la tabla   
        tableListaCompra.setRowCount(0);
    }

    /**
    * Elimina todas las filas seleccionadas de la tabla `tableListaCompra`.
    * 
    * Recorre cada fila de la tabla desde la última hasta la primera, revisando si el 
    * QCheckBox` en la primera columna está marcado. Si está marcado, elimina la fila correspondiente.
    * 
    * Este método sirve para eliminar uno o varios elementos de la tabla a la vez,
    * basándose en la selección del usuario.
    */
    public void borrarSeleccion() {
        // Recorre la tabla desde la última fila hasta la primera para evitar problemas de indexación
        for (int i = tableListaCompra.rowCount() - 1; i >= 0; i--) {
            
            // Obtiene el widget QCheckBox de la primera columna de la fila actual
            QCheckBox checkBox = (QCheckBox) tableListaCompra.cellWidget(i, 0);
             // Si el checkbox está marcado, elimina la fila
            if (checkBox.isChecked()) {
                tableListaCompra.removeRow(i);
            }
        }
    }
    
    /**
    * Muestra un cuadro de diálogo con la lista de productos en la tabla `tableListaCompra`.
    * 
    * Este método recorre todas las filas de la tabla y extrae los detalles del producto
    * (nombre, cantidad, sección y urgencia). Luego, crea un mensaje con estos detalles y
    * lo muestra en un `QMessageBox` con el título "Lista de Compra".
    * 
    * Si la tabla está vacía, el cuadro de diálogo simplemente mostrará el mensaje sin detalles.
    */
    public void mostrarProductos() {
        // Obtener los datos de la tabla en formato de texto
        StringBuilder productosTexto = new StringBuilder();
        // Recorrer todas las filas de la tabla para recopilar la información
        for (int fila = 0; fila < tableListaCompra.rowCount(); fila++) {
            String producto = tableListaCompra.item(fila, 1).text(); //Columna de nombre del producto
            String cantidad = tableListaCompra.item(fila, 2).text(); //Columna de cantidad
            String seccion = tableListaCompra.item(fila, 3).text();  //Columna de seccion
            String urgente = tableListaCompra.item(fila, 4).text();  //Columna de urgencia
            
            // Construir la cadena de texto con la información del producto
            productosTexto.append("Producto: ").append(producto)
                          .append(", Cantidad: ").append(cantidad).append(", Seccion: ").append(seccion).append(", Es Urgente: ").append(urgente+ ".").append("\n");
        }
        
        // Crear y configurar el QMessageBox para mostrar la información
        QMessageBox messageBox = new QMessageBox(this);
        messageBox.setWindowTitle("Lista de Compra"); //Establece el título de la ventana
        messageBox.setText("Productos en la lista de compra:"); //Introduce texto en el cuadro de mensaje
        messageBox.setInformativeText(productosTexto.toString()); // Agregar la lista de productos al cuadro de mensaje
        messageBox.setIcon(QMessageBox.Icon.Information); //Icono de información
        messageBox.exec();// Muestra el cuadro de diálogo.
    }
    
    
    
    
    
}



