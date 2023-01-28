import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> Portugues = new HashMap<>();
    Map<String, String> Ingles = new HashMap<>();

    public void adicionarPalavra(String palavra, String traducao, TipoDicionario tipoDicionario){
        if (tipoDicionario.equals(TipoDicionario.INGLES)){
            Ingles.put(palavra.toLowerCase(), traducao.toLowerCase());
        } else if (tipoDicionario.equals(TipoDicionario.PORTUGUES)) {
            Portugues.put(palavra.toLowerCase(), traducao.toLowerCase());
        }
    }

    public String pegarPalavraIngles(String palavra){
        if(Ingles.containsKey(palavra.toLowerCase())){
            return Ingles.get(palavra.toLowerCase());
        }else{
            throw new PalavraNaoEncontradaException();
        }
    }

    public String pegarPalavraPortugues(String palavra){
        if(Portugues.containsKey(palavra.toLowerCase())){
            return Portugues.get(palavra.toLowerCase());
        }else{
            throw new PalavraNaoEncontradaException();
        }
    }

    public String traduzir(String palavra, TipoDicionario tipoDicionario){
        if (tipoDicionario.equals(TipoDicionario.INGLES)){
            return pegarPalavraIngles(palavra.toLowerCase());
        } else if (tipoDicionario.equals(TipoDicionario.PORTUGUES)) {
            return pegarPalavraPortugues(palavra.toLowerCase());
        }
        return "Não existe esse dicionário";
    }

    public void ImprimeMap(){
        System.out.println(Portugues);
    }

}
