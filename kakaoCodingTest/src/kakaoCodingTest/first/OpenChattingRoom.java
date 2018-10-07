package kakaoCodingTest.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenChattingRoom {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4;
        String record[] = new String[n];

        record = new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };
        
        OpenChattingRoom e = new OpenChattingRoom();
        String[] answer = e.solution(record);
        System.out.println(Arrays.toString(answer));
    }
    
    
    
    public String[] solution(String[] record) {
        // TODO Auto-generated method stub
        Map<String, String> nameData = new HashMap<String, String>();
        int count = 0;
        
        for(String row : record) {
            String tmpRecord[] = row.split(" ");
            
            if (tmpRecord[0].equals("Enter")) {
                nameData.put(tmpRecord[1], tmpRecord[2]);
                count++;
            }

            if (tmpRecord[0].equals("Change")) {
                nameData.put(tmpRecord[1], tmpRecord[2]);
            }
            
            if (tmpRecord[0].equals("Leave")) {
                count++;
            }
        }
        
        String[] answer = new String[count];
        int index = 0;
        
        for(int i=0 ; i<record.length ; i++) {
            String tmpRecord[] = record[i].split(" ");

            if (tmpRecord[0].equals("Enter")) {
                answer[index] = nameData.get(tmpRecord[1]) + "님이 들어왔습니다.";
                index++;
            }
            
            if (tmpRecord[0].equals("Leave")) {
                answer[index] = nameData.get(tmpRecord[1]) + "님이 나갔습니다.";
                index++;
            }
        }
        
        return answer;
    }

}
