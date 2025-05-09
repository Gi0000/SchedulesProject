package example.com.schedulesproject.entity;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String user;
    private String todo;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public void update(ScheduleRequestDto requestDto) {
        if (requestDto.getUser() != null) {
            this.user = requestDto.getUser();
        }
        if (requestDto.getTodo() != null) {
            this.todo = requestDto.getTodo();
        }
        this.updateDate = LocalDateTime.now();
    }
}
