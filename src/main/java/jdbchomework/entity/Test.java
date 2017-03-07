package jdbchomework.entity;

import javax.persistence.*;

@Entity

@Table(name = "test122")

public class Test extends AbstractEntity {

    @Column(name = "phone")
    private String phone;
    @Column(name = "test")
    private String test;

    public Test() {
    }

    public Test(String name, String phone, String test) {
        super(name);
        this.phone = phone;
        this.test = test;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id='"+ getId()+'\'' +
                "name='" + getName()+'\'' +
                "phone='" + phone + '\'' +
                ", test='" + test + '\'' +
                '}';
    }
}
