package oop.implementation;

public class Run {
    public static void main(String[] args) {
        Pet pet = new Pet();
        // Лямбда выражежния
        pet.setSound(() -> System.out.println("Hello"));

        Pet pet1 = new Pet();
        pet1.setSound(new MakeSound() {
            @Override
            public void makeSound() {
                System.out.println("Привет");
            }
        });

        pet.doAnyThing();
        pet1.doAnyThing();

    }
}
