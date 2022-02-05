import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Every number in the array represents the quantity for each volume (2 Vol1, 2 Vol2, ..., 1 Vol5)
        int[] cart = new int[] {2, 2, 2, 1, 1};
        //Make sets of unique volumes with a max set size of 5 to get the maximum discount
        List<Integer> bookSetsUncapped = makeSetsOfUniqueVolumes(cart.clone(), 5);
        //Make sets of unique volumes with a max set size of 4 to try to get a better discount
        //1 set of five + 1 set of 3 -> 35% discount
        //2 sets of four -> 40% discount
        List<Integer> bookSetsCappedAt4 = makeSetsOfUniqueVolumes(cart.clone(), 4);

        double totalDiscountUncapped = getTotalDiscountForBookSets(bookSetsUncapped);
        double totalDiscountCapped = getTotalDiscountForBookSets(bookSetsCappedAt4);

        double priceWithBestDiscount = 0;
        if(totalDiscountCapped > totalDiscountUncapped) {
            priceWithBestDiscount = calculatePriceOfBookSets(bookSetsCappedAt4);
        }
        else if(totalDiscountCapped <= totalDiscountUncapped) {
            priceWithBestDiscount = calculatePriceOfBookSets(bookSetsUncapped);
        }
        System.out.println("€" + priceWithBestDiscount);
    }

    public static double calculatePriceOfBookSets(List<Integer> bookSets) {
        double price = 0;
        for(int nbBooksInSet : bookSets) {
            price += nbBooksInSet * 8 * (1-getDiscount(nbBooksInSet));
        }
        return price;
    }

    public static double getTotalDiscountForBookSets(List<Integer> bookSets) {
        double totalDiscount = 0;
        for(int setSize : bookSets) {
            totalDiscount += getDiscount(setSize);
        }
        return totalDiscount;
    }

    public static double getDiscount(int numberOfUniqueVolumes) {
        if (numberOfUniqueVolumes < 0) throw new IllegalArgumentException("Number of volumes cannot be negative.");

        return switch (numberOfUniqueVolumes) {
            case 0, 1 -> 0;
            case 2 -> 0.05;
            case 3 -> 0.1;
            case 4 -> 0.2;
            default -> 0.25;
        };
    }

    public static int getNumberOfBooksInCart(int[] cart) {
        int nbOfBooks = 0;
        for (int nbOfSameVolumes : cart) {
            nbOfBooks += nbOfSameVolumes;
        }
        return nbOfBooks;
    }

    public static int makeSetOfUniqueVolumes(int[] cart, int maxSetSize) {
        int setSize = 0;
        for(int i = 0; i < cart.length; i++) {
            if(setSize == maxSetSize) break;
            if(cart[i] != 0) {
                cart[i]--;
                setSize++;
            }
        }
        return setSize;
    }

    public static List<Integer> makeSetsOfUniqueVolumes(int[] cart, int maxSetSize) {
        List<Integer> sets = new ArrayList<>();
        while(getNumberOfBooksInCart(cart) > 0) {
            sets.add(makeSetOfUniqueVolumes(cart, maxSetSize));
        }
        return sets;
    }

}