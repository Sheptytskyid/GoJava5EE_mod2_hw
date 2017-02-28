package jdbchomework.entity;

public class Project extends AbstractEntity {

    private int cost;

    public Project(long id, String name, int cost) {
        super(id, name);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Project{");
        sb.append("id = ").append(getId()).append(" ");
        sb.append("name = ").append(getName()).append(" ");
        sb.append("cost = ").append(cost).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
