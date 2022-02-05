import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @Test
    void testCalculatePriceOfBookSets() {
        assertEquals(8d, Main.calculatePriceOfBookSets(List.of(1)));
        assertEquals(15.2d, Main.calculatePriceOfBookSets(List.of(2)));
        assertEquals(21.6d, Main.calculatePriceOfBookSets(List.of(3)));
        assertEquals(25.6d, Main.calculatePriceOfBookSets(List.of(4)));
        assertEquals(30d, Main.calculatePriceOfBookSets(List.of(5)));
        assertEquals(23.2d, Main.calculatePriceOfBookSets(List.of(2, 1)));
        assertEquals(29.6d, Main.calculatePriceOfBookSets(List.of(3, 1)));
        assertEquals(51.2d, Main.calculatePriceOfBookSets(List.of(4, 4)));
    }

    @Test
    void testGetTotalDiscountForBookSets() {
        assertThrows(IllegalArgumentException.class, () -> Main.getTotalDiscountForBookSets(List.of(-1)));
        assertEquals(0d, Main.getTotalDiscountForBookSets(List.of(1)));
        assertEquals(0.05d, Main.getTotalDiscountForBookSets(List.of(2)));
        assertEquals(0.1d, Main.getTotalDiscountForBookSets(List.of(3)));
        assertEquals(0.2d, Main.getTotalDiscountForBookSets(List.of(4)));
        assertEquals(0.25d, Main.getTotalDiscountForBookSets(List.of(5)));
        assertEquals(0d, Main.getTotalDiscountForBookSets(List.of(1, 1)));
        assertEquals(0.05d, Main.getTotalDiscountForBookSets(List.of(2, 1)));
        assertEquals(0.35d, Main.getTotalDiscountForBookSets(List.of(5, 3)));
        assertEquals(0.4d, Main.getTotalDiscountForBookSets(List.of(4, 4)));
    }

    @Test
    void testGetDiscount() {
        assertThrows(IllegalArgumentException.class, () -> {Main.getDiscount(-1);});
        assertEquals(0, Main.getDiscount(0));
        assertEquals(0, Main.getDiscount(1));
        assertEquals(0.05, Main.getDiscount(2));
        assertEquals(0.1, Main.getDiscount(3));
        assertEquals(0.2, Main.getDiscount(4));
        assertEquals(0.25, Main.getDiscount(5));
        assertEquals(0.25, Main.getDiscount(6));
    }

    @Test
    void testGetNumberOfBooksInCart() {
        assertEquals(1, Main.getNumberOfBooksInCart(new int[] {1}));
        assertEquals(2, Main.getNumberOfBooksInCart(new int[] {1, 1}));
        assertEquals(3, Main.getNumberOfBooksInCart(new int[] {1, 1, 1}));
        assertEquals(4, Main.getNumberOfBooksInCart(new int[] {1, 1, 1, 1}));
        assertEquals(5, Main.getNumberOfBooksInCart(new int[] {1, 1, 1, 1, 1}));
        assertEquals(2, Main.getNumberOfBooksInCart(new int[] {2}));
        assertEquals(3, Main.getNumberOfBooksInCart(new int[] {2, 1}));
        assertEquals(4, Main.getNumberOfBooksInCart(new int[] {2, 1, 1}));
        assertEquals(8, Main.getNumberOfBooksInCart(new int[] {2, 2, 2, 1, 1}));
    }

    @Test
    void testMakeSetOfUniqueVolumes() {
        assertEquals(1, Main.makeSetOfUniqueVolumes(new int[] {1}, 5));
        assertEquals(2, Main.makeSetOfUniqueVolumes(new int[] {1, 1}, 5));
        assertEquals(3, Main.makeSetOfUniqueVolumes(new int[] {1, 1, 1}, 5));
        assertEquals(4, Main.makeSetOfUniqueVolumes(new int[] {1, 1, 1, 1}, 5));
        assertEquals(5, Main.makeSetOfUniqueVolumes(new int[] {1, 1, 1, 1, 1}, 5));
        assertEquals(1, Main.makeSetOfUniqueVolumes(new int[] {2}, 5));
        assertEquals(2, Main.makeSetOfUniqueVolumes(new int[] {2, 1}, 5));
        assertEquals(3, Main.makeSetOfUniqueVolumes(new int[] {2, 1, 1}, 5));
        assertEquals(5, Main.makeSetOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 5));

        assertEquals(4, Main.makeSetOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 4));
        assertEquals(3, Main.makeSetOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 3));
        assertEquals(2, Main.makeSetOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 2));
        assertEquals(1, Main.makeSetOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 1));
    }

    @Test
    void testMakeSetsOfUniqueVolumes() {
        assertEquals(List.of(1), Main.makeSetsOfUniqueVolumes(new int[] {1}, 5));
        assertEquals(List.of(2), Main.makeSetsOfUniqueVolumes(new int[] {1, 1}, 5));
        assertEquals(List.of(3), Main.makeSetsOfUniqueVolumes(new int[] {1, 1, 1}, 5));
        assertEquals(List.of(4), Main.makeSetsOfUniqueVolumes(new int[] {1, 1, 1, 1}, 5));
        assertEquals(List.of(5), Main.makeSetsOfUniqueVolumes(new int[] {1, 1, 1, 1, 1}, 5));

        assertEquals(List.of(1, 1), Main.makeSetsOfUniqueVolumes(new int[] {2}, 5));
        assertEquals(List.of(2, 1), Main.makeSetsOfUniqueVolumes(new int[] {2, 1}, 5));
        assertEquals(List.of(3, 1), Main.makeSetsOfUniqueVolumes(new int[] {2, 1, 1}, 5));
        assertEquals(List.of(5, 3), Main.makeSetsOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 5));
        assertEquals(List.of(4, 4), Main.makeSetsOfUniqueVolumes(new int[] {2, 2, 2, 1, 1}, 4));
    }
}
