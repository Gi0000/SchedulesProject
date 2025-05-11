package example.com.schedulesproject.dto;

import example.com.schedulesproject.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long ScheduleId;
    private String userId;
    private String todo;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.ScheduleId = schedule.getScheduleId();
        this.userId = schedule.getUserId();
        this.todo = schedule.getTodo();
        this.createDate = schedule.getCreateDate();
        this.updateDate = schedule.getUpdateDate();
    }
}
