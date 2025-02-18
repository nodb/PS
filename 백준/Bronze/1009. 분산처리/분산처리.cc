#include <iostream>
using namespace std;

// a^b의 마지막 자리 숫자를 구하는 함수
int getLastDigit(int a, int b) {
    // 컴퓨터 번호는 1~10까지이므로, a의 마지막 자리 숫자만 고려하면 됨
    a %= 10;

    // 각 숫자의 주기를 저장하는 배열
    int cycle[10][4] = {
        {0},        // 0의 주기 (항상 0)
        {1},        // 1의 주기 (항상 1)
        {2, 4, 8, 6},
        {3, 9, 7, 1},
        {4, 6},
        {5},        // 5의 주기 (항상 5)
        {6},        // 6의 주기 (항상 6)
        {7, 9, 3, 1},
        {8, 4, 2, 6},
        {9, 1}
    };

    // 주기의 길이 구하기
    int cycleLength;
    if (a == 0 || a == 1 || a == 5 || a == 6) {
        cycleLength = 1;
    }
    else if (a == 4 || a == 9) {
        cycleLength = 2;
    }
    else {
        cycleLength = 4;
    }

    // b를 주기의 길이로 나눈 나머지를 구해 인덱스로 사용 (1-based index라 -1 해줌)
    int index = (b - 1) % cycleLength;
    return cycle[a][index] == 0 ? 10 : cycle[a][index];
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        int a, b;
        cin >> a >> b;
        cout << getLastDigit(a, b) << "\n";
    }

    return 0;
}