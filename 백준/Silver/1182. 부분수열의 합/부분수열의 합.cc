#include <iostream>
using namespace std;

int N, S, cnt = 0;
int arr[21];

void func(int cur, int tot)
{
    if (cur == N)
    {
        if (tot == S)
            cnt++;
        return;
    }
    func(cur + 1, tot);
    func(cur + 1, tot + arr[cur]);
}

int main()
{
    cin >> N >> S;
    for (int i = 0; i < N; i++)
        cin >> arr[i];
    func(0, 0);
    if (S == 0)
        cnt--;
    cout << cnt;
}