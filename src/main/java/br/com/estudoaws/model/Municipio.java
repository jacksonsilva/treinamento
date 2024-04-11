package br.com.estudoaws.model;

public class Municipio {

    private Long id;
    private String nome;
    private MicroRegiao microRegiao;
    private RegiaoImediata regiaoImediata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MicroRegiao getMicroRegiao() {
        return microRegiao;
    }

    public void setMicroRegiao(MicroRegiao microRegiao) {
        this.microRegiao = microRegiao;
    }

    public RegiaoImediata getRegiaoImediata() {
        return regiaoImediata;
    }

    public void setRegiaoImediata(RegiaoImediata regiaoImediata) {
        this.regiaoImediata = regiaoImediata;
    }
}
