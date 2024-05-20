# AbstractFactory

## Description

Abstract Factory provides an interface for creating families of related or dependent objects without specifying their concrete classes. It separates the details of implementation of a set of objects from their general usage. This pattern is useful when the client doesn't know exactly what type to create. An abstract factory can create multiple types of objects which are related, without specifying the exact class.

## Java Code Example

```java
interface Dog
{
      void speak();
      void preferredAction();
}

interface Tiger
{
      void speak();
      void preferredAction();
}

//Types of Dogs-wild dogs and pet dogs
class WildDog implements Dog
{
      @Override
      public void speak()
      {
            System.out.println("Wild Dog says loudly: Bow-Wow.");
      }
      @Override
      public void preferredAction()
      {
             System.out.println("Wild Dogs prefer to roam freely in 
jungles.\n");
      }
}

class PetDog implements Dog
{
      @Override
      public void speak()
      {
             System.out.println("Pet Dog says softly: Bow-Wow.");
      }
      @Override
      public void preferredAction()
      {
            System.out.println("Pet Dogs prefer to stay at home.\n");
      }
}

//Types of Tigers-wild tigers and pet tigers
class WildTiger implements Tiger
{
      @Override
      public void speak()
      {
            System.out.println("Wild Tiger says loudly: Halum.");
      }
      @Override
      public void preferredAction()
      {
            System.out.println("Wild Tigers prefer hunting in jungles.\n");
      }
}

class PetTiger implements Tiger
{
      @Override
      public void speak()
      {
            System.out.println("Pet Tiger says softly: Halum.");
      }

      @Override
      public void preferredAction()
      {
            System.out.println("Pet Tigers play in the animal circus.\n");
      }
}

//Abstract Factory
interface AnimalFactory
{
      Dog createDog();
      Tiger createTiger();
}

//Concrete Factory-Wild Animal Factory
class WildAnimalFactory implements AnimalFactory
{
      @Override
      public Dog createDog()
      {
            return new WildDog();
      }
      @Override
      public Tiger createTiger()
      {
            return new WildTiger();
      }
}

//Concrete Factory-Pet Animal Factory
class PetAnimalFactory implements AnimalFactory
{
      @Override
      public Dog createDog()
      {
            return new PetDog();
      }
      @Override
      public Tiger createTiger()
      {
            return new PetTiger();
      }
}

//Client
class AbstractFactoryPatternExample {
      public static void main(String[] args) {
            AnimalFactory myAnimalFactory;
            Dog myDog;
            Tiger myTiger;
            System.out.println("***Abstract Factory Pattern Demo***\n");
            //Making a wild dog through WildAnimalFactory
            myAnimalFactory = new WildAnimalFactory();
            myDog = myAnimalFactory.createDog();
            myDog.speak();
            myDog.preferredAction();
            //Making a wild tiger through WildAnimalFactory
            myTiger = myAnimalFactory.createTiger();
            myTiger.speak();
            myTiger.preferredAction();
            System.out.println("******************");
            //Making a pet dog through PetAnimalFactory
            myAnimalFactory = new PetAnimalFactory();
            myDog = myAnimalFactory.createDog();
            myDog.speak();
            myDog.preferredAction();
            //Making a pet tiger through PetAnimalFactory
            myTiger = myAnimalFactory.createTiger();
            myTiger.speak();
            myTiger.preferredAction();
      }
}
```