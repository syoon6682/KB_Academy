package com.edu.collection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("아이유", 90);
		map.put("박나래", 80);
		map.put("미미", 78);
		map.put("제임스", 85);
		
		System.out.println(map);
		
		// 1. map 안에 있는 사람들의 이름들만 받아옴
		Set<String> set = map.keySet();
		System.out.println(set);
		
		// 2. 이름에 해당하는 성적들을 출력
		for (String name : set) {
//			System.out.println(name);
			int score = map.get(name);
			System.out.println(name + ", " + score);
		}
		
		
		
		
		// 3. map에 있는 사람들의 성적들만 받아옴
		Collection<Integer> scores = map.values();
		System.out.println(scores);
		
		// 4. 사람들의 성적의 평균과 최고 성적을 구해서 출력
		int maxScore = 0;
		int totalScore = 0;
		int cnt = 0;
		for (int s : scores) {
			totalScore += s;
			if (s > maxScore) {
				maxScore = s;
			}
			cnt++;
		}
		int meanScore = totalScore / cnt;
		
		System.out.println(Collections.max(scores));
		System.out.println(Collections.min(scores));
		System.out.println("Max : " + maxScore + ", meanScore : " + meanScore);
	}	

}
