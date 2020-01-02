package github.grapeqin.top;

/**
 * 盛最多水的容器
 *
 * @description
 * @author qinzy
 * @date 2020-01-02
 */
public class LeetCode11 {
  /**
   * 假设容器左右边界索引分别为i,j
   *
   * 容器盛水的容量等于容器边界极小值min(height[i],height[j])乘以容器的距离j-i
   * 为了获得较大的容量,将容器边界较小的一端进行挪动,直到容器左右边界相交，过程中
   * 记录下每次挪动容器边界时容器的最大容量
   * @param height
   * @return
   */
  public int maxArea(int[] height) {
  	int max = 0;
  	for(int i=0,j=height.length-1;i<j;){
  		max = Math.max(max,Math.min(height[i],height[j])*(j-i));
  		if(height[i] < height[j]){
  			i++;
		}else{
  			j--;
		}
	}
  	return max;
  }
}
