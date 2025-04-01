#include <bits/stdc++.h>

using namespace std;

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    vector<int> v(21);
    int num;
    cin >> num;
    while (num--)
    {
        string s;
        cin >> s;
        int n;
        if (s == "add")
        {
            cin >> n;
            v[n] = 1;
        }
        else if (s == "remove")
        {
            cin >> n;
            v[n] = 0;
        }
        else if (s == "check")
        {
            cin >> n;
            if (v[n] == 0)
                cout << 0 << '\n';
            else
                cout << 1 << '\n';
        }
        else if (s == "toggle")
        {
            cin >> n;
            if (v[n] == 0)
                v[n] = 1;
            else
                v[n] = 0;
        }
        else if (s == "all")
        {
            for (int i = 1; i < 21; i++)
                v[i] = 1;
        }
        else if (s == "empty")
        {
            for (int i = 1; i < 21; i++)
                v[i] = 0;
        }
    }
}