package excercise.homework.closepair;

import java.io.BufferedInputStream;
import java.util.*;

class Vertex implements Comparable<Vertex> {
    public Integer x;
    public Integer y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Vertex v) {
        int t = this.x.compareTo(v.x);
        if (t == 0)
            t =this.y.compareTo(v.y);
        return t;
    }
}

class Result {
    public Vertex vertex1;
    public Vertex vertex2;
    public Double distance;

    public Result() {}

    public Result(Vertex a, Vertex b, double d) {
        vertex1 = a;
        vertex2 = b;
        distance = d;
    }
}

// close pair solution
public class Main {

    private static Scanner sc = new Scanner(new BufferedInputStream(System.in));

    private static List<Vertex> vertices = new ArrayList<Vertex>();

    private static void inputVertexSet() {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            vertices.add(new Vertex(x, y));
        }
        Collections.sort(vertices);
    }

    private static void outputResult() {
        for (Vertex vertex : vertices) {
            System.out.println("x = " + vertex.x + ", y = " + vertex.y);
        }
        Result result = cp(0, vertices.size() - 1);
        System.out.println("\nMin distance = " + result.distance);
        System.out.println("vertex1.x = " + result.vertex1.x + ", vertex1.y = " + result.vertex1.y);
        System.out.println("vertex2.x = " + result.vertex2.x + ", vertex2.y = " + result.vertex2.y);
        /**
         * Sample Input:
         * 5
         * 2 5
         * 1 3
         * 6 3
         * 2 8
         * 5 8
         *
         * Sample Output:
         * x = 1, y = 3
         * x = 2, y = 5
         * x = 2, y = 8
         * x = 5, y = 8
         * x = 6, y = 3
         *
         * Min distance = 2.23606797749979
         * vertex1.x = 1, vertex1.y = 3
         * vertex2.x = 2, vertex2.y = 5
         */
    }

    public static double distance(Vertex a, Vertex b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    public static Result cp(int low, int high) {
        if (high - low + 1 == 3) {
            Vertex v1 = vertices.get(low);
            Vertex v2 = vertices.get(low + 1);
            Vertex v3 = vertices.get(high);
            double a = distance(v1, v2);
            double b = distance(v1, v3);
            double c = distance(v2, v3);
            if (a < b) {
                if (a < c)
                    return new Result(v1, v2, a);
                else
                    return new Result(v2, v3, c);
            } else
                if (b > c)
                    return new Result(v2, v3, c);
                else
                    return new Result(v1, v3, b);
        }
        if (high - low + 1 == 2) {
            Vertex v1 = vertices.get(low);
            Vertex v2 = vertices.get(high);
            return new Result(v1, v2, distance(v1, v2));
        }

        int mid = (low + high) / 2;
        int x0 = vertices.get(mid).x;
        Result left = cp(low, mid);
        Result right = cp(mid + 1, high);
        Result current;
        if (left.distance < right.distance)
            current = left;
        else
            current = right;

        List<Vertex> verticesTemp = new ArrayList<Vertex>();
        for (int i = 0; i < vertices.size(); i++) {
            if (Math.abs(vertices.get(i).x - x0) <= current.distance)
                verticesTemp.add(vertices.get(i));
        }

        int k = verticesTemp.size();
        Result currentTemp = new Result();
        currentTemp.distance = current.distance * 2;
        for (int i = 0; i < k - 1; i++)
            for (int j = i + 1; j < Math.min(i + 8, k); j++) {
                Vertex v1 = verticesTemp.get(i);
                Vertex v2 = verticesTemp.get(j);
                double distance = distance(v1, v2);
                if (distance < currentTemp.distance) {
                    currentTemp.vertex1 = v1;
                    currentTemp.vertex2 = v2;
                    currentTemp.distance = distance;
                }
            }
        if (currentTemp.distance < current.distance)
            current = currentTemp;

        return current;
    }

//    public static void main(String[] args) {
//        inputVertexSet();
//        outputResult();
//    }

}
