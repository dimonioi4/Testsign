import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {


        @Test
        public void avtorization () {
            var playwright = Playwright.create();

            var browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

            var browserContext = browser.newContext();

            var page = browserContext.newPage();
            page.navigate("https://dev.lk.tr-line.ru/sign-in");

            page.fill("#input-18", "admin");
            page.fill("#input-22", "password");
            page.click("button.v-btn:nth-child(2) > span:nth-child(1)");

            String text = page.innerText(".toasted");
            assertEquals("Неудачная попытка авторизоваться", text);

            browser.close();
        }

    @Test
            public void registration () {
    var playwright = Playwright.create();

    var browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

    var browserContext = browser.newContext();

    var page = browserContext.newPage();

            page.navigate("https://dev.lk.tr-line.ru/sign-in");

            page.click("a.v-btn:nth-child(3) > span:nth-child(1)");
            page.click("button.v-btn > span:nth-child(1)");

        String text = page.innerText(".v-messages__message");
        assertEquals("Необходимо указать e-mail", text);


    browser.close();
}

@Test
    public void recoverPassword  () {
        var playwright = Playwright.create();

        var browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        var browserContext = browser.newContext();

        var page = browserContext.newPage();
        page.navigate("https://dev.lk.tr-line.ru/sign-in");

        page.click("a.v-btn:nth-child(1) > span:nth-child(1)");
        page.fill("#input-38", "ivan@yandex.ru");
        page.click(".v-btn");
        String text = page.innerText(".toasted");
        assertEquals("Пользователя с такими данными не существует.", text);

        browser.close();

    }

}