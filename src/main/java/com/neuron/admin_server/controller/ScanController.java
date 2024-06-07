package com.neuron.admin_server.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neuron.admin_server.domain.Scan;
import com.neuron.admin_server.service.ScanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/scans")
@AllArgsConstructor
@Slf4j
public class ScanController {

  private ScanService scanService;

  @GetMapping("/{address}")
  @PreAuthorize("hasAuthority('SuperAdmin')")
  public List<Scan> getScansByAddress(@PathVariable("address") String address) {
    return scanService.getScansByAddress(address);
  }

  
}
