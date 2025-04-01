#include <iostream>
#include <queue>
#include <utility>
using namespace std;
#define X first
#define Y second
int N, M;
int board[1002][1002];
int vis[1002][1002];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int cnt = 0;
int main()
{
    cin >> M >> N;
    queue<pair<int, int>> Q;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            cin >> board[i][j];
            if (board[i][j] == 1)
                Q.push({i, j});
            if (board[i][j] == 0)
                vis[i][j] = -1;
        }
    }
    while (!Q.empty())
    {
        pair<int, int> cur = Q.front();
        Q.pop();
        for (int dir = 0; dir < 4; dir++)
        {
            int nx = cur.X + dx[dir];
            int ny = cur.Y + dy[dir];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;
            if (vis[nx][ny] >= 0)
                continue;
            vis[nx][ny] = vis[cur.X][cur.Y] + 1;
            Q.push({nx, ny});
        }
    }
    int ans = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            if (vis[i][j] == -1)
            {
                cout << -1;
                return 0;
            }
            ans = max(ans, vis[i][j]);
        }
    }
    cout << ans;
}
