package proyectodefarmacia;

import java.io.*;

abstract class Boleta
{
    protected String apellidos;
    protected String nombres;
    protected int DNI;
    protected int edad;
    
    public Boleta(String ape,String nom, int dni, int ed)
    {
        apellidos=ape;
        nombres=nom;
        DNI=dni;
        edad=ed;
    }
    public void setApellidos(String ape)
    {
        apellidos=ape;
    }
    public void setNombres(String nom)
    {
        nombres=nom;
    }
    public void setCodigos(int dni)
    {
        DNI=dni;
    }
    public void setEdades(int ed)
    {
        edad=ed;
    }
    public String getApellidos()
    {
        return apellidos;
    }
    public String getNombres()
    {
        return nombres;
    }
    public int getCodigos()
    {
        return DNI;
    }
     public void getEdades(int ed)
    {
        edad=ed;
    }
    abstract double pago();
}

final class Cliente extends Boleta
{
    public double saldo;
    
    public Cliente(String ape,String nom, int dni, double p, int ed)
    {
        super(ape,nom,dni,ed);
        saldo=p;
    }
    public void setSalario(double p)
    {
        saldo=p;
    }
    public double getSalario()
    {
        return saldo;
    }
    public double pago()
    {
        return saldo;
    }
    public String toString()
    {
        return "\n"
                +"\n"
                +"\n"
                +"                          -----BOLETA ELECTRONICA-----\n"
                +"\n"
                +"\n"
                + "                          Cliente: "+apellidos+" "+nombres+" Cedula: "+DNI+" Edad: "+edad;
    }
    
}
final class Trabajador extends Boleta
{
    private double precio1;
    private double precio2;
    private double descuento;
    
    public Trabajador(String ape,String nom, int cod, double p1, double p2, double des, int ed)
    {
        super(ape,nom,cod,ed);
        precio1=p1;
        precio2=p2;
        descuento=des;
    }
    public void setPrecio1(double p1)
    {
        precio1=p1;
    }
    public void setPrecio2(double p2)
    {
        precio2=p2;
    }
    public void setDescuento(double des)
    {
        descuento=des;
    }
    public double getPrecio1()
    {
        return precio1;
    }
    public double getPrecio2()
    {
        return precio2;
    }
    public double getDescuento()
    {
        return descuento;
    }
    public String toString()
    {
        return "\n"
                +"\n"
                +"\n"
                +"                          -----BOLETA ELECTRONICA-----\n"
                +"\n"
                +"\n"
                + "                          Trabajador: "+apellidos+" "+nombres+" Cedula: "+DNI+" Edad: "+edad;
    }
    public double pago()
    {
        return precio1-(precio2*0.10);
    }
  
}

