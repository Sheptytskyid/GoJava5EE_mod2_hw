package jdbchomework.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(unique = true, nullable = false)
    private long id;
    @Column(nullable = false)
    private String name;

    public AbstractEntity() {
    }

    public AbstractEntity(long id, String name) {
        if (name == null || name.equals("")) {
            name = "DEFAULT";
        }
        if (id == 0) {
            throw new IllegalArgumentException("Id must be > 0");
        }
        this.id = id;
        this.name = name;
    }

    public AbstractEntity(String name) {
        if (name == null || name.equals("")) {
            name = "DEFAULT";
        }
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            name = "DEFAULT";
        }
        this.name = name;
    }

    public void setId(long id) {
        if (id == 0) {
            throw new IllegalArgumentException("Wrong id");
        }
        this.id = id;
    }
}