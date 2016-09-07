package gaframework;

/**
 *
 */
public class Phenotype<P> {

    private final P[] phenotype;

    /**
     *
     * @param size El tamaño del fenotipo.
     */
    @SuppressWarnings("unchecked")
    public Phenotype(int size){
	phenotype = (P[]) new Object[size];
    }

    /**
     *
     * @param index El índice del alelo a solicitar.
     * @return El alelo en la posición index.
     */
    public P getAllele(int index) {
	return phenotype[index];
    }

    /**
     *
     * @param index El índice del alelo a cambiar.
     * @param allele El valor del alelo a cambiar..
     */
    public void setAllele(int index, P allele) {
	phenotype[index] = allele;
    }

    /**
     *
     * @return Tamaño del fenotipo.
     */
    public int size() {
	return phenotype.length;
    }

    /**
     *
     * @param obj El objeto con el que se comparará este fenotipo.
     * @return true si obj es igual a este fenotipo, false en otro caso.
     */
    @Override
    public boolean equals(Object obj) {
	if (obj == this)
	    return true;
	if (obj instanceof Phenotype<?>) {
	    Phenotype<?> another = (Phenotype<?>) obj;
	    int i = 0;
	    if (this.size() == another.size()) {
		while (i < this.size()
		       && this.getAllele(i).equals(another.getAllele(i)))
		    i++;
		if (i == this.size())
		    return true;	
	    }
	}
	return false;
    }

    /**
     *
     * @return El hashcode de este fenotipo.
     */
    @Override
    public int hashCode(){
	return super.hashCode();
    }
    
    /**
     *
     * @return La cadena que representa a este fenotipo.
     */
    @Override
    public String toString() {
	String out = "<";
	for (int i = 0; i < size() - 1; i++) {
	    out += phenotype[i].toString() + ", ";
	}
	return out + phenotype[size()-1] + ">";
    }
}
