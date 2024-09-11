import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // genres = {"classic", "pop", "classic", "classic", "pop"},  plays = {500, 600, 150, 800, 2500}

        // 1. 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> genresCount = new HashMap<>();
        // 2. 장르별 노래 리스트를 저장할 맵
        Map<String, List<int[]>> genresSongsInfo = new HashMap<>();         // List로 int[] 이유는 순번 안에서도 회수로 정렬이 필요하기 때문

        // 3. 각 노래의 장르와 재생 횟수를 기반으로 맵을 채움
        for (int i = 0; i < genres.length; i++) {
            genresCount.put(genres[i], genresCount.getOrDefault(genres[i], 0) + plays[i]);  // 장르별 플레이수 합(장르가 있으면 장르 수, 없으면 0 + 해당 인덱스 번째 플레이 수 더하기)

            // genresSongsInfo 맵에 [노래의 인덱스, 재생 횟수]를 추가
            if (!genresSongsInfo.containsKey(genres[i])) {                  // i번째에 해당하는 장르가 genresIndex에 없으면
                genresSongsInfo.put(genres[i], new ArrayList<>());          // 해당 장르를 키로 하는 맵을 만들고, 벨류는 빈 리스트 생성
            }
            // 해당 장르에 대한 리스트 가져옴
            genresSongsInfo.get(genres[i]).add(new int[]{i, plays[i]});
        }

        // 4. 장르를 총 재생 횟수에 따라 내림차순으로 정렬
        List<String> genreOrder = new ArrayList<>(genresCount.keySet());
        genreOrder.sort((a, b) -> genresCount.get(b) - genresCount.get(a)); // sort(a, b) -> 자체가 정렬 그 후에 내림차순으로 정렬 하는 방식, a-b -> 오름차순, b-a -> 내림차순

        // 5. 결과 리스트를 만들고 장르별로 최대 2곡씩 선택
        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : genreOrder) {   // 내림차순으로 정렬된 장르 값 꺼내오기

            // 장르 내 노래들을 재생 횟수 내림차순, 재생 횟수가 같으면 고유번호 오름차순으로 정렬
            List<int[]> songs = genresSongsInfo.get(genre);
            //System.out.println("[정렬 전 데이터] 장르 = " + genre + ", 순서 = " + songs + ", 인덱스 = " + songs.get(0)[0] + ", 재생수 = " + songs.get(0)[1]);
            songs.sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);       // a,b 우선 정렬하고 b!=a 같지 않으면 b-a(내림차순), 같으면 a-b(오름차순), [0] = 인덱스 순서 [1] = 재생수
            //System.out.println("[정렬 후 데이터] 장르 = " + genre + ", 순서 = " + songs + ", 인덱스 = " + songs.get(0)[0] + ", 재생수 = " + songs.get(0)[1]);

            // 상위 2곡을 결과 리스트에 추가
            bestAlbum.add(songs.get(0)[0]);
            if (songs.size() > 1) {     // 이렇게하면.. pop 1개 classic 3개면..? -> 이러면 3곡만 채워지는거 아닌가 => 이게 맞음.. 장르별 최대 2곡
                bestAlbum.add(songs.get(1)[0]);
            }
        }

        //System.out.println("장르 별 재생수 = " + genresCount);
        //System.out.println("장르 별 노래 정보  = " + genresSongsInfo);

        return bestAlbum.stream().mapToInt(i -> i).toArray(); // (i -> i) = Integer -> int 타입으로 변환 / (.toArray) = int형 배열로 변환해서 반환
    }
}
