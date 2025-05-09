package example.com.schedulesproject.controller;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final Map<Long, Schedule> ScheduleList = new HashMap<>();

    // 생성 기능
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Long scheduleId = ScheduleList.isEmpty() ? 1 : Collections.max(ScheduleList.keySet()) + 1;

        Schedule schedule = new Schedule(
                scheduleId,
                requestDto.getUser(),
                requestDto.getTodo(),
                requestDto.getPassword(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        ScheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    //전체 조회 기능
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : ScheduleList.values()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        return responseList;
    }


    // 단일 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        Schedule schedule = ScheduleList.get(id);
        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }


    // 수정 기능
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {
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

    // 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            @RequestBody Map<String, String> passwordRequest
    ) {
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
