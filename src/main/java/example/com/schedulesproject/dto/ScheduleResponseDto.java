package example.com.schedulesproject.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String user;
    private String todo;
    private String password;
    private String date;
}
