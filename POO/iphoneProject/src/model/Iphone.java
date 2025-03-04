package model;

import model.interfaces.AparelhoTelefonico;
import model.interfaces.NavegadorDaInternet;
import model.interfaces.ReprodutorMusical;
import model.services.AparelhoTelefonicoImpl;
import model.services.NavegadorDaInternetImpl;
import model.services.ReprodutorMusicalImpl;

public class Iphone {
    private ReprodutorMusical reprodutorMusical;
    private AparelhoTelefonico telefone;
    private NavegadorDaInternet navegador;

    public Iphone(NavegadorDaInternetImpl navegador, AparelhoTelefonicoImpl telefone, ReprodutorMusicalImpl reprodutorMusical) {
        this.navegador = navegador;
        this.telefone = telefone;
        this.reprodutorMusical = reprodutorMusical;
    }
}
