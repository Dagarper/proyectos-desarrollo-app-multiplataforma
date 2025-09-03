/********************************************************************************
 ** Form generated from reading ui file 'DialogAñadirProducto.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Dialog implements com.trolltech.qt.QUiForm<QDialog>
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

    public Dialog() { super(); }

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
        labelNombreProducto_3.setFrameShape(QFrame::NoFrame);

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

}

