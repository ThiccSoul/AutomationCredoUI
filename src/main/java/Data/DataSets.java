package Data;

import org.testng.annotations.DataProvider;

public class DataSets {
    @DataProvider(name = "languagesAndTheirErrorTexts")
    public static Object[][] languagesAndTheirErrorTexts() {
        return new Object[][]{
                {"ქართული", "მონაცემები არასწორია"},
                {"მეგრული", "მონაცემები არასწორია"},
                {"სვანური", "მონაცემოლ სწორ დემეგ ლი"}
        };
    }
}
