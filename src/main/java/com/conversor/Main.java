package com.conversor;
//main
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Conversor de Moneda ===");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n1. Convertir moneda");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("\nMonedas disponibles:");
                    CurrencyOption[] monedas = CurrencyOption.values();
                    for (int i = 0; i < monedas.length; i++) {
                        System.out.printf("%d. %s - %s%n", i + 1, monedas[i].getCodigo(), monedas[i].getDescripcion());
                    }

                    System.out.print("Seleccione moneda base (número): ");
                    int baseIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    String from = monedas[baseIndex].getCodigo();

                    System.out.print("Seleccione moneda destino (número): ");
                    int targetIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    String to = monedas[targetIndex].getCodigo();

                    System.out.print("Monto a convertir: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    CurrencyConverter converter = new CurrencyConverter();
                    double result = converter.convert(from, to, amount);

                    if (result != -1) {
                        System.out.printf("💰 %.2f %s = %.2f %s%n", amount, from, result, to);
                    } else {
                        System.out.println("Error al obtener la conversión.");
                    }
                    break;


                case "2":
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();
        System.out.println("¡Gracias por usar el conversor!");
    }
}
