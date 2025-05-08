package example.com.schedulesproject.dto;

import example.com.schedulesproject.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String user;
    private String todo;
    private String createDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.user = schedule.getUser();
        this.todo = schedule.getTodo();
        this.createDate = String.valueOf(LocalDate.now());
    }
}
