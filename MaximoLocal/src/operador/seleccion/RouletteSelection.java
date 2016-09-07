/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operador.seleccion;

import gaframework.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Anuar
 * @param <G>
 * @param <P>
 */
public class RouletteSelection<G, P> implements SelectionOp<G, P> {

    private final Random r;
    private final int numInd;

    public RouletteSelection(int seed, int numInd) {
        this.r = new Random(seed);
        this.numInd = numInd;
    }

    @Override
    public List<Individual<G, P>> select(Population<G, P> p) {
        List<Individual<G, P>> selected = new ArrayList<>();
        double[] rango = new double[p.size()];
        rango[0] = p.getIndividual(0).getFitness();
        for (int i = 1; i < p.size(); i++) {
            rango[i] = rango[i - 1] + p.getIndividual(i).getFitness();
        }
        for (int i = 0; i < numInd; i++) {
            double pestana = r.nextDouble() * rango[rango.length - 1];
            int j = 0;
            while(pestana >= rango[j]){
                j++;
            }
            selected.add(p.getIndividual(j));
        }
        return selected;
    }
}
