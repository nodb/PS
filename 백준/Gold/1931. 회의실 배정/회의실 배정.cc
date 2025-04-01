#include <iostream>
#include <algorithm>
using namespace std;

pair<int, int> s[100005];

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    for(int i=0; i<n; i++) cin >> s[i].second >> s[i].first;
    sort(s, s+n);
    int t = 0, cnt=0;
    for(int i=0; i<n; i++){
        if(t > s[i].second) continue;
        cnt++;
        t=s[i].first;
    }
    cout << cnt;
}