package example.com.schedulesproject.controller;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private final Map<Long, Schedule> ScheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Long scheduleId = ScheduleList.isEmpty() ? 1 : Collections.max(ScheduleList.keySet()) + 1;

        Schedule schedule = new Schedule(scheduleId, requestDto.getUser(), requestDto.getTodo(), requestDto.getPassword(), requestDto.getDate());

        ScheduleList.put(scheduleId, schedule);

        return new ScheduleResponseDto(schedule);
    }

    // 단일 조회
    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleById(@PathVariable Long id) {
        Schedule schedule = ScheduleList.get(id);
        return new ScheduleResponseDto(schedule);
    }

    //todo 전체 조회 기능 구현

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



}
