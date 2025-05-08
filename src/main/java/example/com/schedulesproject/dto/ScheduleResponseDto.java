package example.com.schedulesproject.dto;

import example.com.schedulesproject.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String user;
    private String todo;
    private String password;
    private String date;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.user = schedule.getUser();
        this.todo = schedule.getTodo();
        this.password = schedule.getPassword();
        this.date = schedule.getDate();
    }
}
