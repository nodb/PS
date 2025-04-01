#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

#define X first
#define Y second

bool cmp(const pair<int, int> &a, const pair<int, int> &b) {
    return a.X > b.X;               //내림차순
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, c;
    cin >> n >> c;
    vector<pair<int, int>> arr;     //pair {cnt, num}
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        bool check = false;
        for (auto &a : arr) {
            if (a.Y == x) {
                check = true;
                a.X++;
                break;
            }
        }
        if (!check) arr.push_back({1, x});  //처음 들어온 num 넣어주기
    }
    stable_sort(arr.begin(), arr.end(), cmp);
    for (auto b : arr) while (b.X--) cout << b.Y << ' ';
}
