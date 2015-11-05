package Jogo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Persistencia {

    public void gravaPlayer(Jogo j) {
        int dificuldade = j.getDificuldade().getNumBtns();
        Player jogador = j.getPlayer();
        File file = new File("ranking.txt");

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(jogador.getNome() + ";" + jogador.getScore().getPontos() + ";" + jogador.getScore().getTempo() + ";" + jogador.getScore().getNumTentativas() + ";" + jogador.getScore().getAcertoConsecutivo() + ";" + dificuldade);
            writer.write("\n");
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<ArrayList<Jogo>> lista() {
        ArrayList<ArrayList<Jogo>> retorno = new ArrayList<>();
        String arquivo[];
        ArrayList<Jogo> jogo12 = new ArrayList<>();
        ArrayList<Jogo> jogo24 = new ArrayList<>();
        ArrayList<Jogo> jogo36 = new ArrayList<>();

        try {
            FileReader file = new FileReader("ranking.txt");
            BufferedReader fi = new BufferedReader(file);
            String linha = fi.readLine();
            while (linha != null) {
                Player novo = new Player();
                Score s = new Score();
                Jogo j = new Jogo();
                arquivo = linha.split(";");
                novo.setNome(arquivo[0]);
                s.setPontos(Float.parseFloat(arquivo[1]));
                s.setTempo(Integer.parseInt(arquivo[2]));
                s.setNumTentativas(Integer.parseInt(arquivo[3]));
                s.setAcertoConsecutivo(Integer.parseInt(arquivo[4]));
                novo.setScore(s);
                j.setPlayer(novo);
                j.setDif(Integer.parseInt(arquivo[5]));
                if (j.getDif() == 12) {
                    jogo12.add(j);

                } else if (j.getDif() == 24) {
                    jogo24.add(j);

                } else if (j.getDif() == 36) {
                    jogo36.add(j);

                }

                linha = fi.readLine();

            }
            fi.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        retorno.add(jogo12);
        retorno.add(jogo24);
        retorno.add(jogo36);

        return retorno;

    }

}
