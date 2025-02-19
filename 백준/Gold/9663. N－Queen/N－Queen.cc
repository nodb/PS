#include <iostream>
using namespace std;

bool isused1[40];
bool isused2[40];
bool isused3[40];
int N, cnt = 0;

void func(int cur)
{
    if (cur == N)
    {
        cnt++;
        return;
    }
    for (int i = 0; i < N; i++)
    {
        if (isused1[i] || isused2[i + cur] || isused3[cur - i + N - 1])
            continue;
        isused1[i] = 1;
        isused2[i + cur] = 1;
        isused3[cur - i + N - 1] = 1;
        func(cur + 1);
        isused1[i] = 0;
        isused2[i + cur] = 0;
        isused3[cur - i + N - 1] = 0;
    }
}

int main()
{
    cin >> N;
    func(0);
    cout << cnt;
}