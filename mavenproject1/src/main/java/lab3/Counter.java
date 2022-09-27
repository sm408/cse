

// Language: java
// Path: mavenproject1\src\main\java\lab3\Main.java
package lab3;

class ObjectCounter {
    private static int count = 0;
    public ObjectCounter() {
        count++;
    }
    public static int getCount() {
        return count;
    }
    
    
}

public class Counter {
    public static void main(String[] args) {
        ObjectCounter obj1 = new ObjectCounter();
        ObjectCounter obj2 = new ObjectCounter();
        ObjectCounter obj3 = new ObjectCounter();
        System.out.println(ObjectCounter.getCount());
    }


    
}
