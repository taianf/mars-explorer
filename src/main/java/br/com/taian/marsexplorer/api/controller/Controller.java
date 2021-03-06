package br.com.taian.marsexplorer.api.controller;

import br.com.taian.marsexplorer.api.model.Mission;
import br.com.taian.marsexplorer.api.model.Position;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class Controller {

    @ApiOperation(value = "Receives a mission and returns the final position of the probes")
    @PostMapping(value = "/mission", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Position>> mission(@RequestBody Mission mission) {
        List<Position> missionResult = mission.getMissionResult();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(missionResult);
    }

}
