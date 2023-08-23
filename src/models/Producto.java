package models;

public abstract class Producto {

    public final static int LONGITUD_IDENTIFICADOR = 5;

    private String identificador = new String(new char[LONGITUD_IDENTIFICADOR]);
    private String descripcion;

    private Float precio;
    private Float costoPorUnidad;
    private Integer cantidad;

    public Float getCostoPorUnidad() {
        return costoPorUnidad;
    }

    public void setCostoPorUnidad(Float costoPorUnidad) {
        this.costoPorUnidad = costoPorUnidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getIdentificador() {
        return identificador;
    }

    /*
     * Funcion setIdentificador va a setear el identificador(va a ser obligatorio
     * que contenga 2caracteres y 3 numeros).
     * Convierte un string a un array de chars, luego comprueba que tenga un largo
     * de 5 caracteres
     * Luego verifica que los dos primeros caracteres sean letras y si son
     * minusculas los transforma a mayusculas
     * Luego verifica que los 3 siguientes caracteres sean numeros
     * Si cumple con todas las condisiones se setea el valor correspondiente.
     * No recibe un String como parametro
     * No tiene retorno
     */

    /*
     * public void setIdentificador(String identificador) {
     * 
     * char[] chars = identificador.toCharArray();
     * 
     * if (identificador.length() == LONGITUD_IDENTIFICADOR) {
     * if (Character.isLetter(chars[0]) && Character.isLetter(chars[1])) { // verte
     * este || o el && determinar cual
     * // va
     * 
     * // las convierte en mayusculas
     * if (Character.isLowerCase(chars[0])) {
     * chars[0] = Character.toUpperCase(chars[0]);
     * }
     * if (Character.isLowerCase(chars[1])) {
     * chars[1] = Character.toUpperCase(chars[1]);
     * }
     * // comprobar que los otros 3 digitos sean numeros
     * for (int i = 2; i < LONGITUD_IDENTIFICADOR; i++) {
     * if (!Character.isDigit(chars[i])) {
     * System.out.println(
     * "ERROR! No se seteo el identificador del producto. Del 3er al 5 caracter no es un numero\n\n"
     * );
     * break;
     * } else {
     * this.identificador = new String(chars);
     * }
     * }
     * 
     * }
     * 
     * else {
     * System.out.println(
     * "ERROR! No se seteo el identificador del producto. Los dos primeros caracteres del identifiador deben ser letras.Ejemplo de identificador: AB123\n\n"
     * );
     * }
     * } else {
     * System.out.println(
     * "ERROR! No se seteo el identificador del producto.El identificador debe contener solamente 2 letras y 5 numeros OBLIGATORIAMENTE\n\n"
     * );
     * }
     * 
     * }
     */
    public void setIdentificador(String identificador, Integer numeroId) {

        char[] chars = identificador.toCharArray();

        // comprueba que los dos primeros sean caracteres
        if (Character.isLetter(chars[0]) && Character.isLetter(chars[1])) {

            // las convierto en mayusculas
            if (Character.isLowerCase(chars[0])) {
                chars[0] = Character.toUpperCase(chars[0]);
            }
            if (Character.isLowerCase(chars[1])) {
                chars[1] = Character.toUpperCase(chars[1]);
            }

            if (numeroId >= 0 && numeroId <= 999) {
                String nuevoNumero = String.format("%03d", numeroId);
                System.out.println("\n\n\n\n\nnuevoNumero:  " + nuevoNumero);

                this.identificador = new String(chars);
                this.identificador = this.identificador.concat(nuevoNumero);
                System.out.println("\n\n\n\n\nidentificador:  " + this.identificador);
            } else {
                System.out.println(
                        "\n\n\nERROR el numero del identificador del producto. Debe ser un numero entre 0 y 999\n\n");
            }

        }

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto(String identificador, Integer numero, String descripcion, Float precio, Float costoPorUnidad,
            Integer cantidad) {
        setIdentificador(identificador, numero);
        this.descripcion = descripcion;
        this.precio = precio;
        this.costoPorUnidad = costoPorUnidad;
        this.cantidad = cantidad;
    }

    public Producto() {
    }

}
