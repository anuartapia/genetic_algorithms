package gaframework;

import java.util.List;

/**
 *
 */
public interface SelectionOp<G,P>{

    /**
     *
     * @param p La población de la cual se seleccionarán los individuos.
     * @return Una lista de los individuos seleccionados de la población.
     */
    public List<Individual<G,P>> select(Population<G,P> p);

}
