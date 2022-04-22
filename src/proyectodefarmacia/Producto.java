
package proyectodefarmacia;

public class Producto 
{
    private String nombre;
    private double precio;
    private int stock;
    public Producto(String nom,double pre,int cant )
            {
               nombre= nom;
               precio=pre;
               stock=cant;
            }
    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nom)
    
    {
        nombre=nom;
    }
    public double getPrecio()
    {
        return precio;
    }
    public void setPrecio(double pre)
    {
      precio = pre;
    }
    public int getStock()
    {
        return stock;
    }
    public void setStock(int cant)
    {
        stock=cant;
    }
    public String toString()
    {
        return "Producto{"+"Nombre="+nombre+",Precio="+precio+",Sttock="+stock+'}';
    }
}
