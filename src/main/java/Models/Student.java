package Models;

import java.math.BigDecimal;
import java.util.Objects;

public class Student {

    private String name;
    private String classStream;
    private int admissionNumber;
    private BigDecimal pocketMoney;
    private BigDecimal feeBalance;
    private int id;

    public Student(String name, String classStream, int admissionNumber, double pocketMoney, double feeBalance) {
        this.name = name;
        this.classStream = classStream;
        this.admissionNumber = admissionNumber;
        this.setPocketMoney(pocketMoney);
        this.setFeeBalance(feeBalance);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassStream(String classStream) {
        this.classStream = classStream;
    }

    public void setPocketMoney(double pocketMoney) {
        this.pocketMoney = new BigDecimal(pocketMoney);
    }

    public void setFeeBalance(double feeBalance) {
        this.feeBalance = new BigDecimal(feeBalance);
    }

    public void setAdmissionNumber(int admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getClassStream() {
        return classStream;
    }

    public BigDecimal getPocketMoney() {
        return pocketMoney;
    }

    public BigDecimal getFeeBalance() {
        return feeBalance;
    }

    public int getAdmissionNumber() {
        return admissionNumber;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return admissionNumber == student.admissionNumber
                && Objects.equals(name, student.name)
                && Objects.equals(classStream, student.classStream)
                && Objects.equals(pocketMoney, student.pocketMoney)
                && Objects.equals(feeBalance, student.feeBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classStream, admissionNumber, pocketMoney, feeBalance);
    }
}
