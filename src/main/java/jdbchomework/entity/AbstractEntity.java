package jdbchomework.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private long id;
    @Column(nullable = false)
    private String name;

    public AbstractEntity() {}

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

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
