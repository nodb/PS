import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
	static List<String> expression;
	static int len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		len = s.length();
		expression = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			expression.add(s.charAt(i) + "");
		}

		is_bracket();
		System.out.println(cal(expression));
	}

	private static void is_bracket() {
		int first = 0;
		int last = 0;
		for (int i = expression.size() - 1; i >= 0; i--) {
			if (expression.get(i).equals(")")) {
				last = i;
			}
			if (expression.get(i).equals("(")) {
				first = i;
				String temp = cal_bracket(first, last);
				for (int j = 0; j < last - first + 1; j++) {
					expression.remove(i);
				}
				expression.add(i, temp);
				is_bracket();
				break;
			}
		}
		return;
	}

	private static String cal_bracket(int first, int last) {
		List<String> list = new ArrayList<>();
		for (int i = first + 1; i < last; i++) {
			list.add(expression.get(i));
		}
		return cal(list);
	}

	private static String cal(List<String> list) {
		// 곱셈, 나눗셈
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("*") || list.get(i).equals("/")) {
				list.add(i - 1, list.get(i - 1) + list.get(i + 1) + list.get(i));
				list.remove(i);
				list.remove(i);
				list.remove(i);
				i--;
			}
		}
		// 덧셈, 뺄셈
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals("+") || list.get(i).equals("-")) {
				list.add(i - 1, list.get(i - 1) + list.get(i + 1) + list.get(i));
				list.remove(i);
				list.remove(i);
				list.remove(i);
				i--;
			}
		}
		return list.get(0);
	}

}

// A*(B+C)+(D/(E+F*G+H)+I)
// A*(B+C)+(D/(E+F*G*H)+I)