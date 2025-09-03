package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Cylinder;
import com.jme3.scene.shape.Sphere;
import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;

/**
 * Bolos
 *
 * @author Ministerio de Educación. Gobierno de España.
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    private BulletAppState bulletAppState;
    private Material bola_mat, piedras_mat;
    private Vector3f defaultGravity = new Vector3f(0, -9.81f, 0);
    private boolean gravityEnabled = true;

    private AudioNode sonidoAmbiente;
    private AudioNode sonidoLanzar;

    @Override
    public void simpleInitApp() {

        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);

        // Crear materiales
        crearMateriales();

        // Creamos el suelo
        crearSuelo();

        // Creamos la pared
        crearPared();

        //crear los bolos
        crearBolos();

        // Crear la luz
        crearLuz();

        // Colocamos la cámara en una posición adecuada para ver la superficie
        // del suelo y mirando hacia ella.
        cam.setLocation(new Vector3f(0, 4f, 6f));
        cam.lookAt(new Vector3f(0, 2, 0), Vector3f.UNIT_Y);

        // Ponemos un color de fondo azul oscuro
        viewPort.setBackgroundColor(new ColorRGBA(0f, 0f, 0.2f, 0));

        //Iniciar sonidos:
        iniciarSonidos();

        // ¡Bola va!
        //hazBola();
        
        //LanzarBola
        configurarControles();
    }

    private void configurarControles() {
        inputManager.addMapping("LanzarBola", new KeyTrigger(KeyInput.KEY_SPACE), new MouseButtonTrigger(0));
        inputManager.addMapping("ToggleGravedad", new KeyTrigger(KeyInput.KEY_G));
        inputManager.addListener(accionListener, "LanzarBola", "ToggleGravedad");
    }

    private final ActionListener accionListener = (name, isPressed, tpf) -> {
        if (isPressed) {
            if (name.equals("LanzarBola")) {
                lanzarBola();
            } else if (name.equals("ToggleGravedad")) {
                toggleGravedad();
            }
        }
    };

    private void lanzarBola() {
        // Crear una esfera de 40 centímetros de diámetro 
        Sphere esfera = new Sphere(32, 32, 0.4f);
        // Asociar la forma a una geometría nueva
        Geometry bola_geo = new Geometry("Bola", esfera);
        // asignarle el material
        bola_geo.setMaterial(bola_mat);
        // añadirla al grafo de escena
        rootNode.attachChild(bola_geo);
        // la colocamos en la posición de la cámara
        bola_geo.setLocalTranslation(cam.getLocation());
        //añadir las sombras realistas
        bola_geo.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        // Creamos el objeto de control físico asociado a la bola con un peso
        // de 1Kg.
        RigidBodyControl bola_fis = new RigidBodyControl(1f);
        // Asociar la geometría de la bola al control físico
        bola_geo.addControl(bola_fis);
        // Añadirla al motor de física
        bulletAppState.getPhysicsSpace().add(bola_fis);
        // ¡Empujar la bola en la dirección que mira la cámara a una velocidad
        // de 8 metros por segundo!
        bola_fis.setLinearVelocity(cam.getDirection().mult(20));
        //añadir sonido al lanzar
        sonidoLanzar.play();
    }

    //método para deshabilitar la gravedad
    private void toggleGravedad() {
        gravityEnabled = !gravityEnabled;
        bulletAppState.getPhysicsSpace().setGravity(gravityEnabled ? defaultGravity : Vector3f.ZERO);
    }

//Código para crear los bolos cilindricos
    private void crearBolos() {
        float startX = 0.0f, startZ = -4.0f;
        int filas = 4;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j <= i; j++) {
                float x = startX + j * 1.0f - (i * 0.5f);
                float z = startZ - i * 1.2f;
                crearBolo(x, z);
            }
        }
    }

    private void crearBolo(float x, float z) {
        Cylinder bolo = new Cylinder(16, 16, 0.2f, 1.0f, true);
        Geometry bolo_geo = new Geometry("bolo", bolo);
        bolo_geo.rotate((float) Math.toRadians(-90), 0, 0);

        Material bolo_mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        bolo_geo.setMaterial(bolo_mat);
        //Añadir sombras al bolo
        bolo_geo.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        bolo_mat.setBoolean("UseMaterialColors", true);
        bolo_mat.setColor("Ambient", ColorRGBA.Red);
        bolo_mat.setColor("Diffuse", ColorRGBA.Red);
        bolo_mat.setColor("Specular", ColorRGBA.White);
        bolo_mat.setFloat("Shininess", 1);
        bolo_geo.setLocalTranslation(x, 0.5f, z);
        rootNode.attachChild(bolo_geo);

        //Añadir físicas al bolo
        RigidBodyControl bolo_fis = new RigidBodyControl(1f);
        bolo_geo.addControl(bolo_fis);
        bulletAppState.getPhysicsSpace().add(bolo_fis);
    }

    private void iniciarSonidos() {
        sonidoAmbiente = new AudioNode(assetManager, "Sound/Ambient/Nature.ogg", true);
        sonidoAmbiente.setLooping(true);
        sonidoAmbiente.setPositional(false);
        sonidoAmbiente.setVolume(0.5f);
        rootNode.attachChild(sonidoAmbiente);
        sonidoAmbiente.play();
        sonidoLanzar = new AudioNode(assetManager, "Sound/Effects/Sonido bola.wav", false);
        sonidoLanzar.setPositional(false);
        rootNode.attachChild(sonidoLanzar);
    }

    private void crearSuelo() {

        // Para hacer el suelo usaremos estas variables:
        // suelo    : la forma del suelo
        // suelo_mat: el material del suelo
        // suelo_geo: el spatial de tipo geometría que contendrá el suelo
        // suelo_fis: el objeto de control de físicas que está asociado al suelo
        // Creamos una forma de caja de 5 metros de ancho,
        // 10 de largo y 10cm de alto.
        Box suelo = new Box(Vector3f.ZERO, 5f, 0.1f, 10f);

        // ajustamos el tamaño de la textura que le dará aspecto de suelo
        // para que no se deforme
        suelo.scaleTextureCoordinates(new Vector2f(6, 3));

        // Creamos un spatial de tipo geometría para asociarlo al suelo
        Geometry suelo_geo = new Geometry("Floor", suelo);
        // asignamos el material
        suelo_geo.setMaterial(piedras_mat);
        // bajamos el suelo 10cm para que el origen esté un poco por encima
        suelo_geo.setLocalTranslation(0, -0.1f, 0);
        // y, finalmente, lo incluimos en el grafo de escena
        rootNode.attachChild(suelo_geo);

        // Crearemos un objeto de control físico para asociarlo al suelo
        // IMPORTANTE: tiene masa 0 para convertirlo en un objeto estático
        RigidBodyControl suelo_fis = new RigidBodyControl(0.0f);
        // asociamos el objeto de control a la geometría del suelo
        suelo_geo.addControl(suelo_fis);
        //agregar sombras al suelo
        suelo_geo.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        // y añadimos el objeto de control al motor de físicas
        bulletAppState.getPhysicsSpace().add(suelo_fis);

    }

    private void crearPared() {

        // Para hacer la pared usaremos estas variables:
        // pared    : la forma de la pared
        // pared_geo: el spatial de tipo geometría que contendrá la pared
        // pared_fis: el objeto de control de físicas que está asociado 
        // Creamos una forma de caja de 5 metros de ancho,
        // 10 de largo y 10cm de alto.
        Box pared = new Box(Vector3f.ZERO, 5f, 0.1f, 10f);

        // Ajustamos el tamaño de la textura que le dará el aspecto deseado
        // para que no se deforme
        pared.scaleTextureCoordinates(new Vector2f(6, 3));

        // Creamos un spatial de tipo geometría para asociarlo a la pared
        Geometry pared_geo = new Geometry("Floor", pared);
        // asignamos el material
        pared_geo.setMaterial(piedras_mat);
        //agregar sombras del suelo
        pared_geo.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        // lo desplazamos detrás del suelo e inclinado 90 grados en el eje X
        // para ponerlo en vertical
        pared_geo.setLocalTranslation(0, -0.1f, -10);
        pared_geo.rotate((float) Math.PI / 2.0f, 0f, 0);
        // y, finalmente, lo incluimos en el grafo de escena
        rootNode.attachChild(pared_geo);

        // Crearemos un objeto de control físico para asociarlo a la pared
        // IMPORTANTE: tiene masa 0 para convertirlo en un objeto estático
        RigidBodyControl pared_fis = new RigidBodyControl(0.0f);
        // asociamos el objeto de control a la geometría de la pared
        pared_geo.addControl(pared_fis);
        // y añadimos el objeto de control al motor de físicas
        bulletAppState.getPhysicsSpace().add(pared_fis);
    }

    private void crearLuz() {

        // Crearemos una luz direccional que parezca venir de la parte
        // superior derecha del jugador, por detrás.
        DirectionalLight luz = new DirectionalLight();

        // de color blanco y no excesivamente brillante
        luz.setColor(ColorRGBA.White.mult(0.8f));

        // proveniente de la parte superior derecha de la posición inicial
        // del jugador, por detrás.
        luz.setDirection(new Vector3f(-1, -1, -1).normalizeLocal());

        // añadir la luz al grafo
        rootNode.addLight(luz);
    }

    private void crearMateriales() {
        // Creamos el material de la pared y el suelo a partir de una textura
        // predefinida, haciendo que se repita por su superficie
        piedras_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key = new TextureKey("Textures/Terrain/Pond/Pond.jpg");
        key.setGenerateMips(true);
        Texture textura = assetManager.loadTexture(key);
        textura.setWrap(WrapMode.Repeat);
        piedras_mat.setTexture("ColorMap", textura);

        // Creamos el material de la bola a partir de una base iluminada y
        // la hacemos de color azul reflectante.
        bola_mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        bola_mat.setBoolean("UseMaterialColors", true);
        bola_mat.setColor("Ambient", ColorRGBA.Cyan);
        bola_mat.setColor("Diffuse", ColorRGBA.Cyan);
        bola_mat.setColor("Specular", ColorRGBA.White);
        bola_mat.setFloat("Shininess", 1);

    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
