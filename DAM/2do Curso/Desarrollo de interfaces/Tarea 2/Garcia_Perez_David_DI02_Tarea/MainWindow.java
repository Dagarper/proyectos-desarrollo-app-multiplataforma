/********************************************************************************
 ** Form generated from reading ui file 'MainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
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
        btnAniadir.setIcon(new QIcon(new QPixmap("../../../Users/David/OneDrive/Im\u00e1genes/add.png")));

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
    } // retranslateUi

}

