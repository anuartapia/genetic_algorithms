/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operador.mutacion;

import gaframework.*;
import java.util.Random;

/**
 *
 * @author Anuar
 */
public class UniformMutation implements MutationOp<Boolean> {

    private final double prob;
    private final Random r;

    public UniformMutation(double prob, int seed) {
        this.prob = prob;
        this.r = new Random(seed);
    }

    @Override
    public Genotype<Boolean> mutate(Genotype<Boolean> genotype) {
        Genotype<Boolean> mutated = new Genotype<>(genotype.size());
        for (int i = 0; i < genotype.size(); i++) {
            if (r.nextDouble() < prob) {
                mutated.setGene(i, !genotype.getGene(i).booleanValue());
            } else {
                mutated.setGene(i, genotype.getGene(i).booleanValue());
            }
        }
        return mutated;
    }

}
