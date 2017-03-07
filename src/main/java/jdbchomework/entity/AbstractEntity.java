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
        this.id = id;
        this.name = name;
    }

    public AbstractEntity(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }
}
