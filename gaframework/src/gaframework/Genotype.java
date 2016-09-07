package gaframework;

/**
 *
 */
public class Genotype<G> {

    private final G[] genotype;

    /**
     *
     * @param size El tamaño del genotipo.
     */
    @SuppressWarnings("unchecked")
    public Genotype(int size) {
	genotype = (G[]) new Object[size];
    }

    /**
     *
     * @param index El índice del gen a solicitar.
     * @return El gen de la posición index.
     */
    public G getGene(int index) {
	return genotype[index];
    }

    /**
     *
     * @param index  El inídice de la posición a cambiar.
     * @param gene El valor del gen a cambiar.
     */
    public void setGene(int index, G gene) {
	genotype[index] = gene;
    }

    /**
     *
     * @return El tamaño del genotipo.
     */
    public int size() {
	return genotype.length;
    }

    /**
     *
     * @param obj El objeto con el que se desea comparar este genotipo.
     * @return true si obj es igual a este genotipo, false en otro caso.
     */
    @Override
    public boolean equals(Object obj) {
	if (obj == this)
	    return true;
	if (obj instanceof Genotype<?>) {
	    Genotype<?> another = (Genotype<?>) obj;
	    int i = 0;
	    if (this.size() == another.size()) {
		while (i < this.size()
		       && this.getGene(i).equals(another.getGene(i)))
		    i++;
		if (i == this.size())
		    return true;	
	    }
	}
	return false;
    }
    
    /**
     * 
     * @return El hashcode de este genotipo.
     */
    @Override
    public int hashCode(){
	return super.hashCode();
    }

    /**
     *
     * @return La cadena que representa a este genotipo.
     */
    @Override
    public String toString() {
	String out = "<";
	for (int i = 0; i < size() - 1; i++) {
	    out += genotype[i].toString() + ", ";
	}
	return out + genotype[size()-1] + ">";
    }
}
