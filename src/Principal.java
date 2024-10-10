import com.aluracursos.challenge.Logs;
import com.aluracursos.challenge.Moneda;
import com.aluracursos.challenge.Monedas;
import com.aluracursos.challenge.apiservicio;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcion = 0;
        int moneda = 0;
        String apiKey = "abf5f7f8e9ec30627628197a";
        apiservicio api = new apiservicio();
        Logs logs = new Logs();

        Moneda monedaApi = api.buscaMoneda(apiKey);
        System.out.println(monedaApi);
        Monedas MonedasApi = monedaApi.conversion_rates().get(0);

        System.out.println("*****************************************");
        System.out.println(" Sea Bienvenido/a al Conversor de Moneda =]");
        String menu = """
                 **
                1) Dólar ==> Peso Argentino
                2) Peso Argentino ==> Dólar
                3) Dólar ==> Real Brasileño
                4) Real Brasileño ==> Dólar
                5) Dólar ==> Peso Colombiano
                6) Peso Colombiano ==> Dólar
                7) Dólar ==> Peso Chileno
                8) Peso Chileno ==> Dólar
                9) Salir
                 **
                """;
        Scanner teclado = new Scanner(System.in);
        while (opcion != 9){
            double valor = 0;
            String mensajeTexto = "";
            System.out.println(menu);
            System.out.println("*****************************************\n");
            opcion = teclado.nextInt();
            try {
                switch (opcion){
                    case 1:
                        System.out.println("Ingrese la Cantidad de Dolares a Convertir en Peso Argentino: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda * Double.parseDouble(MonedasApi.ARS());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" USD Corresponde a "+ String.format("%.2f", valor)  +" ARS.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 2:
                        System.out.println("Ingresa la Cantidad de Pesos Argentino a Convertir a Dolares: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda / Double.parseDouble(MonedasApi.ARS());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" ARS Corresponde a "+ String.format("%.2f", valor) +" USD.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 3:
                        System.out.println("Ingresa la Cantidad de Dolares a Convertir a Real Brasileño: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda * Double.parseDouble(MonedasApi.BRL());
                        mensajeTexto = "El valor "+String.format("%.2f", (double)moneda)+" USD Corresponde a "+ String.format("%.2f", valor) +" BRL.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 4:
                        System.out.println("Ingresa la Cantidad de Reales brasileño a Convertir a Dolares: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda / Double.parseDouble(MonedasApi.BRL());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" BRL Corresponde a "+ String.format("%.2f", valor) +" USD.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                       break;
                    case 5:
                        System.out.println("Ingresa la Cantidad de Dolares a convertir a Pesos Colombiano: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda * Double.parseDouble(MonedasApi.COP());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" USD Corresponde a "+ String.format("%.2f", valor) +" COP.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 6:
                        System.out.println("Ingresa la Cantidad de Pesos Colombiano a convertir a Dolares: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda / Double.parseDouble(MonedasApi.COP());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" COP Corresponde a "+ String.format("%.2f", valor) +" USD.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 7:
                        System.out.println("Ingresa la Cantidad de Dolares a convertir a Pesos Chileno: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda * Double.parseDouble(MonedasApi.CLP());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" USD Corresponde a "+ String.format("%.2f", valor) +" CLP.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 8:
                        System.out.println("Ingresa la Cantidad de Pesos Chileno a convertir a Dolares: ");
                        moneda = teclado.nextInt();
                        valor = (double)moneda / Double.parseDouble(MonedasApi.CLP());
                        mensajeTexto = "El Valor "+String.format("%.2f", (double)moneda)+" CLP Corresponde a "+ String.format("%.2f", valor) +" USD.";
                        logs.guardarTxt(mensajeTexto);
                        System.out.println(mensajeTexto);
                        break;
                    case 9:
                        System.out.println("Finalizando el programa. Muchas gracias por usar nuestros servicios");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (RuntimeException | IOException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación.");
            }

        }
        System.out.println("*****************************************");
    }
}
