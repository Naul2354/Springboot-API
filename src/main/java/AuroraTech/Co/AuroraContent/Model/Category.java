package AuroraTech.Co.AuroraContent.Model;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name ="category")
public class Category {

    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    public Category(){

    }


    public Category(int id ,String name, int status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Content> contents;
    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    //toString

    @Override
    public String toString() {
        return "Category{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", status=" + status +
            '}';
    }
}
