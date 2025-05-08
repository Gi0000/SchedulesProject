package example.com.schedulesproject.entity;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String user;
    private String todo;
    private String password;
    private String date;

    public void update(ScheduleRequestDto requestDto) {
        this.user = requestDto.getUser();
        this.todo = requestDto.getTodo();
    }
}
