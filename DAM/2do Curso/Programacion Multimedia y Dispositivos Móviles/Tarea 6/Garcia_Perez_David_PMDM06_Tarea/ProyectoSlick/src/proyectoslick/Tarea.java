/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoslick;

import java.io.File;
import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.*;
import org.newdawn.slick.Input.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.tiled.*;

/**
 *
 * @author David
 */
public class Tarea extends BasicGame {

    // Tilemap
    private TiledMap mapa;

    // Estado del jugador
    private float jugadorX, jugadorY;
    private SpriteSheet cuadros;
    private SpriteSheet cuadrosRobot;
    private SpriteSheet explosionSheet;
    private Animation jugador;
    private Animation jugadorArriba;
    private Animation jugadorDerecha;
    private Animation jugadorAbajo;
    private Animation jugadorIzquierda;
    private boolean jugadorVivo;

    // Estado de los robots
    private Animation[] robot;
    private Animation robotArriba;
    private Animation robotDerecha;
    private Animation robotAbajo;
    private Animation robotIzquierda;
    private float[] robotX, robotY;
    private boolean[] robotVivo;
    private int numeroRobotsVivos;
    private Animation explosion;
    private float explosionX, explosionY;
    private boolean explosionActiva;

    private Music musicaFondo;
    private Music musicaVictoria;
    private Sound sonidoExplosion;

    // Escritura de cadenas
    private UnicodeFont fuente;

    public Tarea(String name) {
        super(name);
    }

