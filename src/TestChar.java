public class TestChar {
    public static void main(String[] args) {
        char[] charArray = {'*','7','b',' ','A'};
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i]))
                System.out.println(charArray[i]+ " 是一个英文字母");
            if (Character.isDigit(charArray[i]))
                System.out.println(charArray[i]+ " 是一个数字");
            if (Character.isUpperCase(charArray[i]))
                System.out.println(charArray[i]+ " 是一个大写字母");
            if (Character.isLowerCase(charArray[i]))
                System.out.println(charArray[i]+ " 是一个小写字母");
            if (Character.isWhitespace(charArray[i]))
                System.out.println(charArray[i]+ " 是一个空格或换行符");

        }
    }
}
