import java.util.Arrays;

public class CountWord {
    public static void main(String[] args) {
        // Đề bài : Đếm số lần xuất hiện của 1 ký tự
        String str ="PreparedStatement";
        // String stringArr = {P,r,e,p....}

        //Câu 1 : Đếm ký tự "t"
        int countT = 0;
        // Chuyển chuỗi về mảng ??
        String[] stringArr = str.split(" ");
        System.out.println(Arrays.toString(stringArr));
        for (String string: stringArr){
            if(string.equals("t")){
                countT++;
            }
        }
        System.out.println("Count t : " + countT);
    }
}