    // Contador de tiempo
    private long tiempo;

    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath", new File("data/native/windows").getAbsolutePath());
        System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
        try {
            AppGameContainer container = new AppGameContainer(new Tarea("PMDM06 - Tarea"));
            container.setDisplayMode(640, 480, false);
            container.setTargetFrameRate(60);
            container.setVSync(true);
            container.setShowFPS(false);
            container.setUpdateOnlyWhenVisible(false);
            container.start();
        } catch (SlickException e) {
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {

        // cargar mapa
        mapa = new TiledMap("data/mapa.tmx", "data");

        // cargar spritesheets
        cuadros = new SpriteSheet("data/heroe.png", 24, 32);
        cuadrosRobot = new SpriteSheet("data/robot.png", 24, 32);
        //Incluimos el spritesheet de la explosión:
        explosionSheet = new SpriteSheet("data/explosion.png", 64, 64);
        // cargar animaciones del jugador
        jugadorArriba = new Animation(cuadros, 0, 0, 2, 0, true, 150, false);
        jugadorDerecha = new Animation(cuadros, 0, 1, 2, 1, true, 150, false);
        jugadorAbajo = new Animation(cuadros, 0, 2, 2, 2, true, 150, false);
        jugadorIzquierda = new Animation(cuadros, 0, 3, 2, 3, true, 150, false);
        jugador = jugadorAbajo;

        // cargar animaciones del robot
        robotArriba = new Animation(cuadrosRobot, 0, 0, 2, 0, true, 150, true);
        robotDerecha = new Animation(cuadrosRobot, 0, 1, 2, 1, true, 150, true);
        robotAbajo = new Animation(cuadrosRobot, 0, 2, 2, 2, true, 150, true);
        robotIzquierda = new Animation(cuadrosRobot, 0, 3, 2, 3, true, 150, true);

        // estado inicial del jugador
        jugadorX = 320;
        jugadorY = 240;
        jugadorVivo = true;

        // estado inicial de los robots       
        robot = new Animation[4];
        robotX = new float[4];
        robotY = new float[4];
        robotVivo = new boolean[4];
        numeroRobotsVivos = 4;

        // los colocamos mirando al jugador y en las 4 esquinas
        robot[0] = robotDerecha;
        robot[1] = robotIzquierda;
        robot[2] = robotDerecha;
        robot[3] = robotIzquierda;

        robotX[0] = 20;
        robotX[1] = 596;
        robotX[2] = 20;
        robotX[3] = 596;

        robotY[0] = 84;
        robotY[1] = 84;
        robotY[2] = 428;
        robotY[3] = 428;

        // indicamos que, de momento, los 4 robots están vivos
        for (int i = 0; i < 4; i++) {
            robotVivo[i] = true;
        }

        // cargar tipo de letra de la carpeta data y todos los símboles
        // que podamos necesitar        
        fuente = new UnicodeFont("data/tuffy.ttf", 28, false, false);
        // añade las letras ASCII estándar
        fuente.addAsciiGlyphs();
        // y ahora añadimos los caracteres españoles
        fuente.addGlyphs("áéíóúÁÉÍÓÚñÑ¡¿");
        // en Slick es obligatorio añadir un efecto para poder dibujar
        // texto. Añadimos un efecto vacío.
        fuente.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        // cargamos los símbolos del tipo de letra
        fuente.loadGlyphs();

        // a partir de ahora, llamado a fuente.drawString(x, y, texto) ¡podremos
        // escribir en el contenedor!
        // comenzar cuenta de tiempo. Apuntamos el número que contiene el
        // reloj del sistema en milisegundos. De esta forma, restando esta
        // cantidad a la cuenta actual nos dice el número de milisengudos
        // que han transcurrido.
        tiempo = System.currentTimeMillis();

        try {
            musicaFondo = new Music("data/musica de fondo.wav");
            musicaVictoria = new Music("data/musica victoria.wav");
            sonidoExplosion = new Sound("data/efecto explosion.wav");

            // Iniciar la música de fondo en bucle
            musicaFondo.loop();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        Input entrada = gc.getInput();

        // si no quedan robots o ha muerto el jugador, no actualizar nada
        if ((jugadorVivo == false) || (numeroRobotsVivos == 0)) {
            return;
        }

        // movimiento del jugador
        if (entrada.isKeyDown(Input.KEY_DOWN)) {	// Tecla abajo
            jugadorY += delta * 0.1f;
            // evitar que nos salgamos por la parte inferior del contenedor
            if (jugadorY > (gc.getHeight() - jugador.getHeight())) {
                jugadorY = (gc.getHeight() - jugador.getHeight());
            }
            jugador = jugadorAbajo;
            jugador.update(delta);
        }
        if (entrada.isKeyDown(Input.KEY_UP)) {	// Tecla arriba
            jugadorY -= delta * 0.1f;
            // evitar que nos salgamos por la parte superior del contenedor
            if (jugadorY < 32) {
                jugadorY = 32;
            }
            jugador = jugadorArriba;
            jugador.update(delta);
        }
        if (entrada.isKeyDown(Input.KEY_RIGHT)) {	// Tecla derecha
            jugadorX += delta * 0.1f;
            // evitar que nos salgamos por la derecha del contenedor
            if (jugadorX > (gc.getWidth() - jugador.getWidth())) {
                jugadorX = (gc.getWidth() - jugador.getWidth());
            }
            jugador = jugadorDerecha;
            jugador.update(delta);
        }
        if (entrada.isKeyDown(Input.KEY_LEFT)) {	// Tecla izquierda
            jugadorX -= delta * 0.1f;
            // evitar que nos salgamos por la izquierda del contenedor
            if (jugadorX < 0) {
                jugadorX = 0;
            }
            jugador = jugadorIzquierda;
            jugador.update(delta);
        }

        // Movimiento y colisiones de los robots
        float velocidadRobot = 0.01f + (System.currentTimeMillis() - tiempo) * 0.000015f; // Aceleración

        for (int i = 0; i < 4; i++) {
            if (robotVivo[i]) {
                float dx = jugadorX - robotX[i];
                float dy = jugadorY - robotY[i];
                float distancia = (float) Math.sqrt(dx * dx + dy * dy);

                // Normaliza el vector de dirección y mueve el robot
                if (distancia > 0) {
                    robotX[i] += (dx / distancia) * velocidadRobot * delta;
                    robotY[i] += (dy / distancia) * velocidadRobot * delta;
                }

                // Verificar colisiones con otros robots
                for (int j = i + 1; j < 4; j++) {
                    if (robotVivo[i] && robotVivo[j]) {
                        float distX = robotX[i] - robotX[j];
                        float distY = robotY[i] - robotY[j];
                        float distanciaEntreRobots = (float) Math.sqrt(distX * distX + distY * distY);
                        if (distanciaEntreRobots < 30) { // Ajustar el umbral de colisión
                            robotVivo[i] = false;
                            robotVivo[j] = false;

                            numeroRobotsVivos -= 2;

                            // Calculamos la posición de la explosión en el punto medio
                            float explosionPosX = (robotX[i] + robotX[j]) / 2;
                            float explosionPosY = (robotY[i] + robotY[j]) / 2;

                            // Activar la explosión
                            mostrarExplosion(explosionPosX, explosionPosY);
                            sonidoExplosion.play();

                        }
                    }
                }

                // Verificar si un robot toca al jugador
                if (robotVivo[i]) {
                    float distX = jugadorX - robotX[i];
                    float distY = jugadorY - robotY[i];
                    if (Math.sqrt(distX * distX + distY * distY) < 32) { // Verifica si el robot colisiona con el jugador
                        jugadorVivo = false;
                    }

                }

                if (numeroRobotsVivos == 0 && musicaVictoria.playing() == false) {
                    musicaFondo.stop();
                    musicaVictoria.play();
                }

            }

        }

    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {

        // dibujar tilemap
        mapa.render(0, 0);

        // dibujar jugador
        jugador.draw(jugadorX, jugadorY);

        // dibujar robots si están vivos
        for (int i = 0; i < 4; i++) {
            if (robotVivo[i]) {
                robot[i].draw(robotX[i], robotY[i]);
            }
        }

        // Dibujar la explosión si está activa
        if (explosionActiva) {
            explosion.draw(explosionX, explosionY);

            // Desactivar la explosión cuando termine la animación
            if (explosion.isStopped()) {
                explosionActiva = false;
            }
        }

        // dibujar robots restantes
        fuente.drawString(400, 10, "Quedan " + numeroRobotsVivos + " robots");

        if (numeroRobotsVivos == 0) {
            String gameOver = "¡Has ganado!";
            // dibujamos el texto centrado en el contenedor
            fuente.drawString((gc.getWidth() - fuente.getWidth(gameOver)) / 2, (gc.getHeight() - fuente.getHeight(gameOver)) / 2, gameOver, Color.yellow);
            return;
        } else {
            if (jugadorVivo == false) {
                String gameOver = "Fin de juego";
                // dibujamos el texto centrado en el contenedor
                fuente.drawString((gc.getWidth() - fuente.getWidth(gameOver)) / 2, (gc.getHeight() - fuente.getHeight(gameOver)) / 2, gameOver, Color.red);
                return;
            }
        }

        // dibujar tiempo transcurrido si no ha acabado el juego
        fuente.drawString(40, 10, "Tiempo: " + (System.currentTimeMillis() - tiempo) / 1000);

    }

    //Método que incluye la animación de la explosión:
    private void mostrarExplosion(float x, float y) {
        explosionX = x;
        explosionY = y;
        explosion = new Animation(explosionSheet, 100); // 100 ms por frame
        explosion.setLooping(false); //evita que realice la animación en bucle.
        explosion.restart();  // Reinicia la animación desde el primer frame
        explosionActiva = true;
    }
}
