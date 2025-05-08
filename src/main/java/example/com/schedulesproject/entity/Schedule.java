package example.com.schedulesproject.entity;

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

}
