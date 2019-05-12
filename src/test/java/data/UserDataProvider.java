package data;

import consts.Constants;
import io.qameta.allure.Attachment;
import org.testng.annotations.DataProvider;


public class UserDataProvider {

    @DataProvider(name = "Credentials")
    @Attachment(value = "Sample svg attachment", type = "image/svg+xml")
    public Object[][] userCredentials() {
        return new Object[][]{{"khrystyna.bilokura.kn.2015", "18.10.1997"}};
    }

    @DataProvider(name = "InvalidCredentials")
    public Object[][] userInvalidCredentials() {
        return new Object[][]{{"khrystyna. bilokura.kn.2015", "18.10.1997"},
                {"KHRYSTYNA.BILOKURA.KN.2015", "18.10.1997"},
                {"18.10.1997", "khrystyna.bilokura.kn.2015"},
                {"khrystyna.bilokura.kn", "18.10.1997"},
                {"іьфкеьфтюузфь\"пьфшдюсщь", "фвьшт"},
                {"khrystyna.bilokura.kn.2015", "test"},
                {"test", "18.10.1997"},
                {"@#*&#&*#%", "@#*&#&*#%"},
                {"", ""},
                {"123456789", "123456789"}};
    }

    @DataProvider(name = "PagesURLs")
    public Object[][] pagesUrls() {
        return new Object[][]{
                {"http://vns.lpnu.ua/my/"},
                {"http://vns.lpnu.ua/my/index.php"},
                {"http://vns.lpnu.ua/my/?myoverviewtab=courses"},
                {"http://vns.lpnu.ua/course/index.php?categoryid=4"}
        };
    }
}

