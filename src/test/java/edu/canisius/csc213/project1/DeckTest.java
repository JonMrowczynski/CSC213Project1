package edu.canisius.csc213.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the {@link Deck} {@code class}.
 */
class DeckTest {
	
	/**
	 * Tests {@link Deck} sizes that are valid deck sizes (multiples of 4 in [4, 52]).
	 *
	 * @param validSize the valid {@link Deck} size being tested.
	 */
	@ParameterizedTest @ValueSource(ints = {4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52}) void testValidDeckSizes(
			final int validSize) { assertEquals(validSize, new Deck(validSize).size()); }
	
	/**
	 * Tests {@link Deck} sizes that are not multiples of 4 and are less than 4 and greater than 52.
	 *
	 * @param invalidSize the invalid {@link Deck} size being tested.
	 */
	@ParameterizedTest @ValueSource(ints = {3, 0, -1, 55}) void testInvalidDeckSizes(final int invalidSize) {
		assertThrows(IllegalArgumentException.class, () -> new Deck(invalidSize));
	}
	
	/**
	 * Tests the {@link Deck#shuffle()} method making sure that it yields a different card order.
	 */
	@Test void testDeckShuffling() {
		final var size = 52; // Must be a valid Deck size
		
		// Create a deck without shuffling it and get the card order.
		final var deck = new Deck(size);
		final var originalOrder = getOrder(deck);
		
		// Make sure a newly created Deck contains the same ordering.
		final var otherDeck = new Deck(size);
		final var otherOriginalOrder = getOrder(otherDeck);
		assertArrayEquals(originalOrder, otherOriginalOrder);
		
		// After shuffling a Deck, though, it should contain a different order of cards.
		final var shuffledDeck = new Deck(size);
		shuffledDeck.shuffle();
		final var shuffledOrder = getOrder(shuffledDeck);
		assertNotEquals(originalOrder, shuffledOrder);
	}
	
	/**
	 * Returns the {@link Card}s in order that they appear in the deck. It should be noted that the {@link Card}s are
	 * drawn from the {@link Deck} to determine their order. Therefore, the passed in {@link Deck} will contain no
	 * {@link Card}s after this function returns.
	 *
	 * @param deck the {@link Deck} whose {@link Card} order is to be returned.
	 * @return an array of the {@link Card}s of the given {@link Deck}.
	 */
	private static Card[] getOrder(final Deck deck) {
		return IntStream.range(0, deck.size()).mapToObj(i -> deck.draw()).toArray(Card[]::new);
	}
	
	/**
	 * Tests the {@link Deck#draw()} method.
	 */
	@Test void testDrawingCards() {
		final var size = 4;
		
		// Create a Deck and ensure that it has the correct size and is of the correct
		final var deck = new Deck(size);
		assertEquals(size, deck.size());
		
		final var drawnCard = deck.draw(); // Draw a card.
		assertNotNull(drawnCard); // Ensure card was actually drawn.
		assertEquals(size - 1, deck.size()); // Deck size should decrease by one after drawing a card.
		assertEquals(Card.Rank.ACE, drawnCard.rank()); // Ensure card matches expected rank.
		
		// Draw all remaining cards
		IntStream.range(0, size - 1).forEach(i -> deck.draw());
		
		// Deck should now be empty
		assertEquals(0, deck.size());
		assertThrows(NoSuchElementException.class, deck::draw);
	}
}

