package com.niu.uidconsumer;

import com.niu.uidgenerator.service.UidGenService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UidTest {

	@Autowired(required = false)
	private UidGenService service;

	@Test
	public void getUid() {
		long uid = service.getUID();
		log.info("" + uid);
	}

}
