package com.yunki.web;

import com.yunki.entity.Bootcoin;
import com.yunki.service.BootcoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bootcoins")
public class BootcoinController {
	
	private final BootcoinService bootcoinService;

	public BootcoinController(BootcoinService bootcoinService) {
		super();
		this.bootcoinService = bootcoinService;
	}
	
	@PostMapping
	public Bootcoin save(@RequestBody Bootcoin bootcoin) {
		return this.bootcoinService.save(bootcoin);
	}
	

}
