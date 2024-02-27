package application;

import entities.Room;
import entities.Student;

public class Main {
    public static void main(String[] args) {
        Room[] rooms = new Room[10];

        for (int i = 0; i< rooms.length; i++) {
            rooms[i] = new Room(i);
        }

        Student student1 = new Student("Maria Green", "maria@gmail.com");
        rooms[5].setStudent(student1);

        Student student2 = new Student("Marco Antonio", "marco@gmail.com");
        rooms[1].setStudent(student2);

        Student student3 = new Student("Alex Brown", "alex@gmail.com");
        rooms[8].setStudent(student3);

        for (Room room: rooms) {
            if(room.isRoomBusy()) {
                System.out.println(room.getRoomNumber() + ":" + room.getStudentData());
            }
        }
    }
}