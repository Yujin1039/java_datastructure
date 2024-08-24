package ch06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q16_1 {
    //--- 신체검사 데이터 ---//
    static class PhyscData {
        String name;              // 이름
        int    height;            // 키
        double vision;            // 시력

        //--- 생성자(constructor) ---//
        PhyscData(String name, int height, double vision) {
            this.name = name;  this.height = height;  this.vision = vision;
        }

        //--- 신체검사 데이터를 문자열로 반환 --//
        public String toString() {
            return name + " " + height + " " + vision;
        }

        //--- 시력의 내림차용 comparator ---//
        static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision > d2.vision) ? -1 :
                	   (d1.vision < d2.vision) ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        PhyscData[] x = {
            new PhyscData("강민하", 162, 0.3),
            new PhyscData("김찬우", 173, 0.7),
            new PhyscData("박준서", 175, 2.0),
            new PhyscData("유서범", 171, 1.5),
            new PhyscData("이수연", 168, 0.4),
            new PhyscData("장경오", 174, 1.2),
            new PhyscData("황지안", 169, 0.8),
        };

        Arrays.sort(x,						    // 배열 x를
        		    PhyscData.VISION_ORDER      // HEIGHT_ORDER를 사용하여 정렬
        	  	    );

        System.out.println("■ 신체검사 리스트 ■");
        System.out.println(" 이름     키  시력");
        System.out.println("------------------");
        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
    }
}
