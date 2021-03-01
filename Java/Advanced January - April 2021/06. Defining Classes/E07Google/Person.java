package E07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String personName;

    private Company company;
    private Car car;
    private List<Pokemon> pokemonList;
    private List<Parents> parentsList;
    private List<Children> childrenList;


    public Person(String personName, Company company, Car car, List<Pokemon> pokemonList, List<Parents> parentsList, List<Children> childrenList) {
        this.personName = personName;
        this.company = company;
        this.car = car;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    public void addParent(Parents parent) {
        this.parentsList.add(parent);
    }

    public void addChild(Children child) {
        this.childrenList.add(child);
    }

    public void setCar(Car car) {
        this.car = car;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.personName);

        sb.append(System.lineSeparator());

        sb.append("Company:")
                .append(System.lineSeparator());
        if (this.company != null) {
            sb.append(String.format("%s %s %.2f",
                    this.company.getCompanyName(), this.company.getDepartment(), this.company.getSalary()))
                    .append(System.lineSeparator());
        }

        sb.append("Car:")
                .append(System.lineSeparator());
        if (this.car != null) {
            sb.append(String.format("%s %d", this.car.getCarModel(), this.car.getCarSpeed()))
                    .append(System.lineSeparator());
        }

        sb.append("Pokemon:")
                .append(System.lineSeparator());
        if (this.pokemonList != null) {
            StringBuilder sbListPokemon = new StringBuilder();

            for (Pokemon pokemon : pokemonList) {
                String pokemonLine = String.format("%s %s", pokemon.getPokemonName(), pokemon.getPokemonType());
                sbListPokemon.append(pokemonLine).append(System.lineSeparator());
            }
            sb.append(sbListPokemon.toString());
        }

        sb.append("Parents:")
                .append(System.lineSeparator());
        if (this.parentsList != null) {
            StringBuilder sbListParents = new StringBuilder();

            for (Parents parent : parentsList) {
                String parentLine = String.format("%s %s", parent.getParentName(), parent.getParentBirthday());
                sbListParents.append(parentLine).append(System.lineSeparator());
            }

            sb.append(sbListParents.toString());
        }

        sb.append("Children:")
                .append(System.lineSeparator());
        if (this.childrenList != null) {
            StringBuilder sbListChildren = new StringBuilder();

            for (Children child : childrenList) {
                String childLine = String.format("%s %s", child.getChildName(), child.getChildBirthday());
                sbListChildren.append(childLine).append(System.lineSeparator());
            }

            sb.append(sbListChildren.toString());
        }

        return sb.toString().trim();
    }
}
