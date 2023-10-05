import java.io.*;
import java.util.*;

public class Main {
    
    // 적 정보를 저장할 클래스
    static class Enemy implements Comparable<Enemy>{
        int id, r, c, distance, archer;
        
        public Enemy(int id, int r, int c) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.archer = -1;
            
        }
        
        public Enemy(int id, int r, int c, int distance, int archer) {
            this.id = id;
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.archer = archer;
        }


        @Override
        public int compareTo(Enemy o) {
            if(this.distance == o.distance) return this.c - o.c;
            return this.distance - o.distance;
        }

        
        
    }
    
    static int NR, NC, D, maxEnemy;    // 행크기, 열크기, 공격거리, 궁수의 수, 쓰러트린 최대 적
    static boolean[] isDie;
    static int[][] map;    // 적 위치
    static List<Enemy> enemyTmp = new LinkedList<>();
    static List<Enemy> enemies = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        NR = Integer.parseInt(st.nextToken());    // 행의 수
        NC = Integer.parseInt(st.nextToken());    // 열의 수
        D = Integer.parseInt(st.nextToken());    // 공격 거리 제한
        
        // 성 정보 및 적 정보 저장
        map = new int[NR][NC];
        int idx = 0;
        for(int i = 0; i < NR; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < NC; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enemyTmp.add(new Enemy(idx++, i,j));
            }
        }
        
        isDie = new boolean[idx];
        
        // 지키기 시작
        // 모든 점에 대하여 궁수를 넣어보고 확인하기
        maxEnemy = 0;
        int[] archer = new int[3];
        for(int i = 0; i < NC-2; i++) {
            for(int j = i+1; j < NC-1; j++) {
                for(int k = j + 1; k < NC; k++ ) {
                    
                	// 적과 궁수의 거리 정보 초기화
                	enemies.clear();

                	// 궁수 위치
                	archer[0] = i;
                    archer[1] = j;
                    archer[2] = k;
                    
                    // 적과 궁수와의 거리 구하기
                    for(int en = 0; en < enemyTmp.size(); en++) {
                        Enemy currEnemy = enemyTmp.get(en);
                        for(int arch = 0; arch < 3; arch++) {
                            int distance = Math.abs(currEnemy.r - NR) + Math.abs(currEnemy.c - archer[arch]);
                            enemies.add(new Enemy(currEnemy.id, currEnemy.r, currEnemy.c, distance, arch ));
                        }
                    }
                    
                    // 지키기
                    Arrays.fill(isDie, false);
                    
                    // 최대값
                    maxEnemy = Math.max(maxEnemy, defense());
                }
            }
        }
        System.out.println(maxEnemy);
    }

    private static int defense() {
    	
    	int nDie = 0; 					// 궁수가 죽인 적
    	int nAlive = isDie.length;		// 맵에 남아있는 적
    	
    	// 한 턴당 궁수가 활을 쏘았는지 여부 판단
    	boolean[] isShootArcher = new boolean[3];
    	int nShooter = 0;	// 활 쏜 궁수 수
    	
    	// 한 턴당 죽은 적 판단
    	boolean[] isDieThisTurn = new boolean[isDie.length];
    	
    	// 적이 맵에 남아있는 동안 계속
    	while(nAlive > 0) {
    		
    		// 정렬
    		// 가까운 순서 -> 왼쪽 순서로 정렬
    		Collections.sort(enemies);
    		
    		// 턴당 배열 초기화
    		Arrays.fill(isShootArcher, false);
    		Arrays.fill(isDieThisTurn, false);
    		
    		// 확인
    		nShooter = 0;
    		for(Enemy e : enemies) {
    			// 궁수가 쏜 적 있거나 이전 턴에서 죽은 적이 있거나 거리가 D 이상이면 넘기기
    			if(isShootArcher[e.archer] || isDie[e.id] || e.distance > D) continue;
    			
    			// 쏠 수 있는 적이면 진행
    			isShootArcher[e.archer] = true;
    			isDieThisTurn[e.id] = true;
    			nShooter++;
    			if(nShooter == 3) break;	// 3명의 궁수가 다 쐈으면 종료
    		}
    		
    		// 이번 턴에 죽은 사람 수 확인 + 죽은 사람 업데이트
    		for(int i = 0; i < isDie.length; i++) {
    			if(isDieThisTurn[i]) {	// 이번 턴에 죽었으면
    				nDie++;				// 궁수가 죽인 사람에 추가
    				nAlive--;			// 살아있는 적 감소
    				isDie[i] = true;	// 죽었다고 표시
    			}
    		}
    		
    		// 적 움직이기
    		for(Enemy e : enemies) {
    			// 죽은 적이면 안보고 넘기기
    			if(isDie[e.id]) continue;
    			e.r++;			// 밑으로 한칸
    			e.distance--;	// 거리 1 감소
    			if(e.r == NR) {	// 맵 끝까지 도달했으면 나가기 표시
    				nAlive--;
    				isDie[e.id] = true;
    			}
    		}
    	}
    	
    	return nDie;
    	
    }
}
