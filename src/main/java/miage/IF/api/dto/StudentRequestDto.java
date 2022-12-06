package miage.IF.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequestDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
