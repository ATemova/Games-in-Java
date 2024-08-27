import java.util.*;

public class GeneticAlgorithm {
    private static final int POP_SIZE = 10;
    private static final int GEN_SIZE = 10;
    private static final double MUTATION_RATE = 0.01;
    private static final int MAX_GENERATIONS = 100;

    public static void main(String[] args) {
        List<Individual> population = initializePopulation();
        for (int generation = 0; generation < MAX_GENERATIONS; generation++) {
            Collections.sort(population);
            if (population.get(0).fitness() == GEN_SIZE) {
                System.out.println("Solution found in generation " + generation);
                System.out.println(population.get(0));
                return;
            }
            List<Individual> newPopulation = new ArrayList<>();
            for (int i = 0; i < POP_SIZE; i++) {
                Individual parent1 = select(population);
                Individual parent2 = select(population);
                Individual child = crossover(parent1, parent2);
                mutate(child);
                newPopulation.add(child);
            }
            population = newPopulation;
        }
        System.out.println("No solution found.");
    }

    private static List<Individual> initializePopulation() {
        List<Individual> population = new ArrayList<>();
        for (int i = 0; i < POP_SIZE; i++) {
            population.add(new Individual());
        }
        return population;
    }

    private static Individual select(List<Individual> population) {
        return population.get(new Random().nextInt(POP_SIZE));
    }

    private static Individual crossover(Individual parent1, Individual parent2) {
        Individual child = new Individual();
        for (int i = 0; i < GEN_SIZE; i++) {
            child.genes[i] = (new Random().nextBoolean()) ? parent1.genes[i] : parent2.genes[i];
        }
        return child;
    }

    private static void mutate(Individual individual) {
        for (int i = 0; i < GEN_SIZE; i++) {
            if (new Random().nextDouble() < MUTATION_RATE) {
                individual.genes[i] = new Random().nextInt(2);
            }
        }
    }

    static class Individual implements Comparable<Individual> {
        int[] genes = new int[GEN_SIZE];

        Individual() {
            for (int i = 0; i < GEN_SIZE; i++) {
                genes[i] = new Random().nextInt(2);
            }
        }

        int fitness() {
            int fitness = 0;
            for (int gene : genes) {
                fitness += gene;
            }
            return fitness;
        }

        @Override
        public int compareTo(Individual other) {
            return Integer.compare(other.fitness(), this.fitness());
        }

        @Override
        public String toString() {
            return Arrays.toString(genes) + " Fitness: " + fitness();
        }
    }
}
