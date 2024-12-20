package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TelBookDTO {
    private long id;
    private String name;
    private  int age;
    private String address;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        String createdDate = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
        String updatedDate = "";
        if (updatedAt != null){
            updatedDate = updatedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
        }
        String str = String.format("%d \t %s \t %d \t %s \t %s \t %s \t %s", id, name, age, address, phone, createdDate, updatedDate);
                return str;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
