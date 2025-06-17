package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseUserData {
    private String name;
    private String job;
    private Integer id;
    private String createdAt;
}
