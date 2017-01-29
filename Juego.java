import java.util.ArrayList;
import java.util.Random;

/**
 * Write a description of class Pregunta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Juego
{
    // Coleccion que almacena las preguntas con las que se jugara.
    private ArrayList<Pregunta> preguntas;
    // Coleccion que almacena posibles nombres para los jugadores.
    private ArrayList<String> nombres;
    // Array que almacena los jugadores que participan en la partida.
    private Jugador[] jugadores;
    // Atributo que indica a que jugador le toca.
    private int turnoDeJugador;
    // Atributo que almacena la pregunta actual.
    private Pregunta preguntaActual;

    /**
     * Constructor for objects of class Juego
     */
    public Juego(int cantidadJugadores)
    {
        Random aleatorio = new Random();
        nombres = new ArrayList<String>();
        llenarNombres();
        preguntas = new ArrayList<Pregunta>();
        llenarPreguntas();
        jugadores = new Jugador[cantidadJugadores];
        String nombresActuales = "";
        for(int i = 0; i < cantidadJugadores; i++){
            int index = aleatorio.nextInt(nombres.size());
            String nombreActual = nombres.remove(index);
            Jugador jugador = new Jugador(nombreActual);
            jugadores[i] = jugador;
            nombresActuales += nombreActual + " ";
        }
        turnoDeJugador = aleatorio.nextInt(cantidadJugadores);
    }

    /**
     * Llena la lista de nombres
     */
    private void llenarNombres()
    {
        nombres.add("Antonio");
        nombres.add("Perico");
        nombres.add("Maria");
        nombres.add("Pepa");
        nombres.add("Alejandro");
        nombres.add("Sofia");
        nombres.add("Teofilo");
        nombres.add("Azucena");
        nombres.add("Ramiro");
        nombres.add("Victoria");
    }

    /**
     * Llena la lista de preguntas.
     */
    private void llenarPreguntas()
    {
        preguntas.add(new Pregunta(4, "1+0=", "1"));
        preguntas.add(new Pregunta(4, "1+1=", "2"));
    }

    /**
     * Muestra toda la información de la partida.
     */
    public void infoPartida()
    {
        System.out.println("Jugadores que participan:");
        for(Jugador jugador : jugadores){
            System.out.println(jugador);
        }
        System.out.println("-------------------------");
        System.out.println("Preguntas por responder en la partida:");
        for(Pregunta pregunta : preguntas){
            System.out.println(pregunta.categoriaToString() + " " + pregunta.getEnunciado());
        }
        System.out.println("-------------------------");
        if(preguntas.size() > 0){
            System.out.println("Es el turno de " + jugadores[turnoDeJugador].getNombre());
        }else{
            partidaFinalizada();
        }
    }

    /**
     * Metodo que se encarga de modificar el turno.
     */
    private void actualizarTurno()
    {
        turnoDeJugador++;
        if(turnoDeJugador == jugadores.length){
            turnoDeJugador = 0;
        }
    }

    /**
     * Informa de quien es el turno, muestra la pregunta y si la respuesta es correcta o no.
     */
    public void siguientePregunta()
    {
        if(preguntas.size() > 0){
            Random aleatorio = new Random();
            if(preguntaActual == null){
                preguntaActual = preguntas.remove(aleatorio.nextInt(preguntas.size()));
            }
            System.out.println("Turno de " + jugadores[turnoDeJugador].getNombre());
            System.out.println(preguntaActual.getEnunciado());
        }else{
            partidaFinalizada();
        }
    }

    /**
     * Permite al jugador actual responder a su pregunta.
     */
    public void responder(String respuesta)
    {
        if(preguntaActual != null){
            boolean valorRespuesta = respuesta.equals(preguntaActual.getRespuesta());
            if(valorRespuesta){
                System.out.println("Correcto");
            }else{
                System.out.println("Has fallado, la respuesta era:");
                System.out.println(preguntaActual.getRespuesta());
            }
            jugadores[turnoDeJugador].respuesta(valorRespuesta);
            preguntaActual = null;
            actualizarTurno();
        }        
    }

    private void partidaFinalizada()
    {
        System.out.println("Se ha terminado la partida");
    }
}