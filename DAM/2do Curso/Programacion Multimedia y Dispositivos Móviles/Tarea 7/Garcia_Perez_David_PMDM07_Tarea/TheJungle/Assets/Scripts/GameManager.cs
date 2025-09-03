using TMPro;
using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;
using UnityStandardAssets.Characters.FirstPerson;

public class GameManager : MonoBehaviour
{
    public static GameManager Instance;

    [Header("Configuración")]
    public float gameTime = 60f;

    [Header("Referencias Jugador")]
    public RigidbodyFirstPersonController playerController;

    [Header("UI")]
    public TMP_Text playerNameText;
    public TMP_Text objectsText;
    public TMP_Text timerText;
    public GameObject gameOverPanel;
    public TMP_Text resultText;

    private int totalObjects;
    private int collectedObjects = 0;
    private float currentTime;
    private bool isGameActive;

    void Awake()
    {
        if (Instance == null)
        {
            Instance = this;
        }
        else
        {
            Destroy(gameObject);
            return;
        }

        totalObjects = GameObject.FindGameObjectsWithTag("Collectible").Length;
    }

    void Start() => InitializeGame();

    void InitializeGame()
    {
        gameOverPanel.SetActive(false);
        playerNameText.text = PlayerPrefs.GetString("Username", "Jugador");
        currentTime = gameTime;
        isGameActive = true;
        StartCoroutine(Countdown());
        UpdateUI();

        if (playerController != null)
        {
            playerController.mouseLook.SetCursorLock(true);
            playerController.enabled = true; // Asegurar que el controlador está activo
        }
    }

    IEnumerator Countdown()
    {
        while (currentTime > 0 && isGameActive)
        {
            currentTime -= Time.deltaTime;
            UpdateTimerUI();
            yield return null;
        }

        if (isGameActive) EndGame(false);
    }

    public void CollectObject()
    {
        collectedObjects++;
        UpdateUI();
        if (collectedObjects >= totalObjects) EndGame(true);
    }

    void UpdateUI() => objectsText.text = $"{collectedObjects}/{totalObjects}";

    void UpdateTimerUI()
    {
        int seconds = Mathf.CeilToInt(currentTime);
        timerText.text = $"{seconds / 60:00}:{seconds % 60:00}";
    }

    public void EndGame(bool isVictory)
    {
        isGameActive = false;

        if (playerController != null)
        {
            playerController.enabled = false;
            playerController.mouseLook.SetCursorLock(false);
        }

        Cursor.lockState = CursorLockMode.None;
        Cursor.visible = true;

        gameOverPanel.SetActive(true);
        resultText.text = isVictory ? "¡Victoria!" : "¡Derrota!";
    }

    public void RestartGame()
    {
        // Destruir el GameManager actual para reiniciar
        Destroy(gameObject);
        SceneManager.LoadScene(SceneManager.GetActiveScene().name);
    }

    public void GoToMainMenu()
    {

        // Borrar el nombre del jugador para que se pueda introducir de nuevo
        PlayerPrefs.DeleteKey("Username");
        
        // Forzar estado del cursor
        Cursor.lockState = CursorLockMode.None;
        Cursor.visible = true;
        

        // Destruir GameManager y cargar escena
        Destroy(gameObject);
        
        SceneManager.LoadScene("PantallaPrincipal");
    }
}