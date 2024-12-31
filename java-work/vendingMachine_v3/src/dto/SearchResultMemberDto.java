package dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SearchResultMemberDto {
    private int memberNo;
    private String memberId;
    private String password;
    private String name;
    private String phone;
    private int balance;
    private LocalDateTime createdDt;

    public SearchResultMemberDto(String memberId, String name, String phone, int balance, LocalDateTime createdDt) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
        this.balance = balance;
        this.createdDt = createdDt;
    }

    public String toString() {
        String formattedCreatedDt = (createdDt != null) ? createdDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) : "N/A";
        String str = String.format("%s \t %s \t %s \t %d \t %s", memberId, name, phone, balance, formattedCreatedDt);
        return str;
    }
}