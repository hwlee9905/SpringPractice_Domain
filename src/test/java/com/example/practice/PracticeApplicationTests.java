package com.example.practice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class) // Mockito 활성화
class PracticeApplicationTests {

	@InjectMocks
	private TransactionServiceImpl transactionService; // 실제 객체 사용


	@Test
	void convertToIdPrice() {
		transactionService = new TransactionServiceImpl();
		// Given (트랜잭션 리스트 준비)
		List<Transaction> transactions = Arrays.asList(
				new Transaction("TX123", new BigDecimal("100")),
				new Transaction("TX456", new BigDecimal("200"))
		);

		// Expected 결과
		List<String> expectedResults = Arrays.asList("TX123100", "TX456200");

		// 메소드 호출 및 결과 저장
		List<String> actualResults = transactionService.convertToIdPrice(transactions);

		// Then (검증)
		assertEquals(expectedResults, actualResults);
	}

}
