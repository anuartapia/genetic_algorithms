/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operador.cruza;

import gaframework.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Anuar
 */
public class OnePointCrossover<G> implements CrossoverOp<G> {

    private final double prob;
    private final Random r;

    public OnePointCrossover(double prob, int seed) {
        this.prob = prob;
        this.r = new Random(seed);
    }

    @Override
    public List<Genotype<G>> crossover(List<Genotype<G>> parents) {
        List<Genotype<G>> children = new ArrayList<>();
        Genotype<G> p1 = parents.get(0);
        Genotype<G> p2 = parents.get(1);
        Genotype<G> c1 = new Genotype<>(p1.size());
        Genotype<G> c2 = new Genotype<>(p1.size());
        if (r.nextDouble() < prob) {
            int crossPoint = r.nextInt(p1.size());
            for (int i = 0; i < crossPoint; i++) {
                c1.setGene(i, p1.getGene(i));
                c2.setGene(i, p2.getGene(i));
            }
            for (int i = crossPoint; i < p1.size(); i++) {
                c1.setGene(i, p2.getGene(i));
                c2.setGene(i, p1.getGene(i));
            }
        }
        children.add(c1);
        children.add(c2);
        return children;
    }
}
