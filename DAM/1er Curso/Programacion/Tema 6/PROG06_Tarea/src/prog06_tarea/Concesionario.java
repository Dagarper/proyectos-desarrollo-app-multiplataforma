
package prog06_tarea;

public class Concesionario {//Clase pública concesionario.
    
    private Vehiculo[] vehiculos;//Declara una variable de tipo array de objetos llamada "vehiculos", 
    //que almacena una serie de elementos de tipo "Vehiculo". 
    private int numVehiculos;//Declara una variable de tipo numerico llamada numVehículos. Recogerá el número de vehiculos que hay en el concesionario.
    
    public Concesionario(){  //Define el constructor de la clase "Concesionario".
        this.vehiculos = new Vehiculo[50];//Inicializa la variable vehículos con un array de tamaño 50 (puede albergar hasta 50 objetos Vehiculo)
        this.numVehiculos = 0; // Inicializa la variable numVehiculos en 0.
}
    
    public String buscaVehiculo (String matricula){//Método para buscar vehículos.  
    //El método recorre el array "vehiculos" de la clase "Concesionario" y verifica si alguno de los objetos "Vehiculo" almacenados tiene una matrícula
    //igual a la matrícula proporcionada como parámetro. Si se encuentra un objeto "Vehiculo" con la matrícula proporcionada, 
    //se devuelve el resultado del método "toString" del objeto "Vehiculo" encontrado. 
    //Si no se encuentra ningún objeto "Vehiculo" con la matrícula proporcionada, se devuelve "null".
        
        for (int i = 0; i < this.numVehiculos; i++) {//Bucle for que recorre el array Vehículo y le asigna una posición i en el array al vehículo v.
            Vehiculo v = this.vehiculos[i];
            
            if(v.getNumMatricula().equals(matricula) ){//Condicional if. Si la matricula es igual a la proporcionada por parámetro devuelve el
                //la cadena toString() del objeto "Vehículo" de nombre "v".
                return v.toString(); 
                
            }
        }
            return null;
    }
    
    
    public boolean existeMatricula(String matricula){//Método existe matricula. Verifica si existe un objeto vehículo con la matricula dada por parámetro.
        //El método recorre el array "vehiculos" de la clase "Concesionario" y verifica si alguno de los objetos "Vehiculo" almacenados tiene una matrícula igual a la matrícula proporcionada como parámetro. 
        //Si se encuentra un objeto "Vehiculo" con la matrícula proporcionada, se devuelve "true". Si no se encuentra ningún objeto "Vehiculo" con la matrícula proporcionada, se devuelve "false".
        for (int i = 0; i < this.numVehiculos; i++) {//Bucle for que recorre el array Vehículo y le asigna una posición i en el array al vehículo v. 
                Vehiculo v = this.vehiculos[i];

                if(v.getNumMatricula().equals(matricula) ){////Condicional if. Si la matricula es igual a la proporcionada por parámetro devuelve true.
                    return true;
                }else{//En caso contrario devuelve false.
                   
                    return false;
                }
        }
        return false;
    }
    
    public int insertarVehiculo(Vehiculo v){//Método insertarVehiculo 
        //Este método tiene un parámetro de entrada llamado "v" de tipo "Vehiculo", 
        //que es el objeto "Vehiculo" que se desea insertar en el concesionario.
     
        
        //El método realiza varias verificaciones antes de insertar el vehículo en el arreglo "vehiculos" de la clase "Concesionario".
            //Condicional if que verifica si el arreglo "vehiculos" está lleno, es decir, si ya se han agregado el máximo número de vehículos 
            //posible (que es igual al tamaño del arreglo "vehiculos"). Si el arreglo está lleno, el método devuelve "-1".
            if (numVehiculos == this.vehiculos.length){
            return -1;
            }
            //Condicional if que verifica si ya existe un vehículo con la misma matrícula que el vehículo que se desea insertar. Para ello, llama al método 
            //"existeMatricula" de la clase "Concesionario", que verifica si existe un vehículo con la matrícula proporcionada. 
            //Si ya existe un vehículo con la misma matrícula, el método devuelve "-2".
            if (existeMatricula(v.getNumMatricula()) == true){
            return -2;
            //Si se cumple ninguna de las condiciones anteriores, significa que se puede insertar el vehículo en el arreglo "vehiculos". 
            //El método inserta el vehículo en la primera posición vacía del arreglo y aumenta en 1 el contador "numVehiculos" 
            //que lleva registro del número de vehículos agregados al arreglo. Finalmente, el método devuelve "0" 
            //para indicar que la inserción del vehículo se realizó correctamente.
            }else{ 
                this.vehiculos[this.numVehiculos] = v;
                this.numVehiculos++;
             
            return 0;
            }
    }
    
    
    public void listaVehiculos (){//Método listaVehículos de la clase Concesionario. No tiene parámetros de entrada ni devuelve ningun valor. 
        
        //A través del siguiente bucle for recorre el array "vehiculos" de la clase "Concesionario" y para cada objeto "Vehiculo" 
        //almacenado en el arreglo, imprime en pantalla el resultado del método "toString" del objeto "Vehiculo" "v".
        
        for (int i = 0; i < this.numVehiculos; i++) {
            Vehiculo v = this.vehiculos[i]; 
            System.out.println(v.toString());
        }
        
    }
    
    
    public boolean actualizaKms (String matricula, int numeroKm){//Método acualizaKms de la clase Concesionario. Tiene como parámetros de entrada
        //las variables de tipo String matricula y de tipo entero numeroKm que es el nuevo número de kilómetros que se desea asignar al vehículo. 
    
        //El siguiente bucle for recorre el arreglo "vehiculos" de la clase "Concesionario" y verifica si alguno de los objetos "Vehiculo" almacenados
        //tiene una matrícula igual a la matrícula proporcionada como parámetro. Si se encuentra un objeto "Vehiculo" con la matrícula proporcionada, 
        //el método utiliza el método "setNumKm" del objeto "Vehiculo" para actualizar el número de kilómetros recorridos del vehículo y devuelve "true". 
        //Si no se encuentra ningún objeto "Vehiculo" con la matrícula proporcionada, el método devuelve "false".
         for (int i = 0; i < this.numVehiculos; i++) {
            Vehiculo v = this.vehiculos[i];
            
            if(v.getNumMatricula().equals(matricula) ){
                v.setNumKm(numeroKm);
                return true;
            }
    }
    return false;
}
}
