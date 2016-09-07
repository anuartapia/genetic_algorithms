package gaframework;

/**
 *
 */
public interface FitnessFunction<P> {

    /**
     *
     * @param p El fenotipo a evaluar.
     * @return El grado de adaptación del fenotipo.
     */
    public double evaluate(Phenotype<P> p);
    
}
