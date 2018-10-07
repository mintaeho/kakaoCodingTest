package kakaoCodingTest.first;

import java.util.Arrays;

public class RatioOfFailure {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N = 5;  // 전체 스테이지 개수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};    // 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        
        RatioOfFailure e = new RatioOfFailure();
        int[] answer = e.solution(N, stages);
        System.out.println(Arrays.toString(answer));
    }
        
    public int[] solution(int N, int[] stages) {
       
        //스테이지별 실패율
        String ratioOfFailure[][] = new String[N][2];       // 0:스테이브번호, 1:실패율
        
        // 실패율 : 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        for(int i=0 ; i<N ; i++) {
            int passUserCnt = 0, notPassUserCnt = 0;
            for(int stage : stages) {
                if (stage > i+1) passUserCnt++;
                if (stage == i+1) {
                    passUserCnt++; 
                    notPassUserCnt++;
                }
            }
            
            if ( passUserCnt == 0 ) {
                ratioOfFailure[i][0] = Integer.toString(i+1);
                ratioOfFailure[i][1] = Double.toString(0);
            }
            else {
                ratioOfFailure[i][0] = Integer.toString(i+1);
                ratioOfFailure[i][1] = Double.toString(((double)notPassUserCnt / (double)passUserCnt) * 100);   //i 스테이지의 실패율
            }
        }

        // 정렬
        String tmpStageNo = "";
        String tmpRatioOfFailure = "";
        for(int i=0 ; i< ratioOfFailure.length-1 ; i++) {
            for(int j=i+1 ; j<ratioOfFailure.length ; j++) {
                if ( Double.parseDouble(ratioOfFailure[i][1]) < Double.parseDouble(ratioOfFailure[j][1]) ||
                     ( Double.parseDouble(ratioOfFailure[i][1]) == Double.parseDouble(ratioOfFailure[j][1]) &&
                       Integer.parseInt(ratioOfFailure[i][0]) > Integer.parseInt(ratioOfFailure[j][0]) )   
                   ) {
                    tmpStageNo = ratioOfFailure[i][0];                  // 작은값을 임시변수에 저장
                    tmpRatioOfFailure = ratioOfFailure[i][1];
                    
                    ratioOfFailure[i][0] = ratioOfFailure[j][0];        // 큰값을 앞으로 옮김
                    ratioOfFailure[i][1] = ratioOfFailure[j][1];      
                    
                    ratioOfFailure[j][0] = tmpStageNo;        // 임시변수에 넣어둔 것을 뒤로 옮김
                    ratioOfFailure[j][1] = tmpRatioOfFailure;            
                }
            }
        }
        
        // 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 리턴
        int[] answer = new int[N];
        for(int i=0 ; i< ratioOfFailure.length ; i++) {
            answer[i] = Integer.parseInt(ratioOfFailure[i][0]);
        }
        
        return answer;
    }

}
