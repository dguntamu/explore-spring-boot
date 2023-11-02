package explore.spring.boot.explore.controller;

import explore.spring.boot.explore.entity.DoctorEntity;
import explore.spring.boot.explore.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public ResponseEntity<?> saveDoctor(@RequestBody DoctorEntity doctorEntity){
        doctorService.saveDoctor(doctorEntity);
        return ResponseEntity.status(HttpStatus.OK).body(doctorEntity);
    }
}
