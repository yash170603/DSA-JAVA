func timeTaken(edges [][]int) []int {
    n := len(edges) + 1 // Number of nodes is edges + 1
    dp := make([][]int, n)
    adj := make([][]int, n)
    
    for i := range dp {
        dp[i] = make([]int, 2)
    }
  

    for _, edge := range edges {
        u, v := edge[0], edge[1]
        adj[u] = append(adj[u], v)
        adj[v] = append(adj[v], u)
    }

    ans := make([]int, n)
    dfs(0, -1, dp, adj)
    solve(0, -1, 0, dp, adj, ans)
    return ans
}

func dfs(root, prev int, dp [][]int, adj [][]int) {
    for _, j := range adj[root] {
        if j != prev {
            dfs(j, root, dp, adj)

            disToCurr := dp[j][0] + func() int {
                if j%2 == 0 {
                    return 2
                }
                return 1
            }()

            if disToCurr > dp[root][0] {
                dp[root][1] = dp[root][0]
                dp[root][0] = disToCurr
            } else if disToCurr > dp[root][1] {
                dp[root][1] = disToCurr
            }
        }
    }
}

func solve(root, prev, incoming int, dp [][]int, adj [][]int, ans []int) {
    ans[root] = max(dp[root][0], incoming)

    pa := func() int {
        if root%2 == 0 {
            return 2
        }
        return 1
    }()

    for _, j := range adj[root] {
        if j != prev {
            curr := dp[j][0] + func() int {
                if j%2 == 0 {
                    return 2
                }
                return 1
            }()

            x := 0
            if curr == dp[root][0] {
                x = dp[root][1]
            } else {
                x = dp[root][0]
            }

            nextIncoming := max(pa+x, pa+incoming)
            solve(j, root, nextIncoming, dp, adj, ans)
        }
    }
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}
