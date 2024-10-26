
import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso introdução ao Java");
        curso1.setDescricao("descrição do curso de Java");
        curso1.setCargaHoraria(4);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso classe em Java");
        curso2.setDescricao("descrição do curso de Classes");
        curso2.setCargaHoraria(6);

        Curso curso3 = new Curso();
        curso3.setTitulo("curso de POO");
        curso3.setDescricao("descrição do curso de POO");
        curso3.setCargaHoraria(10);

        Curso curso4 = new Curso();
        curso4.setTitulo("curso de SQL");
        curso4.setDescricao("descrição do curso de SQL");
        curso4.setCargaHoraria(6);

        Curso curso5 = new Curso();
        curso5.setTitulo("curso de Spring Boot");
        curso5.setDescricao("descrição do curso de Spring Boot");
        curso5.setCargaHoraria(16);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("mentoria de Java");
        mentoria1.setDescricao("descrição mentoria de Java");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("mentoria de SQL");
        mentoria2.setDescricao("descrição mentoria de SQL");
        mentoria2.setData(LocalDate.now());

        Mentoria mentoria3 = new Mentoria();
        mentoria3.setTitulo("mentoria de Spring Boot");
        mentoria3.setDescricao("descrição mentoria de Spring Boot");
        mentoria3.setData(LocalDate.now());

        Bootcamp javaSpring = new Bootcamp();
        javaSpring.setNome("Bootcamp Java Spring");
        javaSpring.setDescricao("Descrição Bootcamp de Java e Spring Boot");
        javaSpring.setConteudos(curso1); // 40xp
        javaSpring.setConteudos(curso2); // 60xp
        javaSpring.setConteudos(curso3); // 100xp
        javaSpring.setConteudos(curso4); // 60xp
        javaSpring.setConteudos(curso5); // 160xp
        javaSpring.setConteudos(mentoria1); // 30xp
        javaSpring.setConteudos(mentoria2); // 30xp
        javaSpring.setConteudos(mentoria3); // 30xp

        Dev devEduardo = new Dev();
        devEduardo.setNome("Eduardo");
        devEduardo.inscreverBootcamp(javaSpring);
        System.out.println("Conteúdos Inscritos Eduardo:" + devEduardo.getConteudosInscritos());
        devEduardo.progredir(javaSpring);
        devEduardo.progredir(javaSpring);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Eduardo:" + devEduardo.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Eduardo:" + devEduardo.getConteudosConcluidos());
        System.out.println("XP:" + devEduardo.calcularTotalXp());

        System.out.println("-------");

        Dev devFulano = new Dev();
        devFulano.setNome("Fulano");
        devFulano.inscreverBootcamp(javaSpring);
        System.out.println("Conteúdos Inscritos Fulano:" + devFulano.getConteudosInscritos());
        devFulano.progredir(javaSpring);
        devFulano.progredir(javaSpring);
        devFulano.progredir(javaSpring);
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Fulano:" + devFulano.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Fulano:" + devFulano.getConteudosConcluidos());
        System.out.println("XP:" + devFulano.calcularTotalXp());

    }

}
