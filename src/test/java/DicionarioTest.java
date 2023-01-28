import org.junit.Assert;
import org.junit.Test;

public class DicionarioTest {
    @Test
    public void deveTraduzirCarroELivroDoInglesParaPortuguesEDoPortuguesParaOIngles(){
        Dicionario dicionario = new Dicionario();
        dicionario.adicionarPalavra("Carro", "Car", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Car", "Carro", TipoDicionario.PORTUGUES);
        dicionario.adicionarPalavra("Livro", "Book", TipoDicionario.INGLES);
        dicionario.adicionarPalavra("Book", "LIvRo", TipoDicionario.PORTUGUES);

        dicionario.ImprimeMap();

        Assert.assertEquals("car", dicionario.traduzir("Carro", TipoDicionario.INGLES));
        Assert.assertEquals("carro", dicionario.traduzir("car", TipoDicionario.PORTUGUES));
        Assert.assertEquals("livro", dicionario.traduzir("book", TipoDicionario.PORTUGUES));
        Assert.assertEquals("book", dicionario.traduzir("livro", TipoDicionario.INGLES));
    }

    @Test(expected = PalavraNaoEncontradaException.class)
    public void deveLancarExceptionQuandoUmaPalavraNaoForEncontrada(){
        Dicionario dicionario = new Dicionario();
        dicionario.traduzir("Porta", TipoDicionario.INGLES);
    }

}
