import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수 저장
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 정보 저장 (재생 횟수, 고유 번호)
        Map<String, List<int[]>> genreToSongs = new HashMap<>();

        int size = genres.length;

        for (int i = 0; i < size; i++) {
            // 장르별 총 재생 횟수 계산
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            // 장르별 노래 정보 추가
            genreToSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreToSongs.get(genres[i]).add(new int[]{plays[i], i});
        }

        // 장르를 재생 횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));

        List<Integer> playList = new ArrayList<>();

        // 각 장르별로 최대 2곡 추가
        for (String genre : sortedGenres) {
            List<int[]> songs = genreToSongs.get(genre);

            // 장르 내 노래를 재생 횟수 내림차순, 고유 번호 오름차순으로 정렬
            songs.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : a[1] - b[1]);

            // 최대 두 곡 추가
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                playList.add(songs.get(i)[1]); // 고유 번호 추가
            }
        }

        // 결과 반환
        return playList.stream().mapToInt(Integer::intValue).toArray();
    }
}