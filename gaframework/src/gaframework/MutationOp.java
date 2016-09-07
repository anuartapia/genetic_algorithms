package gaframework;

/**
 *
 */
public interface MutationOp<G>{

    /**
     *
     * @param g El genotipo a mutar.
     * @return Un nuevo genotipo resultante de mutar el genotipo g.
     */
    public Genotype<G> mutate(Genotype<G> g);

}
