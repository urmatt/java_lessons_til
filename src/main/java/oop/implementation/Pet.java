package oop.implementation;

public class Pet {
     String name;
     MakeSound sound;

    public String getName() {
        if (name == null)
            return "No name given";
        return name;
    }

    public void setName(String name) {
        if (name != null && name != "Tilya")
            this.name = name;
    }

    public void setSound(MakeSound sound) {
        this.sound = sound;
    }

    public void doAnyThing(){
        sound.makeSound();
    }
}
