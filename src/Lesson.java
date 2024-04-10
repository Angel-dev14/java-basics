import java.util.ArrayList;
import java.util.List;

class Person {

    private String name;
    private Integer age;

    Person(String name, Integer age) {
        // this.name = name;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Age: %s\n", this.name, this.age);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Person other = (Person) obj;
        if (this == other) {
            return true;
        }
        System.out.println(other.name);
        System.out.println(other.getName());
        return this.name.equals(other.name) && this.age.equals(other.age);
    }
}

enum AnimalType {
    DOG,
    CAT
}

class Animal {

    protected String name;
    private AnimalType tip;

    Animal(String name, AnimalType tip) {
        this.name = name;
        this.tip = tip;
    }

    public AnimalType getTip() {
        return tip;
    }
}

class Dog extends Animal {

    String rasa;

    Dog(String name, String rasa) {
        super(name, AnimalType.DOG);
        this.rasa = rasa;
    }

    public String getRasa() {
        return rasa;
    }

    @Override
    public String toString() {
        return this.getTip() + " " + this.name;
    }
}

class Cat extends Animal {

    String boja;

    Cat(String name, String boja) {
        super(name, AnimalType.CAT);
        this.boja = boja;
    }

    public String getBoja() {
        return boja;
    }

    @Override
    public String toString() {
        return this.getTip() + " " + this.name;
    }
}

// class G<E> implements List<E> {
//
// }

// [ Animal Garden - {NAME} ]
// [ House of animal - {name of animal} - TYPE
// [ House of animal - {name of animal} - TYPE
// [ House of animal - {name of animal} - TYPE
// [ House of animal - {name of animal} - TYPE

class AnimalGarden {

    List<Animal> animals;

    AnimalGarden() {
        this.animals = new ArrayList<Animal>();
    }

    void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    void removeAnimal(Animal animal) throws RuntimeException {
        if (this.animals.contains(animal)) {
            this.animals.remove(animal);
        }
        throw new RuntimeException("There is no animal with name " + animal.name);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < animals.size(); i++) {
            builder.append(animals.get(i).toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}

public class Lesson {

    public static void lesson(String[] args) {

        Animal dog1 = new Dog("pero", "vucjak");
        Animal dog2 = new Dog("pero", "vucjak");
        Animal dog3 = new Dog("pero", "vucjak");
        Animal cat = new Cat("pero", "bela");
        Animal[] animals = { dog1, dog2, dog3, cat };

        AnimalGarden garden = new AnimalGarden();
        garden.addAnimal(dog1);
        garden.addAnimal(dog2);
        garden.addAnimal(dog3);
        garden.addAnimal(cat);
        System.out.println(garden);
    }
}
