package hm4;

import java.util.Arrays;
import java.util.Objects;

public class hm4 {
    public class Pet {
        private String species;
        private String nickname;
        private int age;
        private int trickLevel;
        private String[] habits;

        public Pet() {
        }

        public Pet(String species, String nickname) {
            this.species = species;
            this.nickname = nickname;
        }

        public Pet(String species, String nickname, int age, int trickLevel, String[] habits) {
            this.species = species;
            this.nickname = nickname;
            this.age = age;
            this.trickLevel = trickLevel;
            this.habits = habits;
        }

        public void eat() {
            System.out.println("Я їм!");
        }

        public void respond() {
            System.out.println("Привіт, хазяїн. Я - " + nickname + ". Я скучив!");
        }

        public void foul() {
            System.out.println("Потрібно добре замести сліди...");
        }

        @Override
        public String toString() {
            return species + "{nickname='" + nickname + "', age=" + age + ", trickLevel=" + trickLevel + ", habits=" + Arrays.toString(habits) + "}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pet)) return false;
            Pet pet = (Pet) o;
            return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Arrays.equals(habits, pet.habits);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(species, nickname, age, trickLevel);
            result = 31 * result + Arrays.hashCode(habits);
            return result;
        }


        public String getSpecies() {
            return species;
        }

        public void setSpecies(String species) {
            this.species = species;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getTrickLevel() {
            return trickLevel;
        }

        public void setTrickLevel(int trickLevel) {
            this.trickLevel = trickLevel;
        }

        public String[] getHabits() {
            return habits;
        }

        public void setHabits(String[] habits) {
            this.habits = habits;
        }
    }

    public class Human {
        private String name;
        private String surname;
        private int year;
        private int iq;
        private String[][] schedule;
        private Family family; // Reference to the family
        private Pet pet;
        // Constructor with all fields
        public Human(String name, String surname, int year, int iq, String[][] schedule) {
            this.name = name;
            this.surname = surname;
            this.year = year;
            this.iq = iq;
            this.schedule = schedule;
        }

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getIq() {
            return iq;
        }

        public void setIq(int iq) {
            this.iq = iq;
        }

        public String[][] getSchedule() {
            return schedule;
        }

        public void setSchedule(String[][] schedule) {
            this.schedule = schedule;
        }

        public Family getFamily() {
            return family;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }
        public String getNickname() {
            return pet.getNickname();
        }
        public void setFamily(Family family) {
            this.family = family;
        }

        // Greet pet method
        public void greetPet() {
            if (family != null && family.getPet() != null) {
                System.out.println("Привіт, " + family.getPet().getNickname());
            } else {
                System.out.println("У мене немає улюбленця.");
            }
        }

        // Describe pet method
        public void describePet() {
            if (family != null && family.getPet() != null) {
                Pet pet = family.getPet();
                String cleverness = pet.getTrickLevel() > 50 ? "дуже хитрий" : "майже не хитрий";
                System.out.println("У мене є " + pet.getSpecies() + ", їй " + pet.getAge() +
                        " років, він " + cleverness + ".");
            } else {
                System.out.println("У мене немає улюбленця.");
            }
        }

        // toString method
        @Override
        public String toString() {
            return "Human{name='" + name + "', surname='" + surname + "', year=" + year +
                    ", iq=" + iq + ", schedule=" + Arrays.deepToString(schedule) + "}";
        }

        // equals and hashCode methods
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Human)) return false;
            Human human = (Human) o;
            return year == human.year &&
                    iq == human.iq &&
                    Objects.equals(name, human.name) &&
                    Objects.equals(surname, human.surname) &&
                    Arrays.deepEquals(schedule, human.schedule);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(name, surname, year, iq);
            result = 31 * result + Arrays.deepHashCode(schedule);
            return result;
        }
    }

    public class Family {
        private Human mother;
        private Human father;
        private Human[] children;
        private Pet pet;


        public Family(Human mother, Human father) {
            this.mother = mother;
            this.father = father;
            this.mother.setFamily(this);
            this.father.setFamily(this);
        }

        // Getters and setters
        public Human getMother() {
            return mother;
        }

        public void setMother(Human mother) {
            this.mother = mother;
        }

        public Human getFather() {
            return father;
        }

        public void setFather(Human father) {
            this.father = father;
        }

        public Human[] getChildren() {
            return children;
        }

        public void setChildren(Human[] children) {
            this.children = children;
        }

        public Pet getPet() {
            return pet;
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }

        // Override toString to display all family information
        @Override
        public String toString() {
            StringBuilder familyInfo = new StringBuilder();
            familyInfo.append("Family:\n");
            familyInfo.append("Mother: ").append(mother).append("\n");
            familyInfo.append("Father: ").append(father).append("\n");
            familyInfo.append("Children: ");
            if (children.length == 0) {
                familyInfo.append("No children\n");
            } else {
                for (Human child : children) {
                    familyInfo.append(child).append("\n");
                }
            }
            familyInfo.append("Pet: ").append(pet != null ? pet : "No pet");
            return familyInfo.toString();
        }
    }

    public static void main(String[] args) {
        // Creating pets
        hm4.Pet pet1 = new hm4().new Pet("Dog", "Buddy", 3, 70, new String[]{"playing", "barking"});

        // Creating humans using different constructors
        hm4.Human mother = new hm4().new Human("Anna", "Smith", 1985, 120, new String[][]{{"Monday", "Work"}});
        hm4.Human father = new hm4().new Human("John", "Smith", 1980, 110, new String[][]{{"Tuesday", "Gym"}});
        hm4.Human child = new hm4().new Human("Emily", "Smith", 2010, 100, new String[][]{{"Wednesday", "School"}});

        // Creating families
        hm4.Family family1 = new hm4().new Family(mother, father);
        hm4.Human[] children = {child};
        family1.setChildren(children);
        family1.setPet(pet1);
        child.setFamily(family1);

        child.setPet(pet1);

        // Displaying information about each person
        System.out.println("Mother: " + mother);
        System.out.println("Father: " + father);
        System.out.println("Child: " + child);

        // Displaying family information
        System.out.println("Family: " + family1);

        // Calling methods for the child
        child.greetPet();
        child.describePet();


        // Calling methods for the pet
        pet1.eat();
        pet1.respond();
        pet1.foul();
    }
}
