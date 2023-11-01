package produtos.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entidades.Produto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorioJPA extends JpaRepository<Produto, Integer> {

    List<Produto> findAll();

    @Query("SELECT p FROM Produto p WHERE p.id = :id AND p.preco <= :preco")
    Optional<Produto> findProdutoParam(Integer id, Double preco);

    @Query(value="SELECT p.* FROM tb_produto p "
            + "WHERE p.id = :id "
            + "AND p.preco <= :preco", nativeQuery = true)
    Optional<Produto> findProdutoParamSql(Integer id, Double preco);

}