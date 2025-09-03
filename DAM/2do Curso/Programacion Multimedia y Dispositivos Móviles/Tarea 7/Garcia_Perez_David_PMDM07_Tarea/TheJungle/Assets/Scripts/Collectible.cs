using UnityEngine;

public class Collectible : MonoBehaviour
{
    private void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Player")) 
        {
            GameManager.Instance.CollectObject();
            Destroy(gameObject); // Destruye el cubo al contacto
            Debug.Log("¡Objeto recolectado!"); // Mensaje de prueba
        }
    }
}