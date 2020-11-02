package homework;

public class Home01 implements Cloneable{
    public static void main(String[] args) {
       /* String str = "1243";
        char[] chars = str.toCharArray();
        double sum =0 ;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i];
            System.out.println(a-48);
            System.out.println(Math.pow(10, chars.length - i - 1) * (a-48));
            double d =Math.pow(10, chars.length - i - 1) * (a-48);
            sum = sum +d;
        }
        System.out.println(sum);
        Integer integer = new Integer(2147483647);

        Class<Integer> integerClass = int.class;
        Class<Home01> home01Class = Home01.class;*/

        Integer integer01 = 128;
        Integer integer02 = 128;
        System.out.println(Integer.valueOf(127));
        System.out.println(integer01 == integer02);

        int i1 = 128;
        int i2 =128;
        System.out.println(i1 ==i2);
    }

    public void clonePin() throws CloneNotSupportedException {
        Object clone = super.clone();
    }
}
