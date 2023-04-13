<<<<<<< HEAD
package com.example.finalproject.domain;public class Schedule {
=======
package com.example.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private int id;
    private int routeId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int BusId;
    private int price;
>>>>>>> origin/ohohoh
}
