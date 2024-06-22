package com.desafioAlura.desafio1.principal;

import com.desafioAlura.desafio1.model.DatosMonedas;
import com.desafioAlura.desafio1.service.ConsumoApi;
import com.desafioAlura.desafio1.service.ConversionService;
import com.desafioAlura.desafio1.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private ConsumoApi consumoApi = new ConsumoApi();
    private Scanner teclado = new Scanner(System.in);
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private final String API_KEY ="d3d173e607cb0f58dfdcc1f8";
    private ConvierteDatos convierteDatos = new ConvierteDatos();

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 9) {
            var menu = """
                    Sea Bienvenido al Conversor de moneda !!
                                        
                    1 - Dolar =>> Peso Argentino
                    2 - Peso Argentino =>> Dolar
                    3 - Dolar =>> Real Brasileño
                    4 - Real Brasileño =>> Dolar
                    5 - Dolar =>> Peso Colombiano
                    6 - Peso Colombiano =>> Dolar
                    7 - Dolar =>> Peso Chileno
                    8 - Peso Chileno =>> Dolar
                    9 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    mostrarDatosPesoArg();
                    break;
                case 2:
                    mostrarDatosDolAPesoArg();
                    break;
                case 3:
                    mostrarDatosRealBra();
                    break;
                case 4:
                    mostrarDatosDolABra();
                    break;
                case 5:
                    mostrarDatosPesoCol();
                    break;
                case 6:
                    mostrarDatosDolACol();
                    break;
                case 7:
                    mostrarDatosPesoClp();
                    break;
                case 8:
                    mostrarDatosDolAClp();
                    break;
                case 9:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");


            }
        }
    }
    public void mostrarDatosPesoArg(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");

        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;
        System.out.println("*************** DOLAR A PESO ARGENTINO ******************");
        System.out.println("Ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        // Ejemplo de conversión
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "USD", "ARS", cantidad);
        System.out.println(cantidad + " USD a ARS: " + cantidadConvertida);
    }
   public void  mostrarDatosRealBra(){
       var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");
       DatosMonedas datos = convierteDatos.obtenerDatos(json);
       //DatosMonedas datosMonedas;
       var cantidad =1;
       System.out.println("*************** DOLAR A PESO BRASILEÑO ******************");
       System.out.println("ingrese la cantidad a convertir:");
       cantidad = teclado.nextInt();
       double cantidadConvertida = ConversionService.convertirMoneda(datos, "USD", "BRL", cantidad);
       System.out.println(cantidad + " USD a BRL: " + cantidadConvertida);
    }
    public void mostrarDatosPesoCol(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");

        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;
        System.out.println("*************** DOLAR A PESO COLOMBIANO ******************");
        System.out.println("ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "USD", "COP", cantidad);
        System.out.println(cantidad + " USD a COP: " + cantidadConvertida);
    }
    public void mostrarDatosDolAPesoArg(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");
        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;
        System.out.println("*************** PESO ARGENTINO A DOLAR ********************");
        System.out.println("ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "ARS", "USD", cantidad);
        System.out.println(cantidad + " ARS a USD: " + cantidadConvertida);
    };
    public void mostrarDatosDolABra(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");
        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;
        System.out.println("*************** PESO BRASILEÑO A DOLAR ********************");
        System.out.println("ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "BRL", "USD", cantidad);
        System.out.println(cantidad + " BRL a USD: " + cantidadConvertida);
    };
    public void mostrarDatosDolACol(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");
        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;

        System.out.println("*************** PESO COLOMBIANO A DOLAR ********************");
        System.out.println("ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "COP", "USD", cantidad);
        System.out.println(cantidad + " BRL a USD: " + cantidadConvertida);
    };
    public void mostrarDatosPesoClp(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");
        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;

        System.out.println("*************** DOLAR A PESO CHILENO ********************");
        System.out.println("ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "USD", "CLP", cantidad);
        System.out.println(cantidad + " USD a CLP: " + cantidadConvertida);
    };
    public void mostrarDatosDolAClp(){
        var json = consumoApi.obtenerDatos(URL_BASE+API_KEY+"/latest/USD");
        DatosMonedas datos = convierteDatos.obtenerDatos(json);
        //DatosMonedas datosMonedas;
        var cantidad =1;

        System.out.println("*************** PESO CHILENO A DOLAR ********************");
        System.out.println("ingrese la cantidad a convertir:");
        cantidad = teclado.nextInt();
        double cantidadConvertida = ConversionService.convertirMoneda(datos, "CLP", "USD", cantidad);
        System.out.println(cantidad + " CLP a USD: " + cantidadConvertida);
    };
}










