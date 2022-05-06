package PROYECTO;

import java.util.Scanner;

public class PROYECTO {

    public static void main(String[] args) {
        System.out.println("carlos estuvo aqui");
        // Se ingresa total de presupuesto
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingresa Monto Total: ");

        // Se valida si monto es valido
        int cantidad = scan.nextInt();
        System.out.println("El monto ingreso es: " + ValidarMonto(cantidad));

        // Si el monto es valido se realiza la cotizacion por los routers, switches y APs.
        if(ValidarMonto(cantidad) == "Monto validado"){


            // Se solicita cantidad de routers
            System.out.print("Ingresa Cantidad de Routers: ");
            int TotalRouters = scan.nextInt();

            // Se brinda precio por routers
            System.out.println("El monto por un router es: " + EquiposRouters(TotalRouters));

            // Se brinda monto total por cantidad de routers
            System.out.println("El monto total a pagar es: " + TotalMontoRouters(TotalRouters));


            // Se solicita cantidad de switches
            System.out.print("Ingresa Cantidad de Switches: ");
            int TotalSwitches = scan.nextInt();

            // Se brinda precio por switches
            System.out.println("El monto por un switch es: " + EquiposSwitches(TotalSwitches) );

            // Se brinda monto total por cantidad de Switches
            System.out.println("El monto total a switch es: " + TotalMontoSwitches(TotalSwitches));

            // Se solicita cantidad de APS
            System.out.print("Ingresa Cantidad de APs: ");
            int TotalAps = scan.nextInt();

            // Se brinda precio por APs
            System.out.println("El monto por un APs es: " + EquiposAps(TotalAps));

            // Se brinda monto total por cantidad de Aps
            System.out.println("El monto total a Aps es: " + TotalMontoAps(TotalAps));

            double SumaTotal = TotalMontoAps(TotalAps) + TotalMontoSwitches(TotalSwitches) + TotalMontoRouters(TotalRouters);

            double IGVTotal = 0.18*SumaTotal;

            double SubTotal = SumaTotal - IGVTotal;

            // Se pregunta al cliente si se requiere un servicio adicional

            System.out.println("Necesitas algún servicio adicional: ");

            String respuesta = scan.next();

            System.out.println("Gracias por elegir la opcion " + respuesta);



            if( "si".equals (respuesta)) {


                // Se consulta el servicio adicional y se agrega a la cotizacion



                System.out.println("Cableado Estructurado = 1");

                System.out.println("Configuraciones de equipos LAN = 2");

                System.out.println("Instalacion de equipos = 3");


                System.out.println("Que servicio le gustaria adicionar:");

                int opcion= scan.nextInt();

                System.out.println("Gracias por elegir la opcion: " + opcion );


                System.out.println("El costo total por dia del servicio adicional seria: " + costototaladicional(new int[]{opcion}));

                int[] opciones = {1,2,3} ;
                int[] precios = {90, 100, 80};

                double sumatotaladicional =  costototaladicional(new int[]{opcion}) + SumaTotal;

                double IGVTotalCosto = sumatotaladicional * 0.18;

                double subtotaladicional = sumatotaladicional - IGVTotalCosto;




                System.out.println("Le compartimos la detalle de la cotizacion: ");

                System.out.println("El sub total a pagar seria: " + subtotaladicional );

                System.out.println("El IGV seria:  " + IGVTotalCosto);

                System.out.println("El total seria: " + sumatotaladicional);

                System.out.println("Gracias por su preferencia.");


            }else if (respuesta.equals ("no")) {

                System.out.println("Le compartimos la detalle de la cotizacion: ");

                System.out.println("El sub total a pagar seria: " + SubTotal);

                System.out.println("El IGV seria:  " + IGVTotal);

                System.out.println("El total seria: " + SumaTotal);

                System.out.println("Gracias por su preferencia.");
            }

        }else if (ValidarMonto(cantidad) == "Monto no valido"){

            System.out.println(" No se puede proceder");
        }

    }



