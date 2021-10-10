import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private final static Integer INPUTS[][] = {{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-4, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
            {-6, -5, -4, -3, -2, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20, 100, 101, 102, 103, 105},
            {1, 3, 4, 6, 7, 9, 20, 21}
    };

    private final static String[] RESULTS = {"-6,-3-1,3-5,7-11,14,15,17-20",
            "-6,-3,-2,0,1,3-5,7-11,14,15,17-20",
            "-4-1,3-5,7-11,14,15,17-20",
            "-6--2,0,1,3-5,7-11,14,15,17-20,100-103,105",
            "1,3,4,6,7,9,20,21"
    };

    public static void main(String[] args) {

        for(int i = 0; i < INPUTS.length; i++){
            var result = convertToIntervals(INPUTS[i]);
            var expectedResult = RESULTS[i];
            boolean correct = result.equalsIgnoreCase(expectedResult);
            System.out.println("The result is " + (correct ? "correct. " : "incorrect. ") + "Result:" + result + " ExpectedResult:" + expectedResult);
        }
    }

    private static String convertToIntervals(Integer[] input) {
     StringBuilder res = new StringBuilder();
        int flag = 0,count=0;
        for (int i = 0; i < input.length-1 ; i++) {
            if (input[i + 1] != input[i] + 1) {

                if (flag > 1) {
                    res.append("-");
                } else{
                    res.append(",");
                }
                if(count==0){res.append(input[i]);
                res.append(",");}
                res.append(input[i + 1]);
                flag = 0;
                count++;
            } else {
                count=0;
                if(i==0){    res.append(input[i]);
                }
                if(i== input.length-2){
                    if(flag!=0){res.append("-");}else{res.append(",");}
                    res.append(input[input.length-1]);}
                flag++;

            }
        }

        if(res.charAt(0)==',' ||(res.charAt(0)=='-' && res.charAt(1)=='-')){
    res.deleteCharAt(0);
}

        return res.toString();
    }
}