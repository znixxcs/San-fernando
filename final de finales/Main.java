import java.util.Scanner;

public class Main {
    Scanner juancho = new Scanner(System.in);
    double billetera = 0;

    public static void main(String[] args) {
        Main sf = new Main();
        sf.MenuLogin();
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

    public void MenuLogin(){

        int intentosDeLogin = 0;
        int intertosRestantes = 3;
        String usuarioPredefinido = "admin";
        String contrasenaPredefinida = "1234";

        int rose;
        do {
            System.out.println("Te saluda san fernando ");
            System.out.println("1. Iniciemos secion");
            System.out.println("2. registremos otro usuario");
            System.out.println("0. Salir");
            System.out.println("Ingrese una opcion: ");
            rose = juancho.nextInt();
            juancho.nextLine();
            switch (rose) {
                case 1:
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
                        // Verificar si las credenciales son correctas en este caso son strings por eso el equals xd
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
                            System.exit(0);
                            daniMoon = false;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Vamos a crea la nueva cuenta");
                    System.out.println("Ingresa un nombre de usuario: ");
                    usuarioPredefinido = juancho.nextLine();
                    System.out.println("Ingresa la nueva contrasaña");
                    contrasenaPredefinida = juancho.nextLine();
                    System.out.println("Felicidades "+usuarioPredefinido+" se creo con exito");
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida xd");
                    break;
            }
        }while (rose != 0);
    }

    public void menuGeneral() {
        double totalPagar;
        double igv;
        int juan;
        do {

            System.out.println("____________________________________");
            System.out.println("|--- Bienvenido al menu General ---|");
            System.out.println("|--- 1) Ventas --------------------|");
            System.out.println("|--- 2) Campañas ------------------|");
            System.out.println("|--- 3) Contactos -----------------|");
            System.out.println("|--- 4) Ver estado financiero -----|");
            System.out.println("|--- 5) Finalisar venta -----------|");
            System.out.println("|--- 0) Salir ---------------------|");
            System.out.println("|--- Ingrese una opcion👇");
            juan = juancho.nextInt();
            juancho.nextLine();
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
                    igv = 0.18 * billetera;
                    totalPagar = billetera + igv;
                    System.out.println("| SUB TOTAL     : S/" + billetera);
                    System.out.println("| IGV           : S/" + igv);
                    System.out.println("| TOTAL A PAGAR : S/" + totalPagar);
                    break;
                case 5:
                    boolean benique = true;
                    while (benique) {
                        System.out.println("| Tienes un total a pagar de " + billetera + " por tus productor a comprar");
                        System.out.println("| Ingresar la cantidad que da el comprador: ");
                        double juanCantidad = juancho.nextDouble();
                        if (juanCantidad > billetera) {
                            double vuelto = juanCantidad - billetera;
                            System.out.println("Tu vuelto es: " + vuelto);
                            System.out.println("------------ Mini Factura ----------------");
                            System.out.println("| Tus gastos que realisaste son de: ");
                            igv = 0.18 * billetera;
                            totalPagar = billetera + igv;
                            System.out.println("| SUB TOTAL     : S/" + billetera);
                            System.out.println("| IGV           : S/" + igv);
                            System.out.println("| TOTAL A PAGAR : S/" + totalPagar);
                            System.out.println("----------------------------------------");
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
        System.out.println("La campaña no esta disponile por el momento, la proxima campaña empezara desde el 12 de diciembre");
    }

    public void Contactos() {
        System.out.println("Contactanos a este numero para poder ayudarlo mediante la compra **+51 902 240 595");
    }


    public void Ventas() {
        int juan;
        do {
            System.out.println("1) Pollo");
            System.out.println("2) Pavo");
            System.out.println("3) Embutidos");
            System.out.println("4) Cerdo");
            System.out.println("5) Huevo");
            System.out.println("0) Regresar al menu anterior");
            juan = juancho.nextInt();
            juancho.nextLine();
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
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (juan != 0);
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
            juancho.nextLine();
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
            juancho.nextLine();
            switch (juan) {
                case 1:
                    System.out.println("Muslo de Pollo Congelado");
                    System.out.println("S/ 13.50 x kg");
                    String producto1 = "Muslo de Pollo Congelado";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad1 = juancho.nextInt();
                    double total1 = cantidad1 * 13.50;
                    System.out.println("Compraste :" + producto1 + " a " + total1 + " soles");
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
            juancho.nextLine();
            switch (juan) {
                case 1:
                    System.out.println("Pollo entero sin piel");
                    System.out.println("S/ 13.80 x kg");
                    String producto1 = "Pollo entero sin piel";
                    System.out.print("Ingre la cantidad de Kg que desee: ");
                    int cantidad1 = juancho.nextInt();
                    double total1 = cantidad1 * 13.80;
                    System.out.println("Compraste :" + producto1 + " a " + total1 + " soles");
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
            juancho.nextLine();
            switch (juan) {
                case 1:
                    System.out.println("Pollo sazón al horno x 800 Gr");
                    String producto1 = "Pollo sazón al horno x 800 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad1 = juancho.nextInt();
                    double total1 = cantidad1 * 12.50;
                    System.out.println("Compraste :" + producto1 + " a " + total1 + " soles");
                    billetera += total1;
                    break;
                case 2:
                    System.out.println("Pollo sazón oriental x 800 Gr");
                    String producto2 = "Pollo sazón oriental x 800 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad2 = juancho.nextInt();
                    double total2 = cantidad2 * 11.40;
                    System.out.println("Compraste :" + producto2 + " a " + total2 + " soles");
                    billetera += total2;
                    break;
                case 3:
                    System.out.println("Pollo sazón Pachamanca x 650 Gr");
                    String producto3 = "Pollo sazón Pachamanca x 650 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad3 = juancho.nextInt();
                    double total3 = cantidad3 * 12.50;
                    System.out.println("Compraste :" + producto3 + " a " + total3 + " soles");
                    billetera += total3;
                    break;
                case 4:
                    System.out.println("Pollo sazón pollada x 800 Gr");
                    String producto4 = "Pollo sazón pollada x 800 Gr";
                    System.out.print("Ingre la cantidad que desee: ");
                    int cantidad4 = juancho.nextInt();
                    double total4 = cantidad4 * 12.70;
                    System.out.println("Compraste :" + producto4 + " a " + total4 + " soles");
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
        int lobo = 0;
        do {
            System.out.println("que tipo de carne eligira?");
            System.out.println("Opcion1: pechuga de pavito en trosos $25.00");
            System.out.println("Opcion2: pechuga de pavo horneado $30.00");
            System.out.println("Opcion3: pechuga de pavo especial $50.00");
            System.out.println("Opcion4: pavo entero $50.00");
            System.out.println("Opcion5: --MENU PAVOS DE CELEBRACIONES");
            System.out.println("Opcion6: --MENU PAVOS CONGELADOS");
            System.out.println("Opcion7: --MENU PAVOS HORNEADOS");
            System.out.println("Opcion0: Para regresar");
            System.out.println("Ingrese una opcion");
            int tipodecarne = juancho.nextInt();
            juancho.nextLine();
            switch (tipodecarne) {
                case 1:
                    System.out.println("cuantas pechugas de pavito en trosos va querer");
                    int cantdad1 = juancho.nextInt();
                    double cantpechugadepavoentrosos = 25.00;
                    double totalpagar1 = cantpechugadepavoentrosos * 2;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += cantpechugadepavoentrosos;
                    break;
                case 2:
                    System.out.println("cuantas pechugas de pavo horneado va querer?");
                    int cantidad2 = juancho.nextInt();
                    double cantpechugapavohorneado = 30.00;
                    double totalapagar = cantpechugapavohorneado * 2;
                    System.out.println("El total a pagar es : " + totalapagar);
                    billetera += cantpechugapavohorneado;
                    break;
                case 3:
                    System.out.println("cuanats pechugas de pavo especial? va querer?");
                    int cantidad3 = juancho.nextInt();
                    double cantpechugapavoespecial = 50.00;
                    double pagar = cantpechugapavoespecial * 2;
                    System.out.println("El total a pagar es : " + pagar);
                    billetera += cantpechugapavoespecial;
                case 4:
                    System.out.println("cuanats pechugas de pavo entero va querer?");
                    int cantidad4 = juancho.nextInt();
                    double cantpechugapavoentero = 50.00;
                    double pago = cantpechugapavoentero * 2;
                    System.out.println("El total a pagar es : " + pago);
                    billetera += cantpechugapavoentero;
                    break;
                case 5:
                    Celebraciones();
                    break;
                case 6:
                    congelados();
                    break;
                case 7:
                    horneados();
                    break;
                case 0:
                    System.out.println("Estas regresando... :C");
                    break;
                default:
                    System.out.println("Opcion no valido");
            }
        } while (lobo != 0);
    }

    public void Celebraciones() {
        int juan;
        do {
            System.out.println("Bienvenido al menu de Pavos de celebraciones");
            System.out.println("1) Pavo con menudencia congelado $147.30");
            System.out.println("2) Enrollado americano de pavita $48.00");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            juancho.nextLine();
            switch (juan) {
                case 1:
                    System.out.println("Pavo con menudencia congelado Rango de 9 a 10 Kg.");
                    String producto1 = "Pavo con menudencia congelado";
                    System.out.println("S/ 147.30 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo1 = juancho.nextInt();
                    double total1 = Bernardo1 * 147.30;
                    System.out.println("Usted esta comprando" + producto1 + " Con un total a pagar de " + total1);
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
            System.out.println("Bienvenido al menu de Congelados ");
            System.out.println("1) Medio pavo congelado $72.50");
            System.out.println("2) Pavo congelado $136.60");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            juancho.nextLine();
            switch (juan) {
                case 1:
                    System.out.println("Medio Pavo 3.5kg");
                    String producto1 = "Medio Pavo 3.5kg";
                    System.out.println("S/ 72.50 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo1 = juancho.nextInt();
                    double total1 = Bernardo1 * 72.50;
                    System.out.println("Usted esta comprando" + producto1 + " Con un total a pagar de " + total1);
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
            System.out.println("Bienvenido al menu de Congelados ");
            System.out.println("1) Pechuga de Pavo Horneada $55.00");
            System.out.println("0) Salir");
            System.out.println("Ingrese una opcion:");
            juan = juancho.nextInt();
            juancho.nextLine();
            switch (juan) {
                case 1:
                    System.out.println("Pechuga de Pavo Horneada");
                    String producto1 = "Pechuga de Pavo Horneada";
                    System.out.println("S/ 55.00 !!");
                    System.out.print("Ingrese la cantidad Que desea:");
                    int Bernardo1 = juancho.nextInt();
                    double total1 = Bernardo1 * 55.00;
                    System.out.println("Usted esta comprando" + producto1 + " Con un total a pagar de " + total1);
                    billetera += total1;
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
            juancho.nextLine();
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
            juancho.nextLine();
            switch (juan) {
                case 1://Chorizo parrillero
                    System.out.println("cuantas Chorizo parrillero va querer: ");
                    int catidad1 = juancho.nextInt();
                    double cantChorizoParrillero = 11.60;
                    double totalpagar1 = cantChorizoParrillero * catidad1;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    break;
                case 2://Chorizo parrillero finas hierbas
                    System.out.println("cuantas Chorizo parrillero finas hierbas va querer: ");
                    int catidad2 = juancho.nextInt();
                    double cantChorizoParrilleroFinasHierbas = 17.00;
                    double totalpagar2 = cantChorizoParrilleroFinasHierbas * catidad2;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    break;
                case 3://Chorizo parrillero brasa
                    System.out.println("cuantas Chorizo parrillero brasa va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double cantChorizoParrilleroBrasa = 17.00;
                    double totalpagar3 = cantChorizoParrilleroBrasa * cantidad3;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    break;
                case 4://Chorizo cocido parrillero
                    System.out.println("cuantas Chorizo cocido parrillero va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double cantChorizoCocidoParrillero = 16.10;
                    double totalpagar4 = cantChorizoCocidoParrillero * cantidad4;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
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
            juancho.nextLine();
            switch (juancho1) {
                case 1://Jamonada especial molde
                    System.out.println("cuantas Jamonada especial molde va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 11.60;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    break;
                case 2://Tocino ahumado
                    System.out.println("cuantas Tocino ahumado va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 45.30;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    break;
                case 3://Chicharrón de prensa
                    System.out.println("cuantas Chicharrón de prensa va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 3.60;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    break;
                case 4://Jamonada especial molde
                    System.out.println("Chicharrón de prensa molde: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 43.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
                    billetera += totalpagar4;
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
            juancho.nextLine();
            switch (juancho1) {
                case 1://Jamoneta de pollo
                    System.out.println("cuantas Jamoneta de pollo va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 30.60;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    break;
                case 2://Jamonada con pollo especial molde
                    System.out.println("cuantas Jamonada con pollo especial molde va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 40.60;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    break;
                case 3://Súper jamoneta de pollo
                    System.out.println("cuantas Súper jamoneta de pollo va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 35.00;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    break;
                case 4://Jamonada especial
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 28.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
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

    public void jamones() {
        int juancho1;
        do {
            System.out.println("que tipo de chorizo eligira?");
            System.out.println("Opcion1: Jamón de pavita x 100gr");
            System.out.println("Opcion2: Jamón ahumado de pavita");
            System.out.println("Opcion3: Jamón de pechuga de pavita");
            System.out.println("Opcion4: Jamón del país");
            System.out.println("Opcion0: Regresar");
            System.out.println("Ingrese una opcion:");
            juancho1 = juancho.nextInt();
            juancho.nextLine();
            switch (juancho1) {
                case 1://Jamón de pavita x 100gr
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 4.90;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    break;
                case 2://Jamón ahumado de pavita
                    System.out.println("cuantas Jamón ahumado de pavita va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 11.10;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    break;
                case 3://Jamón de pechuga de pavita
                    System.out.println("cuantas Jamón de pechuga de pavita va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 12.20;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    break;
                case 4://Jamón del país
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 28.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
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

    public void salchHotDog() {
        int juancho1;
        do {
            System.out.println("que tipo de chorizo eligira?");
            System.out.println("Opcion1: Súper salchicha rosada");
            System.out.println("Opcion2: Súper salchicha roja panchos");
            System.out.println("Opcion3: Súper salchicha naranja");
            System.out.println("Opcion4: Súper Hot Dog");
            System.out.println("Opcion0: Regresar");
            System.out.println("Ingrese una opcion:");
            juancho1 = juancho.nextInt();
            juancho.nextLine();
            switch (juancho1) {
                case 1://Súper salchicha rosada
                    System.out.println("cuantas Súper salchicha rosada va querer: ");
                    int cantidad1 = juancho.nextInt();
                    double totalpagar1 = cantidad1 * 5.70;
                    System.out.println("El total a pagar es : " + totalpagar1);
                    billetera += totalpagar1;
                    break;
                case 2://Súper salchicha roja panchos
                    System.out.println("cuantas salchicha roja panchos va querer: ");
                    int cantidad2 = juancho.nextInt();
                    double totalpagar2 = cantidad2 * 6.70;
                    System.out.println("El total a pagar es : " + totalpagar2);
                    billetera += totalpagar2;
                    break;
                case 3://salchicha naranja
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad3 = juancho.nextInt();
                    double totalpagar3 = cantidad3 * 8.90;
                    System.out.println("El total a pagar es : " + totalpagar3);
                    billetera += totalpagar3;
                    break;
                case 4://Súper Hot Dog
                    System.out.println("cuantas Jamonada especial va querer: ");
                    int cantidad4 = juancho.nextInt();
                    double totalpagar4 = cantidad4 * 5.00;
                    System.out.println("El total a pagar es : " + totalpagar4);
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