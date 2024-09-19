import java.util.ArrayList;
import java.util.List;

/**
 * Betanzos Reyes Gustavo Noel
 * Clase que representa el analizador léxico (lexer).
 * Toma una entrada de texto y genera una lista de tokens.
 */
public class Lexer {
    private String input;  // Cadena de entrada a analizar
    private int pos;       // Posición actual en la cadena de entrada
    private int length;    // Longitud de la cadena de entrada

    /**
     * Constructor para inicializar el lexer con la entrada.
     * 
     * @param input La cadena de entrada que se analizará.
     */
    public Lexer(String input) {
        this.input = input;
        this.pos = 0;
        this.length = input.length();
    }

    /**
     * Método que realiza el análisis léxico de la entrada.
     * Genera una lista de tokens a partir de la entrada.
     * 
     * @return Lista de tokens obtenidos.
     */
    public List<Token> analizar() {
        List<Token> tokens = new ArrayList<>();
        
        // Recorre la entrada carácter por carácter
        while (pos < length) {
            char currentChar = input.charAt(pos);

            // Ignorar espacios en blanco
            if (Character.isWhitespace(currentChar)) {
                pos++;
                tokens.add(new Token(Token.ESPACIO, " "));
            }
            // Identificadores (formados por letras)
            else if (Character.isLetter(currentChar)) {
                tokens.add(analizarIdentificador());
            }
            // Números (enteros y decimales)
            else if (Character.isDigit(currentChar)) {
                tokens.add(analizarNumero());
            }
            // Operadores de asignación "="
            else if (currentChar == '=') {
                tokens.add(new Token(Token.OP_ASIGNACION, "="));
                pos++;
            }
            // Operador de suma "+"
            else if (currentChar == '+') {
                tokens.add(new Token(Token.OP_SUMA, "+"));
                pos++;
            }
            // Otros caracteres no válidos
            else {
                System.err.println("Error: Símbolo no reconocido '" + currentChar + "'");
                pos++;
            }
        }
        
        return tokens; // Devuelve la lista de tokens obtenidos
    }

    /**
     * Método auxiliar para analizar un identificador (secuencia de letras).
     * 
     * @return Token correspondiente a un identificador.
     */
    private Token analizarIdentificador() {
        StringBuilder sb = new StringBuilder();
        
        // Mientras haya letras, forma el identificador
        while (pos < length && Character.isLetter(input.charAt(pos))) {
            sb.append(input.charAt(pos));
            pos++;
        }
        
        return new Token(Token.IDENTIFICADOR, sb.toString());
    }

    /**
     * Método auxiliar para analizar un número (entero o decimal).
     * 
     * @return Token correspondiente a un número entero o decimal.
     */
    private Token analizarNumero() {
        StringBuilder sb = new StringBuilder();
        boolean isDecimal = false;
        
        // Parte entera del número
        while (pos < length && Character.isDigit(input.charAt(pos))) {
            sb.append(input.charAt(pos));
            pos++;
        }
        
        // Si se encuentra un punto, pasa a ser decimal
        if (pos < length && input.charAt(pos) == '.') {
            isDecimal = true;
            sb.append('.');
            pos++;
            
            // Parte decimal
            while (pos < length && Character.isDigit(input.charAt(pos))) {
                sb.append(input.charAt(pos));
                pos++;
            }
        }
        
        if (isDecimal) {
            return new Token(Token.NUMERO_DECIMAL, sb.toString());
        } else {
            return new Token(Token.NUMERO_ENTERO, sb.toString());
        }
    }
}
