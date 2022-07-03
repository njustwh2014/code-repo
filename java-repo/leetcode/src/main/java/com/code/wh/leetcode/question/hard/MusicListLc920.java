package com.code.wh.leetcode.question.hard;

/**
 * @description:leetcode 920 播放列表数量
 * @author: 王欢
 * @create: 2022/07/03 17:21
 **/
public class MusicListLc920 {
    /**
     * 模数
     */
    private static final int MOD = 1_000_000_007;

    /**
     * @param n 不同歌曲数量
     * @param l 列表长度
     * @param k 多少首歌曲播放后才可以重复播放
     * @return
     */
    public static int numMusicPlaylists(int n, int l, int k) {
        // 参数校验
        if (k < 0 || n <= 0 || l <= 0) {
            return 0;
        }
        /**
         * dp表达式
         * i表示当前播放列表长度
         * j表示当前播放列表内不同歌曲数量
         * dp[i][j] = dp[i-1][j-1] * max(n-j, 0) + dp[i-1][j] * max(j-k, 0);
         */
        // 初始化dp数组
        long[][] dp = new long[l + 1][n + 1];
        dp[0][0] = 1;
        // dp数组计算
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j - 1] * Math.max(n - j + 1, 0) + dp[i - 1][j] * Math.max(j - k, 0);
                dp[i][j] %= MOD;
            }
        }
        // 结果取模
        return (int) dp[l][n];
    }
}
