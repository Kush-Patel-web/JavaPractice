//testing git

public class Main {

    public static void main(String[] args) {
        String[] services = {"Ultrasound", "ECG", "Dialysis", "Massage"};
        int[] busyUntil = {0, 0, 0, 0};          // hour each service becomes free
        String[] requests = {"ECG", "None", "Dialysis", "ECG", "Massage", "Massage", "ECG"};

        for (int h = 0; h < requests.length; h++) {
            String request = requests[h];

            if (request.equals("None")) {
                System.out.println("Hour " + h + ": no request");
            } else {
                int index = findIndex(services, request);

                if (h >= busyUntil[index]) {
                    busyUntil[index] = h + getDuration(request);
                    System.out.println("Hour " + h + " deploy " + request + " busy until " + busyUntil[index]);
                } else {
                    System.out.println("Hour " + h + request + " busy until " + busyUntil[index]);
                }
            }
        }
    }
    public static int getDuration(String service) {
        if (service.equals("Ultrasound")) {
            return 3;
        } else if (service.equals("ECG")) {
            return 1;

        }else if (service.equals("Dialysis")) {
            return 4;
        }else if (service.equals("Massage")) {
            return 2;

        }else {
            return 0;
        }
    }


    public static int findIndex (String [] services, String name) {
        for (int i = 0; i < services.length; i++) {
            if (services[i].equals(name)) {
                return i;
            }else {
                continue;
            }
        }
        return -1;
    }
}