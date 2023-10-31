import java.util.*;

public class Riddle {
    public static void main(String[] args) {

        final int TOTAL_AGE_MULTIPLIED = 36;
        Map<Integer, List<int[]>> ageSums = new HashMap<>();

        for (int age1 = 1; age1 <= TOTAL_AGE_MULTIPLIED; age1++) {

            for (int age2 = 1; age2 <= (TOTAL_AGE_MULTIPLIED / age1); age2++) {

                int age3 = TOTAL_AGE_MULTIPLIED / (age1 * age2);

                if (age1 * age2 * age3 == TOTAL_AGE_MULTIPLIED) {
                    if (age1 >= age2 && age2 >= age3) {

                        int sum = age1 + age2 + age3;
                        int[] ages = {age1, age2, age3};

                        if (!ageSums.containsKey(sum)) {
                            ageSums.put(sum, new ArrayList<>());
                        }

                        ageSums.get(sum).add(ages);
                    }
                }
            }
        }

        for (List<int[]> sameSumAges : ageSums.values()) {
            if (sameSumAges.size() > 1) {
                for (int[] ages : sameSumAges) {
                    if (ages[2] >= ages[1]) {
                        System.out.println("Ages of sons are: " + Arrays.toString(ages));
                    }
                }
            }
        }
    }
}