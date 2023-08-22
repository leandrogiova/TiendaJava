package models;

public class ProductoBebida extends Producto {

    private Boolean alcoholica;
    private Float porcentajeDeAlcohol;
    private Boolean importado;

    public Boolean getAlcoholica() {
        return alcoholica;
    }

    public void setAlcoholica(Boolean alcoholica) {
        this.alcoholica = alcoholica;
    }

    public Float getPorcentajeDeAlcohol() {
        return porcentajeDeAlcohol;
    }

    public void setPorcentajeDeAlcohol(Float porcentajeDeAlcohol) {
        if (alcoholica) {
            this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        } else {
            System.out.println("ERROR! Al setear el porcentaje de alcohol en el producto.\n\n");
        }
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    public ProductoBebida(String identificador, String descripcion, Float precio, Float costoPorUnidad,
            Integer cantidad, Boolean alcoholica, Float porcentajeDeAlcohol, Boolean importado) {

        super(identificador, descripcion, precio, costoPorUnidad, cantidad);
        this.alcoholica = alcoholica;
        this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        this.importado = importado;
    }

}
