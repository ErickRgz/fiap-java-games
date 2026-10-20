package br.com.fiap.games;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.model.Game;
import br.com.fiap.games.utils.Conexao;
import jakarta.persistence.EntityManager;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Game game1 = new Game();
        game1.setTitulo("Batletoads");
        game1.setCategoria("Luta");
        game1.setDataLancamento(LocalDate.of(1991, 6, 1));
        game1.setProdutora("Tradewest, Rare");
        game1.setValor(99.89);
        game1.setFinalizado(true);

        EntityManager em = Conexao.getEntityManager();
        GameDao gameDao = new GameDao(em);
        em.getTransaction().begin();
        gameDao.salvar(game1);
        //gameDao.atualizar(game1);
        //gameDao.remover(game1);
        em.getTransaction().commit();
        em.close();
        Conexao.EMF.close();

    }
}
