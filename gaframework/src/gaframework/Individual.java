package gaframework;

/**
 *
 */
public final class Individual<G,P> implements Comparable<Individual<G,P>>{
    
    private final Genotype<G> genotype;
    private final Phenotype<P> phenotype;
    private final double fitness;

    /**
     *
     * @param genotype El genotipo del individuo.
     * @param phenotype El fenotipo del individuo.
     * @param fitness El grado de adaptación del individuo.
     */
    Individual(Genotype<G> genotype, Phenotype<P> phenotype, double fitness){
	this.genotype = genotype;
	this.phenotype = phenotype;
	this.fitness = fitness;
    }
    
    /**
     *
     * @return El fenotipo de este individuo.
     */
    public Phenotype<P> getPhenotype(){
	return phenotype;
    }

    /**
     *
     * @return El genotipo de este individuo.
     */
    public Genotype<G> getGenotype(){
	return genotype;
    }
    
    /**
     *
     * @return El grado de adaptación de este individuo.
     */
    public double getFitness(){
	return fitness;
    }
    
    /**
     *
     * @param obj El objeto con el que se va a comparar este individuo.
     * @return true si obj es igual a este individuo.
     */
    @Override
    public boolean equals(Object obj){
	if (obj == this)
	    return true;
	if (obj instanceof Individual) {
	    Individual<?,?> another = (Individual<?,?>) obj;
	    if(genotype.size() == another.genotype.size()){
		return genotype.equals(another.genotype);
	    }
	}
	return false;
    }

    /**
     *
     * @return La cadena que representa a este individuo.
     */
    @Override
    public String toString(){
	return "Genotype: " + genotype.toString() + "\n"
	    + "Phenotype: " + phenotype.toString() +  "\n"
	    + "Fitness: " + fitness;	
    }

    /**
     *
     * @return El hashcode de este individuo.
     */
    @Override
    public int hashCode(){
	return super.hashCode();
    }
    
    /**
     *
     * @param individual El individuo con el que se comparará el individuo.
     * @return -1, 0 ó 1 si el grado de adaptación de este individuo es 
     * menor, igual o mayor al de individual.
     */
    @Override
    public int compareTo(Individual<G,P> individual){
	if(this.fitness == individual.fitness)
	    return 0;
	return (this.fitness < individual.fitness) ? -1 : 1;
    }

}
