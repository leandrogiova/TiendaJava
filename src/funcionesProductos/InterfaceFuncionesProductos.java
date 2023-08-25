package funcionesProductos;

import java.sql.Date;

public interface InterfaceFuncionesProductos {

    public void setFechaVencimiento(Date fechaVencimiento);

    public Date getFechaVencimiento();

    public void setCalorias(Integer calorias);

    public Integer getCalorias();

}
