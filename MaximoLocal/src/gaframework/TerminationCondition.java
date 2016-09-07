package gaframework;

public interface TerminationCondition<G,P>{

    /**
     *
     * @param p La población con la cual se determinará si
     * se ha alcanzado la condición de terminación.
     * @return true si se alcanzó la condición de terminación, 
     * false en caso contrario
     */
    public boolean conditionReached(Population<G,P> p);
    
}

