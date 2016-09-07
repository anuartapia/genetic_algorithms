package gaframework;

import java.util.List;

/**
 *
 */
public interface CrossoverOp<G> {

    /**
     *
     * @param parents Los padres con los que se realizará la cruza.
     * @return Una lista de nuevos genotipos resultantes de la cruza.
     */
    public List<Genotype<G>> crossover(List<Genotype<G>> parents);

}
