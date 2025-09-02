
package Prog10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculadoraController implements Initializable {

    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn0;
    @FXML
    private Button btnComa;
    @FXML
    private Button btnMas;
    @FXML
    private Button brnMenos;
    @FXML
    private Button btnMult;
    @FXML
    private Button btnDiv;
    @FXML
    private Button btnMasMenos;
    @FXML
    private Button clickBtnIgual;
    @FXML
    private Button clickBtnClear;
    @FXML
    private Button clickBtnClearResult;
    @FXML
    private TextField txtResult;

    private double resultado, masMenos, num1, num2;
    private int sumaClick, restaClick, multClick, divClick;
    private boolean operando1, limpiar, sePuedeCalcular;
    private char ultOperador;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.operando1 = true;
        this.resultado = 0;
        this.limpiar = true;
        this.sePuedeCalcular = false;
    }    

    @FXML
    private void clickBtn1(ActionEvent event) {
        if (this.limpiar) {
            this.txtResult.setText( btn1.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn1.getText());
        } 
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn2(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn2.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn2.getText());
        }
         this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn3(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn3.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn3.getText());
        }
        this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn4(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn4.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn4.getText());
        }
         this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn5(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn5.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn5.getText());
        }
         this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn6(ActionEvent event) {
     if (this.limpiar) {
            this.txtResult.setText( btn6.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn6.getText());
        }
     this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn7(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn7.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn7.getText());
        }
         this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn8(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn8.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn8.getText());
        }
         this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn9(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn9.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn9.getText());
        }
         this.sePuedeCalcular = true;
    }

    @FXML
    private void clickBtn0(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btn0.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btn0.getText());
        }
         this.sePuedeCalcular = true;
    }
    
    @FXML
    private void clickBtnComa(ActionEvent event) {
         if (this.limpiar) {
            this.txtResult.setText( btnComa.getText());
            this.limpiar = false;
        }else{
            this.txtResult.setText(this.txtResult.getText() + btnComa.getText());
        }
         this.sePuedeCalcular = true;
    }
    
    @FXML
    private void clickBtnMas(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.operando1) {
                this.resultado = Double.parseDouble(this.txtResult.getText());
            } else {
                this.resultado += Double.parseDouble(this.txtResult.getText());
            }
            this.txtResult.setText(String.valueOf(this.resultado));
            this.limpiar = true;
            this.operando1 = false;
            this.sePuedeCalcular = false;
        }
        this.ultOperador = '+';
    }

    @FXML
    private void clickBtnMenos(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.operando1) {
                this.resultado = Double.parseDouble(this.txtResult.getText());
            } else {
                this.resultado -= Double.parseDouble(this.txtResult.getText());
            }
            this.txtResult.setText(String.valueOf(this.resultado));
            this.limpiar = true;
            this.operando1 = false;
            this.sePuedeCalcular = false;
        }else if (this.operando1) {
            this.txtResult.setText("-"); 
            this.limpiar = false;
        }
        this.ultOperador = '-';
    }

    @FXML
    private void clickBtnMult(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.operando1) {
                this.resultado = Double.parseDouble(this.txtResult.getText());
            } else {
                this.resultado *= Double.parseDouble(this.txtResult.getText());
            }
            this.txtResult.setText(String.valueOf(this.resultado));
            this.limpiar = true;
            this.operando1 = false;
            this.sePuedeCalcular = false;
        }
        this.ultOperador = '*';
    }

    @FXML
    private void clickBtnDiv(ActionEvent event) {
        if (this.sePuedeCalcular) {
            if (this.operando1) {
                this.resultado = Double.parseDouble(this.txtResult.getText());
            } else {
                this.resultado /= Double.parseDouble(this.txtResult.getText());
            }
            this.txtResult.setText(String.valueOf(this.resultado));
            this.limpiar = true;
            this.operando1 = false;
            this.sePuedeCalcular = false;
        }
        this.ultOperador = '/';
    }
    
    @FXML
    private void clickBtnMasMenos(ActionEvent event) {
        masMenos = Double.parseDouble(this.txtResult.getText()) * (-1);
        resultado = masMenos;
        this.txtResult.setText(String.valueOf(resultado));
    }
    
    @FXML
    private void clickBtnClear(ActionEvent event) {
        this.txtResult.setText("");
        this.limpiar = true;
        this.operando1 = false;
        this.sePuedeCalcular = false;
    }
    @FXML
    private void clickBtnClearResult(ActionEvent event) {
        this.txtResult.setText("");
        resultado = 0;
        this.operando1 = true;
        this.limpiar = true;
        this.sePuedeCalcular = false;
    }

    @FXML
    private void clickBtnIgual(ActionEvent event) {
        
        switch (this.ultOperador) {

            case '+':
                this.clickBtnMas(event);
                break;
            case '-':
                this.clickBtnMenos(event);
                break;
            case '*':
                this.clickBtnMult(event);
                break;
            case '/':
                this.clickBtnDiv(event);
                break;

        }
        
        
    }
    
    
}
