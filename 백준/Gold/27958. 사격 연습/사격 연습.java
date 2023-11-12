import java.io.*;
import java.util.*;

public class Main {
	static int N,K, maxScore = 0;
	static int[] attack, dx = {-1, 1, 0, 0}, dy = {0,0,-1,1}, choice;
	static int[][][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		choice = new int[K];
		combi(0);
		System.out.println(maxScore);
	}
	private static void combi(int sidx) {
		if(sidx == K) {
			maxScore = Math.max(maxScore, shoot());
			return;
		}
		for(int i = 0; i < N; i++) {
			choice[sidx] = i;
			combi(sidx+1);
		}
		
	}
	private static int shoot() {
		
		int mapTmp[][][] = new int[N][N][2];
		int score = 0;
		for(int k = 0; k < N; k++) {
			for(int l = 0; l < N; l++) {
				mapTmp[k][l][0] = map[k][l][0];
				mapTmp[k][l][1] = map[k][l][1];
			}
		}
		
		loop: for(int i = 0; i < K; i++) {
			int row = choice[i];
			for(int j = 0; j < N; j++) {
				if(mapTmp[row][j][0] != 0) {
					if(mapTmp[row][j][0] >= 10) {
						score += mapTmp[row][j][1];
						mapTmp[row][j][0] = 0;
						mapTmp[row][j][1] = 0;
					}
					else{
						mapTmp[row][j][0] -= attack[i];
						if(mapTmp[row][j][0] <= 0) {
							mapTmp[row][j][0] = 0;
							score += mapTmp[row][j][1];
							if(mapTmp[row][j][1] > 3) {
								
								for(int dir = 0; dir < 4; dir++) {
									int nx = row + dx[dir];
									int ny = j + dy[dir];
									if(nx < 0 || nx >= N || ny < 0 || ny >= N || mapTmp[nx][ny][0] != 0) continue;
									mapTmp[nx][ny][1] = mapTmp[row][j][1] / 4;
									mapTmp[nx][ny][0] = mapTmp[nx][ny][1];
								}
							}
						}
					}
					break;
				}
			}
		}
		return score;
		
	}
}
