class Solution {
	public String solution(String new_id) {
		String id = new_id;
		String temp_id = "";
		for (int i = 0; i < id.length(); i++) {
			// 1단계: 모든 대문자를 대응되는 소문자로 치환
			// 대문자이면
			if (Character.isUpperCase(id.charAt(i)))
				temp_id += (char) (id.charAt(i) + 32);
			// 소문자이면
			else {
				// 2단계: 알파벳 소문자, 숫자, (-), (_), (.) 제외 제거
				if (Character.isLowerCase(id.charAt(i)) || Character.isDigit(id.charAt(i)) || id.charAt(i) == '-'
						|| id.charAt(i) == '_' || id.charAt(i) == '.')
					temp_id += id.charAt(i);
			}
		}

		id = temp_id;
		temp_id = id.charAt(0) + "";
		for (int i = 1; i < id.length(); i++) {
			// 3단계: 마침표(.) 2번 이상 연속 -> 마침표(.) 하나
			if (id.charAt(i) == '.' && id.charAt(i - 1) == '.')
				continue;
			temp_id += id.charAt(i);
		}

		id = temp_id;
		// 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
		if (id.charAt(0) == '.') // 처음 확인
			id = id.substring(1, id.length());
		if (!id.isEmpty() && id.charAt(id.length() - 1) == '.') // 끝 확인
			id = id.substring(0, id.length() - 1);

		// 5단계: 빈 문자열이라면, "a" 대입
		if (id.isEmpty())
			id = "a";

		// 6단계
		// 길이가 16자 이상, 첫 15개의 문자를 제외 모두 제거
		// 제거 후 마침표(.)가 끝에 위치한다면 제거
		if (id.length() >= 16) {
			id = id.substring(0, 15);
			if (id.charAt(14) == '.') // 끝 확인
				id = id.substring(0, 14);
		}

		// 7단계: 길이가 2자 이하, 마지막 문자를 길이가 3이 될 때까지 반복
		while (id.length() <= 2) {
			id += id.charAt(id.length() - 1);
		}

		return id;
	}
}