    // Se solicita validacion de monto ingresado
    public static String ValidarMonto(int cantidad){

        String cadena = "Validacion";


        if(cantidad >= 5000){

            cadena = "Monto validado";


        }else if (cantidad < 5000){

            cadena = "Monto no valido";

        }

        return cadena;

    }

    // Se brinda precio de routers de acuerdo a lo brindado por cliente.

    public static int EquiposRouters(int TotalRouters){

        int PrecioRouters = 0;

        switch(TotalRouters){

            case 1:

                PrecioRouters = 1500;

                break;

            case 2:

                PrecioRouters = 1200;

                break;

            case 3:

                PrecioRouters = 1000;

                break;

            default:

                PrecioRouters = 0;

        }

        return PrecioRouters;

    }

    // Se brinda monto total por Routers.

    public static int TotalMontoRouters(int TotalRouters){

        int Montototal = 0;

        while (TotalRouters > 0) {

            if (TotalRouters == 3) {

                Montototal = 3 * 1000;

                break;

            } else if (TotalRouters == 2) {

                Montototal = 2 * 1200;

                break;

            } else if (TotalRouters == 1) {

                Montototal = 1 * 1500;

                break;

            }

        }

        return Montototal;
    }

    //Se brinda precio de switches  de acuerdo a lo brindado por cliente

    public static int EquiposSwitches(int TotalSwitches){

        int PrecioSwitches = 0;

        switch(TotalSwitches){

            case 1:

                PrecioSwitches = 900;

                break;

            case 2:

                PrecioSwitches = 700;

                break;

            case 3:

                PrecioSwitches = 500;

                break;

            default:

                PrecioSwitches = 0;

        }

        return PrecioSwitches;

    }


    // Se brinda monto total por Switches.

    public static int TotalMontoSwitches (int TotalSwitches){

        int MontototalSwitches = 0;

        while (TotalSwitches > 0) {

            if (TotalSwitches == 1) {

                MontototalSwitches = 1 * 900;

                break;

            } else if (TotalSwitches == 2) {

                MontototalSwitches = 2 * 700;

                break;

            } else if (TotalSwitches == 3) {

                MontototalSwitches = 3 * 500;

                break;

            }

        }

        return MontototalSwitches;
    }

    //Se brinda precio de Aps  de acuerdo a lo brindado por cliente

    public static int EquiposAps (int TotalAps ){

        int PrecioAps = 0;

        switch(TotalAps){

            case 1:

                PrecioAps = 100;

                break;

            case 2:

                PrecioAps = 95;

                break;

            case 3:

                PrecioAps = 90;

                break;

            case 4:

                PrecioAps = 85;

                break;

            case 5:

                PrecioAps = 80;

                break;

            default:

                PrecioAps = 0;

        }

        return PrecioAps;

    }


    //Se brinda monto total por Aps

    public static int TotalMontoAps (int TotalAps){

        int MontototalAps = 0;

        while (TotalAps > 0) {

            if (TotalAps == 5) {

                MontototalAps = 5 * 80;

                break;

            } else if (TotalAps == 4) {

                MontototalAps = 4 * 85;

                break;

            } else if (TotalAps == 3) {

                MontototalAps = 3 * 90;

                break;

            } else if (TotalAps == 2) {

                MontototalAps = 2 * 95;

                break;

            } else if (TotalAps == 1) {

                MontototalAps = 1 * 100;

                break;

            }

        }

        return MontototalAps;
    }

    // Arreglo para obtener costo por hora de la instalacion de los productos

    public static int costototaladicional(int[] opciones){

        int totalcosto = 0;

        for ( int i = 0; i < opciones.length; i++){

            if(opciones[i] == 1){

                totalcosto = 90 * 8;

            } else if(opciones[i] == 2){

                totalcosto = 100 * 8;

            }else if(opciones[i] == 3){

                totalcosto = 80 * 8;

            }

        }

        return totalcosto;
    }


}
