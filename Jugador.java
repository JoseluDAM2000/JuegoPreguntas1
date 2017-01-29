
/**
 * 
 */
public class Jugador
{
    // Atributo que almacena el nombre del jugador.
    private String nombre;
    // Atributo que cuenta las respuestas correctas.
    private int respuestasCorrectas;
    // Atributo que cuenta las respuestas erroneas.
    private int errores;

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        this.nombre = nombre;
        respuestasCorrectas = 0;
        errores = 0;
    }

    /**
     * Devuelve un String con toda la información del jugador.
     */
    public String toString()
    {
        return "Jugador: " + nombre + " - Respuestas correctas: " + respuestasCorrectas + " - Errores: " + errores;
    }
    
    /**
     * Modifica la puntuacion dependiendo de la respuesta recibida por parametro.
     */
    public void respuesta(boolean respuesta)
    {
        if(respuesta){
            respuestasCorrectas++;
        }else{
            errores++;
        }
    }
    
    /**
     * Devuelve el nombre del jugador.
     */
    public String getNombre()
    {
        return nombre;
    }
}
