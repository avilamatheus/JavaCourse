package entities;

public class Room {
    private final int roomNumber;
    private Student student;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isRoomBusy() {
        return student != null;
    }

    public String getStudentData() {
        return student.toString();
    }
}
