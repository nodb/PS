#include <iostream>
#include <queue>
using namespace std;
#define X first
#define Y second

string board[102];
int vis[102][102];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};
int N, cnt = 0;

void BFS(int i, int j, char C)
{
    if (board[i][j] == C && !vis[i][j])
    {
        queue<pair<int, int>> Q;
        vis[i][j] = 1;
        Q.push({i, j});
        while (!Q.empty())
        {
            auto cur = Q.front();
            Q.pop();
            for (int dir = 0; dir < 4; dir++)
            {
                int nx = cur.X + dx[dir];
                int ny = cur.Y + dy[dir];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (vis[nx][ny] || board[nx][ny] != C)
                    continue;
                vis[nx][ny] = 1;
                Q.push({nx, ny});
            }
        }
        cnt++;
    }
}

int main()
{
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> board[i];
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < board[i].size(); j++)
        {
            BFS(i, j, 'R');
            BFS(i, j, 'G');
            BFS(i, j, 'B');
        }
    }
    cout << cnt << ' ';
    cnt = 0;
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < board[i].size(); j++)
        {
            vis[i][j] = 0;
            if (board[i][j] == 'G')
                board[i][j] = 'R';
        }
    }
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < board[i].size(); j++)
        {
            BFS(i, j, 'R');
            BFS(i, j, 'B');
        }
    }
    cout << cnt;
}