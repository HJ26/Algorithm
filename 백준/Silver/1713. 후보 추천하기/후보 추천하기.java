import java.io.*;
import java.util.*;

public class Main {
    
    static class Student implements Comparable<Student> {
    	int num;
	    int cnt;
	    int timeStamp;

	    public Student(int num, int cnt, int timeStamp) {
		    this.num = num;
		    this.cnt = cnt;
		    this.timeStamp = timeStamp;
	    }

	    @Override
	    public int compareTo(Student s2) {
		    int resultCnt = s2.cnt - cnt;
		    if (resultCnt == 0) {
			    return s2.timeStamp - timeStamp;
		    }
		    return resultCnt;
	    }

    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Student> photos = new ArrayList<>();
		Student[] students = new Student[101];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (students[num] != null) {
				students[num].cnt++;
			} else {
				Collections.sort(photos);

				if (photos.size() == N) {
					Student del = photos.remove(N - 1);
					students[del.num] = null;
				}
				students[num] = new Student(num, 1, i);
				photos.add(students[num]);
			}
		}

		Collections.sort(photos, (o1, o2) -> o1.num - o2.num);
		for (Student s : photos) {
			System.out.print(s.num + " ");
		}
	}
}