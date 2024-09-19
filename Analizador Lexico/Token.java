/**
 * Betanzos Reyes Gustavo Noel
 * Clase que representa un token en el lenguaje.
 * Los tipos de tokens incluyen identificadores, números enteros y decimales,
 * operadores de asignación, suma, y espacios en blanco.
 */
public class Token {
    // Definición de tipos de token
    public static final int IDENTIFICADOR = 0;
    public static final int NUMERO_ENTERO = 1;
    public static final int NUMERO_DECIMAL = 2;
    public static final int OP_ASIGNACION = 3;
    public static final int OP_SUMA = 4;
    public static final int ESPACIO = 5;

    // Atributos de un token
    private int tipo;     // Tipo del token
    private String valor; // Valor asociado al token

    /**
     * Constructor para inicializar un token con su tipo y valor.
     * 
     * @param tipo Tipo del token (IDENTIFICADOR, NUMERO_ENTERO, etc.)
     * @param valor Valor que representa el token
     */
    public Token(int tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * Método para obtener el tipo del token.
     * 
     * @return El tipo del token.
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * Método para obtener el valor del token.
     * 
     * @return El valor del token.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Método que devuelve la representación en forma de cadena del token,
     * describiendo su tipo y valor.
     */
    @Override
    public String toString() {
        switch (tipo) {
            case IDENTIFICADOR:
                return "IDENTIFICADOR: " + valor;
            case NUMERO_ENTERO:
                return "NUMERO ENTERO: " + valor;
            case NUMERO_DECIMAL:
                return "NUMERO DECIMAL: " + valor;
            case OP_ASIGNACION:
                return "OP ASIGNACION: " + valor;
            case OP_SUMA:
                return "OP SUMA: " + valor;
            case ESPACIO:
                return "ESPACIO";
            default:
                return "TOKEN DESCONOCIDO: " + valor;
        }
    }
}
