package edu.canisius.csc213.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Tests the {@link Card} {@code class }.
 *
 * @author Jon Mrowczynski
 */
class CardTest {
	
	/**
	 * Tests the {@link Card.Suit} of a {@link Card} upon creation.
	 *
	 * @param suit the current {@link Card.Suit} being tested.
	 */
	@ParameterizedTest @EnumSource(Card.Suit.class) void testSuitCardCreation(final Card.Suit suit) {
		final var card = new Card(suit, Card.Rank.ACE);
		assertEquals(suit, card.suit());
	}
	
	/**
	 * Tests the {@link Card.Rank} of a {@link Card} upon creation.
	 *
	 * @param rank the current {@link Card.Rank} being tests.
	 */
	@ParameterizedTest @EnumSource(Card.Rank.class) void testRankCardCreation(final Card.Rank rank) {
		final var card = new Card(Card.Suit.DIAMONDS, rank);
		assertEquals(rank, card.rank());
	}
	
	// It's probably a good idea to use @ParameterizedTest @EnumSource in the below testing methods, since that would
	// holistically test Card's functionality. However, these are kept the way they are for simpler testing examples.
	
	/**
	 * Tests the format of the {@link Card#toString()} method.
	 */
	@Test void testToString() {
		final var card = new Card(Card.Suit.SPADES, Card.Rank.KING);
		assertEquals("KING of SPADES", card.toString());
	}
	
	/**
	 * Tests that two cards with the same suit and rank are equal.
	 */
	@Test void testEqualityWithEqualCards() {
		final var suit = Card.Suit.CLUBS;
		final var rank = Card.Rank.TEN;
		final var card1 = new Card(suit, rank);
		final var card2 = new Card(suit, rank);
		assertEquals(card1, card2);
	}
	
	/**
	 * Tests that two cards with different suits are not equal.
	 */
	@Test void testEqualityWithDifferentSuits() {
		final var rank = Card.Rank.TEN;
		final var card1 = new Card(Card.Suit.CLUBS, rank);
		final var card2 = new Card(Card.Suit.HEARTS, rank);
		assertNotEquals(card1, card2);
	}
	
	/**
	 * Tests that two cards with different ranks are not equal.
	 */
	@Test void testEqualityWithDifferentRanks() {
		final var suit = Card.Suit.SPADES;
		final var card1 = new Card(suit, Card.Rank.KING);
		final var card2 = new Card(suit, Card.Rank.JACK);
		assertNotEquals(card1, card2);
	}
	
	/**
	 * Test that the hashCode function maps two equivalent cards to the same code.
	 */
	@Test public void testHashCode() {
		final var suit = Card.Suit.HEARTS;
		final var rank = Card.Rank.THREE;
		final var card1 = new Card(suit, rank);
		final var card2 = new Card(suit, rank);
		assertEquals(card1.hashCode(), card2.hashCode());
	}
}
