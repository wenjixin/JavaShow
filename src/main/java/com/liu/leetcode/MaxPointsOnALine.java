package com.liu.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxPointsOnALine {
	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		};

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int maxPoints(Point[] points) {
		if (points == null || points.length < 1) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		int len = points.length;
		int maxPoints = 2;
		for (int i = 0; i < len; i++) {
			int maxi = 0;
			int coincide = 0;
			Map<Double, Integer> mapi = new HashMap<>();
			mapi.put(null, 1);
			for (int j = 0; j < len; j++) {
				if (i == j) {
					continue;
				}
				Double k = 0d;
				if (points[i].x == points[j].x && points[i].y == points[j].y) {
					coincide++;
				} else if (points[i].x == points[j].x) {// define k= NAN(null)
					mapi.put(null, mapi.get(null) + 1);
				} else {
					k = (double) (points[i].y - points[j].y) / (double) (points[i].x - points[j].x);
					Integer total = mapi.get(k);
					if (total == null) {
						mapi.put(k, 2);
					} else {
						mapi.put(k, total + 1);
					}
				}
			}
			Set<java.util.Map.Entry<Double, Integer>> entries = mapi.entrySet();
			for (java.util.Map.Entry<Double, Integer> entry : entries) {
				maxi = maxi > entry.getValue() ? maxi : entry.getValue();
			}
			maxi = maxi + coincide;
			maxPoints = maxPoints > maxi ? maxPoints : maxi;
		}
		return maxPoints;
	}

	public static void main(String[] args) {
		// a==0
		Point[] points = new Point[] { new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(2, 2) };
		// System.out.println(maxPoints(points));
		// points = new Point[] { new Point(-230, 324), new Point(-291, 141),
		// new Point(34, -2), new Point(80, 22),
		// new Point(-28, -134), new Point(40, -23), new Point(-72, -149), new
		// Point(0, -17), new Point(32, -32),
		// new Point(-207, 288), new Point(7, 32), new Point(-5, 0), new
		// Point(-161, 216), new Point(-48, -122),
		// new Point(-3, 39), new Point(-40, -113), new Point(115, -216), new
		// Point(-112, -464),
		// new Point(-72, -149), new Point(-32, -104), new Point(12, 42), new
		// Point(-22, 19), new Point(-6, -21),
		// new Point(-48, -122), new Point(161, -288), new Point(16, 11), new
		// Point(39, 23), new Point(39, 30),
		// new Point(873, -111) };
		System.out.println(maxPoints(points));
	}
}
