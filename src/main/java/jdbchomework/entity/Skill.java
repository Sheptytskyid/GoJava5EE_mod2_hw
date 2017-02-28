package jdbchomework.entity;

public class Skill extends AbstractEntity {

    public Skill(long id, String name) {
        super(id, name);
    }

    public Skill(String name) {
        super(name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Skill{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
