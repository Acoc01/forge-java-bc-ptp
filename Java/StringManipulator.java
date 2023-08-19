public class StringManipulator{
    public static String trimString(String a , String b){

        return a.trim()+b.trim();
    }
    public static int getIndexOrNull(String a , char c){
        return a.indexOf(c);
    }
    // Override of getIndexOrNull
    public static int getIndexOrNull(String a, String b){
        return a.indexOf(b);
    }
    public static String concatSubstring(String a, int n, int m, String b){
        return a.substring(n,m)+b;
    }
}