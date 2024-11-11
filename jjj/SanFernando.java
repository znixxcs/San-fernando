import java.util.ArrayList;
import java.util.Scanner;

public class SanFernando {
    class Usuario {
        String nombreUsuario;
        String contrasena;

        // Constructor
        public Usuario(String nombreUsuario, String contrasena) {
            this.nombreUsuario = nombreUsuario;
            this.contrasena = contrasena;
        }

        // Método para verificar si las credenciales coinciden
        public boolean verificarCredenciales(String nombreUsuario, String contrasena) {
            return this.nombreUsuario.equals(nombreUsuario) && this.contrasena.equals(contrasena);
        }
    }
    Scanner juancho = new Scanner(System.in);
    double billetera = 0;

    // ArrayList para almacenar los usuarios
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {
        SanFernando sf = new SanFernando();
        sf.Login();
    }

    // Método para mostrar el logo
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

    // Método de login
    public void Login() {
        // Agregar usuarios a la lista (puedes agregar más usuarios si lo deseas)
        agregarUsuarios();

        int intentosRestantes = 3;  // Número de intentos de login
        logo();  // Mostrar el logo

        // Loop de login
        while (intentosRestantes > 0) {
            System.out.print("Ingresa tu nombre de usuario: ");
            String usuarioIngresado = juancho.nextLine();  // Leer nombre de usuario

            System.out.print("Ingresa tu contraseña: ");
            String contrasenaIngresada = juancho.nextLine();  // Leer contraseña

            // Verificar si las credenciales son correctas
            boolean loginExitoso = false;
            for (Usuario usuario : usuarios) {
                if (usuario.verificarCredenciales(usuarioIngresado, contrasenaIngresada)) {
                    System.out.println("¡Inicio de sesión exitoso!");
                    menuGeneral();  // Mostrar el menú si el login es exitoso
                    return;  // Salir del método después de un login exitoso
                }
            }

            // Si llegamos aquí, significa que las credenciales no fueron correctas
            System.out.println("Usuario o contraseña incorrectos.");
            intentosRestantes--;
            System.out.println("Te quedan " + intentosRestantes + " intentos");
        }

        // Si el número de intentos se agota
        System.out.println("Más suerte la próxima vez :v");
        juancho.close();
    }

    // Método para agregar usuarios a la lista
    private void agregarUsuarios() {
        usuarios.add(new Usuario("admin", "1234"));  // Usuario predefinido
        // Puedes agregar más usuarios aquí si lo deseas
        usuarios.add(new Usuario("juan", "5678"));
        usuarios.add(new Usuario("maria", "abcd"));
    }

    // Método del menú general (aquí puedes agregar más opciones)
    public void menuGeneral() {
        System.out.println("Bienvenido al menú general. Aquí puedes agregar más funcionalidades.");
        // Aquí puedes agregar más lógica para el menú
    }
}