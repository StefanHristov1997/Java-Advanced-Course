package Google_07;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Company company;

    private Car car;
    private List<Pokemon> pokemons;

    private List<Parent> parents;

    private List<Child> children;


    public Person() {
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }


    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company:").append("\n");

        if (company != null) {
            sb.append(company).append("\n");
        }

        sb.append("Car:").append("\n");

        if (car != null) {
            sb.append(car).append("\n");
        }

        sb.append("Pokemon:").append("\n");

        if (!pokemons.isEmpty()) {
            for (Pokemon pokemon : pokemons) {
                sb.append(pokemon.toString().replaceAll("[\\[\\],]", "")).append("\n");
            }
        }

        sb.append("Parents:").append("\n");

        if (!parents.isEmpty()) {
            for (Parent parent : parents) {
                sb.append(parent.toString().replaceAll("[\\[\\],]", "")).append("\n");
            }
        }
        sb.append("Children:").append("\n");

        if (!children.isEmpty()) {
            for (Child child : children) {
                sb.append(child.toString().replaceAll("[\\[\\],]", "")).append("\n");
            }
        }

        return sb.toString();
    }
}
