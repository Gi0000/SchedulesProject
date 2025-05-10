package example.com.schedulesproject.service;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedules();

    ResponseEntity<ScheduleResponseDto> findScheduleById(Long id);

    ResponseEntity<ScheduleResponseDto> updateScheduleById(Long id, ScheduleRequestDto requestDto);

    ResponseEntity<Void> deleteScheduleById(Long id, Map<String, String> passwordRequest);
}
