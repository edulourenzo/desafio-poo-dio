package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        LocalDate agora = LocalDate.now();
        if ((agora.isEqual(bootcamp.getDataInicial())
                || agora.isAfter(bootcamp.getDataInicial()))
                && (agora.isEqual(bootcamp.getDataFinal())
                || agora.isBefore(bootcamp.getDataFinal()))) {
            this.conteudosInscritos.addAll(bootcamp.getConteudos());
            bootcamp.getDevsInscritos().add(this);
        } else {
            System.out.println("A data atual está fora do período do Bootcamp.");
        }
    }

    public void progredir(Bootcamp bootcamp) {
        LocalDate agora = LocalDate.now();
        if (agora.isEqual(bootcamp.getDataFinal()) || agora.isBefore(bootcamp.getDataFinal())) {
            Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
            if (conteudo.isPresent()) {
                this.conteudosConcluidos.add(conteudo.get());
                this.conteudosInscritos.remove(conteudo.get());
            } else {
                System.out.println("Não ha nenhum conteudo matriculado.");
            }
        } else {
            System.out.println("O Bootcamp já se encerrou.");
        }
    }

    public double calcularTotalXp() {
        return this.conteudosConcluidos.stream()
                .map(Conteudo::calcularXp)
                .reduce(0.0d, (subtotal, xp) -> subtotal + xp);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
