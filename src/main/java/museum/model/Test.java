package museum.model;

public class Test {
    String Name;
    int age;

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
}
