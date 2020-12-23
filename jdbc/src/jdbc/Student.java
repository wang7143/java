package jdbc;

public class Student {
    
    private int FlowID;
    private int type;
    private String IDCard;
    private String examCard;
    private String name;
    private String location;
    private int grade;

    public int getFlowID() {
        return FlowID;
    }

    public void setFlowID(int FlowID) {
        this.FlowID = FlowID;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String iDCard) {
        IDCard = iDCard;
    }

    public String getExamCard() {
        return examCard;
    }

    public void setExamCard(String examCard) {
        this.examCard = examCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student() {
    }

    public Student(int FlowID, int type, String iDCard, String examCard, String name, String location, int grade) {
        this.FlowID = FlowID;
        this.type = type;
        IDCard = iDCard;
        this.examCard = examCard;
        this.name = name;
        this.location = location;
        this.grade = grade;
    }

    @Override
    public String toString() {
        // return "Student [IDCard=" + IDCard + ", examCard=" + examCard + ", flowID=" + FlowID + ", grade=" + grade
        //         + ", location=" + location + ", name=" + name + ", type=" + type + "]";
        return info();
    }

    private String info(){
        return "流水号：" + FlowID + "\n四级、六级:" + type + "\n身份证号:" + IDCard + "\n准考证号：" + examCard + "\n学生姓名" +name + "\n区域" + location + "\n成绩" + grade;
    }
    
}
