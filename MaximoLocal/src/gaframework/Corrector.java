package gaframework;

/**
 *
 */
public interface Corrector<G> {

    /**
     *
     * @param g El genotipo a reparar.
     * @return Un nuevo genotipo válido.
     */
    public Genotype<G> repairGenotype(Genotype<G> g);

}
