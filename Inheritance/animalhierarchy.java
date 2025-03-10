package Inheritance;

class Animal {
    String name;
    int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("Some generic animal sound.");
    }

    // Display details of the animal
    public void displayDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass: Dog
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Subclass: Cat
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

// Subclass: Bird
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp! Chirp!");
    }
}


public class animalhierarchy {
    public static void main(String[] args) {
        // Create instances of each subclass
        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        // Demonstrate polymorphism
        dog.displayDetails();
        dog.makeSound();

        cat.displayDetails();
        cat.makeSound();

        bird.displayDetails();
        bird.makeSound();
    }
}
