package apartease.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        
        // Atur judul jendela aplikasi utama (UI)
        primaryStage.setTitle("ApartEase");

        // Tampilan pertama yang dibuka saat aplikasi dijalankan adalah Halaman Login
        showLoginScreen();

        primaryStage.setWidth(1024);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

    // Fungsi untuk memunculkan halaman login
    public void showLoginScreen() {
        LoginView loginView = new LoginView();
        
        // Alur UX: Atur apa yang terjadi jika tombol login diklik
        loginView.loginButton.setOnAction(e -> {
            // SEMENTARA: Langsung pindah ke dashboard tanpa validasi database dulu
            showDashboardScreen();
        });

        // Pasang halaman login ke dalam Scene jendela
        Scene scene = new Scene(loginView);
        primaryStage.setScene(scene);
    }

    // Fungsi untuk memunculkan halaman dashboard utama
    public void showDashboardScreen() {
        DashboardView dashboardView = new DashboardView();

        // Alur UX: Atur jika tombol Keluar/Logout di sidebar diklik
        dashboardView.logoutBtn.setOnAction(e -> {
            showLoginScreen(); // Kembali ke halaman login
        });

        // Ganti isi Scene jendela menjadi halaman dashboard
        Scene scene = new Scene(dashboardView);
        primaryStage.setScene(scene);
    }

    // Fungsi main bawaan Java untuk meluncurkan JavaFX
    public static void main(String[] args) {
        launch(args);
    }
}