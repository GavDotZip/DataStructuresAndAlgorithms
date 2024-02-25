package geneticAlgorithm;

public class GeneticAlgorithm {
    static double totalGenerations = 0;
    static double averageGenerations = 0;
    static double experimentCount = 0;

    public static void main(String[] args) {
        while (Algorithm.mutationRate < 0.15) {
            while (experimentCount < 10) { // Number of iterations
                FitnessCalculator.setSolution("1111000000000000000000000000000000000000000000000000000000001111");

                // Create an initial population
                Population myPop = new Population(50, true);

                // Evolve the population until reaching an optimum solution
                int generationCount = 0; // Start generation at 0

                while (myPop.getFittest().getFitness() < FitnessCalculator.getMaxFitness()) {
                    generationCount++;
                    System.out.println("Generation: " + generationCount + ", \t" + "Fittest Individual: " + myPop.getFittest().getFitness());
                    myPop = Algorithm.evolvePopulation(myPop);
                }

                totalGenerations += generationCount;
                System.out.println("Solution found!");
                System.out.println("Generation: " + generationCount);
                System.out.println("Genes:");
                System.out.println(myPop.getFittest());

                experimentCount++;
            }

            averageGenerations = totalGenerations / experimentCount;
            System.out.println("Average: " + averageGenerations + " with a Mutation Rate of: " + Algorithm.mutationRate);
            Algorithm.mutationRate += 0.015;
            experimentCount = 0;
            totalGenerations = 0;
            averageGenerations = 0;
        }
    }
}
