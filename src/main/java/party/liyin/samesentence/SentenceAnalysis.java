package party.liyin.samesentence;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceAnalysis {

    private static class Similar {
        private static int min(int ... numbers) {
            return (int)new ArrayList<>(Arrays.asList(numbers)).parallelStream().sorted().toArray()[0];
        }

        static int ld(String str1, String str2) {
            int n = str1.length();
            int m = str2.length();
            if (n == 0) return m;
            if (m == 0) return n;
            int d[][] = new int[n + 1][m + 1];
            for (int i = 0; i <= n; i++) {
                d[i][0] = i;
            }
            for (int j = 0; j <= m; j++) {
                d[0][j] = j;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    int temp;
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        temp = 0;
                    } else {
                        temp = 1;
                    }
                    d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1]+ temp);
                }
            }
            return d[n][m];
        }
        static double sim(String str1, String str2) {
            try {
                return (1-ld(str1, str2)/(double)Math.max(str1.length(), str2.length()));
            } catch (Exception e) {
                return 0.1;
            }
        }
    }

    public static double similar(String str1, String str2) {
        return Similar.sim(str1,str2);
    }

    public static List<String> keyword(String str, int size) {
        return HanLP.extractKeyword(str, size);
    }
    public static List<String> keyword(String str) {
        return keyword(str, 10);
    }

    public static List<String> summary(String str, int size) {
        return HanLP.extractSummary(str, size);
    }
    public static List<String> summary(String str) {
        return summary(str, 10);
    }

    public static List<String> phrase(String str, int size) {
        return HanLP.extractPhrase(str,size);
    }
    public static List<String> phrase(String str){
        return phrase(str,10);
    }

    public static List<Term> statement(String str) {
        return HanLP.segment(str);
    }
}
