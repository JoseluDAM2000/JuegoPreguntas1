
/**
 * Write a description of class Pregunta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pregunta
{
    // Indica la categorua de la pregunta, 0 Geografia, 1 Arte 
    //y literatura, 2 Historia, 3 Entretenimiento, 4 Ciencias y naturaleza, 5 Deportes.
    private int categoria;
    // Almacena el enunciado de la pregunta.
    private String enunciado;
    // Almacena la respuesta de la pregunta.
    private String respuesta;

    /**
     * Constructor for objects of class Pregunta
     */
    public Pregunta(int categoria, String enunciado, String respuesta)
    {
        this.categoria = categoria;
        this.enunciado = enunciado;
        this.respuesta = respuesta;
    }

    /**
     * Devuelve un String con el nombre de la categoria de la pregunta.
     */
    private String categoriaToString()
    {
        String categoria = "";
        switch(this.categoria){
            case 0:
            categoria = "Geografía";
            break;
            case 1:
            categoria = "Arte y Literatura";
            break;
            case 2:
            categoria = "Historia";
            break;
            case 3:
            categoria = "Entretenimiento";
            break;
            case 4:
            categoria = "Ciencias y Naturaleza";
            break;
            case 5:
            categoria = "Deportes";
            break;
        }
        return categoria;
    }
    
    /**
     * Devuelve toda la información de la pregunta.
     */
    public String toString()
    {
        return categoriaToString() + " - " + getEnunciado() + " - " + getRespuesta();
    }
    
    /**
     * Devuelve la categoria a la que corresponde la pregunta.
     */
    public int getCategoria()
    {
        // put your code here
        return categoria;
    }
    
    /**
     * Devuelve el enunciado de la pregunta.
     */
    public String getEnunciado()
    {
        return enunciado;
    }
    
    /**
     * Devuelve la respuesta de la pregunta.
     */
    public String getRespuesta()
    {
        return respuesta;
    }
}
