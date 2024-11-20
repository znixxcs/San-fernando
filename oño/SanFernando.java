import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SanFernando {
    ArrayList<String> productos = new ArrayList<>();
    String comprador;
    String dni;
    Scanner juancho = new Scanner(System.in);
    double billetera = 0;

    public static void main(String[] args) {
        SanFernando sf = new SanFernando();
        sf.Login();
    }

    public void logo() {
        System.out.println("""
                =============================================================================================
                  SSSSS    AAAAA   N    N     FFFFF  EEEEE  RRRRR   N    N   AAAAA  N    N  DDDDD   OOOOO
                 S        A     A  NN   N     F      E      R    R  NN   N  A     A NN   N  D    D  O     O
                 SSSSS    AAAAAAA  N N  N     FFFFF  EEEEE  RRRRR   N N  N  AAAAAAA N N  N  D     D O      O
                      S   A     A  N  N N     F      E      R   R   N  N N  A     A N  N N  D    D  O     O
                  SSSSS   A     A  N    N     F      EEEEE  R    R  N    N  A     A N    N  DDDDD   OOOOO
                =============================================================================================""");
    }

    public void Login() {
        int intentosDeLogin = 0;
        int intertosRestantes = 3;
        String usuarioPredefinido = "juan";
        String contrasenaPredefinida = "123";


        boolean daniMoon = true;
        logo();
        while (daniMoon) {
            //Tarea crear apartado de Crear cuenta ( do, switch cases.
            // Solicitar el nombre de usuario
            System.out.print("Ingresa tu nombre de usuario: ");
            String usuarioIngresado = juancho.nextLine();
            // Solicitar la contraseña
            System.out.print("Ingresa tu contraseña: ");
            String contrasenaIngresada = juancho.nextLine();
            // Verificar si las credenciales son correctas
            if (usuarioPredefinido.equals(usuarioIngresado) && contrasenaPredefinida.equals(contrasenaIngresada)) {
                System.out.println("¡Inicio de sesión exitoso!");
                menuGeneral();
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
                intentosDeLogin++;
                intertosRestantes--;
                System.out.println("Te quedan " + intertosRestantes + " intentos");
            }
            if (intentosDeLogin == 3) {
                System.out.println("Mas suerte la proxiam vez :v");
                juancho.close();
                daniMoon = false;
            }
        }

    }

    public void menuGeneral() {
        int juan;
        do {
            System.out.println("____________________________________");
            System.out.println("|--- Bienvenido al menu General ---|");
            System.out.println("|--- 1) Ventas --------------------|");
            System.out.println("|--- 2) Campañas ------------------|");
            System.out.println("|--- 3) Contactos -----------------|");
            System.out.println("|--- 4) Ver estado financiero -----|");
            System.out.println("|--- 5) Finalisar venta -----------|");
            System.out.println("|--- 6) Registrar Comprador -------|");
            System.out.println("|--- 0) Salir ---------------------|");
            System.out.println("|--- Ingrese una opcion👇");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    Ventas();
                    break;
                case 2:
                    Campanas();
                    break;
                case 3:
                    Contactos();
                    break;
                case 4:
                    System.out.println("| Tus gastos a tener son de: ");
                    double igv = 0.18 * billetera;
                    double totalPagar = billetera + igv;
                    System.out.println("| SUB TOTAL     : S/" + billetera);
                    System.out.println("| IGV           : S/" + igv);
                    System.out.println("| TOTAL A PAGAR : S/" + totalPagar);
                    break;
                case 5:
                    boolean benique = true;
                    while (benique) {
                        System.out.println("| Tienes que pagar " + billetera + " por tus productor a comprar");
                        System.out.println("| Ingresar la cantidad que da el comprador: ");
                        double juanCantidad = juancho.nextDouble();
                        if (juanCantidad > billetera) {
                            double vuelto = juanCantidad - billetera;
                            System.out.println("Tu vuelto es: " + vuelto);
                            System.out.println("Muchas gracias por confiar en nosotros !!!");
                            billetera = 0;
                            System.out.println("---- Empesemos una nueva Venta !!!");
                            menuGeneral();
                        } else if (juanCantidad < billetera) {
                            double juanDiferencia = billetera - juanCantidad;
                            System.out.println("No alcansa te falta darme: " + juanDiferencia);
                            System.out.println("Intentemoslo nuevamente -_-");
                        }
                        benique = false;
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del comprador: ");
                    comprador = juancho.nextLine();
                    System.out.println("Ingrese el dni del comprador: ");
                    dni = juancho.nextLine();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void Campanas() {
    }

    public void Contactos() {
    }

    public void Ventas() {
        int juan;
        do {
            System.out.println("1) Pollo");
            System.out.println("2) Pavo");
            System.out.println("3) Embutidos");
            System.out.println("4) Cerdo");
            System.out.println("5) Huevo");
            System.out.println("6) finalisar venta");
            System.out.println("0) Regresar al menu anterior");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    Pollo();
                    break;
                case 2:
                    Pavo();
                    break;
                case 3:
                    Embutidos();
                    break;
                case 4:
                    Cerdo();
                    break;
                case 5:
                    Huevo();
                    break;
                case 6:
                    finalisarcompra();
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void finalisarcompra() {
        int juan;
        do {
//            System.out.println("?) Eliminar producto de carrito");
            System.out.println("----------------------------------------- ");
            System.out.println("1) ver carrito");
            System.out.println("2) Exportar boleta de ventas");
            System.out.println("0) Regresar al menu anterior");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    vercarrito();
                    break;
                case 2:
                    exportarboleta();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }while (juan != 0);
    }
    public void vercarrito() {
        System.err.println("|--------------- Carrito ---------------|");
        System.err.println("| Comprador: "+comprador+" con DNI: "+dni+" |");
        System.err.println("----------------- Productos --------------|");
        System.err.println("|canti|---Nombre producto-----------------------| Total pagar");
        for (String producto : productos) {
            System.err.println(producto);
        }
        System.err.println("|---------- Gastos Generales -----------|");
        System.err.println("|  TOTAL A FACTURAR: ");
        double igv = 0.18 * billetera;
        double totalPagar = billetera + igv;

        System.err.println("|- Sub total     : S/"+ billetera);
        System.err.println("|- Igv           : S/"+ igv);
        System.err.println("|- Total a pagar : S/"+ totalPagar);
    }
    public void exportarboleta() {
        String nombreArchivo = "D:\\Facturaboleta.txt";

        try (FileWriter tumi = new FileWriter(nombreArchivo)) {
            tumi.write("|--------------- Carrito ---------------|\n");
            tumi.write("| Comprador: "+comprador+" con DNI: "+dni+" |\n");
            tumi.write("|-------------- Productos --------------|\n");
            tumi.write("|canti|---Nombre producto-----------------------| Total pagar\n");
            for (String producto : productos) {
                tumi.write(producto+"\n");
            }
            tumi.write("|---------- Gastos Generales -----------|\n");
            tumi.write("|  TOTAL A FACTURAR: \n");
            double igv = 0.18 * billetera;
            double totalPagar = billetera + igv;

            tumi.write("|- Sub total     : S/"+ billetera+"\n");
            tumi.write("|- Igv           : S/"+ igv+"\n");
            tumi.write("|- Total a pagar : S/"+ totalPagar+"\n");

            System.err.println("Factura generada correctamente en el archivo: " + nombreArchivo);
        } catch (IOException D) {
            System.err.println("Error al escribir la factura en el archivo: " + nombreArchivo);
        }

    }
    public void Pollo() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Pollos");
            System.out.println("1) Pollo Congelado");
            System.out.println("2) Pollo Fresco");
            System.out.println("3) Saborizado de Pollos");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    polloCongelado();
                    break;
                case 2:
                    polloFresco();
                    break;
                case 3:
                    saborizadoDePollos();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void polloCongelado() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Pollos Congelados");
            System.out.println("1) Muslo de Pollo Congelado");
            System.out.println("2) Ala de pollo congelada");
            System.out.println("3) Pierna de Pollo Congelada");
            System.out.println("4) Filete de Pechuga de Pollo Congelado");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    System.out.println("Muslo de Pollo Congelado");
                    System.out.println("S/ 13.50 x kg");
                    String producto1 = "Muslo de Pollo Congelado";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad1 = juancho.nextInt();
                    double total1 = cantidad1 * 13.50;
                    System.out.println("Compraste :" + producto1 + " a " + total1 + " soles");
                    productos.add("|- " + cantidad1 + " -|- Muslo de Pollo Congelado S/ 13.50 x kg -|- S/" + total1 + " -|");
                    billetera += total1;
                    break;
                case 2:
                    System.out.println("Ala de pollo congelada");
                    System.out.println("S/ 14.70 x kg");
                    String producto2 = "Ala de pollo congelada";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad2 = juancho.nextInt();
                    double total2 = cantidad2 * 14.70;
                    System.out.println("Compraste :" + producto2 + " a " + total2 + " soles");
                    productos.add("|- " + cantidad2 + " -|- Ala de pollo congelada S/ 14.70 x kg -|- S/" + total2 + " -|");
                    billetera += total2;
                    break;
                case 3:
                    System.out.println("Pierna de Pollo Congelada");
                    System.out.println("S/ 15.00 x kg");
                    String producto3 = "Pierna de Pollo Congelada";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad3 = juancho.nextInt();
                    double total3 = cantidad3 * 15.00;
                    System.out.println("Compraste :" + producto3 + " a " + total3 + " soles");
                    productos.add("|- " + cantidad3 + " -|- Ala de pollo congelada S/ 14.70 x kg -|- S/" + total3 + " -|");
                    billetera += total3;
                    break;
                case 4:
                    System.out.println("Filete de Pechuga de Pollo Congelado");
                    System.out.println("S/ 23.00 x kg");
                    String producto4 = "Filete de Pechuga de Pollo Congelado";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad4 = juancho.nextInt();
                    double total4 = cantidad4 * 23.00;
                    System.out.println("Compraste :" + producto4 + " a " + total4 + " soles");
                    productos.add("|- " + cantidad4 + " -|- Filete de Pechuga de Pollo Congelado S/ 23.00 x kg -|- S/" + total4 + " -|");
                    billetera += total4;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void polloFresco() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Pollos Frescos");
            System.out.println("1) Pollo entero sin piel");
            System.out.println("2) Pollo fresco con menudencia");
            System.out.println("3) Filete Pechuga de pollo");
            System.out.println("4) Pechuga de Pollo con Alas");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    System.out.println("Pollo entero sin piel");
                    System.out.println("S/ 13.80 x kg");
                    String producto1 = "Pollo entero sin piel";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad1 = juancho.nextInt();
                    double total1 = cantidad1 * 13.80;
                    System.out.println("Compraste :" + producto1 + " a " + total1 + " soles");
                    productos.add("|- " + cantidad1 + " -|- Pollo entero sin piel S/ 13.80 -|- S/" + total1 + " -|");
                    billetera += total1;
                    break;
                case 2:
                    System.out.println("Pollo fresco con menudencia");
                    System.out.println("S/ 9.40 x kg");
                    String producto2 = "Pollo fresco con menudencia";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad2 = juancho.nextInt();
                    double total2 = cantidad2 * 9.40;
                    System.out.println("Compraste :" + producto2 + " a " + total2 + " soles");
                    productos.add("|- " + cantidad2 + " -|- Pollo fresco con menudencia S/ 9.40 -|- S/" + total2 + " -|");
                    billetera += total2;
                    break;
                case 3:
                    System.out.println("Filete Pechuga de pollo");
                    System.out.println("S/ 18.40 x kg");
                    String producto3 = "Filete Pechuga de pollo";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad3 = juancho.nextInt();
                    double total3 = cantidad3 * 18.40;
                    System.out.println("Compraste :" + producto3 + " a " + total3 + " soles");
                    productos.add("|- " + cantidad3 + " -|- Filete Pechuga de pollo S/ 18.40 -|- S/" + total3 + " -|");
                    billetera += total3;
                    break;
                case 4:
                    System.out.println("Pechuga de Pollo con Alas");
                    System.out.println("S/ 14.40 x kg");
                    String producto4 = "Pechuga de Pollo con Alas";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad4 = juancho.nextInt();
                    double total4 = cantidad4 * 14.40;
                    System.out.println("Compraste :" + producto4 + " a " + total4 + " soles");
                    productos.add("|- " + cantidad4 + " -|- Pechuga de Pollo con Alas S/ 14.40 -|- S/" + total4 + " -|");
                    billetera += total4;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void saborizadoDePollos() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Saborizados de Pollos");
            System.out.println("1) Pollo al horno");
            System.out.println("2) Pollo oriental");
            System.out.println("3) Pollo pachamanca");
            System.out.println("4) Pollo pollada");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    System.out.println("Pollo sazón al horno x 800 Gr");
                    String producto1 = "Pollo sazón al horno x 800 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad1 = juancho.nextInt();
                    double total1 = cantidad1 * 12.50;
                    System.out.println("Compraste :" + producto1 + " a " + total1 + " soles");
                    productos.add("|- " + cantidad1 + " -|- Pollo sazón al horno x 800 Gr S/ 12.50 -|- S/" + total1 + " -|");
                    billetera += total1;
                    break;
                case 2:
                    System.out.println("Pollo sazón oriental x 800 Gr");
                    String producto2 = "Pollo sazón oriental x 800 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad2 = juancho.nextInt();
                    double total2 = cantidad2 * 11.40;
                    System.out.println("Compraste :" + producto2 + " a " + total2 + " soles");
                    productos.add("|- " + cantidad2 + " -|- Pollo sazón oriental x 800 Gr S/ 11.40 -|- S/" + total2 + " -|");
                    billetera += total2;
                    break;
                case 3:
                    System.out.println("Pollo sazón Pachamanca x 650 Gr");
                    String producto3 = "Pollo sazón Pachamanca x 650 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad3 = juancho.nextInt();
                    double total3 = cantidad3 * 12.50;
                    System.out.println("Compraste :" + producto3 + " a " + total3 + " soles");
                    productos.add("|- " + cantidad3 + " -|- Pollo sazón Pachamanca x 650 Gr S/ 12.50 -|- S/" + total3 + " -|");
                    billetera += total3;
                    break;
                case 4:
                    System.out.println("Pollo sazón pollada x 800 Gr");
                    String producto4 = "Pollo sazón pollada x 800 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad4 = juancho.nextInt();
                    double total4 = cantidad4 * 12.70;
                    System.out.println("Compraste :" + producto4 + " a " + total4 + " soles");
                    productos.add("|- " + cantidad4 + " -|- Pollo sazón pollada x 800 Gr S/ 12.70 -|- S/" + total4 + " -|");
                    billetera += total4;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void Pavo() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Pavos");
            System.out.println("1) celebraciones");
            System.out.println("2) congelados");
            System.out.println("3) horneados");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    celebraciones();
                    break;
                case 2:
                    congelados();
                    break;
                case 3:
                    horneados();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void celebraciones() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Pavos de celebraciones");
            System.out.println("1) Pavo con menudencia congelado");
            System.out.println("2) Enrollado americano de pavita");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    System.out.println("Pavo con menudencia congelado Rango de 9 a 10 Kg.");
                    String producto1 = "Pavo con menudencia congelado";
                    System.out.println("S/ 147.30 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo1 = juancho.nextInt();
                    double total1 = Bernardo1 * 147.30;
                    System.out.println("Usted esta comprando" + producto1 + " Con un total a pagar de " + total1);
                    productos.add("|- " + Bernardo1 + " -|- Pavo con menudencia congelado Rango de 9 a 10 Kg. S/ 147.30 -|- S/" + total1 + " -|");
                    billetera += total1;
                    break;
                case 2:
                    System.out.println("Enrollado americano de pavita x 1.30 Kg");
                    String producto2 = "Enrollado americano de pavita x 1.30 Kg";
                    System.out.println("S/ 48.00 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo2 = juancho.nextInt();
                    double total2 = Bernardo2 * 48.00;
                    System.out.println("Usted esta comprando" + producto2 + " Con un total a pagar de " + total2);
                    productos.add("|- " + Bernardo2 + " -|- Enrollado americano de pavita x 1.30 Kg S/ 48.00 -|- S/" + total2 + " -|");
                    billetera += total2;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void congelados() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Congelados");
            System.out.println("1) Medio pavo congelado");
            System.out.println("2) Pavo congelado");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    System.out.println("Medio Pavo 3.5kg");
                    String producto1 = "Medio Pavo 3.5kg";
                    System.out.println("S/ 72.50 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo1 = juancho.nextInt();
                    double total1 = Bernardo1 * 72.50;
                    System.out.println("Usted esta comprando" + producto1 + " Con un total a pagar de " + total1);
                    productos.add("|- " + Bernardo1 + " -|- Medio Pavo 3.5kg S/ 72.50 -|- S/" + total1 + " -|");
                    billetera += total1;
                    break;
                case 2:
                    System.out.println("Enrollado americano de pavito");
                    String producto2 = "Enrollado americano de pavito";
                    System.out.println("S/ 136.60 !!");
                    System.out.print("Cuantos pavos quieres:");
                    int Bernardo2 = juancho.nextInt();
                    double total2 = Bernardo2 * 136.60;
                    System.out.println("Usted esta comprando" + producto2 + " Con un total a pagar de " + total2);

                    billetera += total2;
                    productos.add("|- " + Bernardo2 + " -|- Enrollado americano de pavito S/ 136.60 -|- S/" + total2 + " -|");
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void horneados() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Congelados");
            System.out.println("1) Pechuga de Pavo Horneada");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    System.out.println("Pechuga de Pavo Horneada");
                    String producto1 = "Pechuga de Pavo Horneada";
                    System.out.println("S/ 55.00 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo1 = juancho.nextInt();
                    double total1 = Bernardo1 * 55.00;
                    System.out.println("Usted esta comprando" + producto1 + " Con un total a pagar de " + Bernardo1);

                    billetera += total1;
                    productos.add("|- " + Bernardo1 + " -|- Pechuga de Pavo Horneada S/ 55.00 -|- S/" + total1 + " -|");
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void Embutidos() {
        int juan;
        do {
            System.out.println("Bienvenido al Menu Embutidos");
            System.out.println("1) Chorizos");
            System.out.println("2) Especiales");
            System.out.println("3) Jamonadas");
            System.out.println("4) Jamones");
            System.out.println("5) Salch/Hot-Dog");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1:
                    chorizos();
                    break;
                case 2:
                    especiales();
                    break;
                case 3:
                    jamonadas();
                    break;
                case 4:
                    jamones();
                    break;
                case 5:
                    salchHotDog();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void chorizos() {
        int juan;
        do {
            System.out.println("Bienvenido a los Embutidos-Chorizos");
            System.out.println("1) Chorizo parrillero");
            System.out.println("2) Chorizo parrillero finas hierbas");
            System.out.println("3) Chorizo parrillero brasa");
            System.out.println("4) Chorizo cocido parrillero");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            switch (juan) {
                case 1://Chorizo parrillero
                    System.out.println("cuantas Chorizo parrillero va querer: ");
                    int catidad1 = juancho.nextInt();
                    double cantChorizoParrillero = 11.60;
                    double totalpagar1 = cantChorizoParrillero * catidad1;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    productos.add("|- " + catidad1 + " -|- Chorizo parrillero S/ 11.60 -|- S/" + totalpagar1 + " -|");
                    break;
                case 2://Chorizo parrillero finas hierbas
                    System.out.println("cuantas Chorizo parrillero finas hierbas va querer: ");
                    int catidad2 = juancho.nextInt();
                    double cantChorizoParrilleroFinasHierbas = 17.00;
                    double totalpagar2 = cantChorizoParrilleroFinasHierbas * catidad2;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    productos.add("|- " + catidad2 + " -|- Chorizo parrillero finas hierbas S/ 17.00 -|- S/" + totalpagar2 + " -|");
                    break;
                case 3://Chorizo parrillero brasa
                    System.out.println("cuantas Chorizo parrillero brasa va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double cantChorizoParrilleroBrasa = 17.00;
                    double totalpagar3 = cantChorizoParrilleroBrasa * cantidad3;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    productos.add("|- " + cantidad3 + " -|- Chorizo parrillero brasa S/ 17.00 -|- S/" + totalpagar3 + " -|");
                    break;
                case 4://Chorizo cocido parrillero
                    System.out.println("cuantas Chorizo cocido parrillero va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double cantChorizoCocidoParrillero = 16.10;
                    double totalpagar4 = cantChorizoCocidoParrillero * cantidad4;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
                    productos.add("|- " + cantidad4 + " -|- Chorizo cocido parrillero S/ 16.10 -|- S/" + totalpagar4 + " -|");
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
    }

    public void especiales() {
        int juancho1;
        do {
            System.out.println("que tipo de chorizo eligira?");
            System.out.println("Opcion1: Jamonada especial molde");
            System.out.println("Opcion2: Tocino ahumado");
            System.out.println("Opcion3: Chicharrón de prensa");
            System.out.println("Opcion4: Chicharrón de prensa molde");
            System.out.println("Opcion0: Regresar");
            System.out.println("Ingrese una opcion:");
            juancho1 = juancho.nextInt();
            switch (juancho1) {
                case 1://Jamonada especial molde
                    System.out.println("cuantas Jamonada especial molde va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 11.60;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    productos.add("|- " + cantidad1 + " -|- Jamonada especial molde S/ 11.60 -|- S/" + totalpagar1 + " -|");
                    break;
                case 2://Tocino ahumado
                    System.out.println("cuantas Tocino ahumado va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 45.30;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    productos.add("|- " + cantidad2 + " -|- Tocino ahumado S/ 45.30 -|- S/" + totalpagar2 + " -|");
                    break;
                case 3://Chicharrón de prensa
                    System.out.println("cuantas Chicharrón de prensa va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 3.60;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    productos.add("|- " + cantidad3 + " -|- Chicharrón de prensa S/ 3.60 -|- S/" + totalpagar3 + " -|");
                    break;
                case 4://Jamonada especial molde
                    System.out.println("cuanto de Chicharrón de prensa molde va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 43.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
                    productos.add("|- " + cantidad4 + " -|- Chicharrón de prensa molde S/ 43.00 -|- S/" + totalpagar4 + " -|");
                    break;
                case 0:
                    System.out.println("Regresando...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juancho1 != 0);
    }

    public void jamonadas() {
        int juancho1;
        do {
            System.out.println("que tipo de chorizo eligira?");
            System.out.println("Opcion1: Jamoneta de pollo");
            System.out.println("Opcion2: Jamonada con pollo especial molde");
            System.out.println("Opcion3: Súper jamoneta de pollo");
            System.out.println("Opcion4: Jamonada especial");
            System.out.println("Opcion0: Regresar");
            System.out.println("Ingrese una opcion:");
            juancho1 = juancho.nextInt();
            switch (juancho1) {
                case 1://Jamoneta de pollo
                    System.out.println("cuantas Jamoneta de pollo va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 30.60;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    productos.add("|- " + cantidad1 + " -|- Jamoneta de pollo S/ 30.60 -|- S/" + totalpagar1 + " -|");
                    break;
                case 2://Jamonada con pollo especial molde
                    System.out.println("cuantas Jamonada con pollo especial molde va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 40.60;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    productos.add("|- " + cantidad2 + " -|- Jamonada con pollo especial molde S/ 40.60 -|- S/" + totalpagar2 + " -|");
                    break;
                case 3://Súper jamoneta de pollo
                    System.out.println("cuantas Súper jamoneta de pollo va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 35.00;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    productos.add("|- " + cantidad3 + " -|- Súper jamoneta de pollo S/ 35.00 -|- S/" + totalpagar3 + " -|");
                    break;
                case 4://Jamonada especial
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 28.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
                    productos.add("|- " + cantidad4 + " -|- Jamonada especial S/ 28.00 -|- S/" + totalpagar4 + " -|");
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juancho1 != 0);
    }

    public void jamones() {
        int juancho1;
        do {
            System.out.println("que tipo de chorizo eligira?");
            System.out.println("Opcion1: Jamón de pavita x 100gr");
            System.out.println("Opcion2: Jamón ahumado de pavita");
            System.out.println("Opcion3: Jamón de pechuga de pavita");
            System.out.println("Opcion4: Jamón del país");
            juancho1 = juancho.nextInt();
            switch (juancho1) {
                case 1://Jamón de pavita x 100gr
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 4.90;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    productos.add("|- " + cantidad1 + " -|- Jamonada especial S/ 4.90 -|- S/" + totalpagar1 + " -|");
                    break;
                case 2://Jamón ahumado de pavita
                    System.out.println("cuantas Jamón ahumado de pavita va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 11.10;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    productos.add("|- " + cantidad2 + " -|- Jamón ahumado de pavita S/ 11.10 -|- S/" + totalpagar2 + " -|");
                    break;
                case 3://Jamón de pechuga de pavita
                    System.out.println("cuantas Jamón de pechuga de pavita va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 12.20;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    productos.add("|- " + cantidad3 + " -|- Jamón de pechuga de pavita S/ 28.00 -|- S/" + totalpagar3 + " -|");
                    break;
                case 4://Jamón del país
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 28.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
                    productos.add("|- " + cantidad4 + " -|- Jamonada especial S/ 28.00 -|- S/" + totalpagar4 + " -|");
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;

            }
        } while (juancho1 != 0);

    }

    public void salchHotDog() {
        int juancho1;
        do {
            System.out.println("que tipo de chorizo eligira?");
            System.out.println("Opcion1: Súper salchicha rosada");
            System.out.println("Opcion2: Súper salchicha roja panchos");
            System.out.println("Opcion3: Súper salchicha naranja");
            System.out.println("Opcion4: Súper Hot Dog");
            juancho1 = juancho.nextInt();
            switch (juancho1) {
                case 1://Súper salchicha rosada
                    System.out.println("cuantas Súper salchicha rosada va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 5.70;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    productos.add("|- " + cantidad1 + " -|- Salchicha rosada S/ 5.70 -|- S/" + totalpagar1 + " -|");
                    break;
                case 2://Súper salchicha roja panchos
                    System.out.println("cuantas salchicha roja panchos va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 6.70;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    productos.add("|- " + cantidad2 + " -|- Salchicha roja panchos S/ 6.70 -|- S/" + totalpagar2 + " -|");
                    break;
                case 3://salchicha naranja
                    System.out.println("cuantas salchicha naranja especial va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 8.90;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    productos.add("|- " + cantidad3 + " -|- Salchicha naranja S/ 8.90 -|- S/" + totalpagar3 + " -|");
                    break;
                case 4://Súper Hot Dog
                    System.out.println("cuantas de Súper Hot Dog va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 5.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
                    productos.add("|- " + cantidad4 + " -|- Súper Hot Dog S/ 5.00 -|- S/" + totalpagar4 + " -|");
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (juancho1 != 0);
    }

    public void Cerdo() {
        int tumi;
        do {
            System.out.println("1) Cerdo Fresco");
            System.out.println("2) Cerdo Congelado");
            System.out.println("0) Salir");
            System.out.println("Ingresar una opcion: ");
            tumi = juancho.nextInt();
            juancho.nextLine();
            switch (tumi) {
                case 1:
                    cerdoFresco();
                    break;
                case 2:
                    cerdoCongelado();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (tumi != 0);
    }

    public void cerdoFresco() {
        int tumi222;
        do {
            System.out.println("1) Chuleta lomo de cerdo");
            System.out.println("2) Chuleta de brazuelo");
            System.out.println("3) Enrollado de Bondiola de Cerdo");
            System.out.println("0) Salirr");
            System.out.println("Ingresar una opcion:: ");
            tumi222 = juancho.nextInt();
            juancho.nextLine();
            switch (tumi222) {
                case 1:
                    System.out.println("¿cuantas Chuleta lomo de cerdo va querer?");
                    System.out.println("S/ 20.20 x u");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 20.20;
                    System.out.println("Compraste :" + cantidad1 + " a " + totalpagar1 + " soles");
                    billetera += totalpagar1;
                    break;
                case 2:
                    System.out.println("¿Cuantas Chuleta de brazuelo va querer?");
                    System.out.println("S/ 35.70 x u");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 35.70;
                    System.out.println("Compraste :" + cantidad2 + " a " + totalpagar2 + " soles");
                    billetera += totalpagar2;
                    break;
                case 3:
                    System.out.println("¿cuantas Enrollado de Bondiola de Cerdo va querer?");
                    System.out.println("S/ 33.00 x u");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 33.00;
                    System.out.println("Compraste :" + cantidad3 + " a " + totalpagar3 + " soles");
                    billetera += totalpagar3;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (tumi222 != 0);
    }

    public void cerdoCongelado() {
        int fernando;
        do {
            System.out.println("1) Pernil de cerdo congelado x und (Rango de 7 a 8 Kg)");
            System.out.println("2) Pierna de Cerdo Congelado (9 a 10 Kg)");
            System.out.println("3) Brazuelo de Cerdo congelado (5 a 6 Kg)");
            System.out.println("0) Salir");
            System.out.println("Ingresar una opcion: ");
            fernando = juancho.nextInt();
            juancho.nextLine();
            switch (fernando) {
                case 1:
                    System.out.println("¿cuantas Pernil de cerdo congelado va querer?");
                    System.out.println("S/ 225.00 x u");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 225.00;
                    System.out.println("Compraste :" + cantidad1 + " a " + totalpagar1 + " soles");
                    billetera += totalpagar1;
                    break;
                case 2:
                    System.out.println("¿cuantas Pierna de Cerdo Congelado va querer?");
                    System.out.println("S/ 240.20 x u");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 240.20;
                    System.out.println("Compraste :" + cantidad2 + " a " + totalpagar2 + " soles");
                    billetera += totalpagar2;
                    break;
                case 3:
                    System.out.println("¿cuantas Brazuelo de Cerdo congelado va querer?");
                    System.out.println("S/ 187.00 x u");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 187.00;
                    System.out.println("Compraste :" + cantidad3 + " a " + totalpagar3 + " soles");
                    billetera += totalpagar3;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (fernando != 0);
    }

    public void Huevo() {
        int juancho1;
        do {
            System.out.println("que tipo de heuvos eligira?");
            System.out.println("Opcion1: huevo de pavo $2.00");
            System.out.println("Opcion2: huevo de gallina natural $3.00");
            System.out.println("Opcion3: huevo de codorniz $4.00");
            System.out.println("Opcion4: huevo extranjero $5.00");
            System.out.println("Opcion0: Regresar");
            System.out.println("Ingrese una opcion:");
            juancho1 = juancho.nextInt();
            juancho.nextLine();
            switch (juancho1) {
                case 1://huevo de pavo
                    System.out.println("¿cuantas cantidades de huevo de pavo va querer?");
                    System.out.println("s/2.00 x u");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 2.00;
                    System.out.println("Compraste :" + cantidad1 + " a " + totalpagar1 + " soles");
                    billetera += totalpagar1;
                    break;
                case 2://huevo de gallina natural
                    System.out.println("¿cuantas cantidades de huevo de gallina natural va querer?");
                    System.out.println("s/3.00 x u");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 3.00;
                    System.out.println("Compraste :" + cantidad2 + " a " + totalpagar2 + " soles");
                    billetera += totalpagar2;
                    break;
                case 3://huevo de codorniz
                    System.out.println("¿cuantas cantidades de huevo de codorniz va querer? ");
                    System.out.println("s/4.00 x u");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 4.00;
                    System.out.println("Compraste :" + cantidad3 + " a " + totalpagar3 + " soles");
                    billetera += totalpagar3;
                    break;
                case 4://huevo de extranjero
                    System.out.println("¿cuantas cantidades de huevo de extranjero va querer?");
                    System.out.println("s/5.00 x u");
                    int producto4 = juancho.nextInt();
                    double totalpagar4 = producto4 * 5.00;
                    System.out.println("Compraste :" + producto4 + " a " + totalpagar4 + " soles");
                    billetera += totalpagar4;
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (juancho1 != 0);
    }
}
