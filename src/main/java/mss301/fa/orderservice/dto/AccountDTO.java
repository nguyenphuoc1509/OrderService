package mss301.fa.orderservice.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Long accountID;
    private String accountName;
    private String email;
}
