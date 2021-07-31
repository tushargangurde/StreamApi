import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PhotographerProblem {

	public static void main(String[] args) {

		int a[] = { 1, 5, 9, 7, 6, 4, 5, 4, 2, 13, 9, 5 };
		int n = 3;

		List<Integer> list = new ArrayList<>();

		for (Integer integer : a) {
			list.add(integer);
		}

		Integer result = list.stream().sorted(Comparator.reverseOrder()).limit(n)
				.collect(Collectors.summingInt(Integer::intValue));

		System.out.println("The result is:" + result);

	}

}
