package model;

public class Classes {
    private static int INDEX = 0;
    int id;
    String name;

    public Classes(String name) {
        this.id = ++INDEX;
        this.name = name;
    }

    public Classes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // Tạo 1 phương thức trả về thông tin đối tượng bao gồm : id , name
    // Khác toString() => trả về Classes{ id= ... ,name= ... }
    public String classInfo(){
        return id+","+name;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
