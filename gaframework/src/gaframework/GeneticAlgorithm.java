package gaframework;

/**
 *
 */
public interface GeneticAlgorithm<G,P>{

    /**
     *
     * @param current La población actual.
     * @return La nueva población.
     */
    public Population<G,P> iteration(Population<G,P> current);
    
    /**
     *
     */
    public void run();
    
}
