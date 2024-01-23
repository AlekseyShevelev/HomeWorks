package task1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AvarageResponseDTO {
    private double averageSalary;
    private double averageAge;
    private int averageFIOLetters;
}
