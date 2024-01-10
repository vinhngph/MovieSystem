package dtos;

public class CustomerDTO {

    private String username, name;
    private int phone_number, age;

    public CustomerDTO(String username, String name, int phone_number, int age) {
        this.username = username;
        this.name = name;
        this.phone_number = phone_number;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
