package bj.climbernotepad.business;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Route {
    private String name;
    private String level;
    private String region;
    private String crag;
    private LocalDate finished;
}
