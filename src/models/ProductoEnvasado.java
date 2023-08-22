package models;

public class ProductoEnvasado extends Producto {

    private String tipoEnvase;
    private Boolean importado;

    public String getTipoEnvase() {
        return tipoEnvase;
    }

    public void setTipoEnvase(String tipoEnvase) {
        this.tipoEnvase = tipoEnvase;
    }

    public Boolean getImportado() {
        return importado;
    }

    public void setImportado(Boolean importado) {
        this.importado = importado;
    }

    public ProductoEnvasado(String identificador, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, String tipoEnvase, Boolean importado) {

        super(identificador, descripcion, precio, costoPorUnidad, cantidad);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;
    }

}