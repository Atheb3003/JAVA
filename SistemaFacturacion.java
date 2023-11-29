/* Crea una clase Producto con atributos como nombre, precio y cantidad en stock.
Luego, crea una clase Factura que tenga una lista de productos comprados, la cantidad 
de cada producto y métodos para calcular el total de la factura.*/

//AUTOR: ANTONIO MERIDA DEL PINO
import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SistemaFacturacion 
{
    static class Producto
    {
        String nombre;
        float precio;
        int stock;

        public String getNombre()
        {
            return this.nombre;
        }
        public float getPrecio()
        {
            return this.precio;
        }
        public int getStock()
        {
            return this.stock;
        }

        public Producto(String nombre, float precio, int stock)
        {
            this.nombre = nombre;
            this.precio  = precio;
            this.stock = stock;
        }

        public void info()
        {
            System.out.println("Producto: " +this.nombre + ".  Precio: " +this.precio +"€. Stock: "+this.stock);
        }
    }
    static class Factura
    {
        List<Producto> productosComprados; //INDICO AL ARRAYLIST LLAMADO PRODUCTOS COMPRADOS QUE ALAMACENARA ELEMENTOS DE LA CLASE "PRODUCTO"
        List<Integer> cantidades; //INDICO QUE EL ARRAYLIST "CANTIDADES" GUARDARA DATOS TIPO INT (INTEGER)
        float total;

        public Factura()
        {
            productosComprados = new ArrayList<>();
            cantidades = new ArrayList<>();
            total = 0;
        }

        public void agregarProducto(Producto producto, int cantidad) 
        {
            productosComprados.add(producto); //EL METODO ADD CON LOS ARRAYLISTS INSERTA 
            cantidades.add(cantidad);
            total += producto.getPrecio() * cantidad;
            producto.stock -= cantidad;
        }

        public void imprimirFactura() 
        {
            System.out.println("----- Detalles de la Factura -----");

            for (int i = 0; i < productosComprados.size(); i++) 
            {
                Producto producto = productosComprados.get(i); //ESTA LINEA OBTIENE LOS ELEMENTOS DE NUESTRO ARRAYLIST "PRODUCTOSCOMPRADOS", INDICA CUAL ES EL PRODUCTO A COMPRAR
                int cantidad = cantidades.get(i); //ESTA LINEA OBTIENE LOS ELEMENTOS DE NUESTRO ARRAYLIST "CANTIDAD", INDICA LA CANTIDAD DE CADA PRODUCTO
                float precioTotal = producto.getPrecio() * cantidad;
                System.out.println(producto.getNombre() + " x" + cantidad + ": " + precioTotal + "€"); //IMPRIME LA LINEA DE LA FACTURA
            }

            total = Math.round(total*100)/100f; //ESTA LINEA REDONDEA EL NUMERO "TOTAL" PARA QUE UNICAMENTE TENGA 2 DECIMALES
            System.out.println("---------------------");
            System.out.println("Total: " + total + "€");
        }
    }

    public static void main(String[] args) 
    {
        int eleccion;
        int cantidad;
        boolean condicion = true;
        
        Scanner scanner = new Scanner(System.in);

        Factura factura = new Factura();

        Producto[] producto = new Producto[5];
        producto[0] = new Producto("Pan de molde", 1.62f, 2);
        producto[1] = new Producto("Leche Entera", 4.99f, 104);
        producto[2] = new Producto("Filete de Salmon (1kg)", 22.50f, 36);
        producto[3] = new Producto("Pasta Integral", 2.99f, 114);
        producto[4] = new Producto("Surtido Frutos Secos", 4.00f, 200);
    
        //EL BUCLE ESTA  ASIGNADO A UNA VARIABLE BOOLEANA ASIGNADA A TRUE PARA QUE SIEMPRE OCURRA, A MENOS QUE EN ALGUN PUNTO DENTRO DEL BUCLE LE ASIGNE EL VALOR FALSE A ESA MISMA VARIABLE
        while(condicion == true)
        {
            mostrarProductosDisponibles(producto);
            
            System.out.print("¿Que producto quiere comprar?: ");
            eleccion = scanner.nextInt();
            
            //ESTE SWITCH NOS PERMITE ELEGIR EL PRODUCTO DE COMPRA, SE ENCUENTRA DENTRO DE UN BUCLE PARA QUE CUANDO LLEGUE AL BREAK VUELVA A DARTE A ELEGIR UNA OPCION, LOS SWITCHS DEL 1 AL 5 SON OPCIONES DE PRODUCTOS Y  EL
            //SWITCH 6 TE MODIFICA LA CONDICION DEL WHILE PARA QUE ACABE EL BUCLE.
            //PUEDE HACERSE DE MANERA MUCHO MAS SIMPLE, PERO ESO LO MEJORARE EN SIGUIENTES VERSIONES.
            switch (eleccion) 
            {
                case 1:
                if (producto[0].stock > 0) //ESTE IF PERMITE REALIZAR LA COMPRA UNICAMENTE SI HAY STOCK DEL PRODUCTO
                {
                    System.out.print("Indique la cantidad de "+producto[0].nombre+" que desea comprar: ");
                    cantidad = scanner.nextInt();
                    if (cantidad <= producto[0].stock) //ESTE IF NOS DA UN ERROR SI LA CANTIDAD DE PRODUCTOS A COMPRAR ES MAYOR QUE EL PROPI  STOCK
                    {
                        factura.agregarProducto(producto[0], cantidad);
                        break;
                    }
                    else
                    {
                        System.out.println("\n\n!!En estos momentos no tenemos tal cantidad de "+producto[0].nombre+".\n\n");
                        break;
                    }
                }
                else
                {
                    System.out.println("\n\n\n\nERROR!! ESTE PRODUCTO NO ESTA DISPONIBLE ACTUALMENTE\n\n\n\n");
                    break;
                }

                case 2:
                if (producto[1].stock > 0) 
                {
                    System.out.print("Indique la cantidad de "+producto[1].nombre+" desea: ");
                    cantidad = scanner.nextInt();
                    if (cantidad <= producto[1].stock)
                    {
                        factura.agregarProducto(producto[1], cantidad);
                        break;
                    }
                    else
                    {
                        System.out.println("!!!!!!!!!!En estos momentos no tenemos tal cantidad de "+producto[1].nombre+".\n");
                        break;
                    }
                }
                else
                {
                    System.out.println("\n\n\n\nERROR!! ESTE PRODUCTO NO ESTA DISPONIBLE ACTUALMENTE\n\n\n\n");
                    break;
                }

                case 3:
                if (producto[2].stock > 0)
                {
                    System.out.print("Indique la cantidad de "+producto[2].nombre+" desea: ");
                    cantidad = scanner.nextInt();
                    if (cantidad <= producto[2].stock)
                    {
                        factura.agregarProducto(producto[2], cantidad);

                        break;
                    }
                    else
                    {
                        System.out.println("En estos momentos no tenemos tal cantidad de "+producto[2].nombre+".");
                        break;
                    }
                }
                else
                {
                   System.out.println("\n\n\n\nERROR!! ESTE PRODUCTO NO ESTA DISPONIBLE ACTUALMENTE\n\n\n\n");
                    break;
                }

                case 4:
                if (producto[3].stock > 0)
                {
                    System.out.print("Indique la cantidad de "+producto[3].nombre+" desea: ");
                    cantidad = scanner.nextInt();
                    if (cantidad <= producto[3].stock)
                    {
                        factura.agregarProducto(producto[3], cantidad);
                        break;
                    }
                    else
                    {
                        System.out.println("En estos momentos no tenemos tal cantidad de "+producto[2].nombre+".");
                        break;
                    }
                }
                else
                {
                    System.out.println("\n\n\n\nERROR!! ESTE PRODUCTO NO ESTA DISPONIBLE ACTUALMENTE\n\n\n\n");
                    break;
                }
        
                case 5:
                if (producto[4].stock > 0)
                {
                    System.out.print("Indique la cantidad de "+producto[4].nombre+" desea: ");
                    cantidad = scanner.nextInt();
                    if (cantidad <= producto[4].stock)
                    {
                        factura.agregarProducto(producto[4], cantidad);
                        break;
                    }
                    else
                    {
                         System.out.println("En estos momentos no tenemos tal cantidad de "+producto[4].nombre+".");
                        break;
                    }
                }
                else
                {
                    System.out.println("\n\n\n\nERROR!! ESTE PRODUCTO NO ESTA DISPONIBLE ACTUALMENTE\n\n\n\n");;
                    break;
                }

                case 6:
                    condicion = false;
                default:
                    break;
            }
        }
        factura.imprimirFactura();
        scanner.close();
    }

    //ESTA FUNCION ES LA QUE ME IMPRIME EL MENU DE ELECCION
    public static void mostrarProductosDisponibles(Producto[] productos) 
    {
        System.out.println("-------------------------");
        System.out.println("| PRODUCTOS DISPONIBLES |");
        System.out.println("-------------------------");
        for (int i = 0; i < productos.length; i++) {
            System.out.print((i + 1) + ". ");
            productos[i].info();
        }
        System.out.println((productos.length + 1) + ". TERMINAR COMPRA.");
        System.out.println("*************************");
        
    }
}
