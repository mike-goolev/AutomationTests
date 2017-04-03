import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class TestDataImporter {

    static JSONObject testData;

    public static JSONObject get(String testSuite, String testMethod) {

        JSONParser parser = new JSONParser();

        try {
            JSONObject testSuiteData = (JSONObject) parser.parse(new FileReader(String.format("/Users/alex.esparza/Documents/workspace/UIAutomationII/SeasonedTests/UIAutomationII/TestData/%s.json", testSuite)));
            testData = (JSONObject) testSuiteData.get(testMethod);
        }
        catch (ParseException e) {
            e.printStackTrace();
            System.out.println("An error occurred while parsing the json file.");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return testData;
    }
}