package example.com.schedulesproject.repository;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);

    List<ScheduleResponseDto> findAllSchedules();

    ResponseEntity findScheduleById(Long id);

    ResponseEntity updateScheduleById(Long id, ScheduleRequestDto requestDto);

    ResponseEntity deleteScheduleById(Long id, Map<String, String> passwordRequest);
}
