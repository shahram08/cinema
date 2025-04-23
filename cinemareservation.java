import java.util.*;

class Movie {
    String title;
    String time;
    boolean[][] seats = new boolean[5][5]; // 5 ردیف × 5 ستون

    public Movie(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public void showSeats() {
        System.out.println("صندلی‌ها (X = پر شده)");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

    public boolean reserveSeat(int row, int col) {
        if (!seats[row][col]) {
            seats[row][col] = true;
            return true;
        }
        return false;
    }
}

public class CinemaReservation {
    static Scanner scanner = new Scanner(System.in);
    static List<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        setupMovies();

        System.out.println("🎬 به سیستم رزرو سینما خوش اومدی");
        for (int i = 0; i < movies.size(); i++) {
            Movie m = movies.get(i);
            System.out.println((i + 1) + ". " + m.title + " - " + m.time);
        }

        System.out.print("کد فیلم مورد نظر رو وارد کن: ");
        int choice = scanner.nextInt() - 1;
        if (choice < 0 || choice >= movies.size()) {
            System.out.println("فیلم اشتباهه");
            return;
        }

        Movie selected = movies.get(choice);
        selected.showSeats();

        System.out.print("ردیف صندلی (0-4): ");
        int row = scanner.nextInt();
        System.out.print("ستون صندلی (0-4): ");
        int col = scanner.nextInt();

        if (selected.reserveSeat(row, col)) {
            System.out.println("✅ رزرو موفق بود!");
        } else {
            System.out.println("⛔ صندلی قبلاً رزرو شده!");
        }

        System.out.println("📍 وضعیت نهایی:");
        selected.showSeats();
    }

    static void setupMovies() {
        movies.add(new Movie("Interstellar", "18:00"));
        movies.add(new Movie("Inception", "20:00"));
        movies.add(new Movie("Matrix", "22:00"));
    }
}
