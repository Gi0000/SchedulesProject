package example.com.schedulesproject.repository;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {
    private final Map<Long, Schedule> ScheduleList = new HashMap<>();

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        Long scheduleId = ScheduleList.isEmpty() ? 1 : Collections.max(ScheduleList.keySet()) + 1;
        schedule.setScheduleId(scheduleId);

        ScheduleList.put(scheduleId, schedule);

        return schedule;

    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : ScheduleList.values()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        return responseList;
    }

    @Override
    public ResponseEntity findScheduleById(Long id) {

        Schedule schedule = ScheduleList.get(id);
        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateScheduleById(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = ScheduleList.get(id);

        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (requestDto.getPassword() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!schedule.getPassword().equals(requestDto.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);  // 401: 비밀번호 불일치
        }

        schedule.update(requestDto);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteScheduleById(Long id, Map<String, String> passwordRequest) {
        Schedule schedule = ScheduleList.get(id);

        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String password = passwordRequest.get("password");
        if (password == null || !schedule.getPassword().equals(password)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        ScheduleList.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
