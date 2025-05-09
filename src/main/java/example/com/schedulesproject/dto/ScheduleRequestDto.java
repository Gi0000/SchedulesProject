package example.com.schedulesproject.dto;

import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
public class ScheduleRequestDto {
    private String user;
    private String todo;
    private String password;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
