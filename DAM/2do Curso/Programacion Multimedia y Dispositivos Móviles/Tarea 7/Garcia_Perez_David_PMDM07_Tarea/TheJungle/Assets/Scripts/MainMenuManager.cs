using UnityEngine;
using UnityEngine.SceneManagement;
using TMPro;

public class MainMenuManager : MonoBehaviour
{
    [SerializeField] TMP_InputField usernameInput;
    [SerializeField] GameObject startButton;

    void Start()
    {
        // Asegurar que el campo de texto es interactivo al volver al menú
        usernameInput.interactable = true;
        
        usernameInput.Select();
        usernameInput.ActivateInputField();

        

        // Restablecer el cursor
        Cursor.lockState = CursorLockMode.None;
        Cursor.visible = true;
    }

    public void StartGame()
    {
        if (!string.IsNullOrEmpty(usernameInput.text))
        {
            PlayerPrefs.SetString("Username", usernameInput.text);
            SceneManager.LoadScene("PantallaJuego");
        }
    }
}