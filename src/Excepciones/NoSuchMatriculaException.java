package Excepciones;

public class NoSuchMatriculaException extends RuntimeException{
    public NoSuchMatriculaException(String mensaje){
        super(mensaje);
    }
}