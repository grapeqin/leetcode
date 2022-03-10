package github.grapeqin.algorithm.backtrack;

/**
 * 0-1背包问题
 */
public class ZeroOneBackpackProblem {

    private int maxW = Integer.MIN_VALUE;

    /**
     * 把对应的石头装到背包里面去,最大重量不超过limit
     * @param i 放入第i块石头
     * @param curW 放入第i块石头后背包的重量
     * @param items 存放石块重量的数组
     * @param limit 背包最大负载
     * @param tracks 记录背包石头装入过程
     * @return 能放入的最大石块重量
     */
    public void fillBackpack(int i,int curW,int[] items,int limit,int[] tracks){
        if(curW > limit || i == items.length){
            if(curW > maxW){
                maxW = curW;
            }
            print(items,tracks);
            return;
        }
        if(curW + items[i] < limit){
            tracks[i] = 1;
            fillBackpack(i+1,curW+items[i],items,limit,tracks);
        }
        tracks[i] = 0;
        fillBackpack(i+1,curW,items,limit,tracks);
    }

    private void print(int[] items,int[] tracks){
        for (int s = 0; s < tracks.length; s++) {
            if(tracks[s] == 1){
                System.out.print(items[s]+" | ");
            }else{
                System.out.print("  | ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ZeroOneBackpackProblem problem = new ZeroOneBackpackProblem();
        int[] items = new int[]{5,4,3,2,1};
        int[] tracks = new int[items.length];
        int limit = 10;
        problem.fillBackpack(0,0,items,limit,tracks);
        System.out.println("背包装的石块最大重量是: " + problem.maxW);
    }
}
