package models;

import java.sql.Date;

import funcionesProductos.FuncionesDescuento;
import funcionesProductos.FuncionesProductos;

public class ProductoEnvasado extends Producto implements FuncionesProductos, FuncionesDescuento {

    public final static String NOMBRE_CATEGORIA_ENVASADO = "JJ";

    private String tipoEnvase;
    private Boolean importado;
    private Date fechaVencimiento;
    private Integer calorias;

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

    public ProductoEnvasado(Integer numero, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, String tipoEnvase, Boolean importado) {

        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        this.tipoEnvase = tipoEnvase;
        this.importado = importado;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_ENVASADO, numero);

    }

    @Override
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public Integer getCalorias() {
        return this.calorias;
    }

    @Override
    public void setCalorias(Integer calorias) {
        this.calorias = calorias;

    }

    @Override
    public Integer getDescuento() {
        return null;
    }

    @Override
    public void setDescuento(Integer descuento) {

    }

}