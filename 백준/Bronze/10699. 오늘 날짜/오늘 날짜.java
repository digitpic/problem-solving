import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        // 서울 시간대
        ZoneId seoulZoneId = ZoneId.of("Asia/Seoul");
        
        // 현재 날짜
        LocalDate currentDate = LocalDate.now(seoulZoneId);
        
        // "YYYY-MM-DD"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        
        // 날짜 출력
        System.out.println(formattedDate);
    }
}