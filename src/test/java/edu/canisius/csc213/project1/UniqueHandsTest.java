package edu.canisius.csc213.project1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the {@link UniqueHands} {@code class}.
 */
public class UniqueHandsTest {
	
	/**
	 * Tests {@link UniqueHands#calculateTotalUniqueHands(int, int)} with a few deck and hand sizes to make sure that
	 * the total number of combinations is being calculated correctly.
	 */
	@Test public void testCalculateTotalUniqueHands() {
		assertEquals(134596, UniqueHands.calculateTotalUniqueHands(24, 6)); // Expected C(24,6)
		assertEquals(376740, UniqueHands.calculateTotalUniqueHands(28, 6)); // C(28,6)
		assertEquals(906192, UniqueHands.calculateTotalUniqueHands(32, 6)); // C(32,6)
		assertEquals(346104, UniqueHands.calculateTotalUniqueHands(24, 7)); // C(24,7)
	}
	
	/**
	 * Tests {@link UniqueHands#countAttemptsToSeeAllHands(int, int)} with different deck sizes. While it is not
	 * necessarily guaranteed to be the case (since we are dealing with probabilities), it is EXTREMELY likely that an
	 * increased deck size should result in more attempts.
	 */
	@Test public void testCountAttemptsToSeeAllHandsIncreasesWithDeckSize() {
		final var attempts24 = UniqueHands.countAttemptsToSeeAllHands(24, 6);
		final var attempts28 = UniqueHands.countAttemptsToSeeAllHands(28, 6);
		assertTrue(attempts28 > attempts24, "Increasing deck size should increase attempts.");
	}
	
	/**
	 * Tests {@link UniqueHands#countAttemptsToSeeAllHands(int, int)} with different hand sizes. While it is not
	 * necessarily guaranteed to be the case (since we are dealing with probabilities), it is EXTREMELY likely that an
	 * increased hand size should result in more attempts.
	 */
	@Test public void testCountAttemptsToSeeAllHandsIncreasesWithHandSize() {
		final var attempts6 = UniqueHands.countAttemptsToSeeAllHands(24, 6);
		final var attempts7 = UniqueHands.countAttemptsToSeeAllHands(24, 7);
		assertTrue(attempts7 > attempts6, "Increasing hand size should increase attempts.");
	}
}