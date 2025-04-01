T = int(input())

for _ in range(T):
    def dfs(y, x, v):
        if array[y][x] == 1 and visit[y][x] == 0:
            visit[y][x] = v
            v += 1
            if x - 1 >= 0:
                dfs(y, x - 1, v)
            if y - 1 >= 0:
                dfs(y - 1, x, v)
            if x + 1 < m:
                dfs(y, x + 1, v)
            if y + 1 < n:
                dfs(y + 1, x, v)

    m, n, k = map(int, input().split())

    array = [[0] * m for _ in range(n)]
    visit = [[0] * m for _ in range(n)]

    for _ in range(k):
        x, y = map(int, input().split())
        array[y][x] = 1

    for i in range(n):
        for j in range(m):
            dfs(i, j, 1)

    result = 0

    for i in range(n):
        result += visit[i].count(1)

    print(result)