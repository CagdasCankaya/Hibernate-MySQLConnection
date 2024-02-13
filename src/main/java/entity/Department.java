package entity;  //view->tool windows->Persistence->rightClick->Generate Persistence Mapping->ByDBSchema->
//select table->packageName = entity

import jakarta.persistence.*;

@Entity
@NamedQuery(name="Department.byDept",query = "SELECT name FROM Department") //When used with createNamedQuery param=name
public class Department {
    public Department(int id) {

    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public Department() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {  //press shift twice in Intellij Idea, select SQL Dialects and mark global and project values as mysql
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() { // a string will be returned instead of a hash value.
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
