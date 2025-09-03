package garcia_perez_david_di02_tarea;

/********************************************************************************
 ** Form generated from reading ui file 'DialogA�adirProducto.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class DialogFormulario extends QDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QPushButton btnAceptar;
    public QPushButton btnCancelar;
    public QLineEdit lineEditNombreProducto;
    public QSpinBox spinBoxCantidad;
    public QComboBox comboBoxSeccion;
    public QRadioButton radioButtonUrgenteSi;
    public QRadioButton radioButtonUrgenteNo;
    public QWidget widget;
    public QVBoxLayout verticalLayout;
    public QLabel labelNombreProducto_3;
    public QLabel labelCantidad_3;
    public QLabel labelSeccion;
    public QLabel labelUrgente;

    public DialogFormulario() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(592, 483).expandedTo(Dialog.minimumSizeHint()));
        btnAceptar = new QPushButton(Dialog);
        btnAceptar.setObjectName("btnAceptar");
        btnAceptar.setGeometry(new QRect(100, 380, 112, 34));
        btnCancelar = new QPushButton(Dialog);
        btnCancelar.setObjectName("btnCancelar");
        btnCancelar.setGeometry(new QRect(310, 380, 112, 34));
        lineEditNombreProducto = new QLineEdit(Dialog);
        lineEditNombreProducto.setObjectName("lineEditNombreProducto");
        lineEditNombreProducto.setGeometry(new QRect(250, 100, 311, 27));
        spinBoxCantidad = new QSpinBox(Dialog);
        spinBoxCantidad.setObjectName("spinBoxCantidad");
        spinBoxCantidad.setGeometry(new QRect(260, 160, 54, 27));
        spinBoxCantidad.setMinimum(1);
        comboBoxSeccion = new QComboBox(Dialog);
        comboBoxSeccion.setObjectName("comboBoxSeccion");
        comboBoxSeccion.setGeometry(new QRect(250, 220, 251, 27));
        radioButtonUrgenteSi = new QRadioButton(Dialog);
        QButtonGroup buttonGroupUrgente = new QButtonGroup(Dialog);
        buttonGroupUrgente.addButton(radioButtonUrgenteSi);
        radioButtonUrgenteSi.setObjectName("radioButtonUrgenteSi");
        radioButtonUrgenteSi.setGeometry(new QRect(260, 280, 124, 25));
        radioButtonUrgenteNo = new QRadioButton(Dialog);
        buttonGroupUrgente.addButton(radioButtonUrgenteNo);
        radioButtonUrgenteNo.setObjectName("radioButtonUrgenteNo");
        radioButtonUrgenteNo.setGeometry(new QRect(350, 280, 124, 25));
        widget = new QWidget(Dialog);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(80, 90, 163, 221));
        verticalLayout = new QVBoxLayout(widget);
        verticalLayout.setObjectName("verticalLayout");
        labelNombreProducto_3 = new QLabel(widget);
        labelNombreProducto_3.setObjectName("labelNombreProducto_3");
        labelNombreProducto_3.setFrameShape(QFrame.Shape.NoFrame);

        verticalLayout.addWidget(labelNombreProducto_3);

        labelCantidad_3 = new QLabel(widget);
        labelCantidad_3.setObjectName("labelCantidad_3");

        verticalLayout.addWidget(labelCantidad_3);

        labelSeccion = new QLabel(widget);
        labelSeccion.setObjectName("labelSeccion");

        verticalLayout.addWidget(labelSeccion);

        labelUrgente = new QLabel(widget);
        labelUrgente.setObjectName("labelUrgente");

        verticalLayout.addWidget(labelUrgente);

        retranslateUi(Dialog);

        Dialog.connectSlotsByName();
        
        /**
        * Conecta el botón "Aceptar" para cerrar el diálogo con un resultado de "aceptado".
        * 
        * Al hacer clic en `btnAceptar`, se ejecutará el método `accept()`, que cierra el diálogo 
        * actual y devuelve `QDialog.DialogCode.Accepted`. Esto indica que la operación fue 
        * exitosa o confirmada por el usuario.
        */
        btnAceptar.clicked.connect(this, "accept()");
        btnCancelar.clicked.connect(this, "reject()");
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "A\u00f1adir Producto", null));
        btnAceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Aceptar", null));
        btnCancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cancelar", null));
        lineEditNombreProducto.setInputMask("");
        lineEditNombreProducto.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca el nombre del producto", null));
        comboBoxSeccion.clear();
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Panader\u00eda", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Pescader\u00eda", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fruter\u00eda", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Carnicer\u00eda", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Charcuter\u00eda", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Conservas", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Perfumer\u00eda", null));
        comboBoxSeccion.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "General", null));
        radioButtonUrgenteSi.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Si", null));
        radioButtonUrgenteNo.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "No", null));
        labelNombreProducto_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Nombre del producto:", null));
        labelCantidad_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cantidad:", null));
        labelSeccion.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Seccion:", null));
        labelUrgente.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "\u00bfEs urgente?", null));
    } // retranslateUi

    
    /**
    * Método para obtener los datos del producto desde los controles de la interfaz.
    * 
    * Este método recoge los valores ingresados por el usuario en los campos del formulario:
    * el nombre del producto, la cantidad, la sección y si es urgente. Si el nombre del producto
    * está vacío, muestra un mensaje de advertencia y retorna `null` para indicar que no se puede
    * obtener la información. Si los datos son válidos, los devuelve en un arreglo de cadenas.
    * 
    * @return Un arreglo de cadenas que contiene el nombre del producto, la cantidad, la sección
    *         y si es urgente. Si el nombre del producto está vacío, se devuelve `null`.
    */
    
    public String[] obtenerDatosProducto(){
    
        String nombre = lineEditNombreProducto.text();
        if (nombre.isEmpty()) {
        // Mostrar un mensaje de error o advertencia si el nombre está vacío
        QMessageBox.warning(this, "Advertencia", "El nombre del producto no puede estar vacío.");
        return null;
    }
        int cantidad = spinBoxCantidad.value();
        String seccion = comboBoxSeccion.currentText();
        String urgente = radioButtonUrgenteSi.isChecked() ? "Sí" : "No";
        
        System.out.println("Nombre: " + nombre);
    System.out.println("Cantidad: " + cantidad);
    System.out.println("Sección: " + seccion);
    System.out.println("Urgente: " + urgente);
        
        return new String[]{nombre, String.valueOf(cantidad), seccion, urgente};
    }  
    
    
   
        
}
    
    



