package infraestructura;

public interface Notificador {
    void enviar(String origen, String destinatario, String asunto, String cuerpo);
}