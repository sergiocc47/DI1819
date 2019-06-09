package dto;

import java.io.Serializable;

/**
 *
 * @author sergio
 */
// NOTA: No necesita implementar Serializable puesto que no es necesario convertir 
// el objeto en bytes para enviarlo a través de red, guardarlo en un fichero (persistir, 
// en definitiva)
public class Mesa implements Comparable<Mesa> {

    private int idMesa;
    private String localizacion;
    private int capacidad;

    public Mesa() {
    }

    public Mesa(int idMesa, String localizacion, int capacidad) {
        this.idMesa = idMesa;
        this.localizacion = localizacion;
        this.capacidad = capacidad;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    // Método para crear array de strings con los datos del objeto mesa para ser
    // añadidos en una nueva fila de una DefaultTableModel
    public String[] toArrayString() {
        String[] s = new String[3];
        s[0] = Integer.toString(idMesa);
        s[1] = localizacion;
        s[2] = Integer.toString(capacidad);
        return s;
    }
    
    // Es necesario, a pesar de que sirva para comparar, puesto que una alerta de
    // NetBeans pide implementar los métodos abstractos de la interfaz Comparable
    @Override
    public int compareTo(Mesa mesa) {
        if (this.idMesa < mesa.idMesa) {
            return -1;
        } else if (this.idMesa == mesa.idMesa) {
            return 0;
        } else {
            return 1;
        }
    }
    
    // DUDA: ¿'hashCode' y 'equals' son mejores cuantos más criterios seleccionemos?
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idMesa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mesa other = (Mesa) obj;
        if (this.idMesa != other.getIdMesa()) {
            return false;
        }
        return true;
    }
    /*
    // Método código propio
    @Override
    public boolean equals(Object object) {
        if (this.idMesa == ((Mesa) object).idMesa) {
            return true;
        }
        return false;
        //return this.idMesa == ((Mesa)object).idMesa;  // abreviado en una línea
    }
    */
    @Override
    public String toString() {
        //return "Mesa{" + "idMesa=" + idMesa + ", localizacion=" + localizacion + ", capacidad=" + capacidad + '}';    // solución cutre pero de momento válida ya que solamente
        return Integer.toString(idMesa);        // TODO: No es necesario, metemos el getter en el setItem del ComboBox  // usamos el ID (para mostrar en el ComboBox)
    }
}
