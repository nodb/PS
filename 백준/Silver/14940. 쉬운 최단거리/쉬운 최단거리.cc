#include <bits/stdc++.h>
using namespace std;

int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0 , -1, 1 };

struct Node
{
	int x, y, d;
};

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n, m;
	cin >> n >> m;

	vector<vector<int>> arr(n, vector<int>(m, 0));
	vector<vector<int>> visited(n, vector<int>(m, -1));

	int startX = -1, startY = -1;

	for (int y = 0; y < n; y++)
	{
		for (int x = 0; x < m; x++)
		{
			int num;
			cin >> num;
			arr[y][x] = num;
			if (num == 0)
			{
				visited[y][x] = 0;
			}
			else if (num == 2) {
				startX = x;
				startY = y;
			}
		}
	}

	queue<Node> q;
	q.push({ startX, startY, 0 });

	visited[startY][startX] = 0;

	while (!q.empty()) {
		auto now = q.front();
		q.pop();
		int nowX = now.x, nowY = now.y, dis = now.d;

		for (int d = 0; d < 4; d++)
		{
			int nx = nowX + dx[d];
			int ny = nowY + dy[d];
			if (nx < 0 || ny < 0 || nx >= m || ny >= n)
				continue;
			if (visited[ny][nx] != -1)
				continue;
			visited[ny][nx] = dis + 1;
			q.push({ nx, ny, dis + 1 });
		}
	}

	for (int y = 0; y < n; y++)
	{
		for (int x = 0; x < m; x++)
		{
			cout << visited[y][x] << " ";
		}
		cout << "\n";
	}

	return 0;
}