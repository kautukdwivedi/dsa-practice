public class LongPressedName {

    // Leetcode 925: https://leetcode.com/problems/long-pressed-name/

    public static void main(String[] args){
        String name = "alex", typed = "aaleex";
        System.out.println(isLongPressedName(name, typed));
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++; j++;
            }else if(j > 0 && typed.charAt(j-1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }

        while(j < typed.length()){
            if(typed.charAt(j) == typed.charAt(j-1))
                j++;
            else
                return false;
        }

        return i == name.length() && j == typed.length();
    }
}
