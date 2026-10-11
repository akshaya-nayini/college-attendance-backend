
package com.anurag.backend;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = {
    "http://localhost:5173",
    "http://localhost:5174",
    "https://college-attendance-frontend-two.vercel.app"
})
public class AttendanceController {

    private final AttendanceRepository attendanceRepository;

    public AttendanceController(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // Mark or update attendance
    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {

        if (attendance.getDate() == null) {
            attendance.setDate(LocalDate.now());
        }

        List<Attendance> existingRecords =
                attendanceRepository.findAllByRollNumberAndDate(
                        attendance.getRollNumber(),
                        attendance.getDate()
                );

        if (!existingRecords.isEmpty()) {
            Attendance record = existingRecords.get(0);

            record.setStudentName(attendance.getStudentName());
            record.setStatus(attendance.getStatus());

            return attendanceRepository.save(record);
        }

        return attendanceRepository.save(attendance);
    }

    // Get all attendance records
    @GetMapping
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    // Get attendance by student roll number
    @GetMapping("/student/{rollNumber}")
    public List<Attendance> getStudentAttendance(
            @PathVariable String rollNumber) {

        return attendanceRepository.findByRollNumber(rollNumber);
    }

    // Get attendance by date
    @GetMapping("/date/{date}")
    public List<Attendance> getAttendanceByDate(
            @PathVariable LocalDate date) {

        return attendanceRepository.findByDate(date);
    }
        // Delete attendance by record ID
    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable String id) {
        attendanceRepository.deleteById(id);
    }
}
