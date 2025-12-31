package edu.canisius.csc213.project1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the {@link Deck} {@code class}.
 */
public class DeckTest {
	
	/**
	 * Tests {@link Deck} sizes that are valid deck sizes (multiples of 4 in [4, 52]).
	 *
	 * @param validSize the valid {@link Deck} size being tested.
	 */
	@ParameterizedTest @ValueSource(ints = {4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52})
	public void testValidDeckSizes(final int validSize) {
		final var deck = new Deck(validSize);
		assertEquals(validSize, deck.size());
	}
	
	/**
	 * Tests {@link Deck} sizes that are not multiples of 4 and are less than 4 and greater than 52.
	 *
	 * @param invalidSize the invalid {@link Deck} size being tested.
	 */
	@ParameterizedTest @ValueSource(ints = {3, 0, -1, 55}) public void testInvalidDeckSizes(final int invalidSize) {
		assertThrows(IllegalArgumentException.class, () -> new Deck(invalidSize));
	}
	
	/**
	 * Tests the {@link Deck#shuffle()} method making sure that it yields a different card order.
	 */
	@Test public void testDeckShuffling() {
		final var size = 52;
		
		// Create a deck and don't shuffle it.
		var deck = new Deck(size);
		
		// Get the order before shuffling.
		final var orderBeforeShuffling = new LinkedList<Card>();
		for (int i = 0; i < size; ++i) {
			orderBeforeShuffling.add(deck.draw());
		}
		
		// Recreate the deck and shuffle.
		deck = new Deck(size);
		deck.shuffle();
		
		// Get the order after shuffling.
		final var orderAfterShuffling = new LinkedList<Card>();
		for (int i = 0; i < size; ++i) {
			orderAfterShuffling.add(deck.draw());
		}
		
		// Orders should be different.
		assertNotEquals(orderBeforeShuffling, orderAfterShuffling);
	}
	
	/**
	 * Tests the {@link Deck#draw()} method.
	 */
	@Test public void testDrawingCards() {
		final var size = 12;
		
		// Create a Deck and make sure that it has the correct size.
		final var deck = new Deck(size);
		assertEquals(size, deck.size());
		
		final var drawnCard = deck.draw(); // Draw a card.
		assertNotNull(drawnCard); // Make sure a card was actually drawn.
		assertEquals(size - 1, deck.size()); // Deck size should decrease by one after drawing a card.
		
		// Draw all remaining cards
		for (int i = 0; i < size - 1; i++) { deck.draw(); }
		
		// Deck should now be empty
		assertEquals(0, deck.size());
		assertThrows(NoSuchElementException.class, deck::draw);
	}
}

