public class Test01 {
    public static void main(String[] args) {
        int i = Integer.parseInt("123");
        System.out.println("字符串转成为数字:" + i);

        int compare = Integer.compare(5, 3);
        System.out.println("比较结果(x<y=-1 x==y=0 x>y=1) : " +compare);

        int max = Integer.max(1, 2);
        System.out.println("最大值 : "+max);

        int min = Integer.min(2, 5);
        System.out.println("最小值 : "+min);

        int sum = Integer.sum(1, 3);
        System.out.println("求和 : "+sum);

        String s = Integer.toString(123);
        System.out.println("数字转字符 : "+ s);

        Integer integer = Integer.valueOf("123",10);
        System.out.println("valueOf: "+integer);
    }
}
