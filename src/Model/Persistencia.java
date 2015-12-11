package Model;

import Control.Player;
import Control.Score;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {

    PlayerDao playerDao;
    ScoreDao scoreDao;

    public void gravaPlayerScore(Player player, Score score) {

        playerDao = new PlayerDao();
        scoreDao = new ScoreDao();

        if (player.getNamePlayer()== playerDao.verificaPlayerExists(player.getNamePlayer())) {
            playerDao.atualizar(player);
        } else {
                long id=scoreDao.contaScore();
                int nova = (int)id;
                nova++;
                
                score.setIdScore(nova);
                scoreDao.inserir(score);
                player.setIdScore(score);
            playerDao.inserir(player);
        }
    }
    
    
    public List<Score> leScore(){
        scoreDao = new ScoreDao();
        
        List<Score> listScore = new ArrayList<>();
        listScore = scoreDao.list();
        
        return listScore;
    }
   
//    //Método utilizado para gravar em um txt
//    public void gravaPlayer(Jogo j) {
//        int dificuldade = j.getDificuldade().getNumBtns();
//        Player jogador = j.getPlayer();
//        File file = new File("ranking.txt");
//
//        try {
//            FileWriter writer = new FileWriter(file, true);
//            //Escreve no arquivo nome do player e suas pontuações
//            writer.write(jogador.getNome() + ";" + jogador.getScore().getPontos() + ";" + jogador.getScore().getTempo() + ";" + jogador.getScore().getNumTentativas() + ";" + jogador.getScore().getAcertoConsecutivo() + ";" + dificuldade);
//            writer.write("\n");
//            writer.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    //Método que lista todos os players de acordo com a dificuldade escolhida
//    //Utilizado para fazer o rank de cada dificuldade(O metodo lista retorna desordenado)
//
//    public ArrayList<ArrayList<Jogo>> lista() {
//        ArrayList<ArrayList<Jogo>> retorno = new ArrayList<>();
//        String arquivo[];
//        //Cria uma arrayList para cada Dificuldade
//        ArrayList<Jogo> jogo12 = new ArrayList<>();
//        ArrayList<Jogo> jogo24 = new ArrayList<>();
//        ArrayList<Jogo> jogo36 = new ArrayList<>();
//
//        try {
//            FileReader file = new FileReader("ranking.txt");
//            BufferedReader fi = new BufferedReader(file);
//            String linha = fi.readLine();
//            while (linha != null) {
//                Player novo = new Player();
//                Score s = new Score();
//                Jogo j = new Jogo();
//                //Quebra o arquivo em ';' para separar os dados dos players
//                arquivo = linha.split(";");
//                novo.setNome(arquivo[0]);
//                s.setPontos(Float.parseFloat(arquivo[1]));
//                s.setTempo(Integer.parseInt(arquivo[2]));
//                s.setNumTentativas(Integer.parseInt(arquivo[3]));
//                s.setAcertoConsecutivo(Integer.parseInt(arquivo[4]));
//                novo.setScore(s);
//                j.setPlayer(novo);
//                
//                j.setDif(Integer.parseInt(arquivo[5]));
//                /*Adciona os jogadores nos vetores de acordo 
//                 com a dificuldade que foi escolhida*/
//                if (j.getDif() == 12) {
//                    jogo12.add(j);
//
//                } else if (j.getDif() == 24) {
//                    jogo24.add(j);
//
//                } else if (j.getDif() == 36) {
//                    jogo36.add(j);
//
//                }
//
//                linha = fi.readLine();
//
//            }
//            fi.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        /*Concatena todos os niveis de 
//         dificuldades em uma ArrayList*/
//
//        retorno.add(jogo12);
//        retorno.add(jogo24);
//        retorno.add(jogo36);
//
//        return retorno;
//
//    }
}
