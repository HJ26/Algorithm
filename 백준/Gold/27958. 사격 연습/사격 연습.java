import java.io.*;
import java.util.*;

public class Main {
	static int N,K, maxScore = 0;
	static int[] attack, dx = {-1, 1, 0, 0}, dy = {0,0,-1,1};
	static int[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	// 지도 크기
		K = Integer.parseInt(br.readLine());	// 사격 횟수
		
		// 지도 정보 받기
		map = new int[N][N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				map[i][j][1] = map[i][j][0];
			}
		}
		
		// 총알 공격력
		attack = new int[K];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; i++) {
			attack[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 쏘기
		shoot(0, 0, map);
		System.out.println(maxScore);
	}
	private static void shoot(int nAttack, int score, int[][][] map) {
		
		if(nAttack == K) {
			maxScore = Math.max(maxScore, score);
			return;
		}
		
		// 지도 정보 복사
		int[][][] mapTmp = new int[N][N][2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				mapTmp[i][j][0] = map[i][j][0];
				mapTmp[i][j][1] = map[i][j][1];
			}
		}
		
		// 쏘기
		loop : for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(mapTmp[i][j][0] != 0) {
					if(mapTmp[i][j][0] >= 10) {
						mapTmp[i][j][0] = 0;
						shoot(nAttack+1,score+mapTmp[i][j][1],mapTmp);
					}
					else {
						mapTmp[i][j][0] -= attack[nAttack];
						if(mapTmp[i][j][0] <= 0) {
							mapTmp[i][j][0] = 0;
							if(mapTmp[i][j][1] > 3) {
								for(int dir = 0; dir < 4; dir++) {
									int nextX = i + dx[dir];
									int nextY = j + dy[dir];
									if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || mapTmp[nextX][nextY][0] != 0) continue;
									else {
										mapTmp[nextX][nextY][0] = mapTmp[i][j][1] / 4;
										mapTmp[nextX][nextY][1] = mapTmp[nextX][nextY][0];
									}
								}								
							}
							shoot(nAttack+1, score + mapTmp[i][j][1], mapTmp);
						}else {
							shoot(nAttack+1, score, mapTmp);
						}
					}
					for(int k = 0; k < N; k++) {
						for(int l = 0; l < N; l++) {
							mapTmp[k][l][0] = map[k][l][0];
							mapTmp[k][l][1] = map[k][l][1];
						}
					}
					continue loop;
				}
			}
		}
		
		
		
	}
}
