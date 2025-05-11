package example.com.schedulesproject.service;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import example.com.schedulesproject.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(
                requestDto.getUserId(),
                requestDto.getTodo(),
                requestDto.getPassword(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {

        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules();

        return allSchedules;
    }

    @Override
    public ResponseEntity<ScheduleResponseDto> findScheduleById(Long id) {
        ResponseEntity scheduleById = scheduleRepository.findScheduleById(id);

        return scheduleById;
    }

    @Override
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(Long id, ScheduleRequestDto requestDto) {
        ResponseEntity sheduleById = scheduleRepository.updateScheduleById(id, requestDto);

        return sheduleById;
    }

    @Override
    public ResponseEntity<Void> deleteScheduleById(Long id, Map<String, String> passwordRequest) {
        ResponseEntity scheduleById = scheduleRepository.deleteScheduleById(id, passwordRequest);

        return scheduleById;
    }


}
