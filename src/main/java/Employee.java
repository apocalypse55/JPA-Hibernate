import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "employee_name", length = 100)
    private String name;

    private int age;


    @Temporal(TemporalType.DATE)
    private Date dob;


    @Column(unique = true, length = 10, nullable = false, updatable = false)
     private String ssn ;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @OneToOne
    private AccessCard card;

    @OneToMany(mappedBy = "employee")
    private List<PayStub> payStub = new ArrayList<>();

    @ManyToMany
    private List<EmailGroup> emailGroups = new ArrayList<>();



    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }
    public void addEmailSubscription(EmailGroup group){
        this.emailGroups.add(group);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                ", type=" + type +
                ", card=" + card +
                '}';
    }
}
