package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
			return Stream.of(arguments(2, 4, 6, false), 
					arguments(4, 5, 9, false), 
					arguments(-100, 5, -95, true), 
					arguments(9, 0, 9, true));
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1,1)).isEqualTo(2);
		assertThat(testDemo.addPositive(18,3)).isEqualTo(21);


	}
	
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForExponentiate")
	void assertThatBaseAndExponentAreCalculatedCorrectly(double a, double b, double expected) {
		assertThat(testDemo.exponentiate(a, b)).isEqualTo(expected);
	}
	
	static Stream<Arguments> argumentsForExponentiate() {
		return Stream.of(arguments(3, 0, 1),
				arguments(0, 5, 0),
				arguments(2, 5, 32),
				arguments(16, 0.5, 4),
				arguments(0.5, 2, 0.25),
				arguments(10, -2, 0.01),
				arguments(-4, 2, 16),
				arguments(-3, 3, -27)
				);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		doReturn(9).when(mockDemo).getRandomInt();
		int nineSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
		assertThat(nineSquared).isEqualTo(81);
	}
	
	
	
	

}
