package PokemonTrainer_06;

import java.util.List;

public class Trainer {

    private String trainerName;

    private List<Pokemon> pokemonList;

    private int badges;

    public Trainer(String trainerName, List<Pokemon> pokemonList) {
        this.trainerName = trainerName;
        this.pokemonList = pokemonList;
        this.badges = 0;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public void executing(String command) {

        if (isExist(command)) {
            badges += 1;
        } else {
            for (int i = 0; i < pokemonList.size(); i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);

                if (pokemonList.get(i).getHealth() <= 0) {
                    pokemonList.remove(i);
                    i--;
                }
            }
        }

    }

    private boolean isExist(String command) {

        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(command)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", getTrainerName(), getBadges(), getPokemonList().size());
    }
}





