package funcionesProductos;

import java.sql.Date;

import models.Producto;

public interface InterfaceFuncionesProductos {

    public void setFechaVencimiento(Date fechaVencimiento);

    public Date getFechaVencimiento();

    public void setCalorias(Integer calorias);

    public Integer getCalorias();

    public void verProduto(Producto p);

}
