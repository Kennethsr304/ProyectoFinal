
package proyectodefarmacia;
public class Almacen {
private String nombre;
    private int nproductos;
    private Producto[] productos;
    
    public Almacen(String nom)
    {
           nombre=nom;
           nproductos = 0;
           productos = new Producto[100];
    }
    public String adicionarProducto(Producto prod)
    {
        String rpta;
        if (nproductos < 100)
        {
            productos[nproductos] = prod;
            nproductos++;
            rpta = "Se registro el producto";
        }else{
            rpta = "No se registro el producto";
        }
        return rpta;
    }
    public Producto obtenerProducto(int indice)
    {
        if (indice < 0 || indice >= nproductos)
        {
        return null;    
        }else{
    return productos[indice];
    }   
}
    public int getNproductos() 
    {
        return nproductos;
    }
    public String getNombre() 
    {
        return nombre;
    }
    
}
