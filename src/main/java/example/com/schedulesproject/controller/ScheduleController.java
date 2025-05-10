package example.com.schedulesproject.controller;

import example.com.schedulesproject.dto.ScheduleRequestDto;
import example.com.schedulesproject.dto.ScheduleResponseDto;
import example.com.schedulesproject.entity.Schedule;
import example.com.schedulesproject.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 생성 기능
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    //전체 조회 기능
    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules() {
        return scheduleService.findAllSchedules();
    }


    // 단일 조회 기능
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return scheduleService.findScheduleById(id);
    }


    // 수정 기능
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto requestDto ) {

        return scheduleService.updateScheduleById(id, requestDto);
    }

    // 삭제 기능
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            @RequestBody Map<String, String> passwordRequest ) {

        return scheduleService.deleteScheduleById(id, passwordRequest);
    }


}