public class ProyectoDeFarmacia {
    public static void mensaje(String m)
    {
        System.out.print(m);
    }
    public static int leerDatoEntero()throws IOException
{
   BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
   return Integer.parseInt(leer.readLine());
}
public static double leerDatoReal()throws IOException
{
   BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
   return Double.parseDouble(leer.readLine());
}
public static String leerDatoCadena()throws IOException
{
   BufferedReader leer=new BufferedReader (new InputStreamReader(System.in));
   return leer.readLine();
}
    public static void main(String[] args) throws IOException 
    {
        
        String nomalmacen, nompro;
        int rpta=1, cant=0;
        double pre=0,totalp,totp=0,sumapre=0;
        Almacen oA= null;
        mensaje("Farmacia Lozano S.A \n ");
        mensaje("Presione Enter Para Continuar ");
        nomalmacen=leerDatoCadena();
        oA=new Almacen(nomalmacen);
        Producto p;
        if(oA!=null)
        mensaje("Bienvenido!");
        mensaje("\n");
        mensaje("\n");
        mensaje("INGRESO DE CANTIDAD DE PRODUCTOS A ADQUIRIR");
        mensaje("\n");
        do
        {
            do{
            try{
            mensaje("Nombre del producto: ");
            nompro=leerDatoCadena();
            break;
            }catch(NumberFormatException t)
            {
                System.err.print(" ¡PORFAVOR INGRESE EL NOMBRE DEL PRODUCTO! \n");
            }
            }while(true);
            do{
            try{
            mensaje("Cantidad del producto que desea adquirir: ");
            cant=leerDatoEntero();
            break;
            }catch(NumberFormatException t)
            {
                System.err.print(" ¡PORFAVOR INGRESE UN NUMERO! \n");
            }
            }while(true);
            do{
            try{
            mensaje("Precio del producto: ");
            pre=leerDatoReal();
            break;
            }catch(NumberFormatException t)
            {
                System.err.print(" ¡PORFAVOR INGRESE UN NUMERO! \n");
            }
            }while(true);
            sumapre=cant*pre+sumapre;
            totp=totp+pre;
            do{
            try{
            mensaje("¿Desea ingresar los datos de otro producto? (SI=1, No=0): " );
            rpta=leerDatoEntero();
            break;
                    }catch(NumberFormatException t)
                    {
                        System.err.print(" ¡PORVAFOR ELIJA BIEN SU OPCION! \n");
                    }
                    }while(true);
            mensaje("\n");
            
            p=new Producto(nompro, pre, cant);
            
            oA.adicionarProducto(p);
           
        }
        while(rpta==1);

     
        String nom;
        String ape;
        int dni,ed,opcion,opcion2,tar;
        double tot,sald=0,prec,des;
        
        do{
            try{
        mensaje("¿Usted es Cliente o Trabajador?[Cliente = 1] [Trabajador = 2]: ");
        opcion=leerDatoEntero();
        break;
                    }catch(NumberFormatException t)
                    {
                        System.err.print(" ¡PORVAFOR ELIJA BIEN SU OPCION! \n");
                    }
                    }while(true);
        
         if(opcion==1)  
         {     
                do{
                try{
                mensaje("Ingrese su Nombre : ");
                nom=leerDatoCadena();
                mensaje("Ingrese sus dos Apellidos: ");
                ape=leerDatoCadena();
                mensaje("Ingrese su DNI (Cedula de identidad): ");
                dni=leerDatoEntero();
                mensaje("Ingrese su edad: ");
                ed=leerDatoEntero();
                break;
                    }catch(NumberFormatException t)
                    {
                        System.err.print(" ¡ERROR VUELVA A INGRESAR! \n");
                    }
                    }while(true);
                do{
                try{
                mensaje("Ingrese el monto con el que pagará el precio del producto: ");
                sald=leerDatoReal();
                break;
                    }catch(NumberFormatException t)
                    {
                        System.err.print(" ¡ERROR VUELVA A INGRESAR! \n");
                    }
                    }while(true);

                    Boleta E;
                Cliente A=new Cliente(nom,ape,dni,sald,ed);
                E=A;
                System.out.println(E.toString());
 
                double vuelto;
                double iva;
                iva=sumapre*0.13;
                vuelto=sald-sumapre-iva;
                mensaje("                 ------Farmacia Lozano S.A -  Ruc: 203535563-------- \n ");
                mensaje("                         >Chimbote - Urb. El Carmen 345< \n ");
                mensaje("                 ------- --TELF: (043)-842642 -----\n ");
                mensaje("\n");
                mensaje("                            Fecha de emisión: 26/04/2022 \n");
                mensaje("\n");
                mensaje("                              Total a pagar: "+sumapre+" colones\n");
                mensaje("                              Impuesto de ventas: "+iva+" colones\n");
                mensaje("                              Saldo a favor: "+sald+" colones\n");
                mensaje("                               Su Vuelto es: "+vuelto+" colones\n");
               System.out.println("             LISTA DE PRODUCTOS         Stock        Precio Unitario");
                    int total,i;
                    total=oA.getNproductos();
                    if(total>0)
                        for(i=0;i<total;i++)
                        {
                            p=oA.obtenerProducto(i);
                            System.out.println("                   "+p.getNombre()+"                  "+p.getStock()+"             "+p.getPrecio());
                        }
         }

        else
         {
                mensaje("POR SER TRABAJADOR SE LE REALIZARA EL DESCUENTO DE 10% \n");
                mensaje("=======================================================\n");
                mensaje("Ingrese su Nombre: ");
                nom=leerDatoCadena();
                mensaje("Ingrese sus dos Apellidos: ");
                ape=leerDatoCadena();
                mensaje("Ingrese su edad: ");
                ed=leerDatoEntero();
                do{
                  try{
                mensaje("Ingrese su Codigo de Trabajador: ");
                dni=leerDatoEntero();
                break;
                    }catch(NumberFormatException t)
                    {
                        System.err.print(" ¡ERROR VUELVA A INGRESAR! \n");
                    }
                    }while(true);
                do{
                  try{
                mensaje("Ingrese el monto con el que pagará el precio del producto: ");
                sald=leerDatoReal();
                break;
                    }catch(NumberFormatException t)
                    {
                        System.err.print(" ¡ERROR VUELVA A INGRESAR! \n");
                    }
                    }while(true);
                prec=pre;

                    des=sumapre-(sumapre*0.10);
                    Boleta E;

                    Trabajador D=new Trabajador(nom,ape,dni,prec,prec,des,ed);
                    E=D;
      
                    double vuelto;
                    double iva;
                    iva=sumapre*0.13;
                    vuelto=sald-des-iva;
                     System.out.println(E.toString());
                    mensaje("                 ------Farmacia Lozano S.A -  Ruc: 203535563-------- \n ");
                    mensaje("                         >Chimbote - Urb. El Carmen 345< \n ");
                    mensaje("                 ----------TELF: (043)-842642 -----\n ");
                    mensaje("\n");
                    mensaje("                            Fecha de emisión: 26/04/2022 \n");
                    mensaje("\n");
                    mensaje("                              Monto a pagar (con 10% de descuento): "+des+" colones\n");
                    mensaje("                              Impuesto de ventas: "+iva+" colones\n");
                    mensaje("                                 Saldo a favor: "+sald+" colones\n");
                    mensaje("                               Su Vuelto es: "+vuelto+" colones\n");
                    System.out.println("             LISTA DE PRODUCTOS         Stock        Precio Unitario");
                    int total,i;
                    total=oA.getNproductos();
                    if(total>0)
                        for(i=0;i<total;i++)
                        {
                            p=oA.obtenerProducto(i);
                            System.out.println("                   "+p.getNombre()+"                 "+p.getStock()+"             "+p.getPrecio());
                        }
                    
         }
         
    }
              
 }