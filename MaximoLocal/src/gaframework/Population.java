package gaframework;

import java.util.LinkedList;
import java.util.Collections;

/**
 *
 */
public class Population<G,P> {
    
    private LinkedList<Individual<G,P>> population;
    private boolean sorted;
    private int generation;
    
    /**
     *
     */
    Population(){
	this.generation = 0;
    }
    
    /**
     *
     * @param generation La generación de esta población.
     */
    public Population(int generation){
	this.generation = generation;
    }
    
    {
	this.population = new LinkedList<>();
	this.sorted = true;
    }
    
    /**
     *
     * @param individual El individuo que será agregado a la población.
     */
    public void addIndividual(Individual<G,P> individual){
	population.add(individual);
	sorted = false;
    }
    
    /**
     *
     * @param index El índice del individuo a solicitar.
     * @return El individuo en la posición index.
     */
    public Individual<G,P> getIndividual(int index){
	if (!sorted)
	    sortPopulation();
	return population.get(index);
    }
    
    /**
     *
     * @return El mejor individuo de la población.
     */
    public Individual<G,P> getBestIndividual(){
	if (!sorted)
	    sortPopulation();
	return population.getFirst();
    }
    
    /**
     *
     * @return El peor individuo de la población.
     */
    public Individual<G,P> getWorstIndividual(){
	if (!sorted)
	   sortPopulation();
	return population.getLast();
    }
    
    /**
     *
     * @return Un arreglo con los grados de adaptación
     * de los individuos de la población.
     */
    public double[] getFitnessArray(){
	if (!sorted)
	   sortPopulation();
	double[] a = new double[this.size()];
	for (int i = 0; i < this.size(); i++)
	    a[i] = population.get(i).getFitness();
	return a;	    
    }
    
    /**
     *
     * @return La generación de esta población.
     */
    public int getGeneration(){
	return generation;
    }
    
    /**
     *
     * @return El tamaño de la población.
     */
    public int size(){
	return population.size();
    }
    
    /**
     *
     */
    private void sortPopulation(){
	population.sort(null);
	LinkedList<Individual<G,P>> l = new LinkedList<>();
	for (Individual<G,P> ind:population)
	    l.addFirst(ind);
	population = l;
	sorted = true;
    }
}
