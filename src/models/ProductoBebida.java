package models;

import java.sql.Date;

import funcionesProductos.FuncionesDescuento;
import funcionesProductos.FuncionesProductos;

public class ProductoBebida extends Producto implements FuncionesProductos, FuncionesDescuento {

    public final static String NOMBRE_CATEGORIA_BEBIDA = "AC";

    private Boolean alcoholica;
    private Float porcentajeDeAlcohol;
    private Boolean importado;
    private Date fechaVencimiento;
    private Integer calorias;

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

    public ProductoBebida(Integer numero, String descripcion,
            Float precio, Float costoPorUnidad, Integer cantidad, Boolean alcoholica, Float porcentajeDeAlcohol,
            Boolean importado) {

        super(numero, descripcion, precio, costoPorUnidad, cantidad);
        this.alcoholica = alcoholica;
        this.porcentajeDeAlcohol = porcentajeDeAlcohol;
        this.importado = importado;

        setIdentificadorAbstracto(NOMBRE_CATEGORIA_BEBIDA, numero);

    }

    @Override
    public Date getFechaVencimiento() {
        return fechaVencimiento;
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
