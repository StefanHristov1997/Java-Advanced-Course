package PokemonTrainer_06;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        LinkedHashMap<String, List<Pokemon>> trainers = new LinkedHashMap<>();

        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);


            trainers.putIfAbsent(trainerName, new ArrayList<>());
            trainers.get(trainerName).add(pokemon);

            command = scanner.nextLine();
        }

        List<Trainer> trainerList = trainers.entrySet().stream().map(trainer -> new Trainer(trainer.getKey(), trainer.getValue())).collect(Collectors.toList());

        command = scanner.nextLine();

        while (!command.equals("End")) {

            for (Trainer trainer : trainerList) {
               trainer.executing(command);
            }
            command = scanner.nextLine();
        }

        trainerList.stream().sorted(Comparator.comparingInt(Trainer::getBadges).reversed()).forEach(System.out::println);
    }
}
