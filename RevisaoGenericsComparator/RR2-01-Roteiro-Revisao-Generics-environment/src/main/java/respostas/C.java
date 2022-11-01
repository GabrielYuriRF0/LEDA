package respostas;

import java.util.ArrayList;

public class C implements A<String> {
    private ArrayList listaInterna = new ArrayList();

    @Override
    public void adicionar(String texto){
        listaInterna.add(texto);
    }
}
