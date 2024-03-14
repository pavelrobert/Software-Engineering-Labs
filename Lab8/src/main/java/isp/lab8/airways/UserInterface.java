package isp.lab8.airways;
import examples.files.FileWriteUtil;
import examples.files.FilesAndFoldersUtil;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserInterface {


    public static void main(String[] args) throws IOException {
        UserInterface exercise = new UserInterface();
        FilesAndFoldersUtil.createFolder(System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder");
        System.out.println("Welcome to our Airplane Route Management System! ");
        System.out.println("Press\n0.Exit\n1.Create a new route\n2.Add waypoints for your route.\n3.Calculate the total distance for a specific route.\n4.Delete a route.\n5.Display all routes.");
        int ch;
        Scanner scanner = new Scanner(System.in);
        ch = scanner.nextInt();

        while (ch != 0) {
            switch (ch) {
                case 1:
                    exercise.createNewRoute();
                    break;
                case 2:
                    try {
                        System.out.println("Introduce the name of the route.");
                        String name = scanner.next();
                        exercise.addWaypointsForRoute(name);
                    }
                    catch (ExceptionDoesntExist e)
                    {
                        System.out.println(e);
                    }
                    catch (LessWaypoints e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Introduce the name of the route.");
                        String name;
                        name = scanner.next();
                        exercise.calculate(name);
                    }
                    catch (ExceptionDoesntExist e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Introduce the name of the route.");
                        String name;
                        name = scanner.next();
                        exercise.deleteRoute(name);
                    }
                    catch (ExceptionDoesntExist e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    try {
                        exercise.listRoutes();
                    }
                    catch (ExceptionDoesntExist e)
                    {
                        System.out.println(e);
                    }

                    break;
                default:
                    System.out.println("Incorrect choice.");
                    break;

            }
            System.out.println("Press\n0.Exit\n1.Create a new route\n2.Add waypoints for your route.\n3.Calculate the total distance for a specific route.\n4.Delete a route."+"\n5.Display all routes.");
            ch = scanner.nextInt();
        }

        System.out.println("You stopped our application.");

    }

    public void createNewRoute() {
        String name;
        System.out.println("Introduce the name of the route");
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        FilesAndFoldersUtil.createFolder(System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder/" + name);
        System.out.println("New route created successfully.");

    }


    public void addWaypointsForRoute(String name) throws IOException, LessWaypoints, ExceptionDoesntExist {


        System.out.println("Add how many Waypoints you want.Introduce the number of Waypoints.");
        int number;
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        if(number < 2)
            throw new LessWaypoints("The number of Waypoints is less than 2.");
        String folderPath = System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder/"+name;
        File folder = new File(folderPath);
        if(!folder.exists())
            throw new ExceptionDoesntExist("The route doesn't exist.");

        Route newroute = new Route();


        for (int i = 0; i < number; i++) {
            System.out.println("Introduce the Waypoints's name.");
            String num;
            num = scanner.next();
            System.out.println("Introduce the Waypoints's latitude.");
            double latitude;
            latitude = scanner.nextDouble();
            System.out.println("Introduce the Waypoints's longitude.");
            double longitude;
            longitude = scanner.nextDouble();
            System.out.println("Introduce the Waypoints's altitude.");
            int altitude;
            altitude = scanner.nextInt();
            Waypoint waypoint = new Waypoint(num, latitude, longitude, altitude);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(waypoint);
            FileWriteUtil.writeUsingFiles(json, System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder/" + name + "/" + num + ".json");
            newroute.route.add(waypoint);
        }
        System.out.println("All waypoints added successfully.");
    }


    public void calculate(String name) throws IOException, ExceptionDoesntExist {

        String folderPath = System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder/" + name;
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();
            Route newroute = new Route();

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Waypoint waypoint = objectMapper.readValue(file, Waypoint.class);
                    newroute.route.add(waypoint);
                }
            }
            newroute.calculateRoute();
        }
        else {
            throw new ExceptionDoesntExist("The name of the route doesn't exist.");
        }


    }

    public void deleteRoute(String name) throws ExceptionDoesntExist{
        String folderPath = System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder/" + name;
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles();

            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".json")) {
                    file.delete();
                }
            }
        }else {
            throw new ExceptionDoesntExist("The name you introduce doesn't exist.");
        }

        folder.delete();
    }

    public void listRoutes() throws ExceptionDoesntExist
    {
        String folderPath = System.getProperty("user.home") + "/Desktop/Andreea/30321_ciubotaru_andreea_se_lab/Lab8/isp-lab-8-2023/src/main/java/isp/lab8/airways/myFolder";
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return !name.equals(".DS_Store");
                }
            });

            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            throw new ExceptionDoesntExist("The folder is empty or doesn't exist.");
        }

    }

}
