import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String patient = br.readLine();
        String doctor = br.readLine();

        int patientACount = patient.length() - 1;
        int doctorACount = doctor.length() - 1;

        if (patientACount >= doctorACount) {
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}
