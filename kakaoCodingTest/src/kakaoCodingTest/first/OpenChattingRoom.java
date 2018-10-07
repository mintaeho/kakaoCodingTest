package kakaoCodingTest.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChattingRoom {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4;
        String records[] = new String[n];

        records = new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
                "Change uid4567 Ryan" };

        List<String> events = new ArrayList<String>();
        Map<String, String> nameData = new HashMap<String, String>();
        String message = "";
        
        for(String record : records) {
            String tmpRecord[] = record.split(" ");
            
            if (tmpRecord[0].equals("Enter") || tmpRecord[0].equals("Change") ) {
                nameData.put(tmpRecord[1], tmpRecord[2]);
            }
            
            if (tmpRecord[0].equals("Enter"))       message = " 님이 들어왔습니다."; 
            else if (tmpRecord[0].equals("Leave"))  message = " 님이 나갔습니다."; 
            
            if (tmpRecord[0].equals("Enter") || tmpRecord[0].equals("Leave") ) {
                events.add(nameData.get(tmpRecord[1])+message);
            }
        }
        
        for(int i=0 ; i<events.size() ; i++) {
            System.out.println(events.get(i));
        }
        
    }

}
