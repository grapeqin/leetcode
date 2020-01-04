package github.grapeqin.top;

/**
 * 最长公共前缀
 * @description
 * @author qinzy
 * @date 2020-01-04
 */
public class LeetCode14 {

	/**
	 * 1.水平扫描法
	 *
	 * 假设第1个字符串命名为prefix为公共前缀
	 * 依次迭代剩余的字符串
	 * 检查第i个字符串strs[i]是否以prefix为前缀,
	 * 如不是,缩短prefix为prefix.substring(0,prefix.length()-1)
	 * 直到prefix为strs[i]的前缀为止
	 * 当 "".equals(prefix) 没有必要再比较下去
	 * 可以直接返回了
	 *
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if(null==strs || strs.length < 1){
			return "";
		}
		String prefix = strs[0];
		for(int i=1;i<strs.length;i++){
			while (strs[i].indexOf(prefix) != 0){
				prefix = prefix.substring(0,prefix.length()-1);
				if("".equals(prefix)){
					return prefix;
				}
			}
		}
		return prefix;
	}

  public static void main(String[] args) {
    LeetCode14 leetCode14 = new LeetCode14();
    String[] strs = new String[] {"flower", "flow", "flight"};
    System.out.println(leetCode14.longestCommonPrefix(strs).equals("fl"));

    strs = new String[] {"dog", "racecar", "car"};
    System.out.println(leetCode14.longestCommonPrefix(strs).equals(""));

    strs = new String[] {"c", "acc", "ccc"};
    System.out.println(leetCode14.longestCommonPrefix(strs).equals(""));
  }
}
