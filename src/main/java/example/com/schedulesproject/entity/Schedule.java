package example.com.schedulesproject.entity;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long scheduleId;
    private String userId;
    private String todo;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Schedule(String userId, String todo, String password, LocalDateTime createDate, LocalDateTime updateDate) {
        this.userId = userId;
        this.todo = todo;
        this.password = password;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void update(ScheduleRequestDto requestDto) {
        if (requestDto.getUserId() != null) {
            this.userId = requestDto.getUserId();
        }
        if (requestDto.getTodo() != null) {
            this.todo = requestDto.getTodo();
        }
        this.updateDate = LocalDateTime.now();
    }
}
