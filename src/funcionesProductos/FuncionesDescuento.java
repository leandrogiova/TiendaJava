package funcionesProductos;

public interface FuncionesDescuento {

    public void setDescuento(Integer descuento);

    public Float getDescuento();

    public static Float calcularDescuento(Float precio, int descuento) {
        System.out.println("\n\n\nEN LA FUNCION CALCULARdESCUENTO: " + ((precio * descuento)));
        return precio = precio - (precio * descuento);

    }

}
