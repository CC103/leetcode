
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeGame {
    private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Queue<Point> snake;
    Queue<Point> foods;
    Set<Integer> body;
    Point head;
    int m;
    int n;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        foods = new LinkedList<>();
        body = new HashSet<>();

        m = height;
        n = width;

        for (int[] f : food) {
            foods.add(new Point(f[0], f[1]));
        }

        head = new Point(0, 0);
        snake.add(head);
        body.add(0);
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int x = head.x;
        int y = head.y;

        int nx = -1;
        int ny = -1;
        char dir = direction.charAt(0);
        switch (dir) {
            case 'U': {
                nx = x - 1;
                ny = y;
                break;
            }
            case 'D': {
                nx = x + 1;
                ny = y;
                break;
            }
            case 'L': {
                nx = x;
                ny = y - 1;
                break;
            }
            case 'R': {
                nx = x;
                ny = y + 1;
                break;
            }
        }

        if (nx < 0 || nx >= m || ny < 0 || ny >= n) return -1;

        // if no food left, just move
        if (foods.isEmpty()) {
            head = new Point(nx, ny);
            snake.add(head);

            // delete tail to move
            Point tail = snake.poll();
            body.remove(tail.x * n + tail.y);

            // touch body
            if (body.contains(head.x * n + head.y)) return -1;

            body.add(head.x * n + head.y);
            return snake.size() - 1;
        }

        Point food = foods.peek();
        int fx = food.x;
        int fy = food.y;

        // eat food
        if (nx == fx && ny == fy) {
            head = new Point(nx, ny);
            snake.add(head);
            body.add(nx * n + ny);

            // update food
            foods.poll();
        }
        // not eat food
        else {
            head = new Point(nx, ny);
            snake.add(head);

            // delete tail to move
            Point tail = snake.poll();
            body.remove(tail.x * n + tail.y);


            // touch body
            if (body.contains(head.x * n + head.y)) return -1;

            body.add(head.x * n + head.y);
        }

        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
