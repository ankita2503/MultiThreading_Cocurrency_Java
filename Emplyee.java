public class Emplyee {

    int id;
    String dept;
    int commitCount;

    public Emplyee(int id, String dept, int commitCount) {
        this.id = id;
        this.dept = dept;
        this.commitCount = commitCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(int commitCount) {
        this.commitCount = commitCount;
    }

    @Override
    public String toString() {
        return "Emplyee{" +
                "id=" + id +
                ", dept='" + dept + '\'' +
                ", commitCount=" + commitCount +
                '}';
    }
}
