package es.leanmind.barbershop.domain;

public class AppointmentDTO {
    public String name;
    public String date;

    public AppointmentDTO(String name, String date) {
        this.name = name;
        this.date = date;
    }
}
