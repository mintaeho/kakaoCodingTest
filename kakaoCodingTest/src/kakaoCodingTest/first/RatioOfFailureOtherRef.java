package kakaoCodingTest.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RatioOfFailureOtherRef {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N = 5;  // 전체 스테이지 개수
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};    // 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열
        
        RatioOfFailureOtherRef e = new RatioOfFailureOtherRef();
        int[] answer = e.solution(N, stages);
        System.out.println(Arrays.toString(answer));
        
    }

    public int[] solution(int N, int[] lastStages) {
        int nPlayers = lastStages.length;
        int[] nStagePlayers = new int[N + 2];
        for (int stage : lastStages) {
            nStagePlayers[stage] += 1;
        }

        int remainingPlayers = nPlayers;
        List<Stage> stages = new ArrayList<>();
        for (int id = 1 ; id <= N; id++) {
            double failure = (double) nStagePlayers[id] / remainingPlayers;
            remainingPlayers -= nStagePlayers[id];

            Stage s = new Stage(id, failure);
            stages.add(s);
        }
        Collections.sort(stages, Collections.reverseOrder());

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stages.get(i).id;
        }
        return answer;
    }

    class Stage implements Comparable<Stage> {
        public int id;
        public double failure;

        public Stage(int id_, double failure_) {
            id = id_;
            failure = failure_;
        }

        @Override
        public int compareTo(Stage o) {
            if (failure < o.failure ) {
                return -1;
            }
            if (failure > o.failure ) {
                return 1;
            }
            return 0;
        }
    }        
    
}
