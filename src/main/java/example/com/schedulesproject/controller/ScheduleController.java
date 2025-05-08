package example.com.schedulesproject.controller;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final Map<Long, Schedule> ScheduleList = new HashMap<>();

    // 생성 기능
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Long scheduleId = ScheduleList.isEmpty() ? 1 : Collections.max(ScheduleList.keySet()) + 1;

        Schedule schedule = new Schedule(scheduleId, requestDto.getUser(), requestDto.getTodo(), requestDto.getPassword(), requestDto.getDate());

        ScheduleList.put(scheduleId, schedule);

        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.CREATED);
    }

    //todo 전체 조회 기능 구현
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules() {
        List<ScheduleResponseDto> responseList = new ArrayList<>();

        for (Schedule schedule : ScheduleList.values()) {
            ScheduleResponseDto responseDto = new ScheduleResponseDto(schedule);
            responseList.add(responseDto);
        }

        return responseList;
    }


    // 단일 조회
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        Schedule schedule = ScheduleList.get(id);
        if (schedule == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ScheduleResponseDto(schedule), HttpStatus.OK);
    }


    // 수정 기능
    @PatchMapping("{/id}")
    public ScheduleResponseDto updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto
    ) {
        Schedule schedule = ScheduleList.get(id);

        schedule.update(requestDto);

        return new ScheduleResponseDto(schedule);
    }

    // 삭제 기능
    @DeleteMapping("{/id}")
    public void deleteSchedule ( @PathVariable Long id ) {
        ScheduleList.remove(id);
    }


}
