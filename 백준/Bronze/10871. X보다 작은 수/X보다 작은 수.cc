#include <bits/stdc++.h>
using namespace std;

int main(void) {
	int n, x, a;
	cin >> n >> x;
	for (int i = 0; i < n; i++)
	{
		cin >> a;
		if (a < x)
		{
			cout << a << " ";
		}
	}
}