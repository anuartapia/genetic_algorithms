package gaframework;

/**
 *
 */
public interface Codification<G,P> {
    
    /**
     *
     * @param phenotype El fenotipo a codificiar.
     * @return El genotipo correspondiente al fenotipo.
     */
    public Genotype<G> encode(Phenotype<P> phenotype);

    /**
     *
     * @param genotype El genotipo a decodificar.
     * @return El fenotipo correspondiente al genotipo.
     */
    public Phenotype<P> decode(Genotype<G> genotype);

    /**
     *
     * @return Un genotipo aleatorio.
     */
    public Genotype<G> newRandomGenotype();

}
