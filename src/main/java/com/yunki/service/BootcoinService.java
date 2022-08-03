package com.yunki.service;

import com.yunki.entity.Bootcoin;
import org.springframework.stereotype.Service;

@Service
public class BootcoinService {
	
	private final BootcoinEventsService bootcoinEventsService;

	public BootcoinService(BootcoinEventsService bootcoinEventsService) {
		super();
		this.bootcoinEventsService = bootcoinEventsService;
	}

	public Bootcoin save(Bootcoin bootcoin) {
		System.out.println("Received " + bootcoin);
		this.bootcoinEventsService.publish(bootcoin);
		return bootcoin;
	}

}
